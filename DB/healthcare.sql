-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 02:28 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PID` int(11) NOT NULL,
  `Pname` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Age` int(11) NOT NULL,
  `Blood_group` varchar(10) NOT NULL,
  `Pcontact` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`PID`, `Pname`, `Gender`, `Age`, `Blood_group`, `Pcontact`) VALUES
(1, 'pasindu', 'male', 23, 'A+', '0012345678'),
(3, 'kalhan', 'male', 25, 'B+', '4567891230'),
(5, 'kalhan', 'male', 23, 'B-', '4567891230'),
(6, 'pts', 'male', 20, 'o', '123465'),
(7, 'pts', 'male', 20, 'o', '123465'),
(8, 'pasindu', 'male', 23, 'AA', '0012345678'),
(9, 'pts', 'male', 8, 'AA', '045678931'),
(10, 'thushan', 'male', 20, 'O-', '753951123'),
(11, 'pasindu', 'male', 23, 'A+', '0'),
(12, 'pasindu', 'male', 23, 'A+', '00000000000'),
(13, 'pasindu', 'male', 23, 'A+', '1111111'),
(14, 'pasindu', 'male', 23, 'A+', '3333333');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
