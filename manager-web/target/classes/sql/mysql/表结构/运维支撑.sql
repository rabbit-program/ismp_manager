/*Table structure for table `oss_klbm_knowledge_base` */

--运维知识库

DROP TABLE IF EXISTS `oss_klbm_knowledge_base`;

CREATE TABLE `oss_klbm_knowledge_base` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `file_content` varchar(255) default NULL,
  `issuer` varchar(255) default NULL,
  `last_update_time` datetime default NULL,
  `name` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `sn` varchar(255) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKCC05902C8E64BD60` (`domain_id`),
  CONSTRAINT `FKCC05902C8E64BD60` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--值班管理

CREATE TABLE `oss_pm_duty_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_leader` int(11) DEFAULT NULL,
  `is_published` int(11) DEFAULT '0',
  `task` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `domain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ossPmDutySchedule_domain` (`domain_id`),
  CONSTRAINT `fk_ossPmDutySchedule_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8


CREATE TABLE `oss_pm_roster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain_id` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ossPmRoster_domain` (`domain_id`),
  CONSTRAINT `fk_ossPmRoster_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8


CREATE TABLE `oss_pm_duty_schedule_roster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roster_id` int(11) DEFAULT NULL,
  `duty_schedule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ossPmRoster_ossPmDutyScheduleRoster` (`roster_id`),
  KEY `fk_ossPmDutySchedule_ossPmDutyScheduleRoster` (`duty_schedule_id`),
  KEY `id` (`id`) USING BTREE,
  CONSTRAINT `fk_ossPmDutySchedule_ossPmDutyScheduleRoster` FOREIGN KEY (`duty_schedule_id`) REFERENCES `oss_pm_duty_schedule` (`id`),
  CONSTRAINT `fk_ossPmRoster_ossPmDutyScheduleRoster` FOREIGN KEY (`roster_id`) REFERENCES `oss_pm_roster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8


--运维工单

CREATE TABLE `oss_wom_client_question` (
  `id` int(11) NOT NULL auto_increment,
  `contact_info` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `description` varchar(500) default NULL,
  `is_new` int(11) default NULL,
  `linkman` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `remark` varchar(500) default NULL,
  `sensor_id` varchar(255) default NULL,
  `server_url` varchar(255) default NULL,
  `sn` varchar(255) default NULL,
  `question_source` varchar(255) default NULL,
  `state` int(11) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6BF505008E64BD30` (`domain_id`),
  CONSTRAINT `FK6BF505008E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


CREATE TABLE `oss_wom_work_order` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `end_time` datetime default NULL,
  `level` int(11) default NULL,
  `notice_way` int(11) default NULL,
  `operator_id` int(11) default NULL,
  `remark` varchar(255) default NULL,
  `sn` varchar(255) default NULL,
  `state` int(11) default NULL,
  `domain_id` int(11) default NULL,
  `question_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKF3AB89BA8E64BD30` (`domain_id`),
  KEY `FKF3AB89BA325C87B` (`question_id`),
  KEY `FKF3AB89BAE6B11E9F` (`operator_id`),
  CONSTRAINT `FKF3AB89BA325C87B` FOREIGN KEY (`question_id`) REFERENCES `oss_wom_client_question` (`id`),
  CONSTRAINT `FKF3AB89BA8E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`),
  CONSTRAINT `FKF3AB89BAE6B11E9F` FOREIGN KEY (`operator_id`) REFERENCES `oss_pm_roster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;



