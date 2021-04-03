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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logico.Empresa;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtNombre;
	private JPasswordField TxtContraseña;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/Login_37128.png")));
		setTitle("Iniciar sesion\r\n");
		setResizable(false);
		setBounds(100, 100, 260, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inicio de sesion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		TxtNombre = new JTextField();
		TxtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		TxtNombre.setBounds(84, 103, 86, 20);
		contentPanel.add(TxtNombre);
		TxtNombre.setColumns(10);
		
		TxtContraseña = new JPasswordField();
		TxtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		TxtContraseña.setBounds(84, 148, 86, 20);
		contentPanel.add(TxtContraseña);
		
		JLabel lblCdigo = new JLabel("Nombre:");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setBounds(84, 88, 86, 14);
		contentPanel.add(lblCdigo);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(84, 134, 86, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido!");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBienvenido.setBounds(7, 11, 241, 38);
		contentPanel.add(lblBienvenido);
		
		JLabel lblPls = new JLabel("Por favor inicie sesi\u00F3n");
		lblPls.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPls.setHorizontalAlignment(SwingConstants.CENTER);
		lblPls.setBounds(7, 47, 241, 38);
		contentPanel.add(lblPls);
		
		JButton btnInicio = new JButton("Iniciar");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Empresa.getInstance().confirmLogin(TxtNombre.getText(), TxtContraseña.getText())!=true) {
					JOptionPane.showMessageDialog(null, "El nombre o contraseña no existen. ", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Inicio satisfactorio ", "Comfirmacion", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInicio.setBounds(83, 187, 89, 23);
		contentPanel.add(btnInicio);
	}
}
