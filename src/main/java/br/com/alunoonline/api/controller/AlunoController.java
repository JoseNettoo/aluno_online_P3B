package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // saber qual a arquitetura vai rodar
@RequestMapping("/alunos") //requisição para o caminho se chama endpoint, path "alunos" o caminho, boa pratica colocar em plural
public class AlunoController {

    @Autowired
    AlunoService alunoService; // ele injeta as dependencia

    @ResponseStatus(HttpStatus.CREATED) // resposta 201 created
    @PostMapping // tipo da requisicção, post criar, mapping caminho
    public void criarAluno(@RequestBody Aluno aluno) {

        alunoService.criarAluno(aluno);
    }
    @GetMapping // requisição get para pegar, fronta so faz pegar
    @ResponseStatus(HttpStatus.OK) // response é 200 ok
    public List<Aluno> listarTodosAlunos(){

        return alunoService.listarTodosAlunos();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // pathvariable-pega a variavel id que esta dentro da url
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id){

        return alunoService.buscarAlunoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id){
        alunoService.deletarAlunoPorId(id);
    }
}
