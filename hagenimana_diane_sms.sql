-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 08:02 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hagenimana_diane_sms`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteOldOrders` (IN `deleteDate` DATE)   BEGIN
    DELETE FROM `Order` WHERE OrderDate < deleteDate;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetCustomersWithMultipleOrders` ()   BEGIN
    SELECT C.CustomerID, C.FirstName, C.LastName
    FROM Customer C
    WHERE (SELECT COUNT(*) FROM `Order` O WHERE O.CustomerID = C.CustomerID) > 3;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetProductInfo` ()   BEGIN
    SELECT * FROM Product;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertProduct` (IN `productName` VARCHAR(255), IN `productPrice` DECIMAL(10,2), IN `productQuantity` INT)   BEGIN
    INSERT INTO Product (Name, Price, Quantity) VALUES (productName, productPrice, productQuantity);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateProduct` (IN `productId` INT, IN `newProductName` VARCHAR(255), IN `newProductPrice` DECIMAL(10,2))   BEGIN
    UPDATE Product SET Name = newProductName, Price = newProductPrice WHERE ProductID = productId;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `password`) VALUES
('supermarket@gmail.com', '000');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `FirstName`, `LastName`, `Email`, `password`) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', '000'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '1234'),
(11, 'kamugi', 'kahu', 'kamu@gmail.com', '1234');

--
-- Triggers `customer`
--
DELIMITER $$
CREATE TRIGGER `AfterDeleteCustomer` AFTER DELETE ON `customer` FOR EACH ROW BEGIN
    
    
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `customerswithmultipleorders`
-- (See below for the actual view)
--
CREATE TABLE `customerswithmultipleorders` (
`CustomerID` int(11)
,`FirstName` varchar(50)
,`LastName` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `insertproduct`
-- (See below for the actual view)
--
CREATE TABLE `insertproduct` (
`ProductID` int(11)
,`Name` varchar(255)
,`Price` decimal(10,2)
,`Quantity` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `OrderID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `OrderDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`OrderID`, `CustomerID`, `OrderDate`) VALUES
(1, 1, '2023-09-10'),
(2, 2, '2023-09-11');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `OrderDate` varchar(20) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrderID`, `CustomerID`, `ProductID`, `OrderDate`, `status`) VALUES
(1, 11, 1, '1/1/2024', 'pending'),
(2, 2, 2, '1/1/2024', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `Name`, `Price`, `Quantity`) VALUES
(1, 'bread', '1200.00', 22),
(2, 'mandazi', '5000.00', 15),
(3, 'B Juice', '7000.00', 16);

--
-- Triggers `product`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertProduct` AFTER INSERT ON `product` FOR EACH ROW BEGIN
    
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterUpdateProduct` AFTER UPDATE ON `product` FOR EACH ROW BEGIN
    
    
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `productinfo`
-- (See below for the actual view)
--
CREATE TABLE `productinfo` (
`ProductID` int(11)
,`Name` varchar(255)
,`Price` decimal(10,2)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `updatecustomer`
-- (See below for the actual view)
--
CREATE TABLE `updatecustomer` (
`CustomerID` int(11)
,`FirstName` varchar(50)
,`LastName` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(39) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Structure for view `customerswithmultipleorders`
--
DROP TABLE IF EXISTS `customerswithmultipleorders`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `customerswithmultipleorders`  AS SELECT `c`.`CustomerID` AS `CustomerID`, `c`.`FirstName` AS `FirstName`, `c`.`LastName` AS `LastName` FROM `customer` AS `c` WHERE (select count(0) from `order` `o` where `o`.`CustomerID` = `c`.`CustomerID`) > 33  ;

-- --------------------------------------------------------

--
-- Structure for view `insertproduct`
--
DROP TABLE IF EXISTS `insertproduct`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `insertproduct`  AS SELECT `product`.`ProductID` AS `ProductID`, `product`.`Name` AS `Name`, `product`.`Price` AS `Price`, `product`.`Quantity` AS `Quantity` FROM `product``product`  ;

-- --------------------------------------------------------

--
-- Structure for view `productinfo`
--
DROP TABLE IF EXISTS `productinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `productinfo`  AS SELECT `product`.`ProductID` AS `ProductID`, `product`.`Name` AS `Name`, `product`.`Price` AS `Price` FROM `product``product`  ;

-- --------------------------------------------------------

--
-- Structure for view `updatecustomer`
--
DROP TABLE IF EXISTS `updatecustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `updatecustomer`  AS SELECT `customer`.`CustomerID` AS `CustomerID`, `customer`.`FirstName` AS `FirstName`, `customer`.`LastName` AS `LastName` FROM `customer``customer`  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
