SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for em_center_event_moni
-- ----------------------------
DROP TABLE IF EXISTS `em_center_event_moni`;
CREATE TABLE `em_center_event_moni` (
  `id` int(11) NOT NULL auto_increment,
  `bureau_id` varchar(255) NOT NULL,
  `bureau_name` varchar(20) NOT NULL,
  `curr_value` int(11) NOT NULL,
  `faci_avai` double NOT NULL,
  `init_value` int(11) NOT NULL,
  `max_value` int(11) NOT NULL,
  `min_value` int(11) NOT NULL,
  `rangee` double NOT NULL,
  `redundance` float NOT NULL,
  `thre_rank` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `total_value` int(11) NOT NULL,
  `type` varchar(1024) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_center_task_sele
-- ----------------------------
DROP TABLE IF EXISTS `em_center_task_sele`;
CREATE TABLE `em_center_task_sele` (
  `id` int(11) NOT NULL auto_increment,
  `bureau_id` varchar(20) NOT NULL,
  `define_id` varchar(1) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_event_corr_rule
-- ----------------------------
DROP TABLE IF EXISTS `em_event_corr_rule`;
CREATE TABLE `em_event_corr_rule` (
  `id` int(11) NOT NULL auto_increment,
  `corr_type` tinyint(4) NOT NULL,
  `dest_ip` varchar(100) NOT NULL,
  `dest_port` varchar(100) NOT NULL,
  `operation` tinyint(4) default NULL,
  `prot_rule` varchar(100) NOT NULL,
  `rule_name` varchar(50) NOT NULL,
  `src_ip` varchar(100) NOT NULL,
  `user_name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_event_moni
-- ----------------------------
DROP TABLE IF EXISTS `em_event_moni`;
CREATE TABLE `em_event_moni` (
  `id` int(11) NOT NULL auto_increment,
  `curr_value` int(11) NOT NULL,
  `faci_avai` double default NULL,
  `faci_id` varchar(20) default NULL,
  `faci_ip` varchar(20) NOT NULL,
  `faci_name` varchar(20) default NULL,
  `init_value` int(11) default NULL,
  `max_value` int(11) default NULL,
  `min_value` int(11) default NULL,
  `rangee` double default NULL,
  `redundance` float default NULL,
  `thre_rank` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `total_value` int(11) NOT NULL,
  `type` varchar(1024) default NULL,
  `domain` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKDBDC615918725B7E` (`domain`),
  CONSTRAINT `FKDBDC615918725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_event_moni_info
-- ----------------------------
DROP TABLE IF EXISTS `em_event_moni_info`;
CREATE TABLE `em_event_moni_info` (
  `id` int(11) NOT NULL auto_increment,
  `alert_value` bigint(20) default NULL,
  `bureau_id` int(11) default NULL,
  `descrip` varchar(1024) default NULL,
  `event_type` varchar(50) NOT NULL,
  `ipaddress` varchar(255) NOT NULL,
  `threshold` bigint(20) default NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_event_real_disp
-- ----------------------------
DROP TABLE IF EXISTS `em_event_real_disp`;
CREATE TABLE `em_event_real_disp` (
  `id` int(11) NOT NULL auto_increment,
  `descrip` varchar(1024) default NULL,
  `dest_ip` varchar(20) NOT NULL,
  `dest_port` int(11) default NULL,
  `event_time` datetime NOT NULL,
  `event_type` varchar(10) NOT NULL,
  `faci_ip` varchar(20) NOT NULL,
  `faci_type` varchar(10) NOT NULL,
  `prot_type` varchar(10) default NULL,
  `src_ip` varchar(20) NOT NULL,
  `src_port` int(11) default NULL,
  `thre_rank` int(11) NOT NULL,
  `domain` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK7CF946A718725B7E` (`domain`),
  CONSTRAINT `FK7CF946A718725B7E` FOREIGN KEY (`domain`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for em_event_task_sele
-- ----------------------------
DROP TABLE IF EXISTS `em_event_task_sele`;
CREATE TABLE `em_event_task_sele` (
  `id` int(11) NOT NULL auto_increment,
  `define_id` int(11) NOT NULL,
  `faci_ip` varchar(50) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
