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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.text.Caret;

import com.sun.glass.ui.Pixels.Format;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class ImformacionDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtNombre;
	private JTextField TxtCodigo;
	private JTextField TxtCliente;
	private JTextField TxtPago;
	private JTextField FechaInicio;
	private JTextField FechaFinal;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImformacionDeClientes.class.getResource("/Imagenes/contrato.png")));
		setTitle("Gestion de Contratos");
		setBounds(100, 100, 450, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Imformacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de contrato:");
		lblNewLabel.setBounds(132, 74, 125, 16);
		panel.add(lblNewLabel);
		
		TxtNombre = new JTextField();
		TxtNombre.setEditable(false);
		TxtNombre.setBounds(252, 73, 161, 19);
		panel.add(TxtNombre);
		TxtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de contrato:");
		lblNewLabel_1.setBounds(132, 103, 128, 13);
		panel.add(lblNewLabel_1);
		
		TxtCodigo = new JTextField();
		TxtCodigo.setEditable(false);
		TxtCodigo.setBounds(252, 100, 161, 19);
		panel.add(TxtCodigo);
		TxtCodigo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ImformacionDeClientes.class.getResource("/Imagenes/contrato.png")));
		lblNewLabel_2.setBounds(10, 74, 128, 128);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del cliente:");
		lblNewLabel_3.setBounds(132, 126, 109, 13);
		panel.add(lblNewLabel_3);
		
		TxtCliente = new JTextField();
		TxtCliente.setEditable(false);
		TxtCliente.setBounds(252, 123, 161, 19);
		panel.add(TxtCliente);
		TxtCliente.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(10, 15, 406, 49);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Imformacion");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(10, 10, 386, 29);
		panel_1.add(lblNewLabel_4);
		
		TxtPago = new JTextField();
		TxtPago.setEditable(false);
		TxtPago.setBounds(195, 152, 96, 19);
		panel.add(TxtPago);
		TxtPago.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pago total:");
		lblNewLabel_5.setBounds(132, 155, 96, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de inicio:");
		lblNewLabel_6.setBounds(67, 212, 96, 13);
		panel.add(lblNewLabel_6);
		
		FechaInicio = new JTextField();
		FechaInicio.setEditable(false);
		FechaInicio.setBounds(67, 225, 125, 19);
		panel.add(FechaInicio);
		FechaInicio.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de conclusion:");
		lblNewLabel_7.setBounds(230, 212, 128, 13);
		panel.add(lblNewLabel_7);
		
		FechaFinal = new JTextField();
		FechaFinal.setEditable(false);
		FechaFinal.setBounds(231, 225, 127, 19);
		panel.add(FechaFinal);
		FechaFinal.setColumns(10);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(159, 274, 85, 21);
		panel.add(btnNewButton);
		setLocationRelativeTo(null);
		Llenar(Nombre);
	}
	public void Llenar(String Nombre) {
		Contrato C = Empresa.getInstance().BuscarContrato(Nombre);
		if(C!=null) {
			for(Contrato C1: Empresa.getInstance().getMisContratos()) {
				if(C1.getNombre().equalsIgnoreCase(Nombre)) {
				TxtNombre.setText(C1.getNombre());
				TxtCodigo.setText(C1.getIdentificador());
				TxtCliente.setText(C1.getCliente().getNombre());
				String cadena = Float.toString(C1.getTotal());
				TxtPago.setText(cadena);

				FechaInicio.setText(convertirFechaString(C1.getFechaInicio()));
				FechaFinal.setText(convertirFechaString(C1.getFechaInicio()));
				
				}
			}
			
		}
	}
	
	public String convertirFechaString(Date date){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

	}
}
