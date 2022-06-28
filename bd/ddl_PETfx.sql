
CREATE DATABASE IF NOT EXISTS petFX;
USE petFX; 


CREATE TABLE IF NOT EXISTS Usuario(
cpf_crmv varchar (12) PRIMARY KEY NOT NULL,
nome_user varchar (100)  NOT NULL,
rua varchar (100)  NOT NULL,
numero varchar (5)  NOT NULL,
cep varchar (8)  NOT NULL,
cidade varchar (100)  NOT NULL,
UF varchar (2)  NOT NULL,
tipo_user varchar (20) NOT NULL,
senha varchar (6) NOT NULL,
email varchar (100) NOT NULL,
tel varchar (20) NOT NULL
);


CREATE TABLE IF NOT EXISTS petExame(
codigo varchar (4) PRIMARY KEY NOT NULL,
nome varchar (50)  NOT NULL,
preco varchar (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS petRemedio(
codigo varchar (4) PRIMARY KEY NOT NULL,
nome varchar (50)  NOT NULL,
preco varchar (10) NOT NULL
);


CREATE TABLE IF NOT EXISTS petVacina(
codigo varchar (4) PRIMARY KEY NOT NULL,
nome varchar (50)  NOT NULL,
preco varchar (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS agendamento(
data_con varchar (10) NOT NULL,
hora_con varchar (5) NOT NULL,
codigopet varchar (10) NOT NULL,
nomepet varchar (50) NOT NULL,
cpf_crmv varchar (12) NOT NULL,
nome_user varchar (100) NOT NULL,
PRIMARY KEY (data_con, hora_con, cpf_crmv),
CONSTRAINT fk_agendamento_paciente FOREIGN KEY (codigopet) REFERENCES hashpetsharp.paciente (codigopet),
CONSTRAINT fk_agendamento_Veterinario FOREIGN KEY (cpf_crmv) REFERENCES hashpetsharp.Usuario (cpf_crmv)
);

CREATE TABLE IF NOT EXISTS Consulta(
data_con varchar (10) NOT NULL,
hora_con varchar (5) NOT NULL,
codigopet varchar (10) NOT NULL,
nomepet varchar (50) NOT NULL,
cpf_crmv varchar (12) NOT NULL,
nome_user varchar (100) NOT NULL,
peso_con varchar (8),
idade_con varchar (4),
obs_con varchar (500),
vacina1 varchar (100),
vacina2 varchar (100),
vacina3 varchar (100),
remedio1 varchar (100),
remedio2 varchar (100),
remedio3 varchar (100),
exame1 varchar (100),
exame2 varchar (100),
exame3 varchar (100),
primary key (data_con, hora_con, cpf_crmv),
CONSTRAINT fk_consulta_veterinario FOREIGN KEY (cpf_crmv) REFERENCES hashpetsharp.Usuario (cpf_crmv),
CONSTRAINT fk_consulta_paciente FOREIGN KEY (codigopet) REFERENCES hashpetsharp.paciente (codigopet),
CONSTRAINT fk_consulta_agendamento FOREIGN KEY (data_con) REFERENCES hashpetsharp.agendamento (data_con),
CONSTRAINT fk_consulta_agendamento FOREIGN KEY (hora_con) REFERENCES hashpetsharp.agendamento (hora_con)
);                        

CREATE TABLE IF NOT EXISTS Paciente(
codigopet varchar (10) NOT NULL,
nomepet varchar (50) NOT NULL,
raca varchar (10)  NOT NULL,
idade varchar (2)  NOT NULL,
peso varchar (8)  NOT NULL,
sexo varchar (15)  NOT NULL,
cpfdono varchar (11) NOT NULL,
nomedono varchar (100)  NOT NULL,
rua varchar (100)  NOT NULL,
numero varchar (5)  NOT NULL,
cep varchar (8)  NOT NULL,
cidade varchar (100)  NOT NULL,
UF varchar (2)  NOT NULL,
email varchar (100)  NOT NULL,
telefone varchar (11)  NOT NULL,
PRIMARY KEY (codigopet, cpfdono)
);



