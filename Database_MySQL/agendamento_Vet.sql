CREATE DATABASE agendamento_Vet;
USE agendamento_Vet;


CREATE TABLE Animal(
id_anim INT PRIMARY KEY,
tipo_anim VARCHAR(60)
);

INSERT INTO Animal (id_anim, tipo_anim) VALUE (1, 'Cachorro');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (2, 'Gato');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (3, 'Papagaio');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (4, 'Hamster');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (5, 'Coelho');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (6, 'Galinha');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (7, 'Porco');
INSERT INTO Animal (id_anim, tipo_anim) VALUE (8, 'Pato');


CREATE TABLE Veterinario(
id_vet INT PRIMARY KEY,
nome_vet VARCHAR(90),
cpf_vet VARCHAR(12)
);


INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (1, 'Alberto Gonçalves', '897365456-96');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (2, 'Mirian Ribeiro', '789746524-23');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (3, 'Larissa Gutemberg', '357951831-46');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (4, 'Eduardo Ferreira', '713982647-65');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (5, 'Sergio Nogueira', '827319729-78');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (6, 'Monica Souza', '791352796-81');
INSERT INTO Veterinario (id_vet, nome_vet, cpf_vet) VALUES (7, 'Carlos Silveira', '468275169-55');

CREATE TABLE Consulta(
id_consulta INT PRIMARY KEY AUTO_INCREMENT,
nome_cliente VARCHAR(90),
nome_pet VARCHAR(45),
id_anim INT,
FOREIGN KEY (id_anim) REFERENCES Animal(id_anim),
id_vet INT,
FOREIGN KEY (id_vet) REFERENCES Veterinario(id_vet),
data_consulta VARCHAR(11)
);