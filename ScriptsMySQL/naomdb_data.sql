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
INSERT INTO `productos` VALUES (1,'Contorno Líquido de la marca Kat Von D en tono Tan neutral 30 en su presentación de .57 oz/17mL fullsize. Es un contorno moderno y realista con un tono natural para aportar instantáneamente profundidad y dimensión a los rasgos faciales.','Art-01.jpg','Contorno Líquido KVD - Tan Neutral 30',353,10.00,10,1),(2,'Un bronceador en crema ligero que agrega color multidimensional mientras crea una definición esculpida. Da un acabado como una segunda piel. El producto versátil se puede usar tanto en la cara como en el cuerpo para definir y contornear. ','Art-02.jpg','Anastasia Beverly Hills Cream Bronzer',700,10.00,10,1),(3,'Paleta de labios con 12 tonos diferentes, hechos con una fórmula mate cremosa. Permite mezclar con el tono blanco o negro para aclarar u oscurecer o se puede mezclar para crear tu propio tono perfecto. Ideal para viajar y maquilladores.','Art-03.jpg','Paleta de Labios Mua Matte Kara Beauty',325,10.00,10,1),(4,'Contornee, sombree, resalte y esculpe. Con esta fórmula ultra cremosa hace que la aplicación sea fácil. La barra presenta dos tonos a sus extremos, ideal para esculpir los huecos de las mejillas, la línea del cabello, la nariz y la mandíbula.','Art-04.jpg','KKW BEAUTY Creme Contour & Highlight Set - Medium',830,10.00,10,1),(5,'Una barra multipropósito para ojos, mejillas, labios y cuerpo con una fórmula única de crema a polvo que se puede usar como rubor, iluminador, contorno y más.','Art-05.jpg','NARS | The Multiple Cream Blush, Lip and Eye Stick',930,10.00,10,1),(6,'Mantén tus brochas de maquillaje y esponjas limpias con la ayuda de este práctico limpiador. Utiliza este limpiador solo o con la ayuda de una almohadilla de limpieza de brochas.','Art-06.jpg','Wet n Wild Jabón Suds Esponja + Cepillo Limpiador Bob Squarepants',225,10.00,10,1),(7,'Saluda a nuestros nuevos lippies Bella Luxe! Esta fórmula de polvo a gamuza proporciona el mejor acabado, ya que no se seca tanto en los labios, pero sigue siendo lo suficientemente mate como para no transferirse.','Art-07.jpg','Bellaluxe Lipstick Matte Here To Stay #BBLP-05',165,10.00,10,1),(8,'Los lápices labiales de mate Bella Luxe tienen una fórmula de polvo a gamuza que brinda el mejor acabado.','Art-08.jpg','Bellaluxe Lipstick Matte Over It #BBLP-08 ',165,10.00,10,1),(9,'Combate el acné y recupera la claridad e incluso tonifica tu piel con esta máscara facial exfoliante. Este tratamiento exfolia la piel en múltiples niveles para combatir el acné y restaurar un tono uniforme y radiante.','Art-09.jpg','The Ordinary - Aha 30% + Bha 2% Peeling Solution - 30ml',465,10.00,10,3),(10,'Airspun Loose Face Powder ayuda a proporcionar una cobertura total que se siente lo suficientemente liviana como para usarla durante todo el día. Este polvo facial puede usarse como base o para fijar.','Art-10.jpg','Polvo traslúcido Airspun - Coty',245,10.00,10,1),(11,'El labial en crema Kris Collection de edición limitada es una fórmula suave y cremosa que proporciona una cobertura completa para unos labios ultra pigmentados. Úselo solo o combínalo con su brillo favorito para obtener un acabado brillante.','Art-11.png','Lápiz labial en crema Give Me a Kiss de Kylie Cosmetics',290,10.00,10,1),(12,'Iluminador con fórmula ligera y sedosa con pigmentos altamente reflejantes de fácil aplicación y difuminación. Úsalo para un look radiante','Art-12.png','Iluminador en polvo compacto Bissú',50,10.00,10,1),(13,'La paleta Artistry Morphe X Nikita presenta 35 tonos sin censura que definitivamente te ayudarán a dar rienda suelta al Dragun. Neutras que cambian el juego y los más atrevidos se unen con destellos sensuales y destellos que toman el control.','Art-13.png','Morphe X Nikita Artistry Palette',690,10.00,10,1),(14,'Mickey & Friends está contigo en cada paso del camino con la paleta de arte Morphe Mickey & Friends Truth Be Bold de edición limitada y rompe fronteras repleta de 35 tonos sin disculpas y audaces en acabados súper feroces.','Art-14.png','Morphe Paleta Mickey & Friends Truth Be Bold',690,10.00,10,1),(15,'Un delineador de ojos líquido impermeable y galardonado para utilizar durante todo el día, su pigmento opaco ayuda a crear líneas ultra precisas inspiradas en el arte del tatuaje.','Art-15.png','Delineador Kvd Beauty Tattoo Liner',350,10.00,10,1),(16,'Juego de pinceles de maquillaje de cintura pequeña de 14 piezas Marca Docolor, pelo sintético y Mango de madera Madera','Art-16.jpg','Cintura pequeña - Juego de brochas de maquillaje de 14 piezas',650,10.00,10,2),(17,'Juego de 4 brochas ideal para enaltecer tu belleza. Tipo de pelo sintético.','Art-17.png','Brochas de maquillaje Docolor DC0412 Rose Gold',110,10.00,10,2),(18,'Una poderosa fórmula iluminadora de vitamina C con una sensación similar a la crema. Soporte antioxidante, tono de piel desigual, signos de envejecimiento, opacidad','Art-18.png','The Ordinary Suspensión de Vitamina C 30% en Silicona',260,10.00,10,3),(19,'Este sérum ligero contiene una gran concentración (5 %) de cafeína, así como una forma purificada de glucósido de galato de epigalocatequina (EGCG) proveniente de hojas de té verde, contribuye a disminuir las bolsas en los ojos y las ojeras.','Art-19.png','Caffeine Solution 5% + Egcg - Sérum Para Contorno De Ojos',250,10.00,10,3),(20,'Este fijador de maquillaje con aroma a Topical llego para darte hidratación con poco esfuerzo, ayuda a que tu maquillaje dure por más tiempo en su lugar. Apto para todo tipo de piel.','Art-20.png','Beauty Creations - Setting Spray Tropical- Fijador De Maquillaje',70,10.00,10,3),(21,'Un spray súper hidratante 3-1, infusionado con agua de coco. Puede ser usado como un primer antes del maquillaje, para fijar el maquillaje todo el día o refrescarlo a cualquier hora. Ilumina, calma y suaviza la piel.','Art-21.png','Primer y Fijador de Maquillaje Hangover 3-in-1 en spray',690,10.00,10,3),(22,'Reduce la hinchazón alrededor de los ojos y alivia la tensión con estas almohadillas en gel reutilizables en frío o caliente para ojos. ¡Adiós ojeras y ojos cansados!','Art-22.png','Hot & Cold Eye Pads Pepino Cala',50,10.00,10,4),(23,'La Esponja Miracle Airblend cuenta con tecnología de espuma viscoelástica que abraza la superficie de la piel para una aplicación perfecta, lo que da como resultado un maquillaje de cobertura media a completa con un acabado mate natural.','Art-23.png',' Esponja RT Miracle Air Blend\n',150,10.00,10,4),(24,'Producto de Edición limitada en color negro con detalles de escritura y diseño en naranja brillante y detalle de orejas de gato.','Art-24.png','Espejo de mano negro ColourPop Hocus Pocus',390,10.00,10,4);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Arguello Ramos','$2a$10$uMRDT.1f7jwaSN8oW9xQB.KN9/LHW0ZZbYQ354QJo7KjVYqzQyGaa','arguello.ramosadrian@gmail.com','Adrian Armando','6861147413','V. Amazonas No. 159 S/N, Los Castillos, 37209, León, Guanajuato'),(2,'Torres Olvera','$2a$10$h4.va7/uEzZ97.yFNA01BOf5HYaTqipux6cXQsoaoGL.kPEPiB6lm','josuetolvera@gmail.com','Josue Vicente','5538843826','Mpio. De Calvillo No. 117, Ciudad Industrial, 20290, Aguascalientes, Aguascalientes'),(3,'Basto Arroyo','$2a$10$cC9tBwpjN5QLDEmhKn2dLuUoLl3nrqgPowzAFxo/hm9WMqt.oC0ga','gbastoa17@gmail.com','Jose Guillermo','9993700974','30 110 No. 23, Mexico Norte, 97128, Mérida, Yucatán'),(4,'Rodriguez Davila','$2a$10$t0Nwt6U6uGJsiuErXRIl5OxNiMLTwJomt1vaJP1keWKIZaEZnSNc.','lore.rdz2802@gmail.com','Lorena','3331032547','Carr Todos Los Santos Km 14.5 No. 2, Ejidal, Cabo San Lucas, Baja California'),(5,'Campos Ceron','$2a$10$OGapjZ1t47BjtO4tiKa0d.l.Y.g69wJJ1C4eWwW3nBGI97hM6t9.O','ivancamposceron11@gmail.com','Ivan','5525168561','30 110 No. 23, Mexico Norte, 97128, Mérida, Yucatán'),(6,'Gonzalez Barreda','$2a$10$fg5j8zpRi.w8TktoGXDcIeaj/4/Vmhh8rhg0ReeapQP9.7q39KECu','maria.gonzalezbarrreda@gmail.com','Maria Concepcion','3121007776','Carr Todos Los Santos Km 14.5 No. 2, Ejidal, Cabo San Lucas, Baja California'),(7,'Villegas Perez','$2a$10$TG.gsZqsp67NhozVj9S/ue1kEfo92wuoT9c9TlWBr.VLgyrdwoIz2','marzo.2093@gmail.com','Nancy Johanna','2221151309','Mpio. De Calvillo No. 117, Ciudad Industrial, 20290, Aguascalientes, Aguascalientes');
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

-- Dump completed on 2023-02-01 12:16:22
