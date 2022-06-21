-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2022 at 03:58 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uasdisprog`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrastor`
--

CREATE TABLE `administrastor` (
  `KodeAdministrator` int(11) NOT NULL,
  `Username` varchar(8) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mitrarestaurant`
--

CREATE TABLE `mitrarestaurant` (
  `KodeRestaurant` int(11) NOT NULL,
  `NamaPemilik` varchar(45) NOT NULL,
  `NamaRestaurant` varchar(45) NOT NULL,
  `Username` varchar(8) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `JumlahMeja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `KodePelanggan` int(11) NOT NULL,
  `NamaPengguna` varchar(8) NOT NULL,
  `Username` varchar(8) NOT NULL,
  `Password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `KodeReservasi` int(11) NOT NULL,
  `TanggalPemesanan` datetime NOT NULL,
  `JumlahOrang` int(11) NOT NULL,
  `KodePelanggan` int(11) NOT NULL,
  `KodeMitraRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrastor`
--
ALTER TABLE `administrastor`
  ADD PRIMARY KEY (`KodeAdministrator`);

--
-- Indexes for table `mitrarestaurant`
--
ALTER TABLE `mitrarestaurant`
  ADD PRIMARY KEY (`KodeRestaurant`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`KodePelanggan`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`KodeReservasi`),
  ADD KEY `fk_Reservasi_Pelanggan_idx` (`KodePelanggan`),
  ADD KEY `fk_Reservasi_MitraRestaurant1_idx` (`KodeMitraRestaurant`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrastor`
--
ALTER TABLE `administrastor`
  MODIFY `KodeAdministrator` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mitrarestaurant`
--
ALTER TABLE `mitrarestaurant`
  MODIFY `KodeRestaurant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `KodePelanggan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `KodeReservasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `fk_Reservasi_MitraRestaurant1` FOREIGN KEY (`KodeMitraRestaurant`) REFERENCES `mitrarestaurant` (`KodeRestaurant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Reservasi_Pelanggan` FOREIGN KEY (`KodePelanggan`) REFERENCES `pelanggan` (`KodePelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
