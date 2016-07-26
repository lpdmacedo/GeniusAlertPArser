-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: genius
-- ------------------------------------------------------
-- Server version	5.7.12

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

DROP SCHEMA IF EXISTS `genius`;
CREATE SCHEMA `genius` DEFAULT CHARACTER SET utf8 ;
USE genius;

DROP TABLE IF EXISTS `physical_host`;
CREATE TABLE `physical_host` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `_id` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `instance` VARCHAR(45) NULL,
  `pool` LONGTEXT NULL,
  `host` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `description` LONGTEXT NULL,
  `from` VARCHAR(45) NULL,
  `to` VARCHAR(45) NULL,
  `ignored` VARCHAR(45) NULL,
  `created_at` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `datadog`
--

DROP TABLE IF EXISTS `datadog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datadog` (
  `_id` varchar(45) DEFAULT NULL,
  `body` longtext,
  `last_updated` varchar(45) DEFAULT NULL,
  `event_type` varchar(45) DEFAULT NULL,
  `title` longtext,
  `id` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `url` longtext,
  `ignored` varchar(45) DEFAULT NULL,
  `created_at` varchar(45) DEFAULT NULL,
  `datadogcol` varchar(45) DEFAULT NULL,
  `idDataDog` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idDataDog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `_id` varchar(50) DEFAULT NULL,
  `related_links` longtext,
  `events` longtext,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `melicloud`
--

DROP TABLE IF EXISTS `melicloud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `melicloud` (
  `_id` varchar(255) DEFAULT NULL,
  `alerted_instances` varchar(255) DEFAULT NULL,
  `app` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `datacenter` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `gav` varchar(255) DEFAULT NULL,
  `ignored` varchar(255) DEFAULT NULL,
  `instance_count` varchar(255) DEFAULT NULL,
  `pool` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `serv` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `newrelic`
--

DROP TABLE IF EXISTS `newrelic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newrelic` (
  `_id` varchar(45) DEFAULT NULL,
  `alert_policy_name` longtext,
  `application_name` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  `ignored` varchar(45) DEFAULT NULL,
  `opened_at` varchar(45) DEFAULT NULL,
  `long_description` longtext,
  `short_description` longtext,
  `created_at` varchar(45) DEFAULT NULL,
  `open_since` varchar(45) DEFAULT NULL,
  `alert_url` longtext,
  `severity` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `account_name` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `_id` varchar(45) DEFAULT NULL,
  `alias` longtext,
  `recipients` varchar(45) DEFAULT NULL,
  `teams` varchar(45) DEFAULT NULL,
  `message` longtext,
  `source` varchar(45) DEFAULT NULL,
  `provider` varchar(45) DEFAULT NULL,
  `status_code` varchar(45) DEFAULT NULL,
  `alert_id` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tags` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-12 12:28:06
