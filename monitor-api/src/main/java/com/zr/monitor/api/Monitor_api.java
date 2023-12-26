package com.zr.monitor.api;

import com.zr.auth.service.AuthService;
import com.zr.monitor.entity.Report;
import com.zr.mailmonitor.service.MailService;
import com.zr.monitor.service.MonitorService;
import com.zr.monitor.utils.MyJson;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.List;

/**
 * 监控 API 控制器，提供与监控相关的接口
 */
@RestController
@RequestMapping("/monitorApi")
public class Monitor_api {

	@Reference(timeout = 5000)
	private MonitorService monitorService;

	@Reference(timeout = 10000)
	private MailService mailService;

	/**
	 * 根据时间获取报告信息，并发送预警邮件
	 *
	 * @param time 时间参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@RequestMapping("/getByTime")
	public MyJson<List<Report>> getReportByTime(@RequestParam String time){
		MyJson<List<Report>> myJson= monitorService.getReportByTime(time);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}

	/**
	 * 根据站点ID获取报告信息，并发送预警邮件
	 *
	 * @param StationID 站点ID参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@RequestMapping("/getByStation")
	public MyJson<List<Report>> getReportByStation(@RequestParam Integer StationID){
		MyJson<List<Report>> myJson= monitorService.getReportByStation(StationID);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}

	/**
	 * 根据组件ID获取报告信息，并发送预警邮件
	 *
	 * @param ComponentID 组件ID参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@RequestMapping("/getByComponent")
	public MyJson<List<Report>> getReportByTime(@RequestParam Integer ComponentID){
		MyJson<List<Report>> myJson= monitorService.getReportByComponent(ComponentID);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}
}
