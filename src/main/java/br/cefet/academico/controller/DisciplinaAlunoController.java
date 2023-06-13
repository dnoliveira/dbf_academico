/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.controller;

import br.cefet.academico.model.Aluno;
import br.cefet.academico.model.DisciplinaAluno;
import br.cefet.academico.service.DisciplinaAlunoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/disciplina/{idDisc}/aluno")
public class DisciplinaAlunoController {
    
    private final DisciplinaAlunoService disciplinaAlunoService;
    
    public DisciplinaAlunoController(DisciplinaAlunoService disciplinaAlunoService){
        this.disciplinaAlunoService = disciplinaAlunoService;
    }
    
    @GetMapping({"/", ""})
    public List<Aluno> consultarTodos(@PathVariable("idDisc") int idDisc){
        List<Aluno> alunoList = disciplinaAlunoService.getByDisciplina(idDisc);
        return alunoList;
    }
    
    @GetMapping("/{idAluno}")
    public Aluno consultarAluno(@PathVariable("idDisc") int idDisc, @PathVariable("idAluno") int idAluno){
        Aluno aluno = disciplinaAlunoService.get(idDisc, idAluno);
        return aluno;
    }
    
    @PostMapping({"", "/"})
    public Aluno inserir(@RequestBody DisciplinaAluno disciplinaAluno){
        Aluno aluno = disciplinaAlunoService.inserir(disciplinaAluno);
        return aluno;
    }
    
    @DeleteMapping({"", "/"})
    public List<Aluno> deletar(@PathVariable("idDisc") int idDisc){
        List<Aluno> alunoList = disciplinaAlunoService.getByDisciplina(idDisc);
        if (alunoList == null || alunoList.isEmpty()){
            throw new RuntimeException("Nao existem alunos com este idDisc para ser excluido....");
        }
        disciplinaAlunoService.deleteAllByDisciplina(idDisc);
        return alunoList;
    }
    
    @DeleteMapping("/{idAluno}")
    public Aluno deletar(
            @PathVariable("idDisc") int idDisc, 
            @PathVariable("idAluno") int idAluno
    ){
        Aluno aluno = disciplinaAlunoService.get(idDisc, idAluno);
        if (aluno == null){
            throw new RuntimeException("Nao existe aluno com este id para ser excluido....");
        }
        disciplinaAlunoService.delete(idDisc, idAluno);
        return aluno;
    }
    
}
