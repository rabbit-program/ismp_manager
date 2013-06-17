--不允许你删除一个被FOREIGN KEY表约束引用的表，除非你做设置SET FOREIGN_KEY_CHECKS=0
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `lm_dlog_ftp`;

CREATE TABLE `lm_dlog_ftp` (
  `id` int(11) NOT NULL auto_increment,
  `agent_id` int(11) default NULL,
  `cs_ip` varchar(255) default NULL,
  `cs_method` varchar(255) default NULL,
  `cs_uri_stem` varchar(255) default NULL,
  `event_time` datetime default NULL,
  `ftp_collect_source_ip` varchar(255) default NULL,
  `log_source_sequence` varchar(255) default NULL,
  `sc_status` varchar(255) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK817E6A018E64BD30` (`domain_id`),
  CONSTRAINT `FK817E6A018E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_ftp_source

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_ftp_source`;

CREATE TABLE `lm_dlog_ftp_source` (
  `id` int(11) NOT NULL auto_increment,
  `agent_id` int(11) default NULL,
  `create_time` datetime default NULL,
  `ftp_collect_source_file_name` varchar(255) default NULL,
  `ftp_collect_source_ip` varchar(255) default NULL,
  `ftp_collect_source_name` varchar(255) default NULL,
  `ftp_collect_source_password` varchar(255) default NULL,
  `ftp_collect_source_path` varchar(255) default NULL,
  `ftp_collect_source_port` int(11) default NULL,
  `interval_collect_time` bigint(20) default NULL,
  `log_source_sequence` varchar(255) default NULL,
  `source_name` varchar(255) default NULL,
  `start_collect_switch` bit(1) default NULL,
  `domain` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK8537E81918725B7E` (`domain`),
  CONSTRAINT `FK8537E81918725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_pc

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_pc`;

CREATE TABLE `lm_dlog_pc` (
  `id` int(11) NOT NULL auto_increment,
  `computer_name` varchar(255) default NULL,
  `event_category` varchar(255) default NULL,
  `event_description` varchar(3000) default NULL,
  `event_id` int(11) default NULL,
  `event_name` varchar(255) default NULL,
  `event_source` varchar(255) default NULL,
  `event_time` datetime default NULL,
  `event_type` varchar(255) default NULL,
  `sensor_sequence` varchar(255) default NULL,
  `source_ip` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_pc_sensor

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_pc_sensor`;

CREATE TABLE `lm_dlog_pc_sensor` (
  `id` int(11) NOT NULL auto_increment,
  `computer_name` varchar(255) default NULL,
  `computer_os_type` varchar(255) default NULL,
  `interval_collect_time` bigint(20) default NULL,
  `sensor_ip` varchar(255) default NULL,
  `sensor_is_exist` bit(1) default NULL,
  `sensor_mac` varchar(255) default NULL,
  `sensor_sequence` varchar(255) default NULL,
  `start_collect_switch` bit(1) default NULL,
  `start_monitor_switch` bit(1) default NULL,
  `domain` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK9FDBE4E518725B7E` (`domain`),
  CONSTRAINT `FK9FDBE4E518725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_snmptrap_sanling_ids

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_snmptrap_sanling_ids`;

CREATE TABLE `lm_dlog_snmptrap_sanling_ids` (
  `id` int(11) NOT NULL auto_increment,
  `descrip` varchar(2000) default NULL,
  `dest_ip` varchar(255) default NULL,
  `dest_port` int(11) default NULL,
  `event_time` datetime default NULL,
  `event_type` varchar(255) default NULL,
  `facility_ip` varchar(255) default NULL,
  `log_source_sequence` varchar(255) default NULL,
  `protocol_type` varchar(255) default NULL,
  `source_ip` varchar(255) default NULL,
  `source_port` int(11) default NULL,
  `threaten_rank` int(11) default NULL,
  `domain` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK7652A73C18725B7E` (`domain`),
  CONSTRAINT `FK7652A73C18725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_snmptrap_source

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_snmptrap_source`;

CREATE TABLE `lm_dlog_snmptrap_source` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `device_ip` varchar(255) default NULL,
  `log_sourcese_quence` varchar(255) default NULL,
  `source_name` varchar(255) default NULL,
  `start_collect_switch` bit(1) default NULL,
  `domain` int(11) default NULL,
  `source_type` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK879AD78E18725B7E` (`domain`),
  KEY `FK879AD78EFDB17E7B` (`source_type`),
  CONSTRAINT `FK879AD78E18725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`),
  CONSTRAINT `FK879AD78EFDB17E7B` FOREIGN KEY (`source_type`) REFERENCES `lm_dlog_snmptrap_source_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_snmptrap_source_handle_or_parser

-- ----------------------------

DROP TABLE IF EXISTS `lm_dl_trap_handle_or_parser`;

CREATE TABLE `lm_dl_trap_handle_or_parser` (
  `id` int(11) NOT NULL auto_increment,
  `agent_handle_class` varchar(255) default NULL,
  `handle_type` varchar(255) default NULL,
  `server_handle_class` varchar(255) default NULL,
  `web_handle_class` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_snmptrap_source_type

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_snmptrap_source_type`;

CREATE TABLE `lm_dlog_snmptrap_source_type` (
  `id` int(11) NOT NULL auto_increment,
  `brand` varchar(255) default NULL,
  `category` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `source_type_name` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `handle_type` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK254F94B90AA73BE` (`handle_type`),
  CONSTRAINT `FK254F94B90AA73BE` FOREIGN KEY (`handle_type`) REFERENCES `lm_dl_trap_handle_or_parser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_syslog`;

CREATE TABLE `lm_dlog_syslog` (
  `id` int(11) NOT NULL auto_increment,
  `hostname` varchar(255) default NULL,
  `message` varchar(2000) default NULL,
  `timestamp` datetime default NULL,
  `domain_id` int(11) default NULL,
  `facility_oid` int(11) default NULL,
  `severity_oid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6C6A4058A51C77A7` (`facility_oid`),
  KEY `FK6C6A40588E64BD30` (`domain_id`),
  KEY `FK6C6A4058D69C035B` (`severity_oid`),
  CONSTRAINT `FK6C6A40588E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`),
  CONSTRAINT `FK6C6A4058A51C77A7` FOREIGN KEY (`facility_oid`) REFERENCES `lm_dlog_syslog_facility` (`facility_number`),
  CONSTRAINT `FK6C6A4058D69C035B` FOREIGN KEY (`severity_oid`) REFERENCES `lm_dlog_syslog_severity` (`severity_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_facility

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_syslog_facility`;

CREATE TABLE `lm_dlog_syslog_facility` (
  `facility_number` int(11) NOT NULL,
  `facility_describe` varchar(255) default NULL,
  PRIMARY KEY  (`facility_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_hillstone_firewall

-- ----------------------------

DROP TABLE IF EXISTS `lm_dl_syslog_hillstone_fw`;

CREATE TABLE `lm_dlog_syslog_hillstone_firewall` (
  `id` int(11) NOT NULL auto_increment,
  `dstip` varchar(255) default NULL,
  `dstport` varchar(255) default NULL,
  `hostname` varchar(255) default NULL,
  `ipaddr` varchar(255) default NULL,
  `log_sourcese_quence` varchar(255) default NULL,
  `message_type` varchar(255) default NULL,
  `msg` varchar(2000) default NULL,
  `protocol` varchar(255) default NULL,
  `srcip` varchar(255) default NULL,
  `srcport` varchar(255) default NULL,
  `timestamp` datetime default NULL,
  `domain` int(11) default NULL,
  `facility` int(11) default NULL,
  `severity` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK60F46762ACDDA41C` (`facility`),
  KEY `FK60F46762215AECD0` (`severity`),
  KEY `FK60F4676218725B7E` (`domain`),
  CONSTRAINT `FK60F4676218725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`),
  CONSTRAINT `FK60F46762215AECD0` FOREIGN KEY (`severity`) REFERENCES `lm_dlog_syslog_severity` (`severity_number`),
  CONSTRAINT `FK60F46762ACDDA41C` FOREIGN KEY (`facility`) REFERENCES `lm_dlog_syslog_facility` (`facility_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_severity

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_syslog_severity`;

CREATE TABLE `lm_dlog_syslog_severity` (
  `severity_number` int(11) NOT NULL,
  `severity_describe` varchar(255) default NULL,
  PRIMARY KEY  (`severity_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_source

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_syslog_source`;

CREATE TABLE `lm_dlog_syslog_source` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `device_ip` varchar(255) default NULL,
  `log_sourcese_quence` varchar(255) default NULL,
  `source_name` varchar(255) default NULL,
  `start_collect_switch` bit(1) default NULL,
  `domain` int(11) default NULL,
  `source_type` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK14F591E218725B7E` (`domain`),
  KEY `FK14F591E29B447667` (`source_type`),
  CONSTRAINT `FK14F591E218725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`),
  CONSTRAINT `FK14F591E29B447667` FOREIGN KEY (`source_type`) REFERENCES `lm_dlog_syslog_source_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_source_handle_or_parser

-- ----------------------------

DROP TABLE IF EXISTS `lm_dl_syslog_handle_or_parser`;

CREATE TABLE `lm_dl_syslog_handle_or_parser` (
  `id` int(11) NOT NULL auto_increment,
  `agent_handle_class` varchar(255) default NULL,
  `handle_type` varchar(255) default NULL,
  `server_handle_class` varchar(255) default NULL,
  `web_handle_class` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_dlog_syslog_source_type

-- ----------------------------

DROP TABLE IF EXISTS `lm_dlog_syslog_source_type`;

CREATE TABLE `lm_dlog_syslog_source_type` (
  `id` int(11) NOT NULL auto_increment,
  `brand` varchar(255) default NULL,
  `category` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `source_type_name` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `handle_type` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB1F59377CB0974AA` (`handle_type`),
  CONSTRAINT `FKB1F59377CB0974AA` FOREIGN KEY (`handle_type`) REFERENCES `lm_dl_syslog_handle_or_parser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for lm_pflog_oplog

-- ----------------------------

DROP TABLE IF EXISTS `lm_pflog_oplog`;

CREATE TABLE `lm_pflog_oplog` (
  `id` int(11) NOT NULL auto_increment,
  `module_name` varchar(255) default NULL,
  `op_desc` varchar(255) default NULL,
  `op_time` datetime default NULL,
  `op_result` varchar(255) default NULL,
  `role_name` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
