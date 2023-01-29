CREATE DATABASE  IF NOT EXISTS `naomdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `naomdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: naom
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
INSERT INTO `ordenes` VALUES (1,1,353,2),(2,2,1400,2),(3,5,2325,6),(4,2,650,6),(5,1,165,3),(6,2,1660,3);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos_ordenes`
--

LOCK TABLES `productos_ordenes` WRITE;
/*!40000 ALTER TABLE `productos_ordenes` DISABLE KEYS */;
INSERT INTO `productos_ordenes` VALUES (1,1),(2,2),(3,9),(4,3),(5,7),(6,4);
/*!40000 ALTER TABLE `productos_ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Contorno Líquido KVD - Tan Neutral 30',NULL,353,'Contorno Líquido de la marca Kat Von D en tono Tan neutral 30 en su presentación de .57 oz/17mL fullsize. Es un contorno moderno y realista con un tono natural para aportar instantáneamente profundidad y dimensión a los rasgos faciales.',10,0,1),(2,'Anastasia Beverly Hills Cream Bronzer',NULL,700,'Un bronceador en crema ligero que agrega color multidimensional mientras crea una definición esculpida. Da un acabado como una segunda piel. El producto versátil se puede usar tanto en la cara como en el cuerpo para definir y contornear. ',10,0,1),(3,'Paleta de Labios Mua Matte Kara Beauty',NULL,325,'Paleta de labios con 12 tonos diferentes, hechos con una fórmula mate cremosa. Permite mezclar con el tono blanco o negro para aclarar u oscurecer o se puede mezclar para crear tu propio tono perfecto. Ideal para viajar y maquilladores.',10,0,1),(4,'KKW BEAUTY Creme Contour & Highlight Set - Medium',NULL,830,'Contornee, sombree, resalte y esculpe. Con esta fórmula ultra cremosa hace que la aplicación sea fácil. La barra presenta dos tonos a sus extremos, ideal para esculpir los huecos de las mejillas, la línea del cabello, la nariz y la mandíbula.',10,0,1),(5,'NARS | The Multiple Cream Blush, Lip and Eye Stick',NULL,930,'Una barra multipropósito para ojos, mejillas, labios y cuerpo con una fórmula única de crema a polvo que se puede usar como rubor, iluminador, contorno y más.',10,0,1),(6,'Wet n Wild Jabón Suds Esponja + Cepillo Limpiador Bob Squarepants',NULL,225,'Mantén tus brochas de maquillaje y esponjas limpias con la ayuda de este práctico limpiador. Utiliza este limpiador solo o con la ayuda de una almohadilla de limpieza de brochas.',10,0,1),(7,'Bellaluxe Lipstick Matte Here To Stay #BBLP-05',NULL,165,'Saluda a nuestros nuevos lippies Bella Luxe! Esta fórmula de polvo a gamuza proporciona el mejor acabado, ya que no se seca tanto en los labios, pero sigue siendo lo suficientemente mate como para no transferirse.',10,0,1),(8,'Bellaluxe Lipstick Matte Over It #BBLP-08 ',NULL,165,'Los lápices labiales de mate Bella Luxe tienen una fórmula de polvo a gamuza que brinda el mejor acabado.',10,0,1),(9,'The Ordinary - Aha 30% + Bha 2% Peeling Solution - 30ml',NULL,465,'Combate el acné y recupera la claridad e incluso tonifica tu piel con esta máscara facial exfoliante. Este tratamiento exfolia la piel en múltiples niveles para combatir el acné y restaurar un tono uniforme y radiante.',10,0,3),(10,'Polvo traslúcido Airspun - Coty',NULL,245,'Airspun Loose Face Powder ayuda a proporcionar una cobertura total que se siente lo suficientemente liviana como para usarla durante todo el día. Este polvo facial puede usarse como base o para fijar.',10,0,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Josue Vicente','Torres Olvera','josuetolvera@gmail.com','josue123','5538843826'),(2,'Jose Guillermo','Basto Arroyo','gbastoa17@gmail.com','guillermo123','9993700974'),(3,'Lorena','Rodríguez Dávila','lore.rdz2802@gmail.com','lorena123','3331032547'),(4,'Adrian Armando','Arguello Ramos','arguello.ramosadrian@gmail.com','adrian123','6861147413'),(5,'Ivan','Campos Ceron','ivancamposceron11@gmail.com','ivan123','5525168561'),(6,'Maria Concepcion','Gonzalez Barreda','maria.gonzalezbarrreda@gmail.com','maria123','3121007776'),(7,'Nancy Johanna','Villegas Pérez','marzo.2093@gmail.com','marzo123','2221151309');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- Dump completed on 2023-01-20 21:58:34