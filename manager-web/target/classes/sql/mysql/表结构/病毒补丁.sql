CREATE TABLE `vpm_pm_def_pro_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(255) DEFAULT NULL,
  `pro_value` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


CREATE TABLE `vpm_pm_patch_update_tactics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `is_auto_update` int(11) DEFAULT NULL,
  `last_change_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `update_address` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `update_way` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8

CREATE TABLE `vpm_pm_sensor_clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `operate_time` date DEFAULT NULL,
  `patch_ok_num` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `sensor_id` varchar(255) DEFAULT NULL,
  `sensor_ip` varchar(255) DEFAULT NULL,
  `sensor_mac` varchar(255) DEFAULT NULL,
  `asset_device_id` int(11) DEFAULT NULL,
  `domain_id` int(11) DEFAULT NULL,
  `patch_update_tactics_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA67A8B98E64BD30` (`domain_id`),
  KEY `FKCA67A8B930E7C8CA` (`patch_update_tactics_id`),
  CONSTRAINT `FKCA67A8B930E7C8CA` FOREIGN KEY (`patch_update_tactics_id`) REFERENCES `vpm_pm_patch_update_tactics` (`id`),
  CONSTRAINT `FKCA67A8B98E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8

CREATE TABLE `vpm_sd_dispatch_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatch_check_tag` tinyint(1) DEFAULT NULL,
  `consistency_check_tag` tinyint(1) DEFAULT NULL,
  `dispatch_form_tag` tinyint(1) DEFAULT NULL,
  `dispatch_thread_num` int(11) DEFAULT NULL,
  `dispatch_priority` int(1) DEFAULT NULL,
  `dispatch_start_date` timestamp NULL DEFAULT NULL,
  `dispatch_end_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dispatch_start_time` mediumtext,
  `dispatch_end_time` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8


CREATE TABLE `vpm_sd_execute_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `execute_file_path` varchar(255) DEFAULT NULL,
  `execute_check_tag` tinyint(1) DEFAULT NULL,
  `execute_parameter` varchar(255) DEFAULT NULL,
  `execute_prompting_message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8



CREATE TABLE `vpm_sd_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `soft_link_name` varchar(255) DEFAULT NULL,
  `md5` varchar(255) DEFAULT NULL,
  `validate` varchar(255) DEFAULT NULL,
  `size` mediumtext,
  `type_id` int(11) DEFAULT NULL,
  `execute_id` int(11) DEFAULT NULL,
  `dispatch_id` int(11) DEFAULT NULL,
  `validate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_info_type` (`type_id`),
  KEY `fk_info_validate` (`validate_id`),
  KEY `fk_info_dispatch` (`dispatch_id`),
  KEY `fk_info_execute` (`execute_id`),
  CONSTRAINT `fk_info_dispatch` FOREIGN KEY (`dispatch_id`) REFERENCES `vpm_sd_dispatch_policy` (`id`),
  CONSTRAINT `fk_info_execute` FOREIGN KEY (`execute_id`) REFERENCES `vpm_sd_execute_policy` (`id`),
  CONSTRAINT `fk_info_type` FOREIGN KEY (`type_id`) REFERENCES `vpm_sd_type_info` (`id`),
  CONSTRAINT `fk_info_validate` FOREIGN KEY (`validate_id`) REFERENCES `vpm_sd_validate_policy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8


CREATE TABLE `vpm_sd_record_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `download_status` int(11) DEFAULT NULL,
  `download_time` datetime DEFAULT NULL,
  `sensor_id` varchar(255) DEFAULT NULL,
  `setup_status` int(11) DEFAULT NULL,
  `setup_time` datetime DEFAULT NULL,
  `software_name` varchar(255) DEFAULT NULL,
  `validation_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 


CREATE TABLE `vpm_sd_sensor_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `dep_sequence` varchar(255) DEFAULT NULL,
  `device_single_code` varchar(255) DEFAULT NULL,
  `sensor_name` varchar(255) DEFAULT NULL,
  `sensor_sequence` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 


CREATE TABLE `vpm_sd_type_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8


CREATE TABLE `vpm_sd_validate_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `validate_check_tag` tinyint(1) DEFAULT NULL,
  `validate_file_path` varchar(255) DEFAULT NULL,
  `validate_file_version` varchar(255) DEFAULT NULL,
  `validate_register_key` varchar(255) DEFAULT NULL,
  `validate_process` varchar(255) DEFAULT NULL,
  `validate_service` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

CREATE TABLE `vpm_vm_kill_result_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `vpm_vm_rav_clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(255) DEFAULT NULL,
  `client_ip` varchar(255) DEFAULT NULL,
  `client_last_register_time` datetime DEFAULT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `client_port` int(11) DEFAULT NULL,
  `client_state` int(11) DEFAULT NULL,
  `client_version` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `asset_device_id` int(11) DEFAULT NULL,
  `domain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC31A21348E64BD30` (`domain_id`),
  CONSTRAINT `FKC31A21348E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8

CREATE TABLE `vpm_vm_sys_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `center_ip` varchar(255) DEFAULT NULL,
  `center_port` int(11) DEFAULT NULL,
  `center_ver` varchar(255) DEFAULT NULL,
  `last_register` datetime DEFAULT NULL,
  `parent_center_id` varchar(255) DEFAULT NULL,
  `receiver_ip` varchar(255) DEFAULT NULL,
  `receiver_port` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `sender_ip` varchar(255) DEFAULT NULL,
  `sender_port` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `vpm_vm_virus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_find_time` datetime DEFAULT NULL,
  `last_find_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `virus_clients_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9396141951F9067` (`virus_clients_id`),
  KEY `FKC93961416FBECBC4` (`typeid`),
  CONSTRAINT `FKC93961416FBECBC4` FOREIGN KEY (`typeid`) REFERENCES `vpm_vm_virus_type` (`id`),
  CONSTRAINT `FKC9396141951F9067` FOREIGN KEY (`virus_clients_id`) REFERENCES `vpm_vm_rav_clients` (`id`)
) 

CREATE TABLE `vpm_vm_va` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `find_time` datetime DEFAULT NULL,
  `finder` varchar(255) DEFAULT NULL,
  `last_find_time` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `virus_source` varchar(255) DEFAULT NULL,
  `kill_result_id` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  `virus_clients_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8D0798DEE618EB2` (`virus_id`),
  KEY `FK8D0798DE951F9067` (`virus_clients_id`),
  KEY `FK8D0798DEB5C3E0B9` (`kill_result_id`),
  CONSTRAINT `FK8D0798DE951F9067` FOREIGN KEY (`virus_clients_id`) REFERENCES `vpm_vm_rav_clients` (`id`),
  CONSTRAINT `FK8D0798DEB5C3E0B9` FOREIGN KEY (`kill_result_id`) REFERENCES `vpm_vm_kill_result_type` (`id`),
  CONSTRAINT `FK8D0798DEE618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 


CREATE TABLE `vpm_vm_vad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `report_date` datetime DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  `virus_clients_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA6683B78E618EB2` (`virus_id`),
  KEY `FKA6683B78951F9067` (`virus_clients_id`),
  CONSTRAINT `FKA6683B78951F9067` FOREIGN KEY (`virus_clients_id`) REFERENCES `vpm_vm_rav_clients` (`id`),
  CONSTRAINT `FKA6683B78E618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 

CREATE TABLE `vpm_vm_vad_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `report_date` datetime DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `sys_center_id` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBB9F36FCE618EB2` (`virus_id`),
  KEY `FKBB9F36FC6DD11DED` (`sys_center_id`),
  CONSTRAINT `FKBB9F36FC6DD11DED` FOREIGN KEY (`sys_center_id`) REFERENCES `vpm_vm_sys_center` (`id`),
  CONSTRAINT `FKBB9F36FCE618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 

CREATE TABLE `vpm_vm_va_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `find_time` datetime DEFAULT NULL,
  `finder` varchar(255) DEFAULT NULL,
  `last_find_time` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `virus_source` varchar(255) DEFAULT NULL,
  `kill_result_id` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  `virus_clients_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK26DC66D2E618EB2` (`virus_id`),
  KEY `FK26DC66D2951F9067` (`virus_clients_id`),
  KEY `FK26DC66D2B5C3E0B9` (`kill_result_id`),
  CONSTRAINT `FK26DC66D2951F9067` FOREIGN KEY (`virus_clients_id`) REFERENCES `vpm_vm_rav_clients` (`id`),
  CONSTRAINT `FK26DC66D2B5C3E0B9` FOREIGN KEY (`kill_result_id`) REFERENCES `vpm_vm_kill_result_type` (`id`),
  CONSTRAINT `FK26DC66D2E618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 


CREATE TABLE `vpm_vm_vam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `report_date` datetime DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  `virus_clients_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA18D11ACE618EB2` (`virus_id`),
  KEY `FKA18D11AC951F9067` (`virus_clients_id`),
  CONSTRAINT `FKA18D11AC951F9067` FOREIGN KEY (`virus_clients_id`) REFERENCES `vpm_vm_rav_clients` (`id`),
  CONSTRAINT `FKA18D11ACE618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 

CREATE TABLE `vpm_vm_vam_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_time` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `report_date` datetime DEFAULT NULL,
  `vcount` int(11) DEFAULT NULL,
  `sys_center_id` int(11) DEFAULT NULL,
  `virus_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK53ABE48E618EB2` (`virus_id`),
  KEY `FK53ABE486DD11DED` (`sys_center_id`),
  CONSTRAINT `FK53ABE486DD11DED` FOREIGN KEY (`sys_center_id`) REFERENCES `vpm_vm_sys_center` (`id`),
  CONSTRAINT `FK53ABE48E618EB2` FOREIGN KEY (`virus_id`) REFERENCES `vpm_vm_virus` (`id`)
) 

CREATE TABLE `vpm_vm_virus_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
