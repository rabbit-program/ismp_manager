-----------------------monitor------------------------
CREATE TABLE `monitor` (
  `id` int(10) NOT NULL,
  `servicetype` varchar(128) default NULL,
  `classname` varchar(512) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
---------------------spservice--------------------------
CREATE TABLE `spservice` (
  `serviceId` int(10) NOT NULL default '0',
  `name` varchar(128) default NULL,
  `serviceType` varchar(128) default NULL,
  `status` varchar(64) default NULL,
  `svcLostEventUei` varchar(128) default NULL,
  `ipAddr` varchar(64) default NULL,
  `m_interval` bigint(64) default NULL,
  `ifHalfInterval` tinyint(2) default NULL,
  `svcLostServiceTime` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `mininterval` bigint(64) default NULL,
  PRIMARY KEY  (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
-----------------------spservice_param------------------------
CREATE TABLE `spservice_param` (
  `parmName` varchar(128) default NULL,
  `value` varchar(128) default NULL,
  `serviceId` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8