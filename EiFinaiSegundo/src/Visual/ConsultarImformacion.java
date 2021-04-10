package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Cliente;
import Logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class ConsultarImformacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCodigo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarImformacion dialog = new ConsultarImformacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarImformacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarImformacion.class.getResource("/Imagenes/tarjeta-de-identificacion (5).png")));
		setForeground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setTitle("Identificacion");
		setBounds(100, 100, 412, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo del cliente:");
				lblNewLabel.setForeground(Color.BLUE);
				lblNewLabel.setBounds(10, 78, 108, 13);
				panel.add(lblNewLabel);
			}
			{
				TxtCodigo = new JTextField();
				TxtCodigo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
				TxtCodigo.setBounds(117, 76, 96, 19);
				panel.add(TxtCodigo);
				TxtCodigo.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.BLUE);
			panel_1.setBounds(10, 15, 368, 53);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Consultar imformacion");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 27));
			lblNewLabel_1.setBounds(10, 10, 348, 32);
			panel_1.add(lblNewLabel_1);
			
			btnNewButton = new JButton("Consultar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente C = Empresa.getInstance().BuscarCliente(TxtCodigo.getText());
					if(C!=null) {
						for(Cliente Clie:Empresa.getInstance().getMisClientes()) {
							if(Clie.getIdentificacion().equalsIgnoreCase(TxtCodigo.getText())) {
								ImformacionDeClientes Clie1 = new ImformacionDeClientes(TxtCodigo.getText());
								Clie1.setVisible(true);
								Clie1.setModal(false);
								dispose();
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No existe un cliente con ese codigo ", "Error", JOptionPane.ERROR_MESSAGE);
						TxtCodigo.setText("");
					}
				}
			});
			btnNewButton.setBounds(72, 116, 90, 21);
			panel.add(btnNewButton);
			
			btnNewButton_1 = new JButton("Salir");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setBounds(229, 116, 85, 21);
			panel.add(btnNewButton_1);
		}
	}
}
