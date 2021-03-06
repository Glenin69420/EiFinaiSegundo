package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Dise?ador;
import Logico.Empresa;
import Logico.JefeProyecto;
import Logico.Planificadores;
import Logico.Programadores;
import Logico.Trabajadora;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Window.Type;

public class RegistroDeTrabajadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TxtCodigo;
	private JTextField TxtNombre;
	private JTextField TxtApellido;
	private JTextField TxtSexo;
	private JTextField TxtDireccion;
	private JRadioButton RbtnJefe;
	private JRadioButton RbtnProgramador;
	private JRadioButton RbtnPlanificador;
	private JRadioButton RbtnDisenador;
	private JPanel PanelJefe;
	private JPanel PanelProgramador;
	private JPanel PanelPlanificador;
	private JTextField TxtLenguaje;
	private JSpinner SpnEdad;
	private JSpinner SpnTrabajador;
	private JSpinner SpnDias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroDeTrabajadores dialog = new RegistroDeTrabajadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroDeTrabajadores() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroDeTrabajadores.class.getResource("/Imagenes/cliente (2).png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroDeTrabajadores.class.getResource("/Imagenes/cliente (1).png")));
		setTitle("Registro de trabajador");
		setResizable(false);
		setBounds(100, 100, 706, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.BLACK);
			panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Imformacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 79, 662, 135);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 26, 45, 13);
			panel_1.add(lblNewLabel);
			
			TxtCodigo = new JTextField();
			TxtCodigo.setEditable(false);
			TxtCodigo.setBounds(65, 23, 96, 19);
			panel_1.add(TxtCodigo);
			TxtCodigo.setColumns(10);
			TxtCodigo.setText("T-"+Trabajadora.Codigo);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 56, 48, 13);
			panel_1.add(lblNewLabel_1);
			
			TxtNombre = new JTextField();
			TxtNombre.setBounds(65, 53, 96, 19);
			panel_1.add(TxtNombre);
			TxtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(10, 86, 50, 13);
			panel_1.add(lblNewLabel_2);
			
			TxtApellido = new JTextField();
			TxtApellido.setBounds(65, 83, 96, 19);
			panel_1.add(TxtApellido);
			TxtApellido.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Edad:");
			lblNewLabel_3.setBounds(247, 26, 45, 13);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Sexo:");
			lblNewLabel_4.setBounds(247, 56, 45, 13);
			panel_1.add(lblNewLabel_4);
			
			TxtSexo = new JTextField();
			TxtSexo.setBounds(315, 53, 96, 19);
			panel_1.add(TxtSexo);
			TxtSexo.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Direccion:");
			lblNewLabel_5.setBounds(247, 86, 60, 13);
			panel_1.add(lblNewLabel_5);
			
			TxtDireccion = new JTextField();
			TxtDireccion.setBounds(315, 83, 96, 19);
			panel_1.add(TxtDireccion);
			TxtDireccion.setColumns(10);
			
			SpnEdad = new JSpinner();
			SpnEdad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			SpnEdad.setBounds(315, 23, 96, 20);
			panel_1.add(SpnEdad);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.BLACK);
			panel_2.setBorder(new TitledBorder(null, "Tipo de trabajador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 10, 662, 59);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			RbtnJefe = new JRadioButton("Jefe de proyecto.");
			RbtnJefe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelJefe.setVisible(true);
					PanelProgramador.setVisible(false);
					PanelPlanificador.setVisible(false);
					RbtnPlanificador.setSelected(false);
					RbtnProgramador.setSelected(false);
					RbtnDisenador.setSelected(false);
					
				}
			});
			RbtnJefe.setSelected(true);
			RbtnJefe.setBounds(20, 19, 140, 21);
			panel_2.add(RbtnJefe);
			
			RbtnProgramador = new JRadioButton("Programadores.");
			RbtnProgramador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelJefe.setVisible(false);
					PanelProgramador.setVisible(true);
					PanelPlanificador.setVisible(false);
					RbtnPlanificador.setSelected(false);
					RbtnProgramador.setSelected(true);
					RbtnDisenador.setSelected(false);
					RbtnJefe.setSelected(false);
				}
			});
			RbtnProgramador.setBounds(180, 19, 140, 21);
			panel_2.add(RbtnProgramador);
			
			RbtnPlanificador = new JRadioButton("Planificadores.");
			RbtnPlanificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelJefe.setVisible(false);
					PanelProgramador.setVisible(false);
					PanelPlanificador.setVisible(true);
					RbtnPlanificador.setSelected(true);
					RbtnProgramador.setSelected(false);
					RbtnDisenador.setSelected(false);
					RbtnJefe.setSelected(false);
				}
			});
			RbtnPlanificador.setBounds(340, 19, 140, 21);
			panel_2.add(RbtnPlanificador);
			
			RbtnDisenador = new JRadioButton("Dise\u00F1adores.");
			RbtnDisenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelJefe.setVisible(false);
					PanelProgramador.setVisible(false);
					PanelPlanificador.setVisible(false);
					RbtnPlanificador.setSelected(false);
					RbtnProgramador.setSelected(false);
					RbtnDisenador.setSelected(true);
					RbtnJefe.setSelected(false);
				}
			});
			RbtnDisenador.setBounds(500, 19, 140, 21);
			panel_2.add(RbtnDisenador);
			
			PanelJefe = new JPanel();
			PanelJefe.setBorder(new TitledBorder(null, "Jefe de proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelJefe.setBounds(10, 224, 662, 59);
			panel.add(PanelJefe);
			PanelJefe.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Cantidad de trabajadores:");
			lblNewLabel_6.setBounds(10, 25, 148, 13);
			PanelJefe.add(lblNewLabel_6);
			
			SpnTrabajador = new JSpinner();
			SpnTrabajador.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			SpnTrabajador.setBounds(160, 23, 96, 19);
			PanelJefe.add(SpnTrabajador);
			
			PanelProgramador = new JPanel();
			PanelProgramador.setVisible(false);
			PanelProgramador.setBorder(new TitledBorder(null, "Programadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelProgramador.setBounds(10, 224, 662, 59);
			panel.add(PanelProgramador);
			PanelProgramador.setLayout(null);
			
			JLabel lblNewLabel_7 = new JLabel("Lenguajes de programacion:");
			lblNewLabel_7.setBounds(10, 25, 165, 13);
			PanelProgramador.add(lblNewLabel_7);
			
			TxtLenguaje = new JTextField();
			TxtLenguaje.setBounds(175, 23, 96, 19);
			PanelProgramador.add(TxtLenguaje);
			TxtLenguaje.setColumns(10);
			
			PanelPlanificador = new JPanel();
			PanelPlanificador.setVisible(false);
			PanelPlanificador.setBorder(new TitledBorder(null, "Planificadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelPlanificador.setBounds(10, 224, 662, 59);
			panel.add(PanelPlanificador);
			PanelPlanificador.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("Cantidad de dias:");
			lblNewLabel_8.setBounds(10, 25, 148, 13);
			PanelPlanificador.add(lblNewLabel_8);
			
			SpnDias = new JSpinner();
			SpnDias.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			SpnDias.setBounds(112, 23, 96, 19);
			PanelPlanificador.add(SpnDias);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Trabajadora Trabajador = null;
						
						if(RbtnJefe.isSelected()) {
							Trabajador = new JefeProyecto(TxtCodigo.getText(), TxtNombre.getText(), TxtApellido.getText(), (int) Float.parseFloat(SpnEdad.getValue().toString()), TxtSexo.getText(), TxtDireccion.getText(),
									(int) Float.parseFloat(SpnTrabajador.getValue().toString()));
						}
						
						if(RbtnProgramador.isSelected()) {
							Trabajador = new Programadores(TxtCodigo.getText(), TxtNombre.getText(), TxtApellido.getText(), TxtDireccion.getText(), TxtSexo.getText(),
									(int) Float.parseFloat(SpnEdad.getValue().toString()), TxtLenguaje.getText());
							
						}
						
						if(RbtnPlanificador.isSelected()) {
							Trabajador = new Planificadores(TxtCodigo.getText(), TxtNombre.getText(), TxtApellido.getText(), TxtDireccion.getText(),
									TxtSexo.getText(), (int) Float.parseFloat(SpnEdad.getValue().toString()),  (int) Float.parseFloat(SpnDias.getValue().toString()));
							
						}
						
						if(RbtnDisenador.isSelected()) {
							Trabajador = new Dise?ador(TxtCodigo.getText(), TxtNombre.getText(), TxtApellido.getText(),  TxtDireccion.getText(),
									TxtSexo.getText(), (int) Float.parseFloat(SpnEdad.getValue().toString()));
							
						}
						
						Empresa.getInstance().InsertarTrabajador(Trabajador);
						clean();
						JOptionPane.showMessageDialog(null, "El Trabajdor ha sido registrado con exito. ", "Registro satisfactorio", JOptionPane.INFORMATION_MESSAGE);
						
						
	


					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
	private void clean() {
		TxtCodigo.setText("T-"+Trabajadora.Codigo);
		TxtNombre.setText("");
		TxtApellido.setText("");
		TxtSexo.setText("");
		TxtDireccion.setText("");
		SpnEdad.setValue(1);
		SpnDias.setValue(1);
		SpnTrabajador.setValue(1);
		TxtLenguaje.setText("");
		RbtnJefe.setSelected(true);
		PanelJefe.setVisible(true);
		PanelProgramador.setVisible(false);
		PanelPlanificador.setVisible(false);
		RbtnProgramador.setSelected(false);
		RbtnPlanificador.setSelected(false);
		RbtnDisenador.setSelected(false);
	
	}
}
