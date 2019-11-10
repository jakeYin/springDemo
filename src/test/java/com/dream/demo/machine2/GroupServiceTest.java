package com.dream.demo.machine2;

import com.dream.demo.controller.StateMachineControllerTest;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupServiceTest {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(GroupServiceTest.class);

    @Autowired
    GroupService groupService;

    @Autowired
     GroupRepository groupRepository;

    int groupId = 12399;
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void test001create() {
        Group group = new Group(groupId,groupId+"");
        group.setAdvance(true);
        groupService.create(group);
        logger.info(group+"");

    }
    @Test
    public void test002handleAction() {
        groupService.handleAction(groupId,"APPROVE1");
        Group group = groupRepository.findGroupById(groupId);
        logger.info(group+"");
    }

    @Test
    public void test003handleAction() {
        groupService.handleAction(groupId,"APPROVE2");
        Group group = groupRepository.findGroupById(groupId);
        logger.info(group+"");
    }

    @Test
    public void test004handleAction() {
        groupService.handleAction(groupId,"APPROVE3");
        Group group = groupRepository.findGroupById(groupId);
        logger.info(group+"");
    }

    @Test
    public void test005handleAction() {
        groupService.handleAction(groupId,"APPROVE4");
        Group group = groupRepository.findGroupById(groupId);
        logger.info(group+"");
    }




    @After
    public void tearDown() throws Exception {
    }
}