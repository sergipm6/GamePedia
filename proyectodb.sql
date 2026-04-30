CREATE DATABASE  IF NOT EXISTS `proyectodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectodb`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectodb
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `game_id` bigint NOT NULL AUTO_INCREMENT,
  `game_description` text,
  `game_developer` varchar(255) DEFAULT NULL,
  `game_genre` varchar(255) DEFAULT NULL,
  `game_image_url` varchar(255) DEFAULT NULL,
  `game_name` varchar(255) DEFAULT NULL,
  `main_competitions` varchar(255) DEFAULT NULL,
  `peak_players` varchar(255) DEFAULT NULL,
  `release_year` int DEFAULT NULL,
  `competitive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'League of Legends nació en 2009 de la mano de Riot Games, inspirado por el popular mod de Warcraft III, Defense of the Ancients (DotA). El concepto original buscaba profesionalizar el género MOBA, eliminando las barreras de entrada del mod original y ofreciendo un modelo free-to-play con actualizaciones constantes.\r\n\r\nEn su inicio, la historia se centraba en la Academia de la Guerra, donde \"Invocadores\" (los jugadores) resolvían los conflictos políticos de Runaterra mediante batallas controladas. Con el tiempo, Riot eliminó esta narrativa de los Invocadores para enfocarse en un lore expansivo, transformando a cada campeón en un héroe con motivaciones propias en un mundo de fantasía complejo y épico.','Riot Games','MOBA','https://logodownload.org/wp-content/uploads/2014/09/lol-league-of-Legends-logo.png','League of Legends',NULL,'100M de jugadores activos',2009,1),(2,'El Counter-Strike 2 (CS2) se lanzó en septiembre de 2023 como una actualización gratuita y masiva para sustituir al legendario CS:GO. Desarrollado con el motor Source 2, introdujo mejoras gráficas críticas, físicas de humo dinámicas y un sistema de \"sub-tick\" para mejorar la precisión de los disparos. Aunque su estreno fue polémico por la eliminación de mapas y modos clásicos, logró unificar la base de jugadores en una plataforma tecnológica moderna. Hoy representa el estándar actual de los tactical shooters, manteniendo el espíritu competitivo que ha definido a la franquicia por más de 25 años.','Valve','FPS','https://logodownload.org/wp-content/uploads/2025/01/cs-2-logo.png','CS:2',NULL,'35M de jugadores activos',2023,1),(3,'VALORANT fue lanzado por Riot Games en 2020, combinando el disparo táctico de precisión con habilidades únicas de personajes (agentes). El juego revolucionó la escena competitiva gracias a su excelente infraestructura de servidores y un ecosistema de esports global liderado por el circuito VCT. A través de cinemáticas y mapas dinámicos, desarrolla una narrativa sobre un evento catastrófico llamado \"First Light\" y el conflicto entre dos Tierras. Su modelo gratuito y su constante actualización de contenido lo han consolidado como el principal rival de CS. Actualmente, es uno de los títulos más vistos en Twitch, destacando por eventos masivos donde organizaciones como Movistar KOI compiten por la gloria internacional.','Riot Games','FPS','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Valorant_logo_-_pink_color_version.svg/1280px-Valorant_logo_-_pink_color_version.svg.png','Valorant',NULL,'35M de jugadores activos',2020,1),(4,'Situado en la ciudad ficticia de Los Santos, la trama sigue a tres criminales muy distintos cuyos caminos se cruzan en una serie de audaces robos. Mientras intentan sobrevivir a las fuerzas del gobierno y al mundo del espectáculo, el juego ofrece un mundo abierto masivo y detallado que satiriza la cultura estadounidense moderna. Su modo online ha mantenido el juego vivo durante más de una década, convirtiéndolo en el producto de entretenimiento más rentable de la historia.','Rockstar Games','Historia','https://upload.wikimedia.org/wikipedia/de/thumb/7/74/GTA5-logo-o.svg/3840px-GTA5-logo-o.svg.png','Grand theft auto V',NULL,'200M de jugadores registrados',2013,0),(5,'The Witcher 3: Wild Hunt es la culminación de la trilogía desarrollada por el estudio polaco CD Projekt RED, basada en la saga literaria Saga o Wiedźminie del autor Andrzej Sapkowski. A diferencia de sus predecesores, esta entrega introdujo un vasto mundo abierto diseñado para cerrar la historia personal del brujo Geralt de Rivia. La narrativa se aleja de los tropos heroicos tradicionales para centrarse en una búsqueda desesperada: localizar a Ciri, la hija adoptiva de Geralt, quien es perseguida por la Cacería Salvaje, una fuerza espectral de otra dimensión. El guion destaca por su profunda madurez y un sistema de consecuencias grises, donde no existe una distinción clara entre el bien y el mal. Cada decisión del jugador, incluso en misiones secundarias aparentemente menores, puede alterar drásticamente el destino de regiones enteras y el desenlace de los personajes principales. Esta estructura redefine la narrativa en los RPG, entrelazando temas de política, folclore eslavo y lazos familiares de una forma emocionalmente devastadora.','CD Projekt Red','RPG','https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/EN_The-Witcher-3_Logo-Black_RGB.svg/1280px-EN_The-Witcher-3_Logo-Black_RGB.svg.png','The Witcher 3: Wild Hunt',NULL,'50M de jugadores registrados',2015,0),(6,'La cronología de World of Warcraft se sitúa cuatro años después de los eventos de Warcraft III: The Frozen Throne, heredando un conflicto milenario entre la Alianza y la Horda en el devastado mundo de Azeroth. Lo que comenzó como una lucha por la supervivencia y el territorio pronto escaló hacia una narrativa de proporciones cósmicas, donde los jugadores pasaron de ser simples mercenarios a los \"Campeones de Azeroth\". A través de más de dos décadas, la historia ha sido impulsada por hitos climáticos: desde el asalto a la Ciudadela de la Corona de Hielo para derrotar al Rey Exánime, hasta el Cataclismo provocado por el dragón Alamuerte que reformó geográficamente el mundo entero. Con la introducción de la Saga del Alma del Mundo, la narrativa ha alcanzado una madurez técnica y emocional, explorando el destino del titán durmiente dentro del planeta y las sombras que acechan desde el Vacío. Este arco evolutivo ha consolidado a WoW no solo como un juego, sino como un universo literario vivo donde la política interna de las facciones y las amenazas de dioses antiguos convergen en una épica constante.','Blizzard','MMORPG','https://logos-world.net/wp-content/uploads/2021/02/World-of-Warcraft-Logo-2004-present.png','World of Warcraft',NULL,'100M de jugadores registrados',2004,0),(7,'The Legend of Zelda: Tears of the Kingdom es la secuela directa del aclamado Breath of the Wild, desarrollada por Nintendo EPD bajo la dirección de Hidemaro Fujibayashi. El origen del proyecto surgió de la gran cantidad de ideas descartadas para los contenidos descargables del título anterior, lo que llevó al equipo a expandir Hyrule no solo horizontalmente, sino también verticalmente con las Islas Celestes y el Subsuelo. La narrativa comienza con el despertar de una antigua entidad malévola bajo el Castillo de Hyrule, evento que provoca la desaparición de la Princesa Zelda y la destrucción del brazo de Link. A través de una estructura no lineal, el jugador debe reconstruir los eventos del pasado mediante las \"Lágrimas de Dragón\" y colaborar con los nuevos sabios para enfrentar la amenaza de Ganondorf. El guion profundiza en el lore de los Zonnan, una civilización ancestral, entrelazando temas de sacrificio, legado y la persistencia del espíritu a través del tiempo. Esta entrega culmina la transformación de la saga hacia una libertad creativa total, donde la narrativa se descubre orgánicamente mientras el jugador explora un mundo en constante cambio.','Nintendo EPD','Historia','https://static.wikia.nocookie.net/zelda_gamepedia_en/images/4/4c/TotK_English_Logo.png/revision/latest?cb=20220913150240','Zelda: Tears Of The Kingdom',NULL,'23M de jugadores registrados',2023,0);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_awards`
--

DROP TABLE IF EXISTS `game_awards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_awards` (
  `game_game_id` bigint NOT NULL,
  `awards` varchar(255) DEFAULT NULL,
  KEY `FK6vn9fhailw2gorypchk6wsftn` (`game_game_id`),
  CONSTRAINT `FK6vn9fhailw2gorypchk6wsftn` FOREIGN KEY (`game_game_id`) REFERENCES `game` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_awards`
--

LOCK TABLES `game_awards` WRITE;
/*!40000 ALTER TABLE `game_awards` DISABLE KEYS */;
INSERT INTO `game_awards` VALUES (4,'GOTY 2013'),(4,'PREMIOS BAFTA'),(4,'7x RECORD GUINESS'),(5,'GOTY 2015'),(5,'Golden Joystick Awards'),(5,'Game Developers Choice Awards'),(5,'SXSW Gaming Awards'),(5,'D.I.C.E. Awards'),(7,'Golden Joystick Awards 2023: * Nintendo Game of the Year');
/*!40000 ALTER TABLE `game_awards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_leagues`
--

DROP TABLE IF EXISTS `game_leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_leagues` (
  `game_id` bigint NOT NULL,
  `league_id` bigint NOT NULL,
  PRIMARY KEY (`game_id`,`league_id`),
  KEY `FK5b9nvdperym2qqe5seotog9v5` (`league_id`),
  CONSTRAINT `FK5b9nvdperym2qqe5seotog9v5` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`league_id`),
  CONSTRAINT `FKrttvtljy076r2g41pjoxpa19q` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_leagues`
--

LOCK TABLES `game_leagues` WRITE;
/*!40000 ALTER TABLE `game_leagues` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leagues`
--

DROP TABLE IF EXISTS `leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leagues` (
  `league_id` bigint NOT NULL AUTO_INCREMENT,
  `international` tinyint(1) DEFAULT NULL,
  `league_description` text,
  `league_name` varchar(255) DEFAULT NULL,
  `game_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`league_id`),
  KEY `FK9kbp7x60v037t6ombxcjfadsm` (`game_id`),
  CONSTRAINT `FK9kbp7x60v037t6ombxcjfadsm` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leagues`
--

LOCK TABLES `leagues` WRITE;
/*!40000 ALTER TABLE `leagues` DISABLE KEYS */;
INSERT INTO `leagues` VALUES (1,1,'Worlds es el torneo anual más prestigioso de League of Legends, donde los mejores equipos de regiones como Corea, China y Europa compiten por la Copa del Invocador. El evento destaca por su altísimo nivel competitivo y sus espectaculares ceremonias de apertura con himnos interpretados por artistas de talla mundial. Históricamente, las organizaciones asiáticas han dominado el palmarés, especialmente T1, el equipo más laureado de la historia. El formato ha evolucionado hacia un sistema suizo y eliminatorias directas, atrayendo a audiencias globales de millones de espectadores. Es, en esencia, la culminación de la temporada y el escenario donde se forjan las leyendas de los esports.','Worlds',1,'https://upload.wikimedia.org/wikipedia/en/5/5f/LOL_Worlds_logo.svg'),(2,0,'La LEC (League of Legends EMEA Championship) es la máxima competición profesional de Europa y una de las ligas más innovadoras y seguidas del mundo. Con sede en Berlín, destaca por su formato de tres \"splits\" anuales (Invierno, Primavera y Verano) que culminan en unas finales regionales para decidir a los representantes de Worlds. Históricamente ha estado dominada por organizaciones legendarias como G2 Esports y Fnatic, quienes mantienen una de las rivalidades más intensas de los esports. El torneo es famoso no solo por su nivel técnico, sino por su alta calidad de producción, integrando entretenimiento, música y una narrativa muy cercana a los fans. Su enfoque actual integra a toda la región de EMEA (Europa, Oriente Medio y África), consolidando un ecosistema competitivo diverso y de élite.','LEC',1,'https://upload.wikimedia.org/wikipedia/commons/c/c6/LEC_Logo.png'),(3,1,'Las Intel Extreme Masters en CS2 representan la cúspide del circuito competitivo, siendo los torneos no-Major más prestigiosos del calendario. Sus paradas icónicas en Katowice (Polonia) y Colonia (Alemania) son consideradas los \"Grand Slams\" del juego, donde ganar otorga un estatus de leyenda inmediata. Con la llegada de Source 2, estos eventos han servido como escaparate para definir el nuevo meta profesional, destacando por una producción técnica impecable y estadios con miles de fans. Además, son piezas clave para el Intel Grand Slam, el premio de $1.000.000 para el equipo que logre cuatro victorias en sus torneos. En definitiva, la IEM es donde se forja la historia de Counter-Strike, manteniendo viva la llama de la competición pura desde hace dos décadas.','Intel extreme Masters (IEM)',2,'https://intelextrememasters.com/wp-content/uploads/2022/03/IEM-Logo-on-White_Horizontal_RGB.png'),(4,0,'La LCK (League of Legends Champions Korea) es la liga profesional de primer nivel de Corea del Sur y es ampliamente considerada la competición más prestigiosa y de mayor nivel técnico en el mundo.','LCK',1,'https://upload.wikimedia.org/wikipedia/commons/1/13/League_of_Legends_Champions_Korea_logo.svg');
/*!40000 ALTER TABLE `leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_positions`
--

DROP TABLE IF EXISTS `player_positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_positions` (
  `player_id` int NOT NULL,
  `position_id` int NOT NULL,
  KEY `FKpskrshhm2l2hmymwipcil6si3` (`position_id`),
  KEY `FKls7iovsuc8x2924csuuc9avsn` (`player_id`),
  CONSTRAINT `FKls7iovsuc8x2924csuuc9avsn` FOREIGN KEY (`player_id`) REFERENCES `players` (`player_id`),
  CONSTRAINT `FKpskrshhm2l2hmymwipcil6si3` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_positions`
--

LOCK TABLES `player_positions` WRITE;
/*!40000 ALTER TABLE `player_positions` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `player_id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `player_email` varchar(255) DEFAULT NULL,
  `player_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `game_id` bigint DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `position_position_id` int DEFAULT NULL,
  PRIMARY KEY (`player_id`),
  KEY `FKp6fpr78wx0dw2gymua6lw4t3w` (`game_id`),
  KEY `FKp6sdv1jjmd9prqj0c1hsrbvp6` (`position_id`),
  KEY `FK5nglidr00c4dyybl171v6kask` (`team_id`),
  KEY `FKic2uaip4rbtai1187y0iw1sa0` (`position_position_id`),
  CONSTRAINT `FK5nglidr00c4dyybl171v6kask` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  CONSTRAINT `FKic2uaip4rbtai1187y0iw1sa0` FOREIGN KEY (`position_position_id`) REFERENCES `positions` (`position_id`),
  CONSTRAINT `FKp6fpr78wx0dw2gymua6lw4t3w` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FKp6sdv1jjmd9prqj0c1hsrbvp6` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (9,19,'España','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/4b/MKOI_Myrwn_2026_Split_1.png/revision/latest?cb=20260117101837','mirwin@mail.com','Alex Villarejo','Mirwin',1,2,3,NULL),(10,26,'España','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/9/9e/MKOI_Elyoya_2026_Split_1.png/revision/latest?cb=20260117101832','elyoya@mail.com','Javier Prades Batalla','Elyoya',1,3,3,NULL),(11,21,'','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/ac/MKOI_Jojopyun_2026_Split_1.png/revision/latest?cb=20260117101834','jojopyun@mail.com','Joseph Joon Pyun','Jojopyun',1,4,3,NULL),(12,25,'España','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/59/MKOI_Supa_2026_Split_1.png/revision/latest?cb=20260117101839','supa@mail.com','David Martínez García','Supa',1,5,3,NULL),(13,22,'España','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/ed/MKOI_Alvaro_2026_Split_1.png/revision/latest/scale-to-width-down/651?cb=20260117101830','alvaro@mail.com','Álvaro Fernández del Amo','Alvaro',1,6,3,NULL),(14,25,'Corea del Sur','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/de/T1_Doran_2026_LCK_Cup.png/revision/latest?cb=20260122163256','doran@mail.com','Choi Hyeon-joon','Doran',1,2,4,NULL),(15,23,'Corea del Sur','https://ggscore.com/media/logo/p72460.png?29','oner@mail.com','Moon Hyeon-joon','Oner',1,3,4,NULL),(16,29,'Corea del Sur','https://e7.pngegg.com/pngimages/77/262/png-clipart-faker-league-of-legends-champions-korea-mid-season-invitational-sk-telecom-t1-mid-background-game-glasses.png','faker@mail.com','Lee Sang-hyeok','Faker',1,4,4,NULL),(17,20,'Corea del Sur','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/e9/T1_Peyz_2026_LCK_Cup.png/revision/latest?cb=20260122163320','peyz@mail.com','Kim Su-hwan','Peyz',1,5,4,NULL),(18,23,'Corea del Sur','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/da/T1_Keria_2026_LCK_Cup.png/revision/latest?cb=20260122163329','keria@mail.com','Ryu Min-seok','Keria',1,6,4,NULL);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(255) DEFAULT NULL,
  `game_id` bigint NOT NULL,
  PRIMARY KEY (`position_id`),
  KEY `FKhe8g0cwivwoelj649x55q5jss` (`game_id`),
  CONSTRAINT `FKhe8g0cwivwoelj649x55q5jss` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'TOPLANER',1),(2,'TOPLANER',1),(3,'JUNGLER',1),(4,'MIDLANER',1),(5,'ADCARRY',1),(6,'SUPPORT',1),(7,'Duelista',3),(8,'Iniciador',3),(9,'Controlador',3),(10,'Centinela',3);
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` enum('ROLE_ADMIN','ROLE_USER') NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK716hgxp60ym1lifrdgp67xt5k` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (4,'ROLE_ADMIN'),(3,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_leagues`
--

DROP TABLE IF EXISTS `team_leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_leagues` (
  `team_id` int NOT NULL,
  `league_id` bigint NOT NULL,
  KEY `FKolccfsxqvuqv8x14962riklkm` (`league_id`),
  KEY `FKi6gkbeko3kru8txpyad2kb5o7` (`team_id`),
  CONSTRAINT `FKi6gkbeko3kru8txpyad2kb5o7` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  CONSTRAINT `FKolccfsxqvuqv8x14962riklkm` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`league_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_leagues`
--

LOCK TABLES `team_leagues` WRITE;
/*!40000 ALTER TABLE `team_leagues` DISABLE KEYS */;
INSERT INTO `team_leagues` VALUES (1,1),(1,2),(3,2),(3,1),(4,1),(4,4);
/*!40000 ALTER TABLE `team_leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_palmares`
--

DROP TABLE IF EXISTS `team_palmares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_palmares` (
  `team_team_id` int NOT NULL,
  `palmares` varchar(255) DEFAULT NULL,
  KEY `FKcn9mhf7mm21minom5bju9chc5` (`team_team_id`),
  CONSTRAINT `FKcn9mhf7mm21minom5bju9chc5` FOREIGN KEY (`team_team_id`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_palmares`
--

LOCK TABLES `team_palmares` WRITE;
/*!40000 ALTER TABLE `team_palmares` DISABLE KEYS */;
INSERT INTO `team_palmares` VALUES (1,'14X LEC'),(1,'1X MSI'),(3,'3x LEC'),(4,'5x WORLDS'),(4,'2X MSI (Mid-Season Invitational)'),(4,'1x IEM World Championship'),(4,'10x LCK');
/*!40000 ALTER TABLE `team_palmares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `history` text,
  `image_url` text,
  `palmares` text,
  `team_created` date DEFAULT NULL,
  `team_name` varchar(255) NOT NULL,
  `trophies` int DEFAULT '0',
  `game_id` bigint DEFAULT NULL,
  `league_id` bigint DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  KEY `FK78r2urulb5063bvih5ca3tme3` (`game_id`),
  KEY `FKcmnrlwu7alyse9s3x5tgvxyqj` (`league_id`),
  CONSTRAINT `FK78r2urulb5063bvih5ca3tme3` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FKcmnrlwu7alyse9s3x5tgvxyqj` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`league_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Alemania','Fundado por Ocelote, G2 pasó de ser un equipo aspirante a dominar Europa con puño de hierro desde su debut en 2016, ganando cuatro títulos consecutivos. Su cima llegó en 2019, cuando con el histórico roster de Caps y Perkz, ganaron el MSI y estuvieron a una sola serie (la final de Worlds) de lograr el primer \"Grand Slam\" de la historia del juego. Tras una etapa de reconstrucción, volvieron a la cima reinventando su estilo, manteniéndose hoy como el único equipo europeo capaz de plantar cara de forma constante a las potencias de Corea y China.','https://static.wixstatic.com/media/ee59cf_c4d75c0546194c10ad89728f3e1078de~mv2.png/v1/fill/w_2048,h_2048,al_c/Year%202%20G2%20Esports%20Launch%20Nameplate.png','1x Worlds',NULL,'G2 Esports',15,1,NULL),(3,'España','KOI nació a finales de 2021 de la mano de Ibai Llanos y Gerard Piqué, debutando con un éxito masivo de audiencia en la Superliga española. Tras un inicio fulgurante, el equipo buscó expandirse globalmente mediante una alianza con Rogue para entrar en la LEC, la máxima competición europea. Sin embargo, tras problemas internos y financieros en la estructura de Infinite Reality, Ibai decidió separar caminos y refundar el proyecto. Actualmente, KOI vive una nueva etapa bajo el nombre de Movistar KOI, tras fusionarse con Movistar Riders y MAD Lions para consolidarse como el gran referente del gaming hispano.','https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/bd/Movistar_KOIlogo_square.png/revision/latest/scale-to-width-down/220?cb=20240528162718',NULL,NULL,'Movistar Koi',3,1,NULL),(4,'Corea del Sur','Fundado en 2012 por SK Telecom, T1 se convirtió en el equipo más legendario de los esports liderado por el prodigio Faker. Tras conquistar su primer mundial en 2013, establecieron una hegemonía absoluta logrando el bicampeonato consecutivo en 2015 y 2016. Tras años de sequía y cambios de marca, la organización renació con el quinteto ZOFGK, logrando una redención histórica. Recientemente, consolidaron su estatus de \"Jefe Final\" del League of Legends al alcanzar su quinto trofeo mundial, demostrando una longevidad competitiva que no tiene comparación en la historia del juego.','https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/T1_esports_logo.svg/1280px-T1_esports_logo.svg.png',NULL,NULL,'T1',18,1,NULL);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trainer_age` int DEFAULT NULL,
  `trainer_country` varchar(255) DEFAULT NULL,
  `trainer_name` varchar(255) DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `game_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKktdj07v41xiwh0jm7yantkdwd` (`team_id`),
  KEY `FKgjm8x3wnwdajvupbbj3ogtd2b` (`game_id`),
  CONSTRAINT `FKgjm8x3wnwdajvupbbj3ogtd2b` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FKlqmgwsj1pmfdyibumr3dbei97` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (3,31,'España','Tomás Campelo',3,1,'https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/c/c2/G2A_Melzhet_2022_Split_1.png/revision/latest/scale-to-width-down/250?cb=20220110122107'),(4,36,'Corea del Sur','Kim Jeong-gyun',4,1,'https://i.namu.wiki/i/N_mu1tSMgYymgVu3J3tv1Z3Q5mdFIASfX7saZX0whQ-eyLjQn8WJQQVZo6uAWeestvUpKw6Ft6xh60z5JhZAnw.webp');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (5,'admin@mail.com','$2a$10$BBUkHEhxTcIkfkukUAmeBumSa/YFhND/bIJhSQK8umQQArxndMQ7C','admin'),(11,'user@mail.com','$2a$10$xg.FuBsrGluOR21hd/cV9eFBCCqrX0Qz1Ri5AcfEwRl0HwO2vgF7W','user');
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
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (11,3),(5,4);
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

-- Dump completed on 2026-04-30 16:43:58
