package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCdigo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setResizable(false);
		setBounds(100, 100, 260, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCdigo = new JTextField();
		txtCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCdigo.setBounds(83, 103, 86, 20);
		contentPanel.add(txtCdigo);
		txtCdigo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(83, 148, 86, 20);
		contentPanel.add(passwordField);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setBounds(83, 88, 86, 14);
		contentPanel.add(lblCdigo);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(83, 134, 86, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido!");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBienvenido.setBounds(10, 11, 241, 38);
		contentPanel.add(lblBienvenido);
		
		JLabel lblPls = new JLabel("Por favor inicie sesi\u00F3n");
		lblPls.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		lblPls.setBounds(10, 47, 241, 14);
		contentPanel.add(lblPls);
		
		JButton btnInicio = new JButton("Iniciar");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo para buscar en las listas de usuarios y colocar usuario default que funcione como admin/admin
			}
		});
		btnInicio.setBounds(80, 187, 89, 23);
		contentPanel.add(btnInicio);
	}
}
