
package br.com.luiz.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import br.com.luiz.model.Cliente;

public class ClienteController {

	private Cliente cliente;
	private EntityManagerFactory emf;
	private EntityManager em;

	public ClienteController(Cliente cliente) {
		this.cliente = cliente;
	}

	public String EntidadeGerenciadora() {

		try {
			emf = Persistence.createEntityManagerFactory("empresa");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();

			em.close();
			emf.close();
			return "Usu�rio Cadastrado";

		} catch (ServiceException se) {
			return "Usu�rio n�o foi cadastrado. \n ERRO: " + se.getMessage();
		}
	}
}
