import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblQtde;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(262, 54, 17, 176);
		contentPane.add(scrollBar);
		
		table = new JTable();
		table.setBorder(UIManager.getBorder("ComboBox.border"));
		table.setBounds(41, 54, 239, 176);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(41, 23, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(41, 10, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblQtde = new JLabel("Qtde.");
		lblQtde.setBounds(97, 10, 46, 14);
		contentPane.add(lblQtde);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 23, 46, 20);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(203, 22, 77, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(345, 157, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("R$ 0,00");
		lblNewLabel_2.setBounds(345, 171, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Fechar pedido");
		btnNewButton_1.setBounds(319, 207, 105, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Pre\u00E7o Total");
		lblNewLabel_3.setBounds(345, 54, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("R$ 0,00");
		lblNewLabel_4.setBounds(345, 68, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(319, 22, 105, 23);
		contentPane.add(btnNewButton_2);
	}
}
