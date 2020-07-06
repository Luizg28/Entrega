/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gera as tabelas, utomaticamente, no banco de dados antes de salvar os valores
 * 
 * @author Breno
 * @version 1.0
 * @since 15/05/2017
 */
public class GerarTabelas {

	/**
	 * M�todo principal
	 */
	public static void main(String[] args) {

		/*	A linha 

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");
			
			/*ir� acessar o arquivo persistence.xml para criar as tabelas Funcionario, Cliente e Peca
	
				Linhas do arquivo persistence.xml
				Observe que as 3 linhas abaixo ser�o as tabelas (Funcionario, Cliente e Peca) do banco de dados.
				
					<class>br.com.breno.aplicacao.modelo.Funcionario</class>
					<class>br.com.breno.aplicacao.modelo.Cliente</class>
					<class>br.com.breno.aplicacao.modelo.Peca</class>
		*/
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");

		factory.close();

	}
}