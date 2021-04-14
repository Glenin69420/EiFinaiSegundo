package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class RegistroDeContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodigoCliente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroDeContrato dialog = new RegistroDeContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroDeContrato() {
		setBounds(100, 100, 599, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 563, 54);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigoCliente = new JLabel("C\u00F3digo del cliente:\r\n");
		lblCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigoCliente.setBounds(10, 29, 91, 14);
		panel.add(lblCodigoCliente);
		{
			CodigoCliente = new JTextField();
			CodigoCliente.setBounds(100, 26, 144, 20);
			panel.add(CodigoCliente);
			CodigoCliente.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Nombre del contrato:");
		lblNewLabel.setBounds(288, 29, 111, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(396, 26, 157, 20);
		panel.add(textField);
		textField.setColumns(10);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 87, 563, 235);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel Trabajadores = new JLabel("Tipos de proyectos:");
				Trabajadores.setBounds(10, 34, 103, 14);
				panel_1.add(Trabajadores);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(111, 31, 122, 21);
				panel_1.add(comboBox);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(10, 76, 200, 115);
				panel_1.add(panel_2);
				panel_2.setLayout(null);
				
				JList list = new JList();
				list.setBounds(10, 11, 180, 93);
				panel_2.add(list);
			}
			
			JButton Derecha = new JButton(">>");
			Derecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Derecha.setBounds(236, 93, 89, 23);
			panel_1.add(Derecha);
			
			JButton Izquierda = new JButton("<<");
			Izquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Izquierda.setBounds(236, 142, 89, 23);
			panel_1.add(Izquierda);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(353, 76, 200, 115);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			JList list = new JList();
			list.setBounds(10, 11, 180, 93);
			panel_2.add(list);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de finalizaci\u00F3n:");
			lblNewLabel_1.setBounds(279, 34, 103, 14);
			panel_1.add(lblNewLabel_1);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerDateModel(new Date(1618372800000L), null, null, Calendar.DAY_OF_YEAR));
			spinner_2.setBounds(392, 31, 161, 20);
			panel_1.add(spinner_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton TerminarButton = new JButton("Terminar\r\n");
				TerminarButton.setActionCommand("OK");
				buttonPane.add(TerminarButton);
				getRootPane().setDefaultButton(TerminarButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar\r\n");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
