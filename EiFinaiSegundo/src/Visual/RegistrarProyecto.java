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

public class RegistrarProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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
		getContentPane().setForeground(Color.GRAY);
		setTitle("Proyectos");
		setBounds(100, 100, 554, 529);
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
			
			textField = new JTextField();
			textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			textField.setBounds(270, 91, 247, 19);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton = new JButton("Registrar");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLUE);
			btnNewButton.setBounds(111, 439, 98, 21);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setBounds(320, 439, 98, 21);
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("Tipo de proyecto:");
			lblNewLabel_3.setBounds(166, 128, 98, 13);
			panel.add(lblNewLabel_3);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			comboBox.setBounds(270, 124, 247, 21);
			panel.add(comboBox);
			
			JLabel lblNewLabel_4 = new JLabel("Descripcion:");
			lblNewLabel_4.setBounds(166, 162, 85, 13);
			panel.add(lblNewLabel_4);
			
			JTextArea textArea = new JTextArea();
			textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
			textArea.setBounds(270, 162, 247, 58);
			panel.add(textArea);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Empleados disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(20, 238, 195, 164);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JList list = new JList();
			panel_2.add(list, BorderLayout.CENTER);
			
			JButton btnNewButton_2 = new JButton(">>");
			btnNewButton_2.setBounds(225, 280, 85, 21);
			panel.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("<<");
			btnNewButton_3.setBounds(225, 320, 85, 21);
			panel.add(btnNewButton_3);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(320, 238, 197, 164);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			JList list_1 = new JList();
			list_1.setBorder(new TitledBorder(null, "Empleados seleccionados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.add(list_1, BorderLayout.CENTER);
		}
	}
	//xd
}
