CREATE DATABASE IF NOT EXISTS `training` 
USE `training`;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `enumber` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

