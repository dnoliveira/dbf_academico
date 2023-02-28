/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.service;

import br.cefet.academico.dao.AlunoDao;
import br.cefet.academico.model.Aluno;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

/**
 *
 * @author dougl
 */
@Service
public class AlunoService {
    
    private final AlunoDao alunoDao;
    
    public AlunoService(Jdbi jdbi){
        this.alunoDao = jdbi.onDemand(AlunoDao.class);
    }
    
    public Aluno inserir (Aluno aluno){
        int idAluno = alunoDao.insert(aluno);
        aluno.setId(idAluno);
        return aluno;
    }
    
    public List<Aluno> consultarTodos(){
        return alunoDao.getAll();
    }
    
    public Aluno consultarPorId(int id){
        return alunoDao.get(id);
    }
    
    public void alterar(Aluno aluno){
        alunoDao.update(aluno);
    }
    
    public void excluir(int id){
        alunoDao.delete(id);
    }
    
}
