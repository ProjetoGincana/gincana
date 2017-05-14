-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gincana
-- ------------------------------------------------------
-- Server version	5.7.12-log

DROP DATABASE IF EXISTS `gincana`;
CREATE DATABASE `gincana`;
USE gincana;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atividade`
--

DROP TABLE IF EXISTS `atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividade` (
  `id_atividade` bigint(20) NOT NULL AUTO_INCREMENT,
  `acao_atividade` varchar(255) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FKnlevm692u469x5f76dxh7bmr` (`id_usuario`),
  CONSTRAINT `FKnlevm692u469x5f76dxh7bmr` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade`
--

LOCK TABLES `atividade` WRITE;
/*!40000 ALTER TABLE `atividade` DISABLE KEYS */;
/*!40000 ALTER TABLE `atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edicao`
--

DROP TABLE IF EXISTS `edicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edicao` (
  `id_edicao` bigint(20) NOT NULL AUTO_INCREMENT,
  `primaria_edicao` varchar(255) NOT NULL,
  `secundaria_edicao` varchar(255) NOT NULL,
  `terciaria_edicao` varchar(255) NOT NULL,
  `descricao_edicao` varchar(255) NOT NULL,
  `tema_edicao` varchar(255) NOT NULL,
  `titulo_edicao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_edicao`),
  UNIQUE KEY `UK_l7gvgl1vk9mikbxpkiwf7w97e` (`tema_edicao`),
  UNIQUE KEY `UK_m573wvibfnr9m56bqfsqsp3qy` (`titulo_edicao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicao`
--

LOCK TABLES `edicao` WRITE;
/*!40000 ALTER TABLE `edicao` DISABLE KEYS */;
INSERT INTO `edicao` VALUES (1,'black','black','black','Teste da Gincana','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.','O Teste');
/*!40000 ALTER TABLE `edicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe` (
  `id_equipe` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao_equipe` varchar(255) NOT NULL,
  `nome_equipe` varchar(255) NOT NULL,
  `foto_equipe` varchar(255) NOT NULL,
  PRIMARY KEY (`id_equipe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','A Equipe de Teste','img/usuario-padrao.png'),(2,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Outra Equipe de Teste','img/usuario-padrao.png');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao`
--

DROP TABLE IF EXISTS `inscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscricao` (
  `id_inscricao` bigint(20) NOT NULL AUTO_INCREMENT,
  `envio_inscricao` date NOT NULL,
  `parecer_inscricao` varchar(255) NOT NULL,
  `resposta_inscricao` date NOT NULL,
  `status_inscricao` bit(1) NOT NULL,
  `id_edicao` bigint(20) DEFAULT NULL,
  `id_equipe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_inscricao`),
  KEY `FK5mj0eudo3el9p59g19wi7k06h` (`id_edicao`),
  KEY `FK5698gwu1c23bugda6lwanwaq5` (`id_equipe`),
  CONSTRAINT `FK5698gwu1c23bugda6lwanwaq5` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`),
  CONSTRAINT `FK5mj0eudo3el9p59g19wi7k06h` FOREIGN KEY (`id_edicao`) REFERENCES `edicao` (`id_edicao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao`
--

LOCK TABLES `inscricao` WRITE;
/*!40000 ALTER TABLE `inscricao` DISABLE KEYS */;
INSERT INTO `inscricao` VALUES (1,'2017-05-12','Aceito','2017-05-13','',1,1),(2,'2017-05-12','Aceito','2017-05-13','',1,2);
/*!40000 ALTER TABLE `inscricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id_nota` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor_nota` double DEFAULT NULL,
  `id_equipe` bigint(20) DEFAULT NULL,
  `id_prova` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `FKo10c3k28da980ouy82lwaac0t` (`id_equipe`),
  KEY `FKlebe7cgl45evw2gjchaqiuam9` (`id_prova`),
  CONSTRAINT `FKlebe7cgl45evw2gjchaqiuam9` FOREIGN KEY (`id_prova`) REFERENCES `prova` (`id_prova`),
  CONSTRAINT `FKo10c3k28da980ouy82lwaac0t` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (1,8.5,1,1),(2,9.5,2,1),(3,7,1,2),(4,8.5,2,2);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prova`
--

DROP TABLE IF EXISTS `prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prova` (
  `id_prova` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao_prova` varchar(255) NOT NULL,
  `divulgacao_prova` date NOT NULL,
  `divulgacao_nota_prova` date NOT NULL,
  `local_prova` varchar(255) NOT NULL,
  `numero_participantes_prova` int(11) NOT NULL,
  `peso_prova` int(11) NOT NULL,
  `id_edicao` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_prova`),
  KEY `FKbljuecdud7rsem9q7g040sviy` (`id_edicao`),
  CONSTRAINT `FKbljuecdud7rsem9q7g040sviy` FOREIGN KEY (`id_edicao`) REFERENCES `edicao` (`id_edicao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prova`
--

LOCK TABLES `prova` WRITE;
/*!40000 ALTER TABLE `prova` DISABLE KEYS */;
INSERT INTO `prova` VALUES (1,'Correr ao redor','2017-05-13','2017-05-13','Biblioteca',4,5,1),(2,'Pular Corda','2017-05-13','2017-05-13','Estacionamento',1,5,1);
/*!40000 ALTER TABLE `prova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurso` (
  `id_recurso` bigint(20) NOT NULL AUTO_INCREMENT,
  `conteudo_recurso` varchar(255) NOT NULL,
  `envio_recurso` date NOT NULL,
  `parecer_recurso` varchar(255) NOT NULL,
  `resposta_recurso` date NOT NULL,
  `status_recurso` bit(1) NOT NULL,
  `id_prova` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  KEY `FKqyt59t4wk9hc6tme34cjdhjqq` (`id_prova`),
  KEY `FK1297nj8ki91hgic67p2j9wcri` (`id_usuario`),
  CONSTRAINT `FK1297nj8ki91hgic67p2j9wcri` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKqyt59t4wk9hc6tme34cjdhjqq` FOREIGN KEY (`id_prova`) REFERENCES `prova` (`id_prova`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso`
--

LOCK TABLES `recurso` WRITE;
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `curso_usuario` varchar(255) DEFAULT NULL,
  `email_usuario` varchar(255) NOT NULL,
  `tipo_usuario` varchar(255) NOT NULL,
  `lider_usuario` bit(1) NOT NULL,
  `nascimento_usuario` date NOT NULL,
  `nome_usuario` varchar(255) NOT NULL,
  `senha_usuario` varchar(255) NOT NULL,
  `status_usuario` bit(1) NOT NULL,
  `turma_usuario` varchar(255) DEFAULT NULL,
  `id_equipe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_isxwoo508iq2mrksqgheuh3r3` (`email_usuario`),
  KEY `FKe4vusx50ur5sqh44n49q4tchd` (`id_equipe`),
  CONSTRAINT `FKe4vusx50ur5sqh44n49q4tchd` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'INFQ','aluno1@local','ALUNO','','2010-05-10','Aluno 1','$2a$10$4M04KbnCRcRnYPPeeqjTsuQFUsOuG1qFnj1vO4vM/YzLQ.a36mKh6','','XI',1),(2,'EVENQ','aluno2@local','ALUNO','\0','2010-05-11','Aluno 2','$2a$10$4M04KbnCRcRnYPPeeqjTsuQFUsOuG1qFnj1vO4vM/YzLQ.a36mKh6','','XI',1),(3,'PLAQ','aluno3@local','ALUNO','','2010-05-13','Aluno 3','$2a$10$4M04KbnCRcRnYPPeeqjTsuQFUsOuG1qFnj1vO4vM/YzLQ.a36mKh6','','XI',2),(4,'INFQ','aluno4@local','ALUNO','\0','2010-05-14','Aluno 4','$2a$10$4M04KbnCRcRnYPPeeqjTsuQFUsOuG1qFnj1vO4vM/YzLQ.a36mKh6','','XI',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-14 18:55:59
