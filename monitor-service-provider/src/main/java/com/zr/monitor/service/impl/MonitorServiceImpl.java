package com.zr.monitor.service.impl;

import com.zr.monitor.entity.Report;
import com.zr.monitor.utils.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zr.monitor.mapper.ReportMapper;
import com.zr.monitor.service.MonitorService;

import java.util.List;

/**
 * MonitorService 接口的实现类，提供了检索报告的方法。
 */
@Service(interfaceClass = MonitorService.class)
public class MonitorServiceImpl implements MonitorService {

	private static final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);

	@Autowired
	private ReportMapper reportMapper;

	/**
	 * 根据指定的时间检索报告。
	 *
	 * @param time 报告检索的时间参数
	 * @return 包含所选报告和状态消息的 MyJson 对象
	 */
	@Override
	public MyJson<List<Report>> getReportByTime(String time) {
		try {
			List<Report> reportList= reportMapper.getReportByTime(time);
			logger.info("Successfully selected. Here are reports: {}",reportList);
			if(reportList.size()==0){
				MyJson<List<Report>> myJson=new MyJson<>("success","But report is not existed",null);
				return myJson;
			}
			else {
				MyJson<List<Report>> myJson=new MyJson<>("success","Report has been selected",reportList);
				return myJson;
			}
		} catch (Exception e){
			logger.error("Error occurred while selecting reports");
			return new MyJson<>("error", "An error occurred while processing the request", null);
		}

	}

	/**
	 * 根据指定的站点ID检索报告。
	 *
	 * @param StationID 报告检索的站点ID参数
	 * @return 包含所选报告和状态消息的 MyJson 对象
	 */
	@Override
	public MyJson<List<Report>> getReportByStation(Integer StationID) {
		try {
			List<Report> reportList= reportMapper.getReportByStation(StationID);
			logger.info("Successfully selected. Here are reports: {}",reportList);
			if(reportList.size()==0){
				MyJson<List<Report>> myJson=new MyJson<>("success","But report is not existed",null);
				return myJson;
			}
			else {
				MyJson<List<Report>> myJson=new MyJson<>("success","Report has been selected",reportList);
				return myJson;
			}
		} catch (Exception e){
			logger.error("Error occurred while selecting reports");
			return new MyJson<>("error", "An error occurred while processing the request", null);
		}
	}

	/**
	 * 根据指定的组件ID检索报告。
	 *
	 * @param ComponentID 报告检索的组件ID参数
	 * @return 包含所选报告和状态消息的 MyJson 对象
	 */
	@Override
	public MyJson<List<Report>> getReportByComponent(Integer ComponentID) {
		try {
			List<Report> reportList= reportMapper.getReportByComponent(ComponentID);
			logger.info("Successfully selected. Here are reports: {}",reportList);
			if(reportList.size()==0){
				MyJson<List<Report>> myJson=new MyJson<>("success","But report is not existed",null);
				return myJson;
			}
			else {
				MyJson<List<Report>> myJson=new MyJson<>("success","Report has been selected",reportList);
				return myJson;
			}
		} catch (Exception e){
			e.printStackTrace();
			return new MyJson<>("error", "An error occurred while processing the request", null);
		}

	}
}
