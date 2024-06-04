CREATE TABLE IF NOT EXISTS aluno (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS curso (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS aluno_curso (
                                           aluno_id BIGINT NOT NULL,
                                           curso_id BIGINT NOT NULL,
                                           PRIMARY KEY (aluno_id, curso_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
    );
