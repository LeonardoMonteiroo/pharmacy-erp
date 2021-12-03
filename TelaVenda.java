package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classesdenegocio.Caixa;
import classesdenegocio.Cosmeticos;
import classesdenegocio.Medicamento;
import classesdenegocio.Pedido;
import classesdenegocio.Produto;
import dados.CaixaDAO;
import dados.PedidoDAO;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txCod;
	private JLabel lblNewLabel;
	private JLabel lblQtde;
	private JTextField txQntd;
	private JButton btnAdicionar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel precoTotal;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	
	String colunas[] = {"Código", "Nome", "Quantidade", "Valor Unitário", "Valor Total"};
	
	private JTextField txCaixa;
	
	public static void main(String[] args) {

		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(0, 4);
		table.setBorder(UIManager.getBorder("ComboBox.border"));
		table.setBounds(20, 79, 239, 176);
		contentPane.add(table);
		
		txCod = new JTextField();
		txCod.setBounds(20, 48, 46, 20);
		contentPane.add(txCod);
		txCod.setColumns(10);
		
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(20, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblQtde = new JLabel("Quantidade");
		lblQtde.setBounds(76, 35, 77, 14);
		contentPane.add(lblQtde);
		
		txQntd = new JTextField();
		txQntd.setColumns(10);
		txQntd.setBounds(76, 48, 61, 20);
		contentPane.add(txQntd);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1º Dados da tabela Produto -> listar() -> ArrayList
				
				//Criar um modelo de tabela -> JTable
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Código"); //visualização
				modelo.addColumn("Nome");
				modelo.addColumn("Quantidade");
				modelo.addColumn("Valor Unitário");
				modelo.addColumn("Valor Total");
				
				//Objeto para receber os filtros (WHERE)
				Pedido ped = new Pedido();
				Produto pro = new Produto();
				Caixa c = new Caixa();
				pro.setCodigo(Integer.parseInt(txCod.getText()));
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
				ped.setQntd(Integer.parseInt(txQntd.getText()));
				ped.setValorTotalItem(Integer.parseInt(txQntd.getText())*pro.getPrecoUnitario());
				
				modelo.addRow(new String[] {
						colunas[0],
						colunas[1],
						colunas[2],
						colunas[3],
						colunas[4]
				});
				
				PedidoDAO pDAO = new PedidoDAO();
				ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
				try {
					pDAO.salvar(ped, pro, c);
					listaPedidos = pDAO.listar(ped, pro);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Mostrar isso Tabela (JTable)
				//for(int i=0; i < listaProdutos.size(); i++) {
				for(Pedido peItem: listaPedidos) {
					for(Produto p: peItem.getProduto()) {
						//Cada linha:
						modelo.addRow(new Object[] {
								p.getNome(),
								p.getCodigo(),
								peItem.getQntd(),
								p.getPrecoUnitario(),
								peItem.getValorTotalItem(),
						});					
					}
				}
				//Aplicar o modelo dentro do JTable:
				table.setModel(modelo);
			}
		});
		
		btnAdicionar.setBounds(182, 47, 77, 23);
		contentPane.add(btnAdicionar);
		
		lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(345, 157, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("R$ 0,00");
		lblNewLabel_2.setBounds(345, 171, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Fechar pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(306, 207, 118, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Pre\u00E7o Total");
		lblNewLabel_3.setBounds(345, 54, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		precoTotal = new JLabel("R$ 0,00");
		precoTotal.setBounds(345, 68, 46, 14);
		contentPane.add(precoTotal);

		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(319, 22, 105, 23);
		contentPane.add(btnNewButton_2);
		
		txCaixa = new JTextField();
		txCaixa.setColumns(10);
		txCaixa.setBounds(64, 4, 35, 20);
		contentPane.add(txCaixa);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(21, 7, 45, 14);
		contentPane.add(lblCaixa);
	}
}
