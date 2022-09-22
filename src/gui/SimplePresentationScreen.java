package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblNewLabel_LU;
	private JTextField textField_LU;
	private JLabel lblNewLabel_Apellido;
	private JTextField textField_Apellido;
	private JTextField textField_Nombre;
	private JTextField textField_Email;
	private JTextField textField_URL;
	private JLabel lblNewLabel_Horario;
	private JPanel panel_Imagen;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 250));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		lblNewLabel_LU = new JLabel("LU");
		lblNewLabel_LU.setBounds(10, 15, 16, 17);
		lblNewLabel_LU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_LU.setHorizontalAlignment(SwingConstants.LEFT);
		tabInformation.add(lblNewLabel_LU);
		
		textField_LU = new JTextField();
		textField_LU.setBounds(100, 15, 315, 20);
		tabInformation.add(textField_LU);
		textField_LU.setColumns(10);
		textField_LU.setText("" + studentData.getId());
		
		
		lblNewLabel_Apellido = new JLabel("Apellido");
		lblNewLabel_Apellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Apellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_Apellido.setBounds(10, 46, 60, 17);
		tabInformation.add(lblNewLabel_Apellido);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(100, 46, 315, 20);
		tabInformation.add(textField_Apellido);
		textField_Apellido.setText(studentData.getLastName());
		
		
		JLabel lblNewLabel_Nombre = new JLabel("Nombre");
		lblNewLabel_Nombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_Nombre.setBounds(10, 77, 60, 17);
		tabInformation.add(lblNewLabel_Nombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(100, 77, 315, 20);
		tabInformation.add(textField_Nombre);
		textField_Nombre.setText(studentData.getFirstName());
		
		
		JLabel lblNewLabel_Mail = new JLabel("E-mail");
		lblNewLabel_Mail.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_Mail.setBounds(10, 105, 60, 17);
		tabInformation.add(lblNewLabel_Mail);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(100, 105, 315, 20);
		tabInformation.add(textField_Email);
		textField_Email.setText(studentData.getMail());
		
		
		JLabel lblNewLabel_Git = new JLabel("GitHub URL");
		lblNewLabel_Git.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Git.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_Git.setBounds(10, 133, 80, 17);
		tabInformation.add(lblNewLabel_Git);
		
		textField_URL = new JTextField();
		textField_URL.setColumns(10);
		textField_URL.setBounds(100, 133, 315, 20);
		tabInformation.add(textField_URL);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		textField_URL.setText(studentData.getGithubURL());
		
		
		LocalTime ahora = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate hoy = LocalDate.now();
		
		lblNewLabel_Horario = new JLabel("Esta ventana fue generada el " + hoy.format(f) + " a las: " + ahora + "hs.");
		contentPane.add(lblNewLabel_Horario, BorderLayout.SOUTH);
		
		panel_Imagen = new JPanel();
		contentPane.add(panel_Imagen, BorderLayout.CENTER);
		
		ImageIcon i = new javax.swing.ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		panel_Imagen.setLayout(null);
		JLabel pic = new JLabel(i);
		pic.setBounds(10, 11, 149, 175);
		panel_Imagen.add(pic);
		
		ImageIcon i2 = new javax.swing.ImageIcon(getClass().getResource("/images/tdp.png"));
		this.setIconImage(i2.getImage());
		
		
		
	}
}
