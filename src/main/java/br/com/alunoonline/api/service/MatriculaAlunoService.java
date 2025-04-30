package br.com.alunoonline.api.service;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;


    public void criarMatricula(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public List<MatriculaAluno>listarTodasMatriculaAluno(){
        return matriculaAlunoRepository.findAll();

    }

    public Optional<MatriculaAluno>buscarMatriculaAlunoPorId(long id){
        return matriculaAlunoRepository.findById(id);
    }

}
