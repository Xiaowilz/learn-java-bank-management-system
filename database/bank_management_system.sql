-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 30, 2021 at 12:39 PM
-- Server version: 5.7.24
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_branches`
--

CREATE TABLE `bank_branches` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` text NOT NULL,
  `description` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_branches`
--

INSERT INTO `bank_branches` (`id`, `name`, `location`, `description`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'BCA KCP Tanjung Pura', 'Jalan Tanjung Pura Pontianak', NULL, '2021-05-29 08:43:55', '2021-05-29 08:43:55', NULL),
(2, 'BCA KCP Iman Bonjol', 'Jalan Iman Bonjol Pontianak', NULL, '2021-05-29 08:43:55', '2021-05-29 08:43:55', NULL),
(3, 'BNI', 'Pemangkat', 'BNI', '2021-05-29 13:13:10', '2021-05-29 13:13:10', '2021-05-29 13:25:52'),
(4, 'BRI', 'Jalan', 'Nusantara', '2021-05-29 13:39:31', '2021-05-29 13:39:31', '2021-05-30 05:26:03'),
(5, 'BRI', 'KCP', 'Pemangkat', '2021-05-29 13:40:24', '2021-05-29 13:40:24', '2021-05-29 13:58:36'),
(6, '', 'BRI', 'Asd', '2021-05-29 13:43:31', '2021-05-29 13:43:31', '2021-05-29 13:57:37'),
(7, 'BRI', 'Pemangkat', 'kajdfkjd', '2021-05-29 13:48:52', '2021-05-29 13:48:52', '2021-05-29 13:58:22'),
(8, 'sdf', 'sdfsd', 'sdfsd', '2021-05-29 13:50:45', '2021-05-29 13:50:45', '2021-05-29 13:57:22'),
(9, 'Mandiri', 'Pontianak', 'Pontianak', '2021-05-29 13:58:50', '2021-05-30 08:34:44', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `nik` varchar(255) NOT NULL,
  `mother_name` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(13) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `email` text NOT NULL,
  `phone` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `email`, `phone`) VALUES
(1, 'Willy', 'xiaowilz', 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86', 'xiaowilz7@gmail.com', '081351309197'),
(2, 'Tommy', 'limtommy', '28caa410eae5ba30dabb067d31c16fca71c42a4bfc6678fe4b8ff272f3e0704f14b5a45003d1b877e57fee9edc63922f0ae578411a6dc54fbb66dc1d72dc0010', 'limtommy@gmail.com', '0824765734');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_branches`
--
ALTER TABLE `bank_branches`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_user_id_foreign` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank_branches`
--
ALTER TABLE `bank_branches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customer_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
