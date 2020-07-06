/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.view;


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

import br.com.luiz.controller.FuncionarioController;
import br.com.luiz.model.Funcionario;

import java.awt.Component;

public class TelaCadastroFuncionario extends JInternalFrame {
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfIdade;
	private JTextField tfEndereco;
	private JTextField tfMatricula;

	public TelaCadastroFuncionario(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);

		JLabel lNome = new JLabel("Nome");

		tfNome = new JTextField();
		tfNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");

		JLabel lblIdade = new JLabel("Idade");

		JLabel lblEndereo = new JLabel("Endere\u00E7o");

		tfSobrenome = new JTextField();
		tfSobrenome.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setText("");
		tfIdade.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();

				try {
					funcionario.setNome(tfNome.getText());
					funcionario.setSobrenome(tfSobrenome.getText());
					funcionario.setEndereco(tfEndereco.getText());
					funcionario.setMatricula(Integer.parseInt(tfMatricula.getText()));
					funcionario.setIdade(Integer.parseInt(tfIdade.getText()));

					FuncionarioController funcionarioController = new FuncionarioController(funcionario);
					String msg = funcionarioController.EntidadeGerenciadora();

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
				tfMatricula.setText("");
				tfNome.setText("");
				tfSobrenome.setText("");
				tfEndereco.setText("");
				tfIdade.setText("");

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

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");

		tfMatricula = new JTextField();
		tfMatricula.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnCadastrar).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lblEndereo).addComponent(lblIdade)
								.addComponent(lblSobrenome).addComponent(lNome).addComponent(lblMatrcula))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfEndereco, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfIdade, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfSobrenome, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfMatricula, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
						.addGap(75)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMatrcula))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSobrenome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdade))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo))
						.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lNome, tfNome, lblSobrenome, lblIdade,
				lblEndereo, tfSobrenome, tfIdade, tfEndereco, lblMatrcula, tfMatricula });
		getContentPane().setLayout(groupLayout);

	}
}