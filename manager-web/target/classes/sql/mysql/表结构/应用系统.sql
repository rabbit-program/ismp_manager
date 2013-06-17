CREATE TABLE `sysm_app_sys_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain_id` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA67A8B98E64BD33` (`domain_id`),
  CONSTRAINT `FKCA67A8B98E64BD33` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) 

CREATE TABLE `sysm_app_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `app_sys_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `s_a_s_r_s_a_s_i` (`app_sys_id`),
  CONSTRAINT `s_a_s_r_s_a_s_i` FOREIGN KEY (`app_sys_id`) REFERENCES `sysm_app_sys_info` (`id`)
) 

CREATE TABLE `sysm_app_sys_role_assign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_sys_id` int(11) DEFAULT NULL,
  `user_sign` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `s_a_s_r_a_s_a_s_r` (`role_id`),
  KEY `S_a_s_r_a_s_a_s_i` (`app_sys_id`),
  CONSTRAINT `S_a_s_r_a_s_a_s_i` FOREIGN KEY (`app_sys_id`) REFERENCES `sysm_app_sys_info` (`id`),
  CONSTRAINT `s_a_s_r_a_s_a_s_r` FOREIGN KEY (`role_id`) REFERENCES `sysm_app_sys_role` (`id`)
) 