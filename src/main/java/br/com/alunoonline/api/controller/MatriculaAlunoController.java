package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMatricula(@RequestBody MatriculaAluno matriculaAluno){
        matriculaAlunoService.criarMatricula(matriculaAluno);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MatriculaAluno> listarTodosMatriculaAluno(){
        return matriculaAlunoService.listarTodasMatriculaAluno();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MatriculaAluno> buscarMatriculaAlunoPorId(@PathVariable Long id){
        return matriculaAlunoService.buscarMatriculaAlunoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMatriculaAlunoporId(@PathVariable Long id){
        matriculaAlunoService.deletarMatriculaAlunoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarMatriculaAlunoPorId(@PathVariable Long id, @RequestBody MatriculaAluno matriculaAluno){
        matriculaAlunoService.atualizarMatriculaAlunoPorId(id, matriculaAluno);
    }

    @PatchMapping("/trancar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void trancarMatricula(@PathVariable Long id){
        matriculaAlunoService.trancarMatricula(id);
    }

    @PatchMapping("/atualizar-notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarNotas(@PathVariable Long id, @RequestBody AtualizarNotasRequestDTO atualizarNotasRequestDTO){

        matriculaAlunoService.atualizarNotas(id, atualizarNotasRequestDTO);
    }

    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponseDTO emitirHistorico(@PathVariable Long alunoId){
        return matriculaAlunoService.emitirHistorico(alunoId);
    }
}
