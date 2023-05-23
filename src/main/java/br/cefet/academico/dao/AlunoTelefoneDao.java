/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.dao;

import br.cefet.academico.model.AlunoTelefone;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author dougl
 */
@RegisterBeanMapper(AlunoTelefone.class)
public interface AlunoTelefoneDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into aluno_telefone (idAluno, telefone) values (:idAluno, :telefone)")
    int insert(@BindBean AlunoTelefone alunoTelefone);
    
    
    @SqlQuery("select * " +
            " from aluno_telefone " +
            " where id = :id;")
    AlunoTelefone get(@Bind("id") int id);

    
    @SqlQuery("select * " +
            " from aluno_telefone;")
    List<AlunoTelefone> getAll();

    
    @SqlQuery("select * " +
            " from aluno_telefone " +
            " where idAluno = :idAluno;")
    List<AlunoTelefone> getAllByAluno(@Bind("idAluno") int idAluno);


    @SqlUpdate("update aluno_telefone " +
            " set telefone = :telefone " +
            " where id = :id;")
    int update(@BindBean AlunoTelefone alunoTelefone);

    
    @SqlUpdate("delete " +
            " from aluno_telefone " +
            " where id = :id;")
    int delete(@Bind("id") int id);
}
