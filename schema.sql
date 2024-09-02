CREATE TABLE IF NOT EXISTS cliente (
  codCliente SERIAL PRIMARY KEY,
  nomeCliente VARCHAR(20) NOT NULL,
  rgCliente VARCHAR(9) UNIQUE NOT NULL,
  enderecoCliente VARCHAR(255) NOT NULL,
  bairroCliente VARCHAR(100) NOT NULL,
  cidadeCliente VARCHAR(100) NOT NULL,
  estadoCliente VARCHAR(2) NOT NULL,
  cepCliente VARCHAR(9) NOT NULL,
  nascimentoCliente DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS chale (
  codChale SERIAL PRIMARY KEY,
  localizacao VARCHAR(255) NOT NULL,
  capacidade INTEGER NOT NULL,
  valorAltaEstacao DECIMAL(10, 2) NOT NULL,
  valorBaixaEstacao DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS hospedagem (
  codHospedagem SERIAL PRIMARY KEY,
  codChale INTEGER NOT NULL,
  codCliente INTEGER NOT NULL,
  estado VARCHAR(255) NOT NULL,
  dataInicio DATE NOT NULL,
  dataFim DATE,
  qtdPessoas INTEGER NOT NULL,
  desconto  DECIMAL(10, 2),
  valorFinal  DECIMAL(10, 2) ,
  CONSTRAINT fk_chale 
    FOREIGN KEY (codChale)
    REFERENCES public.chale (codChale),
  CONSTRAINT fk_cliente 
    FOREIGN KEY (codCliente)
    REFERENCES public.cliente (codCliente)
);
