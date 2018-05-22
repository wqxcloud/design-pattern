package com.xiaoxin.jms.controller;

import com.xiaoxin.jms.model.Message;
import com.xiaoxin.jms.service.MessageService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午7:34
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/addOne")
    public Result addMessage(@RequestBody String content) {
        messageService.addMessage(new Message(content));
        return ResultGenerator.genSuccessResult();
    }


}
