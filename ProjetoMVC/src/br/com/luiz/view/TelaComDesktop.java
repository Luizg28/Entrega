/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.luiz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TelaComDesktop extends JFrame {

	private JFrame frame;
	private Image img;
	private JDesktopPane jDesktopPrincipal;

	public static void main(String[] args) {
		new TelaComDesktop("Tela Com Desktop");
	}

	public TelaComDesktop(String titulo) {
		super(titulo);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH); // Abre o desktop maximizado

		jDesktopPrincipal = new JDesktopPane() {

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage bi;

				if (img != null) {

					Dimension dimension = this.getSize();
					int dWidth = (int) dimension.getWidth();
					int dHeight = (int) dimension.getHeight();

					bi = new BufferedImage(dWidth / 2, dHeight / 2, BufferedImage.TYPE_INT_RGB);

					Graphics2D g2 = bi.createGraphics();
					g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.drawImage(img, 0, 0, dWidth / 2, dHeight / 2, null);
					g2.dispose();
					g.drawImage(bi, 100, 150, null);

				}
			}
		};

		jDesktopPrincipal.setBackground(new Color(0, 255, 100));
		this.add(jDesktopPrincipal);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mCadastros = new JMenu("Cadastros");
		menuBar.add(mCadastros);
		JMenu mConsultas = new JMenu("Consultas");
		menuBar.add(mConsultas);
		JMenu mRemover = new JMenu("Remover");
		menuBar.add(mRemover);

		JMenuItem miCadastroFuncionario = new JMenuItem("Funcionarios");
		miCadastroFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mCadastros.add(miCadastroFuncionario);

		miCadastroFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroFuncionario telaFuncionario = new TelaCadastroFuncionario("Cadastro de Funcion�rios");
				telaFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaFuncionario);

			}

		});

		JMenuItem miArmazem = new JMenuItem("Armazem");
		miArmazem.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mCadastros.add(miArmazem);

		miArmazem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroArmazem telaArmazem = new TelaCadastroArmazem("Cadastro de Armaz�ns");
				telaArmazem.setClosable(true);// true - habilita o X (fechar)
				telaArmazem.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaArmazem.setVisible(true);

				jDesktopPrincipal.add(telaArmazem);
			}
		});
                
                JMenuItem miCliente = new JMenuItem("Cliente");
		miCliente.setMnemonic(KeyEvent.VK_C); // cria tela de atalho
		mCadastros.add(miCliente);

		miCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente telaClientes= new TelaCadastroCliente("Cadastro de Clientes");
				telaClientes.setClosable(true);// true - habilita o X (fechar)
				telaClientes.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaClientes.setVisible(true);

				jDesktopPrincipal.add(telaClientes);
			}
		});
                
                JMenuItem miCadastroPeca = new JMenuItem("Peças");
		miCadastroPeca.setMnemonic(KeyEvent.VK_P); // cria tela de atalho
		mCadastros.add(miCadastroPeca);

		miCadastroPeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroPeca telaPeca = new TelaCadastroPeca("Cadastro de Peças");
				telaPeca.setClosable(true);// true - habilita o X (fechar)
				telaPeca.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaPeca.setVisible(true);

				jDesktopPrincipal.add(telaPeca);

			}

		});
                
                JMenuItem miCadastroItemPedido = new JMenuItem("Item Pedido");
		miCadastroItemPedido.setMnemonic(KeyEvent.VK_I); // cria tela de atalho
		mCadastros.add(miCadastroItemPedido);

		miCadastroItemPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroItemPedido telaPedido = new TelaCadastroItemPedido("Cadastro de Itens Pedidos");
				telaPedido.setClosable(true);// true - habilita o X (fechar)
				telaPedido.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaPedido.setVisible(true);

				jDesktopPrincipal.add(telaPedido);

			}

		});

		JMenuItem miSair = new JMenuItem("Sair");
		miSair.setMnemonic(KeyEvent.VK_S); // cria tela de atalho
		mCadastros.add(miSair);

		miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
                

		JMenuItem miConsultaFuncionario = new JMenuItem("Funcionário");
		miConsultaFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mConsultas.add(miConsultaFuncionario);

		miConsultaFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario telaConsultaFuncionario = new TelaConsultaFuncionario("Consultar Funcion�rio");

				telaConsultaFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaConsultaFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaConsultaFuncionario);

			}
		});
                
                JMenuItem miConsultaArmazem = new JMenuItem("Armazem");
		miConsultaArmazem.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mConsultas.add(miConsultaArmazem);

		miConsultaArmazem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                TelaConsultaArmazem telaConsultaArmazem = new TelaConsultaArmazem("Consulta Armazem");

				telaConsultaArmazem.setClosable(true);// true - habilita o X (fechar)
				telaConsultaArmazem.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaArmazem.setVisible(true);

				jDesktopPrincipal.add(telaConsultaArmazem);
			}
		});

		JMenuItem miConsultaCliente = new JMenuItem("Cliente");
		miConsultaCliente.setMnemonic(KeyEvent.VK_C); // cria tela de atalho
		mConsultas.add(miConsultaCliente);

		miConsultaCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                TelaConsultaCliente telaConsultaCliente = new TelaConsultaCliente("Consultar Cliente");

				telaConsultaCliente.setClosable(true);// true - habilita o X (fechar)
				telaConsultaCliente.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaCliente.setVisible(true);

				jDesktopPrincipal.add(telaConsultaCliente);
			}
		});
                
                JMenuItem miConsultaPeca = new JMenuItem("Peças");
		miConsultaPeca.setMnemonic(KeyEvent.VK_P); // cria tela de atalho
		mConsultas.add(miConsultaPeca);

		miConsultaPeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaConsultaPeca telaConsultaPeca = new TelaConsultaPeca("Consultar Peças");
				telaConsultaPeca.setClosable(true);// true - habilita o X (fechar)
				telaConsultaPeca.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaPeca.setVisible(true);

				jDesktopPrincipal.add(telaConsultaPeca);

			}

		});
                
                JMenuItem miConsultaItemPedido = new JMenuItem("Item Pedido");
		miConsultaItemPedido.setMnemonic(KeyEvent.VK_I); // cria tela de atalho
		mConsultas.add(miConsultaItemPedido);

		miConsultaItemPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaConsultaItemPedido telaConsultaPedido = new TelaConsultaItemPedido("Consulta de Itens Pedidos");
				telaConsultaPedido.setClosable(true);// true - habilita o X (fechar)
				telaConsultaPedido.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaPedido.setVisible(true);

				jDesktopPrincipal.add(telaConsultaPedido);

			}

		});

		JMenuItem miRemoveFuncionario = new JMenuItem("Funcionário");
		miRemoveFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mRemover.add(miRemoveFuncionario);

		miRemoveFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaRemoveFuncionario telaRemoveFuncionario = new TelaRemoveFuncionario("Consultar Funcionario");

				telaRemoveFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaRemoveFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemoveFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaRemoveFuncionario);

			}
		});
                
                JMenuItem miRemoveArmazem = new JMenuItem("Armazem");
		miRemoveArmazem.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mRemover.add(miRemoveArmazem);

		miRemoveArmazem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                TelaRemoveArmazem telaRemoveArmazem = new TelaRemoveArmazem("Remover Armazem");

				telaRemoveArmazem.setClosable(true);// true - habilita o X (fechar)
				telaRemoveArmazem.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemoveArmazem.setVisible(true);

				jDesktopPrincipal.add(telaRemoveArmazem);
			}
		});
                
                JMenuItem miRemoveCliente = new JMenuItem("Cliente");
		miRemoveCliente.setMnemonic(KeyEvent.VK_C); // cria tela de atalho
		mRemover.add(miRemoveCliente);

		miRemoveCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                TelaRemoveCliente telaRemoveCliente = new TelaRemoveCliente("Remover Cliente");

				telaRemoveCliente.setClosable(true);// true - habilita o X (fechar)
				telaRemoveCliente.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemoveCliente.setVisible(true);

				jDesktopPrincipal.add(telaRemoveCliente);
			}
		});
                
                JMenuItem miRemoverPeca = new JMenuItem("Peças");
		miRemoverPeca.setMnemonic(KeyEvent.VK_P); // cria tela de atalho
		mRemover.add(miRemoverPeca);

		miRemoverPeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaRemovePeca telaRemovePeca = new TelaRemovePeca("Remover Peças");
				telaRemovePeca.setClosable(true);// true - habilita o X (fechar)
				telaRemovePeca.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemovePeca.setVisible(true);

				jDesktopPrincipal.add(telaRemovePeca);

			}

		});
                
                JMenuItem miRemoverItemPedido = new JMenuItem("Item Pedido");
		miRemoverItemPedido.setMnemonic(KeyEvent.VK_I); // cria tela de atalho
		mRemover.add(miRemoverItemPedido);

		miRemoverItemPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaRemoveItemPedido telaRemovePedido = new TelaRemoveItemPedido("Cadastro de Itens Pedidos");
				telaRemovePedido.setClosable(true);// true - habilita o X (fechar)
				telaRemovePedido.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemovePedido.setVisible(true);

				jDesktopPrincipal.add(telaRemovePedido);

			}

		});

		setVisible(true);
	}
}