-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy_online_spring
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drugs`
--

DROP TABLE IF EXISTS `drugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drugs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `drug_content` double NOT NULL,
  `drug_name` varchar(100) NOT NULL,
  `drug_usage` varchar(255) DEFAULT NULL,
  `expiration_date` date NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `price_per_unit` decimal(12,0) NOT NULL,
  `production_date` date NOT NULL,
  `quantity` int NOT NULL,
  `dosage_form_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3m25na93a5hbh52x20gkaipfn` (`dosage_form_id`),
  CONSTRAINT `FK3m25na93a5hbh52x20gkaipfn` FOREIGN KEY (`dosage_form_id`) REFERENCES `dosage_forms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugs`
--

LOCK TABLES `drugs` WRITE;
/*!40000 ALTER TABLE `drugs` DISABLE KEYS */;
INSERT INTO `drugs` VALUES (1,'2022-07-18 14:05:06.652000',NULL,1,'2022-07-18 14:05:06.652000',NULL,43,'Rhoda Moran','Dolore esse adipisic','2022-07-19','Laboriosam consecte',907,'2022-07-17',328,1),(2,'2022-07-18 14:11:11.292000',NULL,0,'2022-07-18 14:11:11.292000',NULL,12,'Ulysses Harrington','Ea velit voluptas si','2022-07-19','Velit quia ut minus',501,'2022-07-17',293,3),(3,'2022-07-18 16:47:43.879000',NULL,0,'2022-07-18 16:47:43.879000',NULL,91,'Dakota Bright','Eos aut repellendus','2024-12-27','Ipsa consequat Dig',405,'2022-02-18',954,4),(4,'2022-07-18 16:49:44.980000',NULL,1,'2022-07-18 16:49:44.980000',NULL,72,'Nolan Gould','Debitis quos odio la','2023-03-12','Quasi voluptatum qui',377,'2021-05-02',243,1),(5,'2022-07-18 17:01:50.652000',NULL,0,'2022-07-18 17:01:50.652000',NULL,100,'Daphne Dalton','Doloremque ipsam non','2024-10-25','Quia est cum dolorem',744,'2021-07-18',180,4),(6,'2022-07-18 17:22:11.352000',NULL,0,'2022-07-18 17:22:11.352000',NULL,38,'Cairo Hewitt','Dolor qui omnis ulla','2023-10-21','Fugit a repudiandae',788,'2021-07-18',907,4),(7,'2022-07-18 17:22:34.221000',NULL,1,'2022-07-18 17:22:34.221000',NULL,43,'Quinn Steele','Consectetur adipisic','2023-04-25','Nulla asperiores num',324,'2021-09-17',649,4),(8,'2022-07-18 17:24:08.102000',NULL,0,'2022-07-18 17:24:08.102000',NULL,19,'Jared Rush','Enim sed Nam aliquid','2023-04-22','Aut quas alias omnis',385,'2021-02-01',145,3),(15,'2022-07-19 11:57:51.116000',NULL,0,NULL,NULL,500,'Paracetamol','Aut ut excepteur atq','2023-06-20','Culpa odio veniam i',415,'2021-09-21',217,4),(16,'2022-07-19 13:34:19.910000',NULL,1,NULL,NULL,5.6,'Hexadetromine','Deserunt sit sunt','2023-04-02','Totam qui excepturi',15000,'2022-01-02',500,2),(17,'2022-07-19 13:39:52.756000',NULL,1,NULL,NULL,79,'AminoDehydrate','Dolor nisi repudiand','2022-09-20','Vel qui fugiat verit',684,'2021-07-19',965,4),(18,'2022-07-19 13:54:41.668000',NULL,1,NULL,NULL,45.5,'Otrigamelon','Consectetur commodo','2023-01-09','Est sint laudantium',511,'2022-02-12',748,3),(19,'2022-07-22 14:59:56.803000',NULL,0,NULL,NULL,500,'Vitamin E','Fugiat ab quidem lab','2024-04-07','Nihil voluptas rerum',1000,'2021-06-03',500,1);
/*!40000 ALTER TABLE `drugs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-11 19:36:11
