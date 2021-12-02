package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesdenegocio.Produto;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 401, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		list.setBounds(10, 65, 365, 266);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		campoCodigoDigitado = new JTextField();
		//campoCodigoDigitado.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//		pesquisar.add(Integer.parseInt(campoCodigoDigitado.getText()));
		//	}
		//});
		campoCodigoDigitado.setBounds(53, 37, 86, 20);
		contentPane.add(campoCodigoDigitado);
		campoCodigoDigitado.setColumns(10);
		
		JLabel lblNom = new JLabel("Nome:");
		lblNom.setBounds(149, 40, 46, 14);
		contentPane.add(lblNom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 37, 86, 20);
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
		btnNewButton.setBounds(286, 36, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(286, 6, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cadastrar produto");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(10, 6, 121, 23);
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
		btnNewButton_1_1_1.setBounds(148, 6, 121, 23);
		contentPane.add(btnNewButton_1_1_1);
		//abrir TelaLote
	}
}
