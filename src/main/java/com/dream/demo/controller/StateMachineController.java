package com.dream.demo.controller;

import com.dream.demo.handle.Result;
import com.dream.demo.handle.ResultUtil;
import com.dream.demo.machine.Events;
import com.dream.demo.machine.States;
import com.dream.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("state")
public class StateMachineController {


    @Autowired
    private StateMachinePersister<States, Events, String> persister;

    @Autowired
    private StateMachine<States, Events> stateMachine;


    @RequestMapping("/new")
    @ResponseBody
    public Result newLeave() {
        stateMachine.start();
        System.out.println("新建请假申请成功");
        return ResultUtil.success(UUIDUtil.generatId());
    }

    @RequestMapping("/apply")
    @ResponseBody
    public Result apply(String id) {
        return sendEvent(Events.SUBMIT, id);
    }

    @RequestMapping("/tlApproveYes")
    @ResponseBody
    public Result tlApproveYes(String id) {
        return sendEvent(Events.TL_AGREE, id);
    }

    @RequestMapping("/tlApproveNo")
    @ResponseBody
    public Result tlApproveNo(String id) {
        return sendEvent(Events.TL_REJECT, id);
    }

    @RequestMapping("/dmApproveYes")
    @ResponseBody
    public Result dmApproveYes(String id) {
        return sendEvent(Events.DM_AGREE, id);
    }


    @RequestMapping("/dmApproveNo")
    @ResponseBody
    public Result dmApproveNo(String id) {
        return sendEvent(Events.DM_REJECT, id);
    }

    @RequestMapping("/hrRecord")
    @ResponseBody
    public Result hrRecord(String id) {
        return sendEvent(Events.HR_RECORD, id);
    }

    @RequestMapping("/getState")
    @ResponseBody
    public Result getState(String id) {
        try {
            persister.restore(stateMachine, id);
            States state = stateMachine.getState().getId();
            return ResultUtil.success(state);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1002,e.getMessage());
        } finally {
            stateMachine.stop();
        }
    }

    private Result sendEvent(Events event, String leaveId) {
        try {
            // 根据业务 id 获取状态
            persister.restore(stateMachine, leaveId);
            boolean success = stateMachine.sendEvent(event);
            // 持久化状态机
            if (success) {
                persister.persist(stateMachine, leaveId);
            }
            String message = success ? "执行成功" : "执行失败";
            message = message + "，当前状态为：" + stateMachine.getState().getId();
            System.out.println(message);
            return ResultUtil.success(message);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1001,e.getMessage());
        } finally {
            stateMachine.stop();
        }
    }

}
