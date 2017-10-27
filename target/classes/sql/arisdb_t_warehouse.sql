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
-- Table structure for table `t_warehouse`
--

DROP TABLE IF EXISTS `t_warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_warehouse` (
  `id` varchar(5) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `tel` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_warehouse`
--

LOCK TABLES `t_warehouse` WRITE;
/*!40000 ALTER TABLE `t_warehouse` DISABLE KEYS */;
INSERT INTO `t_warehouse` VALUES ('OSK01','難波第一倉庫',900,'大阪府大阪市中央区難波1-11-111','0611111111'),('OSK02','難波第二倉庫',700,'大阪府大阪市中央区難波2-22-22','0622222222'),('TKY01','涩谷第二仓库',1000,'東京都東京都渋谷区宇田川町123-444-567','0311111111'),('TKY02','涩谷第二仓库',800,'東京都渋谷区渋谷5-55-55','0322222222'),('TKY03','台場第一倉庫',700,'東京都港区台場1-2-3456','0333333333'),('TKY04','台場第二倉庫',500,'東京都港区台場7-7-777','0344444444');
/*!40000 ALTER TABLE `t_warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-23 16:05:31
