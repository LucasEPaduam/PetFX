use petFX;

INSERT INTO Usuario (cpf_crmv, nome_user, rua, numero, cep, cidade, UF, tipo_user, senha, email, tel) VALUES
("CRMV-SP-4432", "Emerson Abreu", "Rocaglia", "342", "13234755","campinas", "SP", "veterinario", "1234","@gmail.com", "78787"),
("CRMV-SP-5329", "Vivian Andrada", "Amazonas","76", "13675993","arthur nogueira", "SP", "veterinario","4321","@gmail.com", "78787"),
("17356452345", "Marcio Pereira", "alvorada", "654", "13046777","valinhos", "SP", "administrativo","2143", "@gmail.com", "78787"),
("27356452345", "Luana Ana", "major alfredo", "456", "13046755","campinas", "SP", "administrativo", "3421", "@gmail.com", "78787");

INSERT INTO petExame (codigo, nome, preco) VALUES
("E101", "ELETROCARDIOGRAMA", '56.72'),
("E102", "SANGUE", '24.50'),
("E103", "URINA", '19.90');

INSERT INTO petRemedio (codigo, nome, preco) VALUES
("R101", "ANALGÉSICO", '56.72'),
("R102", "SYMPARIC", '24.50'),
("R103", "PROBIÓTICO", '19.90');

INSERT INTO petVacina (codigo, nome, preco) VALUES
("V101", "CORONAVAC", '56.72'),
("V102", "ASTRAZENICA", '24.50'),
("V103", "PFIZER", '19.90');

insert into agendamento (data_con, hora_con, codigopet, nomepet, 
						cpf_crmv, nome_user) values
						("2022-06-28", "15:30", "C101", "WOLFA", "CRMV-SP-5329", "Vivian Andrada"),
						("2022-06-28", "08:30", "C102", "IRLANDES", "CRMV-SP-4432", "Emerson Abreu");
                        
                        
insert into Consulta (data_con, hora_con, codigopet, nomepet, cpf_crmv, nome_user, 
					peso_con, idade_con, obs_con, vacina1,vacina2,vacina3, remedio1,remedio2,remedio3, exame1,exame2,exame3) values
("2021-06-28", "15:30",  "C101", "WOLFA", "CRMV-SP-5329", "Vivian Andrada", "12.5", "2", "muita coceira", "pfizer", "","","symparic", "","","urina","",""),
("2021-06-28", "08:30",  "C102", "IRLANDES", "CRMV-SP-4432", "Emerson Abreu", "9", "3", "", "astrazenica", "","","symparic", "","","urina","","");
                      
                      
INSERT INTO Paciente (codigopet, nomepet, raca, idade, peso, sexo, cpfdono, nomedono, rua, numero, cep, cidade, UF, email, telefone) VALUES
	("C101", "WOLFA", "HUSKY", "4", "12,67", "Feminino", "32726305876", "Lucas Paduam", "Estrada Velha","879","1234562","Arthur Nogueira", "SP", "lp@gmail.com", "19981777654"),
	("C102",  "IRLANDES", "SRD", "2", "15,00", "Masculino", "67826305876", "Angelica Spark", "Rua das Bromelias","231","1233456","Valinhos", "SP", "an@gmail.com", "19981888990");
    
    
