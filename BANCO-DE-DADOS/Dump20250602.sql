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
  `isAlcoolica` tinyint(1) DEFAULT NULL,
  `volume` varchar(50) DEFAULT NULL,
  `acompanhamento` varchar(100) DEFAULT NULL,
  `isVegan` tinyint(1) DEFAULT NULL,
  `imagens` varchar(255) DEFAULT NULL,
  `avaliacao` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `bebida_chk_1` CHECK (((`avaliacao` >= 1) and (`avaliacao` <= 5)))
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (1,'suco de laranja',10.00,0,'500ml',NULL,NULL,'https://i.pinimg.com/736x/9e/c8/68/9ec86885e9dc5f96466a2b9228b87253.jpg',4.2),(2,'Refrigerante Guaraná',6.50,0,'350ml','Batata frita',1,'https://i.pinimg.com/736x/39/31/63/3931637bb5aceba1f4aea2ad126248e4.jpg',3.6),(3,'Cerveja Corona',8.00,1,'600ml','Porção de amendoim',1,'https://i.pinimg.com/736x/07/d6/ff/07d6ff7cf764838c9074bfcb50a6725e.jpg',2.5),(4,'Vinho Tinto Seco',25.00,1,'750ml','Tábua de frios',0,'https://i.pinimg.com/736x/44/9b/4d/449b4d0186602b22e923c271b23d0755.jpg',5),(5,'Suco de Morango',9.00,0,'500ml','Pão de queijo',0,'https://i.pinimg.com/736x/48/18/e5/4818e51392e79d1f754fdb90495571ef.jpg',1.7);
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
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheiro.dev@gmail.com','12312333',0),(2,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheirodsdsfsdf.dev@gmail.com','1233333',2),(3,'Ruan Pablo Machado Pinheiro',18,'ruan.pinheiro3dsdsfsdf.dev@gmail.com','1233333',3),(4,'Ruan P2223ablo Machado Pinheiro',22,'ruan.pinhe3223iro3dsdsfsdf.dev@gmail.com','123333323222',4),(5,'Ruan Pablo',12,'ToyaMON777@outlook.com','saas',5),(6,'Ruan Pablo',12,'ruanzito@gmail','000000',6),(7,'Ruan Pablo',12,'ruanzito@gmail.com','55555',7),(8,'Ruan Pablo',12,'ruan@gmail.com','11111',8),(9,'ruan',12,'r@gmail.com','12345',9),(10,'ruanzito',19,'zito@gmail.com','senha321',19),(12,'carlos',14,'carlos@gamil.com','123123',22),(13,'ber',40,'ber@gmail.com','2323',23),(14,'joseeeee',45,'j@gmail.com','55555',24);
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
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'88160768','Biguaçu - SC','Bom Viver','homero','2222',NULL),(2,'88160768','Biguaçu - SC','Bom Viver','homero','2222',NULL),(3,'88160768','Biguaçu - SC','Bom Viver','homero','2222',NULL),(4,'881607268','Biguaçu2 - SC','Bom Vive2r','homero','22223',NULL),(5,'32323232','Biguaçu - SC','Bom Viver','homero','2222',NULL),(6,'32323232','Biguaçu - SC','Bom Viver','homero','2222',NULL),(7,'32323232','Biguaçu - SC','Bom Viver','homero','2222',NULL),(8,'32','saojose - SC','janaina','augusto','1111','bigua'),(9,'123123','riozinho','carioca','rua do futebol','1222','rio de janeiro'),(10,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(11,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(12,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(13,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(14,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(15,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(16,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(17,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(18,'123123','riozinho','carioca','rua do futebol','1222','rio de janeiro'),(19,'2323','saojose','biguu','rua da manqueira','234234','santa monica'),(20,'123123','riozinho','carioca','rua do futebol','1222','rio de janeiro'),(21,'123123','riozinho','carioca','rua do futebol','1222','rio de janeiro'),(22,'22222','Biguaçu','Bom Viver','rua ausgusto pereira','43','Santa Catarina'),(23,'22222','Biguaçu','Bom Viver','rua da mangueira','43','Santa Catarina'),(24,'22222','Biguaçu','Bom Viver','rua da mangueira','43','Santa Catarina'),(25,'22222','Biguaçu','Bom Viver','rua ausgusto pereira','43','Santa Catarina');
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
  `preco` decimal(10,2) NOT NULL,
  `acompanhamento` varchar(255) DEFAULT NULL,
  `isVegan` tinyint(1) DEFAULT NULL,
  `imagens` varchar(255) DEFAULT NULL,
  `avaliacao` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `pratoprincipal_chk_1` CHECK (((`avaliacao` >= 1) and (`avaliacao` <= 5))),
  CONSTRAINT `pratoprincipal_chk_2` CHECK (((`avaliacao` >= 1) and (`avaliacao` <= 5)))
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pratoprincipal`
--

LOCK TABLES `pratoprincipal` WRITE;
/*!40000 ALTER TABLE `pratoprincipal` DISABLE KEYS */;
INSERT INTO `pratoprincipal` VALUES (1,'Camarão à Milanesa',35.00,'Arroz , Feijão, Salada',0,'https://i.pinimg.com/736x/7b/2e/59/7b2e5988db5797f6aa846285c37ce968.jpg',4.5),(2,'Bife Acebolado',20.00,'Arroz , Feijão, Salada',0,'https://i.pinimg.com/736x/9e/e2/69/9ee2691d4d30ab3143e1785456a88c51.jpg',3.8),(3,'Frango Empanado',15.00,'Arroz , Feijão, Salada',0,'https://i.pinimg.com/736x/f0/11/0b/f0110b07a520c5fba692d9475cc40962.jpg',2.9),(4,'Salada',10.00,'Arroz , Feijão',1,'https://i.pinimg.com/736x/4a/82/6d/4a826d70d3f474bc8731e0c0baa1e115.jpg',5),(5,'Contra Filé',25.00,'Arroz , Feijão, Salada, macarrão',0,'https://i.pinimg.com/736x/a8/d0/96/a8d0964e5b32a5ee255d6fdfa95728f5.jpg',1.5);
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
  `preco` decimal(10,2) NOT NULL,
  `temAcucar` tinyint(1) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `imagens` varchar(255) DEFAULT NULL,
  `avaliacao` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `sobremesa_chk_1` CHECK (((`avaliacao` >= 1) and (`avaliacao` <= 5)))
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sobremesa`
--

LOCK TABLES `sobremesa` WRITE;
/*!40000 ALTER TABLE `sobremesa` DISABLE KEYS */;
INSERT INTO `sobremesa` VALUES (1,'Bolo de Chocolate',12.00,1,150,'https://i.pinimg.com/736x/69/b4/a8/69b4a80990779a1c3f529ee371d68c27.jpg',4.7),(2,'Torta de Limão',10.50,1,120,'https://i.pinimg.com/736x/e7/17/80/e717802a74baded680c31e6d24f384b2.jpg',3.5),(3,'Salada de Frutas',8.00,0,200,'https://i.pinimg.com/736x/9d/37/06/9d370686708722f8b2eabc2d7afa4d1e.jpg',2.8),(4,'Pudim de Leite',9.00,1,130,'https://i.pinimg.com/736x/88/c3/e9/88c3e9b62a3af5a6e978ee0955016fff.jpg',5),(5,'Mousse de Maracujá',8.50,1,100,'https://i.pinimg.com/736x/a5/50/8c/a5508c3e5ec8ddb4bf7a64972fbb925e.jpg',4.9);
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

-- Dump completed on 2025-06-02 21:54:20
