SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aim_alert
-- ----------------------------
DROP TABLE IF EXISTS `aim_alert`;
CREATE TABLE `aim_alert` (
  `id` int(11) NOT NULL auto_increment,
  `alert_identity` varchar(255) default NULL,
  `alertreason` varchar(255) default NULL,
  `alertsubtype` varchar(255) default NULL,
  `alerttype` varchar(255) default NULL,
  `fusion` varchar(255) default NULL,
  `ifnew` int(11) default NULL,
  `level` int(11) default NULL,
  `nodeid` bigint(20) default NULL,
  `rawcontent` varchar(5000) default NULL,
  `rule` varchar(255) default NULL,
  `srcip` varchar(255) default NULL,
  `status` int(11) default NULL,
  `time` datetime default NULL,
  `type` varchar(255) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `aim_alert_to_ismp_domain` (`domain_id`),
  CONSTRAINT `aim_alert_to_ismp_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aim_fusion_rule
-- ----------------------------
DROP TABLE IF EXISTS `aim_fusion_rule`;
CREATE TABLE `aim_fusion_rule` (
  `id` int(11) NOT NULL auto_increment,
  `depict` varchar(255) default NULL,
  `fusion_time` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*
MySQL Data Transfer
Source Host: localhost
Source Database: sep
Target Host: localhost
Target Database: sep
Date: 2010-12-31 17:54:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aim_rule
-- ----------------------------
DROP TABLE IF EXISTS `aim_rule`;
CREATE TABLE `aim_rule` (
  `id` int(11) NOT NULL auto_increment,
  `domain_id` int(11) default NULL,
  `deprecated` int(11) default NULL,
  `email_target` varchar(255) default NULL,
  `enabled` int(11) default NULL,
  `msg_target` varchar(255) default NULL,
  `priority` int(11) default NULL,
  `send_email` int(11) default NULL,
  `send_msg` int(11) default NULL,
  `send_sms` int(11) default NULL,
  `sms_target` varchar(255) default NULL,
  `sub_type` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aim_type
-- ----------------------------
DROP TABLE IF EXISTS `aim_type`;
CREATE TABLE `aim_type` (
  `id` int(11) NOT NULL auto_increment,
  `category` varchar(255) default NULL,
  `parent_id` int(11) default NULL,
  `alert_marker` int(11) default NULL,
  `alert_type_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

