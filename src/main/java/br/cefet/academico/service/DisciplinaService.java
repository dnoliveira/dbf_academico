/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.service;

import br.cefet.academico.dao.DisciplinaDao;
import br.cefet.academico.model.Disciplina;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

/**
 *
 * @author dougl
 */
@Service
public class DisciplinaService {
    
    private final DisciplinaDao disciplinaDao;
    
    public DisciplinaService(Jdbi jdbi){
        this.disciplinaDao = jdbi.onDemand(DisciplinaDao.class);
    }
    
    public Disciplina inserir (Disciplina disciplina){
        int id = disciplinaDao.insert(disciplina);
        disciplina.setId(id);
        return disciplina;
    }
    
    public List<Disciplina> consultarTodos(){
        List<Disciplina> disciplinaList = disciplinaDao.getAll();
        return disciplinaList;
    }
    
    public Disciplina consultarPorId(int id){
        Disciplina aluno = disciplinaDao.get(id);
        return aluno;
    }
    
    public void alterar(Disciplina disciplina){
        disciplinaDao.update(disciplina);
    }
    
    public void excluir(int id){
        disciplinaDao.delete(id);
    }
    
}
