/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.repository.AlunoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Frank
 */
@ManagedBean
public class AlunoController {
    
    private AlunoModel alunoModel;
    private AlunoRepository alunoRepository;
    private List<AlunoModel> listaDeAlunos;
    
    public AlunoController(){
        this.alunoModel = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeAlunos =  new ArrayList<>();
    }
    
    public void salvar(){
        this.alunoRepository.salvar(this.alunoModel);
    }

    public void buscar(){
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }
    
    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
    
}
