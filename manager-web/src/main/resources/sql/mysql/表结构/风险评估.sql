CREATE TABLE `ram_info_asse` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_busi_id` int(11) default NULL,
  `asse_info_proj_id` int(11) default NULL,
  `asset_code` varchar(50) NOT NULL,
  `asset_name` varchar(50) default NULL,
  `importance` varchar(5) default NULL,
  `ip` varchar(20) default NULL,
  `memo` varchar(500) default NULL,
  `resp_man` varchar(20) default NULL,
  `asse_know_dic_asse_kind_id` int(11) default NULL,
  `domain_id` int(11) default NULL,
  `asse_begin_time` datetime default NULL,
  `asse_comp` varchar(50) default NULL,
  `asse_end_time` datetime default NULL,
  `asse_pers` varchar(20) default NULL,
  `expert_suggest` longtext,
  `proj_id` int(11) default NULL,
  `proj_name` varchar(50) default NULL,
  `secu_leve` varchar(10) default NULL,
  `vuln_high_ip_num` int(11) default NULL,
  `vuln_high_num` int(11) default NULL,
  `vuln_low_ip_num` int(11) default NULL,
  `vuln_low_num` int(11) default NULL,
  `vuln_midu_ip_num` int(11) default NULL,
  `vuln_midu_num` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `asset_code` (`asset_code`),
  KEY `FK76AA8C14313BDA7E` (`asse_know_dic_asse_kind_id`),
  KEY `FK76AA8C148E64BD30` (`domain_id`),
  CONSTRAINT `FK76AA8C14313BDA7E` FOREIGN KEY (`asse_know_dic_asse_kind_id`) REFERENCES `ram_know_dic_asse_kind` (`ID`),
  CONSTRAINT `FK76AA8C148E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


CREATE TABLE `ram_info_busi` (
  `id` int(11) NOT NULL auto_increment,
  `business_id` varchar(20) NOT NULL,
  `business_name` varchar(200) NOT NULL,
  `importance` varchar(5) NOT NULL,
  `resp_man` varchar(10) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `business_id` (`business_id`),
  KEY `FK76AB07F98E64BD30` (`domain_id`),
  CONSTRAINT `FK76AB07F98E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;


CREATE TABLE `ram_info_leak` (
  `ID` int(11) NOT NULL auto_increment,
  `LEAKDESCRIBE` text,
  `IP` varchar(15) default NULL,
  `KNOW_ID` varchar(20) default NULL,
  `LOCATION` text,
  `LEAKPORT` varchar(5) default NULL,
  `PROTOCOL` varchar(10) default NULL,
  `WARN_KIND` varchar(10) default NULL,
  `asse_info_proj_id` int(11) NOT NULL,
  `BUGTRAQ_ID` varchar(15) default NULL,
  `CVE_ID` varchar(20) default NULL,
  `MESS_STRING` text,
  `NSFOCUS_ID` varchar(15) default NULL,
  `PLUGIN_ID` varchar(15) default NULL,
  `RISK` varchar(15) default NULL,
  `SOLUTION` text,
  `asse_info_asse_id` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKE689C3D912AB90AE` (`asse_info_proj_id`),
  KEY `FKE689C3D9FB123B4E` (`asse_info_asse_id`),
  CONSTRAINT `FKE689C3D912AB90AE` FOREIGN KEY (`asse_info_proj_id`) REFERENCES `ram_info_proj` (`id`),
  CONSTRAINT `FKE689C3D9FB123B4E` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_info_pape` (
  `id` int(11) NOT NULL auto_increment,
  `answer` varchar(20) default NULL,
  `asse_info_proj_id` int(11) NOT NULL,
  `memo` longtext,
  `record` longtext,
  `asse_know_stst_secu_elem_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK76B119B63D0F1FB8` (`asse_know_stst_secu_elem_id`),
  CONSTRAINT `FK76B119B63D0F1FB8` FOREIGN KEY (`asse_know_stst_secu_elem_id`) REFERENCES `ram_know_stat_secu_elem` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_info_proj` (
  `id` int(11) NOT NULL auto_increment,
  `address` varchar(50) default NULL,
  `asse_begin_time` datetime NOT NULL,
  `asse_comp` varchar(50) default NULL,
  `asse_end_time` datetime default NULL,
  `asse_pers` varchar(10) NOT NULL,
  `asse_status` varchar(10) NOT NULL,
  `cp_kind` varchar(10) NOT NULL,
  `law_pers` varchar(10) default NULL,
  `linkway` varchar(20) default NULL,
  `phone` varchar(15) default NULL,
  `progress` varchar(10) NOT NULL,
  `proj_name` varchar(50) default NULL,
  `secu_leve` varchar(10) default NULL,
  `zipcode` varchar(6) default NULL,
  `domain_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK76B1596D8E64BD30` (`domain_id`),
  CONSTRAINT `FK76B1596D8E64BD30` FOREIGN KEY (`domain_id`) REFERENCES `ismp_domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_asse_kind` (
  `ID` int(11) NOT NULL auto_increment,
  `ASSET_KIND_ID` varchar(20) NOT NULL,
  `ASSET_KIND_NAME` varchar(50) NOT NULL,
  `asse_know_dic_asse_kind_id` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK8C7A41B54DFFF094` (`asse_know_dic_asse_kind_id`),
  CONSTRAINT `FK8C7A41B54DFFF094` FOREIGN KEY (`asse_know_dic_asse_kind_id`) REFERENCES `ram_know_dic_asse_kind` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_asse_stat` (
  `ID` int(11) NOT NULL auto_increment,
  `ASSE_STAT_ID` varchar(20) NOT NULL,
  `ASSE_STAT_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_cp_kind` (
  `ID` int(11) NOT NULL auto_increment,
  `CP_KIND_ID` varchar(20) NOT NULL,
  `CP_KIND_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_prog` (
  `ID` int(11) NOT NULL auto_increment,
  `PROG_ID` varchar(20) NOT NULL,
  `PROG_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_ques_kind` (
  `ID` int(11) NOT NULL auto_increment,
  `HTML_CODE` text NOT NULL,
  `QUES_KIND_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_risk_matr_rule` (
  `ID` int(11) NOT NULL auto_increment,
  `asse_impo` varchar(5) NOT NULL,
  `risk_valu` varchar(5) NOT NULL,
  `thre_poss` varchar(5) NOT NULL,
  `vuln_seri` varchar(5) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dic_secu_leve` (
  `ID` int(11) NOT NULL auto_increment,
  `SECU_LEVE_ID` varchar(20) NOT NULL,
  `SECU_LEVE_NAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_asse_resu` (
  `ID` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `risk_valu` varchar(5) NOT NULL,
  `asse_info_asse_id` int(11) NOT NULL,
  `asse_know_dyna_thre_id` int(11) default NULL,
  `asse_know_dyna_vuln_id` int(11) default NULL,
  `asse_know_dyna_leak_id` int(11) default NULL,
  `asse_know_dyna_leak_thre_id` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKB9F60432FB123B4E` (`asse_info_asse_id`),
  KEY `FKB9F60432CD4390E` (`asse_know_dyna_leak_thre_id`),
  KEY `FKB9F604328CBEC12B` (`asse_know_dyna_thre_id`),
  KEY `FKB9F60432C6ADAEB` (`asse_know_dyna_vuln_id`),
  KEY `FKB9F60432DF7DD7AB` (`asse_know_dyna_leak_id`),
  CONSTRAINT `FKB9F604328CBEC12B` FOREIGN KEY (`asse_know_dyna_thre_id`) REFERENCES `ram_know_dyna_thre` (`id`),
  CONSTRAINT `FKB9F60432C6ADAEB` FOREIGN KEY (`asse_know_dyna_vuln_id`) REFERENCES `ram_know_dyna_vuln` (`id`),
  CONSTRAINT `FKB9F60432CD4390E` FOREIGN KEY (`asse_know_dyna_leak_thre_id`) REFERENCES `ram_know_dyna_leak_thre` (`id`),
  CONSTRAINT `FKB9F60432DF7DD7AB` FOREIGN KEY (`asse_know_dyna_leak_id`) REFERENCES `ram_know_dyna_leak` (`id`),
  CONSTRAINT `FKB9F60432FB123B4E` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_asse_valu` (
  `id` int(11) NOT NULL auto_increment,
  `expert_suggest` longtext,
  `proj_code` varchar(20) NOT NULL,
  `total_asse` longtext,
  `web_topoinfo` longtext,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_elem_resu` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `is_warn` varchar(2) default NULL,
  `vuln_high_num` int(11) default NULL,
  `vuln_low_num` int(11) default NULL,
  `vuln_midu_num` int(11) default NULL,
  `asse_info_asse_id` int(11) NOT NULL,
  `asse_know_dyna_asse_valu_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK35CBE6A1F56F44A4` (`asse_info_asse_id`),
  KEY `FK35CBE6A186ACC391` (`asse_know_dyna_asse_valu_id`),
  CONSTRAINT `FK35CBE6A186ACC391` FOREIGN KEY (`asse_know_dyna_asse_valu_id`) REFERENCES `ram_know_dyna_asse_valu` (`id`),
  CONSTRAINT `FK35CBE6A1F56F44A4` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_leak` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `asse_know_stat_vuln_kind_id` int(11) default NULL,
  `cve_id` varchar(20) default NULL,
  `asse_info_leak_id` int(11) default NULL,
  `location` longtext,
  `plugin_id` varchar(15) default NULL,
  `seri_leve` varchar(2) default NULL,
  `source` varchar(10) default NULL,
  `vul_id` varchar(20) default NULL,
  `asse_info_asse_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKFE7D01C7F56F44A4` (`asse_info_asse_id`),
  CONSTRAINT `FKFE7D01C7F56F44A4` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_leak_thre` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `asse_know_stat_cve_thre_id` int(11) default NULL,
  `asse_know_stat_thre_kind_id` int(11) default NULL,
  `possibility` varchar(2) NOT NULL,
  `thre_code` varchar(10) default NULL,
  `asse_info_asse_id` int(11) default NULL,
  `asse_know_dyna_leak_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK95810B1FF56F44A4` (`asse_info_asse_id`),
  KEY `FK95810B1FE6EA4601` (`asse_know_dyna_leak_id`),
  CONSTRAINT `FK95810B1FE6EA4601` FOREIGN KEY (`asse_know_dyna_leak_id`) REFERENCES `ram_know_dyna_leak` (`id`),
  CONSTRAINT `FK95810B1FF56F44A4` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_thre` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `asse_know_stat_thre_id` int(11) NOT NULL,
  `asse_know_stat_thre_kind_id` int(11) NOT NULL,
  `possibility` varchar(2) NOT NULL,
  `thre_code` varchar(10) NOT NULL,
  `asse_info_asse_id` int(11) default NULL,
  `asse_know_dyna_vuln_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKFE80B20BF56F44A4` (`asse_info_asse_id`),
  KEY `FKFE80B20B13D74941` (`asse_know_dyna_vuln_id`),
  CONSTRAINT `FKFE80B20B13D74941` FOREIGN KEY (`asse_know_dyna_vuln_id`) REFERENCES `ram_know_dyna_vuln` (`id`),
  CONSTRAINT `FKFE80B20BF56F44A4` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_vta_repo` (
  `id` int(11) NOT NULL auto_increment,
  `asse_name` varchar(50) NOT NULL,
  `asset_id` int(11) default NULL,
  `risk_valu` varchar(5) NOT NULL,
  `sugg` longtext,
  `thre_name` longtext,
  `vuln_poin_name` longtext,
  `asse_info_proj_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB8DE4132D089A04` (`asse_info_proj_id`),
  CONSTRAINT `FKB8DE4132D089A04` FOREIGN KEY (`asse_info_proj_id`) REFERENCES `ram_info_proj` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_vuln` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_busi_id` int(11) default NULL,
  `asse_info_proj_id` int(11) NOT NULL,
  `asse_know_stat_vuln_kind_id` int(11) NOT NULL,
  `asse_know_stat_vuln_poin_id` int(11) NOT NULL,
  `seri_leve` varchar(2) default NULL,
  `source` varchar(10) default NULL,
  `asse_info_asse_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKFE81CAE5F56F44A4` (`asse_info_asse_id`),
  CONSTRAINT `FKFE81CAE5F56F44A4` FOREIGN KEY (`asse_info_asse_id`) REFERENCES `ram_info_asse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_dyna_warn` (
  `id` int(11) NOT NULL auto_increment,
  `asse_info_proj_id` int(11) NOT NULL,
  `high_ip_num` int(11) default NULL,
  `low_ip_num` int(11) default NULL,
  `midu_ip_num` int(11) default NULL,
  `vuln_high_num` int(11) default NULL,
  `vuln_low_num` int(11) default NULL,
  `vuln_midu_num` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_cve_thre` (
  `id` int(11) NOT NULL auto_increment,
  `cve_id` varchar(20) default NULL,
  `memo` longtext,
  `thre_code` varchar(30) NOT NULL,
  `threat` longtext,
  `asse_know_stat_thre_kind_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKD8D4320C1617734C` (`asse_know_stat_thre_kind_id`),
  CONSTRAINT `FKD8D4320C1617734C` FOREIGN KEY (`asse_know_stat_thre_kind_id`) REFERENCES `ram_know_stat_thre_kind` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_leak` (
  `id` int(11) NOT NULL auto_increment,
  `bugtraq_id` varchar(15) default NULL,
  `cve_id` varchar(20) default NULL,
  `ip` varchar(15) default NULL,
  `mess_string` longtext,
  `name` longtext,
  `nsfocus_id` varchar(15) default NULL,
  `plugin_id` varchar(15) default NULL,
  `leakport` varchar(5) default NULL,
  `protocol` varchar(10) default NULL,
  `risk` varchar(15) default NULL,
  `solution` longtext,
  `vul_id` varchar(20) default NULL,
  `asse_know_stat_vuln_kind_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK17D4B3FBA77C2E00` (`asse_know_stat_vuln_kind_id`),
  CONSTRAINT `FK17D4B3FBA77C2E00` FOREIGN KEY (`asse_know_stat_vuln_kind_id`) REFERENCES `ram_know_stat_vuln_kind` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_leak_thre` (
  `id` int(11) NOT NULL auto_increment,
  `memo` longtext,
  `thre_code` varchar(10) NOT NULL,
  `threat` longtext,
  `asse_know_stat_leak_id` int(11) default NULL,
  `asse_know_stat_thre_kind_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKD1E4996B1617734C` (`asse_know_stat_thre_kind_id`),
  KEY `FKD1E4996B3C42E99` (`asse_know_stat_leak_id`),
  CONSTRAINT `FKD1E4996B1617734C` FOREIGN KEY (`asse_know_stat_thre_kind_id`) REFERENCES `ram_know_stat_thre_kind` (`ID`),
  CONSTRAINT `FKD1E4996B3C42E99` FOREIGN KEY (`asse_know_stat_leak_id`) REFERENCES `ram_know_stat_leak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_secu_elem` (
  `ID` int(11) NOT NULL auto_increment,
  `CONTENT` text,
  `ELEM_CODE` varchar(10) NOT NULL,
  `MEMO` text,
  `ELEM_NAME` varchar(30) default NULL,
  `URL` varchar(100) default NULL,
  `asse_know_stat_vuln_poin_id` int(11) default NULL,
  `asse_know_stat_secu_elem_id` int(11) default NULL,
  `asse_know_dic_ques_kind_id` int(11) default NULL,
  `asse_know_stat_secu_elem_id_jump` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ELEM_CODE` (`ELEM_CODE`),
  KEY `FK81BCF1F835B788AA` (`asse_know_stat_vuln_poin_id`),
  KEY `FK81BCF1F8835E4330` (`asse_know_dic_ques_kind_id`),
  KEY `FK81BCF1F8676053D0` (`asse_know_stat_secu_elem_id`),
  KEY `FK81BCF1F8B5B28099` (`asse_know_stat_secu_elem_id_jump`),
  KEY `FK5A99CB12B9F8DC00` (`asse_know_stat_vuln_poin_id`),
  KEY `FK5A99CB12669A2D1A` (`asse_know_dic_ques_kind_id`),
  KEY `FK5A99CB12EBA1A726` (`asse_know_stat_secu_elem_id`),
  KEY `FK5A99CB1239F3D3EF` (`asse_know_stat_secu_elem_id_jump`),
  CONSTRAINT `FK5A99CB1239F3D3EF` FOREIGN KEY (`asse_know_stat_secu_elem_id_jump`) REFERENCES `ram_know_stat_secu_elem` (`ID`),
  CONSTRAINT `FK5A99CB12669A2D1A` FOREIGN KEY (`asse_know_dic_ques_kind_id`) REFERENCES `ram_know_dic_ques_kind` (`ID`),
  CONSTRAINT `FK5A99CB12B9F8DC00` FOREIGN KEY (`asse_know_stat_vuln_poin_id`) REFERENCES `ram_know_stat_vuln_poin` (`ID`),
  CONSTRAINT `FK5A99CB12EBA1A726` FOREIGN KEY (`asse_know_stat_secu_elem_id`) REFERENCES `ram_know_stat_secu_elem` (`ID`),
  CONSTRAINT `FK81BCF1F835B788AA` FOREIGN KEY (`asse_know_stat_vuln_poin_id`) REFERENCES `asse_know_stat_vuln_poin` (`ID`),
  CONSTRAINT `FK81BCF1F8676053D0` FOREIGN KEY (`asse_know_stat_secu_elem_id`) REFERENCES `asse_know_stat_secu_elem` (`ID`),
  CONSTRAINT `FK81BCF1F8835E4330` FOREIGN KEY (`asse_know_dic_ques_kind_id`) REFERENCES `asse_know_dic_ques_kind` (`ID`),
  CONSTRAINT `FK81BCF1F8B5B28099` FOREIGN KEY (`asse_know_stat_secu_elem_id_jump`) REFERENCES `asse_know_stat_secu_elem` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_thre` (
  `ID` int(11) NOT NULL auto_increment,
  `THREAT` text,
  `asse_know_stat_vuln_poin_id` int(11) default NULL,
  `asse_know_stat_thre_kind_id` int(11) default NULL,
  `threCode` varchar(10) NOT NULL,
  `memo` text,
  PRIMARY KEY  (`ID`),
  KEY `FKE351FD9935B788AA` (`asse_know_stat_vuln_poin_id`),
  KEY `FKE351FD9991D61FF6` (`asse_know_stat_thre_kind_id`),
  CONSTRAINT `FKE351FD9935B788AA` FOREIGN KEY (`asse_know_stat_vuln_poin_id`) REFERENCES `ram_know_stat_vuln_poin` (`ID`),
  CONSTRAINT `FKE351FD9991D61FF6` FOREIGN KEY (`asse_know_stat_thre_kind_id`) REFERENCES `ram_know_stat_thre_kind` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_thre_kind` (
  `ID` int(11) NOT NULL auto_increment,
  `KIND` varchar(100) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_vuln_kind` (
  `ID` int(11) NOT NULL auto_increment,
  `KIND` varchar(100) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_vuln_poin` (
  `ID` int(11) NOT NULL auto_increment,
  `VULN_POIN_DESCRIBE` text NOT NULL,
  `RESOLVE` text,
  `SOURCE` varchar(10) default NULL,
  `asse_know_stat_vuln_kind_id` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK8CC841B0233ADAAA` (`asse_know_stat_vuln_kind_id`),
  CONSTRAINT `FK8CC841B0233ADAAA` FOREIGN KEY (`asse_know_stat_vuln_kind_id`) REFERENCES `ram_know_stat_vuln_kind` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;



CREATE TABLE `ram_know_stat_warn_stri` (
  `id` int(11) NOT NULL auto_increment,
  `vuln_high_num` int(11) default NULL,
  `vuln_low_num` int(11) default NULL,
  `vuln_midu_num` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


