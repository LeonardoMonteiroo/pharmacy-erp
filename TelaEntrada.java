import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
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
	private JTable table;
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo");
		lblNewLabel_2.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		txCod = new JTextField();
		txCod.setBounds(10, 24, 75, 20);
		contentPane.add(txCod);
		txCod.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantidade");
		lblNewLabel_3_1.setBounds(106, 10, 75, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txQuantidade = new JTextField();
		txQuantidade.setColumns(10);
		txQuantidade.setBounds(106, 24, 75, 20);
		contentPane.add(txQuantidade);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto prod = new Produto();
				prod.setCodigo(Integer.parseInt(txCod.getText()));
				
				Caixa p1 = new Caixa();
				p1.setQnt(Integer.parseInt(txQuantidade.getText())); 
							
				//nao mexer, gambiarra!!!
				if(check==0) {
				obj1.addRow(new String[] {
						colunas[0],
						colunas[1],
						colunas[2]
				});
				check=1;
				}
				
				if(check==1 || check==2){ //testar se funciona
				
				obj1.addRow(new String[] {
						String.valueOf(prod.getNome()), 
						String.valueOf(prod.getCodigo()),
						String.valueOf(p1.getQnt()),
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
		btnNewButton.setBounds(236, 23, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(308, 55, 17, 195);
		contentPane.add(scrollBar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque telaEstoque = new TelaEstoque();
				telaEstoque.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(325, 227, 99, 23);
		contentPane.add(btnVoltar);
		
		table = new JTable();
		table.setBorder(UIManager.getBorder("FormattedTextField.border"));
		table.setBounds(10, 55, 314, 195);
		contentPane.add(table);
		
		JButton btnDarEntrada = new JButton("Dar entrada");
		btnDarEntrada.setBounds(325, 193, 99, 23);
		contentPane.add(btnDarEntrada);
	}
}
