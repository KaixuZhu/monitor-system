package com.zr.monitor.service;

import com.zr.monitor.entity.Report;
import com.zr.monitor.utils.MyJson;

import java.util.List;

public interface MonitorService {

	MyJson<List<Report>> getReportByTime(String time);
	MyJson<List<Report>> getReportByStation(Integer StationID);
	MyJson<List<Report>> getReportByComponent(Integer ComponentID);

}
