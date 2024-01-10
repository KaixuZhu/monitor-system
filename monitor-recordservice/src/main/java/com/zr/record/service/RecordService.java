package com.zr.record.service;



import com.zr.monitor.entity.Report;
import com.zr.monitor.utils.MyJson;

import java.util.List;

public interface RecordService {

	MyJson<List<Report>> checkRecord(Integer rid, Integer cid, Integer wid, String status);

}
