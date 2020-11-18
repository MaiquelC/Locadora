package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUser;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrarCliente.setBounds(10, 11, 124, 27);
		contentPane.add(lblCadastrarCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 45, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 67, 168, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 98, 46, 14);
		contentPane.add(lblCpf);
		
		JSpinner spCpf = new JSpinner();
		spCpf.setBounds(10, 123, 168, 20);
		contentPane.add(spCpf);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 154, 46, 14);
		contentPane.add(lblEndereo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 168, 77);
		contentPane.add(scrollPane);
		
		JTextArea txtEndereco = new JTextArea();
		scrollPane.setViewportView(txtEndereco);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(220, 45, 46, 14);
		contentPane.add(lblUsurio);
		
		txtUser = new JTextField();
		txtUser.setBounds(220, 67, 168, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(220, 98, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(220, 123, 168, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(txtNome.getText());
				c.setCpf(Integer.parseInt(spCpf.getValue().toString()));
				c.setEndereco(txtEndereco.getText());
				c.setUsuario(txtUser.getText());
				c.setSenha(txtSenha.getText());
				dao.create(c);
			}
		});
		btnCadastrar.setBounds(220, 175, 168, 27);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(220, 213, 168, 27);
		contentPane.add(btnCancelar);
		
	}
	
	

}
