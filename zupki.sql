-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Paź 2023, 11:27
-- Wersja serwera: 10.4.24-MariaDB
-- Wersja PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projektagile`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zupki`
--

CREATE TABLE `zupki` (
  `ID` int(11) NOT NULL,
  `Marka` varchar(255) NOT NULL,
  `Smak` varchar(255) NOT NULL,
  `Pochodzenie` varchar(255) NOT NULL,
  `Waga` int(11) NOT NULL,
  `Cena_hurtowa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `zupki`
--

INSERT INTO `zupki` (`ID`, `Marka`, `Smak`, `Pochodzenie`, `Waga`, `Cena_hurtowa`) VALUES
(1, 'Vifon', 'Pomidorowy', 'Wietnam', 70, 2.59),
(2, 'Knorr', 'Gulażowy', 'Niemcy', 61, 3.72),
(3, 'Kuksu', 'Serowy', 'Malta', 86, 6.99);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `zupki`
--
ALTER TABLE `zupki`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `zupki`
--
ALTER TABLE `zupki`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
