use petFX;

INSERT INTO Usuario (cpf_crmv, nome_user, rua, numero, cep, cidade, UF, tipo_user, senha, email, tel) VALUES
("CRMV-SP-4432", "Emerson Abreu", "Rocaglia", "342", "13234755","campinas", "SP", "veterinario", "1234","@gmail.com", "78787"),
("CRMV-SP-5329", "Vivian Andrada", "Amazonas","76", "13675993","arthur nogueira", "SP", "veterinario","4321","@gmail.com", "78787"),
("17356452345", "Marcio Pereira", "alvorada", "654", "13046777","valinhos", "SP", "administrativo","2143", "@gmail.com", "78787"),
("27356452345", "Luana Ana", "major alfredo", "456", "13046755","campinas", "SP", "administrativo", "3421", "@gmail.com", "78787");

INSERT INTO petExame (codigo, nome, preco) VALUES
("E101", "eletrocardiograma", '56.72'),
("E102", "sangue", '24.50'),
("E103", "urina", '19.90');

INSERT INTO petRemedio (codigo, nome, preco) VALUES
("R101", "analgesico", '56.72'),
("R102", "symparic", '24.50'),
("R103", "probiotico", '19.90');

INSERT INTO petVacina (codigo, nome, preco) VALUES
("V101", "coronavac", '56.72'),
("V102", "astrazenica", '24.50'),
("V103", "pfizer", '19.90');

insert into agendamento (data_con, hora_con, codigopet, nomepet, 
						cpf_crmv, nome_user) values
						("2021-10-13", "15:30", "C101", "irlandes", "CRMV-SP-5329", "Vivian Andrada"),
						("2021-10-13", "08:30", "C102", "nina", "CRMV-SP-4432", "Emerson Abreu"),
						("2021-10-13", "11:30", "C103", "zander", "CRMV-SP-5329", "Vivian Andrada"),
                        ("2021-12-05", "08:30", "C105", "suzy", "CRMV-SP-4432", "Emerson Abreu"),
                        ("2021-12-05", "14:00", "C104", "laiska", "CRMV-SP-5329", "Vivian Andrada");
                        
                        
insert into Consulta (data_con, hora_con, codigopet, nomepet, cpf_crmv, nome_user, 
					peso_con, idade_con, obs_con, vacina, remedio, exame) values
("2021-10-13", "15:30",  "C101", "irlandes", "CRMV-SP-5329", "Vivian Andrada", "12.5", "2", "muita coceira", "pfizer", "symparic", "urina"),
("2021-10-13", "08:30",  "C102", "nina", "CRMV-SP-4432", "Emerson Abreu", "9", "3", "", "astrazenica", "", "sangue"),
("2021-10-13", "11:30",  "C103", "zander", "CRMV-SP-5329", "Vivian Andrada", "6.55", "4", "excelente", "", "", ""),
("2021-12-05", "08:30",  "C105", "suzy", "CRMV-SP-4432", "Emerson Abreu", "1.50", "2", "apresenta apatia", "coronavac", "analgesico", "eletrocardiograma"),
("2021-12-05", "14:00", "C104", "laiska", "CRMV-SP-5329", "Vivian Andrada", "2.47", "2", "apresenta apatia", "coronavac", "analgesico", "eletrocardiograma");
                      
                      
INSERT INTO Paciente (codigopet, nomepet, raca, idade, peso, sexo, cpfdono, nomedono, rua, numero, cep, cidade, UF, email, telefone) VALUES
	("C101", "irlandes", "husky", "4", "12,67", "Masculino", "32726305876", "Kazemiro", "alfazema","879","1234562","campinas", "SP", "kaz@gmail.com", "19981777654"),
	("C102",  "nina", "SRD", "2", "15,00", "Feminino", "67826305876", "Angelica Houston", "bromelias","231","1233456","valinhos", "SP", "an@gmail.com", "19981888990"),
    ("C103",  "zander", "poodle", "3", "9,65", "Masculino", "67826305876", "Angelica Houston", "bromelias","231","1233456","valinhos", "SP", "an@gmail.com", "19981888990"),
    ("C104",  "laiska", "york", "1", "2", "Feminino", "54345678941",  "Dorneles Fields", "das correas","77","9876548","vinhedo", "SP", "df@gmail.com", "19981876540"),
    ("C105",  "suzy", "shitzu", "2", "1,33", "Feminino", "34567890321", "Donita Sparks", "munduruku","13","5436789","cosmopolis", "SP", "sparksdon@gmail.com", "19981843250");
    
    
