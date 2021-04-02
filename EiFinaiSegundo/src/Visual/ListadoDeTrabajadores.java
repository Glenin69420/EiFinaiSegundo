package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


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

public class ListadoDeTrabajadores extends JDialog {

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
			ListadoDeTrabajadores dialog = new ListadoDeTrabajadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoDeTrabajadores() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ListaDeQuesos.class.getResource("/Imagenes/logo.png")));
		setTitle("Listado de trabajadores");
		setBounds(100, 100, 771, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 5, 742, 41);
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
					//CargarTabla2(Seleccion);

					
				}


			});
			CbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Jefe de proyecto.", "Programador.", "Planificador.", "Dise\u00F1ador."}));
			CbxTipo.setBounds(122, 17, 130, 21);
			panel.add(CbxTipo);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_1.setBounds(5, 49, 742, 434);
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
				String[] Headers = {"Codigo","Nombre","Apellidos","Edad","Sexo","Direccion"};
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//CargarTabla();
	//	CargarTabla2(Seleccion);
		
		
	}
	/*private void CargarTabla() {
		Model.setRowCount(0);
		Filas = new Object[Model.getColumnCount()];
		for (Trabajadora C : ///Queseria.getInstance().getMisQuesos()) {
			if(C != null) {	
				Filas[0] = C.getNombre();
				Filas[1] = Queseria.getInstance().TipoDeQueso(C);
				Filas[2] = C.getPrecioBase();
				Filas[3] = C.getPrecioUnitario();
				if(C instanceof Esfera) {
					Filas[4] = ((Esfera) C).getRadioE();
					Filas[5] = null;
					Filas[6] = null;
				}
				else {
					Filas[4] = ((Cilindro) C).getRadioC();
					Filas[5] = ((Cilindro) C).getLongitud();
					if(C instanceof CilindroHueco) {
						Filas[6] = ((CilindroHueco) C).getRadioI();
					}
					else {
						Filas[6] = null;
					}
				}
				Model.addRow(Filas);
			}
		}
		
	}
	private void CargarTabla2(String seleccion) {
		Model.setRowCount(0);
		Filas = new Object[Model.getColumnCount()];

		if(Seleccion.equalsIgnoreCase("<Todos>")) {
			CargarTabla();
		}else if(Seleccion.equalsIgnoreCase("Queso esferico")) {
			for(Quesos Q:Queseria.getInstance().getMisQuesos()) {
				if(Q instanceof Esfera) {
					Filas[0] = Q.getNombre();
					Filas[1] = Queseria.getInstance().TipoDeQueso(Q);
					Filas[2] = Q.getPrecioBase();
					Filas[3] = Q.getPrecioUnitario();
					Filas[4] = ((Esfera) Q).getRadioE();
					Model.addRow(Filas);
				}
			}


		}else if(Seleccion.equalsIgnoreCase("Queso cilindrico")) {
			for(Quesos Q:Queseria.getInstance().getMisQuesos()) {
				if(Q instanceof Cilindro && !(Q instanceof CilindroHueco)) {
					Filas[0] = Q.getNombre();
					Filas[1] = Queseria.getInstance().TipoDeQueso(Q);
					Filas[2] = Q.getPrecioBase();
					Filas[3] = Q.getPrecioUnitario();
					Filas[4] = ((Cilindro) Q).getRadioC();
					Filas[5] = ((Cilindro) Q).getLongitud();
					Model.addRow(Filas);
				}
			}
		}else if(Seleccion.equalsIgnoreCase("Queso cilindricoH")) {
			for(Quesos Q:Queseria.getInstance().getMisQuesos()) {
				if(Q instanceof CilindroHueco ) {
					Filas[0] = Q.getNombre();
					Filas[1] = Queseria.getInstance().TipoDeQueso(Q);
					Filas[2] = Q.getPrecioBase();
					Filas[3] = Q.getPrecioUnitario();
					Filas[4] = ((Cilindro) Q).getRadioC();
					Filas[5] = ((Cilindro) Q).getLongitud();
					Filas[6] = ((CilindroHueco) Q).getRadioI();
					Model.addRow(Filas);
				}
			}

		}

	}*/


}
