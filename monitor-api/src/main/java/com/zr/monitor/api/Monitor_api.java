package com.zr.monitor.api;

import com.zr.monitor.entity.Report;
import com.zr.mailmonitor.service.MailService;
import com.zr.monitor.service.MonitorService;
import com.zr.monitor.utils.MyJson;
import com.zr.record.service.RecordService;
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

	@Reference(timeout = 5000)
	private RecordService recordService;

	/**
	 * 根据记录判断是否缺陷，并发送预警邮件
	 *
	 * @param recordId 记录id
	 * @param componentId 部件id
	 * @param stationId 工作站id
	 * @param status 状态
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@PostMapping("/checkRecord")
	public MyJson<List<Report>> checkRecord(@RequestParam Integer recordId, @RequestParam Integer componentId, @RequestParam Integer stationId, @RequestParam String status){
		MyJson<List<Report>> myJson= recordService.checkRecord(recordId,componentId,stationId,status);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}

	/**
	 * 根据时间查找报告，并发送预警邮件
	 *
	 * @param time 时间参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@GetMapping("/getByTime")
	public MyJson<List<Report>> getReportByTime(@RequestParam String time){
		MyJson<List<Report>> myJson= monitorService.getReportByTime(time);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}

	/**
	 * 根据站点ID查找报告，并发送预警邮件
	 *
	 * @param StationID 站点ID参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@GetMapping("/getByStation")
	public MyJson<List<Report>> getReportByStation(@RequestParam Integer StationID){
		MyJson<List<Report>> myJson= monitorService.getReportByStation(StationID);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}

	/**
	 * 根据组件ID查找报告，并发送预警邮件
	 *
	 * @param ComponentID 组件ID参数
	 * @return 包含报告信息和状态消息的 MyJson 对象
	 */
	@GetMapping("/getByComponent")
	public MyJson<List<Report>> getReportByTime(@RequestParam Integer ComponentID){
		MyJson<List<Report>> myJson= monitorService.getReportByComponent(ComponentID);
		if(myJson.getData()!=null){
			myJson = mailService.sendWarningMail(myJson);
		}
		return myJson;
	}
}
