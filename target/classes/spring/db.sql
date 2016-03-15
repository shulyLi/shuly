


CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) NOT NULL,
  `user_telnum` varchar(11) DEFAULT NULL,
  `pic_url` varchar(500) NOT NULL,
  `mes` varchar(1023) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `index_telnum` (`user_telnum`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `leave_mes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `from_user` int(10) NOT NULL,
  `to_goods` int(10) NOT NULL,
  `type` tinyint(1) NOT NULL COMMENT '0,1',
  `to_id` int(10) NOT NULL,
  `mes` varchar(1023) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `index_from_user` (`from_user`),
  KEY `index_to_goods` (`to_goods`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `message` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `from_user` int(10) NOT NULL,
  `to_user` int(10) NOT NULL,
  `mes` varchar(1023) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `index_from_user` (`from_user`),
  KEY `index_to_user` (`to_user`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) NOT NULL,
  `psword` varchar(63) NOT NULL,
  `email` varchar(63) DEFAULT NULL,
  `telnum` varchar(11) DEFAULT NULL,
  `level` int(8) NOT NULL DEFAULT '1',
  `last_visit_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `index_telnum` (`telnum`),
  KEY `index_email` (`email`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
CREATE TABLE `visited` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL DEFAULT '-1',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ip` varchar(16) NOT NULL DEFAULT '0.0.0.0',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_user_ip` (`ip`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


