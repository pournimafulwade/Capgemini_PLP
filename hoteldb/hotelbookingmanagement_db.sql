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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `booking_info` */

insert  into `booking_info`(`bookingId`,`roomId`,`userId`,`roomRent`,`paymentStatus`,`modeOfPayment`,`checkinDate`,`checkoutDate`,`totalDays`,`hotelId`,`userName`,`hotelName`) values 
(1,1,2,1999.00,'success','cash','2019-12-23','2019-12-30',8,2,'kartik tyagi','Petrion Hotel'),
(2,2,3,2999.90,'success','cash','2019-12-12','2019-12-25',13,2,'Shubham Sutar','Petrion Hotel'),
(3,2,2,1999.00,'success','cash','2019-12-12','2019-12-25',13,3,'kartik tyagi','Sahara Hotel'),
(4,2,2,1999.00,'success','cash','2019-12-12','2019-12-25',13,3,'kartik tyagi','Taaj Hotel');

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotelId` int(20) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `imgURL` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotelId`,`hotelName`,`location`,`imgURL`) values 
(1,'Grand Hyatt','karnataka','https://cdn.pixabay.com/photo/2016/08/26/20/30/hotel-1623064__340.jpg'),
(2,'Petrion Hotel','SitaCircle karnataka','https://cdn.pixabay.com/photo/2016/02/19/10/01/hotel-1209021__340.jpg'),
(3,'Oyo','Karnataka','https://image.shutterstock.com/image-photo/real-estate-luxury-interior-exterior-260nw-660324757.jpg'),
(4,'Taaj Hotel','Mumbai','https://image.shutterstock.com/image-photo/beautiful-taj-mahal-hotel-260nw-1455231200.jpg'),
(5,'5 Star','Mumbai','https://image.shutterstock.com/image-photo/luxury-five-star-hotel-entrance-260nw-618129716.jpg'),
(6,'The Oberoi','Bangalore','https://cdn.pixabay.com/photo/2015/09/02/13/13/resort-918952__340.jpg'),
(8,'One Squre','Nainital','https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789__340.jpg');

/*Table structure for table `room_info` */

DROP TABLE IF EXISTS `room_info`;

CREATE TABLE `room_info` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `roomRent` double(6,2) DEFAULT NULL,
  `roomType` varchar(20) DEFAULT NULL,
  `roomCapacity` bigint(20) DEFAULT NULL,
  `roomStatus` varchar(20) DEFAULT NULL,
  `hotelId` int(11) DEFAULT NULL,
  `imgURL` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `room_info` */

insert  into `room_info`(`roomId`,`roomRent`,`roomType`,`roomCapacity`,`roomStatus`,`hotelId`,`imgURL`) values 
(2,1999.00,'AC',3,'Available',1,'https://image.shutterstock.com/image-illustration/bright-cozy-modern-bedroom-dressing-260nw-560973166.jpg'),
(3,1999.00,'AC',4,'Available',2,'https://cdn.pixabay.com/photo/2014/09/25/18/05/bedroom-460762__340.jpg'),
(4,2999.00,'AC',3,'Available',2,'https://cdn.pixabay.com/photo/2016/04/15/11/45/hotel-1330841__340.jpg'),
(5,5999.99,'AC',4,'Available',3,'https://cdn.pixabay.com/photo/2014/05/17/18/03/lobby-346426__340.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_registration` */

insert  into `user_registration`(`userId`,`userName`,`userEmail`,`userPassword`,`mobile`,`address`,`nationality`,`userType`,`hotelId`) values 
(1,'pournima fulwade','pournima@gmail.com','Pournima07','8689929864','Sam atithi Pavathi karnataka ','Indian','Admin',1),
(2,'kartik tyagi','kartik@gmail.com','Kartik07','7894564121','Andhra palace karnataka ','Indian','User',1),
(3,'Shubham Sutar','shubham@gmail.com','Abhishek07','78945613127','Jay Ganesh chawl,Mumbai','American','employee',1),
(4,'Amruta Patil','amruta@gmail.com','Amruta07','8945672316','Star pg,karnataka','Indian','User',0),
(5,'Pragya Tiwari','pragya@gmail.com','Pragya07','8945672316','Star pg,karnataka','Indian','employee',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
