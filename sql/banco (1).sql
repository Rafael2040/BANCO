-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2021 at 07:31 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banco`
--
CREATE DATABASE IF NOT EXISTS `banco` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `banco`;

-- --------------------------------------------------------

--
-- Table structure for table `conta_bancaria`
--

CREATE TABLE `conta_bancaria` (
  `id` tinyint(4) NOT NULL,
  `agencia` varchar(250) NOT NULL,
  `conta` varchar(250) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `corrente_Poupaça` tinyint(1) NOT NULL DEFAULT 0,
  `saldo` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `conta_bancaria`
--

INSERT INTO `conta_bancaria` (`id`, `agencia`, `conta`, `nome`, `corrente_Poupaça`, `saldo`) VALUES
(6, 'asdsad', 'asdsad', 'asdad', 1, '22.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `conta_bancaria`
--
ALTER TABLE `conta_bancaria`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `conta_bancaria`
--
ALTER TABLE `conta_bancaria`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
