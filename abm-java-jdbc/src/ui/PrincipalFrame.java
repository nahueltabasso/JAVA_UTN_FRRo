package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PrincipalFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroDocumento;
	private JTextField textFieldNombrePersona;
	private JTextField textFieldTipoDocumento;
	private JTextField textFieldApellidoPersona;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JTextField textFieldEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame frame = new PrincipalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNroDocumento = new JTextField();
		textFieldNroDocumento.setBounds(190, 104, 132, 22);
		contentPane.add(textFieldNroDocumento);
		textFieldNroDocumento.setColumns(10);
		
		textFieldNombrePersona = new JTextField();
		textFieldNombrePersona.setColumns(10);
		textFieldNombrePersona.setBounds(142, 24, 180, 22);
		contentPane.add(textFieldNombrePersona);
		
		textFieldTipoDocumento = new JTextField();
		textFieldTipoDocumento.setColumns(10);
		textFieldTipoDocumento.setBounds(142, 104, 36, 22);
		contentPane.add(textFieldTipoDocumento);
		
		textFieldApellidoPersona = new JTextField();
		textFieldApellidoPersona.setColumns(10);
		textFieldApellidoPersona.setBounds(142, 59, 180, 22);
		contentPane.add(textFieldApellidoPersona);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(142, 144, 180, 22);
		contentPane.add(textFieldEmail);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(142, 179, 180, 22);
		contentPane.add(textFieldTelefono);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(142, 214, 180, 22);
		contentPane.add(textFieldEstado);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setBounds(45, 27, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(45, 62, 73, 16);
		contentPane.add(lblApellido);
		
		JLabel lblTipoYNro = new JLabel("TIPO Y NRO DNI:");
		lblTipoYNro.setBounds(45, 107, 85, 16);
		contentPane.add(lblTipoYNro);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(45, 147, 73, 16);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(45, 182, 73, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(45, 217, 73, 16);
		contentPane.add(lblEstado);
		
		JButton btnNewButton = new JButton("Modificar Datos");
		btnNewButton.setBounds(44, 257, 148, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(240, 257, 148, 25);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblDatosDeLa = new JLabel("DATOS DE LA PERSONA");
		lblDatosDeLa.setBounds(142, 0, 180, 16);
		contentPane.add(lblDatosDeLa);
	}
}
