CREATE TABLE `oss_pm_domain_complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain_id` int(11) DEFAULT NULL,
  `complaint_type` varchar(255) DEFAULT NULL,
  `complaint_help` varchar(255) DEFAULT NULL,
  `complaint_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_complaint_domain` (`domain_id`),
  CONSTRAINT `fk_complaint_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) 


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
) 


CREATE TABLE `oss_pm_duty_schedule_roster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roster_id` int(11) DEFAULT NULL,
  `duty_schedule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ossPmRoster_ossPmDutyScheduleRoster` (`roster_id`),
  KEY `fk_ossPmDutySchedule_ossPmDutyScheduleRoster` (`duty_schedule_id`),
  CONSTRAINT `fk_ossPmDutySchedule_ossPmDutyScheduleRoster` FOREIGN KEY (`duty_schedule_id`) REFERENCES `oss_pm_duty_schedule` (`id`),
  CONSTRAINT `fk_ossPmRoster_ossPmDutyScheduleRoster` FOREIGN KEY (`roster_id`) REFERENCES `oss_pm_roster` (`id`)
) 


CREATE TABLE `oss_pm_roster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain_id` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ossPmRoster_domain` (`domain_id`) USING BTREE,
  CONSTRAINT `fk_ossPmRoster_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) 
