package br.cefet.academico.controller;

import br.cefet.academico.model.Disciplina;
import br.cefet.academico.model.AlunoDisciplina;
import br.cefet.academico.service.AlunoDisciplinaService;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dougl
 */
@RestController
@RequestMapping("/api/v1/aluno/{idAluno}/disciplina")
public class AlunoDisciplinaControlle {
    
    private final AlunoDisciplinaService alunoDisciplinaService;
    
    public AlunoDisciplinaControlle(AlunoDisciplinaService alunoDisciplinaService){
        this.alunoDisciplinaService = alunoDisciplinaService;
    }
    
    @GetMapping({"/", ""})
    public List<Disciplina> getByAluno(@PathVariable("idAluno") int idAluno){
        List<Disciplina> disciplinaList = alunoDisciplinaService.getByAluno(idAluno);
        return disciplinaList;
    }
    
    @GetMapping("/{idDisc}")
    public Disciplina consultar(
            @PathVariable("idAluno") int idAluno,
            @PathVariable("idDisc") int idDisc
    ){
        Disciplina disciplina = alunoDisciplinaService.get(idAluno, idDisc);
        return disciplina;
    }
    
    @PostMapping({"", "/"})
    public Disciplina inserir(@RequestBody AlunoDisciplina alunoDisciplina){
        Disciplina disciplina = alunoDisciplinaService.inserir(alunoDisciplina);
        return disciplina;
    }
    
    @DeleteMapping({"", "/"})
    public List<Disciplina> deletarByAluno(@PathVariable("idAluno") int idAluno){
        List<Disciplina> disciplinaList = alunoDisciplinaService.getByAluno(idAluno);
        if (disciplinaList == null || disciplinaList.isEmpty()){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        alunoDisciplinaService.deleteAllByAluno(idAluno);
        return disciplinaList;
    }
    
    @DeleteMapping("/{idDisc}")
    public Disciplina deletar(
            @PathVariable("idAluno") int idAluno, 
            @PathVariable("idDisc") int idDisc
    ){
        Disciplina disciplina = alunoDisciplinaService.get(idAluno, idDisc);
        if (disciplina == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        alunoDisciplinaService.delete(idAluno, idDisc);
        return disciplina;
    }
}
