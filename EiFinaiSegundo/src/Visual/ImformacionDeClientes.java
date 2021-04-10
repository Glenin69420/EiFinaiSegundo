package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ImformacionDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCodigo;
	private JTextField TxtNombre;
	private JTextField TxtApellidos;

	/**
	 * Launch the application.
	 */
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
	public ImformacionDeClientes(String Codigo) {
		setTitle("Imformacion de cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		TxtCodigo = new JTextField();
		TxtCodigo.setBounds(170, 50, 96, 19);
		contentPanel.add(TxtCodigo);
		TxtCodigo.setColumns(10);
		
		TxtNombre = new JTextField();
		TxtNombre.setBounds(170, 110, 96, 19);
		contentPanel.add(TxtNombre);
		TxtNombre.setColumns(10);
		
		TxtApellidos = new JTextField();
		TxtApellidos.setBounds(170, 165, 96, 19);
		contentPanel.add(TxtApellidos);
		TxtApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(71, 53, 54, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(71, 113, 52, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(71, 168, 56, 13);
		contentPanel.add(lblNewLabel_2);
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
		Llenar(Codigo);
	}
	public void Llenar(String Codigo) {
		Cliente C = Empresa.getInstance().BuscarCliente(Codigo);
		if(C!=null) {
			for(Cliente C1: Empresa.getInstance().getMisClientes()) {
				if(C1.getIdentificacion().equalsIgnoreCase(Codigo)) {
				TxtNombre.setText(C1.getNombre());
				TxtApellidos.setText(C1.getApellidos());
				TxtCodigo.setText(C1.getIdentificacion());
				}
			}
			
		}
	}
}
