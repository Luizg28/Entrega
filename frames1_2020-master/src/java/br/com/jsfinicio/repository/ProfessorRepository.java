/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Lopes
 */
public class ProfessorRepository extends Conexao{
    public void salvar(ProfessorModel professorModel){
        super.inicializa();
        super.getSess().save(professorModel);
        super.executar();
    }
    
    public List<ProfessorModel> buscarTodos(){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel").list();
        super.executar();
        return listaDeProfessores;
    }
}
