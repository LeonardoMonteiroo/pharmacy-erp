package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesdenegocio.Produto;
import classesdenegocio.Medicamento;
import classesdenegocio.Cosmeticos;
import dados.ProdutoDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.SQLException;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField marca;
	private JTextField tipo;
	private JTextField especificacao;
	/**
	 * @wbp.nonvisual location=-8,-31
	 */
	private final JRadioButton radioButton = new JRadioButton("New radio button");
	private JTextField concentracao;
	private JTextField qntdProd;

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
		setBounds(100, 100, 594, 351);
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
		
		marca = new JTextField();
		marca.setBounds(26, 180, 226, 20);
		contentPane.add(marca);
		marca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(26, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblNewLabel_1.setBounds(25, 97, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setBounds(25, 161, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(90, 262, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tipo = new JTextField();
		tipo.setEnabled(false);
		tipo.setBounds(335, 54, 86, 20);
		contentPane.add(tipo);
		tipo.setColumns(10);
		
		qntdProd = new JTextField();
		qntdProd.setBounds(335, 180, 86, 20);
		contentPane.add(qntdProd);
		qntdProd.setColumns(10);
		
		especificacao = new JTextField();
		especificacao.setEnabled(false);
		especificacao.setBounds(335, 117, 86, 20);
		contentPane.add(especificacao);
		especificacao.setColumns(10);
		
		JRadioButton botaoUN = new JRadioButton("UN");
		botaoUN.setEnabled(false);
		botaoUN.setBounds(446, 53, 46, 23);
		contentPane.add(botaoUN);
		
		JRadioButton botaoG = new JRadioButton("g");
		botaoG.setEnabled(false);
		botaoG.setBounds(494, 53, 39, 23);
		contentPane.add(botaoG);
		
		JRadioButton botaoL = new JRadioButton("L");
		botaoL.setEnabled(false);
		botaoL.setBounds(533, 53, 39, 23);
		contentPane.add(botaoL);
		
		JLabel lblNewLabel_3 = new JLabel("Unidade de medida");
		lblNewLabel_3.setBounds(451, 32, 121, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setBounds(335, 32, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Especifica\u00E7\u00E3o");
		lblNewLabel_4_1.setBounds(335, 97, 97, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Qntd do produto");
		lblNewLabel_5.setBounds(335, 161, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Concetra\u00E7\u00E3o");
		lblNewLabel_6.setBounds(451, 161, 78, 14);
		contentPane.add(lblNewLabel_6);
		
		concentracao = new JTextField();
		concentracao.setEnabled(false);
		concentracao.setBounds(446, 180, 86, 20);
		contentPane.add(concentracao);
		concentracao.setColumns(10);
		
		JRadioButton botaoCos = new JRadioButton("Cosm\u00E9tico");
		
		JRadioButton botaoMed = new JRadioButton("Medicamento"); //o que acontece qnd o botao medicament é true
		botaoMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botaoMed.isSelected() == true) {
					botaoCos.setSelected(false);
					botaoUN.setEnabled(false);
					botaoG.setEnabled(false);
					botaoL.setEnabled(false);
					especificacao.setEnabled(false);
					especificacao.setText(null);
					botaoUN.setSelected(false);
					botaoG.setSelected(false);
					botaoL.setSelected(false);

					//qntd de produto e concentraaco true
					qntdProd.setEnabled(true);
					tipo.setEnabled(true);
					concentracao.setEnabled(true);
				}
			}
		});
		botaoMed.setBounds(31, 222, 109, 23);
		contentPane.add(botaoMed);
		
		botaoCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botaoCos.isSelected() == true) {
					botaoMed.setSelected(false);
					qntdProd.setEnabled(false);
					concentracao.setEnabled(false); 
					qntdProd.setText(null); //apagar se digitado antes e a opcao for trocada
					concentracao.setText(null);			
					
					//especificação e un de medida false
					botaoUN.setEnabled(true);
					botaoG.setEnabled(true);
					botaoL.setEnabled(true);
					especificacao.setEnabled(true);
					tipo.setEnabled(true);
				}
			}
		});
		botaoCos.setBounds(154, 222, 109, 23);
		contentPane.add(botaoCos);
		
		
		JButton confirmarBotao = new JButton("Confirmar");
		confirmarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				Medicamento m = new Medicamento();
				Cosmeticos c = new Cosmeticos();
				p.setNome(campoNome.getText());
				p.setPrecoUnitario(Float.parseFloat(campoPreco.getText()));
				p.setMarca(marca.getText());
				m.setTipo(tipo.getText());
				if ((concentracao.getText()).length() == 0) {
					m.setConcentracao(0);  //se o valor for null ele deve retornar 0 para n dar erro (int n pode ser == null)
				}else {
					m.setConcentracao(Float.parseFloat(concentracao.getText()));
				}
				c.setTipo(tipo.getText());
				c.setEspecificacao(especificacao.getText());
				
				if((qntdProd.getText()).length() != 0) {
					m.setQtdProduto(Integer.parseInt(qntdProd.getText()));
				}else {
					m.setQtdProduto(Integer.parseInt("0"));  //se o valor for null ele deve retornar 0 para n dar erro (int n pode ser == null)
				}
				

				//c.setUnidMedidaProd();
				if(botaoUN.isSelected()) {
					c.setUnidMedidaProd("Unidade");
				}else if(botaoG.isSelected()) {
					c.setUnidMedidaProd("Grama");
				}else if(botaoL.isSelected()) {
					c.setUnidMedidaProd("Litro");
				} //define de acordo com a opção
				
				//Criar um objeto da classe DAO
				ProdutoDAO pDAO = new ProdutoDAO();
				try {
					pDAO.salvar(p, c, m);
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
		confirmarBotao.setBounds(383, 262, 109, 23);
		contentPane.add(confirmarBotao);
		

} }
