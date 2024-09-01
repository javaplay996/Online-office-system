package com.example.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl   {
    @Autowired
    private JavaMailSender javaMailSender;
    //发送人
    private String from = "1097426373@qq.com";
    //接收人
    private String to = "1097426373@qq.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "恭喜你被录取了，请尽快道清华大学报到";

    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(小甜甜)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
