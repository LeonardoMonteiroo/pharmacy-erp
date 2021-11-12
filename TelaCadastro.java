package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesdenegocio.Produto;
import dados.ProdutoDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.SQLException;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoNome = new JTextField();
		campoNome.setBounds(26, 54, 226, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(26, 117, 226, 20);
		contentPane.add(campoPreco);
		campoPreco.setColumns(10);
		
		campoMarca = new JTextField();
		campoMarca.setBounds(26, 180, 226, 20);
		contentPane.add(campoMarca);
		campoMarca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(26, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblNewLabel_1.setBounds(25, 97, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setBounds(25, 161, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				p.setNome(campoNome.getText());
				p.setPrecoUnitario(Float.parseFloat(campoPreco.getText()));
				p.setMarca(campoMarca.getText());
				//Criar um objeto da classe DAO
				ProdutoDAO pDAO = new ProdutoDAO();
				try {
					pDAO.salvar(p);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			private ProdutoDAO ProdutoDAO() {
				// TODO Auto-generated method stub
				return null;
			} 
		});
		btnNewButton.setBounds(26, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(163, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
