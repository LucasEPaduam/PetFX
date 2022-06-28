use petFX;

drop table consulta;

/*CONSULTA SIMPLES*/
select * from Usuario;
select * from Paciente order by nomepet;
select * from agendamento;
select * from Consulta;
select * from petVacina;
select * from petExame;
select * from petRemedio;

SELECT * FROM agendamento ORDER BY data_con;
SELECT * FROM agendamento WHERE data_con = curdate() ORDER BY data_con;

DELETE FROM Consulta WHERE codigopet = "C101";
UPDATE agendamento SET codigopet = "C104", nomepet = "Irlandes", cpf_crmv = "CRMV-SP-5329", nome_user = "Vivian Andrada" WHERE data_con = "2021-10-13" AND hora_con = "15:30";

/*Seleciona paciente e vet que realizarão consulta na data informada*/
select nomepet as PET, nome_user as VETERINÁRIO from agendamento where data_con = curdate();

/*seleciona paciente e seu respectivo dono*/
select nomepet as PET, nomedono as DONO from paciente;

/*seleciona pacientes consultados aos quais tenha sido receitado vacina*/
select data_con as DATA, nomepet as PET, vacina as VACINA from consulta where vacina is not null; 

/*seleciona o nome de donos de pet, caso um dono esteja atrelado a mais de um pet, este nome será agrupado*/
select nomedono from paciente group by nomedono;

/*seleciona apenas as consultas agendado para o veterinário informado*/
select nomepet from agendamento where cpf_crmv = "CRMV-SP-5329"; 


/*CONSULTAS - JUNÇÕES*/

/*seleciona codigo e nome do paciente e codigo e nome do seu respectivo dono*/
select p.codigopet, p.nomepet, d.cpf, d.nomedono
	from paciente p join dono d on p.codigopet = d.paciente_codigopet;
    
/*seleciona o peso do paciente na data de cadastro e posteriomente na consulta*/
select nomedono, nomepet, peso as PESO_CADASTRO, consulta_peso as PESO_CONSULTA
	from dono join paciente on codigopet = paciente_codigopet 
			  join consulta on consulta_codigopet = codigopet;
              
/*seleciona data e hora da consulta do paciente, dono e vet responsável. 
Consultas realizadas no mês 10 ou dia 10 onde tenha sido receitado algum remédio */              
select consulta_nomevet as VET, nomepet as PET, nomedono as DONO, 
	   consulta_data, consulta_hora
			from dono join paciente on paciente_codigopet = codigopet 
				join consulta on consulta_codigopet = codigopet
                  where consulta_data like '%10%' and consulta_remedio is not null
					order by nomepet asc;
                   
/*seleciona pacientes que passaram por consulta onde tenha sido receitado o remédio analgésico
e alguma vacina com a letra a*/                   
SELECT codigopet, count(codigopet) 
	FROM paciente join consulta on consulta_codigopet = codigopet
		WHERE consulta_remedio = "analgesico" AND consulta_vacina like '%a%';

/*calcula a média de idade de pacientes maiores de 1 ano que passaram por consulta */
SELECT avg (consulta_idade) 
	FROM paciente join consulta on consulta_codigopet = codigopet
		WHERE nomepet like '%a%'
			having avg(consulta_idade) > 1;
            
            
/*CONSULTAS - SUBCONSULTAS*/ 

/*seleciona pet e dono que não existam na tabela consulta com remédio valor null*/
select nomepet, nomedono
	from paciente join dono on codigopet = paciente_codigopet
		where not exists (select * from consulta 
							where consulta_codigopet = codigopet and consulta_remedio is null);
     
/*seleciona pacientes com idade maior que o pet numero c105*/     
select nomepet
	from paciente
    where idade > (select idade from paciente where codigopet = "C105");



/*CONSULTAS - VISÕES*/ 


/*Mostra as consultas do dia atual*/
CREATE VIEW consultas_do_dia (PACIENTE, DONO, VET, DATA, HORA) AS
	select nomepet, nomedono, v.nome, consulta_data, consulta_hora
		from paciente join dono on codigopet = paciente_codigopet 
						  join consulta on codigopet = consulta_codigopet
							join Vet v on crmv = consulta_vetcrmv
								where consulta_data = curdate();

select * from consultas_do_dia;

/*Mostra a quantidade de consultas realizadas por cada pet*/
CREATE VIEW quantidade_consultas (COD_PET, NOMEPET, DONO, VETERINARIO, QUANT_CONSULTAS) AS
	select consulta_codigopet, consulta_nomepet, nomedono, consulta_nomevet, count(*) as Quant_Consultas
		from consulta, dono
			where consulta_codigopet = paciente_codigopet
				group by consulta_nomepet order by consulta_codigopet asc;

select * from quantidade_consultas;

/*Mostra todos os pacientes cadastrados no sistema*/
CREATE VIEW pacientes_cadastrados (COD_PET, NOMEPET, CPF_DONO, NOME_DONO) AS
	select p.codigopet, p.nomepet, d.cpf, d.nomedono
		from paciente p join dono d on p.codigopet = d.paciente_codigopet;

select * from pacientes_cadastrados;

/*Mostra todos os usuários cadastrados no sistema*/
CREATE VIEW usuarios_cadastrados (CPF_CRMV, NOME) AS
	select usuario, nome_usuario
		from Usu;

select * from usuarios_cadastrados;

/*Mostra a quantidade de consultas ministradas por cada vet*/
CREATE VIEW quantidade_consultas_por_vet (CRMV, NOME, QUANT_CONSULTAS) AS
select consulta_vetcrmv, consulta_nomevet, count(*) as Quant_Consultas
		from consulta
			group by consulta_vetcrmv order by consulta_vetcrmv asc;
		
select * from quantidade_consultas_por_vet;


 

