--拓扑发现
CREATE TABLE `tm_find_node_types` (                 
                          `id` int(11) NOT NULL auto_increment,                 
                          `add_date` datetime default NULL,                     
                          `description` varchar(255) default NULL,              
                          `english_tag` varchar(255) default NULL,              
                          `fullclass_name` varchar(255) default NULL,           
                          `ico_path` varchar(255) default NULL,                 
                          `image_path` varchar(255) default NULL,               
                          `name` varchar(255) default NULL,                     
                          `remarks` varchar(255) default NULL,                  
                          `update_date` datetime default NULL,                  
                          PRIMARY KEY  (`id`)                                   
                        ) ENGINE=InnoDB DEFAULT CHARSET=utf8  

CREATE TABLE `tm_find_node` (                                                                 
                    `id` int(11) NOT NULL auto_increment,                                                           
                    `add_date` datetime default NULL,                                                               
                    `community` varchar(255) default NULL,                                                          
                    `description` varchar(255) default NULL,                                                        
                    `ip_addr` varchar(255) default NULL,                                                            
                    `level` int(11) default NULL,                                                                   
                    `mac` varchar(255) default NULL,                                                                
                    `name` varchar(255) default NULL,                                                               
                    `net_mask` varchar(255) default NULL,                                                           
                    `port` int(11) default NULL,                                                                    
                    `remarks` varchar(255) default NULL,                                                            
                    `search_time` varchar(255) default NULL,                                                        
                    `sub_net` varchar(255) default NULL,                                                            
                    `try_num` int(11) default NULL,                                                                 
                    `update_date` datetime default NULL,                                                            
                    `x` int(11) default NULL,                                                                       
                    `y` int(11) default NULL,                                                                       
                    `type` int(11) default NULL,                                                                    
                    `neighbor_interface` varchar(255) default NULL,                                                 
                    `parent_ip_addr` varchar(255) default NULL,                                                     
                    `self_interface` varchar(255) default NULL,                                                     
                    `sensor_id` varchar(255) default NULL,                                                          
                    PRIMARY KEY  (`id`),                                                                            
                    KEY `FKC9127D872F2B041` (`type`),                                                               
                    CONSTRAINT `FKC9127D872F2B041` FOREIGN KEY (`type`) REFERENCES `tm_find_node_types` (`id`)  
                  ) ENGINE=InnoDB DEFAULT CHARSET=utf8                                             

CREATE TABLE `tm_find_lines` (                                                                 
                     `id` int(11) NOT NULL auto_increment,                                                            
                     `add_date` datetime default NULL,                                                                
                     `description` varchar(255) default NULL,                                                         
                     `name` varchar(255) default NULL,                                                                
                     `remarks` varchar(255) default NULL,                                                             
                     `update_date` datetime default NULL,                                                             
                     `node_dest` int(11) default NULL,                                                                
                     `node_self` int(11) default NULL,                                                                
                     PRIMARY KEY  (`id`),                                                                             
                     KEY `FK7C5C445A7776A87B` (`node_self`),                                                          
                     KEY `FK7C5C445A776FD7D1` (`node_dest`),                                                          
                     CONSTRAINT `FK7C5C445A776FD7D1` FOREIGN KEY (`node_dest`) REFERENCES `tm_find_node` (`id`),  
                     CONSTRAINT `FK7C5C445A7776A87B` FOREIGN KEY (`node_self`) REFERENCES `tm_find_node` (`id`)   
                   ) ENGINE=InnoDB DEFAULT CHARSET=utf8                                                               

CREATE TABLE `tm_find_device_types_ruler` (                                             
                                        `id` int(11) NOT NULL auto_increment,                                                           
                                        `add_date` datetime default NULL,                                                               
                                        `description` varchar(255) default NULL,                                                        
                                        `key_chars` varchar(255) default NULL,                                                          
                                        `level` int(11) default NULL,                                                                   
                                        `name` varchar(255) default NULL,                                                               
                                        `oid` varchar(255) default NULL,                                                                
                                        `remarks` varchar(255) default NULL,                                                            
                                        `update_date` datetime default NULL,                                                            
                                        `type` int(11) default NULL,                                                                    
                                        PRIMARY KEY  (`id`),                                                                            
                                        KEY `FK5FD9AB9B2F2B041` (`type`),                                                               
                                        CONSTRAINT `FK5FD9AB9B2F2B041` FOREIGN KEY (`type`) REFERENCES `tm_find_node_types` (`id`)  
                                      ) ENGINE=InnoDB DEFAULT CHARSET=utf8                                            





--拓扑管理
CREATE TABLE `tm_topo_node_type` (
  `type_id` int(11) NOT NULL auto_increment,
  `active_big_image` varchar(100) default NULL,
  `active_small_image` varchar(100) default NULL,
  `active_un_line_big_image` varchar(100) default NULL,
  `active_un_line_small_image` varchar(100) default NULL,
  `english_name` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `type_object` varchar(100) default NULL,
  `un_active_gray_big_image` varchar(100) default NULL,
  `un_active_gray_small_image` varchar(100) default NULL,
  PRIMARY KEY  (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_device_brand` (
  `brand_id` int(11) NOT NULL auto_increment,
  `english_name` varchar(50) default NULL,
  `name` varchar(50) default NULL,
  PRIMARY KEY  (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_device_model` (
  `model_id` int(11) NOT NULL auto_increment,
  `en_name` varchar(50) default NULL,
  `name` varchar(50) default NULL,
  `brand_id` int(11) default NULL,
  PRIMARY KEY  (`model_id`),
  KEY `FK94D01A714360AD4F` (`brand_id`),
  CONSTRAINT `FK94D01A714360AD4F` FOREIGN KEY (`brand_id`) REFERENCES `tm_topo_manager_device_brand` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_node` (
  `node_id` varchar(60) NOT NULL,
  `create_time` datetime default NULL,
  `height` int(11) default '30',
  `ip_address` varchar(255) default NULL,
  `is_visible` int(1) default '1',
  `manager_style` varchar(20) default 'SNMP',
  `name` varchar(50) default NULL,
  `mac` varchar(255) default NULL,
  `node_style` int(1) default '0',
  `point_x` int(11) default NULL,
  `point_y` int(11) default '0',
  `remark` varchar(500) default NULL,
  `status` int(1) default '0',
  `system` varchar(255) default NULL,
  `width` int(11) default '30',
  `brand_id` int(11) default NULL,
  `domain_id` int(11) default NULL,
  `model_id` int(11) default NULL,
  `parent_domain_id` int(11) default NULL,
  `type_id` int(11) default NULL,
  PRIMARY KEY  (`node_id`),
  UNIQUE KEY `node_id` (`node_id`),
  KEY `FKDF30E573C48B0255` (`domain_id`),
  KEY `FKDF30E5734360AD4F` (`brand_id`),
  KEY `FKDF30E573117D7FB7` (`type_id`),
  KEY `FKDF30E5739C2BB900` (`parent_domain_id`),
  KEY `FKDF30E57351E05F0F` (`model_id`),
  CONSTRAINT `FKDF30E573C48B0255` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKDF30E573117D7FB7` FOREIGN KEY (`type_id`) REFERENCES `tm_topo_node_type` (`type_id`),
  CONSTRAINT `FKDF30E5734360AD4F` FOREIGN KEY (`brand_id`) REFERENCES `tm_topo_manager_device_brand` (`brand_id`),
  CONSTRAINT `FKDF30E57351E05F0F` FOREIGN KEY (`model_id`) REFERENCES `tm_topo_manager_device_model` (`model_id`),
  CONSTRAINT `FKDF30E5739C2BB900` FOREIGN KEY (`parent_domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_database` (
  `database_id` bigint(20) NOT NULL auto_increment,
  `database_name` varchar(100) default NULL,
  `display_name` varchar(100) default NULL,
  `down_interval` bigint(20) default NULL,
  `driver` varchar(100) default NULL,
  `ip` varchar(20) default NULL,
  `password` varchar(80) default NULL,
  `port` int(11) default NULL,
  `type` varchar(20) default NULL,
  `up_interval` bigint(20) default NULL,
  `url` varchar(100) default NULL,
  `username` varchar(100) default NULL,
  `version` varchar(50) default NULL,
  `node_id` varchar(60) default NULL,
  PRIMARY KEY  (`database_id`),
  KEY `FK906B286C16C3D115` (`node_id`),
  CONSTRAINT `FK906B286C16C3D115` FOREIGN KEY (`node_id`) REFERENCES `tm_topo_manager_node` (`node_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_link` (
  `link_id` bigint(20) NOT NULL auto_increment,
  `from_device_port` varchar(255) default NULL,
  `link_state` int(11) default NULL,
  `node_type` int(11) default NULL,
  `to_device_port` varchar(255) default NULL,
  `from_node_id` varchar(60) default NULL,
  `to_node_id` varchar(60) default NULL,
  PRIMARY KEY  (`link_id`),
  KEY `FKDF2FE76BEEE4580` (`from_node_id`),
  KEY `FKDF2FE76B9E46DB51` (`to_node_id`),
  CONSTRAINT `FKDF2FE76B9E46DB51` FOREIGN KEY (`to_node_id`) REFERENCES `tm_topo_manager_node` (`node_id`),
  CONSTRAINT `FKDF2FE76BEEE4580` FOREIGN KEY (`from_node_id`) REFERENCES `tm_topo_manager_node` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_sensor` (
  `id` int(11) NOT NULL auto_increment,
  `mac` varchar(255) default NULL,
  `retries` int(11) default NULL,
  `sensor_id` varchar(255) default NULL,
  `timeout` bigint(20) default NULL,
  `node_id` varchar(60) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKDE8D72EB16C3D115` (`node_id`),
  CONSTRAINT `FKDE8D72EB16C3D115` FOREIGN KEY (`node_id`) REFERENCES `tm_topo_manager_node` (`node_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tm_topo_manager_snmp` (
  `snmp_id` bigint(20) NOT NULL auto_increment,
  `community` varchar(255) default NULL,
  `port` varchar(255) default NULL,
  `version` varchar(255) default NULL,
  `node_id` varchar(60) default NULL,
  PRIMARY KEY  (`snmp_id`),
  KEY `FKDF3328AF16C3D115` (`node_id`),
  CONSTRAINT `FKDF3328AF16C3D115` FOREIGN KEY (`node_id`) REFERENCES `tm_topo_manager_node` (`node_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
