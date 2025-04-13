package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // // cria o contrutor sem argumentos
@AllArgsConstructor // cria os construtores com argumentos
@Data //ja faz get e setter
@Table(name = "aluno") //criar tabela, "as anotações de @ é para o que tem abaixo"
@Entity //Informar que e uma entidade
public class Aluno {

    @Id // identificando como chave primario
    @GeneratedValue(strategy = GenerationType.AUTO) // no pessoal usar identity
    private Long id;
    private String nome;
    private String cpf;
    private String email;


}
