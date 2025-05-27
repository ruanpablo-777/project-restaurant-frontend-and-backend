CREATE DATABASE  IF NOT EXISTS `testeendereco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `testeendereco`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: testeendereco
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `isAcoolica` tinyint(1) DEFAULT NULL,
  `volume` varchar(50) DEFAULT NULL,
  `acompanhamento` varchar(100) DEFAULT NULL,
  `isVegan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `idade` int NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `endereco_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `endereco_id` (`endereco_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheiro.dev@gmail.com','12312333',0),(2,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheirodsdsfsdf.dev@gmail.com','1233333',2),(3,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheiro3dsdsfsdf.dev@gmail.com','1233333',3),(4,'Ruan P2223ablo Machado Pinheiro',22,'ruan.pinhe3223iro3dsdsfsdf.dev@gmail.com','123333323222',4),(5,'Ruan Pablo',12,'ToyaMON777@outlook.com','saas',5),(6,'Ruan Pablo',12,'ruanzito@gmail','000000',6),(7,'Ruan Pablo',12,'ruanzito@gmail.com','55555',7);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comida`
--

DROP TABLE IF EXISTS `comida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `tipo` enum('pratoPrincipal','bebida','sobremesa') NOT NULL,
  `isAlcoolica` tinyint(1) DEFAULT NULL,
  `volume` varchar(50) DEFAULT NULL,
  `acompanhamento` varchar(100) DEFAULT NULL,
  `isVegan` tinyint(1) DEFAULT NULL,
  `imagens` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comida`
--

LOCK TABLES `comida` WRITE;
/*!40000 ALTER TABLE `comida` DISABLE KEYS */;
INSERT INTO `comida` VALUES (1,'Cerveja','Cerveja gelada',8.00,'bebida',1,'600ml',NULL,NULL,'https://i.pinimg.com/736x/3d/7e/0e/3d7e0ef489331b95e653239334b12e9e.jpg'),(2,'Bife Acebolado','Bife com cebola',25.00,'pratoPrincipal',NULL,NULL,NULL,NULL,'https://i.pinimg.com/736x/7f/5e/cf/7f5ecfbe1729478003c199a250fbb641.jpg'),(3,'Pudim','Pudim de leite condensado',10.00,'sobremesa',NULL,NULL,NULL,NULL,'https://i.pinimg.com/736x/cd/e2/2f/cde22f87de022714c90ec943884f06bf.jpg'),(4,'Suco','Suco de Laranja',3.00,'bebida',0,'500ml',NULL,NULL,'https://i.pinimg.com/736x/9e/c8/68/9ec86885e9dc5f96466a2b9228b87253.jpg'),(5,'Frango','Frango Empanado',25.00,'pratoPrincipal',NULL,NULL,NULL,NULL,'https://i.pinimg.com/736x/f0/11/0b/f0110b07a520c5fba692d9475cc40962.jpg'),(6,'Açai','Açai com leite condensado e banana',15.00,'sobremesa',NULL,NULL,NULL,NULL,'https://i.pinimg.com/736x/bb/39/2a/bb392a7fa2c9cfc34146a171581501c1.jpg');
/*!40000 ALTER TABLE `comida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(10) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `numero` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'88160768','Biguaçu - SC','Bom Viver','homero','2222'),(2,'88160768','Biguaçu - SC','Bom Viver','homero','2222'),(3,'88160768','Biguaçu - SC','Bom Viver','homero','2222'),(4,'881607268','Biguaçu2 - SC','Bom Vive2r','homero','22223'),(5,'32323232','Biguaçu - SC','Bom Viver','homero','2222'),(6,'32323232','Biguaçu - SC','Bom Viver','homero','2222'),(7,'32323232','Biguaçu - SC','Bom Viver','homero','2222');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pratoprincipal`
--

DROP TABLE IF EXISTS `pratoprincipal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pratoprincipal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pratoprincipal`
--

LOCK TABLES `pratoprincipal` WRITE;
/*!40000 ALTER TABLE `pratoprincipal` DISABLE KEYS */;
/*!40000 ALTER TABLE `pratoprincipal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `avaliacao` decimal(3,2) NOT NULL,
  `endereco_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `endereco_id` (`endereco_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sobremesa`
--

DROP TABLE IF EXISTS `sobremesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sobremesa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sobremesa`
--

LOCK TABLES `sobremesa` WRITE;
/*!40000 ALTER TABLE `sobremesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `sobremesa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-27  2:08:33
