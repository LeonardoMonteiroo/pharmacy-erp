package tela;

import java.awt.BorderLayout;
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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTextField txCaixa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	String colunas[] = {"Caixa", "Status", "Saldo"};
	private JTextField txSaldoDoCaixa;
	
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
		setTitle("Caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txCaixa = new JTextField();
		txCaixa.setBounds(126, 11, 51, 20);
		contentPane.add(txCaixa);
		txCaixa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero do Caixa");
		lblNewLabel.setBounds(10, 14, 106, 14);
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
		btnNewButton.setBounds(10, 92, 106, 23);
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
		btnExluirCaixa.setBounds(10, 126, 106, 23);
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
		btnAbirCaixa.setBounds(126, 92, 116, 23);
		contentPane.add(btnAbirCaixa);
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setAberto(false);//define o caixa como fechado
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
				c.setSaldoCaixa(0);
				
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
		
				try {
					cDAO.statusCaixa(c);
					cDAO.saldoCaixa(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFecharCaixa.setBounds(126, 126, 118, 23);
		contentPane.add(btnFecharCaixa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(264, 10, 106, 23);
		contentPane.add(btnVoltar);
		
		table = new JTable();
		table.setBounds(10, 42, 244, 39);
		contentPane.add(table);
		
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1º Dados da tabela Produto -> listar() -> ArrayList
				
				//Criar um modelo de tabela -> JTable
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Caixa"); //visualização
				modelo.addColumn("Status");
				modelo.addColumn("Saldo");
				
				//Objeto para receber os filtros (WHERE)
				Caixa c = new Caixa();
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
				
				modelo.addRow(new String[] {
						colunas[0],
						colunas[1],
						colunas[2]
				});
				
				CaixaDAO cDAO = new CaixaDAO();
				ArrayList<Caixa> listaCaixas = new ArrayList<Caixa>();
				try {
					listaCaixas = cDAO.listar(c);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Mostrar isso Tabela (JTable)
				//for(int i=0; i < listaProdutos.size(); i++) {
				for(Caixa cItem: listaCaixas) {
					//Cada linha:
					modelo.addRow(new Object[] {
							cItem.getNumCaixa(),
							cItem.getStatus(),
							cItem.getSaldoCaixa()
					});
				} //fim for
				//Aplicar o modelo dentro do JTable:
				table.setModel(modelo);
			}
		});
		btnNewButton_1.setBounds(186, 10, 68, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo do Caixa");
		lblNewLabel_1.setBounds(275, 80, 87, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Alterar Saldo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caixa c = new Caixa();
				c.setSaldoCaixa(Float.parseFloat(txSaldoDoCaixa.getText()));//define o saldo do caixa
				c.setNumCaixa(Integer.parseInt(txCaixa.getText()));
					
				//Criar um objeto da classe DAO
				CaixaDAO cDAO = new CaixaDAO();
		
				try {
					cDAO.saldoCaixa(c);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(252, 126, 118, 23);
		contentPane.add(btnNewButton_2);
		
		txSaldoDoCaixa = new JTextField();
		txSaldoDoCaixa.setToolTipText("");
		txSaldoDoCaixa.setBounds(252, 93, 118, 20);
		contentPane.add(txSaldoDoCaixa);
		txSaldoDoCaixa.setColumns(10);
	}
}
