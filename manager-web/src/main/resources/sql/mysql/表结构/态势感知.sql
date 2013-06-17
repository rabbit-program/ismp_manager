/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : sep

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2010-12-30 14:10:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bsam_color_threshold`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_color_threshold`;
CREATE TABLE `bsam_color_threshold` (
  `id` int(11) NOT NULL auto_increment,
  `color` varchar(10) NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_color_threshold
-- ----------------------------
INSERT INTO `bsam_color_threshold` VALUES ('1', 'green', '20');
INSERT INTO `bsam_color_threshold` VALUES ('2', 'yellow', '60');

-- ----------------------------
-- Table structure for `bsam_machine`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machine`;
CREATE TABLE `bsam_machine` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `ip` varchar(100) NOT NULL,
  `machine_cabinet_name` varchar(255) default NULL,
  `machine_name` varchar(100) default NULL,
  `machine_room_name` varchar(255) default NULL,
  `parent_type` varchar(100) default NULL,
  `security_area_name` varchar(255) default NULL,
  `weight` int(11) NOT NULL,
  `security_area_id` int(11) default NULL,
  `machine_cabinet_id` int(11) default NULL,
  `machine_room_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK4375A645D9F71468` (`machine_cabinet_id`),
  KEY `FK4375A64596112CEC` (`machine_room_id`),
  KEY `FK4375A6452ED71EC8` (`security_area_id`),
  CONSTRAINT `FK4375A645D9F71468` FOREIGN KEY (`machine_cabinet_id`) REFERENCES `bsam_machine_cabinet` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK4375A6452ED71EC8` FOREIGN KEY (`security_area_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK4375A64596112CEC` FOREIGN KEY (`machine_room_id`) REFERENCES `bsam_machine_room` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machine
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_machine_cabinet`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machine_cabinet`;
CREATE TABLE `bsam_machine_cabinet` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `machine_cabinet_name` varchar(100) NOT NULL,
  `machine_room_name` varchar(255) default NULL,
  `machine_room_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1969A5E96112CEC` (`machine_room_id`),
  CONSTRAINT `FK1969A5E96112CEC` FOREIGN KEY (`machine_room_id`) REFERENCES `bsam_machine_room` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machine_cabinet
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_machine_room`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machine_room`;
CREATE TABLE `bsam_machine_room` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `machine_room_name` varchar(100) NOT NULL,
  `security_area_name` varchar(255) default NULL,
  `security_area_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5D50B6952ED71EC8` (`security_area_id`),
  CONSTRAINT `FK5D50B6952ED71EC8` FOREIGN KEY (`security_area_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machine_room
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_machine_situation`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machine_situation`;
CREATE TABLE `bsam_machine_situation` (
  `id` int(11) NOT NULL auto_increment,
  `attack_threat` float default NULL,
  `invalid_connection` float default NULL,
  `ip` varchar(100) NOT NULL,
  `time` datetime NOT NULL,
  `virus_condition` float default NULL,
  `whole_situation` float default NULL,
  `machine_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK45A3A88411F7FDFD` (`machine_id`),
  CONSTRAINT `FK45A3A88411F7FDFD` FOREIGN KEY (`machine_id`) REFERENCES `bsam_machine` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machine_situation
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_machinecabinet_situation`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machinecabinet_situation`;
CREATE TABLE `bsam_machinecabinet_situation` (
  `id` int(11) NOT NULL auto_increment,
  `attack_threat` float default NULL,
  `invalid_connection` float default NULL,
  `machine_cabinet_name` varchar(100) NOT NULL,
  `time` datetime NOT NULL,
  `virus_condition` float default NULL,
  `whole_situation` float default NULL,
  `machine_cabinet_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5CEEB532D9F71468` (`machine_cabinet_id`),
  CONSTRAINT `FK5CEEB532D9F71468` FOREIGN KEY (`machine_cabinet_id`) REFERENCES `bsam_machine_cabinet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machinecabinet_situation
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_machineroom_situation`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_machineroom_situation`;
CREATE TABLE `bsam_machineroom_situation` (
  `id` int(11) NOT NULL auto_increment,
  `attack_threat` float default NULL,
  `invalid_connection` float default NULL,
  `machine_room_name` varchar(100) NOT NULL,
  `time` datetime NOT NULL,
  `virus_condition` float default NULL,
  `whole_situation` float default NULL,
  `machine_room_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6F9A891F96112CEC` (`machine_room_id`),
  CONSTRAINT `FK6F9A891F96112CEC` FOREIGN KEY (`machine_room_id`) REFERENCES `bsam_machine_room` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_machineroom_situation
-- ----------------------------

-- ----------------------------
-- Table structure for `bsam_securityarea_situation`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_securityarea_situation`;
CREATE TABLE `bsam_securityarea_situation` (
  `id` int(11) NOT NULL auto_increment,
  `attack_threat` float default NULL,
  `invalid_connection` float default NULL,
  `security_area_name` varchar(100) NOT NULL,
  `time` datetime NOT NULL,
  `virus_condition` float default NULL,
  `whole_situation` float default NULL,
  `security_area_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKD95A024E2ED71EC8` (`security_area_id`),
  CONSTRAINT `FKD95A024E2ED71EC8` FOREIGN KEY (`security_area_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsam_securityarea_situation
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : sep

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2011-03-08 10:43:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bsam_situation_event`
-- ----------------------------
DROP TABLE IF EXISTS `bsam_situation_event`;
CREATE TABLE `bsam_situation_event` (
  `id` int(11) unsigned NOT NULL auto_increment COMMENT 'id',
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '态势产生时间',
  `event_id` mediumtext COMMENT '事件的id',
  `srcmod` varchar(100) default NULL COMMENT '事件的产生模块',
  `event_log_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '事件的记录时间',
  `event_old_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '事件的原始时间',
  `event_ip` varchar(100) default NULL COMMENT '事件的目的IP',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9925 DEFAULT CHARSET=utf8 COMMENT='态势对应事件表(常)';

