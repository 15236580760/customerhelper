/*
SQLyog Ultimate v8.32
MySQL - 5.5.56 : Database - customer_helper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`customer_helper` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `customer_helper`;

/*Table structure for table `discount` */

DROP TABLE IF EXISTS `discount`;

CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price_range` int(11) DEFAULT NULL,
  `favourable` int(11) DEFAULT NULL,
  `game_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `discount` */

insert  into `discount`(`id`,`price_range`,`favourable`,`game_name`) values (1,0,0,'王者荣耀'),(2,21,2,'王者荣耀'),(3,51,5,'王者荣耀'),(4,101,7,'王者荣耀'),(5,201,15,'王者荣耀'),(6,501,30,'王者荣耀'),(9,1001,50,'王者荣耀'),(10,4,2,'fgo'),(11,444,2,'cf');

/*Table structure for table `glory_combo` */

DROP TABLE IF EXISTS `glory_combo`;

CREATE TABLE `glory_combo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `combo_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `combo_addition` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `glory_combo` */

insert  into `glory_combo`(`id`,`combo_name`,`combo_addition`) values (1,'普通代练','1.0'),(2,'加急代练','1.3'),(3,'指定英雄','1.2'),(6,'fgo',NULL),(7,'CF',NULL);

/*Table structure for table `glory_quoted` */

DROP TABLE IF EXISTS `glory_quoted`;

CREATE TABLE `glory_quoted` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `price` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `time` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `interval_value` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `star_num` int(11) DEFAULT NULL,
  `server_multiplier` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `level_name` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `glory_quoted` */

insert  into `glory_quoted`(`id`,`name`,`price`,`parent`,`time`,`interval_value`,`star_num`,`server_multiplier`,`level_name`) values (1,'安卓QQ区',NULL,45,NULL,'',NULL,NULL,NULL),(2,'安卓微信区',NULL,45,NULL,'',NULL,NULL,NULL),(3,'苹果QQ区',NULL,45,NULL,'',NULL,NULL,NULL),(4,'苹果微信区',NULL,45,NULL,'',NULL,NULL,NULL),(5,'qt3','2.0',1,'2.0','101',3,NULL,'青铜3-青铜2'),(6,'qt2','2.0',1,'2.0','102',3,NULL,'青铜2-青铜1'),(7,'qt1','2.0',1,'2.0','103',3,NULL,'青铜1-白银3'),(9,'by3','2.0',1,'2.0','104',3,NULL,'白银3-白银2'),(10,'by2','3.0',1,'2.0','105',3,NULL,'白银2-白银1'),(11,'by1','3.0',1,'2.0','106',3,NULL,'白银1-黄金4'),(12,'hj4','4.0',1,'2.0','107',4,NULL,'黄金4-黄金3'),(13,'hj3','4.0',1,NULL,'108',4,NULL,'黄金3-黄金2'),(14,'hj2','4.0',1,NULL,'109',4,NULL,'黄金2-黄金1'),(15,'hj1','6.0',1,NULL,'110',4,NULL,'黄金1-铂金4'),(16,'bj4','6.0',1,NULL,'111',4,NULL,'铂金4-铂金3'),(17,'bj3','7.0',1,NULL,'112',4,NULL,'铂金3-铂金2'),(18,'bj2','7.0',1,NULL,'113',4,NULL,'铂金2-铂金1'),(19,'bj1','8.0',1,NULL,'114',4,NULL,'铂金1-钻石5'),(20,'zs5','8.0',1,NULL,'115',5,NULL,'钻石5-钻石4'),(21,'zs4','8.0',1,NULL,'116',5,NULL,'钻石4-钻石3'),(22,'zs3','9.0',1,NULL,'117',5,NULL,'钻石3-钻石2'),(23,'zs2','9.0',1,NULL,'118',5,NULL,'钻石2-钻石1'),(24,'zs1','12.0',1,NULL,'119',5,NULL,'钻石1-星耀5'),(25,'xy5','13.0',1,NULL,'120',5,NULL,'星耀5-星耀4'),(26,'xy4','14.0',1,NULL,'121',5,NULL,'星耀4-星耀3'),(27,'xy3','15.0',1,NULL,'122',5,NULL,'星耀3-星耀2'),(28,'xy2','16.0',1,NULL,'123',5,NULL,'星耀2-星耀1'),(29,'xy1','17.0',1,NULL,'124',5,NULL,'星耀1-王者1星'),(30,'wz1','40.0',1,NULL,'125',10,NULL,'王者1星-王者10星'),(31,'wz2','50.0',1,NULL,'126',10,NULL,'王者11星-王者20星'),(32,'wz3','70.0',1,NULL,'127',10,NULL,'王者21星-王者30星'),(33,'wz4','90.0',1,NULL,'128',10,NULL,'王者31星-王者40星'),(34,'wz5','100.0',1,NULL,'129',10,NULL,'王者41星-王者50星'),(35,'wz6','160.0',1,NULL,'130',10,NULL,'王者51星-王者60星'),(36,'wz7','170.0',1,NULL,'131',10,NULL,'王者61星-王者70星'),(37,'wz8','200.0',1,NULL,'132',10,NULL,'王者71星-王者80星'),(38,'wz9','400.0',1,NULL,'133',10,NULL,'王者81星-王者90星'),(39,'wz10','400.0',1,NULL,'134',10,NULL,'王者91星-王者100星'),(40,'wz11','500.0',1,NULL,'135',10,NULL,'王者101星-王者110星'),(41,'wz12','600.0',1,NULL,'136',10,NULL,'王者111星-王者120星'),(42,'wz13','600.0',1,NULL,'137',10,NULL,'王者121星-王者130星'),(43,'wz14','600.0',1,NULL,'138',10,NULL,'王者131星-王者140星'),(44,'wz15','600.0',1,NULL,'139',10,NULL,'王者141星-王者150星'),(45,'王者荣耀',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,'1','4.0',NULL,'2','140',5002,'','23'),(47,'2','4.0',NULL,'2','140',500,'','23');

/*Table structure for table `glory_server` */

DROP TABLE IF EXISTS `glory_server`;

CREATE TABLE `glory_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `server_addition` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `glory_server` */

insert  into `glory_server`(`id`,`server_name`,`server_addition`) values (1,'安卓QQ区','1.0'),(2,'安卓微信区','1.1'),(3,'苹果QQ区','1.1'),(4,'苹果微信区','1.2');

/*Table structure for table `inscription` */

DROP TABLE IF EXISTS `inscription`;

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etc` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `addition` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `inscription_num` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `inscription` */

insert  into `inscription`(`id`,`etc`,`addition`,`inscription_num`) values (1,'qt','1.05',0),(2,'qt','1.03',51),(3,'qt','1.02',101),(4,'qt','1.01',121),(5,'qt','1.0',141),(6,'by','1.05',0),(7,'by','1.03',51),(8,'by','1.02',101),(9,'by','1.01',121),(10,'by','1.0',141),(11,'hj','1.1',0),(12,'hj','1.1',51),(13,'hj','1.1',101),(14,'hj','1.1',121),(15,'hj','1.0',141),(16,'bj','1.1',0),(17,'bj','1.1',51),(18,'bj','1.1',101),(19,'bj','1.1',121),(20,'bj','1.0',141),(21,'zs','1.5',0),(22,'zs','1.35',51),(23,'zs','1.25',101),(24,'zs','1.15',121),(25,'zs','1.0',141),(26,'xy','1.5',0),(27,'xy','1.35',51),(28,'xy','1.25',101),(29,'xy','1.15',121),(30,'xy','1.0',141),(31,'wz','1.6',0),(32,'wz','1.4',51),(33,'wz','1.2',101),(34,'wz','1.1',121),(35,'wz','1.0',141),(36,NULL,NULL,NULL);

/*Table structure for table `speechcraft` */

DROP TABLE IF EXISTS `speechcraft`;

CREATE TABLE `speechcraft` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `speechcraft` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `speechcraft` */

insert  into `speechcraft`(`id`,`name`,`speechcraft`) values (1,'王者荣耀','新赛季，新开始，孙氏网游竭诚为您服务！\n普通订单0-5小时左右上号。\n加急单0-3小时左右开始代练！\n开打和完单都会短信通知您！\n孙氏专注王者代练，千名签约百星荣耀打手\n---------------孙氏网游专营店---------------\n上千名百星级高素质代练----期待能为您效劳！'),(2,NULL,'4'),(3,NULL,'334');

/*Table structure for table `sys_short_word` */

DROP TABLE IF EXISTS `sys_short_word`;

CREATE TABLE `sys_short_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shortword` varchar(2048) DEFAULT NULL,
  `typeid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `sys_short_word` */

insert  into `sys_short_word`(`id`,`shortword`,`typeid`) values (1,'快捷语A',1),(2,'快捷语B',1),(3,'快捷语C',1),(4,'快捷语D',1),(5,'快捷语E',1),(6,'快捷语F',1),(7,'快捷语G',1),(8,'快捷语：呵呵哒！哥哥 咱们是代抽的哈 收取99元的服务费哦 （抽取期间需要您每天自备点券2700点）',1),(9,'快捷语：生活！！！',1),(10,'快捷语：人生！！！',1),(11,'快捷语11',1),(12,'快捷语12',1),(13,'快捷语13',1),(14,'快捷语14',1),(15,'快捷语15',1),(16,'快捷语16',1),(17,'快捷语17',1),(18,'快捷语18',1),(19,'快捷语19',1);

/*Table structure for table `sys_treemenu` */

DROP TABLE IF EXISTS `sys_treemenu`;

CREATE TABLE `sys_treemenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(32) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;

/*Data for the table `sys_treemenu` */

insert  into `sys_treemenu`(`id`,`url`,`name`,`parent`,`icon`) values (1,'/user/LogOut','客户进门',0,'leftico04.png'),(2,'/user/LogOut','自动回复',0,'leftico01.png'),(5,'/user/labWeekSet','首次问候',0,'leftico04.png'),(8,'/user/LogOut','报价',0,'leftico03.png'),(12,'','介绍优势',0,'leftico02.png'),(15,'/user/Test','1分钟追问',0,'leftico04.png'),(21,'','3分钟追问',0,'leftico04.png'),(24,'/user/LogOut','5分钟追问',0,'leftico04.png'),(1001,NULL,'一小时回访',0,NULL),(1002,NULL,'下单',0,NULL),(1003,NULL,'核对信息',0,NULL),(1004,NULL,'录入订单',0,NULL),(1005,NULL,'关注，收藏',0,NULL),(1006,NULL,'送客',0,NULL),(1007,NULL,'回访昨日未下单',0,NULL),(1008,NULL,'下班回访介绍自己',0,NULL),(1009,NULL,'总结',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
