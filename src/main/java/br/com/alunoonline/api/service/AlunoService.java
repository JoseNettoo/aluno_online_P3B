package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service // informa ao spring que essa classe é service
public class AlunoService {

    @Autowired //injetando a dependencia do repository service
    AlunoRepository alunoRepository; // //injetando a dependencia do repository service

    public void criarAluno(Aluno aluno){
        alunoRepository.save(aluno);

    }
    public List<Aluno>listarTodosAlunos(){
        return alunoRepository.findAll(); // retornando todos os alunos, no repository
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);

    }
    public void deletarAlunoPorId(Long id){
        Optional<Aluno> aluno= alunoRepository.findById(id);
        if (aluno.isPresent()){
                alunoRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado");
        }
    }

}
