package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
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

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import Logico.Empresa;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtNombre;
	private JPasswordField TxtContraseña;
	private JTextField TxtContra1;
	private JRadioButton RbtnVer;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

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
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/Login_37128.png")));
		setTitle("Iniciar sesion\r\n");
		setResizable(false);
		setBounds(100, 100, 404, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setForeground(Color.BLUE);
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inicio de sesion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel img = new JLabel(" ");

		ImageIcon image = new ImageIcon("/Imagenes/Login_37128.png");
	
		//Panellol.add(img); // "dibujar" es mi panel ok...

		//Propiedades de la etiqueta
		img.setIcon(image);
		img.setSize(135,135);
		img.setLocation(550,20);
		img.setVisible(true);
		contentPanel.setLayout(null);
		
		TxtNombre = new JTextField();
		TxtNombre.setBounds(157, 158, 86, 20);
		TxtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPanel.add(TxtNombre);
		TxtNombre.setColumns(10);
		
		TxtContraseña = new JPasswordField();
		TxtContraseña.setBounds(157, 208, 86, 20);
		TxtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(TxtContraseña);
		
		JLabel lblCdigo = new JLabel("Nombre:");
		lblCdigo.setForeground(Color.BLUE);
		lblCdigo.setBounds(157, 138, 86, 14);
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblCdigo);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(157, 184, 86, 14);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblPassword);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido!");
		lblBienvenido.setForeground(Color.BLUE);
		lblBienvenido.setBounds(79, 6, 241, 38);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPanel.add(lblBienvenido);
		
		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setForeground(Color.BLUE);
		btnInicio.setBounds(155, 238, 89, 23);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Empresa.getInstance().confirmLogin(TxtNombre.getText(), TxtContraseña.getText())!=true) {
					JOptionPane.showMessageDialog(null, "El nombre o contraseña no existen. ", "Error", JOptionPane.ERROR_MESSAGE);
					Clean();
					
				}else {
					JOptionPane.showMessageDialog(null, "Inicio satisfactorio ", "Comfirmacion", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//ImformacionDeClientes C = new ImformacionDeClientes();
					//C.setVisible(true);
				}
			}
		});
		contentPanel.add(btnInicio);
		
		RbtnVer = new JRadioButton("Ver");
		RbtnVer.setBackground(Color.PINK);
		RbtnVer.setForeground(Color.BLUE);
		RbtnVer.setBounds(249, 207, 48, 21);
		RbtnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RbtnVer.isSelected()) {
					TxtContra1.setText(TxtContraseña.getText());
					TxtContraseña.setVisible(false);
					TxtContra1.setVisible(true);

				}else {
					TxtContraseña.setVisible(true);
					TxtContra1.setVisible(false);
				}
			}
		});
		contentPanel.add(RbtnVer);
		
		TxtContra1 = new JTextField();
		TxtContra1.setBounds(157, 208, 86, 20);
		TxtContra1.setVisible(false);
		TxtContra1.setEditable(false);
		TxtContra1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(TxtContra1);
		TxtContra1.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(163, 54, 80, 82);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/user.png")));
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u00BFNo tienes cuenta? ");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(142, 271, 115, 13);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Registrate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeCliente C = new RegistroDeCliente();
				C.setVisible(true);
				C.setModal(false);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(254, 267, 99, 21);
		contentPanel.add(btnNewButton);
	}
	public void Clean() {
		TxtNombre.setText("");
		TxtContraseña.setText("");
	}
}
