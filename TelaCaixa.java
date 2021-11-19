package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesdenegocio.Caixa;
import classesdenegocio.Cosmeticos;
import classesdenegocio.Medicamento;
import classesdenegocio.Produto;
import dados.CaixaDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTextField txCaixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaixa frame = new TelaCaixa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCaixa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 238, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txCaixa = new JTextField();
		txCaixa.setBounds(106, 11, 106, 20);
		contentPane.add(txCaixa);
		txCaixa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero do Caixa");
		lblNewLabel.setBounds(10, 14, 86, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Criar Caixa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
					
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
				try {
					cDAO.salvar(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 68, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExluirCaixa = new JButton("Exluir Caixa");
		btnExluirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
					
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
		
				try {
					cDAO.deletarCaixa(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExluirCaixa.setBounds(106, 68, 106, 23);
		contentPane.add(btnExluirCaixa);
		
		JButton btnAbirCaixa = new JButton("Abrir Caixa");
		btnAbirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setAberto(true);//define o caixa como aberto
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
					
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
		
				try {
					cDAO.statusCaixa(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAbirCaixa.setBounds(10, 34, 89, 23);
		contentPane.add(btnAbirCaixa);
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setAberto(false);//define o caixa como fechado
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
					
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
		
				try {
					cDAO.statusCaixa(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFecharCaixa.setBounds(106, 34, 106, 23);
		contentPane.add(btnFecharCaixa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(106, 103, 106, 23);
		contentPane.add(btnVoltar);
	}
}
