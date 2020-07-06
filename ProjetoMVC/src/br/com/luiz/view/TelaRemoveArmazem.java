/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.com.luiz.model.Armazem;

public class TelaRemoveArmazem extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tcNomeArmazem; 
	private JTextField tcId;

	public TelaRemoveArmazem(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);

		JLabel lNomeArmazem = new JLabel("Nome do Armazém");

		tcNomeArmazem = new JTextField();
		tcNomeArmazem.setColumns(10);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");
				EntityManager manager = factory.createEntityManager();

				Armazem funcionario = manager.find(Armazem.class, Integer.parseInt(tcId.getText()));

				manager.getTransaction().begin();
				manager.remove(funcionario);
				manager.getTransaction().commit();

				manager.close();

				JOptionPane.showMessageDialog(null, "Armazem removido");
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tcId.setText("");
				tcNomeArmazem.setText("");


				System.out.println("Campos limpos.");
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Fechou a tela de remoção de armazem");
				dispose();
			}
		});

		JLabel lblId = new JLabel("Id");

		tcId = new JTextField();
		tcId.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnRemover).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lNomeArmazem).addComponent(lblId))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tcNomeArmazem, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                                .addComponent(tcId, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
						.addGap(75)));
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tcId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tcNomeArmazem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lNomeArmazem))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnRemover)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lNomeArmazem, tcNomeArmazem });
		getContentPane().setLayout(groupLayout);

	}
}
