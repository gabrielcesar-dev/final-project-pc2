CREATE TABLE IF NOT EXISTS "clientes" (
  "id" SERIAL PRIMARY KEY,
  "rg" VARCHAR(20) NOT NULL,
  "endereco" VARCHAR(255) NOT NULL,
  "bairro" VARCHAR(100) NOT NULL,
  "cidade" VARCHAR(100) NOT NULL,
  "estado" VARCHAR(2) NOT NULL,
  "CEP" VARCHAR(9) NOT NULL,
  "nascimento" DATE
);

CREATE TABLE IF NOT EXISTS "hospedagens" (
  "id" SERIAL PRIMARY KEY,
  "estado" VARCHAR(2) NOT NULL,
  "dataInicio" DATE NOT NULL,
  "dataFim" DATE NOT NULL,
  "desconto" REAL NOT NULL,
  "valorFinal" REAL NOT NULL
);
