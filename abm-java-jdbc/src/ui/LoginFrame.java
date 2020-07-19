package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelPassword.setBounds(100, 225, 158, 33);
		contentPane.add(labelPassword);
		
		JLabel labelTituloVentana_1 = new JLabel("LOGIN");
		labelTituloVentana_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		labelTituloVentana_1.setBounds(316, 91, 81, 33);
		contentPane.add(labelTituloVentana_1);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNombreUsuario.setBounds(100, 178, 158, 33);
		contentPane.add(lblNombreUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setText("Ingrese nombre de usuario");
		textFieldUsuario.setBounds(270, 186, 247, 25);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton buttonLogin = new JButton("Iniciar Sesion");
		buttonLogin.setBackground(Color.GREEN);
		buttonLogin.setBounds(396, 291, 121, 46);
		contentPane.add(buttonLogin);
		
		JButton buttonLimpiar = new JButton("Limpiad Datos");
		buttonLimpiar.setBackground(Color.DARK_GRAY);
		buttonLimpiar.setBounds(263, 291, 121, 46);
		contentPane.add(buttonLimpiar);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(270, 233, 247, 22);
		contentPane.add(textFieldPassword);
		
		JLabel labelTitulo = DefaultComponentFactory.getInstance().createTitle("JAVA");
		labelTitulo.setFont(new Font("Century Gothic", Font.BOLD, 28));
		labelTitulo.setBounds(247, 13, 270, 46);
		contentPane.add(labelTitulo);
	}
}
