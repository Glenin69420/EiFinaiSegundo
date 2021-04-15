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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Logico.Cliente;
import Logico.Contrato;
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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class RegistroDeContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCliente;
	private int index = -1;
	private int indexBack = -1;
	private ArrayList<String> disponibles;
	private ArrayList<String> Seleccionados;
	private JList ListaDisponibles;
	private JList ListaSeleccionados;
	private JSpinner SpnFinal;
	private JComboBox comboBox;
	private JTextField TxtNombre;
	private JTextField TxtCodigo;
	private JSpinner SpnInicio;
	private JTextField TxtPrecio;
	private JButton BtnRegistrar;
	private JButton BtnVolver;
	private String Seleccion = "<Todos>";
	private String seleccion = "<Web>";
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
		setTitle("Creacion de contrato");
		setBounds(100, 100, 598, 648);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setForeground(Color.YELLOW);
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.YELLOW);
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 82, 558, 54);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigoCliente = new JLabel("C\u00F3digo del cliente:\r\n");
		lblCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigoCliente.setBounds(10, 29, 91, 14);
		panel.add(lblCodigoCliente);
		{
			TxtCliente = new JTextField();
			TxtCliente.setBounds(100, 26, 144, 20);
			panel.add(TxtCliente);
			TxtCliente.setColumns(10);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del contrato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 148, 558, 439);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel Trabajadores = new JLabel("Tipos de proyectos:");
				Trabajadores.setBounds(10, 189, 111, 14);
				panel_1.add(Trabajadores);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Web", "Movil", "Desktop"}));
				comboBox.setBounds(128, 186, 122, 21);
				panel_1.add(comboBox);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "Proyectos Registrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(10, 220, 206, 115);
				panel_1.add(panel_2);
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
				panel_2.add(ListaDisponibles, BorderLayout.CENTER);
			}
			
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
						float precioTotal = 0;
						for(int i=0; i<Seleccionados.size();i++) {
							String[] aux = Seleccionados.get(i).split(":");
							precioTotal+= Empresa.getInstance().BuscarProyecto(aux[1]).getTotal();
									
						}
						TxtPrecio.setText(""+precioTotal);
						
					}
				}
			});
			BtnRegistrar.setBounds(226, 249, 89, 23);
			panel_1.add(BtnRegistrar);
			
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
						float precioTotal = 0;
						for(int i=0; i<Seleccionados.size();i++) {
							String[] aux = Seleccionados.get(i).split(":");
							precioTotal+= Empresa.getInstance().BuscarProyecto(aux[1]).getTotal();
							
							
							
							
							
						}
						TxtPrecio.setText(""+precioTotal);
					}
				}
			});
			BtnVolver.setBounds(226, 283, 89, 23);
			panel_1.add(BtnVolver);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de finalizaci\u00F3n:");
			lblNewLabel_1.setBounds(370, 124, 122, 14);
			panel_1.add(lblNewLabel_1);
			
			SpnFinal = new JSpinner();
			SpnFinal.setModel(new SpinnerDateModel(new Date(1618459200000L), null, null, Calendar.DAY_OF_YEAR));
			SpnFinal.setBounds(370, 139, 161, 20);
			panel_1.add(SpnFinal);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Proyectos Seleccionados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(331, 220, 206, 115);
			panel_1.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			ListaSeleccionados = new JList();
			ListaSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(ListaSeleccionados.getSelectedIndex()!=-1) {
						BtnVolver.setEnabled(true);
					}
					
				}
			});
			panel_2.add(ListaSeleccionados, BorderLayout.CENTER);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistroDeContrato.class.getResource("/Imagenes/documentos-oficiales.png")));
			lblNewLabel.setBounds(10, 25, 138, 134);
			panel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre:");
			lblNewLabel_3.setBounds(158, 38, 52, 13);
			panel_1.add(lblNewLabel_3);
			
			TxtNombre = new JTextField();
			TxtNombre.setBounds(158, 55, 373, 19);
			panel_1.add(TxtNombre);
			TxtNombre.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Codigo:");
			lblNewLabel_4.setBounds(158, 83, 45, 13);
			panel_1.add(lblNewLabel_4);
			
			TxtCodigo = new JTextField();
			TxtCodigo.setEditable(false);
			TxtCodigo.setBounds(158, 96, 96, 19);
			panel_1.add(TxtCodigo);
			TxtCodigo.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Fecha de inicio:");
			lblNewLabel_5.setBounds(158, 125, 89, 13);
			panel_1.add(lblNewLabel_5);
			
		
			SpnInicio = new JSpinner();
			SpnInicio.setBounds(158, 139, 161, 20);
			SpnInicio.setModel(new SpinnerDateModel(new Date(1618459200000L), null, null, Calendar.DAY_OF_YEAR));
			panel_1.add(SpnInicio);
			
			JButton btnNewButton = new JButton("Registrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Proyecto> P = new ArrayList<Proyecto>();
					for (int i = 0; i <Seleccionados.size(); i++) {
						String[] splits = Seleccionados.get(i).split(":");
					    P.add(Empresa.getInstance().BuscarProyecto(splits[1]));
					    Empresa.getInstance().ElimininarProyectos(Empresa.getInstance().BuscarProyecto(splits[1]));
					}
					String aux = "C-"+Empresa.ContratoCod++;
					Contrato p = new Contrato(TxtNombre.getText(), aux, Empresa.getInstance().BuscarCliente(TxtCliente.getText()), (Date)SpnInicio.getValue(),
							(Date)SpnFinal.getValue());
					float Cambio = Float.parseFloat(TxtPrecio.getText());
					p.setTotal(Cambio*30);
					Empresa.getInstance().InsertarContrato(p);
					JOptionPane.showMessageDialog(null, "Se ha concretado el contrato", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
					
					
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLUE);
			btnNewButton.setBounds(128, 395, 88, 21);
			panel_1.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setBounds(343, 395, 85, 21);
			panel_1.add(btnNewButton_1);
			
			JLabel lblNewLabel_6 = new JLabel("Saldo total:");
			lblNewLabel_6.setBounds(331, 352, 70, 13);
			panel_1.add(lblNewLabel_6);
			
			TxtPrecio = new JTextField();
			TxtPrecio.setBounds(398, 349, 133, 19);
			panel_1.add(TxtPrecio);
			TxtPrecio.setColumns(10);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setForeground(Color.BLUE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 558, 62);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Contratos");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 586, 42);
		panel_1.add(lblNewLabel_2);
		CargarDisponibles(Seleccion);
	}
	
	
	private void CargarDisponibles(String seleccion) {
		disponibles = new ArrayList<String>();
		Seleccionados = new ArrayList<String>();
		if(seleccion.equalsIgnoreCase("<Todos>")){
		for(Proyecto P: Empresa.getInstance().getMisProyectos()) {
			disponibles.add("Nombre:"+P.getNombre()+":"+"Tipo"+":"+P.getTipoDeProyecto());
		}
		}
		ListaDisponibles.removeAll();
		ListaDisponibles.setListData(disponibles.toArray());
	}
}
