package com.zr.record.service.impl;

import com.zr.monitor.entity.Report;
import com.zr.monitor.utils.MyJson;
import com.zr.record.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * MonitorService 接口的实现类，提供了检索报告的方法。
 */
@Service(interfaceClass = RecordService.class)
public class RecordServiceImpl implements RecordService {

	private static final Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);


	@Override
	public MyJson<List<Report>> checkRecord(Integer rid, Integer cid, Integer wid, String status) {
		try {
			if(status=="Defective")
			logger.info("This record is error record");
			List<Report> r=new ArrayList<>();
			Report report=new Report();
			report.setRecordID(rid);
			report.setWorkStationID(wid);
			report.setComponentID(cid);
			report.setDefectDescription(status);
			r.add(report);
			MyJson<List<Report>> myJson=new MyJson<>("success", "Error record.",r);
			return myJson;

		} catch (Exception e){
			logger.error("Error occurred.");
			return new MyJson<>("error", "An error occurred.", null);
		}
	}
}
