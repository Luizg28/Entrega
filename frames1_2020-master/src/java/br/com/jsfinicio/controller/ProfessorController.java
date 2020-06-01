/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luiz Lopes
 */
@ManagedBean
public class ProfessorController {
    
    private ProfessorModel professorModel;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;
    
    public ProfessorController(){
        this.professorModel = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores =  new ArrayList<>();
    }
    
    public void salvar(){
        this.professorRepository.salvar(this.professorModel);
    }

    public void buscar(){
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }
    
    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeAlunos(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }
    
}
