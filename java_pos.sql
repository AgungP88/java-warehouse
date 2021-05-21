-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Des 2020 pada 09.03
-- Versi server: 10.1.40-MariaDB
-- Versi PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_pos`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `idBarang` int(5) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `jenisBarang` varchar(30) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `ukuran` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`idBarang`, `namaBarang`, `jenisBarang`, `satuan`, `ukuran`, `harga`) VALUES
(1, 'rinso', 'detergen', 'kg', '2', 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `idPelanggan` int(11) NOT NULL,
  `namaPelanggan` varchar(50) NOT NULL,
  `noHp` varchar(20) NOT NULL,
  `jenisKelamin` varchar(20) NOT NULL,
  `umur` varchar(20) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`idPelanggan`, `namaPelanggan`, `noHp`, `jenisKelamin`, `umur`, `alamat`) VALUES
(1, 'agung', '1234567', 'Pria', '19', 'bekasi'),
(2, 'towbot', '432431', 'Pria', '20', 'karawang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasok`
--

CREATE TABLE `pemasok` (
  `idPemasok` int(5) NOT NULL,
  `namaPemasok` varchar(25) NOT NULL,
  `namaBarang` varchar(25) NOT NULL,
  `jumlah` int(5) NOT NULL,
  `alamatPemasok` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pemasok`
--

INSERT INTO `pemasok` (`idPemasok`, `namaPemasok`, `namaBarang`, `jumlah`, `alamatPemasok`) VALUES
(1, 'bisnet', 'router', 5, 'Bekasi');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`idPelanggan`);

--
-- Indeks untuk tabel `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`idPemasok`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `idBarang` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `idPelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `pemasok`
--
ALTER TABLE `pemasok`
  MODIFY `idPemasok` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
