package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Contrato;
import Logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class ImformacionDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ImformacionDeClientes dialog = new ImformacionDeClientes("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public static void main(String[] args) {
		try {
			ImformacionDeClientes dialog = new ImformacionDeClientes("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ImformacionDeClientes(String Nombre) {
		setTitle("Gestion de Contratos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Imformacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de contrato:");
		lblNewLabel.setBounds(135, 40, 125, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(254, 39, 150, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de contrato:");
		lblNewLabel_1.setBounds(135, 63, 128, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 60, 150, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ImformacionDeClientes.class.getResource("/Imagenes/contrato.png")));
		lblNewLabel_2.setBounds(10, 25, 128, 128);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del cliente:");
		lblNewLabel_3.setBounds(135, 85, 109, 13);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 82, 150, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	//	Llenar(Nombre);
	}
/*	public void Llenar(String Nombre) {
		Contrato C = Empresa.getInstance().BuscarContrato(Nombre);
		if(C!=null) {
			for(Contrato C1: Empresa.getInstance().getMisContratos()) {
				if(C1.getNombre().equalsIgnoreCase(Nombre)) {
				TxtNombre.setText(C1.getNombre());
				TxtApellidos.setText(C1.getApellidos());
				TxtCodigo.setText(C1.getIdentificacion());
				}
			}
			
		}
	}*/
}
