
package br.cefet.academico.controller;

import br.cefet.academico.model.AlunoTelefone;
import br.cefet.academico.service.AlunoTelefoneService;
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
@RequestMapping("/api/v1/alunotelefone")
public class AlunoTelefoneController {
    private final AlunoTelefoneService alunoTelefoneService;
    
    public AlunoTelefoneController(AlunoTelefoneService alunoTelefoneService){
        this.alunoTelefoneService = alunoTelefoneService;
    }
    
    @GetMapping({"/", ""})
    public List<AlunoTelefone> consultarTodos(){
        List<AlunoTelefone> alunoList = alunoTelefoneService.consultarTodos();
        return alunoList;
    }
    
    @GetMapping("/{id}")
    public AlunoTelefone consultarAluno(@PathVariable("id") int id){
        AlunoTelefone ret = alunoTelefoneService.consultarPorId(id);
        return ret;
    }
    
    @PostMapping({"", "/"})
    public AlunoTelefone inserir(@RequestBody AlunoTelefone alunoTelefone){
        AlunoTelefone ret = alunoTelefoneService.inserir(alunoTelefone);
        return ret;
    }
    
    @PutMapping({"", "/"})
    public AlunoTelefone alterar(@RequestBody AlunoTelefone alunoTelefone){
        alunoTelefoneService.alterar(alunoTelefone);
        return alunoTelefone;
    }
    
    @DeleteMapping("/{id}")
    public AlunoTelefone deletar(@PathVariable("id") int id){
        AlunoTelefone aluno = alunoTelefoneService.consultarPorId(id);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        alunoTelefoneService.excluir(id);
        return aluno;
    }
}
