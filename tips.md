drop table if exists user;
CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`email` char(50) NOT NULL DEFAULT '',
`username` char(50) NOT NULL DEFAULT '',
`password` char(50) NOT NULL DEFAULT '',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;