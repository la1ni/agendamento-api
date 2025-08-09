CREATE TABLE profissional_servico(
    profissional_id UUID,
    servico_id UUID,
    FOREIGN KEY (profissional_id) references profissional(id),
    FOREIGN KEY (servico_id) references servico(id)
)