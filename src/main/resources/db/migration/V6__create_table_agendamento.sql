CREATE TABLE agendamentos (

        id BIGINT NOT NULL AUTO_INCREMENT,
        dataHora DATETIME NOT NULL,
        treinador_id BIGINT,
        cliente_id BIGINT,
        PRIMARY KEY (id),
        FOREIGN KEY (treinador_id) REFERENCES treinadores(id),
        FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
