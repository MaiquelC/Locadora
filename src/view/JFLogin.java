package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class JFLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsurio;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFLogin frame = new JFLogin();
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
	public JFLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		lblLogin.setBounds(230, 27, 103, 32);
		contentPane.add(lblLogin);
		
		txtUsurio = new JTextField();
		txtUsurio.setForeground(new Color(0, 0, 0));
		txtUsurio.setBackground(new Color(255, 255, 255));
		txtUsurio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsurio.setBounds(230, 88, 181, 20);
		contentPane.add(txtUsurio);
		txtUsurio.setColumns(10);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(230, 70, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(230, 119, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(230, 137, 181, 20);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(51, 255, 204));
		separator.setBounds(230, 57, 66, 2);
		contentPane.add(separator);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setForeground(new Color(0, 0, 0));
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAcessar.setBackground(new Color(153, 255, 255));
		btnAcessar.setBounds(230, 168, 181, 23);
		contentPane.add(btnAcessar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 204));
		panel.setBounds(0, 0, 210, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo(a)!");
		lblBemVindo.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblBemVindo.setBounds(40, 88, 115, 21);
		panel.add(lblBemVindo);
		
		JLabel lblDesc = new JLabel("Fa\u00E7a o login e acesse sua conta");
		lblDesc.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDesc.setBounds(15, 120, 180, 14);
		panel.add(lblDesc);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(208, 0, 2, 261);
		panel.add(separator_1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(0, 0, 0));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBackground(new Color(153, 255, 255));
		btnLimpar.setBounds(230, 202, 181, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblPergunta = new JLabel("Ainda n\u00E3o tem conta?");
		lblPergunta.setBounds(230, 236, 119, 14);
		contentPane.add(lblPergunta);
		lblPergunta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		
		JLabel lblAcessarCadastro = new JLabel("Cadastre-se");
		lblAcessarCadastro.setForeground(new Color(0, 0, 0));
		lblAcessarCadastro.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAcessarCadastro.setBounds(340, 236, 66, 14);
		contentPane.add(lblAcessarCadastro);
	}
}
