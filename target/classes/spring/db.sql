
CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodname` varchar(63) NOT NULL,
  `user_id` int(10) NOT NULL,
  `pic_url` varchar(500) NOT NULL,
  `detailPlace` varchar(12) NOT NULL,
  `mes` varchar(1023) DEFAULT NULL,
  `point` int(10) NOT NULL DEFAULT '0',
  `ischeck` smallint(1) NOT NULL DEFAULT '0',
  `judge` varchar(100) NOT NULL DEFAULT '0|0|0|0|0',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `tag` varchar(10) DEFAULT '',
  `province` varchar(8) NOT NULL,
  `isshelf` int(2) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `number` double(10,2) DEFAULT NULL,
  `tradenum` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_userId` (`user_id`),
  KEY `index_name` (`goodname`),
  KEY `index_birth_place` (`detailPlace`),
  KEY `index_point` (`point`),
  KEY `index_create_time` (`create_time`),
  KEY `index_tag` (`tag`),
  KEY `index_find` (`goodname`,`detailPlace`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8
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

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `emailr` varchar(63) DEFAULT NULL,
  `telnum` varchar(11) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL,
  `levelr` int(8) NOT NULL DEFAULT '1',
  `point` int(10) NOT NULL DEFAULT '0',
  `utype` int(2) NOT NULL DEFAULT '-1',
  `ischeck` smallint(1) NOT NULL DEFAULT '0',
  `last_visit_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `pic` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `index_telnum` (`telnum`),
  KEY `index_email` (`emailr`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `visited` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL DEFAULT '-1',
  `good_id` int(10) NOT NULL DEFAULT '-1',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ip` varchar(16) NOT NULL DEFAULT '0.0.0.0',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_user_ip` (`ip`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



