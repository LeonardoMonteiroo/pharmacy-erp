import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;

public class Lote extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lote frame = new Lote();
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
	public Lote() {
		setTitle("Novo lote");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar novo lote");
		lblNewLabel.setBounds(10, 11, 217, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("VALIDADE");
		lblNewLabel_1.setBounds(226, 21, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo produto");
		lblNewLabel_2.setBounds(10, 36, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 56, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 18, 102, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome produto");
		lblNewLabel_3.setBounds(10, 87, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 112, 148, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantidade");
		lblNewLabel_3_1.setBounds(10, 143, 115, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 168, 148, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(36, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(226, 75, 165, 161);
		contentPane.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Itens");
		lblNewLabel_4.setBounds(226, 59, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
}
