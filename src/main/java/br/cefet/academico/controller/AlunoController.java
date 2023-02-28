package br.cefet.academico.controller;

import br.cefet.academico.model.Aluno;
import java.util.ArrayList;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dougl
 */
@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {
    
    private Aluno a1 = new Aluno(1, "Samuel B.O.", 18);
    private Aluno a2 = new Aluno(2, "Gabriella B.O.", 10);
    
    @GetMapping({"/", ""})
    public List<Aluno> consultarTodos(){
        List<Aluno> alunoList = new ArrayList<>();
        alunoList.add(a1);
        alunoList.add(a2);
        
        return alunoList;
    }
    
    @GetMapping("/{idAluno}")
    public Aluno consultarAluno(
            @PathVariable("idAluno") int idAluno)
    {
        if (idAluno == 1){
            return a1;
        }else{
            return a2;
        }
    }
    
}
