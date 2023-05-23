package br.cefet.academico.controller;

import br.cefet.academico.model.Disciplina;
import br.cefet.academico.service.DisciplinaService;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dougl
 */
@RestController
@RequestMapping("/api/v1/aluno")
public class DisciplinaController {
    
    private final DisciplinaService disciplinaService;
    
    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }
    
    @GetMapping({"/", ""})
    public List<Disciplina> consultarTodos(){
        List<Disciplina> alunoList = disciplinaService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Disciplina consultarAluno(@PathVariable("id") int id){
        Disciplina ret = disciplinaService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Disciplina inserir(@RequestBody Disciplina disciplina){
        Disciplina ret = disciplinaService.inserir(disciplina);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Disciplina alterar(@RequestBody Disciplina disciplina){
        disciplinaService.alterar(disciplina);
        return disciplina;
    }
    
    @DeleteMapping("/{id}")
    public Disciplina deletar(@PathVariable("id") int id){
        Disciplina aluno = disciplinaService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        disciplinaService.excluir(id);
        return aluno;
    }
}
