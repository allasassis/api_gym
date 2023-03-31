create table treinadores(

     id bigint not null auto_increment,
     nome varchar(100) not null,
     especializacao enum('PERSONAL_TRAINER', 'JIUJITSU','NATACAO', 'MUAYTHAI'),

     primary key(id)

);