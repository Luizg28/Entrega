
package br.com.luiz.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import br.com.luiz.model.Armazem;

public class ArmazemController {

	private Armazem armazem;
	private EntityManagerFactory emf;
	private EntityManager em;

	public ArmazemController(Armazem armazem) {
		this.armazem = armazem;
	}

	public String EntidadeGerenciadora() {

		try {
			emf = Persistence.createEntityManagerFactory("empresa");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(armazem);
			em.getTransaction().commit();

			em.close();
			emf.close();
			return "Armazem Cadastrado";

		} catch (ServiceException se) {
			return "Armazem não foi cadastrado. \n ERRO: " + se.getMessage();
		}
	}
}
