package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import Logico.Cliente;
import Logico.Empresa;

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
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					FileInputStream empresa;
					FileOutputStream empresa2;
					ObjectInputStream empresaRead;
					ObjectOutputStream empresaWrite;
					try {
						empresa = new FileInputStream ("empresa.dat");
						empresaRead = new ObjectInputStream(empresa);
						Empresa temp = (Empresa)empresaRead.readObject();
						Empresa.setCentro(temp);
						empresa.close();
						empresaRead.close();
					} catch (FileNotFoundException e) {
						try {
							empresa2 = new  FileOutputStream("empresa.dat");
							empresaWrite = new ObjectOutputStream(empresa2);
							Cliente aux = new Cliente("C-1", "Frank", "Paulino", "809-580-5544", "Aeropuerto", "Prueba");
							Empresa.getInstance().InsertarCliente(aux);
							empresaWrite.writeObject(Empresa.getInstance());
							empresa2.close();
							empresaWrite.close();
						} catch (FileNotFoundException e1) {
						} catch (IOException e1) {
							// TODO Auto-generated catch block
						}
					} catch (IOException e) {
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
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
					JOptionPane.showMessageDialog(null, "El nombre o contraseña no existen. ", "ERROR", JOptionPane.ERROR_MESSAGE);
					Clean();
					
				}else {
					ProyectoPrincipal frame = new ProyectoPrincipal();
					dispose();
					frame.setVisible(true);
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
