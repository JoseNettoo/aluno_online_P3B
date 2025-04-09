package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository; // ele injetar as dependencias da coisa

    public void criarAluno(Aluno aluno){
        alunoRepository.save(aluno);

    }
    public List<Aluno>listarTodosAlunos(){
        return alunoRepository.findAll(); // retornando todos os alunos, no repository
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);

    }

}
