/*
MySQL Data Transfer
Source Host: localhost
Source Database: sep
Target Host: localhost
Target Database: sep
Date: 2010-12-30 17:09:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_asset_device
-- ----------------------------
DROP TABLE IF EXISTS `am_asset_device`;
CREATE TABLE `am_asset_device` (
  `id` int(11) NOT NULL auto_increment,
  `sn` varchar(255) default NULL,
  `descr` varchar(5000) default NULL,
  `model` varchar(255) default NULL,
  `manufacturer` varchar(255) default NULL,
  `mac` varchar(255) default NULL,
  `check_available` tinyint(1) default NULL,
  `monitor_status` int(11) default NULL,
  `device_type` varchar(255) default NULL,
  `single_code` varchar(255) default NULL,
  `registration_time` datetime default NULL,
  `validity_period` int(11) default NULL,
  `stock_time` datetime default NULL,
  `status` int(11) default NULL,
  `priority` int(11) default NULL,
  `dep` varchar(255) default NULL,
  `community_name` varchar(2000) default NULL,
  `unit` varchar(255) default NULL,
  `telephone` varchar(255) default NULL,
  `user` varchar(255) default NULL,
  `agent_ip` varchar(255) default NULL,
  `location_id` int(11) default NULL,
  `ip` varchar(255) default NULL,
  `asset_type` int(11) default NULL,
  `name` varchar(255) default NULL,
  `node_id` varchar(255) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_am_asset_device_domain` (`domain_id`),
  CONSTRAINT `FK_am_asset_device_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_change_log
-- ----------------------------
DROP TABLE IF EXISTS `am_change_log`;
CREATE TABLE `am_change_log` (
  `id` int(11) NOT NULL auto_increment,
  `create_time` datetime default NULL,
  `device_id` int(11) default NULL,
  `status_after` varchar(255) default NULL,
  `status_before` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_daily_availability
-- ----------------------------
DROP TABLE IF EXISTS `am_daily_availability`;
CREATE TABLE `am_daily_availability` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `availability_type` int(11) default NULL,
  `single_code` varchar(255) default NULL,
  `time` datetime default NULL,
  `used_percent` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_hardware
-- ----------------------------
DROP TABLE IF EXISTS `am_hardware`;
CREATE TABLE `am_hardware` (
  `id` int(11) NOT NULL auto_increment,
  `capacity` varchar(255) default NULL,
  `description` varchar(5000) default NULL,
  `hardware_type` varchar(255) default NULL,
  `location_id` int(11) default NULL,
  `manufacturer` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `registration_time` datetime default NULL,
  `single_code` varchar(255) default NULL,
  `status` int(11) default NULL,
  `stock_time` datetime default NULL,
  `validity_period` int(11) default NULL,
  `version` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_monthly_availability
-- ----------------------------
DROP TABLE IF EXISTS `am_monthly_availability`;
CREATE TABLE `am_monthly_availability` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `availability_type` int(11) default NULL,
  `single_code` varchar(255) default NULL,
  `time` datetime default NULL,
  `used_percent` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_position
-- ----------------------------
DROP TABLE IF EXISTS `am_position`;
CREATE TABLE `am_position` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(5000) default NULL,
  `parent_id` int(11) default NULL,
  `position_id` int(11) default NULL,
  `single_code` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_raw_availability
-- ----------------------------
DROP TABLE IF EXISTS `am_raw_availability`;
CREATE TABLE `am_raw_availability` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `availability_type` int(11) default NULL,
  `online` bit(1) default NULL,
  `time` datetime default NULL,
  `total_quantity` bigint(20) default NULL,
  `used_percent` int(11) default NULL,
  `used_quantity` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_software
-- ----------------------------
DROP TABLE IF EXISTS `am_software`;
CREATE TABLE `am_software` (
  `id` int(11) NOT NULL auto_increment,
  `department` varchar(255) default NULL,
  `description` varchar(5000) default NULL,
  `location_id` int(11) default NULL,
  `manufacturer` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `registration_time` datetime default NULL,
  `single_code` varchar(255) default NULL,
  `software_type` varchar(255) default NULL,
  `status` int(11) default NULL,
  `stock_time` datetime default NULL,
  `telephone` varchar(255) default NULL,
  `unit` varchar(255) default NULL,
  `user` varchar(255) default NULL,
  `validity_period` int(11) default NULL,
  `version` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_to_hardware
-- ----------------------------
DROP TABLE IF EXISTS `am_to_hardware`;
CREATE TABLE `am_to_hardware` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `description` varchar(255) default NULL,
  `hardware_id` int(11) default NULL,
  `single_code` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_to_position
-- ----------------------------
DROP TABLE IF EXISTS `am_to_position`;
CREATE TABLE `am_to_position` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `description` varchar(255) default NULL,
  `position_id` int(11) default NULL,
  `single_code` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for am_to_software
-- ----------------------------
DROP TABLE IF EXISTS `am_to_software`;
CREATE TABLE `am_to_software` (
  `id` int(11) NOT NULL auto_increment,
  `asset_id` int(11) default NULL,
  `description` varchar(255) default NULL,
  `single_code` varchar(255) default NULL,
  `software_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `single_code` (`single_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

