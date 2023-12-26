package com.zr.monitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report implements Serializable {

    public Integer ReportID;
    public Integer RecordID;
    public String DefectDescription;
    public String ReportDateTime;
    public Integer ComponentID;
    public Integer WorkStationID;

}
