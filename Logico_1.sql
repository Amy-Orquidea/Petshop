/* Lógico_1: */

CREATE TABLE clientes (
    cpf Varchar(11) PRIMARY KEY,
    nome Varchar(255),
    telefone Varchar(20),
    email Varchar(255),
    endereco Varchar(255)
);

CREATE TABLE animais (
    id Long PRIMARY KEY,
    nome Varchar(255),
    raca Varchar(90),
    idade int(3),
    fk_clientes_cpf Varchar(11)
);

CREATE TABLE vendedores (
    id Long PRIMARY KEY,
    nome Varchar(255),
    telefone Varchar(20),
    email Varchar(255)
);

CREATE TABLE pedidos (
    numero_pedido Long PRIMARY KEY,
    data_e_hora STOPWATCH
);

CREATE TABLE produtos (
    id Long PRIMARY KEY,
    nome Varchar(255),
    preco DOUBLE[3,2]
);

CREATE TABLE estoque (
    qtd_entrada int(5),
    data_de_entrada STOPWATCH,
    fk_produtos_id Long
);

CREATE TABLE Vendas (
    fk_produtos_id Long,
    fk_animais_id Long,
    fk_vendedores_id Long,
    fk_clientes_cpf Varchar(11),
    fk_pedidos_numero_pedido Long,
    qtd int(5)
);
 
ALTER TABLE animais ADD CONSTRAINT FK_animais_2
    FOREIGN KEY (fk_clientes_cpf)
    REFERENCES clientes (cpf)
    ON DELETE CASCADE;
 
ALTER TABLE estoque ADD CONSTRAINT FK_estoque_1
    FOREIGN KEY (fk_produtos_id)
    REFERENCES produtos (id)
    ON DELETE RESTRICT;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_1
    FOREIGN KEY (fk_produtos_id)
    REFERENCES produtos (id)
    ON DELETE NO ACTION;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_2
    FOREIGN KEY (fk_animais_id)
    REFERENCES animais (id)
    ON DELETE NO ACTION;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_3
    FOREIGN KEY (fk_vendedores_id)
    REFERENCES vendedores (id)
    ON DELETE NO ACTION;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_4
    FOREIGN KEY (fk_clientes_cpf)
    REFERENCES clientes (cpf)
    ON DELETE NO ACTION;
 
ALTER TABLE Vendas ADD CONSTRAINT FK_Vendas_5
    FOREIGN KEY (fk_pedidos_numero_pedido)
    REFERENCES pedidos (numero_pedido)
    ON DELETE NO ACTION;