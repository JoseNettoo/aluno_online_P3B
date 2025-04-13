package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//jparepository é erdado da springdata
// <aluno, Longe> tem que informar que a interface é da classe aluno, e o long é o tipo da chave primaria da tabela

@Repository // agora o spring sabe que é um repositorio
public interface AlunoRepository extends JpaRepository<Aluno, Long>{//lincando o repositorio e informando a classe e model{

}
