import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos frame = new Produtos();
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
	public Produtos() {
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo ");
		lblNewLabel.setBounds(10, 11, 67, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("00000000.000");
		lblNewLabel_1.setBounds(10, 31, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Paracetamol Caixa");
		lblNewLabel_1_1.setBounds(10, 96, 151, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 76, 67, 22);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1_2 = new JLabel("100 UN");
		lblNewLabel_1_2.setBounds(188, 63, 43, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblQuantiadeEmEstoque = new JLabel("Quantiade em estoque");
		lblQuantiadeEmEstoque.setBounds(153, 43, 115, 22);
		contentPane.add(lblQuantiadeEmEstoque);
	}
}
