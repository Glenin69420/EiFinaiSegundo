package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class RegustroDeCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCodigo;
	private JTextField TxtNombre;
	private JTextField TxtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegustroDeCliente dialog = new RegustroDeCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegustroDeCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegustroDeCliente.class.getResource("/Imagenes/usuario-especialista.png")));
		setTitle("Registro de clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imformacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 27, 45, 13);
			panel.add(lblNewLabel);
			
			TxtCodigo = new JTextField();
			TxtCodigo.setEditable(false);
			TxtCodigo.setBounds(65, 24, 96, 19);
			panel.add(TxtCodigo);
			TxtCodigo.setText("C-"+Cliente.Codigo);
			TxtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 75, 50, 13);
			panel.add(lblNewLabel_1);
			
			TxtNombre = new JTextField();
			TxtNombre.setBounds(65, 72, 96, 19);
			panel.add(TxtNombre);
			TxtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Direccion:");
			lblNewLabel_2.setBounds(10, 118, 60, 13);
			panel.add(lblNewLabel_2);
			
			TxtDireccion = new JTextField();
			TxtDireccion.setBounds(70, 115, 96, 19);
			panel.add(TxtDireccion);
			TxtDireccion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente C = new Cliente(TxtCodigo.getText(), TxtNombre.getText(), TxtDireccion.getText());
						Empresa.getInstance().InsertarCliente(C);
						clean();
						JOptionPane.showMessageDialog(null, "El cliente ha sido registrado con exito", "Registro satisfactorio", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					


				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clean() {
		TxtCodigo.setText("C-"+Cliente.Codigo);
		TxtNombre.setText("");
		TxtDireccion.setText("");
		
	}
}
