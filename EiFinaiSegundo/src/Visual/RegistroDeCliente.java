package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import Logico.Cliente;
import Logico.Empresa;
import Logico.Trabajadora;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class RegistroDeCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCodigo;
	private JTextField TxtNombre;
	private JTextField TxtTelefono;
	private JTextField TxtApellidos;
	private JTextField TxtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroDeCliente dialog = new RegistroDeCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroDeCliente() {
		setForeground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroDeCliente.class.getResource("/Imagenes/usuario-especialista.png")));
		setTitle("Registro de clientes");
		setBounds(100, 100, 376, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imformacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			//TxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBounds(10, 269, 45, 13);
			panel.add(lblNewLabel);
			
			TxtCodigo = new JTextField();
			TxtCodigo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtCodigo.setEditable(false);
			TxtCodigo.setBounds(70, 266, 96, 19);
			panel.add(TxtCodigo);
			TxtCodigo.setText("C-"+Cliente.Codigo);
			TxtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setBounds(10, 102, 50, 13);
			panel.add(lblNewLabel_1);
			
			TxtNombre = new JTextField();
			TxtNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtNombre.setBounds(70, 100, 278, 19);
			panel.add(TxtNombre);
			TxtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Direccion:");
			lblNewLabel_2.setForeground(Color.BLUE);
			lblNewLabel_2.setBounds(10, 231, 60, 13);
			panel.add(lblNewLabel_2);
			
			TxtTelefono = new JTextField();
			TxtTelefono.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtTelefono.setBounds(70, 186, 278, 19);
			panel.add(TxtTelefono);
			TxtTelefono.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBackground(Color.BLUE);
			panel_1.setBounds(10, 16, 339, 65);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Registrar");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBackground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 30));
			lblNewLabel_3.setBounds(101, 10, 166, 45);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Apellidos:");
			lblNewLabel_4.setForeground(Color.BLUE);
			lblNewLabel_4.setBounds(10, 145, 60, 13);
			panel.add(lblNewLabel_4);
			
			TxtApellidos = new JTextField();
			TxtApellidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtApellidos.setBounds(70, 143, 278, 19);
			panel.add(TxtApellidos);
			TxtApellidos.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Telefono:");
			lblNewLabel_5.setForeground(Color.BLUE);
			lblNewLabel_5.setBounds(10, 188, 52, 13);
			panel.add(lblNewLabel_5);
			
			TxtDireccion = new JTextField();
			TxtDireccion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtDireccion.setBounds(70, 230, 278, 19);
			panel.add(TxtDireccion);
			TxtDireccion.setColumns(10);
			
			JButton BtnRegistrar = new JButton("Registrar");
			BtnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente C = new Cliente(TxtCodigo.getText(), TxtNombre.getText(), TxtApellidos.getText(), 
							TxtTelefono.getText(), TxtDireccion.getText(), "prueba");
					Empresa.getInstance().InsertarCliente(C);
					clean();
					JOptionPane.showMessageDialog(null, "El cliente ha sido registrados con exito. ", "Registro satisfactorio", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			BtnRegistrar.setForeground(Color.WHITE);
			BtnRegistrar.setBackground(Color.BLUE);
			BtnRegistrar.setBounds(59, 317, 96, 21);
			panel.add(BtnRegistrar);
			
			JButton BtnCancelar = new JButton("Cancelar");
			BtnCancelar.setForeground(Color.WHITE);
			BtnCancelar.setBackground(Color.RED);
			BtnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			BtnCancelar.setBounds(214, 317, 85, 21);
			panel.add(BtnCancelar);
		}
	}
	private void clean() {
		TxtCodigo.setText("C-"+Cliente.Codigo);
		TxtNombre.setText("");
		TxtTelefono.setText("");
		TxtDireccion.setText("");
		TxtApellidos.setText("");
		
	}
}
