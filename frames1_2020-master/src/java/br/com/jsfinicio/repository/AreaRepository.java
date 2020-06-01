/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Lopes
 */
public class AreaRepository extends Conexao{
    public void salvar(AreaModel areaModel){
        super.inicializa();
        super.getSess().save(areaModel);
        super.executar();
    }
    
    public List<AreaModel> buscarTodos(){
        List<AreaModel> listaDeArea = new ArrayList<>();
        super.inicializa();
        listaDeArea = super.getSess().createQuery("from AreaModel").list();
        super.executar();
        return listaDeArea;
    }
}
