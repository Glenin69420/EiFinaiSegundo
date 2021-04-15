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

import Logico.Empresa;
import Logico.Proyecto;
import Logico.Trabajadora;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class RegistroDeContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CodigoCliente;
	private JTextField textField;
	private int index = -1;
	private int indexBack = -1;
	private ArrayList<String> disponibles;
	private ArrayList<String> Seleccionados;
	private JList ListaDisponibles;
	private JList ListaSeleccionados;
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
		setLocationRelativeTo(null);
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
				Trabajadores.setBounds(10, 34, 111, 14);
				panel_1.add(Trabajadores);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Web", "Movil", "Desktop"}));
				comboBox.setBounds(126, 31, 122, 21);
				panel_1.add(comboBox);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "Proyectos Registrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(10, 76, 200, 115);
				panel_1.add(panel_2);
				panel_2.setLayout(new BorderLayout(0, 0));
				
				ListaDisponibles = new JList();
				ListaDisponibles.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = ListaDisponibles.getSelectedIndex();
						if(index!=-1) {
							//BtnRegistrar.setEnabled(true);
							}
					}
				});
				panel_2.add(ListaDisponibles, BorderLayout.CENTER);
			}
			
			JButton Derecha = new JButton(">>");
			Derecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ListaDisponibles.getSelectedIndex()!=-1) {
						Seleccionados.add(disponibles.get(ListaDisponibles.getSelectedIndex()));
						disponibles.remove(ListaDisponibles.getSelectedIndex());
						ListaDisponibles.removeAll();
						ListaSeleccionados.removeAll();
						ListaDisponibles.setListData(disponibles.toArray());
						ListaSeleccionados.setListData(Seleccionados.toArray());
						Derecha.setEnabled(false);
					}
				}
			});
			Derecha.setBounds(236, 93, 89, 23);
			panel_1.add(Derecha);
			
			JButton Izquierda = new JButton("<<");
			Izquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ListaSeleccionados.getSelectedIndex() != -1) {
						disponibles.add(Seleccionados.get(ListaSeleccionados.getSelectedIndex()));
						Seleccionados.remove(ListaSeleccionados.getSelectedIndex());
						ListaDisponibles.removeAll();
						ListaSeleccionados.removeAll();;
						ListaDisponibles.setListData(disponibles.toArray());
						ListaSeleccionados.setListData(Seleccionados.toArray());
						Izquierda.setEnabled(false);
					}
				}
			});
			Izquierda.setBounds(236, 142, 89, 23);
			panel_1.add(Izquierda);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de finalizaci\u00F3n:");
			lblNewLabel_1.setBounds(279, 34, 103, 14);
			panel_1.add(lblNewLabel_1);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerDateModel(new Date(1618372800000L), null, null, Calendar.DAY_OF_YEAR));
			spinner_2.setBounds(392, 31, 161, 20);
			panel_1.add(spinner_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Proyectos Seleccionados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(366, 76, 172, 115);
			panel_1.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			ListaSeleccionados = new JList();
			panel_2.add(ListaSeleccionados, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton TerminarButton = new JButton("Registrar");
				TerminarButton.setActionCommand("OK");
				buttonPane.add(TerminarButton);
				getRootPane().setDefaultButton(TerminarButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar\r\n");
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
	
	
	private void CargarDisponibles(String seleccion) {
		disponibles = new ArrayList<String>();
		Seleccionados = new ArrayList<String>();
		if(seleccion.equalsIgnoreCase("<Todos>")){
		for(Proyecto P: Empresa.getInstance().getMisProyectos()) {
			disponibles.add("Nombre: "+P.getNombre()+" : "+"Tipo"+": "+Empresa.TipoDeProyecto(P));
		}
		}
		ListaDisponibles.removeAll();
		ListaDisponibles.setListData(disponibles.toArray());
	}
}
