package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Diseñador;
import Logico.Empresa;
import Logico.JefeProyecto;
import Logico.Planificadores;
import Logico.Programadores;
import Logico.Proyecto;
import Logico.Trabajadora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ProyectoPrincipal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	public Image ImagenFondo;
	public URL Fondo;
	private String Hola;


	/**
	 * Launch the application.
	 */
/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoPrincipal frame = new ProyectoPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ProyectoPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Empresa.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProyectoPrincipal.class.getResource("/Imagenes/empresa.png")));
		setTitle("Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1536, 821);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Trabajadores");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeTrabajadores T = new RegistroDeTrabajadores();
				T.setVisible(true);
				T.setModal(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Clientes");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeCliente C = new RegistroDeCliente();
				C.setVisible(true);
				C.setModal(false);
	
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Listados");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Trabajadores");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeTrabajadores L = new ListadoDeTrabajadores();
				L.setVisible(true);
				L.setModal(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clientes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeClientes C = new ListadoDeClientes();
				C.setVisible(true);
				C.setModal(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("proyectos");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeProyectos P = new ListadoDeProyectos();
				P.setVisible(true);
				P.setResizable(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Contratos");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeContratos C = new ListadoDeContratos();
				C.setVisible(true);
				C.setResizable(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_3 = new JMenu("Creaciones");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Proyecto");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProyecto P = new RegistrarProyecto();
				P.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Contratos");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeContrato C = new RegistroDeContrato();
				C.setVisible(true);
				C.setResizable(false);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Contrato");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarImformacion I = new ConsultarImformacion();
				I.setVisible(true);
				I.setModal(false);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 10, 671, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Grafico pastel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficoTrabajadores();
			}
		});
		btnNewButton.setBounds(293, 74, 138, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProyectoPrincipal.class.getResource("/Imagenes/xDlolll.jpg")));
		lblNewLabel.setBounds(42, 123, 629, 504);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(900, 10, 831, 749);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Grafico de barras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficoProyectos();
			}
		});
		btnNewButton_1.setBounds(418, 79, 150, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ProyectoPrincipal.class.getResource("/Imagenes/barras.png")));
		lblNewLabel_1.setBounds(133, 162, 670, 443);
		panel_1.add(lblNewLabel_1);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		dim= getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-45);
		setLocationRelativeTo(null);
	}
	
	private void GraficoTrabajadores() {
        DefaultPieDataset data = new DefaultPieDataset();
        int jefeProyectos = 0;
        int programadores = 0;
        int planificadores = 0;
        int disennador = 0;
        for(Trabajadora t : Empresa.getInstance().getMisTrabajadores()) {
            if(t != null) {
                if(t instanceof JefeProyecto) {
                    jefeProyectos++;
                }
                if(t instanceof Programadores) {
                    programadores++;
                }
                if(t instanceof Planificadores) {
                    planificadores++;
                }
                if(t instanceof Diseñador) {
                    disennador++; 
                }
            }
        }
        data.setValue("Jefes de proyectos", jefeProyectos);
        data.setValue("Programadores", programadores);
        data.setValue("planificadores", planificadores);
        data.setValue("Diseñadores", disennador);

        JFreeChart chart = ChartFactory.createPieChart("Trabajadores", data, true, true, false);

        ChartFrame frame = new ChartFrame("Información sobre trabajadores", chart);
        frame.pack();
        frame.setVisible(true);
    }

    private void GraficoProyectos() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        int web = 0;
        int movil = 0;
        int desktop = 0;
        for(Proyecto t : Empresa.getInstance().getMisProyectos()) {
            if(t != null) {
                if(t.getTipoDeProyecto().equalsIgnoreCase("Web")) {
                    web++;
                }
                if(t.getTipoDeProyecto().equalsIgnoreCase("Movil")) {
                    movil++;
                }
                if(t.getTipoDeProyecto().equalsIgnoreCase("Web")) {
                    desktop++;
                }
            }
        }
        data.setValue(web, "Proyectos webs", "");
        data.setValue(movil, "proyectos para moviles", "");
        data.setValue(desktop, "proyectos para desktop", "");

        JFreeChart chart = ChartFactory.createBarChart3D("Tipos de proyectos disponibles", "Tipos de proyectos", "Cantidad", 
                data);

        ChartFrame frame = new ChartFrame("Información sobre trabajadores", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
