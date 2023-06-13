/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.academico.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author dougl
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    protected int id;
    protected String nome;
    protected int idade;
    
    protected List<AlunoTelefone> telefones;
}
