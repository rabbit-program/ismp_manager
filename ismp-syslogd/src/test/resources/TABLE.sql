CREATE TABLE agent_config (
    id INT NOT NULL AUTO_INCREMENT,
    agent_name VARCHAR(128),
    syslogd_port INT,
    special_poller_thread INT,
    poller_thread INT,
    trapd_port INT,
    receive_event_port INT,
    agent_addr VARCHAR(64),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE spservice (
    serviceId INT DEFAULT 0 NOT NULL,
    name VARCHAR(128),
    serviceType VARCHAR(128),
    status VARCHAR(64),
    svcLostEventUei VARCHAR(128),
    ipAddr VARCHAR(64),
    m_interval BIGINT,
    ifHalfInterval TINYINT,
    svcLostServiceTime TIMESTAMP,
    mininterval BIGINT,
    PRIMARY KEY (serviceId)
) ENGINE=InnoDB;

CREATE TABLE spservice_param (
    parmName VARCHAR(128),
    value VARCHAR(128),
    serviceId INT
) ENGINE=InnoDB;

CREATE TABLE syslog_parser_config (
    id INT  NOT NULL AUTO_INCREMENT,
    type VARCHAR(128),
     src_id varchar(128),
     domain_id varchar(128),
    ip_addr VARCHAR(128),
    uei VARCHAR(128),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE syslog_parser_type (
    id INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(128),
    class_name VARCHAR(128),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE syslogrules (
    id BIGINT NOT NULL AUTO_INCREMENT,
    type VARCHAR(10) DEFAULT '' NOT NULL,
    ip VARCHAR(64) DEFAULT '' NOT NULL,
    regex VARCHAR(128),
    tableName VARCHAR(128),
    status VARCHAR(10),
    createtime DATETIME,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `lm_dlog_syslog_hillstone_firewall`;
CREATE TABLE `lm_dlog_syslog_hillstone_firewall` (
  `id` int(11) NOT NULL auto_increment,
  `dstip` varchar(255) default NULL,
  `dstport` varchar(255) default NULL,
  `hostname` varchar(255) default NULL,
  `ipaddr` varchar(255) default NULL,
  `log_sourcese_quence` varchar(255) default NULL,
  `message_type` varchar(255) default NULL,
  `msg` varchar(255) default NULL,
  `protocol` varchar(255) default NULL,
  `srcip` varchar(255) default NULL,
  `srcport` varchar(255) default NULL,
  `timestamp` datetime default NULL,
  `domain` varchar(255) default NULL,
  `facility` varchar(255) default NULL,
  `severity` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;