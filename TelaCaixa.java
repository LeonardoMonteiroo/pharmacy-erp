import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCaixa extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField campoCod;
	private JLabel lblNewLabel;
	private JLabel lblQtde;
	private JTextField campoQuant;
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
	
	String colunas[] = {"Nome", "Código", "Quantidade", "Preço UN"};
	private DefaultTableModel obj1 = new DefaultTableModel(colunas, 0);

	int check = 0;
	private JTextField textField;
	
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
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(262, 54, 17, 176);
		contentPane.add(scrollBar);
		
		table = new JTable(0, 4);
		table.setBorder(UIManager.getBorder("ComboBox.border"));
		table.setBounds(41, 54, 239, 176);
		contentPane.add(table);
		
		campoCod = new JTextField();
		campoCod.setBounds(41, 23, 46, 20);
		contentPane.add(campoCod);
		campoCod.setColumns(10);
		
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(41, 10, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblQtde = new JLabel("Qtde.");
		lblQtde.setBounds(97, 10, 46, 14);
		contentPane.add(lblQtde);
		
		campoQuant = new JTextField();
		campoQuant.setColumns(10);
		campoQuant.setBounds(97, 23, 46, 20);
		contentPane.add(campoQuant);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto prod = new Produto();
				prod.setCodigo(Integer.parseInt(campoCod.getText()));
				
				Pedido p1 = new Pedido();
				p1.setQntd(Integer.parseInt(campoQuant.getText())); 
							
				//nao mexer, gambiarra!!!
				if(check==0) {
				obj1.addRow(new String[] {
						colunas[0],
						colunas[1],
						colunas[2],
						colunas[3]
				});
				check=1;
				}
				
				if(check==1 || check==2){ //testar se funciona
				
				obj1.addRow(new String[] {
						String.valueOf(prod.getNome()), 
						String.valueOf(prod.getCodigo()),
						String.valueOf(p1.getQntd()),
						String.valueOf(prod.getPrecoUnitario()) 
				});
				
				check=2;
				
				}
				/*else {
					
					obj1.addRow(new String[] {
							p1.getNome(), 
							String.valueOf(p1.getCodigo()),
							String.valueOf(p1.getQnt()),
							String.valueOf(p1.getPrecoUnitario())
					});
				}*/
				
				table.setModel(obj1);
				
			} 
		});
		
		btnAdicionar.setBounds(203, 22, 77, 23);
		contentPane.add(btnAdicionar);
		
		lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(345, 157, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("R$ 0,00");
		lblNewLabel_2.setBounds(345, 171, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Fechar pedido");
		btnNewButton_1.setBounds(306, 207, 118, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Pre\u00E7o Total");
		lblNewLabel_3.setBounds(345, 54, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		precoTotal = new JLabel("R$ 0,00");
		precoTotal.setBounds(345, 68, 46, 14);
		contentPane.add(precoTotal);
		//setvalor
		//getvalor
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(153, 23, 40, 20);
		contentPane.add(textField);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(153, 10, 46, 14);
		contentPane.add(lblCaixa);
		
		JButton btnNewButton = new JButton("Abrir Caixa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar função para abrir o caixa
			}
		});
		btnNewButton.setBounds(41, 266, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Fechar Caixa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar função para fechar o caixa
			}
		});
		btnNewButton_3.setBounds(306, 266, 118, 23);
		contentPane.add(btnNewButton_3);
	}
}
