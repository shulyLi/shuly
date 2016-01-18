

CREATE TABLE if not EXISTS `user`{
  `id`  INT(9) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(63) NOT  NULL,
  `psword` VARCHAR(63) NOT  NULL,
  `email` VARCHAR(63) ,
  `telnum` VARCHAR(11) ,
  `level`  int(8)  NOT NULL DEFAULT 1,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY(`id`),
  UNIQUE KEY(`name`),
  KEY `index_telnum` (`telnum`),
  KEY `index_email` (`email`),
  key `index_create_time`(`create_time`)
}