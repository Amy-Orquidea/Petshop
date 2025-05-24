-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24/05/2025 às 19:20
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `petshopdb24052025`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `animais`
--

CREATE TABLE `animais` (
  `id` int(11) NOT NULL,
  `data_de_nascimento` datetime(6) DEFAULT NULL,
  `foto_path` varchar(255) DEFAULT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `fk_clientes_id` int(11) DEFAULT NULL,
  `fk_racas_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `animais`
--

INSERT INTO `animais` (`id`, `data_de_nascimento`, `foto_path`, `nome`, `fk_clientes_id`, `fk_racas_id`) VALUES
(1, '2020-03-15 00:00:00.000000', NULL, 'Rex', 1, 1),
(2, '2019-07-22 00:00:00.000000', NULL, 'Bella', 2, 2),
(3, '2021-01-10 00:00:00.000000', NULL, 'Max', 3, 3),
(4, '2020-11-05 00:00:00.000000', NULL, 'Luna', 4, 4),
(5, '2018-09-30 00:00:00.000000', NULL, 'Charlie', 5, 5),
(6, '2021-05-18 00:00:00.000000', NULL, 'Mimi', 6, 6),
(7, '2020-02-14 00:00:00.000000', NULL, 'Snowball', 7, 7),
(8, '2019-12-03 00:00:00.000000', NULL, 'Simba', 8, 8),
(9, '2021-08-27 00:00:00.000000', NULL, 'Princess', 9, 9),
(10, '2020-06-12 00:00:00.000000', NULL, 'Shadow', 10, 10),
(11, '2021-04-20 00:00:00.000000', NULL, 'Tweety', 11, 11),
(12, '2020-10-08 00:00:00.000000', NULL, 'Rio', 12, 12),
(13, '2019-03-25 00:00:00.000000', NULL, 'Melody', 13, 13),
(14, '2021-07-14 00:00:00.000000', NULL, 'Sunny', 14, 14),
(15, '2020-09-01 00:00:00.000000', NULL, 'Sky', 15, 15),
(16, '2021-02-28 00:00:00.000000', NULL, 'Neptune', 16, 16),
(17, '2020-12-17 00:00:00.000000', NULL, 'Goldie', 17, 17),
(18, '2021-06-23 00:00:00.000000', NULL, 'Rainbow', 18, 18),
(19, '2020-04-11 00:00:00.000000', NULL, 'Flash', 19, 19),
(20, '2019-08-19 00:00:00.000000', NULL, 'Rocky', 20, 20),
(21, '2021-03-07 00:00:00.000000', NULL, 'Peanut', 21, 21),
(22, '2020-11-24 00:00:00.000000', NULL, 'Nibbles', 22, 22),
(23, '2021-01-16 00:00:00.000000', NULL, 'Fluffy', 23, 23),
(24, '2020-05-29 00:00:00.000000', NULL, 'Hoppy', 24, 24),
(25, '2019-10-06 00:00:00.000000', NULL, 'Shelly', 25, 25),
(26, '2021-09-13 00:00:00.000000', NULL, 'Spike', 26, 26),
(27, '2020-07-31 00:00:00.000000', NULL, 'Bandit', 27, 27),
(28, '2021-12-04 00:00:00.000000', NULL, 'Dusty', 28, 28),
(29, '2020-08-21 00:00:00.000000', NULL, 'Ginger', 29, 29),
(30, '2021-04-09 00:00:00.000000', NULL, 'Whiskers', 30, 30),
(31, '2020-08-23 00:00:00.000000', NULL, 'Silvia', 2, 2),
(32, '2021-12-06 00:00:00.000000', NULL, 'Coragem', 4, 4),
(33, '2022-06-19 00:00:00.000000', NULL, 'Viagem', 6, 6),
(34, '2020-01-04 00:00:00.000000', NULL, 'Meia Tosa', 8, 8),
(35, '2021-07-01 00:00:00.000000', NULL, 'Susto', 10, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categorias`
--

INSERT INTO `categorias` (`id`, `nome`) VALUES
(1, 'Ração para Cães'),
(2, 'Ração para Gatos'),
(3, 'Ração para Pássaros'),
(4, 'Ração para Peixes'),
(5, 'Brinquedos para Cães'),
(6, 'Brinquedos para Gatos'),
(7, 'Acessórios para Cães'),
(8, 'Acessórios para Gatos'),
(9, 'Medicamentos'),
(10, 'Higiene e Limpeza'),
(11, 'Camas e Almofadas'),
(12, 'Coleiras e Guias'),
(13, 'Comedouros e Bebedouros'),
(14, 'Transporte'),
(15, 'Aquarismo'),
(16, 'Gaiolas e Viveiros'),
(17, 'Arranhadores'),
(18, 'Petiscos para Cães'),
(19, 'Petiscos para Gatos'),
(20, 'Shampoos e Condicionadores'),
(21, 'Roupas para Pets'),
(22, 'Suplementos'),
(23, 'Antipulgas e Carrapatos'),
(24, 'Vermífugos'),
(25, 'Produtos para Roedores'),
(26, 'Produtos para Répteis'),
(27, 'Iluminação para Aquários'),
(28, 'Filtros e Bombas'),
(29, 'Decoração para Aquários'),
(30, 'Produtos de Limpeza');

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `foto_path` varchar(255) DEFAULT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id`, `email`, `endereco`, `foto_path`, `nome`, `telefone`) VALUES
(1, 'maria.silva@email.com', 'Rua das Flores, 123 - São Paulo/SP', NULL, 'Maria Silva Santos', '(11) 99999-1001'),
(2, 'joao.pedro@email.com', 'Av. Paulista, 456 - São Paulo/SP', NULL, 'João Pedro Oliveira', '(11) 99999-1002'),
(3, 'ana.carolina@email.com', 'Rua Augusta, 789 - São Paulo/SP', NULL, 'Ana Carolina Lima', '(11) 99999-1003'),
(4, 'carlos.eduardo@email.com', 'Rua Oscar Freire, 321 - São Paulo/SP', NULL, 'Carlos Eduardo Costa', '(11) 99999-1004'),
(5, 'fernanda.almeida@email.com', 'Av. Faria Lima, 654 - São Paulo/SP', NULL, 'Fernanda Almeida', '(11) 99999-1005'),
(6, 'ricardo.mendes@email.com', 'Rua Consolação, 987 - São Paulo/SP', NULL, 'Ricardo Mendes', '(11) 99999-1006'),
(7, 'juliana.ferreira@email.com', 'Av. Ibirapuera, 147 - São Paulo/SP', NULL, 'Juliana Ferreira', '(11) 99999-1007'),
(8, 'paulo.roberto@email.com', 'Rua Pamplona, 258 - São Paulo/SP', NULL, 'Paulo Roberto Silva', '(11) 99999-1008'),
(9, 'camila.rodrigues@email.com', 'Av. Europa, 369 - São Paulo/SP', NULL, 'Camila Rodrigues', '(11) 99999-1009'),
(10, 'diego.santos@email.com', 'Rua Bela Vista, 741 - São Paulo/SP', NULL, 'Diego Santos', '(11) 99999-1010'),
(11, 'leticia.barbosa@email.com', 'Av. Rebouças, 852 - São Paulo/SP', NULL, 'Letícia Barbosa', '(11) 99999-1011'),
(12, 'marcos.antonio@email.com', 'Rua Estados Unidos, 963 - São Paulo/SP', NULL, 'Marcos Antônio Lima', '(11) 99999-1012'),
(13, 'patricia.gomes@email.com', 'Av. Angélica, 159 - São Paulo/SP', NULL, 'Patrícia Gomes', '(11) 99999-1013'),
(14, 'rafael.costa@email.com', 'Rua Haddock Lobo, 753 - São Paulo/SP', NULL, 'Rafael Costa', '(11) 99999-1014'),
(15, 'sabrina.oliveira@email.com', 'Av. Brigadeiro Luís Antônio, 486 - São Paulo/SP', NULL, 'Sabrina Oliveira', '(11) 99999-1015'),
(16, 'thiago.pereira@email.com', 'Rua Augusta, 1234 - São Paulo/SP', NULL, 'Thiago Pereira', '(11) 99999-1016'),
(17, 'vanessa.martins@email.com', 'Av. Paulista, 2468 - São Paulo/SP', NULL, 'Vanessa Martins', '(11) 99999-1017'),
(18, 'wagner.souza@email.com', 'Rua Oscar Freire, 1357 - São Paulo/SP', NULL, 'Wagner Souza', '(11) 99999-1018'),
(19, 'yasmin.alves@email.com', 'Av. Faria Lima, 2468 - São Paulo/SP', NULL, 'Yasmin Alves', '(11) 99999-1019'),
(20, 'zeca.ribeiro@email.com', 'Rua Consolação, 3691 - São Paulo/SP', NULL, 'Zeca Ribeiro', '(11) 99999-1020'),
(21, 'amanda.torres@email.com', 'Av. Ibirapuera, 2582 - São Paulo/SP', NULL, 'Amanda Torres', '(11) 99999-1021'),
(22, 'bruno.cardoso@email.com', 'Rua Pamplona, 1470 - São Paulo/SP', NULL, 'Bruno Cardoso', '(11) 99999-1022'),
(23, 'cristina.dias@email.com', 'Av. Europa, 3692 - São Paulo/SP', NULL, 'Cristina Dias', '(11) 99999-1023'),
(24, 'eduardo.machado@email.com', 'Rua Bela Vista, 1583 - São Paulo/SP', NULL, 'Eduardo Machado', '(11) 99999-1024'),
(25, 'fabiana.castro@email.com', 'Av. Rebouças, 2694 - São Paulo/SP', NULL, 'Fabiana Castro', '(11) 99999-1025'),
(26, 'gustavo.rocha@email.com', 'Rua Estados Unidos, 1705 - São Paulo/SP', NULL, 'Gustavo Rocha', '(11) 99999-1026'),
(27, 'helena.nascimento@email.com', 'Av. Angélica, 2816 - São Paulo/SP', NULL, 'Helena Nascimento', '(11) 99999-1027'),
(28, 'igor.campos@email.com', 'Rua Haddock Lobo, 1927 - São Paulo/SP', NULL, 'Igor Campos', '(11) 99999-1028'),
(29, 'julia.freitas@email.com', 'Av. Brigadeiro Luís Antônio, 3048 - São Paulo/SP', NULL, 'Júlia Freitas', '(11) 99999-1029'),
(30, 'kevin.morais@email.com', 'Rua da Consolação, 4159 - São Paulo/SP', NULL, 'Kevin Morais', '(11) 99999-1030');

-- --------------------------------------------------------

--
-- Estrutura para tabela `especies`
--

CREATE TABLE `especies` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `especies`
--

INSERT INTO `especies` (`id`, `nome`) VALUES
(1, 'Cão'),
(2, 'Gato'),
(3, 'Pássaro'),
(4, 'Peixe'),
(5, 'Hamster'),
(6, 'Coelho'),
(7, 'Tartaruga'),
(8, 'Iguana'),
(9, 'Ferret'),
(10, 'Chinchila'),
(11, 'Porquinho-da-índia'),
(12, 'Rato'),
(13, 'Papagaio'),
(14, 'Canário'),
(15, 'Periquito'),
(16, 'Calopsita'),
(17, 'Betta'),
(18, 'Goldfish'),
(19, 'Guppy'),
(20, 'Tetra'),
(21, 'Jabuti'),
(22, 'Cágado'),
(23, 'Gecko'),
(24, 'Camaleão'),
(25, 'Sagui'),
(26, 'Ouriço'),
(27, 'Sugar Glider'),
(28, 'Esquilo'),
(29, 'Furão'),
(30, 'Serpente');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL,
  `data_entrada` datetime(6) DEFAULT NULL,
  `nota_de_entrada` varchar(30) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor_de_entrada` double DEFAULT NULL,
  `fk_produtos_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `estoque`
--

INSERT INTO `estoque` (`id`, `data_entrada`, `nota_de_entrada`, `quantidade`, `valor_de_entrada`, `fk_produtos_id`) VALUES
(1, '2024-01-01 08:00:00.000000', 'NF001234', 50, 75, 1),
(2, '2024-01-01 08:30:00.000000', 'NF001235', 30, 120, 2),
(3, '2024-01-01 09:00:00.000000', 'NF001236', 100, 10, 3),
(4, '2024-01-01 09:30:00.000000', 'NF001237', 80, 15, 4),
(5, '2024-01-01 10:00:00.000000', 'NF001238', 60, 12, 5),
(6, '2024-01-01 10:30:00.000000', 'NF001239', 90, 6.5, 6),
(7, '2024-01-01 11:00:00.000000', 'NF001240', 40, 20, 7),
(8, '2024-01-01 11:30:00.000000', 'NF001241', 15, 130, 8),
(9, '2024-01-01 12:00:00.000000', 'NF001242', 25, 160, 9),
(10, '2024-01-01 12:30:00.000000', 'NF001243', 70, 16, 10),
(11, '2024-01-02 08:00:00.000000', 'NF001244', 20, 170, 11),
(12, '2024-01-02 08:30:00.000000', 'NF001245', 35, 38, 12),
(13, '2024-01-02 09:00:00.000000', 'NF001246', 55, 18, 13),
(14, '2024-01-02 09:30:00.000000', 'NF001247', 25, 75, 14),
(15, '2024-01-02 10:00:00.000000', 'NF001248', 10, 250, 15),
(16, '2024-01-02 10:30:00.000000', 'NF001249', 15, 160, 16),
(17, '2024-01-02 11:00:00.000000', 'NF001250', 45, 28, 17),
(18, '2024-01-02 11:30:00.000000', 'NF001251', 80, 9.5, 18),
(19, '2024-01-02 12:00:00.000000', 'NF001252', 200, 1.8, 19),
(20, '2024-01-02 12:30:00.000000', 'NF001253', 60, 20, 20),
(21, '2024-01-03 08:00:00.000000', 'NF001254', 40, 24, 21),
(22, '2024-01-03 08:30:00.000000', 'NF001255', 30, 28, 22),
(23, '2024-01-03 09:00:00.000000', 'NF001256', 20, 75, 23),
(24, '2024-01-03 09:30:00.000000', 'NF001257', 35, 38, 24),
(25, '2024-01-03 10:00:00.000000', 'NF001258', 100, 7.5, 25),
(26, '2024-01-03 10:30:00.000000', 'NF001259', 50, 32, 26),
(27, '2024-01-03 11:00:00.000000', 'NF001260', 25, 65, 27),
(28, '2024-01-03 11:30:00.000000', 'NF001261', 30, 55, 28),
(29, '2024-01-03 12:00:00.000000', 'NF001262', 40, 20, 29),
(30, '2024-01-03 12:30:00.000000', 'NF001263', 80, 12, 30);

-- --------------------------------------------------------

--
-- Estrutura para tabela `formas_de_pagamento`
--

CREATE TABLE `formas_de_pagamento` (
  `id` int(11) NOT NULL,
  `descricao` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `formas_de_pagamento`
--

INSERT INTO `formas_de_pagamento` (`id`, `descricao`) VALUES
(1, 'Dinheiro'),
(2, 'Cartão de Débito'),
(3, 'Cartão de Crédito à Vista'),
(4, 'Cartão de Crédito 2x'),
(5, 'Cartão de Crédito 3x'),
(6, 'Cartão de Crédito 4x'),
(7, 'Cartão de Crédito 5x'),
(8, 'Cartão de Crédito 6x'),
(9, 'PIX'),
(10, 'Transferência Bancária'),
(11, 'Boleto Bancário'),
(12, 'Cheque à Vista'),
(13, 'Cheque Pré-datado 30 dias'),
(14, 'Cartão Meal/Alelo'),
(15, 'Vale Alimentação'),
(16, 'Cartão Sodexo'),
(17, 'PayPal'),
(18, 'PagSeguro'),
(19, 'Mercado Pago'),
(20, 'PicPay'),
(21, 'Cartão de Crédito 7x'),
(22, 'Cartão de Crédito 8x'),
(23, 'Cartão de Crédito 9x'),
(24, 'Cartão de Crédito 10x'),
(25, 'Cartão de Crédito 12x'),
(26, 'Financiamento Próprio'),
(27, 'Crédito em Conta'),
(28, 'Desconto em Folha'),
(29, 'Cartão Presente'),
(30, 'Troca de Produtos');

-- --------------------------------------------------------

--
-- Estrutura para tabela `itens_de_pedidos`
--

CREATE TABLE `itens_de_pedidos` (
  `id` int(11) NOT NULL,
  `desconto` double DEFAULT NULL,
  `preco_unitario` double DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `fk_animais_id` int(11) DEFAULT NULL,
  `fk_clientes_id` int(11) DEFAULT NULL,
  `fk_pedidos_numero_pedido` int(11) NOT NULL,
  `fk_produtos_id` int(11) NOT NULL,
  `fk_vendedores_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `itens_de_pedidos`
--

INSERT INTO `itens_de_pedidos` (`id`, `desconto`, `preco_unitario`, `quantidade`, `fk_animais_id`, `fk_clientes_id`, `fk_pedidos_numero_pedido`, `fk_produtos_id`, `fk_vendedores_id`) VALUES
(1, NULL, NULL, NULL, 1, 1, 1001, 1, 1),
(2, NULL, NULL, NULL, 6, 2, 1002, 2, 2),
(3, NULL, NULL, NULL, 11, 11, 1003, 3, 3),
(4, NULL, NULL, NULL, 16, 16, 1004, 4, 4),
(5, NULL, NULL, NULL, 1, 1, 1005, 5, 5),
(6, NULL, NULL, NULL, 6, 6, 1006, 6, 6),
(7, NULL, NULL, NULL, 1, 1, 1007, 7, 7),
(8, NULL, NULL, NULL, 6, 6, 1008, 8, 8),
(9, NULL, NULL, NULL, 1, 1, 1009, 9, 9),
(10, NULL, NULL, NULL, 1, 1, 1010, 10, 10),
(11, NULL, NULL, NULL, 10, 10, 1011, 11, 11),
(12, NULL, NULL, NULL, 1, 1, 1012, 12, 12),
(13, NULL, NULL, NULL, 1, 1, 1013, 13, 13),
(14, NULL, NULL, NULL, 1, 1, 1014, 14, 14),
(15, NULL, NULL, NULL, 16, 16, 1015, 15, 15),
(16, NULL, NULL, NULL, 11, 11, 1016, 16, 16),
(17, NULL, NULL, NULL, 6, 6, 1017, 17, 17),
(18, NULL, NULL, NULL, 1, 1, 1018, 18, 18),
(19, NULL, NULL, NULL, 6, 6, 1019, 19, 19),
(20, NULL, NULL, NULL, 6, 6, 1020, 20, 20),
(21, NULL, NULL, NULL, 1, 1, 1021, 21, 21),
(22, NULL, NULL, NULL, 21, 21, 1022, 22, 22),
(23, NULL, NULL, NULL, 1, 1, 1023, 23, 23),
(24, NULL, NULL, NULL, 1, 1, 1024, 24, 24),
(25, NULL, NULL, NULL, 21, 21, 1025, 25, 25),
(26, NULL, NULL, NULL, 26, 26, 1026, 26, 26),
(27, NULL, NULL, NULL, 16, 16, 1027, 27, 27),
(28, NULL, NULL, NULL, 16, 16, 1028, 28, 28),
(29, NULL, NULL, NULL, 16, 16, 1029, 29, 29),
(30, NULL, NULL, NULL, 30, 30, 1030, 30, 30);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `id` int(11) NOT NULL,
  `data_e_hora` datetime(6) DEFAULT NULL,
  `valor_pago` double DEFAULT NULL,
  `fk_formas_de_pagamento` int(11) DEFAULT NULL,
  `fk_pedidos_numero_pedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pagamentos`
--

INSERT INTO `pagamentos` (`id`, `data_e_hora`, `valor_pago`, `fk_formas_de_pagamento`, `fk_pedidos_numero_pedido`) VALUES
(1, '2024-01-15 10:35:00.000000', 89.9, 9, 1001),
(2, '2024-01-15 11:50:00.000000', 145.5, 3, 1002),
(3, '2024-01-16 09:20:00.000000', 12.9, 1, 1003),
(4, '2024-01-16 14:25:00.000000', 18.9, 2, 1004),
(5, '2024-01-17 16:35:00.000000', 15.9, 9, 1005),
(6, '2024-01-18 08:50:00.000000', 8.9, 1, 1006),
(7, '2024-01-18 13:15:00.000000', 25.9, 2, 1007),
(8, '2024-01-19 15:30:00.000000', 159.9, 4, 1008),
(9, '2024-01-20 11:45:00.000000', 189.9, 3, 1009),
(10, '2024-01-20 18:00:00.000000', 19.9, 9, 1010),
(11, '2024-01-21 09:35:00.000000', 199.9, 5, 1011),
(12, '2024-01-21 12:20:00.000000', 45.9, 2, 1012),
(13, '2024-01-22 14:50:00.000000', 22.9, 1, 1013),
(14, '2024-01-22 16:25:00.000000', 89.9, 3, 1014),
(15, '2024-01-23 10:15:00.000000', 299.9, 6, 1015),
(16, '2024-01-23 13:40:00.000000', 189.9, 4, 1016),
(17, '2024-01-24 11:55:00.000000', 35.9, 9, 1017),
(18, '2024-01-24 15:45:00.000000', 12.9, 1, 1018),
(19, '2024-01-25 09:30:00.000000', 2.5, 1, 1019),
(20, '2024-01-25 14:20:00.000000', 24.9, 2, 1020),
(21, '2024-01-26 16:50:00.000000', 29.9, 9, 1021),
(22, '2024-01-27 10:25:00.000000', 35.9, 3, 1022),
(23, '2024-01-27 13:00:00.000000', 89.9, 2, 1023),
(24, '2024-01-28 14:35:00.000000', 45.9, 1, 1024),
(25, '2024-01-28 17:15:00.000000', 9.9, 1, 1025),
(26, '2024-01-29 09:45:00.000000', 39.9, 2, 1026),
(27, '2024-01-29 13:25:00.000000', 79.9, 3, 1027),
(28, '2024-01-30 11:20:00.000000', 69.9, 9, 1028),
(29, '2024-01-30 15:40:00.000000', 25.9, 1, 1029),
(30, '2024-01-31 16:55:00.000000', 15.9, 2, 1030);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedidos`
--

CREATE TABLE `pedidos` (
  `numero_pedido` int(11) NOT NULL,
  `data_e_hora` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pedidos`
--

INSERT INTO `pedidos` (`numero_pedido`, `data_e_hora`) VALUES
(1001, '2024-01-15 10:30:00.000000'),
(1002, '2024-01-15 11:45:00.000000'),
(1003, '2024-01-16 09:15:00.000000'),
(1004, '2024-01-16 14:20:00.000000'),
(1005, '2024-01-17 16:30:00.000000'),
(1006, '2024-01-18 08:45:00.000000'),
(1007, '2024-01-18 13:10:00.000000'),
(1008, '2024-01-19 15:25:00.000000'),
(1009, '2024-01-20 11:40:00.000000'),
(1010, '2024-01-20 17:55:00.000000'),
(1011, '2024-01-21 09:30:00.000000'),
(1012, '2024-01-21 12:15:00.000000'),
(1013, '2024-01-22 14:45:00.000000'),
(1014, '2024-01-22 16:20:00.000000'),
(1015, '2024-01-23 10:10:00.000000'),
(1016, '2024-01-23 13:35:00.000000'),
(1017, '2024-01-24 11:50:00.000000'),
(1018, '2024-01-24 15:40:00.000000'),
(1019, '2024-01-25 09:25:00.000000'),
(1020, '2024-01-25 14:15:00.000000'),
(1021, '2024-01-26 16:45:00.000000'),
(1022, '2024-01-27 10:20:00.000000'),
(1023, '2024-01-27 12:55:00.000000'),
(1024, '2024-01-28 14:30:00.000000'),
(1025, '2024-01-28 17:10:00.000000'),
(1026, '2024-01-29 09:40:00.000000'),
(1027, '2024-01-29 13:20:00.000000'),
(1028, '2024-01-30 11:15:00.000000'),
(1029, '2024-01-30 15:35:00.000000'),
(1030, '2024-01-31 16:50:00.000000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `foto_path` varchar(255) DEFAULT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `fk_categorias_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`id`, `foto_path`, `nome`, `preco`, `fk_categorias_id`) VALUES
(1, NULL, 'Ração Premier Golden Adulto 15kg', 89.9, 1),
(2, NULL, 'Ração Royal Canin Gato Adulto 7.5kg', 145.5, 2),
(3, NULL, 'Ração Alcon Club Pássaros 500g', 12.9, 3),
(4, NULL, 'Ração Tetra Min Peixes Tropicais 52g', 18.9, 4),
(5, NULL, 'Bola de Tênis para Cães Grande', 15.9, 5),
(6, NULL, 'Ratinho de Pelúcia para Gatos', 8.9, 6),
(7, NULL, 'Coleira de Couro Marrom G', 25.9, 7),
(8, NULL, 'Arranhador Torre 1,5m', 159.9, 8),
(9, NULL, 'Antipulgas Bravecto Cães 20-40kg', 189.9, 9),
(10, NULL, 'Shampoo Sanol Dog Neutro 500ml', 19.9, 10),
(11, NULL, 'Cama Ortopédica Memory Foam G', 199.9, 11),
(12, NULL, 'Guia Retrátil Flexi 5m', 45.9, 12),
(13, NULL, 'Comedouro Inox Antiderrapante M', 22.9, 13),
(14, NULL, 'Caixa de Transporte N3', 89.9, 14),
(15, NULL, 'Filtro Externo Canister 1200L/h', 299.9, 15),
(16, NULL, 'Gaiola Calopsita Luxo', 189.9, 16),
(17, NULL, 'Arranhador Horizontal Sisal', 35.9, 17),
(18, NULL, 'Petisco Pedigree Dentastix M', 12.9, 18),
(19, NULL, 'Sachê Whiskas Frango 85g', 2.5, 19),
(20, NULL, 'Condicionador Sanol Cat 500ml', 24.9, 20),
(21, NULL, 'Blusa de Frio para Cães P', 29.9, 21),
(22, NULL, 'Suplemento Vitamínico Pet 60 caps', 35.9, 22),
(23, NULL, 'Coleira Antipulgas Scalibor G', 89.9, 23),
(24, NULL, 'Vermífugo Drontal Plus 10kg', 45.9, 24),
(25, NULL, 'Ração Hamster Funny Bunny 500g', 9.9, 25),
(26, NULL, 'Lâmpada UV Répteis 25W', 39.9, 26),
(27, NULL, 'Timer Digital para Aquário', 79.9, 27),
(28, NULL, 'Bomba Submersa 800L/h', 69.9, 28),
(29, NULL, 'Tronco Decorativo Aquário', 25.9, 29),
(30, NULL, 'Desinfetante Pet Safe 1L', 15.9, 30);

-- --------------------------------------------------------

--
-- Estrutura para tabela `racas`
--

CREATE TABLE `racas` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `fk_especies_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `racas`
--

INSERT INTO `racas` (`id`, `nome`, `fk_especies_id`) VALUES
(1, 'Labrador', 1),
(2, 'Golden Retriever', 1),
(3, 'Bulldog', 1),
(4, 'Poodle', 1),
(5, 'Pastor Alemão', 1),
(6, 'Siamês', 2),
(7, 'Persa', 2),
(8, 'Maine Coon', 2),
(9, 'Ragdoll', 2),
(10, 'British Shorthair', 2),
(11, 'Bem-te-vi', 3),
(12, 'Sabiá', 3),
(13, 'Curió', 3),
(14, 'Canário Belga', 14),
(15, 'Periquito Australiano', 15),
(16, 'Betta Splendens', 17),
(17, 'Goldfish Comum', 18),
(18, 'Guppy Fancy', 19),
(19, 'Neon Tetra', 20),
(20, 'Jabuti Piranga', 21),
(21, 'Hamster Sírio', 5),
(22, 'Hamster Anão', 5),
(23, 'Coelho Angorá', 6),
(24, 'Coelho Mini Lop', 6),
(25, 'Tartaruga Tigre', 7),
(26, 'Iguana Verde', 8),
(27, 'Ferret Padrão', 9),
(28, 'Chinchila Padrão', 10),
(29, 'Porquinho Abissínio', 11),
(30, 'Rato Dumbo', 12);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendedores`
--

CREATE TABLE `vendedores` (
  `id` int(11) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vendedores`
--

INSERT INTO `vendedores` (`id`, `email`, `nome`, `telefone`) VALUES
(1, 'andre.silva@petshop.com', 'André Silva', '(11) 98765-0001'),
(2, 'beatriz.costa@petshop.com', 'Beatriz Costa', '(11) 98765-0002'),
(3, 'carlos.mendes@petshop.com', 'Carlos Mendes', '(11) 98765-0003'),
(4, 'daniela.santos@petshop.com', 'Daniela Santos', '(11) 98765-0004'),
(5, 'eduardo.lima@petshop.com', 'Eduardo Lima', '(11) 98765-0005'),
(6, 'fernanda.rocha@petshop.com', 'Fernanda Rocha', '(11) 98765-0006'),
(7, 'gabriel.alves@petshop.com', 'Gabriel Alves', '(11) 98765-0007'),
(8, 'helena.martins@petshop.com', 'Helena Martins', '(11) 98765-0008'),
(9, 'igor.ferreira@petshop.com', 'Igor Ferreira', '(11) 98765-0009'),
(10, 'juliana.oliveira@petshop.com', 'Juliana Oliveira', '(11) 98765-0010'),
(11, 'kevin.barbosa@petshop.com', 'Kevin Barbosa', '(11) 98765-0011'),
(12, 'larissa.gomes@petshop.com', 'Larissa Gomes', '(11) 98765-0012'),
(13, 'marcos.pereira@petshop.com', 'Marcos Pereira', '(11) 98765-0013'),
(14, 'natalia.souza@petshop.com', 'Natália Souza', '(11) 98765-0014'),
(15, 'otavio.dias@petshop.com', 'Otávio Dias', '(11) 98765-0015'),
(16, 'priscila.torres@petshop.com', 'Priscila Torres', '(11) 98765-0016'),
(17, 'rodrigo.castro@petshop.com', 'Rodrigo Castro', '(11) 98765-0017'),
(18, 'sabrina.machado@petshop.com', 'Sabrina Machado', '(11) 98765-0018'),
(19, 'thiago.cardoso@petshop.com', 'Thiago Cardoso', '(11) 98765-0019'),
(20, 'viviane.ribeiro@petshop.com', 'Viviane Ribeiro', '(11) 98765-0020'),
(21, 'wilson.campos@petshop.com', 'Wilson Campos', '(11) 98765-0021'),
(22, 'ximena.freitas@petshop.com', 'Ximena Freitas', '(11) 98765-0022'),
(23, 'yuri.morais@petshop.com', 'Yuri Morais', '(11) 98765-0023'),
(24, 'zilda.nascimento@petshop.com', 'Zilda Nascimento', '(11) 98765-0024'),
(25, 'alberto.correia@petshop.com', 'Alberto Correia', '(11) 98765-0025'),
(26, 'bruna.lopes@petshop.com', 'Bruna Lopes', '(11) 98765-0026'),
(27, 'claudio.ramos@petshop.com', 'Cláudio Ramos', '(11) 98765-0027'),
(28, 'debora.reis@petshop.com', 'Débora Reis', '(11) 98765-0028'),
(29, 'everton.teixeira@petshop.com', 'Everton Teixeira', '(11) 98765-0029'),
(30, 'flavia.araujo@petshop.com', 'Flávia Araújo', '(11) 98765-0030');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `animais`
--
ALTER TABLE `animais`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKni60qv15qdb13984goog19ibv` (`fk_clientes_id`),
  ADD KEY `FK9o3so3mx4m1nqwnwc6wrrnauf` (`fk_racas_id`);

--
-- Índices de tabela `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `especies`
--
ALTER TABLE `especies`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcp0pk0xc41asv4uij7qkeupyt` (`fk_produtos_id`);

--
-- Índices de tabela `formas_de_pagamento`
--
ALTER TABLE `formas_de_pagamento`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `itens_de_pedidos`
--
ALTER TABLE `itens_de_pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4oa9fdtjdp931q66yj41sf96e` (`fk_animais_id`),
  ADD KEY `FKeycofv2ijirtdjrxr14orgp0n` (`fk_clientes_id`),
  ADD KEY `FK2gftnurf3e9tesk2ejbhssemg` (`fk_pedidos_numero_pedido`),
  ADD KEY `FK2bt1qa47r1nhapalau85lk6e2` (`fk_produtos_id`),
  ADD KEY `FK3skg4o927rwrg616odmrnkch5` (`fk_vendedores_id`);

--
-- Índices de tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3d1qcxnri8l09a3a6bsrxek7h` (`fk_formas_de_pagamento`),
  ADD KEY `FK8rx4yq8x5wp37hj6q26b1dkj` (`fk_pedidos_numero_pedido`);

--
-- Índices de tabela `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`numero_pedido`);

--
-- Índices de tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7ne97lyun6ie54apied8qmhr5` (`fk_categorias_id`);

--
-- Índices de tabela `racas`
--
ALTER TABLE `racas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK87u6d71ntuwd5j2yf8lqqhyxb` (`fk_especies_id`);

--
-- Índices de tabela `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `animais`
--
ALTER TABLE `animais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de tabela `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `especies`
--
ALTER TABLE `especies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `formas_de_pagamento`
--
ALTER TABLE `formas_de_pagamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `itens_de_pedidos`
--
ALTER TABLE `itens_de_pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `numero_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1031;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `racas`
--
ALTER TABLE `racas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `animais`
--
ALTER TABLE `animais`
  ADD CONSTRAINT `FK9o3so3mx4m1nqwnwc6wrrnauf` FOREIGN KEY (`fk_racas_id`) REFERENCES `racas` (`id`),
  ADD CONSTRAINT `FKni60qv15qdb13984goog19ibv` FOREIGN KEY (`fk_clientes_id`) REFERENCES `clientes` (`id`);

--
-- Restrições para tabelas `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `FKcp0pk0xc41asv4uij7qkeupyt` FOREIGN KEY (`fk_produtos_id`) REFERENCES `produtos` (`id`);

--
-- Restrições para tabelas `itens_de_pedidos`
--
ALTER TABLE `itens_de_pedidos`
  ADD CONSTRAINT `FK2bt1qa47r1nhapalau85lk6e2` FOREIGN KEY (`fk_produtos_id`) REFERENCES `produtos` (`id`),
  ADD CONSTRAINT `FK2gftnurf3e9tesk2ejbhssemg` FOREIGN KEY (`fk_pedidos_numero_pedido`) REFERENCES `pedidos` (`numero_pedido`),
  ADD CONSTRAINT `FK3skg4o927rwrg616odmrnkch5` FOREIGN KEY (`fk_vendedores_id`) REFERENCES `vendedores` (`id`),
  ADD CONSTRAINT `FK4oa9fdtjdp931q66yj41sf96e` FOREIGN KEY (`fk_animais_id`) REFERENCES `animais` (`id`),
  ADD CONSTRAINT `FKeycofv2ijirtdjrxr14orgp0n` FOREIGN KEY (`fk_clientes_id`) REFERENCES `clientes` (`id`);

--
-- Restrições para tabelas `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD CONSTRAINT `FK3d1qcxnri8l09a3a6bsrxek7h` FOREIGN KEY (`fk_formas_de_pagamento`) REFERENCES `formas_de_pagamento` (`id`),
  ADD CONSTRAINT `FK8rx4yq8x5wp37hj6q26b1dkj` FOREIGN KEY (`fk_pedidos_numero_pedido`) REFERENCES `pedidos` (`numero_pedido`);

--
-- Restrições para tabelas `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `FK7ne97lyun6ie54apied8qmhr5` FOREIGN KEY (`fk_categorias_id`) REFERENCES `categorias` (`id`);

--
-- Restrições para tabelas `racas`
--
ALTER TABLE `racas`
  ADD CONSTRAINT `FK87u6d71ntuwd5j2yf8lqqhyxb` FOREIGN KEY (`fk_especies_id`) REFERENCES `especies` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
