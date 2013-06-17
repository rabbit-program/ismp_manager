/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : sep

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2010-12-30 14:08:41
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `scm_monitor`
-- ----------------------------
DROP TABLE IF EXISTS `scm_monitor`;
CREATE TABLE `scm_monitor` (
  `id` int(11) NOT NULL auto_increment,
  `admonitory_text` varchar(255) default NULL,
  `begin_hour` varchar(255) default NULL,
  `checkfailcount` int(11) default NULL,
  `community` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `description` varchar(255) default NULL,
  `domain_name` varchar(255) default NULL,
  `end_hour` varchar(255) default NULL,
  `event_priority` varchar(255) default NULL,
  `interval_time` int(11) default NULL,
  `ip` varchar(255) default NULL,
  `isdaycheck` varchar(255) default NULL,
  `isweekcheck` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `node_id` varchar(255) default NULL,
  `online_state` int(11) default NULL,
  `password` varchar(255) default NULL,
  `port` varchar(255) default NULL,
  `retry` int(11) default NULL,
  `sub_type` varchar(255) default NULL,
  `timeout` int(11) default NULL,
  `type` varchar(255) NOT NULL,
  `url` varchar(255) default NULL,
  `userid` varchar(255) default NULL,
  `version` varchar(255) default NULL,
  `weekcheck` varchar(255) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5286B3388E64BD30` (`domain_id`),
  CONSTRAINT `FK5286B3388E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scm_monitor
-- ----------------------------
