package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classesdenegocio.Produto;
import classesdenegocio.Medicamento;
import classesdenegocio.Cosmeticos;
import dados.ProdutoDAO;
import tela.TelaEstoque;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {


	private JPanel contentPane;
	private JTextField txtPre;
	private JTextField txtEst;
	private JTextField txtUn;
	private JTextField txtQntdProd;
	private JTextField txtMarca;
	private JTextField txtNome;
	private JTextField txtEsp;
	private JTextField txtConc;
	private JTextField txtTipo;
	private JTextField campoCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produto p1 = new Produto();
					TelaProdutos frame = new TelaProdutos(p1);
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
	
	
	public TelaProdutos(Produto p) {
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo ");
		lblNewLabel.setBounds(10, 45, 67, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 110, 67, 22);
		contentPane.add(lblNome);
		
		JLabel lblQuantiadeEmEstoque = new JLabel("Quantiade em estoque");
		lblQuantiadeEmEstoque.setBounds(145, 110, 115, 22);
		contentPane.add(lblQuantiadeEmEstoque);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setBounds(10, 182, 67, 22);
		contentPane.add(lblPreoUnitrio);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(144, 43, 67, 22);
		contentPane.add(lblMarca);
		
		JLabel lblEspecificao = new JLabel("Especifica\u00E7\u00E3o");
		lblEspecificao.setBounds(145, 182, 67, 22);
		contentPane.add(lblEspecificao);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de medida");
		lblUnidadeDeMedida.setBounds(311, 179, 115, 22);
		contentPane.add(lblUnidadeDeMedida);
		
		JLabel lblQntdDoProduto = new JLabel("Qntd do produto");
		lblQntdDoProduto.setBounds(307, 47, 102, 22);
		contentPane.add(lblQntdDoProduto);
		
		JLabel lblConcentrao = new JLabel("Concentra\u00E7\u00E3o");
		lblConcentrao.setBounds(307, 110, 67, 22);
		contentPane.add(lblConcentrao);
		
		campoCodigo = new JTextField();
		campoCodigo.setText(String.valueOf(p.getSearchCod()));
		campoCodigo.setBounds(10, 64, 107, 20);
		contentPane.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		txtPre = new JTextField();
		txtPre.setText("00000000.000");
		txtPre.setEnabled(false);
		txtPre.setColumns(10);
		txtPre.setBounds(10, 199, 107, 20);
		contentPane.add(txtPre);
		
		txtEst = new JTextField();
		txtEst.setText("00");
		txtEst.setEnabled(false);
		txtEst.setColumns(10);
		txtEst.setBounds(145, 132, 107, 20);
		contentPane.add(txtEst);
		
		txtUn = new JTextField();
		txtUn.setText("00000000.000");
		txtUn.setEnabled(false);
		txtUn.setColumns(10);
		txtUn.setBounds(311, 199, 107, 20);
		contentPane.add(txtUn);
		
		txtQntdProd = new JTextField();
		txtQntdProd.setText("00000000.000");
		txtQntdProd.setEnabled(false);
		txtQntdProd.setColumns(10);
		txtQntdProd.setBounds(307, 64, 107, 20);
		contentPane.add(txtQntdProd);
		
		txtMarca = new JTextField();
		txtMarca.setText("xxxxxx");
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(145, 62, 107, 20);
		contentPane.add(txtMarca);
		
		txtNome = new JTextField();
		txtNome.setText("xxxxxx");
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 127, 107, 20);
		contentPane.add(txtNome);
		
		txtEsp = new JTextField();
		txtEsp.setText("xxxxxx");
		txtEsp.setEnabled(false);
		txtEsp.setColumns(10);
		txtEsp.setBounds(145, 199, 107, 20);
		contentPane.add(txtEsp);
		
		txtConc = new JTextField();
		txtConc.setText("xxxxxx");
		txtConc.setEnabled(false);
		txtConc.setColumns(10);
		txtConc.setBounds(307, 132, 107, 20);
		contentPane.add(txtConc);
		
		txtTipo = new JTextField();
		txtTipo.setText("xxxxxx");
		txtTipo.setEnabled(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(10, 258, 107, 20);
		contentPane.add(txtTipo);
				
	
	JButton btAlterar = new JButton("Alterar");
	btAlterar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(btAlterar.getText() == "Confirmar") {
				Produto p = new Produto();
				Medicamento m = new Medicamento();
				Cosmeticos c = new Cosmeticos();
				
				p.setCodigo(Integer.parseInt(campoCodigo.getText()));
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
			}else if(Integer.parseInt(campoCodigo.getText()) > 0 && btAlterar.getText() == "Alterar") {
			btAlterar.setText("Confirmar");
			//preparar para dados
			
			if(txtEsp.getText().length()>1) {
				txtEsp.setEnabled(true);
				txtUn.setEnabled(true);		
			}else {
				txtConc.setEnabled(true);
				txtQntdProd.setEnabled(true);
			}
			
			txtNome.setEnabled(true);
			txtPre.setEnabled(true);
			txtMarca.setEnabled(true);
			txtTipo.setEnabled(true);		
						
}
		}
		private ProdutoDAO ProdutoDAO() {
			// TODO Auto-generated method stub
			return null;
		} 
	});

	btAlterar.setBounds(163, 253, 89, 23);
	contentPane.add(btAlterar);
	
	JButton btDeletar = new JButton("Deletar");
	btDeletar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Produto p = new Produto();
			
			ProdutoDAO pDAO = new ProdutoDAO();
			try {
				pDAO.deletar(p, Integer.parseInt(campoCodigo.getText()));
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
			
		}
	});
	btDeletar.setBounds(256, 253, 89, 23);
	contentPane.add(btDeletar);
	btDeletar.setEnabled(false);
	
	JLabel lblTipo = new JLabel("Tipo");
	lblTipo.setBounds(10, 241, 67, 22);
	contentPane.add(lblTipo);
	
	JButton btPesquisar = new JButton("Pesquisar");
	btPesquisar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btDeletar.setEnabled(true);
			
			//Objeto para receber os filtros (WHERE)
			Produto p = new Produto();
			Cosmeticos c = new Cosmeticos();
			Medicamento m = new Medicamento();
			p.setCodigo(Integer.parseInt(campoCodigo.getText()));
			
			ProdutoDAO pDAO = new ProdutoDAO();
			ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
			ArrayList<Cosmeticos> listaCosmetico = new ArrayList<Cosmeticos>();
			ArrayList<Medicamento> listaMedicamento = new ArrayList<Medicamento>();
			try {
				listaProdutos = pDAO.listarP(p);
				listaMedicamento = pDAO.listarM(m);
				listaCosmetico = pDAO.listarC(c);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Mostrar isso Tabela (JTable)
			//for(int i=0; i < listaProdutos.size(); i++) {
			for(Produto pItem: listaProdutos) {
				//Cada linha:
				txtNome.setText(pItem.getNome());
				txtPre.setText(String.valueOf(pItem.getPrecoUnitario()));
				txtMarca.setText(pItem.getMarca());
			}
			for(Medicamento mItem: listaMedicamento) {
				txtQntdProd.setText(String.valueOf(mItem.getQtdProduto()));
				txtConc.setText(String.valueOf(mItem.getConcentracao()));	
			}
			for(Cosmeticos cItem: listaCosmetico) {txtTipo.setText(cItem.getTipo());
				txtEsp.setText(cItem.getEspecificao());
				txtUn.setText(String.valueOf(cItem.getUnidMedidaProd()));	
				
			}//fim for
			//Aplicar o modelo dentro do JTable:
			
		}
	});
	btPesquisar.setBounds(349, 253, 89, 23);
	contentPane.add(btPesquisar);
	
	JButton voltar = new JButton("Voltar");
	voltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			TelaEstoque telaEstoque = new TelaEstoque();
			telaEstoque.setVisible(true);
			dispose();
		}
	});
	voltar.setBounds(10, 11, 89, 23);
	contentPane.add(voltar);
	

}

	private String toString(Integer searchCod) {
		// TODO Auto-generated method stub
		return null;
	}
}
