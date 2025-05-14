package br.com.alunoonline.api.dtos;

import lombok.Data;

//pq ele leva somente o que interessa na transferencia de dados
@Data
public class AtualizarNotasRequestDTO {
    private Double nota1;
    private Double nota2;
}
