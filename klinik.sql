-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2017 at 07:01 AM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `klinik`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_admin`
--

CREATE TABLE `tabel_admin` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nohp` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tabel_apoteker`
--

CREATE TABLE `tabel_apoteker` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nohp` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_apoteker`
--

INSERT INTO `tabel_apoteker` (`id`, `nama`, `alamat`, `nohp`, `username`, `password`) VALUES
(1, 'sinta', 'jalan sinsin', '0214429238', 'sinta', 'sinta123');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_customerservice`
--

CREATE TABLE `tabel_customerservice` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `nohp` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_customerservice`
--

INSERT INTO `tabel_customerservice` (`id`, `nama`, `alamat`, `nohp`, `username`, `password`) VALUES
(1, 'Antoni', 'jalan jalan ', '0214242428', 'antoni', 'antoni123');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_dokter`
--

CREATE TABLE `tabel_dokter` (
  `id_dokter` varchar(11) NOT NULL,
  `nama_dokter` varchar(50) NOT NULL,
  `jk_dokter` enum('Laki-Laki','Perempuan') NOT NULL,
  `tarif_dokter` int(11) NOT NULL,
  `status_dokter` enum('aktif','tidak aktif') NOT NULL,
  `nohp_dokter` varchar(13) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_dokter`
--

INSERT INTO `tabel_dokter` (`id_dokter`, `nama_dokter`, `jk_dokter`, `tarif_dokter`, `status_dokter`, `nohp_dokter`, `username`, `password`) VALUES
('DR-01', 'test', 'Laki-Laki', 21111, 'aktif', '21321312', '', ''),
('DR-02', 'testy', 'Laki-Laki', 21111, 'aktif', '21321312', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_obat`
--

CREATE TABLE `tabel_obat` (
  `id_obat` varchar(15) NOT NULL,
  `nama_obat` varchar(255) NOT NULL,
  `harga_obat` int(11) NOT NULL,
  `stok_obat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_obat`
--

INSERT INTO `tabel_obat` (`id_obat`, `nama_obat`, `harga_obat`, `stok_obat`) VALUES
('OB-01', 'Promag', 100000, 100),
('OB-02', 'Bodrex', 100000, 100);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pasien`
--

CREATE TABLE `tabel_pasien` (
  `id_pasien` int(50) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `jk_pasien` enum('Laki-Laki','Perempuan','','') NOT NULL,
  `alamat_pasien` text NOT NULL,
  `tgllahir_pasien` date NOT NULL,
  `nohp_pasien` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pasien`
--

INSERT INTO `tabel_pasien` (`id_pasien`, `nama_pasien`, `jk_pasien`, `alamat_pasien`, `tgllahir_pasien`, `nohp_pasien`) VALUES
(1, 'test', 'Laki-Laki', 'test', '2017-02-20', '081291042'),
(2, 'testerer', 'Laki-Laki', 'tester', '2017-02-20', '081291042');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pemeriksaan`
--

CREATE TABLE `tabel_pemeriksaan` (
  `kode_pemeriksaan` int(11) NOT NULL,
  `id_dokter` varchar(255) NOT NULL,
  `id_pasien` varchar(255) NOT NULL,
  `tanggal_pemeriksaan` datetime NOT NULL,
  `status_pemeriksaan` enum('Pending','On Process','Waiting Payment','Success','Cancel') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pemeriksaan`
--

INSERT INTO `tabel_pemeriksaan` (`kode_pemeriksaan`, `id_dokter`, `id_pasien`, `tanggal_pemeriksaan`, `status_pemeriksaan`) VALUES
(1, 'DR-01', '1', '2017-07-03 00:00:00', 'Waiting Payment'),
(2, 'DR-01', '1', '2017-07-03 17:15:11', 'Success'),
(3, 'DR-02', '2', '2017-07-05 22:42:15', 'Waiting Payment');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_resep`
--

CREATE TABLE `tabel_resep` (
  `id` int(11) NOT NULL,
  `id_pemeriksaan` int(11) NOT NULL,
  `id_obat` varchar(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_resep`
--

INSERT INTO `tabel_resep` (`id`, `id_pemeriksaan`, `id_obat`, `jumlah`, `harga`, `keterangan`) VALUES
(1, 1, 'OB-01', 1, 100000, '3x1hari'),
(2, 1, 'OB-02', 2, 100000, '1x1 hari');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_transaksi`
--

CREATE TABLE `tabel_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pemeriksaan` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL,
  `tanggal_bayar` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_admin`
--
ALTER TABLE `tabel_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_apoteker`
--
ALTER TABLE `tabel_apoteker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_customerservice`
--
ALTER TABLE `tabel_customerservice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_dokter`
--
ALTER TABLE `tabel_dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indexes for table `tabel_obat`
--
ALTER TABLE `tabel_obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `tabel_pasien`
--
ALTER TABLE `tabel_pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indexes for table `tabel_pemeriksaan`
--
ALTER TABLE `tabel_pemeriksaan`
  ADD PRIMARY KEY (`kode_pemeriksaan`);

--
-- Indexes for table `tabel_resep`
--
ALTER TABLE `tabel_resep`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_admin`
--
ALTER TABLE `tabel_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tabel_apoteker`
--
ALTER TABLE `tabel_apoteker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tabel_customerservice`
--
ALTER TABLE `tabel_customerservice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tabel_pasien`
--
ALTER TABLE `tabel_pasien`
  MODIFY `id_pasien` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tabel_pemeriksaan`
--
ALTER TABLE `tabel_pemeriksaan`
  MODIFY `kode_pemeriksaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tabel_resep`
--
ALTER TABLE `tabel_resep`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
