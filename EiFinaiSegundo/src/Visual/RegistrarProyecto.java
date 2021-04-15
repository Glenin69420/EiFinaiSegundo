package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logico.Empresa;
import Logico.Proyecto;
import Logico.Trabajadora;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.ListSelectionModel;
import java.awt.Toolkit;

public class RegistrarProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtNombre;
	private int index = -1;
	private int indexBack = -1;
	private JList ListaSeleccionados;
	private JList ListaDisponibles;
	private ArrayList<String> disponibles;
	private ArrayList<String> Seleccionados;
	private String Seleccion = "<Todos>";
	private JButton BtnRegistrar;
	private JButton BtnVolver;
	private JComboBox TipoCombo;
	private JTextArea TxtArea;
	private String seleccion = "<Web>";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarProyecto dialog = new RegistrarProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarProyecto.class.getResource("/Imagenes/proyecto.png")));
		getContentPane().setForeground(Color.GRAY);
		setTitle("Proyectos");
		setBounds(100, 100, 554, 560);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Creacion de proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarProyecto.class.getResource("/Imagenes/proyecto (1).png")));
			lblNewLabel.setBounds(20, 77, 140, 128);
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.BLUE);
			panel_1.setBounds(9, 18, 508, 49);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Proyectos");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 28));
			lblNewLabel_1.setBounds(10, 10, 456, 29);
			panel_1.add(lblNewLabel_1);
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(166, 93, 61, 13);
			panel.add(lblNewLabel_2);
			
			TxtNombre = new JTextField();
			TxtNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtNombre.setBounds(270, 91, 247, 19);
			panel.add(TxtNombre);
			TxtNombre.setColumns(10);
			
			JButton BtnCrar = new JButton("Registrar");
			BtnCrar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					ArrayList<Trabajadora> P = new ArrayList<Trabajadora>();
					for (int i = 0; i <Seleccionados.size(); i++) {
						String[] splits = Seleccionados.get(i).split(":");
					    P.add(Empresa.getInstance().BuscarTrabajador(splits[1]));
					    Empresa.getInstance().EliminarTrabajador(Empresa.getInstance().BuscarTrabajador(splits[1]));
					}
					String aux = ""+Empresa.ProyectoCod++;
					Proyecto p = new Proyecto(TxtNombre.getText(), aux, TxtArea.getText(), P,TipoCombo.getSelectedItem().toString());
					Empresa.getInstance().InsertarProyecto(p);
					JOptionPane.showMessageDialog(null, "El proyecto se ha registrado", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			BtnCrar.setForeground(Color.WHITE);
			BtnCrar.setBackground(Color.BLUE);
			BtnCrar.setBounds(111, 468, 98, 21);
			panel.add(BtnCrar);
			
			JButton btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setBounds(320, 468, 98, 21);
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("Tipo de proyecto:");
			lblNewLabel_3.setBounds(166, 128, 98, 13);
			panel.add(lblNewLabel_3);
			
			TipoCombo = new JComboBox();
				
			
			TipoCombo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "<Wed>", "<Mobile>", "<Desktop>"}));
			TipoCombo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TipoCombo.setBounds(270, 124, 247, 21);
			panel.add(TipoCombo);
			
			JLabel lblNewLabel_4 = new JLabel("Descripcion:");
			lblNewLabel_4.setBounds(166, 162, 85, 13);
			panel.add(lblNewLabel_4);
			
			TxtArea = new JTextArea();
			TxtArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			TxtArea.setBounds(270, 162, 247, 58);
			panel.add(TxtArea);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Empleados disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(20, 265, 195, 164);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			ListaDisponibles = new JList();
			ListaDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index = ListaDisponibles.getSelectedIndex();
					if(index!=-1) {
						BtnRegistrar.setEnabled(true);
						}
				}
			});
			ListaDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			panel_2.add(ListaDisponibles, BorderLayout.CENTER);
			
			BtnRegistrar = new JButton(">>");
			BtnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ListaDisponibles.getSelectedIndex()!=-1) {
						Seleccionados.add(disponibles.get(ListaDisponibles.getSelectedIndex()));
						disponibles.remove(ListaDisponibles.getSelectedIndex());
						ListaDisponibles.removeAll();
						ListaSeleccionados.removeAll();
						ListaDisponibles.setListData(disponibles.toArray());
						ListaSeleccionados.setListData(Seleccionados.toArray());
						BtnRegistrar.setEnabled(false);
						
					}
					
				}
			});
			BtnRegistrar.setEnabled(false);
			BtnRegistrar.setBounds(225, 314, 85, 21);
			panel.add(BtnRegistrar);
			
			BtnVolver = new JButton("<<");
			BtnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ListaSeleccionados.getSelectedIndex() != -1) {
						disponibles.add(Seleccionados.get(ListaSeleccionados.getSelectedIndex()));
						Seleccionados.remove(ListaSeleccionados.getSelectedIndex());
						ListaDisponibles.removeAll();
						ListaSeleccionados.removeAll();;
						ListaDisponibles.setListData(disponibles.toArray());
						ListaSeleccionados.setListData(Seleccionados.toArray());
						BtnVolver.setEnabled(false);
					}
				}
			});
			BtnVolver.setEnabled(false);
			BtnVolver.setBounds(225, 361, 85, 21);
			panel.add(BtnVolver);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Empleados seleccionados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(320, 265, 195, 164);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			ListaSeleccionados = new JList();
			ListaSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListaSeleccionados.setLocation(0, 265);
			ListaSeleccionados.setSize(195, 164);
			ListaSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(ListaSeleccionados.getSelectedIndex()!=-1) {
						BtnVolver.setEnabled(true);
					}
					
					
				}
			});
			panel_3.add(ListaSeleccionados, BorderLayout.CENTER);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "<Jefe de proyecto>", "<Programador>", "<Planificador>", "<Dise\u00F1ador>"}));
			comboBox.setBounds(20, 234, 189, 21);
			panel.add(comboBox);
		}
		CargarDisponibles(Seleccion);
	}
	private void CargarDisponibles(String seleccion) {
		disponibles = new ArrayList<String>();
		Seleccionados = new ArrayList<String>();
		if(seleccion.equalsIgnoreCase("<Todos>")){
		for(Trabajadora P:Empresa.getInstance().getMisTrabajadores()) {
			disponibles.add("Nombre:"+P.getNombre()+":"+"Tipo"+":"+Empresa.TipoDeTrabajador(P));
		}
		}
		ListaDisponibles.removeAll();
		ListaDisponibles.setListData(disponibles.toArray());
	}
}
