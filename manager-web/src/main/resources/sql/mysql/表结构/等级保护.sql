CREATE TABLE `gosp_knowledge_base` (                                                                                            
                       `id` int(11) NOT NULL auto_increment,                                                                                         
                       `domain_id` int(11) default NULL,                                                                                             
                       `sn` varchar(255) default NULL,                                                                                               
                       `name` varchar(255) default NULL,                                                                                             
                       `file_content` varchar(1000) default NULL,                                                                                    
                       `issuer` varchar(255) default NULL,                                                                                           
                       `create_time` datetime default NULL,                                                                                          
                       `last_update_time` datetime default NULL,                                                                                     
                       `remark` varchar(500) default NULL,                                                                                           
                       PRIMARY KEY  (`id`),                                                                                                          
                       KEY `FK_gosp_knowledge_base_ismp_domain` (`domain_id`),                                                                       
                       CONSTRAINT `FK_gosp_knowledge_base_ismp_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE SET NULL  
                     ) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC                                            


CREATE TABLE `gosp_laws_info` (                                                                                            
                  `id` int(11) NOT NULL auto_increment,                                                                                    
                  `domain_id` int(11) default NULL,                                                                                        
                  `sn` varchar(255) default NULL,                                                                                          
                  `name` varchar(255) default NULL,                                                                                        
                  `file_type` varchar(100) default NULL,                                                                                     
                  `issue_unit` varchar(255) default NULL,                                                                                  
                  `issue_date` datetime default NULL,                                                                                      
                  `upload_time` datetime default NULL,                                                                                     
                  `remark` varchar(500) default NULL,                                                                                      
                  PRIMARY KEY  (`id`),                                                                                                     
                  KEY `FK_gosp_laws_info_ismp_domain` (`domain_id`),                                                                       
                  CONSTRAINT `FK_gosp_laws_info_ismp_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE SET NULL  
                ) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC                                       


CREATE TABLE `gosp_safe_state_records` (                                                                                            
                           `id` int(11) NOT NULL auto_increment,                                                                                             
                           `domain_id` int(11) default NULL,                                                                                                 
                           `name` varchar(255) default NULL,                                                                                                 
                           `description` varchar(500) default NULL,                                                                                          
                           `level` int(11) default NULL,                                                                                                     
                           `state` int(11) default NULL,                                                                                                     
                           `create_time` datetime default NULL,                                                                                              
                           `last_update_time` datetime default NULL,                                                                                         
                           `remark` varchar(500) default NULL,                                                                                               
                           PRIMARY KEY  (`id`),                                                                                                              
                           KEY `FK_gosp_safe_state_records_ismp_domain` (`domain_id`),                                                                       
                           CONSTRAINT `FK_gosp_safe_state_records_ismp_domain` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`) ON DELETE SET NULL  
                         ) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC                                                
