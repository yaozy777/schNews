package com.heima.schedule.service.impl;

import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.ScheduleApplication;
import com.heima.schedule.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Test
    void addTask() {
        for(int i=0;i<5;i++){
            Task task = new Task();
            task.setPriority(30);
            task.setTaskType(10+10*i);
            task.setExecuteTime(new Date().getTime()+500*(i+1));
            task.setParameters("refresh task test".getBytes());
            taskService.addTask(task);
        }
    }

    @Test
    void cancelTask(){
        taskService.cancelTask(1771561438918221826L);
    }

    @Test
    void poll(){
        Task task = taskService.poll(50,20);
        System.out.println(task.toString());
    }
}