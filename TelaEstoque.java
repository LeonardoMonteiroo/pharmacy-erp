package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classesdenegocio.Cosmeticos;
import classesdenegocio.Medicamento;
import classesdenegocio.Produto;
import dados.ProdutoDAO;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigoDigitado;
	private JTextField textField_1;
	public ArrayList<Integer> pesquisar = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
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
	public TelaEstoque() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		campoCodigoDigitado = new JTextField();
		//campoCodigoDigitado.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//		pesquisar.add(Integer.parseInt(campoCodigoDigitado.getText()));
		//	}
		//});
		campoCodigoDigitado.setBounds(53, 22, 46, 20);
		contentPane.add(campoCodigoDigitado);
		campoCodigoDigitado.setColumns(10);
		
		JLabel lblNom = new JLabel("Nome:");
		lblNom.setBounds(122, 25, 46, 14);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 22, 46, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produtos = new Produto();
				produtos.setSearchCod(Integer.parseInt(campoCodigoDigitado.getText()));
				TelaProdutos telaProdutos = new TelaProdutos(produtos);
				telaProdutos.setVisible(true);
				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NAO FUNCIONA
			}
		});
		btnNewButton.setBounds(233, 21, 131, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(134, 113, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cadastrar produto");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(10, 76, 172, 23);
		contentPane.add(btnNewButton_1_1);
		//abrir TelaCadastro
		
		JButton btnNewButton_1_1_1 = new JButton("Entrada");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEntrada telaEntrada = new TelaEntrada();
				telaEntrada.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(203, 76, 172, 23);
		contentPane.add(btnNewButton_1_1_1);
		

	}
}
