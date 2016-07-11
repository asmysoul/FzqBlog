/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.12-log : Database - fzqblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fzqblog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fzqblog`;

/*Table structure for table `fzqblog_user` */

DROP TABLE IF EXISTS `fzqblog_user`;

CREATE TABLE `fzqblog_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_bg` varchar(100) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `characters` varchar(200) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `work` varchar(50) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `activation_code` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `user_index_username` (`user_name`),
  KEY `user_index_email` (`email`),
  KEY `user_index_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_user` */

insert  into `fzqblog_user`(`userid`,`email`,`user_name`,`password`,`user_icon`,`user_bg`,`age`,`sex`,`characters`,`mark`,`address`,`work`,`register_time`,`last_login_time`,`activation_code`) values (10016,'2@2.com','fan520','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:32:48','2016-07-12 02:32:48',NULL),(10017,'fan@qq.com','fan555','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:33:42','2016-07-12 02:33:42',NULL),(10018,'afdasf@qq.com','afasdf','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:38:36','2016-07-12 02:38:36',NULL),(10019,'afdas1f@qq.com','afasdff','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:39:15','2016-07-12 02:39:15',NULL),(10020,'fan999@qq.com','aaa_aaa','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:39:50','2016-07-12 02:39:50',NULL),(10021,'fan@q.com','4asdfas','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:41:48','2016-07-12 02:41:48',NULL),(10022,'fa@qq.com','fasdfasfd','fan520',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-12 02:42:16','2016-07-12 02:42:16',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
