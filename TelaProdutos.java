package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesdenegocio.Produto;
import classesdenegocio.Medicamento;
import classesdenegocio.Cosmeticos;
import dados.ProdutoDAO;
import telas.TelaEstoque;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {


	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtPre;
	private JTextField txtEst;
	private JTextField txtUn;
	private JTextField txtQntdProd;
	private JTextField txtMarca;
	private JTextField txtNome;
	private JTextField txtEsp;
	private JTextField txtConc;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public TelaProdutos() {
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo ");
		lblNewLabel.setBounds(10, 11, 67, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 76, 67, 22);
		contentPane.add(lblNome);
		
		JLabel lblQuantiadeEmEstoque = new JLabel("Quantiade em estoque");
		lblQuantiadeEmEstoque.setBounds(145, 76, 115, 22);
		contentPane.add(lblQuantiadeEmEstoque);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setBounds(10, 148, 67, 22);
		contentPane.add(lblPreoUnitrio);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(144, 9, 67, 22);
		contentPane.add(lblMarca);
		
		JLabel lblEspecificao = new JLabel("Especifica\u00E7\u00E3o");
		lblEspecificao.setBounds(145, 148, 67, 22);
		contentPane.add(lblEspecificao);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de medida");
		lblUnidadeDeMedida.setBounds(311, 147, 115, 22);
		contentPane.add(lblUnidadeDeMedida);
		
		JLabel lblQntdDoProduto = new JLabel("Qntd do produto");
		lblQntdDoProduto.setBounds(307, 13, 102, 22);
		contentPane.add(lblQntdDoProduto);
		
		JLabel lblConcentrao = new JLabel("Concentra\u00E7\u00E3o");
		lblConcentrao.setBounds(307, 76, 67, 22);
		contentPane.add(lblConcentrao);
		
		txtCod = new JTextField();
		txtCod.setEnabled(true);
		txtCod.setText("0000");
		txtCod.setBounds(10, 28, 107, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setText("00000000.000");
		txtPre.setEnabled(false);
		txtPre.setColumns(10);
		txtPre.setBounds(10, 165, 107, 20);
		contentPane.add(txtPre);
		
		txtEst = new JTextField();
		txtEst.setText("00");
		txtEst.setEnabled(false);
		txtEst.setColumns(10);
		txtEst.setBounds(145, 98, 107, 20);
		contentPane.add(txtEst);
		
		txtUn = new JTextField();
		txtUn.setText("00000000.000");
		txtUn.setEnabled(false);
		txtUn.setColumns(10);
		txtUn.setBounds(311, 164, 107, 20);
		contentPane.add(txtUn);
		
		txtQntdProd = new JTextField();
		txtQntdProd.setText("00000000.000");
		txtQntdProd.setEnabled(false);
		txtQntdProd.setColumns(10);
		txtQntdProd.setBounds(307, 30, 107, 20);
		contentPane.add(txtQntdProd);
		
		txtMarca = new JTextField();
		txtMarca.setText("xxxxxx");
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(145, 28, 107, 20);
		contentPane.add(txtMarca);
		
		txtNome = new JTextField();
		txtNome.setText("xxxxxx");
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 93, 107, 20);
		contentPane.add(txtNome);
		
		txtEsp = new JTextField();
		txtEsp.setText("xxxxxx");
		txtEsp.setEnabled(false);
		txtEsp.setColumns(10);
		txtEsp.setBounds(145, 165, 107, 20);
		contentPane.add(txtEsp);
		
		txtConc = new JTextField();
		txtConc.setText("xxxxxx");
		txtConc.setEnabled(false);
		txtConc.setColumns(10);
		txtConc.setBounds(313, 95, 107, 20);
		contentPane.add(txtConc);
		
		txtTipo = new JTextField();
		txtTipo.setText("xxxxxx");
		txtTipo.setEnabled(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(10, 224, 107, 20);
		contentPane.add(txtTipo);
		
	
	JButton btAlterar = new JButton("Alterar");
	btAlterar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(btAlterar.getText() == "Confirmar") {
				Produto p = new Produto();
				Medicamento m = new Medicamento();
				Cosmeticos c = new Cosmeticos();
				
				p.setCodigo(Integer.parseInt(txtCod.getText()));
				p.setNome(txtNome.getText());
				p.setPrecoUnitario(Float.parseFloat(txtPre.getText()));
				p.setMarca(txtMarca.getText());
				p.setEstoque(Integer.parseInt(txtEst.getText()));
				m.setTipo(txtTipo.getText());
				if ((txtConc.getText()).length() == 0) {
					m.setConcentracao(0);
				}else {
					m.setConcentracao(Float.parseFloat(txtConc.getText()));
				}
				c.setTipo(txtTipo.getText());
				c.setEspecificacao(txtEsp.getText());
				c.setUnidMedidaProd(txtUn.getText());
				
				if((txtQntdProd.getText()).length() != 0) {
					m.setQtdProduto(Integer.parseInt(txtQntdProd.getText()));
				}else {
					m.setQtdProduto(Integer.parseInt("0"));
				}
				
				//Criar um objeto da classe DAO
				ProdutoDAO pDAO = new ProdutoDAO();
				try {
					pDAO.alterar(p, c, m);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}else if(Integer.parseInt(txtCod.getText()) > 0 && btAlterar.getText() == "Alterar") {
			btAlterar.setText("Confirmar");
			//preparar para dados
			txtNome.setEnabled(true);
			txtPre.setEnabled(true);
			txtMarca.setEnabled(true);
			txtTipo.setEnabled(true);
			txtConc.setEnabled(true);
			txtEsp.setEnabled(true);
			txtQntdProd.setEnabled(true);
			txtEsp.setEnabled(true);
			txtUn.setEnabled(true);						
			
			txtNome.setText("");
			txtPre.setText("");
			txtMarca.setText("");
			txtTipo.setText("");
			txtConc.setText("");
			txtEsp.setText("");
			txtQntdProd.setText("");
			txtEsp.setText("");
			txtUn.setText("");
						
}
		}
		private ProdutoDAO ProdutoDAO() {
			// TODO Auto-generated method stub
			return null;
		} 
	});

	btAlterar.setBounds(163, 221, 89, 23);
	contentPane.add(btAlterar);
	
	JButton btDeletar = new JButton("Deletar");
	btDeletar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Produto p = new Produto();
			p.setCodigo(Integer.parseInt(txtCod.getText()));
			ProdutoDAO pDAO = new ProdutoDAO();
			try {
				pDAO.deletar(p);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
			
		}
	});
	btDeletar.setBounds(307, 221, 89, 23);
	contentPane.add(btDeletar);
	
	JLabel lblTipo = new JLabel("Tipo");
	lblTipo.setBounds(10, 207, 67, 22);
	contentPane.add(lblTipo);
	

}
	
}
