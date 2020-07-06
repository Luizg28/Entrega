/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.view;

import br.com.luiz.controller.ClienteController;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.hibernate.service.spi.ServiceException;

import br.com.luiz.model.Cliente;

import java.awt.Component;

public class TelaCadastroCliente extends JInternalFrame {

	private JTextField tcNome;
        
	public TelaCadastroCliente(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();

				try {
					cliente.setNome(tcNome.getText());

					ClienteController clienteController = new ClienteController(cliente);
					String msg = clienteController.EntidadeGerenciadora();

					JOptionPane.showMessageDialog(null, msg);
				} catch (NumberFormatException ex) { // handle your exception
					JOptionPane.showMessageDialog(null,
							"Os campos matr�cula e idade devem ser do tipo n�meros. \n Erro:" + ex.getMessage());
				}
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tcNome.setText("");

				System.out.println("Campos limpos.");
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int simNao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if (simNao == 0) {
					dispose();
				}
			}
		});
                
                JLabel lNome = new JLabel("Nome do cliente");
                tcNome = new JTextField();
                tcNome.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnCadastrar).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tcNome, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addGap(75))));
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tcNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lNome, tcNome });
		getContentPane().setLayout(groupLayout);


	}

}