CREATE TABLE IF NOT EXISTS "clientes" (
  "id" SERIAL PRIMARY KEY,
  "nome" VARCHAR(64) NOT NULL,
  "rg" VARCHAR(20) NOT NULL,
  "endereco" VARCHAR(255),
  "bairro" VARCHAR(100),
  "cidade" VARCHAR(100),
  "estado" VARCHAR(2),
  "CEP" VARCHAR(9) NOT NULL,
  "nascimento" DATE
);

CREATE TABLE IF NOT EXISTS "hospedagens" (
  "id" SERIAL PRIMARY KEY,
  "estado" VARCHAR(2),
  "dataInicio" DATE NOT NULL,
  "dataFim" DATE NOT NULL,
  "desconto"  DECIMAL(10, 2),
  "qtdPessoas" SMALLINTEGER,
  "valorFinal"  DECIMAL(10, 2) NOT NULL,
  "cliente_id" INTEGER REFERENCES "clientes"("id")
);
