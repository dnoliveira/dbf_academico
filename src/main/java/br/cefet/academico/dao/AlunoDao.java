/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.dao;

import br.cefet.academico.model.Aluno;
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
@RegisterBeanMapper(Aluno.class)
public interface AlunoDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into aluno (nome, idade) values (:nome, :idade)")
    int insert(@BindBean Aluno aluno);
    
    
    @SqlQuery("select * " +
            " from aluno " +
            " where id = :id;")
    Aluno get(@Bind("id") int id);

    
    @SqlQuery("select * " +
            " from aluno " +
            " order by nome;")
    List<Aluno> getAll();

    
    @SqlQuery("select * " +
            " from aluno " +
            " where nome like :nome " +
            " order by nome;")
    List<Aluno> getAllByName(@Bind("nome") String nome);


    @SqlUpdate("update aluno " +
            " set nome = :nome, " +
            "     idade = :idade " +
            " where id = :id;")
    int update(@BindBean Aluno aluno);

    
    @SqlUpdate("delete " +
            " from aluno " +
            " where id = :id;")
    int delete(@Bind("id") int id);

}
