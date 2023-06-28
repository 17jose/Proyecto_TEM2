-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_tienda
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `categoria_id` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (2,'Zapatos'),(4,'Sombreros'),(6,'Chamaras'),(7,'acc gamer'),(8,'Auriculares'),(9,'Teclados'),(10,'Mouse'),(11,'computadoras');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ci_cliente` int NOT NULL,
  `nombre_cliente` varchar(60) NOT NULL,
  `apellidos_cliente` varchar(60) NOT NULL,
  `celular` int NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`ci_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (12381209,'Pepe','Huanca',688192,12381209),(113028233,'Goni','Ssanxhez',28301749,113028233),(134315131,'Pepito','Gonzales',35226264,134315131);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `marca_id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`marca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Nike Total'),(2,'Puma'),(3,'rowell'),(4,'PHILIPS'),(5,'Logitech'),(6,'Razer'),(7,'HyperX'),(8,'Abkoncore'),(9,'Asus'),(10,'Redragon'),(11,'Samsung');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden` (
  `orden_id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `total` double(10,2) DEFAULT NULL,
  `descuento` double(10,2) DEFAULT NULL,
  `fecha_orden` date DEFAULT NULL,
  `producto_id` int DEFAULT NULL,
  `id_venta` int DEFAULT NULL,
  PRIMARY KEY (`orden_id`),
  KEY `producto_id` (`producto_id`),
  KEY `orden_ifbk_2` (`id_venta`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`producto_id`),
  CONSTRAINT `orden_ifbk_2` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` VALUES (1,20,30.00,0.00,'2022-11-24',2,3);
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `producto_id` int NOT NULL AUTO_INCREMENT,
  `nombre_prod` varchar(255) NOT NULL,
  `precio` double(10,2) NOT NULL,
  `stock_id` int DEFAULT NULL,
  `marca_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  PRIMARY KEY (`producto_id`),
  KEY `stock_id` (`stock_id`),
  KEY `marca_id` (`marca_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`marca_id`),
  CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (2,'Buso',1241.00,1,2,4),(3,'teclado rgb',380.00,2,3,7),(4,'auriculares Fidelio X2HR',270.00,4,4,8),(5,'Silver Eagle G5',82.00,5,5,10),(6,'RatÃ³n inalÃ¡mbrico recargable con Bluetooth para ordenador',75.00,6,3,10);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,9),(2,19),(3,50),(4,75),(5,34),(6,80),(7,70),(8,67);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienda`
--

DROP TABLE IF EXISTS `tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tienda` (
  `id_tienda` int NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `telefono` int NOT NULL,
  PRIMARY KEY (`id_tienda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
/*!40000 ALTER TABLE `tienda` DISABLE KEYS */;
INSERT INTO `tienda` VALUES (1001,'Av. Juan Pablo II','El Alto',22337766),(1002,'Av. Sucre B','El Alto',22559900),(1003,'Av. Pando','Pando',73020),(49964,'Av. Santa Fe','Cochabamba',221840);
/*!40000 ALTER TABLE `tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin','admin@gmail.com','21232f297a57a5a743894a0e4a801fc3'),(2,'luis','llamaca','luis.llamaca@gmail.com','c0df0cf57888b987cf5b55bb6bf22d7a'),(3,'hector','charca','hector.charca@gmail.com','c59fa204f5abd7caebca8f58aa1d21c1'),(4,'silvia','quispe','silvia.quispe','6464fff3ba1de8b5d604675a79b1fc2e');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `ci_vendedor` int NOT NULL,
  `nombre_vendedor` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `celular` int NOT NULL,
  `id_tienda` int DEFAULT NULL,
  `id` int DEFAULT NULL,
  PRIMARY KEY (`ci_vendedor`),
  KEY `id_tienda` (`id_tienda`),
  CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (440183,'Pedro','Domingo','Suarez',76539026,1001,12),(1283213,'Hugo','Salinas','Aguado',78592057,1002,2),(15326232,'Raul','Alejandro','Magno',74890235,1003,90216467);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `fecha_venta` date NOT NULL,
  `tienda_id` int DEFAULT NULL,
  `ci_vendedor` int DEFAULT NULL,
  `ci_cliente` int DEFAULT NULL,
  `orden_id` int DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `tienda_id` (`tienda_id`),
  KEY `ci_vendedor` (`ci_vendedor`),
  KEY `ci_cliente` (`ci_cliente`),
  KEY `venta_ibfk_4` (`orden_id`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`tienda_id`) REFERENCES `tienda` (`id_tienda`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`ci_vendedor`) REFERENCES `vendedor` (`ci_vendedor`),
  CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`ci_cliente`) REFERENCES `cliente` (`ci_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (3,'2022-11-24',1002,440183,12381209,NULL),(4,'2022-11-26',1002,440183,113028233,NULL);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 13:28:10
