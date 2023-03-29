create table clientes(

     id bigint not null auto_increment,
     nome varchar(100) not null,
     email varchar(100) not null unique,
     altura decimal(5,2) not null,
     peso decimal(5,2) not null,
     nivelSedentarismo enum('COMPLETAMENTE_SEDENTARIO, SEDENTARIO, ATIVO, ATLETA'),

     primary key(id)

);