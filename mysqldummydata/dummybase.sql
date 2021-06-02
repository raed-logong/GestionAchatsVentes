-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2021 at 12:13 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `miniprojetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `addresses_client`
--

CREATE TABLE `addresses_client`
(
    `code`         varchar(255) NOT NULL,
    `numeroRue`    varchar(255) NOT NULL,
    `libelle`      varchar(255) NOT NULL,
    `ville`        varchar(255) NOT NULL,
    `codePostal`   varchar(255) NOT NULL,
    `gouvernourat` varchar(255) NOT NULL,
    `pays`         varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `addresses_client`
--

INSERT INTO `addresses_client` (`code`, `numeroRue`, `libelle`, `ville`, `codePostal`, `gouvernourat`, `pays`)
VALUES ('Client41', '14', 'dsfsdf', 'Tunis', '1234', 'sousse', 'tunisie'),
       ('Partner10', '1', 'sdf', 'Tunis', '1111', 'sdfsdf', 'sdfsdf'),
       ('Partner12', '125', 'dfgdgdfg', 'Tunis', '1234', 'dfgdgdf', 'dfgdfgdg'),
       ('Partner14', '22', 'fdgfd', 'Manouba', '1485', 'dfgdg', 'dfgdfg');

-- --------------------------------------------------------

--
-- Table structure for table `addresses_entreprise`
--

CREATE TABLE `addresses_entreprise`
(
    `loc`          tinyint(4)   NOT NULL,
    `ville`        varchar(255) NOT NULL,
    `codePostal`   varchar(255) NOT NULL,
    `gouvernourat` varchar(255) NOT NULL,
    `pays`         varchar(255) NOT NULL,
    `numeroRue`    varchar(255) NOT NULL,
    `libelle`      varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `addresses_entreprise`
--

INSERT INTO `addresses_entreprise` (`loc`, `ville`, `codePostal`, `gouvernourat`, `pays`, `numeroRue`, `libelle`)
VALUES (1, 'Sousse', '1234', 'sousse', 'tunisie', '12', 'rue de bla bla');

-- --------------------------------------------------------

--
-- Table structure for table `addresses_fournisseur`
--

CREATE TABLE `addresses_fournisseur`
(
    `code`         varchar(255) NOT NULL,
    `numeroRue`    varchar(255) NOT NULL,
    `libelle`      varchar(255) NOT NULL,
    `ville`        varchar(255) NOT NULL,
    `codePostal`   varchar(255) NOT NULL,
    `gouvernourat` varchar(255) NOT NULL,
    `pays`         varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `addresses_fournisseur`
--

INSERT INTO `addresses_fournisseur` (`code`, `numeroRue`, `libelle`, `ville`, `codePostal`, `gouvernourat`, `pays`)
VALUES ('codefour', '12', 'sidiabdlahid', 'Sousse', '4515', 'sidiabdlahmid', 'Tunisie'),
       ('Partner15', '15', 'fsdfsdf', 'Zaghouan', '4444', 'haha', 'haha'),
       ('test2', 'ddd', 'ddd', 'dd', 'dd', 'dd', 'dd');

-- --------------------------------------------------------

--
-- Table structure for table `bankaccounts_client`
--

CREATE TABLE `bankaccounts_client`
(
    `RIB`      varchar(20)  NOT NULL,
    `bankname` varchar(255) NOT NULL,
    `agence`   varchar(255) DEFAULT NULL,
    `code`     varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bankaccounts_client`
--

INSERT INTO `bankaccounts_client` (`RIB`, `bankname`, `agence`, `code`)
VALUES ('44545454545455454545', 'atb', 'atb', 'Client41'),
       ('dfgdfg', 'ggg', 'gg', 'Partner14'),
       ('dfgdfgdf', 'gdgdg', 'dgdfg', 'Partner12'),
       ('dfgdfggdg', 'ggg', 'gg', 'Partner14'),
       ('dsfsdf', 'dsf', 'sdf', 'Partner10');

-- --------------------------------------------------------

--
-- Table structure for table `bankaccounts_entreprise`
--

CREATE TABLE `bankaccounts_entreprise`
(
    `RIB`      varchar(20)  NOT NULL,
    `bankname` varchar(255) NOT NULL,
    `agence`   varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bankaccounts_entreprise`
--

INSERT INTO `bankaccounts_entreprise` (`RIB`, `bankname`, `agence`)
VALUES ('11111111111111', 'BIAT', 'BIAT'),
       ('2222222222222', 'BIAT', 'BIAT');

-- --------------------------------------------------------

--
-- Table structure for table `bankaccounts_fournisseur`
--

CREATE TABLE `bankaccounts_fournisseur`
(
    `RIB`      varchar(20)  NOT NULL,
    `bankname` varchar(255) NOT NULL,
    `agence`   varchar(255) DEFAULT NULL,
    `code`     varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bankaccounts_fournisseur`
--

INSERT INTO `bankaccounts_fournisseur` (`RIB`, `bankname`, `agence`, `code`)
VALUES ('45564564565', 'aggdf', 'zerfe', 'Partner15'),
       ('dsfsdfssdf2', 'dsfsdfsf', 'dsfdsfsdf', 'codefour'),
       ('dsfsdfssdf4', 'dsfsdfsf2', 'dsfdsfsdf2', 'codefour'),
       ('qsdsqdsqd', 'sqdsqd', 'qsdsqd', 'test2');

-- --------------------------------------------------------

--
-- Table structure for table `bonclient`
--

CREATE TABLE `bonclient`
(
    `id`              int(11)      NOT NULL,
    `code`            varchar(255) NOT NULL,
    `fournisseur`     varchar(255) NOT NULL,
    `datedebon`       date         NOT NULL DEFAULT curdate(),
    `datedereception` date         NOT NULL,
    `information`     varchar(255)          DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bonclient`
--

INSERT INTO `bonclient` (`id`, `code`, `fournisseur`, `datedebon`, `datedereception`, `information`)
VALUES (1, 'testbonclient', 'Client41', '2021-01-24', '2021-01-25', 'formation'),
       (2, 'Bon43', 'Partner14', '2021-01-24', '2021-01-24', ''),
       (3, 'Bon44', 'Client41', '2021-01-24', '2021-01-24', 'test'),
       (4, 'Bon54', 'Client41', '2021-01-26', '2021-01-26', '');

-- --------------------------------------------------------

--
-- Table structure for table `bonclient_produit`
--

CREATE TABLE `bonclient_produit`
(
    `id`         int(11) NOT NULL,
    `product_id` int(11)      DEFAULT NULL,
    `bon_code`   varchar(255) DEFAULT NULL,
    `quantite`   int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bonclient_produit`
--

INSERT INTO `bonclient_produit` (`id`, `product_id`, `bon_code`, `quantite`)
VALUES (1, 12, 'testbonclient', 3),
       (2, 37, 'Bon43', 5),
       (3, 24, 'Bon43', 5),
       (4, 46, 'Bon44', 3),
       (5, 47, 'Bon44', 3),
       (6, 46, 'Bon54', 9);

-- --------------------------------------------------------

--
-- Table structure for table `bonfournisseur`
--

CREATE TABLE `bonfournisseur`
(
    `id`              int(11)      NOT NULL,
    `code`            varchar(255) NOT NULL,
    `fournisseur`     varchar(255) NOT NULL,
    `datedebon`       date         NOT NULL DEFAULT curdate(),
    `datedereception` date         NOT NULL,
    `information`     varchar(255)          DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bonfournisseur`
--

INSERT INTO `bonfournisseur` (`id`, `code`, `fournisseur`, `datedebon`, `datedereception`, `information`)
VALUES (4, 'test', 'codefour', '2021-01-14', '2021-01-14', 'testformation'),
       (6, 'haha', 'test2', '2021-01-14', '2021-01-23', 'dsgdsg'),
       (7, 'testcodde', 'Partner15', '2021-01-15', '2021-01-22', 'Information'),
       (8, 'Bon16', 'codefour', '2021-01-15', '2021-01-17', 'ttsfsdfsdf'),
       (9, 'Bon17', 'Partner15', '2021-01-15', '2021-01-15', 'ggggg'),
       (10, 'Bon18', 'codefour', '2021-01-16', '2021-01-15', ''),
       (13, 'Bon21', 'codefour', '2021-01-19', '2021-01-20', ''),
       (14, 'Bon23', 'codefour', '2021-01-19', '2021-01-19', 'dgfdg'),
       (15, 'Bon24', 'codefour', '2021-01-19', '2021-01-19', 'dfgdfg'),
       (16, 'Bon31', 'codefour', '2021-01-19', '2021-01-19', ''),
       (17, 'Bon40', 'codefour', '2021-01-21', '2021-01-21', 'tetttt'),
       (18, 'Bon47', 'codefour', '2021-01-24', '2021-01-24', 'fvvfvf');

-- --------------------------------------------------------

--
-- Table structure for table `bonfournisseur_produit`
--

CREATE TABLE `bonfournisseur_produit`
(
    `id`         int(11) NOT NULL,
    `product_id` int(11)      DEFAULT NULL,
    `bon_code`   varchar(255) DEFAULT NULL,
    `quantite`   int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `bonfournisseur_produit`
--

INSERT INTO `bonfournisseur_produit` (`id`, `product_id`, `bon_code`, `quantite`)
VALUES (2, 12, 'test', 10),
       (3, 37, 'haha', 5),
       (4, 41, 'haha', 15),
       (5, 46, 'testcodde', 10),
       (6, 47, 'testcodde', 6),
       (7, 42, 'Bon16', 1),
       (8, 12, 'Bon16', 1),
       (9, 24, 'Bon16', 1),
       (10, 46, 'Bon17', 40),
       (11, 47, 'Bon17', 50),
       (12, 42, 'Bon18', 11),
       (13, 12, 'Bon18', 40),
       (14, 24, 'Bon18', 6),
       (16, 12, 'Bon24', 1),
       (19, 12, 'Bon31', 1),
       (20, 12, 'Bon40', 8),
       (21, 42, 'Bon47', 3);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client`
(
    `code`        varchar(255) NOT NULL,
    `matricule`   varchar(255) NOT NULL,
    `raison`      varchar(255) NOT NULL,
    `type`        varchar(255) NOT NULL,
    `fax`         varchar(20)  NOT NULL,
    `numportable` varchar(20)  NOT NULL,
    `numfix`      varchar(20)  NOT NULL,
    `email`       varchar(255) DEFAULT NULL,
    `siteweb`     varchar(255) DEFAULT NULL,
    `etat`        tinyint(1)   NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`code`, `matricule`, `raison`, `type`, `fax`, `numportable`, `numfix`, `email`, `siteweb`, `etat`)
VALUES ('Client41', '18/19/19', 'jean jack', 'Morale', '97979797', '97979797', '97979797', 'jaen@jack.ff', '', 1),
       ('Partner10', 'ff/44f/ffxx', 'dsfsdf', 'Morale', '12345678', '12345678', '12345678', 'fff@fff.ff', '', 0),
       ('Partner12', '114/1414/41', 'tttttt', 'Morale', '99999999', '44444444', '44444444', '', '', 1),
       ('Partner14', 'dsdds/dsd/sd', 'Attia Raed', 'Physique', '44444444', '44444444', '44444444', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `codevalue`
--

CREATE TABLE `codevalue`
(
    `code` int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `codevalue`
--

INSERT INTO `codevalue` (`code`)
VALUES (55);

-- --------------------------------------------------------

--
-- Table structure for table `entreprise`
--

CREATE TABLE `entreprise`
(
    `loc`         tinyint(4)   NOT NULL DEFAULT 1,
    `matricule`   varchar(255) NOT NULL,
    `raison`      varchar(255) NOT NULL,
    `type`        varchar(255) NOT NULL,
    `fax`         varchar(20)  NOT NULL,
    `numportable` varchar(20)  NOT NULL,
    `numfix`      varchar(20)  NOT NULL,
    `email`       varchar(255)          DEFAULT NULL,
    `siteweb`     varchar(255)          DEFAULT NULL,
    `etat`        tinyint(1)   NOT NULL,
    `description` varchar(255) NOT NULL
);

--
-- Dumping data for table `entreprise`
--

INSERT INTO `entreprise` (`loc`, `matricule`, `raison`, `type`, `fax`, `numportable`, `numfix`, `email`, `siteweb`,
                          `etat`, `description`)
VALUES (1, '5/5/55', 'polyentreprise', 'Physique', '55555555', '55555555', '55555555', 'polyentreprise@poly.com', '', 0,
        'rrr');

-- --------------------------------------------------------

--
-- Table structure for table `facturebl_bon`
--

CREATE TABLE `facturebl_bon`
(
    `id`           int(11)      NOT NULL,
    `facture_code` varchar(255) NOT NULL,
    `bon_code`     varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `facturebl_bon`
--

INSERT INTO `facturebl_bon` (`id`, `facture_code`, `bon_code`)
VALUES (6, 'FactureBL39', 'Bon18'),
       (7, 'FactureBL39', 'Bon16'),
       (8, 'FactureBL39', 'test'),
       (9, 'FactureBL39', 'Bon24'),
       (10, 'FactureBL46', 'Bon31'),
       (11, 'FactureBL46', 'Bon40'),
       (12, 'FactureBL48', 'Bon16'),
       (13, 'FactureBL51', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `factureclientbl`
--

CREATE TABLE `factureclientbl`
(
    `id`          int(11)      NOT NULL,
    `code`        varchar(255) NOT NULL,
    `date`        date DEFAULT curdate(),
    `fournisseur` varchar(255) NOT NULL,
    `modepayment` varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `factureclientbl`
--

INSERT INTO `factureclientbl` (`id`, `code`, `date`, `fournisseur`, `modepayment`)
VALUES (3, 'FactureBL52', '2021-01-24', 'Client41', 'Espèce'),
       (4, 'FactureBL53', '2021-01-24', 'Partner14', 'Espèce');

-- --------------------------------------------------------

--
-- Table structure for table `factureclientbl_bon`
--

CREATE TABLE `factureclientbl_bon`
(
    `id`           int(11)      NOT NULL,
    `facture_code` varchar(255) NOT NULL,
    `bon_code`     varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `factureclientbl_bon`
--

INSERT INTO `factureclientbl_bon` (`id`, `facture_code`, `bon_code`)
VALUES (3, 'FactureBL52', 'testbonclient'),
       (4, 'FactureBL53', 'Bon43');

-- --------------------------------------------------------

--
-- Table structure for table `factureclientlibre`
--

CREATE TABLE `factureclientlibre`
(
    `id`              int(11)      NOT NULL,
    `code`            varchar(255) NOT NULL,
    `fournisseur`     varchar(255) NOT NULL,
    `datedebon`       date         NOT NULL DEFAULT curdate(),
    `datedereception` date         NOT NULL,
    `information`     varchar(255)          DEFAULT NULL,
    `modepayment`     varchar(255)          DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `factureclientlibre`
--

INSERT INTO `factureclientlibre` (`id`, `code`, `fournisseur`, `datedebon`, `datedereception`, `information`,
                                  `modepayment`)
VALUES (1, 'testfacturelibre', 'Client41', '2021-01-24', '2021-01-25', 'ffffffff', 'Cheque'),
       (2, 'Facture45', 'Client41', '2021-01-24', '2021-01-24', 'ggg', 'Virement');

-- --------------------------------------------------------

--
-- Table structure for table `factureclient_produit`
--

CREATE TABLE `factureclient_produit`
(
    `id`         int(11) NOT NULL,
    `product_id` int(11)      DEFAULT NULL,
    `bon_code`   varchar(255) DEFAULT NULL,
    `quantite`   int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `factureclient_produit`
--

INSERT INTO `factureclient_produit` (`id`, `product_id`, `bon_code`, `quantite`)
VALUES (1, 12, 'Facture45', 2),
       (2, 47, 'Facture45', 2);

-- --------------------------------------------------------

--
-- Table structure for table `facturefournisseurbl`
--

CREATE TABLE `facturefournisseurbl`
(
    `id`          int(11)      NOT NULL,
    `code`        varchar(255) NOT NULL,
    `date`        date DEFAULT curdate(),
    `fournisseur` varchar(255) NOT NULL,
    `modepayment` varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `facturefournisseurbl`
--

INSERT INTO `facturefournisseurbl` (`id`, `code`, `date`, `fournisseur`, `modepayment`)
VALUES (5, 'FactureBL39', '2021-01-20', 'codefour', 'Espèce'),
       (6, 'FactureBL46', '2021-01-24', 'codefour', 'Espèce'),
       (7, 'FactureBL48', '2021-01-24', 'codefour', 'EspÃ¨ce'),
       (8, 'FactureBL51', '2021-01-24', 'codefour', 'Espèce');

-- --------------------------------------------------------

--
-- Table structure for table `facturefournisseurlibre`
--

CREATE TABLE `facturefournisseurlibre`
(
    `id`              int(11)      NOT NULL,
    `code`            varchar(255) NOT NULL,
    `fournisseur`     varchar(255) NOT NULL,
    `datedebon`       date         NOT NULL DEFAULT curdate(),
    `datedereception` date         NOT NULL,
    `information`     varchar(255)          DEFAULT NULL,
    `modepayment`     varchar(255)          DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `facturefournisseurlibre`
--

INSERT INTO `facturefournisseurlibre` (`id`, `code`, `fournisseur`, `datedebon`, `datedereception`, `information`,
                                       `modepayment`)
VALUES (16, 'Facture36', 'Partner15', '2021-01-19', '2021-01-19', '', 'Espèce'),
       (17, 'Facture42', 'codefour', '2021-01-22', '2021-01-22', '', 'Espèce');

-- --------------------------------------------------------

--
-- Table structure for table `facturefournisseur_produit`
--

CREATE TABLE `facturefournisseur_produit`
(
    `id`         int(11) NOT NULL,
    `product_id` int(11)      DEFAULT NULL,
    `bon_code`   varchar(255) DEFAULT NULL,
    `quantite`   int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `facturefournisseur_produit`
--

INSERT INTO `facturefournisseur_produit` (`id`, `product_id`, `bon_code`, `quantite`)
VALUES (9, 47, 'Facture36', 3),
       (10, 24, 'Facture42', 20);

-- --------------------------------------------------------

--
-- Table structure for table `familleproduit`
--

CREATE TABLE `familleproduit`
(
    `code`        int(11) NOT NULL,
    `designation` varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `familleproduit`
--

INSERT INTO `familleproduit` (`code`, `designation`)
VALUES (3, 'Boisson'),
       (1, 'Eau'),
       (2, 'Food');

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur`
(
    `code`        varchar(255) NOT NULL,
    `matricule`   varchar(255) NOT NULL,
    `raison`      varchar(255) NOT NULL,
    `type`        varchar(255) NOT NULL,
    `fax`         varchar(20)  NOT NULL,
    `numportable` varchar(20)  NOT NULL,
    `numfix`      varchar(20)  NOT NULL,
    `email`       varchar(255) DEFAULT NULL,
    `siteweb`     varchar(255) DEFAULT NULL,
    `etat`        tinyint(1)   NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`code`, `matricule`, `raison`, `type`, `fax`, `numportable`, `numfix`, `email`, `siteweb`,
                           `etat`)
VALUES ('codefour', '25/25/25', 'Attia Raed', 'Morale', '51212188', '54654588', '65456885', 'attia@raed.com',
        'test.com', 1),
       ('Partner15', '44/55/858', 'Attia Flen', 'Morale', '55555554', '45465465', '45485484', 'fsdf@dfdf.ff', '', 0),
       ('test2', 'ttttttt', 'Flen Fouleni', 'Morale', '44444', '44444', '44444', 'flen@fouleni.com', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit`
(
    `id`             int(11)      NOT NULL,
    `reference`      varchar(255) NOT NULL,
    `designation`    varchar(255) DEFAULT NULL,
    `unite`          varchar(255) NOT NULL,
    `fournisseur`    varchar(255) NOT NULL,
    `familleproduit` int(11)      DEFAULT NULL,
    `stock`          int(11)      DEFAULT NULL,
    `stockminimal`   int(11)      DEFAULT NULL,
    `prixunitaire`   double       DEFAULT NULL,
    `tva`            double       DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `reference`, `designation`, `unite`, `fournisseur`, `familleproduit`, `stock`,
                       `stockminimal`, `prixunitaire`, `tva`)
VALUES (12, '57857', 'eau', 'kg', 'codefour', 3, 10, 1, 11, 10),
       (24, 'aa', 'sdfsdf', 'sdfsd', 'codefour', 1, 15, 1, 1, 0),
       (37, 'aaaaaa', 'sdfsdfdd', 'sdfsdf', 'test2', 2, 5, 1, 16, 0),
       (41, 'bbbbbb', 'dfgdfg', 'kg', 'test2', 2, 70, 3, 24, 15),
       (42, 'aaa', 'qsdqsd', 'qsdsqd', 'codefour', 3, 6, 1, 1, 0),
       (44, 'aaaa', 'sdfs', 'qsf', 'test2', 1, 8, 4, 1, 0),
       (45, 'a', 'ddd', 'dddd', 'test2', 3, 0, 1, 1, 0),
       (46, 'fffff', 'ffffdsf', 'litre', 'Partner15', 1, 0, 1, 12, 10),
       (47, 'sdqds', 'qsdsqd', 'v', 'Partner15', 3, 39, 1, 5, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addresses_client`
--
ALTER TABLE `addresses_client`
    ADD PRIMARY KEY (`code`);

--
-- Indexes for table `addresses_entreprise`
--
ALTER TABLE `addresses_entreprise`
    ADD PRIMARY KEY (`loc`);

--
-- Indexes for table `addresses_fournisseur`
--
ALTER TABLE `addresses_fournisseur`
    ADD PRIMARY KEY (`code`);

--
-- Indexes for table `bankaccounts_client`
--
ALTER TABLE `bankaccounts_client`
    ADD PRIMARY KEY (`RIB`),
    ADD KEY `BankAccounts_client_code_fk` (`code`);

--
-- Indexes for table `bankaccounts_entreprise`
--
ALTER TABLE `bankaccounts_entreprise`
    ADD PRIMARY KEY (`RIB`);

--
-- Indexes for table `bankaccounts_fournisseur`
--
ALTER TABLE `bankaccounts_fournisseur`
    ADD PRIMARY KEY (`RIB`),
    ADD KEY `bankaccounts_fournisseur_fournisseur_code_fk` (`code`);

--
-- Indexes for table `bonclient`
--
ALTER TABLE `bonclient`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `bonfornisseur_code_uindex` (`code`);

--
-- Indexes for table `bonclient_produit`
--
ALTER TABLE `bonclient_produit`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bonfournisseur`
--
ALTER TABLE `bonfournisseur`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `bonfornisseur_code_uindex` (`code`);

--
-- Indexes for table `bonfournisseur_produit`
--
ALTER TABLE `bonfournisseur_produit`
    ADD PRIMARY KEY (`id`),
    ADD KEY `bonfournisseur_produit_produit_id_fk` (`product_id`),
    ADD KEY `bonfournisseur_produit_bonfornisseur_code_fk` (`bon_code`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
    ADD PRIMARY KEY (`code`);

--
-- Indexes for table `codevalue`
--
ALTER TABLE `codevalue`
    ADD PRIMARY KEY (`code`),
    ADD UNIQUE KEY `codevalue_code_uindex` (`code`);

--
-- Indexes for table `entreprise`
--
ALTER TABLE `entreprise`
    ADD PRIMARY KEY (`loc`);

--
-- Indexes for table `facturebl_bon`
--
ALTER TABLE `facturebl_bon`
    ADD PRIMARY KEY (`id`),
    ADD KEY `facturebl_bon_bonfournisseur_code_fk` (`bon_code`),
    ADD KEY `facturebl_bon_facturefournisseurbl_code_fk` (`facture_code`);

--
-- Indexes for table `factureclientbl`
--
ALTER TABLE `factureclientbl`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `facturefournisseurbl_code_uindex` (`code`);

--
-- Indexes for table `factureclientbl_bon`
--
ALTER TABLE `factureclientbl_bon`
    ADD PRIMARY KEY (`id`),
    ADD KEY `factureclientbl_bon_factureclientbl_code_fk` (`facture_code`),
    ADD KEY `factureclientbl_bon_bonclient_code_fk` (`bon_code`);

--
-- Indexes for table `factureclientlibre`
--
ALTER TABLE `factureclientlibre`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `bonfornisseur_code_uindex` (`code`);

--
-- Indexes for table `factureclient_produit`
--
ALTER TABLE `factureclient_produit`
    ADD PRIMARY KEY (`id`),
    ADD KEY `factureclient_produit_produit_id_fk` (`product_id`),
    ADD KEY `factureclient_produit_factureclientlibre_code_fk` (`bon_code`);

--
-- Indexes for table `facturefournisseurbl`
--
ALTER TABLE `facturefournisseurbl`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `facturefournisseurbl_code_uindex` (`code`);

--
-- Indexes for table `facturefournisseurlibre`
--
ALTER TABLE `facturefournisseurlibre`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `bonfornisseur_code_uindex` (`code`);

--
-- Indexes for table `facturefournisseur_produit`
--
ALTER TABLE `facturefournisseur_produit`
    ADD PRIMARY KEY (`id`),
    ADD KEY `facturefournisseur_produit_facturefournisseurlibre_code_fk` (`bon_code`),
    ADD KEY `facturefournisseur_produit_produit_id_fk` (`product_id`);

--
-- Indexes for table `familleproduit`
--
ALTER TABLE `familleproduit`
    ADD PRIMARY KEY (`code`),
    ADD UNIQUE KEY `familleproduit_designation_uindex` (`designation`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
    ADD PRIMARY KEY (`code`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `produit_reference_uindex` (`reference`),
    ADD KEY `produit_fournisseur_code_fk` (`fournisseur`),
    ADD KEY `produit_produitfamille_code_fk` (`familleproduit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bonclient`
--
ALTER TABLE `bonclient`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 5;

--
-- AUTO_INCREMENT for table `bonclient_produit`
--
ALTER TABLE `bonclient_produit`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 7;

--
-- AUTO_INCREMENT for table `bonfournisseur`
--
ALTER TABLE `bonfournisseur`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 19;

--
-- AUTO_INCREMENT for table `bonfournisseur_produit`
--
ALTER TABLE `bonfournisseur_produit`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 22;

--
-- AUTO_INCREMENT for table `facturebl_bon`
--
ALTER TABLE `facturebl_bon`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 14;

--
-- AUTO_INCREMENT for table `factureclientbl`
--
ALTER TABLE `factureclientbl`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 5;

--
-- AUTO_INCREMENT for table `factureclientbl_bon`
--
ALTER TABLE `factureclientbl_bon`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 5;

--
-- AUTO_INCREMENT for table `factureclientlibre`
--
ALTER TABLE `factureclientlibre`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 3;

--
-- AUTO_INCREMENT for table `factureclient_produit`
--
ALTER TABLE `factureclient_produit`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 3;

--
-- AUTO_INCREMENT for table `facturefournisseurbl`
--
ALTER TABLE `facturefournisseurbl`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 9;

--
-- AUTO_INCREMENT for table `facturefournisseurlibre`
--
ALTER TABLE `facturefournisseurlibre`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 18;

--
-- AUTO_INCREMENT for table `facturefournisseur_produit`
--
ALTER TABLE `facturefournisseur_produit`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 11;

--
-- AUTO_INCREMENT for table `familleproduit`
--
ALTER TABLE `familleproduit`
    MODIFY `code` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 101;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 48;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addresses_client`
--
ALTER TABLE `addresses_client`
    ADD CONSTRAINT `Address_client_code_fk` FOREIGN KEY (`code`) REFERENCES `client` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `addresses_entreprise`
--
ALTER TABLE `addresses_entreprise`
    ADD CONSTRAINT `address_entreprise_entreprise_loc_fk` FOREIGN KEY (`loc`) REFERENCES `entreprise` (`loc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `addresses_fournisseur`
--
ALTER TABLE `addresses_fournisseur`
    ADD CONSTRAINT `addresses_fournisseur_fournisseur_code_fk` FOREIGN KEY (`code`) REFERENCES `fournisseur` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bankaccounts_client`
--
ALTER TABLE `bankaccounts_client`
    ADD CONSTRAINT `BankAccounts_client_code_fk` FOREIGN KEY (`code`) REFERENCES `client` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bankaccounts_fournisseur`
--
ALTER TABLE `bankaccounts_fournisseur`
    ADD CONSTRAINT `bankaccounts_fournisseur_fournisseur_code_fk` FOREIGN KEY (`code`) REFERENCES `fournisseur` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bonfournisseur_produit`
--
ALTER TABLE `bonfournisseur_produit`
    ADD CONSTRAINT `bonfournisseur_produit_bonfornisseur_code_fk` FOREIGN KEY (`bon_code`) REFERENCES `bonfournisseur` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `bonfournisseur_produit_produit_id_fk` FOREIGN KEY (`product_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `facturebl_bon`
--
ALTER TABLE `facturebl_bon`
    ADD CONSTRAINT `facturebl_bon_bonfournisseur_code_fk` FOREIGN KEY (`bon_code`) REFERENCES `bonfournisseur` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `facturebl_bon_facturefournisseurbl_code_fk` FOREIGN KEY (`facture_code`) REFERENCES `facturefournisseurbl` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

--
-- Constraints for table `factureclientbl_bon`
--
ALTER TABLE `factureclientbl_bon`
    ADD CONSTRAINT `factureclientbl_bon_bonclient_code_fk` FOREIGN KEY (`bon_code`) REFERENCES `bonclient` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `factureclientbl_bon_factureclientbl_code_fk` FOREIGN KEY (`facture_code`) REFERENCES `factureclientbl` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `factureclient_produit`
--
ALTER TABLE `factureclient_produit`
    ADD CONSTRAINT `factureclient_produit_factureclientlibre_code_fk` FOREIGN KEY (`bon_code`) REFERENCES `factureclientlibre` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `factureclient_produit_produit_id_fk` FOREIGN KEY (`product_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `facturefournisseur_produit`
--
ALTER TABLE `facturefournisseur_produit`
    ADD CONSTRAINT `facturefournisseur_produit_facturefournisseurlibre_code_fk` FOREIGN KEY (`bon_code`) REFERENCES `facturefournisseurlibre` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `facturefournisseur_produit_produit_id_fk` FOREIGN KEY (`product_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
    ADD CONSTRAINT `produit_fournisseur_code_fk` FOREIGN KEY (`fournisseur`) REFERENCES `fournisseur` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `produit_produitfamille_code_fk` FOREIGN KEY (`familleproduit`) REFERENCES `familleproduit` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
