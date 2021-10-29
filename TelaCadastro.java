import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCodigo;
	private JTextField campoPreco;

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
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(26, 117, 226, 20);
		contentPane.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(26, 180, 226, 20);
		contentPane.add(campoPreco);
		campoPreco.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(26, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(25, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o UN");
		lblNewLabel_2.setBounds(25, 161, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto prod1 = new Produto();
				
				prod1.setCodigo(Integer.parseInt(campoCodigo.getText()));
				prod1.setNome(campoNome.getText());
				prod1.setPrecoUnitario(Float.parseFloat(campoPreco.getText()));
				
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
				dispose();
				
				//adicionr saida automatica apos cadastro
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
