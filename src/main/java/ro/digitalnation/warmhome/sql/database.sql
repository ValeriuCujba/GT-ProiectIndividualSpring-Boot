CREATE DATABASE  IF NOT EXISTS `warm-home` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `warm-home`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: warm-home
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `id` bigint NOT NULL,
  `nume` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Iasi','Iasi.jpg'),(2,'Cluj','cluj-1.jpg'),(52,'Chisinau','chisinau.jpg'),(102,'Brasov','brasov-romania.jpg');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities_seq`
--

DROP TABLE IF EXISTS `cities_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities_seq`
--

LOCK TABLES `cities_seq` WRITE;
/*!40000 ALTER TABLE `cities_seq` DISABLE KEYS */;
INSERT INTO `cities_seq` VALUES (651);
/*!40000 ALTER TABLE `cities_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `properties` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pret` double DEFAULT NULL,
  `suprafata` varchar(255) DEFAULT NULL,
  `titlu` varchar(255) DEFAULT NULL,
  `city_id` bigint NOT NULL,
  `tip` varchar(255) DEFAULT NULL,
  `images_names` varbinary(255) DEFAULT NULL,
  `descriere` varchar(2000) DEFAULT NULL,
  `property_ad_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk566k4d814s2e8gne83deonc0` (`city_id`),
  KEY `FKktgkh3po2sbfivddqnpiqqk6c` (`property_ad_id`),
  CONSTRAINT `FKk566k4d814s2e8gne83deonc0` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`),
  CONSTRAINT `FKktgkh3po2sbfivddqnpiqqk6c` FOREIGN KEY (`property_ad_id`) REFERENCES `property_ads` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (12,3000,'40','Apartament 2 camere',1,'Apartment',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0	img-2.jpgt\0	img-3.jpgt\0	img-4.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce lectus magna, vestibulum vitae tristique ac, ullamcorper in tortor. Nullam vehicula bibendum finibus. Praesent magna elit, euismod at nulla quis, egestas euismod elit. Quisque tempus, sem vel porttitor dignissim, est sapien accumsan mauris, vitae ultrices velit purus ut mi. Praesent auctor velit non semper rutrum. Nulla pharetra libero id viverra convallis. Vestibulum quis arcu quis orci blandit pulvinar. In porta lobortis sapien ac rhoncus. Nunc aliquam consectetur nunc, ut vehicula libero ullamcorper a.\r\n\r\nDonec sagittis, tortor vitae consequat ullamcorper, lectus libero blandit mi, non pulvinar ipsum ante eget enim. Etiam finibus fringilla tempus. Duis mollis non ligula vitae fermentum. Morbi egestas ullamcorper magna vel eleifend. Phasellus vitae urna in purus vulputate lobortis. Morbi ornare tincidunt finibus. Phasellus at mauris sed neque ullamcorper feugiat. Donec sem dolor, efficitur vel imperdiet in, tristique id erat.\r\n',5),(13,300,'400','Apartament nou',1,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0douglas-sheppard.jpgt\0francesca-tosolini-unsplash.jpgt\0	img-1.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris pharetra id diam vel scelerisque. Mauris faucibus ut turpis ac ornare. Morbi tincidunt lobortis lorem, et commodo lorem convallis eu. Praesent quis erat ac ex sollicitudin aliquet quis sit amet nibh. Cras ac mauris eu diam interdum accumsan. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Phasellus consectetur sapien vel dapibus iaculis. Sed tempor tristique nisi, eget cursus augue mattis varius. Donec scelerisque imperdiet porttitor. Cras at lectus id nibh blandit laoreet. Vivamus eget hendrerit turpis. Sed rutrum, nisl in mattis mattis, nibh orci congue erat, et dignissim velit felis vel metus. Nulla mattis a augue quis mattis. Nulla dignissim, justo sed finibus consequat, tellus nulla fringilla purus, sed pellentesque nibh sem vel est. Proin eget sem nec lacus hendrerit tristique nec id elit. Sed leo metus, malesuada ac nibh eget, blandit molestie dolor.\r\n\r\nQuisque dictum tempus lorem at tincidunt. Nulla id turpis a libero aliquet vehicula sed ac purus. Nulla facilisi. Integer vulputate sagittis dui id porta. Pellentesque nunc nisi, sagittis vitae risus vitae, pharetra placerat arcu. Donec at massa posuere, fermentum lacus nec, tristique lorem. Praesent euismod placerat ligula, ut rhoncus lacus tristique id. Suspendisse eu sem et orci feugiat tempor congue quis orci. Nam ut erat ac tortor elementum finibus quis vel mauris.\r\n\r\nMorbi ac auctor diam. Suspendisse eget dolor ac urna auctor ullamcorper. Mauris ac nisl nec urna finibus eleifend. Ut auctor purus dui, eget eleifend libero blandit sollicitudin. Pellentesque aliquet, enim nec tincidunt mattis, tortor eros mollis augue, non tincidunt metus ante faucibus turpis. Cras non justo eget mi convallis laoreet et nec nunc. Phasellus vitae tellus in quam dignissim rutrum eget feugiat ipsum. Phasellus id orci tristique, rutrum erat lobortis, eleifend leo.\r\n\r\n',8),(21,350,'400','Casa la tara',1,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0bailey-anselme.jpgt\0	img-5.jpgt\0	img-6.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',17),(22,444,'405','Casa noua',1,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0	img-5.jpgt\0ionut-vlad-unsplash.jpgt\0\Zkrystal-black-unsplash.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',18),(23,398,'48','Apartament zona buna',52,'Apartment',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\Zkrystal-black-unsplash.jpgt\0naomi-hebert-unsplash.jpgt\0pexels-curtis-adams-3288100.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',19),(24,400,'405','Casa veche',52,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\"pexels-binyamin-mellish-106399.jpgt\0pexels-ilya-shakir-2440471.jpgt\0pexels-jason-boyd-3209045.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',20),(25,350,'400','Casa noua buna de mutat',102,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0#pexels-binyamin-mellish-1396132.jpgt\0pexels-jason-boyd-3209045.jpgt\0&pexels-jean-van-der-meulen-1457842.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',21),(26,230,'32,45','Apartament',102,'Apartment',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0pexels-pixabay-276554.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',22),(27,350,'56','Casa 3 camere',102,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0&pexels-jean-van-der-meulen-1457842.jpgt\0 pexels-mark-mccammon-1080696.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',23),(28,3000,'400','Casa veche',102,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\"pexels-vecislavas-popa-1643383.jpgt\0\Zroam-in-color-unsplash.jpgt\0\Zronnie-george-unsplash.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',24),(29,300,'40','Apartament',102,'Apartment',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\"pexels-vecislavas-popa-1571458.jpgt\0\"pexels-vecislavas-popa-1571460.jpgt\0\"pexels-vecislavas-popa-1643383.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',25),(30,325,'47','Apartament 2 camere',2,'Apartment',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\"pexels-vecislavas-popa-1571453.jpgt\0\"pexels-vecislavas-popa-1571458.jpgt\0\Zroam-in-color-unsplash.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',26),(31,350,'40','Casa buna',2,'House',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0bailey-anselme.jpgt\0douglas-sheppard.jpgt\0francesca-tosolini-unsplash.jpgx','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac magna eget magna pharetra tincidunt vel id diam. Aenean nec commodo magna. Nulla eget maximus nisi, porttitor tincidunt eros. Morbi mi nunc, volutpat mattis fringilla et, ultrices at metus. Integer augue eros, pellentesque ac mi id, ultricies luctus libero. Aenean consectetur mollis purus. Cras quis sodales nulla. Sed ac ipsum ac tellus sagittis porttitor. Curabitur elementum arcu ac mi dapibus, eget sagittis mi finibus.\r\n\r\nDonec vestibulum lorem quis odio pretium luctus. Vivamus vel rutrum erat, nec efficitur eros. Duis et urna placerat, tristique ex eget, blandit tortor. Nulla tempus vehicula tortor, at malesuada ex ornare sed. Aliquam fringilla velit nec mauris auctor scelerisque. Ut leo mi, scelerisque ac cursus vel, maximus sed justo. Suspendisse ut elit blandit, dapibus elit vel, varius velit. Nunc sollicitudin ipsum turpis, eu maximus ex ullamcorper ac. Proin lacinia consequat finibus. Aenean et massa vel lacus malesuada placerat quis ut dui. Cras vel lorem et massa accumsan pharetra. Vivamus efficitur quam et urna mattis, eu ultrices nunc ultricies.\r\n\r\nNulla nec leo luctus, feugiat nunc at, varius massa. Nulla hendrerit consectetur nisl. Sed fringilla euismod nisi, eu pulvinar turpis efficitur ac. Vestibulum ante ipsum primis in faucibus.',27);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_ads`
--

DROP TABLE IF EXISTS `property_ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property_ads` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_postarii` date DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_ads`
--

LOCK TABLES `property_ads` WRITE;
/*!40000 ALTER TABLE `property_ads` DISABLE KEYS */;
INSERT INTO `property_ads` VALUES (1,'2022-12-09',NULL),(3,'2022-12-09',NULL),(5,'2022-12-15','0744444444'),(8,'2022-12-15','0744444455'),(17,'2022-12-20','0744444444'),(18,'2022-12-20','0744441111'),(19,'2022-12-20','0744441110'),(20,'2022-12-20','0744441110'),(21,'2022-12-20','0744444455'),(22,'2022-12-20','0744444455'),(23,'2022-12-20','0744444455'),(24,'2022-12-20','0744444455'),(25,'2022-12-20','0744444455'),(26,'2022-12-20','0745784111'),(27,'2022-12-20','0745784111');
/*!40000 ALTER TABLE `property_ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'john@gmail.com','$2a$10$.AcZ5Y2rJlmR/9HGe/ty.udlQ/e6ffNsitMePtkRrKRedgNJcrgY2','John Cena'),(4,'admin@gmail.com','$2a$10$0gqSWYUn27N9syT1u66gI.CBXwlhTCBwR6HCtmNS4UnR6LyNrmZ4C','Admin Admin'),(5,'valeriu@gmail.com','$2a$10$I2uSEaU0sDb52mJkSUCSie9wV69RPwyig0YzSJJCyqu2zt.2Fgc1.','Valeriu Cujba'),(6,'cujba@gmail.com','$2a$10$bzSwM5bTe4E54mC6yzzi5.po72E4co4kEEbpaZ1Ux5Mkfb/8iVoLS','Valeriu Cujba'),(7,'elena@gmail.com','$2a$10$wainxbP.TtXHABsnl27cGuW42SY3HkfHwsnhhNgkHYSeO.q2DESJq','Elena Cena');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (3,1),(4,2),(5,1),(6,1),(7,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-20 23:07:53
