package com.dream.demo.controller;

import com.dream.demo.constant.ReturnCode;
import com.dream.demo.constant.SysCode;
import com.dream.demo.entity.*;
import com.dream.demo.service.*;
import com.dream.demo.vo.*;
import com.dream.demo.handle.CustomException;
import com.dream.demo.utils.UUIDUtil;
import com.dream.demo.utils.UserMgr;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典表(Dictionary)表控制层
 *
 * @author makejava
 * @since 2019-10-01 06:06:45
 */
@RestController
@RequestMapping("app")
public class AppController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    @Resource
    private UserExamService userExamService;

    @Resource
    private QuestionService questionService;

    @Resource
    private ExamQuestionService examQuestionService;

    @Resource
    private UserQuestionService userQuestionService;

    @Resource
    private QuestionOptionService questionOptionService;

    @Resource
    private UserQuestionLogService userQuestionLogService;

    @Resource
    private UserService userService;

    /**
     * 按照分类搜索试卷
     *
     * @param type
     * @return
     */
    @GetMapping("queryExamsByType")
    public List<ExamVo> queryExamsByType(String type) {
        ExamVo vo = new ExamVo();
        vo.setUserId(UserMgr.getUserId());
        vo.setType(type);
        return examService.queryExamListByType(vo);
    }

    /**
     * 按照试卷id搜索题目
     *
     * @param id
     * @return
     */
    @GetMapping("queryQuestionsByExamId")
    public List<QuestionVo> queryQuestionsByExamId(String id) {
        //查询符合的题目列表
        List<QuestionVo> questionList = questionService.queryByExamId(id);
        for (QuestionVo vo :
                questionList) {
            QuestionOption questionOption = new QuestionOption();
            questionOption.setQuestionId(vo.getId());
            List<QuestionOption> list = questionOptionService.queryAll(questionOption);
            vo.setOptions(list);
        }
        return questionList;
    }


    /**
     * 收藏题目
     *
     * @param fav 1 like, 0 unlike
     * @return
     */
    @GetMapping("like")
    public void like(String id, String fav) {
        //update
        UserQuestion updateUserQuestion = new UserQuestion();
        updateUserQuestion.setId(id);
        updateUserQuestion.setIsFav(fav);
        userQuestionService.update(updateUserQuestion);
    }


    /**
     * 答题
     *
     * @param questionId
     * @param userExamId
     * @param answer
     */
    private void answer(String questionId, String userExamId, String answer) {
        //update
        UserQuestion updateUserQuestion = userQuestionService.queryById(userExamId);
        updateUserQuestion.setAnswer(answer);
        Question question = questionService.queryById(questionId);
        if (StringUtils.isEmpty(answer)) {
            updateUserQuestion.setState(SysCode.Question.NO_ANSWER);
        } else {
            if (question.getAnswerRight().endsWith(answer)) {
                updateUserQuestion.setState(SysCode.Question.RIGHT);
            } else {
                updateUserQuestion.setState(SysCode.Question.WRONG);
            }
        }

        userQuestionService.update(updateUserQuestion);

//        UserQuestionLog insertUserQuestionLog = new UserQuestionLog();
//        BeanUtils.copyProperties(updateUserQuestion,insertUserQuestionLog);
//        insertUserQuestionLog.setId(UUIDUtil.generatId());
//        userQuestionLogService.insert(insertUserQuestionLog);
    }

    /**
     * 交卷
     *
     * @param userQuestionVo
     * @return
     */
    @PostMapping(value = "answerBatch", consumes = "application/json")
    public void answerBatch(@RequestBody UserQuestionVo userQuestionVo) {
        System.out.println(userQuestionVo);
        for (UserQuestionVo vo :
                userQuestionVo.getAnswerList()) {
            answer(vo.getId(), vo.getUserQuestionId(), vo.getAnswer());
        }
    }

    /**
     * 删除题目
     *
     * @param id
     * @return
     */
    @GetMapping("deleteByExamQuestionId")
    public void deleteByExamQuestionId(String id) {
        userQuestionService.deleteByExamQuestionId(id);
    }

    /**
     * 生成答题卡
     *
     * @param id
     * @return
     */
    @GetMapping("generateUserQuestionByExamId")
    @Transactional
    public void generateUserQuestionByExamId(String id) {
        UserExam queryUserExam = new UserExam();
        queryUserExam.setExamId(id);
        queryUserExam.setUserId(UserMgr.getUserId());
        List<UserExam> list = userExamService.queryAll(queryUserExam);

        if (list.size() > 0) {
            // already generate
            throw new CustomException(ReturnCode.ALREADY_GENERATE_RECORD);
        } else {
            List<UserQuestion> userQuestionList = new ArrayList<>();
            ExamQuestion queryExamQuestion = new ExamQuestion();
            queryExamQuestion.setExamId(id);
            List<ExamQuestion> examQuestionList = examQuestionService.queryAll(queryExamQuestion);
            for (ExamQuestion eq :
                    examQuestionList) {
                UserQuestion userQuestion = new UserQuestion();
                userQuestion.setExamId(id);
                userQuestion.setUserId(UserMgr.getUserId());
                userQuestion.setExamQuestionId(eq.getId());
                userQuestion.setQuestionId(eq.getQuestionId());
//            使用用户id+问题id， 作为主键，防止重复新增
                userQuestion.setId(UserMgr.getUserId() + "-" + eq.getId());
                userQuestion.setIsFav(SysCode.Question.UNLIKE);
                userQuestionList.add(userQuestion);
            }
            userQuestionService.insertBatch(userQuestionList);
            queryUserExam.setId(UserMgr.getUserId() + "-" + id);
            queryUserExam.setState(SysCode.Exam.NOT_START);
            userExamService.insert(queryUserExam);
        }
    }


    @PostMapping("updateExamState")
    public UserExam updateExamState(@RequestBody UserExam userExam) {
        UserExam update = userExamService.queryById(UserMgr.getUserId() + "-" + userExam.getId());
        update.setState(userExam.getState());
        userExamService.update(update);
        return update;
    }

    @PostMapping("cleanAnswer")
    public void cleanAnswer(@RequestBody UserExam userExam) {
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setExamId(userExam.getExamId());
        userQuestion.setUserId(UserMgr.getUserId());
        userQuestionService.cleanAnswer(userQuestion);
    }

    /**
     * 做题统计
     *
     * @param questionId
     * @return
     */
    @GetMapping("getQuestionSummary")
    public QuestionSummaryVo getQuestionSummary(String questionId) {
        return userQuestionLogService.getQuestionSummary(questionId);
    }

    @PostMapping("login")
    public UserVo login(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            throw new CustomException(ReturnCode.NO_USERNAME);
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new CustomException(ReturnCode.NO_PASSWORD);
        }
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//        try {
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            throw new CustomException(ReturnCode.WRONG_USERNAME_PASSWORD);
//        }

        List<User> list = userService.queryAll(user);
        if (list.size() > 0) {
            User user1 = list.get(0);
            String token = UUIDUtil.generatId();
            user1.setToken(token);
            userService.update(user1);
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user1, userVo);
            return userVo;
        }
        throw new CustomException(ReturnCode.WRONG_USERNAME_PASSWORD);
    }

    @GetMapping("toLogin")
    public void toLogin() {
        throw new CustomException(ReturnCode.INVALID_TOKEN);
    }


    @PostMapping("checkToken")
    public void checkToken(@RequestBody User user) {
        User user1 = userService.queryByToken(user.getToken());
        if (user1 == null) {
            throw new CustomException(ReturnCode.INVALID_TOKEN);
        }
    }

    @PostMapping("logout")
    public void logout(@RequestBody User user) {

        List<User> list = userService.queryAll(user);
        if (list.size() > 0) {
            User user1 = list.get(0);
            user1.setToken("");
            userService.update(user1);
        } else {
            throw new CustomException(ReturnCode.ALREADY_LOGOUT);
        }
    }

    @PostMapping("register")
    public UserVo register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            throw new CustomException(ReturnCode.NO_USERNAME);
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new CustomException(ReturnCode.NO_PASSWORD);
        }
        User queryByName = new User();
        queryByName.setUserName(user.getUserName());
        List<User> list = userService.queryAll(queryByName);
        if (list.size() > 0) {
            throw new CustomException(ReturnCode.ALREADY_EXIST_USERNAME);
        } else {
            user.setId(UUIDUtil.generatId());
            user.setToken(UUIDUtil.generatId());
            userService.insert(user);
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            return userVo;
        }
    }

}