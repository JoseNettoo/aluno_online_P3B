package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "disciplina")
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    @ManyToOne // primeira palavra fala da classe, many "muitas disciplinas",TO"para", one"um professor"
    @JoinColumn(name = "professor_id") // juntar as duas tabelas, chave estrangeira( nome de tabela referenciando com chave primaria)
    private Professor professor;// relacionamento JPA, para referenciar o objeto anterior,
}
