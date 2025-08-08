CREATE TABLE agendamento(
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    profissional_id UUID,
    servico_id UUID,
    usuario_id UUID,
    FOREIGN KEY (profissional_id) REFERENCES profissional(id) ON DELETE CASCADE,
    FOREIGN KEY (servico_id) REFERENCES servico(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
)