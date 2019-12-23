/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 5.5.27 : Database - hotelbookingmanagement_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotelbookingmanagement_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotelbookingmanagement_db`;

/*Table structure for table `booking_info` */

DROP TABLE IF EXISTS `booking_info`;

CREATE TABLE `booking_info` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `roomRent` double(6,2) DEFAULT NULL,
  `paymentStatus` varchar(11) DEFAULT NULL,
  `modeOfPayment` varchar(11) DEFAULT NULL,
  `checkinDate` date DEFAULT NULL,
  `checkoutDate` date DEFAULT NULL,
  `totalDays` int(10) DEFAULT NULL,
  `hotelId` int(10) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `hotelName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bookingId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `booking_info` */

insert  into `booking_info`(`bookingId`,`roomId`,`userId`,`roomRent`,`paymentStatus`,`modeOfPayment`,`checkinDate`,`checkoutDate`,`totalDays`,`hotelId`,`userName`,`hotelName`) values 
(1,1,2,1999.00,'success','cash','2019-12-23','2019-12-30',8,2,'kartik tyagi',NULL),
(2,2,3,2999.90,'success','cash','2019-12-12','2019-12-25',13,2,'Shubham Sutar',NULL),
(3,2,2,1999.00,NULL,NULL,NULL,NULL,0,0,NULL,'Sahara Hotel');

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotelId` int(20) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotelId`,`hotelName`,`location`) values 
(1,'qwerty','karnataka'),
(2,'Bunt\'s Biryani Palace','SitaCircle karnataka'),
(3,'Sahara Hotel','Mumbai'),
(4,'Taaj Hotel','Mumbai'),
(5,'5 Star','Mumbai'),
(6,'Abc','Bangalore'),
(7,'XYZ','Bangalore');

/*Table structure for table `room_info` */

DROP TABLE IF EXISTS `room_info`;

CREATE TABLE `room_info` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `roomRent` double(6,2) DEFAULT NULL,
  `roomType` varchar(20) DEFAULT NULL,
  `roomCapacity` bigint(20) DEFAULT NULL,
  `roomStatus` varchar(20) DEFAULT NULL,
  `hotelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `room_info` */

insert  into `room_info`(`roomId`,`roomRent`,`roomType`,`roomCapacity`,`roomStatus`,`hotelId`) values 
(1,3999.00,'Non-AC',3,'Available',1),
(2,1999.00,'AC',3,'Available',1),
(3,1999.00,'AC',4,'Available',2),
(4,2999.00,'AC',3,'Available',2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userType` varchar(20) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userPassword` varchar(30) DEFAULT NULL,
  `userContact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UNIQUE` (`userPassword`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`userType`,`userEmail`,`userPassword`,`userContact`) values 
(1,'pournima fulwade','Admin','pournima@gmail.com','Pournima07','8689929864'),
(2,'Kartik Tyagi','User','kartik@gmail.com','Kartik07','7894561328'),
(3,'Shubham sutar','User','shubham@gmail.com','Shubhamk07',NULL);

/*Table structure for table `user_registration` */

DROP TABLE IF EXISTS `user_registration`;

CREATE TABLE `user_registration` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  `hotelId` int(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user_registration` */

insert  into `user_registration`(`userId`,`userName`,`userEmail`,`userPassword`,`mobile`,`address`,`nationality`,`userType`,`hotelId`) values 
(1,'pournima fulwade','pournima@gmail.com','Pournima07','8689929864','Sam atithi Pavathi karnataka ','Indian','Admin',1),
(2,'kartik tyagi','kartik@gmail.com','Kartik07','7894564121','Andhra palace karnataka ','Indian','User',1),
(3,'Shubham Sutar','shubham@gmail.com','shubham10','7895613344','Pune','American','Room Manager',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
