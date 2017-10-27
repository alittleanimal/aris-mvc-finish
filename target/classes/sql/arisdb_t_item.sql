-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: arisdb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_item`
--

DROP TABLE IF EXISTS `t_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_item` (
  `id` int(11) NOT NULL,
  `ean_code` char(13) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  `region_code` char(1) DEFAULT NULL,
  `language` varchar(16) DEFAULT NULL,
  `number_of_discs` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `package_img_path` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_item_ukey` (`ean_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_item`
--

LOCK TABLES `t_item` WRITE;
/*!40000 ALTER TABLE `t_item` DISABLE KEYS */;
INSERT INTO `t_item` VALUES (1,'4988142580726','虎胆龙威4.0','2','English',1,1200,'2013-01-01','/resources/img/dvd/die_hard_4.jpg'),(2,'4988135831729','哈利波特和神秘的王子','2','English',2,2000,'2012-02-02','/resources/img/dvd/harry_potter.jpg'),(3,'4988021138543','鲁邦三世vs名侦探柯南','1','Japanese',1,1500,'2011-10-10','/resources/img/dvd/lupin_vs_conan.jpg'),(4,'4547462084750','霹雳娇娃','2','English',1,1600,'2010-05-05','/resources/img/dvd/charlies_angels.jpg');
/*!40000 ALTER TABLE `t_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-23 16:05:30
