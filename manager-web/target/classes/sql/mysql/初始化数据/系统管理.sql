--初始化权限
insert into `ismp_role` (`id`, `name`, `role`) values('1','超级管理员(全局)','AdminAll');
insert into `ismp_role` (`id`, `name`, `role`) values('2','域管理员(全局)','DomainAdminAll');
insert into `ismp_role` (`id`, `name`, `role`) values('3','域管理员(本地)','DomainAdminLocal');
insert into `ismp_role` (`id`, `name`, `role`) values('4','other','other');


--初始化用户，只有超级管理员，初始用户名 /密码为：admin/123456s
insert into `ismp_user` (`id`, `description`, `email`, `enabled`, `end_lock_time`, `expired_time`, `job`, `login_name`, `mobile`, `password`, `phone`, `registertime`, `username`, `version`) 
                  values('1',NULL,NULL,'',NULL,NULL,'admin','admin',NULL,'fc2d169cbb6e0e54b5cdc7a64e0d8122',NULL,NULL,'admin',1);
insert into `ismp_user` (`id`, `description`, `email`, `enabled`, `end_lock_time`, `expired_time`, `job`, `login_name`, `mobile`, `password`, `phone`, `registertime`, `username`, `version`) 
                  values('2',NULL,NULL,'',NULL,NULL,'DomainAdminAll','DomainAdminAll',NULL,'fc2d169cbb6e0e54b5cdc7a64e0d8122',NULL,NULL,'DomainAdminAll',2);
insert into `ismp_user` (`id`, `description`, `email`, `enabled`, `end_lock_time`, `expired_time`, `job`, `login_name`, `mobile`, `password`, `phone`, `registertime`, `username`, `version`) 
                  values('3',NULL,NULL,'',NULL,NULL,'DomainAdminLocal','DomainAdminLocal',NULL,'fc2d169cbb6e0e54b5cdc7a64e0d8122',NULL,NULL,'DomainAdminLocal',3);
insert into `ismp_user` (`id`, `description`, `email`, `enabled`, `end_lock_time`, `expired_time`, `job`, `login_name`, `mobile`, `password`, `phone`, `registertime`, `username`, `version`) 
                  values('4',NULL,NULL,'',NULL,NULL,'other','other',NULL,'fc2d169cbb6e0e54b5cdc7a64e0d8122',NULL,NULL,'other',4);


--初始化用户-权限
insert into `ismp_user_role` (`user_id`, `role_id`) values('1','1');
insert into `ismp_user_role` (`user_id`, `role_id`) values('2','2');
insert into `ismp_user_role` (`user_id`, `role_id`) values('3','3');
insert into `ismp_user_role` (`user_id`, `role_id`) values('4','4');