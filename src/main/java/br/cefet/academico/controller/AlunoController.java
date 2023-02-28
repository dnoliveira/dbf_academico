package br.cefet.academico.controller;

import br.cefet.academico.model.Aluno;
import br.cefet.academico.service.AlunoService;

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
public class AlunoController {
    
    private final AlunoService alunoService;
    
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }
    
    @GetMapping({"/", ""})
    public List<Aluno> consultarTodos(){
        List<Aluno> alunoList = alunoService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public Aluno consultarAluno(@PathVariable("id") int id){
        Aluno ret = alunoService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public Aluno inserir(@RequestBody Aluno aluno){
        Aluno ret = alunoService.inserir(aluno);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public Aluno alterar(@RequestBody Aluno aluno){
        alunoService.alterar(aluno);
        return aluno;
    }
    
    @DeleteMapping("/{id}")
    public Aluno alterar(@PathVariable("id") int id){
        Aluno aluno = alunoService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        alunoService.excluir(id);
        return aluno;
    }
}
