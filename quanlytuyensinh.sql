-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 04, 2021 lúc 06:02 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlytuyensinh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctkhoi`
--

CREATE TABLE `ctkhoi` (
  `maKhoi` varchar(10) NOT NULL,
  `maMon` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ctkhoi`
--

INSERT INTO `ctkhoi` (`maKhoi`, `maMon`) VALUES
('KHOI01', 'MON01'),
('KHOI01', 'MON02'),
('KHOI01', 'MON03'),
('KHOI02', 'MON01'),
('KHOI02', 'MON03'),
('KHOI02', 'MON04'),
('KHOI03', 'MON05'),
('KHOI03', 'MON06'),
('KHOI03', 'MON07');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diemthi`
--

CREATE TABLE `diemthi` (
  `soBaoDanh` varchar(10) NOT NULL,
  `maMon` varchar(10) NOT NULL,
  `diem` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `diemthi`
--

INSERT INTO `diemthi` (`soBaoDanh`, `maMon`, `diem`) VALUES
('2018600804', 'MON05', 9),
('2018600804', 'MON06', 9),
('2018600804', 'MON07', 9),
('2018601761', 'MON01', 10),
('2018601761', 'MON03', 9),
('2018601761', 'MON04', 8),
('2018601856', 'MON01', 10),
('2018601856', 'MON02', 9),
('2018601856', 'MON03', 9),
('21', 'MON05', 3),
('21', 'MON06', 3),
('21', 'MON07', 3),
('a', 'MON01', 1),
('a', 'MON03', 2),
('a', 'MON04', 3),
('b', 'MON01', 5),
('b', 'MON02', 5),
('b', 'MON03', 5),
('d', 'MON05', 3),
('d', 'MON06', 3),
('d', 'MON07', 3),
('e', 'MON01', 2),
('e', 'MON03', 3),
('e', 'MON04', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoi`
--

CREATE TABLE `khoi` (
  `maKhoi` varchar(10) NOT NULL,
  `tenKhoi` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khoi`
--

INSERT INTO `khoi` (`maKhoi`, `tenKhoi`) VALUES
('KHOI01', 'A'),
('KHOI02', 'B'),
('KHOI03', 'C');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuvuc`
--

CREATE TABLE `khuvuc` (
  `maKhuVuc` varchar(10) NOT NULL,
  `diemUuTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khuvuc`
--

INSERT INTO `khuvuc` (`maKhuVuc`, `diemUuTien`) VALUES
('KV1', 0.75),
('KV2', 0.25),
('KV2-NT', 0.5),
('KV3', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mon`
--

CREATE TABLE `mon` (
  `maMon` varchar(6) NOT NULL,
  `tenMon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `mon`
--

INSERT INTO `mon` (`maMon`, `tenMon`) VALUES
('MON01', 'Toán'),
('MON02', 'Lý'),
('MON03', 'Hóa'),
('MON04', 'Sinh'),
('MON05', 'Văn'),
('MON06', 'Sử'),
('MON07', 'Địa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thisinh`
--

CREATE TABLE `thisinh` (
  `soBaoDanh` varchar(10) NOT NULL,
  `maKhuVuc` varchar(10) NOT NULL,
  `maKhoi` varchar(10) NOT NULL,
  `hoTen` varchar(100) NOT NULL,
  `diaChi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thisinh`
--

INSERT INTO `thisinh` (`soBaoDanh`, `maKhuVuc`, `maKhoi`, `hoTen`, `diaChi`) VALUES
('2018600804', 'KV1', 'KHOI03', 'Nguyễn Xuân Quang', 'Quảng Ninh'),
('2018601761', 'KV2-NT', 'KHOI02', 'Trần Công Sơn', 'Hải Dương'),
('2018601856', 'KV2', 'KHOI01', 'Hoàng Văn Thắng', 'Thường Tín - Hà Nội'),
('21', 'KV3', 'KHOI03', 's', 's'),
('a', 'KV2-NT', 'KHOI02', 'a', 'a'),
('b', 'KV2-NT', 'KHOI01', 'b', 'b'),
('d', 'KV2-NT', 'KHOI03', 'd', 'd'),
('e', 'KV3', 'KHOI02', 'e', 'e');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctkhoi`
--
ALTER TABLE `ctkhoi`
  ADD PRIMARY KEY (`maKhoi`,`maMon`),
  ADD KEY `fk_CTKHOI_MON` (`maMon`);

--
-- Chỉ mục cho bảng `diemthi`
--
ALTER TABLE `diemthi`
  ADD PRIMARY KEY (`soBaoDanh`,`maMon`),
  ADD KEY `fk_DIEMTHI_MON` (`maMon`);

--
-- Chỉ mục cho bảng `khoi`
--
ALTER TABLE `khoi`
  ADD PRIMARY KEY (`maKhoi`);

--
-- Chỉ mục cho bảng `khuvuc`
--
ALTER TABLE `khuvuc`
  ADD PRIMARY KEY (`maKhuVuc`);

--
-- Chỉ mục cho bảng `mon`
--
ALTER TABLE `mon`
  ADD PRIMARY KEY (`maMon`);

--
-- Chỉ mục cho bảng `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`soBaoDanh`),
  ADD KEY `fk_THISINH_KHUVUC` (`maKhuVuc`),
  ADD KEY `fk_THISINH_KHOI` (`maKhoi`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctkhoi`
--
ALTER TABLE `ctkhoi`
  ADD CONSTRAINT `fk_CTKHOI_KHOI` FOREIGN KEY (`maKhoi`) REFERENCES `khoi` (`maKhoi`),
  ADD CONSTRAINT `fk_CTKHOI_MON` FOREIGN KEY (`maMon`) REFERENCES `mon` (`maMon`);

--
-- Các ràng buộc cho bảng `diemthi`
--
ALTER TABLE `diemthi`
  ADD CONSTRAINT `fk_DIEMTHI_MON` FOREIGN KEY (`maMon`) REFERENCES `mon` (`maMon`),
  ADD CONSTRAINT `fk_DIEMTHI_THISINH` FOREIGN KEY (`soBaoDanh`) REFERENCES `thisinh` (`soBaoDanh`);

--
-- Các ràng buộc cho bảng `thisinh`
--
ALTER TABLE `thisinh`
  ADD CONSTRAINT `fk_THISINH_KHOI` FOREIGN KEY (`maKhoi`) REFERENCES `khoi` (`maKhoi`),
  ADD CONSTRAINT `fk_THISINH_KHUVUC` FOREIGN KEY (`maKhuVuc`) REFERENCES `khuvuc` (`maKhuVuc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;