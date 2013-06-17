--初始化SysLog之Facility
INSERT INTO `lm_dlog_syslog_facility` VALUES ('0', 'kernel messages');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('1', 'user-level messages');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('2', 'mail system');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('3', 'system daemons');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('4', 'security/authorization messages (note 1)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('5', 'messages generated internally by syslogd');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('6', 'line printer subsystem');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('7', 'network news subsystem');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('8', 'UUCP subsystem');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('9', 'clock daemon (note 2)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('10', 'security/authorization messages (note 1)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('11', 'FTP daemon');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('12', 'NTP subsystem');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('13', 'log audit (note 1)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('14', 'log alert (note 1)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('15', 'clock daemon (note 2)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('16', 'local use 0 (local0)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('17', 'local use 1 (local1)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('18', 'local use 2 (local2)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('19', 'local use 3 (local3)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('20', 'local use 4 (local4)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('21', 'local use 5 (local5)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('22', 'local use 6 (local6)');
INSERT INTO `lm_dlog_syslog_facility` VALUES ('23', 'local use 7 (local7)');

----初始化SysLog之Severity
INSERT INTO `lm_dlog_syslog_severity` VALUES ('0', 'Emergency');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('1', 'Alert');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('2', 'Critical');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('3', 'Error');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('4', 'Warning');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('5', 'Notice');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('6', 'Informational');
INSERT INTO `lm_dlog_syslog_severity` VALUES ('7', 'Debug');











--测试数据
INSERT INTO `lm_dlog_syslog` VALUES ('1', '192.168.9.119', '杩欎釜瀛楁濂介暱濂介暱,浣犵湅鍑烘潵浜嗗悧锛熻鏄病鐪嬪嚭鏉ワ紝鎴戝啀鍐欓暱涓€鐐广€傘€傘€傘€?', '2010-10-26 11:05:33', '1', '0', '0');
INSERT INTO `lm_dlog_syslog` VALUES ('2', '192.168.9.128', '杩欎釜瀛楁濂介暱濂介暱,浣犵湅鍑烘潵浜嗗悧锛熻鏄病鐪嬪嚭鏉ワ紝鎴戝啀鍐欓暱涓€鐐广€傘€傘€傘€?', '2010-10-26 11:15:14', '1', '1', '1');

INSERT INTO `lm_dl_syslog_hillstone_fw` VALUES ('1', '202.120.200.7', '443', 'hillstone', '192.168.9.119', '043c348b-7f10-4adf-bd5a-08233d81bead', 'SECURITY', 'interface ethernet0/1, policyid 3, action: policy session start', 'TCP', '192.168.17.88', '2043', '2010-09-19 13:43:20', '1', '1', '1');
INSERT INTO `lm_dl_syslog_hillstone_fw` VALUES ('2', '202.120.200.7', '443', 'hillstone', '192.168.9.128', '043c348b-7f10-4adf-bd5a-08233d81bead', 'SECURITY', 'interface ethernet0/1, policyid 3, action: policy session start', 'TCP', '192.168.1.88', '2043', '2010-09-19 23:43:20', '1', '1', '1');
INSERT INTO `lm_dl_syslog_hillstone_fw` VALUES ('3', '202.120.200.7', '443', 'hillstone', '192.168.9.138', '043c348b-7f10-4adf-bd5a-08233d81bead', 'SECURITY', 'interface ethernet0/1, policyid 3, action: policy session start', 'TCP', '192.168.100.88', '2043', '2010-09-19 23:43:20', '1', '1', '1');

INSERT INTO `lm_dl_syslog_handle_or_parser` VALUES ('1', null, 'hillstoneFireWallParser', 'hillStoneFireWallAction_0.0', 'hillstone');

INSERT INTO `lm_dlog_syslog_source_type` VALUES ('1', 'hillstone', '0.0', '2010-10-20 20:12:19', 'hillstone', 'filrwall', '1');

INSERT INTO `lm_dlog_syslog_source` VALUES ('1', '1', '2010-10-20 20:26:02', '192.168.9.1', '043c348b-7f10-4adf-bd5a-08233d81bead', 'hillStone', '', '1', '1');
INSERT INTO `lm_dlog_syslog_source` VALUES ('2', '1', '2010-10-29 09:50:56', '192.168.9.119', '043c348b-7f10-4adf-bd5a-08233d810000', 'test', '', '2', '1');
INSERT INTO `lm_dlog_syslog_source` VALUES ('3', '1', '2010-11-01 11:13:59', '192.168.9.1', '043c348b-7f10-4adf-bd5a-08233d81bead', 'testpage', '', '1', '1');