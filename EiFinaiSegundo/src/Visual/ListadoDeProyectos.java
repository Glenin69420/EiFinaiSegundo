package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Diseñador;
import Logico.Empresa;
import Logico.JefeProyecto;
import Logico.Planificadores;
import Logico.Trabajadora;
import Logico.Programadores;
import Logico.Proyecto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ListadoDeProyectos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel Model;
	private Object[] Filas;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton BtnEliminar;
	private int seleccion;
	private JComboBox CbxTipo;
	private String Seleccion = "<Todos>";

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoDeProyectos dialog = new ListadoDeProyectos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoDeProyectos() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ListaDeQuesos.class.getResource("/Imagenes/logo.png")));
		setTitle("Listado de trabajadores");
		setBounds(100, 100, 640, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 5, 1085, 41);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tipo de trabajador:");
			lblNewLabel.setBounds(10, 21, 110, 13);
			panel.add(lblNewLabel);
		}
		{
			CbxTipo = new JComboBox();
			CbxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seleccion = CbxTipo.getSelectedItem().toString();
					CargarTabla2(Seleccion);

					
				}


			});
			CbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Web", "Mobile", "Desktop"}));
			CbxTipo.setBounds(122, 17, 130, 21);
			panel.add(CbxTipo);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_1.setBounds(5, 49, 611, 434);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			scrollPane = new JScrollPane();
		
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.NORTH);
			
			table = new JTable();
			panel_1.add(table, BorderLayout.CENTER);
		}
		{
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				Model = new DefaultTableModel();
				String[] Headers = {"Codigo","Nombre","Tipo de Proyecto"};
				Model.setColumnIdentifiers(Headers);
				table.setModel(Model);
				table.setFont(new Font("Verdana", Font.PLAIN, 17));
				scrollPane.setFont(new Font("Verdana", Font.PLAIN, 19));
				scrollPane.setViewportView(table);
				
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BtnEliminar = new JButton("Eliminar");
				BtnEliminar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							seleccion = table.getSelectedRow();
							if(seleccion!=-1){
								BtnEliminar.setEnabled(true);
							}else{
								BtnEliminar.setEnabled(false);
							}
						
					}
				});
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						seleccion = table.getSelectedRow();
						if(seleccion!=-1){
							BtnEliminar.setEnabled(true);
						}else{
							BtnEliminar.setEnabled(false);
						}
					}
				});
			/*	BtnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este queso?", "Confirmación", JOptionPane.WARNING_MESSAGE);
						if(option==JOptionPane.OK_OPTION){
							Queseria.getInstance().eliminarQueso(Queseria.getInstance().BuscarQueso(Model.getValueAt(seleccion, 0).toString()));
							CargarTabla();
							BtnEliminar.setEnabled(false);
						
					}
					}
				});*/
				BtnEliminar.setActionCommand("OK");
				BtnEliminar.setEnabled(false);
				buttonPane.add(BtnEliminar);
				getRootPane().setDefaultButton(BtnEliminar);
			}
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
		CargarTabla();
		CargarTabla2(Seleccion);
		
		
	}
	private void CargarTabla() {
		Model.setRowCount(0);
		Filas = new Object[Model.getColumnCount()];
		for (Proyecto T : Empresa.getInstance().getMisProyectos()) {
			if(T != null) {	
				Filas[0] = T.getIndentificacion();
				Filas[1] = T.getNombre();
				Filas[2] = T.getTipoDeProyecto();
				
				Model.addRow(Filas);
			}
		}
		
	}
	private void CargarTabla2(String seleccion) {
		Model.setRowCount(0);
		Filas = new Object[Model.getColumnCount()];

		if(Seleccion.equalsIgnoreCase("<Todos>")) {
			CargarTabla();
		}else if(Seleccion.equalsIgnoreCase("Jefe de proyecto")) {
			for(Trabajadora T:Empresa.getInstance().getMisTrabajadores()) {
				if(T instanceof JefeProyecto) {
					Filas[0] = T.getIdentificador();
					Filas[1] = T.getNombre();
					Filas[2] = Empresa.getInstance().TipoDeTrabajador(T);
					Filas[3] = T.getApellido();
					Filas[4] = T.getDireccion();
					Filas[5] = ((JefeProyecto) T).getCantidadDeTrabajadores();
					Filas[6] = null;
					Filas[7] = null;
					Model.addRow(Filas);
				}
			}


		}else if(Seleccion.equalsIgnoreCase("Programador")) {
			for(Trabajadora T:Empresa.getInstance().getMisTrabajadores()) {
				if(T instanceof Programadores) {
					Filas[0] = T.getIdentificador();
					Filas[1] = T.getNombre();
					Filas[2] = Empresa.getInstance().TipoDeTrabajador(T);
					Filas[3] = T.getApellido();
					Filas[4] = T.getDireccion();
					Filas[5] = null;
					Filas[6] = ((Programadores) T).getLenguajeDeProgramacion();
					Filas[7] = null;
					Model.addRow(Filas);
				}
			}
		}else if(Seleccion.equalsIgnoreCase("Planificador")) {
			for(Trabajadora T:Empresa.getInstance().getMisTrabajadores()) {
				if(T instanceof Planificadores ) {
					Filas[0] = T.getIdentificador();
					Filas[1] = T.getNombre();
					Filas[2] = Empresa.getInstance().TipoDeTrabajador(T);
					Filas[3] = T.getApellido();
					Filas[4] = T.getDireccion();
					Filas[5] = null;
					Filas[6] = null;
					Filas[7] = ((Planificadores) T).getCantidadDeDias();
					Model.addRow(Filas);
				}
			}

		}else if(Seleccion.equalsIgnoreCase("Diseñador")) {
			for(Trabajadora T:Empresa.getInstance().getMisTrabajadores()) {
				if(T instanceof Diseñador  ) {
					Filas[0] = T.getIdentificador();
					Filas[1] = T.getNombre();
					Filas[2] = Empresa.getInstance().TipoDeTrabajador(T);
					Filas[3] = T.getApellido();
					Filas[4] = T.getDireccion();
					Filas[5] = null;
					Filas[6] = null;
					Filas[7] = null;
					Model.addRow(Filas);
				}
			}

		}

	}


}
