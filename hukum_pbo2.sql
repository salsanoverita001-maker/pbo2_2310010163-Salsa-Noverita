-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Nov 2025 pada 14.48
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hukum_pbo2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `agenda`
--

CREATE TABLE `agenda` (
  `ID_Agenda` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jam` time NOT NULL,
  `Topik` varchar(100) NOT NULL,
  `Isi` text NOT NULL,
  `Gambar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `agenda`
--

INSERT INTO `agenda` (`ID_Agenda`, `Tanggal`, `Jam`, `Topik`, `Isi`, `Gambar`) VALUES
(1, '2025-11-11', '09:00:00', 'Rapat Bulanan Pimpinan', 'Membahas evaluasi kinerja bulan Oktober 2025.', 'rapat_pimpinan.jpg'),
(2, '2025-11-12', '14:00:00', 'Sosialisasi E-Court V.3.0', 'Sosialisasi penggunaan E-Court V.3.0 kepada para advokat dan mitra.', 'sosialisasi_ecourt.jpg'),
(3, '2025-11-13', '10:00:00', 'Evaluasi Kinerja Triwulan III', 'Evaluasi kinerja triwulan ke-3 tahun 2025 bersama seluruh hakim dan pejabat.', NULL),
(4, '2025-11-14', '08:30:00', 'Briefing Petugas PTSP', 'Briefing pagi rutin untuk petugas Pelayanan Terpadu Satu Pintu (PTSP).', NULL),
(5, '2025-11-17', '13:30:00', 'Pelatihan Teknis SIPP', 'Pelatihan teknis Sistem Informasi Penelusuran Perkara (SIPP) untuk panitera pengganti.', 'pelatihan_sipp.jpg'),
(6, '2025-11-18', '09:00:00', 'Rapat Tim Zona Integritas (ZI)', 'Rapat koordinasi tim pembangunan Zona Integritas menuju WBBM.', 'zi_wbbm.png'),
(7, '2025-11-19', '11:00:00', 'Kunjungan Studi Banding PA Watampone', 'Menerima kunjungan studi banding dari Pengadilan Agama Watampone.', 'PAW.png'),
(8, '2025-11-20', '10:00:00', 'Penyusunan Laporan Tahunan 2025', 'Rapat awal tim penyusunan Laporan Tahunan (Laptah) 2025.', 'laptah.jpg'),
(9, '2025-11-21', '07:45:00', 'Apel Pagi Rutin', 'Pelaksanaan apel pagi rutin di halaman kantor.', 'apel_pagi.jpg'),
(10, '2025-11-21', '16:00:00', 'Pengajian Bulanan', 'Kegiatan siraman rohani dan pengajian bulanan untuk seluruh aparatur.', 'PBUSA.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `bagian_perkara`
--

CREATE TABLE `bagian_perkara` (
  `ID_Bagian_Perkara` int(11) NOT NULL,
  `Nama_Lengkap` varchar(100) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Hak_Akses` enum('Admin','Petugas','User') DEFAULT 'User'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `bagian_perkara`
--

INSERT INTO `bagian_perkara` (`ID_Bagian_Perkara`, `Nama_Lengkap`, `Username`, `Password`, `Hak_Akses`) VALUES
(1, 'Administrator Utama', 'admin', 'admin123', 'Admin'),
(2, 'Petugas PTSP 1', 'petugas1', 'petugas123', 'Petugas'),
(3, 'Panitera Muda Perdata', 'panitera_perdata', 'panitera123', 'Petugas'),
(4, 'Andi Susanto', 'andi_s', 'user123', 'User'),
(5, 'Budi Wibowo', 'budi_w', 'user123', 'User'),
(6, 'Rini Kartika, SH (Jaksa)', 'jaksa_rini', 'jaksa123', 'User'),
(7, 'Adi Nugroho, SH (Pengacara)', 'pengacara_adi', 'advokat123', 'User'),
(8, 'Siti Aminah (Penggugat)', 'siti_a', 'user123', 'User'),
(9, 'Petugas Arsip', 'petugas_arsip', 'arsip123', 'Petugas'),
(10, 'Pengguna Eksternal 01', 'user_eksternal', 'user123', 'User');

-- --------------------------------------------------------

--
-- Struktur dari tabel `berita`
--

CREATE TABLE `berita` (
  `ID_Berita` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jam` time NOT NULL,
  `Topik` varchar(100) NOT NULL,
  `Isi` text NOT NULL,
  `Gambar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `berita`
--

INSERT INTO `berita` (`ID_Berita`, `Tanggal`, `Jam`, `Topik`, `Isi`, `Gambar`) VALUES
(1, '2025-11-01', '10:00:00', 'Kunjungan Ketua Mahkamah Agung', 'Ketua Mahkamah Agung melakukan kunjungan kerja dan pembinaan di Pengadilan.', 'kunjungan_kma.jpg'),
(2, '2025-11-03', '14:00:00', 'Pengambilan Sumpah Jabatan 2 Hakim Baru', 'Ketua Pengadilan secara resmi melantik 2 hakim baru.', 'pelantikan_hakim.jpg'),
(3, '2025-11-04', '09:00:00', 'Pengumuman Pelayanan Selama Cuti Bersama', 'Informasi jadwal pelayanan terpadu selama cuti bersama akhir tahun.', 'cuti.jpg'),
(4, '2025-11-05', '11:00:00', 'Gedung Baru Pengadilan Resmi Beroperasi', 'Gedung baru diresmikan oleh Dirjen Badilum dan siap digunakan.', 'gedung_baru.jpg'),
(5, '2025-11-06', '13:00:00', 'Sistem Antrian Online (SION) Diluncurkan', 'Untuk mempermudah layanan, kini hadir sistem antrian online SION.', 'antrian_online.png'),
(6, '2025-11-07', '15:00:00', 'Pengadilan Sukses Meraih Predikat WBK', 'Pengadilan sukses meraih predikat Wilayah Bebas dari Korupsi (WBK) 2025.', 'wbk.jpg'),
(7, '2025-11-10', '09:30:00', 'Penandatanganan MoU dengan LBH', 'Kerjasama dengan LBH Mitra Keadilan untuk Pos Bantuan Hukum (Posbakum).', 'mou_lbh.jpg'),
(8, '2025-11-11', '08:00:00', 'Kegiatan Bakti Sosial Donor Darah', 'Kegiatan bakti sosial donor darah dalam rangka HUT Pengadilan.', 'baksos.jpg'),
(9, '2025-11-12', '10:00:00', 'Upacara Peringatan HUT Mahkamah Agung', 'Upacara bendera dalam rangka peringatan HUT MA ke-80.', 'hut_ma.jpg'),
(10, '2025-11-13', '14:00:00', 'Pengadilan Jadi Tuan Rumah Seminar Hukum Nasional', 'Seminar Hukum Nasional 2025 sukses digelar di aula pengadilan.', 'seminar_hukum.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_sidang`
--

CREATE TABLE `jadwal_sidang` (
  `ID_Jadwal` int(11) NOT NULL,
  `Hari` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jam` time NOT NULL,
  `Susunan_Majlis` varchar(150) NOT NULL,
  `Acara` varchar(150) NOT NULL,
  `Ruang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jadwal_sidang`
--

INSERT INTO `jadwal_sidang` (`ID_Jadwal`, `Hari`, `Tanggal`, `Jam`, `Susunan_Majlis`, `Acara`, `Ruang`) VALUES
(1, 'Senin', '2025-11-17', '09:00:00', 'Ketua: Dr. Ahmad, Anggota: Budi, Citra', 'Pemeriksaan Saksi Perdata (No. 123/Pdt.G/2025)', 'Ruang Sidang 1'),
(2, 'Senin', '2025-11-17', '10:00:00', 'Ketua: Dr. Dian, Anggota: Eka, Fajar', 'Pembacaan Putusan Pidana (No. 45/Pid.B/2025)', 'Ruang Sidang Cakra'),
(3, 'Selasa', '2025-11-18', '09:00:00', 'Ketua: Dr. Ahmad, Anggota: Budi, Citra', 'Duplik Tergugat (No. 123/Pdt.G/2025)', 'Ruang Sidang 1'),
(4, 'Selasa', '2025-11-18', '11:00:00', 'Ketua: Dr. Gani, Anggota: Hani, Iman', 'Sidang Pertama (Gugatan Sederhana No. 01/Pdt.GS/2025)', 'Ruang Sidang 2'),
(5, 'Rabu', '2025-11-19', '10:00:00', 'Ketua: Dr. Dian, Anggota: Eka, Fajar', 'Pemeriksaan Terdakwa (No. 46/Pid.B/2025)', 'Ruang Sidang Cakra'),
(6, 'Rabu', '2025-11-19', '13:30:00', 'Ketua: Dr. Ahmad, Anggota: Budi, Citra', 'Kesimpulan Para Pihak (No. 124/Pdt.G/2025)', 'Ruang Sidang 1'),
(7, 'Kamis', '2025-11-20', '09:00:00', 'Ketua: Dr. Gani, Anggota: Hani, Iman', 'Pembacaan Ikrar Talak (No. 555/Pdt.G/2025/PA)', 'Ruang Sidang 2'),
(8, 'Kamis', '2025-11-20', '10:00:00', 'Ketua: Dr. Dian, Anggota: Eka, Fajar', 'Tuntutan Jaksa Penuntut Umum (No. 46/Pid.B/2025)', 'Ruang Sidang Cakra'),
(9, 'Jumat', '2025-11-21', '09:00:00', 'Ketua: Dr. Ahmad, Anggota: Budi, Citra', 'Putusan Sela (No. 125/Pdt.G/2025)', 'Ruang Sidang 1'),
(10, 'Jumat', '2025-11-21', '10:30:00', 'Hakim Mediator: Dr. Hani, S.H.', 'Mediasi Perkara Waris (No. 126/Pdt.G/2025)', 'Ruang Mediasi');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`ID_Agenda`);

--
-- Indeks untuk tabel `bagian_perkara`
--
ALTER TABLE `bagian_perkara`
  ADD PRIMARY KEY (`ID_Bagian_Perkara`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indeks untuk tabel `berita`
--
ALTER TABLE `berita`
  ADD PRIMARY KEY (`ID_Berita`);

--
-- Indeks untuk tabel `jadwal_sidang`
--
ALTER TABLE `jadwal_sidang`
  ADD PRIMARY KEY (`ID_Jadwal`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `agenda`
--
ALTER TABLE `agenda`
  MODIFY `ID_Agenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `bagian_perkara`
--
ALTER TABLE `bagian_perkara`
  MODIFY `ID_Bagian_Perkara` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `berita`
--
ALTER TABLE `berita`
  MODIFY `ID_Berita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `jadwal_sidang`
--
ALTER TABLE `jadwal_sidang`
  MODIFY `ID_Jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
