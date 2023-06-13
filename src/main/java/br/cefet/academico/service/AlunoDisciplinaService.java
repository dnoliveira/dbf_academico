/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.service;

import br.cefet.academico.dao.AlunoDisciplinaDao;
import br.cefet.academico.model.Disciplina;
import br.cefet.academico.model.AlunoDisciplina;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class AlunoDisciplinaService {
    private final AlunoDisciplinaDao alunoDisciplinaDao;
    
    public AlunoDisciplinaService(Jdbi jdbi){
        this.alunoDisciplinaDao = jdbi.onDemand(AlunoDisciplinaDao.class);
    }
    
    public AlunoDisciplina inserir (AlunoDisciplina alunoDisciplina){
        alunoDisciplinaDao.insert(alunoDisciplina);
        return alunoDisciplina;
    }
    
    public List<Disciplina> getByAluno(int idAluno){
        List<Disciplina> disciplinaList = alunoDisciplinaDao.getAllByAluno(idAluno);
        return disciplinaList;
    }
    
    public Disciplina get(int idAluno, int idDisciplina){
        Disciplina disciplina = alunoDisciplinaDao.get(idAluno, idDisciplina);
        return disciplina;
    }
    
    public void delete(int idAluno, int idDisciplina){
        alunoDisciplinaDao.delete(idAluno, idDisciplina);
    }
    
    public void deleteAllByAluno(int idAluno){
        alunoDisciplinaDao.deleteAllByAluno(idAluno);
    }
}
