CREATE TABLE role (
    id INT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL,
    role_desc VARCHAR(255)
);
CREATE TABLE user (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    status INT
);
CREATE TABLE user (
    rid INT PRIMARY KEY,
    uid INT NOT NULL
);
CREATE TABLE defect_report (
    ReportID INT PRIMARY KEY,
    RecordID INT,
    DefectDescription VARCHAR(255),
    ReportDateTime VARCHAR(255),
    ComponentID INT,
    WorkStationID INT
);