/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.service;

import br.cefet.academico.dao.AlunoTelefoneDao;
import br.cefet.academico.model.AlunoTelefone;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

/**
 *
 * @author dougl
 */
@Service
public class AlunoTelefoneService {
    
    private final AlunoTelefoneDao alunoTelefonDao;
    
    public AlunoTelefoneService(Jdbi jdbi){
        this.alunoTelefonDao = jdbi.onDemand(AlunoTelefoneDao.class);
    }
    
    public AlunoTelefone inserir (AlunoTelefone alunoTelefone){
        int idAluno = alunoTelefonDao.insert(alunoTelefone);
        alunoTelefone.setId(idAluno);
        return alunoTelefone;
    }
    
    public List<AlunoTelefone> consultarTodos(){
        return alunoTelefonDao.getAll();
    }
    
    public AlunoTelefone consultarPorId(int id){
        return alunoTelefonDao.get(id);
    }
    
    public List<AlunoTelefone> consultarPorIdAluno(int idAluno){
        return alunoTelefonDao.getAllByAluno(idAluno);
    }
    
    public void alterar(AlunoTelefone alunoTelefone){
        alunoTelefonDao.update(alunoTelefone);
    }
    
    public void excluir(int id){
        alunoTelefonDao.delete(id);
    }
    
}
