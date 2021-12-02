package tela;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classesdenegocio.Pedido;
import classesdenegocio.Produto;
import dados.ProdutoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaEntrada extends JFrame {

	private JPanel contentPane;
	private JTextField txCod;
	private JTextField txQuantidade;

	/**
	 * Launch the application.
	 */
	
	String colunas[] = {"Nome", "Código", "Quantidade"};
	private DefaultTableModel obj1 = new DefaultTableModel(colunas, 0);

	int check = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEntrada frame = new TelaEntrada();
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
	public TelaEntrada() {
		setTitle("Entrada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo");
		lblNewLabel_2.setBounds(10, 49, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		txCod = new JTextField();
		txCod.setBounds(10, 62, 75, 20);
		contentPane.add(txCod);
		txCod.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantidade");
		lblNewLabel_3_1.setBounds(106, 48, 75, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txQuantidade = new JTextField();
		txQuantidade.setColumns(10);
		txQuantidade.setBounds(106, 62, 75, 20);
		contentPane.add(txQuantidade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 15, 99, 23);
		contentPane.add(btnVoltar);
		
		JButton btnDarEntrada = new JButton("Dar entrada");
		btnDarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto();
				p.setCodigo(Integer.parseInt(txCod.getText()));
				p.setEstoque(Integer.parseInt(txQuantidade.getText()));
				
				ProdutoDAO pDAO = new ProdutoDAO();
				try {
					pDAO.alterarEstoque(p);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnDarEntrada.setBounds(202, 61, 122, 23);
		contentPane.add(btnDarEntrada);
	}
}
