package com.xiaoxin.jms.controller;

import com.xiaoxin.jms.model.Message;
import com.xiaoxin.jms.service.MessageService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午7:34
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
//    @Qualifier("clientMessageService")
    private MessageService clientMessageService;

    @PostMapping("/addOne")
    public Result addMessage(){
        clientMessageService.addMessage(new Message());
        return ResultGenerator.genSuccessResult();
    }


}
