/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import br.com.luiz.model.ItemPedido;

public class ItemPedidoController {
	
	private ItemPedido itemPedido;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ItemPedidoController(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	public String EntidadeGerenciadora() {
		try {
			emf = Persistence.createEntityManagerFactory("empresa");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(itemPedido);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return "Item do pedido cadastrado!";
		}catch(ServiceException se) {
			return "Item do pedido n�o foi cadastrado. \n ERRO:" + se.getMessage();
		}
	}
}
