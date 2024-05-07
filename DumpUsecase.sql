-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: salary
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `bankdetails`
--

DROP TABLE IF EXISTS `bankdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankdetails` (
  `BankDetailID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int DEFAULT NULL,
  `AccountNumber` varchar(10) DEFAULT NULL,
  `BankName` varchar(20) DEFAULT NULL,
  `BranchName` varchar(15) DEFAULT NULL,
  `IFSCCode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`BankDetailID`),
  KEY `EmployeeID` (`EmployeeID`),
  CONSTRAINT `bankdetails_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankdetails`
--

LOCK TABLES `bankdetails` WRITE;
/*!40000 ALTER TABLE `bankdetails` DISABLE KEYS */;
INSERT INTO `bankdetails` VALUES (1,1,'1234567890','AXIS Bank','TVM Branch','ABC1234567'),(2,2,'0987654321','SBI','KLM Branch','XYZ9876543'),(3,3,'2468101214','Canara Bank','PTA Branch','PQR2468101'),(4,4,'1357924680','Federal Bank','KTYM Branch','DEF1357924'),(5,5,'9876543210','SBI','KTYM Branch','MNO9876543'),(7,1,'6','SBI','KAZHAKOOTAM','KAZA0001');
/*!40000 ALTER TABLE `bankdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EmployeeID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) DEFAULT NULL,
  `LastName` varchar(20) DEFAULT NULL,
  `JoinDate` date DEFAULT NULL,
  `GradeID` int DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `FK_Employee_Grade` (`GradeID`),
  CONSTRAINT `FK_Employee_Grade` FOREIGN KEY (`GradeID`) REFERENCES `grade` (`GradeID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Fardeen','Gandhi','2014-01-15',1),(2,'Kamath','Sreeram','2013-08-20',2),(3,'Gandhi','Arjun','2012-11-10',1),(4,'Virat','Kohli','2014-03-05',3),(5,'Sachin','Tendulkar','2013-05-12',2),(6,'Aswin','Sundar','2024-05-03',1),(7,'Amal','Roy','2020-10-26',2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `GradeID` int NOT NULL AUTO_INCREMENT,
  `GradeName` varchar(15) DEFAULT NULL,
  `GradeBasic` int DEFAULT NULL,
  `GradeTA` int DEFAULT NULL,
  `GradeHRA` int DEFAULT NULL,
  `GradeMA` int DEFAULT NULL,
  `GradeBonus` int DEFAULT NULL,
  `GradePF` int DEFAULT NULL,
  `GradePT` int DEFAULT NULL,
  PRIMARY KEY (`GradeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'Grade A',50000,3000,2000,1500,5000,5000,200),(2,'Grade B',40000,2500,1800,1200,4000,4500,150),(3,'Grade C',35000,2000,1500,1000,3500,4000,100);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  `BankName` varchar(50) DEFAULT NULL,
  `TransactionDate` varchar(20) DEFAULT NULL,
  `TransactionStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TransactionID`),
  KEY `EmployeeID` (`EmployeeID`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1001,1,56300,'HDFC Bank','2024-05-01','Completed'),(1002,2,44850,'HDFC Bank','2024-04-28','Pending'),(1003,3,56300,'HDFC Bank','2024-04-30','Completed'),(1004,4,38900,'HDFC Bank','2024-04-30','Processing'),(1005,5,44850,'HDFC Bank','2024-04-29','Completed'),(2003,6,56000,'HDFC','2024-05-03','PROCESSING');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:16:01
