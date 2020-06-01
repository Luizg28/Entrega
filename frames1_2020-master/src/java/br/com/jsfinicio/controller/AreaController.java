/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.repository.AreaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luiz Lopes
 */
@ManagedBean
public class AreaController {
    
    private AreaModel areaModel;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeArea;
    
    public AreaController(){
        this.areaModel = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.listaDeArea =  new ArrayList<>();
    }
    
    public void salvar(){
        this.areaRepository.salvar(this.areaModel);
    }

    public void buscar(){
        this.listaDeArea = this.areaRepository.buscarTodos();
    }
    
    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaModel> getListaDeArea() {
        return listaDeArea;
    }

    public void setListaDeArea(List<AreaModel> listaDeArea) {
        this.listaDeArea = listaDeArea;
    }
    
}
