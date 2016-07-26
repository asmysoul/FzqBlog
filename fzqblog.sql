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

/*Table structure for table `fzqblog_shuoshuo` */

DROP TABLE IF EXISTS `fzqblog_shuoshuo`;

CREATE TABLE `fzqblog_shuoshuo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `image_url_small` varchar(600) DEFAULT NULL,
  `music_url` varchar(300) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `shuoshuo_index_userid` (`user_id`),
  KEY `shuoshuo_index_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_shuoshuo` */

insert  into `fzqblog_shuoshuo`(`id`,`user_id`,`user_icon`,`user_name`,`image_url`,`image_url_small`,`music_url`,`content`,`create_time`,`comment_count`,`like_count`) values (132,10033,'user_icon/2.jpg','抽离','201607/1469466594145.jpg','201607/1469466594145.jpg_s.jpg|',NULL,'keng&nbsp;<a href=\"http://localhost:8091/user/10032\"  class=\"referer\"  target=\"_blank\">@fan52000</a>','2016-07-26 01:09:57',3,3),(133,10033,'user_icon/2.jpg','抽离','201607/1469466609198.jpg','201607/1469466609198.jpg_s.jpg|',NULL,'<a href=\"http://localhost:8091/user/10036\"  class=\"referer\"  target=\"_blank\">@asmysoul</a> &nbsp;[奥特曼]','2016-07-26 01:10:14',1,4),(134,10034,'user_icon/6.jpg','fan220','201607/1469466680327.jpg','201607/1469466680327.jpg_s.jpg|',NULL,'挺好看的页面[熊猫]','2016-07-26 01:11:21',0,3),(135,10033,'user_icon/2.jpg','抽离','','',NULL,'总算完成说说功能[兔子]<a href=\"http://localhost:8091/user/10029\"  class=\"referer\"  target=\"_blank\">@fan555</a> &nbsp;<a href=\"http://localhost:8091/user/10029\"  class=\"referer\"  target=\"_blank\">@fan555</a>','2016-07-26 01:23:28',1,3),(136,10033,'user_icon/2.jpg','抽离','201607/1469469234756.jpg','201607/1469469234756.jpg_s.jpg|',NULL,'啦啦啦<a href=\"http://localhost:8091/user/10044\"  class=\"referer\"  target=\"_blank\">@sdfasdf</a>','2016-07-26 01:54:15',1,3);

/*Table structure for table `fzqblog_shuoshuo_comment` */

DROP TABLE IF EXISTS `fzqblog_shuoshuo_comment`;

CREATE TABLE `fzqblog_shuoshuo_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shuoshuo_id` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_shuoshuo_id` (`shuoshuo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_shuoshuo_comment` */

insert  into `fzqblog_shuoshuo_comment`(`id`,`shuoshuo_id`,`content`,`create_time`,`user_id`,`user_icon`,`user_name`) values (1,111,'断剑重铸之日骑士归来之时','2015-01-01 00:40:29',10028,'user_icon/2.jpg','抽离'),(2,111,'只有高手才能活下来','2016-07-22 00:40:31',10028,'user_icon/2.jpg','抽离'),(3,112,'要么拥抱暗影，要么死于黑暗','2016-07-22 00:40:33',10034,'user_icon/2.jpg','fan220'),(7,127,'<a href=\"http://localhost:8091/user/10032\"  class=\"referer\"  target=\"_blank\">@fan52000</a> &nbsp;<a href=\"http://localhost:8091/user/10029\"  class=\"referer\"  target=\"_blank\">@fan555</a> &nbsp;<a href=\"http://localhost:8091/user/10032\"  class=\"referer\"  target=\"_blank\">@fan52000</a> &nbsp;<a href=\"http://localhost:8091/user/10036\"  class=\"referer\"  target=\"_blank\">@asmysoul</a> &nbsp;好漂亮啊[威武]','2016-07-25 00:37:55',10033,'user_icon/2.jpg','抽离'),(8,127,'可以的','2016-07-25 00:39:06',10033,'user_icon/2.jpg','抽离'),(9,127,'我很喜欢这种风格','2016-07-25 00:39:21',10033,'user_icon/2.jpg','抽离'),(10,127,'真好','2016-07-25 00:40:16',10033,'user_icon/2.jpg','抽离'),(11,127,'@抽离&nbsp;&nbsp;fafasdfasdf','2016-07-25 00:42:33',10033,'user_icon/2.jpg','抽离'),(12,128,'fasdfasd','2016-07-25 00:49:13',10033,'user_icon/2.jpg','抽离'),(13,128,'dasfsdf','2016-07-25 00:51:34',10033,'user_icon/2.jpg','抽离'),(14,128,'sdfa','2016-07-25 00:54:37',10033,'user_icon/2.jpg','抽离'),(15,128,'fafasdfasfd','2016-07-25 00:56:51',10033,'user_icon/2.jpg','抽离'),(16,128,'[围观]','2016-07-25 00:57:57',10033,'user_icon/2.jpg','抽离'),(17,128,'dfadfasfd<a href=\"http://localhost:8091/user/10044\"  class=\"referer\"  target=\"_blank\">@sdfasdf</a>','2016-07-25 01:01:27',10033,'user_icon/2.jpg','抽离'),(18,111,'@抽离&nbsp;&nbsp;safdasdf','2016-07-25 01:01:52',10033,'user_icon/2.jpg','抽离'),(19,111,'@抽离&nbsp;&nbsp;keyi','2016-07-25 01:02:03',10033,'user_icon/2.jpg','抽离'),(20,129,'[打哈气]','2016-07-25 01:02:47',10033,'user_icon/2.jpg','抽离'),(21,129,'@抽离&nbsp;&nbsp;fasdasd','2016-07-25 01:02:52',10033,'user_icon/2.jpg','抽离'),(22,129,'kengn','2016-07-25 01:03:47',10033,'user_icon/2.jpg','抽离'),(23,131,'<a href=\"http://localhost:8091/user/10029\"  class=\"referer\"  target=\"_blank\">@fan555</a> &nbsp;[呵呵]','2016-07-25 18:02:00',10033,'user_icon/2.jpg','抽离'),(24,133,'lalal','2016-07-26 01:10:42',10033,'user_icon/2.jpg','抽离'),(25,135,'啦啦啦啦<a href=\"http://localhost:8091/user/10029\"  class=\"referer\"  target=\"_blank\">@fan555</a> &nbsp;[可怜]','2016-07-26 01:23:41',10033,'user_icon/2.jpg','抽离'),(26,136,'总的来讲还可以[围观]','2016-07-26 08:11:39',10047,'user_icon/10.jpg','fan_406'),(27,132,'@fan520&nbsp;啦啦啦','2016-07-26 08:12:14',10047,'user_icon/10.jpg','fan_406'),(28,132,'@fan520&nbsp;==','2016-07-26 08:12:45',10047,'user_icon/10.jpg','fan_406'),(29,132,'<a href=\"http://localhost:8091/user/10034\"  class=\"referer\"  target=\"_blank\">@fan220</a> &nbsp;==','2016-07-26 08:12:56',10047,'user_icon/10.jpg','fan_406');

/*Table structure for table `fzqblog_shuoshuo_like` */

DROP TABLE IF EXISTS `fzqblog_shuoshuo_like`;

CREATE TABLE `fzqblog_shuoshuo_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shuoshuo_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`shuoshuo_id`,`user_id`),
  KEY `index_shuoshuo_id` (`shuoshuo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_shuoshuo_like` */

insert  into `fzqblog_shuoshuo_like`(`id`,`shuoshuo_id`,`user_id`,`user_icon`,`user_name`,`create_time`) values (1,111,10032,'user_icon/3.jpg','fan520','2016-07-25 21:37:40'),(2,111,10033,'user_icon/4.jpg','抽离','2016-07-25 21:37:57'),(4,128,10033,'user_icon/2.jpg','抽离','2016-07-26 01:01:26'),(5,126,10033,'user_icon/2.jpg','抽离','2016-07-26 01:01:51'),(6,115,10033,'user_icon/2.jpg','抽离','2016-07-26 01:01:54'),(7,113,10033,'user_icon/2.jpg','抽离','2016-07-26 01:01:58'),(8,114,10033,'user_icon/2.jpg','抽离','2016-07-26 01:02:02'),(9,112,10033,'user_icon/2.jpg','抽离','2016-07-26 01:02:08'),(10,127,10033,'user_icon/2.jpg','抽离','2016-07-26 01:03:17'),(11,116,10033,'user_icon/2.jpg','抽离','2016-07-26 01:08:43'),(12,133,10033,'user_icon/2.jpg','抽离','2016-07-26 01:10:19'),(13,134,10034,'user_icon/6.jpg','fan220','2016-07-26 01:11:27'),(14,133,10034,'user_icon/6.jpg','fan220','2016-07-26 01:11:35'),(15,134,10033,'user_icon/2.jpg','抽离','2016-07-26 01:16:02'),(16,132,10033,'user_icon/2.jpg','抽离','2016-07-26 01:18:02'),(17,135,10033,'user_icon/2.jpg','抽离','2016-07-26 01:23:32'),(18,136,10033,'user_icon/2.jpg','抽离','2016-07-26 01:54:21'),(19,136,10046,'user_icon/5.jpg','406_抽离','2016-07-26 08:07:19'),(20,135,10046,'user_icon/5.jpg','406_抽离','2016-07-26 08:07:31'),(21,133,10046,'user_icon/5.jpg','406_抽离','2016-07-26 08:07:36'),(22,132,10046,'user_icon/5.jpg','406_抽离','2016-07-26 08:07:40'),(23,136,10047,'user_icon/10.jpg','fan_406','2016-07-26 08:11:02'),(24,135,10047,'user_icon/10.jpg','fan_406','2016-07-26 08:11:05'),(25,134,10047,'user_icon/10.jpg','fan_406','2016-07-26 08:11:08'),(26,133,10047,'user_icon/10.jpg','fan_406','2016-07-26 08:11:12'),(27,132,10047,'user_icon/10.jpg','fan_406','2016-07-26 08:11:15');

/*Table structure for table `fzqblog_sign_in` */

DROP TABLE IF EXISTS `fzqblog_sign_in`;

CREATE TABLE `fzqblog_sign_in` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `sign_date` date NOT NULL,
  `sign_time` datetime DEFAULT NULL,
  UNIQUE KEY `idx_userid_signdate` (`userid`,`sign_date`),
  KEY `signin_index_userid` (`userid`),
  KEY `signin_index_signdate` (`sign_date`)
) ENGINE=InnoDB AUTO_INCREMENT=10048 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_sign_in` */

insert  into `fzqblog_sign_in`(`userid`,`user_icon`,`user_name`,`sign_date`,`sign_time`) values (10030,NULL,NULL,'2016-07-17','2016-07-17 22:12:15'),(10033,'user_icon/2.jpg','抽离','2016-07-21','2016-07-21 15:57:15'),(10033,'user_icon/2.jpg','抽离','2016-07-22','2016-07-22 00:47:12'),(10033,'user_icon/2.jpg','抽离','2016-07-23','2016-07-23 00:15:53'),(10033,'user_icon/2.jpg','抽离','2016-07-24','2016-07-24 01:05:06'),(10033,'user_icon/2.jpg','抽离','2016-07-25','2016-07-25 00:11:28'),(10033,'user_icon/2.jpg','抽离','2016-07-26','2016-07-26 01:55:20'),(10034,NULL,NULL,'2016-07-11','2016-07-11 23:04:19'),(10034,NULL,NULL,'2016-07-12','2016-07-12 23:03:59'),(10034,NULL,NULL,'2016-07-13','2016-07-13 23:03:42'),(10034,NULL,'张三','2016-07-14','2016-07-14 02:39:46'),(10034,NULL,NULL,'2016-07-15','2016-07-15 23:03:26'),(10034,NULL,'张三','2016-07-16','2016-07-16 02:40:38'),(10034,NULL,'fan220','2016-07-17','2016-07-17 23:11:05'),(10034,NULL,'fan220','2016-07-18','2016-07-18 02:15:31'),(10034,NULL,'fan220','2016-07-19','2016-07-19 20:15:23'),(10034,NULL,'fan220','2016-07-20','2016-07-20 01:41:56'),(10034,NULL,'fan220','2016-07-21','2016-07-21 03:29:39'),(10034,'user_icon/6.jpg','fan220','2016-07-22','2016-07-22 20:42:07'),(10034,'user_icon/6.jpg','fan220','2016-07-23','2016-07-23 17:32:49'),(10036,NULL,'抽离啦啦啦啦','2016-07-17','2016-07-17 22:57:25'),(10037,NULL,'fan330','2016-07-17','2016-07-17 23:01:32'),(10038,NULL,'fasdfa','2016-07-17','2016-07-17 23:29:34'),(10039,NULL,'qqfanq','2016-07-17','2016-07-17 23:52:27'),(10040,NULL,'fan520','2016-07-18','2016-07-18 02:35:57'),(10040,NULL,'fan520','2016-07-20','2016-07-20 01:46:53'),(10040,'user_icon/2.jpg','fan520','2016-07-22','2016-07-22 16:49:05'),(10041,'user_icon/6.jpg','fan5522','2016-07-21','2016-07-21 15:13:11'),(10043,'user_icon/6.jpg','fasdfadfadf','2016-07-21','2016-07-21 15:53:42'),(10045,'user_icon/4.jpg','fan_抽离','2016-07-26','2016-07-26 01:58:21'),(10046,'user_icon/5.jpg','406_抽离','2016-07-26','2016-07-26 08:07:15'),(10047,'user_icon/10.jpg','fan_406','2016-07-26','2016-07-26 08:13:39');

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
) ENGINE=InnoDB AUTO_INCREMENT=10048 DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_user` */

insert  into `fzqblog_user`(`userid`,`email`,`user_name`,`password`,`user_icon`,`user_bg`,`age`,`sex`,`characters`,`mark`,`address`,`work`,`register_time`,`last_login_time`,`activation_code`) values (10028,'27708324@qq.com','抽离','fan27708324',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-13 02:27:53','2016-07-13 02:27:53','6MA9KQ'),(10029,'fan555@qq.com','fan555','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-13 13:26:32','2016-07-13 13:26:32',NULL),(10030,'fan5555@qq.com','fandasd','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,100,NULL,NULL,'2016-07-13 14:44:01','2016-07-13 14:44:01',NULL),(10031,'1134273060@qq.com','fan555999','fan222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-13 14:45:33','2016-07-13 14:45:33','NQLERL'),(10032,'2770@qq.com','fan52000','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-14 19:50:01','2016-07-14 19:50:01',NULL),(10033,'fan520@qq.com','抽离','7506e6d179b562585c29e5e261cf7386','user_icon/2.jpg',NULL,NULL,NULL,NULL,290,NULL,NULL,'2016-07-16 20:05:57','2016-07-16 20:05:57',NULL),(10034,'fan220@qq.com','fan220','29e291199bb95392c555798e02b14909','user_icon/6.jpg',NULL,NULL,NULL,NULL,388,NULL,NULL,'2016-07-16 20:32:46','2016-07-16 20:32:46',NULL),(10035,'fan2250@qq.com','fan2250','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-17 03:26:18','2016-07-17 03:26:18',NULL),(10036,'fan660@qq.com','asmysoul','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,6,NULL,NULL,'2016-07-17 22:57:16','2016-07-17 22:57:16',NULL),(10037,'fan330@qq.com','fan330','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,6,NULL,NULL,'2016-07-17 23:01:28','2016-07-17 23:01:28',NULL),(10038,'fansdfs5@qq.com','fasdfa','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,'2016-07-17 23:29:26','2016-07-17 23:29:26',NULL),(10039,'fanqqq@qq.com','qqfanq','7506e6d179b562585c29e5e261cf7386',NULL,NULL,NULL,NULL,NULL,6,NULL,NULL,'2016-07-17 23:52:23','2016-07-17 23:52:23',NULL),(10044,'fan52000000d@qq.com','sdfasdf','7506e6d179b562585c29e5e261cf7386','user_icon/3.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-07-23 23:21:47','2016-07-23 23:21:47',NULL),(10045,'fan552200@qq.com','fan_抽离','7506e6d179b562585c29e5e261cf7386','user_icon/4.jpg',NULL,NULL,NULL,NULL,6,NULL,NULL,'2016-07-26 01:58:10','2016-07-26 01:58:10',NULL),(10046,'fan406@qq.com','406_抽离','7506e6d179b562585c29e5e261cf7386','user_icon/5.jpg',NULL,NULL,NULL,NULL,6,NULL,NULL,'2016-07-26 08:07:09','2016-07-26 08:07:09',NULL),(10047,'fan_406@qq.com','fan_406','7506e6d179b562585c29e5e261cf7386','user_icon/10.jpg',NULL,NULL,NULL,NULL,10,NULL,NULL,'2016-07-26 08:10:56','2016-07-26 08:10:56',NULL);

/*Table structure for table `fzqblog_user_friend` */

DROP TABLE IF EXISTS `fzqblog_user_friend`;

CREATE TABLE `fzqblog_user_friend` (
  `user_id` int(50) NOT NULL,
  `friend_user_id` int(50) NOT NULL,
  `user_icon` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `friend_user_icon` varchar(50) DEFAULT NULL,
  `friend_user_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`friend_user_id`),
  KEY `friend_index_userid` (`user_id`),
  KEY `friend_index_friendid` (`friend_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fzqblog_user_friend` */

insert  into `fzqblog_user_friend`(`user_id`,`friend_user_id`,`user_icon`,`user_name`,`friend_user_icon`,`friend_user_name`,`create_time`) values (10033,10028,'user_icon/2.jpg','抽离','user_icon/2.jpg','fan2250','2016-07-23 03:50:00'),(10033,10029,'user_icon/2.jpg','抽离','user_icon/3.jpg','fan555','2016-07-23 03:50:02'),(10033,10030,'user_icon/2.jpg','抽离','user_icon/4.jpg','fan52000','2016-07-23 03:50:03'),(10033,10031,'user_icon/2.jpg','抽离','user_icon/5.jpg','qqfanq','2016-07-23 03:50:05'),(10033,10032,'user_icon/2.jpg','抽离','user_icon/6.jpg','sdfasdf','2016-09-01 03:50:07'),(10033,10033,'user_icon/2.jpg','抽离','user_icon/7.jpg','fan330','2016-07-23 03:50:21'),(10033,10034,'user_icon/2.jpg','抽离','user_icon/8.jpg','asmysoul','2016-07-23 03:50:19'),(10033,10035,'user_icon/2.jpg','抽离','user_icon/9.jpg','fan52000','2016-07-23 03:50:22'),(10033,10036,'user_icon/2.jpg','抽离','user_icon/10.jpg','fan52000','2016-07-23 03:50:24'),(10033,10037,'user_icon/2.jpg','抽离','user_icon/1.jpg','fan52000','2016-07-23 03:50:26'),(10033,10038,'user_icon/2.jpg','抽离','user_icon/1.jpg','fan52000','2016-07-23 03:50:28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
