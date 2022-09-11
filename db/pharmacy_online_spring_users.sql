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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9q63snka3mdh91as4io72espi` (`phone_number`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2022-07-20 17:23:17.775000',NULL,0,'2022-07-20 17:23:17.775000',NULL,'Qui velit dolore dic','Nguyen Dai Triet','$2a$10$QjzOIVubRI0S294Xe428Z.KtRk99UHnbwD5DM2tpQQRbOxAtcKBFu','+1 (891) 179-2936','triet123@gmail.com',2),(2,'2022-07-21 14:09:46.852000',NULL,0,'2022-07-21 14:09:46.852000',NULL,'Ipsam reiciendis est','Nayda Terry','$2a$10$fQn9W1/ly9.PxFkOdxFOmeQTxtWz9Cz1AJ1RA7HkdG043anM6.oRq','+1 (287) 533-4752','tiwymajuva@mailinator.com',1),(3,'2022-07-21 14:21:52.760000',NULL,0,'2022-07-21 14:21:52.760000',NULL,'In quia velit est p','Heidi Miller','$2a$10$aa64CytPwCOrNf.plECXJu0fpTvbyE5KquB1HZiycqJAAtmARfS4G','+1 (738) 134-7356','nemetifacy@mailinator.com',1),(4,'2022-07-21 14:22:00.890000',NULL,0,'2022-07-21 14:22:00.890000',NULL,'Animi deleniti fugi','Peter Barrett','$2a$10$qL07eJ9YDEG8n/Z/90KOwecovRL/b5SKJlV6TRs2WkbCbD.MCIW7e','+1 (597) 186-7122','ruto@mailinator.com',1),(6,'2022-07-21 17:23:23.090000',NULL,0,'2022-07-21 17:23:23.090000',NULL,'Minus excepturi do e','Bertha Hypoth','$2a$10$dEc50pmKBxDZ6SOTJVz8Ueibzm3JtnGO9EJtKQo3C9tjU4166VESm','+81 (173) 193-6688','admin@mail.com',2),(7,'2022-07-21 22:57:44.144000',NULL,0,'2022-07-21 22:57:44.144000',NULL,'Fuga Mollitia aut n','Ori Parker','$2a$10$cEA1y4qmIRa2yGxTrxOt3eGgBQf2msNEDFmH5enspyQZ9aer4ADaq','+1 (328) 741-6573','cateqohube@mailinator.com',1),(8,'2022-07-22 09:32:38.522000',NULL,0,'2022-07-22 09:32:38.522000',NULL,'','Kirestin Fox','$2a$10$MiYi62vtblA7t6LGx6KwcuO/Sua0klJVLLOIxFCXpTEXH0vJ7Q1hK','+1 (104) 966-1339','sogakupo@mailinator.com',2),(9,'2022-07-22 09:40:07.681000',NULL,0,'2022-07-22 09:40:07.681000',NULL,'Obcaecati ipsam quia','Rachel Huff','$2a$10$B.dKPjBs6y3IgxRsVcB/VO0V5ddv53Q2pXiT/JxX/SINjCMbtlNvq','+1 (374) 903-9661','gevitahaqo@mailinator.com',2),(10,'2022-07-22 10:11:07.218000',NULL,0,'2022-07-22 10:11:07.218000',NULL,'Aut quam consequatur','Armand Russell','$2a$10$b7oWrr7rTklvGtAQ49HynetdShKgJCUQmyM3yhdBjkTgTpqKiVEWK','+1 (405) 655-2288','triet@mail.com',1),(11,'2022-07-22 14:58:15.440000',NULL,0,'2022-07-22 14:58:15.441000',NULL,'','Wendy Snow','$2a$10$KB5uQiarEgv/yPHj5ANus.5XywvU0WkHElYpNHwPtLSk6/fMk4wbC','','jolew@mailinator.com',2),(12,'2022-09-04 09:00:20.657000',NULL,0,'2022-09-04 09:00:20.657000',NULL,'Id ea nesciunt expl','Margaret Reese','$2a$10$AscY4FE97xYJtKKRWPEueO3/pP.4bZ/SIRlNxH1alKucC.xBibxtG','+1 (608) 705-2222','tr@main.com',1),(13,'2022-09-04 09:03:11.276000',NULL,0,'2022-09-04 09:03:11.276000',NULL,'Numquam est soluta p','Lila Serrano','$2a$10$bka0Rn1c8lisOm8gOrhd2.2pujdAYzMLL9FQlAhOJJnMFKRcCplUe','+1 (659) 391-4048','gatonys@mailinator.com',2),(14,'2022-09-04 09:03:37.521000',NULL,0,'2022-09-04 09:03:37.521000',NULL,'Nihil elit quia exp','Hanae Hickman','$2a$10$5uebWMon/0Sx6C8pNbv.1OWWGInAAxkx58iqynsnb0LuHh./sHwMK','+1 (665) 904-5226','byberuv@mailinator.com',2),(15,'2022-09-11 19:27:15.035000',NULL,0,'2022-09-11 19:27:15.035000',NULL,'Inventore est ut di','Piper Bradshaw','$2a$10$3ZJj.t8A9jj7RttX5yOHAO9zgyMDd21ctPGrsCIPxhcAE4qgZNEh6','+1 (133) 238-6233','losiwole@mailinator.com',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
