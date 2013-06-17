CREATE TABLE `erm_bia` (
  `id` int(11) NOT NULL auto_increment,
  `assets` varchar(255) default NULL,
  `business` varchar(255) default NULL,
  `rto` int(11) default NULL,
  `rtpo` int(11) default NULL,
  `priority_level_id` int(11) default NULL,
  `resp_info_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKA78A859BF5BEB085` (`priority_level_id`),
  KEY `FKA78A859BC95D2E74` (`resp_info_id`),
  CONSTRAINT `FKA78A859BC95D2E74` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`),
  CONSTRAINT `FKA78A859BF5BEB085` FOREIGN KEY (`priority_level_id`) REFERENCES `erm_priority_level` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;


CREATE TABLE `erm_calltree_linkman` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(255) default NULL,
  `fax` varchar(255) default NULL,
  `fid` int(11) default NULL,
  `job` varchar(255) default NULL,
  `jobid` varchar(255) default NULL,
  `mp` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `pid` int(11) default NULL,
  `team_code` varchar(255) default NULL,
  `resp_info_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKBB179DCC95D2E74` (`resp_info_id`),
  CONSTRAINT `FKBB179DCC95D2E74` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;



CREATE TABLE `erm_notify_proc` (
  `id` int(11) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `resp_info_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK92AC22DC95D2E74` (`resp_info_id`),
  CONSTRAINT `FK92AC22DC95D2E74` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;


CREATE TABLE `erm_priority_level` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `erm_resp_file_print` (
  `id` int(11) NOT NULL auto_increment,
  `content` longtext,
  `resp_info_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1DF1951AC95D2E74` (`resp_info_id`),
  CONSTRAINT `FK1DF1951AC95D2E74` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;


CREATE TABLE `erm_resp_info` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `expect` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `refs` varchar(255) default NULL,
  `state` int(11) default NULL,
  `sys_desc` varchar(255) default NULL,
  `sys_name` varchar(255) default NULL,
  `touch_by` varchar(255) default NULL,
  `update_time` datetime default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1DB5EF9E8E64BD30` (`domain_id`),
  CONSTRAINT `FK1DB5EF9E8E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;


CREATE TABLE `erm_resp_inst` (
  `id` int(11) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `resp_proc_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1DB5F136A88B4966` (`resp_proc_id`),
  CONSTRAINT `FK1DB5F136A88B4966` FOREIGN KEY (`resp_proc_id`) REFERENCES `erm_resp_proc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `erm_resp_proc` (
  `id` int(11) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `resp_info_id` int(11) default NULL,
  `safe_threaten_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1DB92E46C95D2E74` (`resp_info_id`),
  KEY `FK1DB92E4679CC1FCF` (`safe_threaten_id`),
  CONSTRAINT `FK1DB92E4679CC1FCF` FOREIGN KEY (`safe_threaten_id`) REFERENCES `erm_safe_threaten_info` (`id`),
  CONSTRAINT `FK1DB92E46C95D2E74` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;



CREATE TABLE `erm_resp_script` (
  `id` int(11) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `resp_proc_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK98735FBBA88B4966` (`resp_proc_id`),
  CONSTRAINT `FK98735FBBA88B4966` FOREIGN KEY (`resp_proc_id`) REFERENCES `erm_resp_proc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `erm_safe_threaten_info` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(200) default NULL,
  `desc` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;


CREATE TABLE `erm_notify_inst` (
  `id` int(11) NOT NULL auto_increment,
  `notify_proc_id` int(11) default NULL,
  `name` varchar(255) default NULL,
  `content` varchar(1000) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_erm_notify_inst` (`notify_proc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;


CREATE TABLE `erm_pro_manage` (
  `id` int(11) NOT NULL auto_increment,
  `resp_info_id` int(11) default NULL,
  `event_id` int(11) default NULL,
  `event_name` varchar(20) NOT NULL,
  `event_type` varchar(20) NOT NULL,
  `event_content` text,
  `system` varchar(20) NOT NULL,
  `notif_msg` varchar(2000) NOT NULL,
  `process_content` varchar(2000) NOT NULL,
  `resp_summary` varchar(2000) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_erm_pro_manage` (`resp_info_id`),
  CONSTRAINT `FK_erm_pro_manage` FOREIGN KEY (`resp_info_id`) REFERENCES `erm_resp_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
