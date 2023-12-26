package com.zr.mailmonitor.service;

import com.zr.monitor.entity.Report;
import com.zr.monitor.utils.MyJson;

import java.util.List;

public interface MailService {
    public MyJson<List<Report>> sendWarningMail(MyJson<List<Report>> myJson);

}
