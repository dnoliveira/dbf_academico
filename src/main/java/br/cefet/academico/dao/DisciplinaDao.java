/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.dao;

import br.cefet.academico.model.Disciplina;
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
@RegisterBeanMapper(Disciplina.class)
public interface DisciplinaDao {
    
    @GetGeneratedKeys
    @SqlUpdate("insert into disciplina (descricao) values (:descricao)")
    int insert(@BindBean Disciplina disciplina);
    
    
    @SqlQuery("select * " +
            " from disciplina " +
            " where id = :id;")
    Disciplina get(@Bind("id") int id);

    
    @SqlQuery("select * " +
            " from disciplina " +
            " order by descricao;")
    List<Disciplina> getAll();

    
    @SqlQuery("select * " +
            " from disciplina " +
            " where nome like :descricao " +
            " order by descricao;")
    List<Disciplina> getAllByName(@Bind("descricao") String descricao);


    @SqlUpdate("update disciplina " +
            " set nome = :descricao " +
            " where id = :id;")
    int update(@BindBean Disciplina disciplina);

    
    @SqlUpdate("delete " +
            " from disciplina " +
            " where id = :id;")
    int delete(@Bind("id") int id);

}
