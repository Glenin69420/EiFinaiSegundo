package Visual;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Empresa;
import Logico.Cliente;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class ImformacionDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnEliminar;
	private int seleccion;
	public static void main(String[] args) {
		try {
			ImformacionDeClientes dialog = new ImformacionDeClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public ImformacionDeClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImformacionDeClientes.class.getResource("/Imagenes/usuario-especialista.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ListaDeFacturas.class.getResource("/Imagenes/factura.png")));
		//setFont(new Font("Arial", Font.PLAIN, 5));
		setTitle("Clientes registrados.");
		setBounds(100, 100, 700, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		modelo = new DefaultTableModel();
		String[] columns = {"Codigo","Nombre","Apellidos","Telefono","Direccion"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 17));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccion = table.getSelectedRow();
				if(seleccion!=-1){
					btnEliminar.setEnabled(true);
				}else{
					btnEliminar.setEnabled(false);
				}
			}
		});
		table.setModel(modelo);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				//cancelButton.setFont(cancelButton.getFont().deriveFont(cancelButton.getFont().getSize() + 9f));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollPane.setFont(new Font("Verdana", Font.PLAIN, 19));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		CargarTabla();
	}
	
	private void CargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for (Cliente C : Empresa.getInstance().getMisClientes()) {
			fila[0] = C.getIdentificacion();
			fila[1] = C.getNombre();
			fila[2] = C.getApellidos();
			fila[3] = C.getTelefono();
			fila[4] = C.getDireccion();					
					
			
				modelo.addRow(fila);
			}
		}
		
	}



