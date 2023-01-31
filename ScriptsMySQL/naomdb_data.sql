CREATE DATABASE  IF NOT EXISTS `naomdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `naomdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: naomdb
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
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Maquillaje'),(2,'Brochas'),(3,'Cuidado Facial'),(4,'Accesorios');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (1,5,2000.00,1,1,'2023-01-31'),(2,2,1400.00,2,1,'2023-01-31'),(3,5,2325.00,3,1,'2023-01-31'),(4,2,650.00,4,1,'2023-01-31'),(5,1,165.00,5,1,'2023-01-31'),(6,2,1660.00,6,1,'2023-01-31');
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordenes_has_productos`
--

LOCK TABLES `ordenes_has_productos` WRITE;
/*!40000 ALTER TABLE `ordenes_has_productos` DISABLE KEYS */;
INSERT INTO `ordenes_has_productos` VALUES (1,1),(2,2),(3,9),(4,3),(5,7),(6,4);
/*!40000 ALTER TABLE `ordenes_has_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Contorno Líquido de la marca Kat Von D en tono Tan neutral 30 en su presentación de .57 oz/17mL fullsize. Es un contorno moderno y realista con un tono natural para aportar instantáneamente profundidad y dimensión a los rasgos faciales.','','Contorno Líquido KVD - Tan Neutral 30',353,10.00,0,1),(2,'Un bronceador en crema ligero que agrega color multidimensional mientras crea una definición esculpida. Da un acabado como una segunda piel. El producto versátil se puede usar tanto en la cara como en el cuerpo para definir y contornear. ','','Anastasia Beverly Hills Cream Bronzer',700,10.00,0,1),(3,'Paleta de labios con 12 tonos diferentes, hechos con una fórmula mate cremosa. Permite mezclar con el tono blanco o negro para aclarar u oscurecer o se puede mezclar para crear tu propio tono perfecto. Ideal para viajar y maquilladores.','','Paleta de Labios Mua Matte Kara Beauty',325,10.00,0,1),(4,'Contornee, sombree, resalte y esculpe. Con esta fórmula ultra cremosa hace que la aplicación sea fácil. La barra presenta dos tonos a sus extremos, ideal para esculpir los huecos de las mejillas, la línea del cabello, la nariz y la mandíbula.','','KKW BEAUTY Creme Contour & Highlight Set - Medium',830,10.00,0,1),(5,'Una barra multipropósito para ojos, mejillas, labios y cuerpo con una fórmula única de crema a polvo que se puede usar como rubor, iluminador, contorno y más.','','NARS | The Multiple Cream Blush, Lip and Eye Stick',930,10.00,0,1),(6,'Mantén tus brochas de maquillaje y esponjas limpias con la ayuda de este práctico limpiador. Utiliza este limpiador solo o con la ayuda de una almohadilla de limpieza de brochas.','','Wet n Wild Jabón Suds Esponja + Cepillo Limpiador Bob Squarepants',225,10.00,0,1),(7,'Saluda a nuestros nuevos lippies Bella Luxe! Esta fórmula de polvo a gamuza proporciona el mejor acabado, ya que no se seca tanto en los labios, pero sigue siendo lo suficientemente mate como para no transferirse.','','Bellaluxe Lipstick Matte Here To Stay #BBLP-05',165,10.00,0,1),(8,'Los lápices labiales de mate Bella Luxe tienen una fórmula de polvo a gamuza que brinda el mejor acabado.','','Bellaluxe Lipstick Matte Over It #BBLP-08 ',165,10.00,0,1),(9,'Combate el acné y recupera la claridad e incluso tonifica tu piel con esta máscara facial exfoliante. Este tratamiento exfolia la piel en múltiples niveles para combatir el acné y restaurar un tono uniforme y radiante.','','The Ordinary - Aha 30% + Bha 2% Peeling Solution - 30ml',465,10.00,0,3),(10,'Airspun Loose Face Powder ayuda a proporcionar una cobertura total que se siente lo suficientemente liviana como para usarla durante todo el día. Este polvo facial puede usarse como base o para fijar.','','Polvo traslúcido Airspun - Coty',245,10.00,0,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Arguello Ramos','$2a$10$uMRDT.1f7jwaSN8oW9xQB.KN9/LHW0ZZbYQ354QJo7KjVYqzQyGaa','arguello.ramosadrian@gmail.com','Adrian Armando','6861147413'),(2,'Torres Olvera','$2a$10$h4.va7/uEzZ97.yFNA01BOf5HYaTqipux6cXQsoaoGL.kPEPiB6lm','josuetolvera@gmail.com','Josue Vicente','5538843826'),(3,'Basto Arroyo','$2a$10$cC9tBwpjN5QLDEmhKn2dLuUoLl3nrqgPowzAFxo/hm9WMqt.oC0ga','gbastoa17@gmail.com','Jose Guillermo','9993700974'),(4,'Rodriguez Davila','$2a$10$t0Nwt6U6uGJsiuErXRIl5OxNiMLTwJomt1vaJP1keWKIZaEZnSNc.','lore.rdz2802@gmail.com','Lorena','3331032547'),(5,'Campos Ceron','$2a$10$OGapjZ1t47BjtO4tiKa0d.l.Y.g69wJJ1C4eWwW3nBGI97hM6t9.O','ivancamposceron11@gmail.com','Ivan','5525168561'),(6,'Gonzalez Barreda','$2a$10$fg5j8zpRi.w8TktoGXDcIeaj/4/Vmhh8rhg0ReeapQP9.7q39KECu','maria.gonzalezbarrreda@gmail.com','Maria Concepcion','3121007776'),(7,'Villegas Perez','$2a$10$TG.gsZqsp67NhozVj9S/ue1kEfo92wuoT9c9TlWBr.VLgyrdwoIz2','marzo.2093@gmail.com','Nancy Johanna','2221151309');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'naomdb'
--

--
-- Dumping routines for database 'naomdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-31  8:51:24
