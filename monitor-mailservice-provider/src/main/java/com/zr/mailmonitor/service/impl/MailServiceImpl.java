package com.zr.mailmonitor.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zr.mailmonitor.entity.Email;
import com.zr.monitor.entity.Report;
import com.zr.mailmonitor.service.MailService;
import com.zr.monitor.utils.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

/**
 * 邮件服务的实现类，用于发送警告邮件。
 */
@Service(interfaceClass = MailService.class)
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    // 注入'spring.mail.username'属性
    @Value("${spring.mail.username}")
    private String from;

    // 自动注入JavaMailSender以发送电子邮件
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送警告邮件的方法，其中包含报告的列表。
     *
     * @param myJson 包含报告列表的MyJson对象
     * @return 包含状态消息的MyJson对象
     */
    public MyJson<List<Report>> sendWarningMail(MyJson<List<Report>> myJson){
        List<Report> selectResult=myJson.getData();
        String content = "An error was found, here is the information\n";
        for (Report r: selectResult) {
            content+=r.toString()+"\n";
        }

        Email mail=new Email("15930243608@163.com","Warning!",content);

        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(mail.getTos());
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());
            mailSender.send(message);//设置基本信息并发送邮件
            myJson.setMessage("Report has been selected and e-mail has been sent");
            logger.info("Warning email sent successfully to: {}", mail.getTos());
            return myJson;
        }catch (Exception e){
            logger.error("Failed to send warning email to: {}", mail.getTos(), e);
            myJson.setStatus("Mail error");
            myJson.setMessage("Report has been selected but e-mail has failed to be sent");
            return myJson;
        }
    }
}