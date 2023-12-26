package com.zr.monitor.mapper;

import com.zr.monitor.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
	List<Report> getReportByTime(@Param("time") String time);
	List<Report> getReportByStation(@Param("StationID") Integer StationID);
	List<Report> getReportByComponent(@Param("ComponentID") Integer ComponentID);
}
