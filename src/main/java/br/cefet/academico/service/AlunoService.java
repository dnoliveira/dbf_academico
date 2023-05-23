/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.service;

import br.cefet.academico.dao.AlunoDao;
import br.cefet.academico.dao.AlunoTelefoneDao;
import br.cefet.academico.model.Aluno;
import br.cefet.academico.model.AlunoTelefone;
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
    private final AlunoTelefoneDao alunoTelefoneDao; 
    
    public AlunoService(Jdbi jdbi){
        this.alunoDao = jdbi.onDemand(AlunoDao.class);
        this.alunoTelefoneDao = jdbi.onDemand(AlunoTelefoneDao.class);
    }
    
    public Aluno inserir (Aluno aluno){
        int idAluno = alunoDao.insert(aluno);
        aluno.setId(idAluno);
        return aluno;
    }
    
    public List<Aluno> consultarTodos(){
        List<Aluno> alunoList = alunoDao.getAll();
        
        for (Aluno aluno : alunoList) {
            List<AlunoTelefone> alunoTelefoneList = alunoTelefoneDao.getAllByAluno(aluno.getId());
            aluno.setTelefones(alunoTelefoneList);
        }
        
        return alunoList;
    }
    
    public Aluno consultarPorId(int id){
        Aluno aluno = alunoDao.get(id);
        if (aluno != null){
            List<AlunoTelefone> alunoTelefoneList = alunoTelefoneDao.getAllByAluno(aluno.getId());
            aluno.setTelefones(alunoTelefoneList);
        }
        return aluno;
    }
    
    public void alterar(Aluno aluno){
        alunoDao.update(aluno);
    }
    
    public void excluir(int id){
        alunoDao.delete(id);
    }
    
}
