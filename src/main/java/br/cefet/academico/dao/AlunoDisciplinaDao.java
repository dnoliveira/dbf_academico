/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.dao;

import br.cefet.academico.model.AlunoDisciplina;
import br.cefet.academico.model.Disciplina;
import br.cefet.academico.model.DisciplinaAluno;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Disciplina.class)
public interface AlunoDisciplinaDao {
            
    @SqlUpdate("insert into aluno_disciplina (idAluno, idDisciplina) values (:idAluno, :id)")
    void insert(@BindBean AlunoDisciplina alunoDisciplina);
    
    
    @SqlQuery("select * " +
            " from disciplina d, aluno_disciplina ad " +
            " where ad.idDisciplina = d.id " +
            "   and ad.idAluno = :idAluno " +
            "   and ad.idDisciplina = :idDisciplina;")
    Disciplina get(@Bind("idAluno") int idAluno, @Bind("idDisciplina") int idDisciplina);

    @SqlQuery("select * " +
            " from disciplina a, aluno_disciplina ad " +
            " where ad.idDisciplina = d.id " +
            "   and ad.idAluno = :idAluno;")
    List<Disciplina> getAllByAluno(@Bind("idAluno") int idAluno);
    
    @SqlUpdate("delete " +
            " from aluno_disciplina " +
            " where ad.idAluno = :idAluno " +
            "   and ad.idDisciplina = :idDisciplina;")
    int delete(@Bind("idAluno") int idAluno, @Bind("idDisciplina") int idDisciplina);
    
    @SqlUpdate("delete " +
            " from aluno_disciplina " +
            " where ad.idAluno = :idAluno;")
    int deleteAllByAluno(@Bind("idAluno") int idAluno);
}
