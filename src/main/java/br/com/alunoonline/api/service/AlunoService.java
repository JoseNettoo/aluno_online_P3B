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
    }//Aluno aluno - preparando o front para mandar com JSON "aluno" vem do front em json
    public void atualizarAlunoPorId(Long id, Aluno aluno){
        //primeiro passo; ve se o aluno existe no BD
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        // e se nao existir esse aluno?
        if(alunoDoBancoDeDados.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Aluno nao encontrado no banco de dados");
        }
        //se chegar aqui , significa que exite aluno com esse id!
        //vou armazena-lo em uma variavel para depois edita-lo.
        Aluno alunoParaEditar= alunoDoBancoDeDados.get();

        // com esse aluno para ser editado acima, faço
        // os sets necessarios para atualizar os atributos dele
        alunoParaEditar.setNome(aluno.getNome());
        alunoParaEditar.setCpf(aluno.getCpf());
        alunoParaEditar.setEmail(aluno.getEmail());

        //com o aluno totalmente aditado acima
        //eu devolvo ele atualizado para o bd
        alunoRepository.save(alunoParaEditar);
    }



}
