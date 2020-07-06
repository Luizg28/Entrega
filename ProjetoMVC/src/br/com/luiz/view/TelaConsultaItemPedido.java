/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.view;

import br.com.luiz.model.ItemPedido;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.GroupLayout;
import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class TelaConsultaItemPedido extends JInternalFrame {
    
        private JTextField tfDescricaoItemPedido; 

	public TelaConsultaItemPedido(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");
				EntityManager manager = factory.createEntityManager();

				Query query = manager.createQuery("select f from ItemPedido as f " + "where f.descricaoItemPedido = :parametro1");
				query.setParameter("parametro1", tfDescricaoItemPedido.getText());

				List<ItemPedido> lista = query.getResultList();

				for (ItemPedido itemPedido : lista) {
					JOptionPane.showMessageDialog(null, "Nome do Item Pedido: " 
                                            + itemPedido.getDescricaoItemPedido());
				}
                                
				manager.close();

			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				tfDescricaoItemPedido.setText("");

				System.out.println("Campos limpos.");
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				int simNao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if (simNao == 0) {
					dispose();
				}
			}
		});
                
                JLabel lNome = new JLabel("Nome do item pedido");
                tfDescricaoItemPedido = new JTextField();
                tfDescricaoItemPedido.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnPesquisar).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lNome))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(tfDescricaoItemPedido, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addGap(75))));
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfDescricaoItemPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lNome))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lNome, tfDescricaoItemPedido });
		getContentPane().setLayout(groupLayout);

	}

}