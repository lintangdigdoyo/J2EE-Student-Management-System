/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.5.60-log : Database - students
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`students` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `students`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `studentgrade` */

DROP TABLE IF EXISTS `studentgrade`;

CREATE TABLE `studentgrade` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `grade` int(10) DEFAULT NULL,
  `course_id` int(10) DEFAULT NULL,
  `studentinfo_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `studentinfo_id` (`studentinfo_id`),
  CONSTRAINT `studentgrade_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `studentgrade_ibfk_2` FOREIGN KEY (`studentinfo_id`) REFERENCES `studentinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Table structure for table `studentinfo` */

DROP TABLE IF EXISTS `studentinfo`;

CREATE TABLE `studentinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(50) DEFAULT NULL,
  `student_number` varchar(20) DEFAULT NULL,
  `studentpicurl` varchar(50) DEFAULT NULL,
  `majors` varchar(50) DEFAULT NULL,
  `faculty` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_number` (`student_number`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
