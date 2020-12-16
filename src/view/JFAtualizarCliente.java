package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUser;
	private JTextField txtSenha;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
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
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNewLabel_7 = new JLabel("ID do cliente");
		lblNewLabel_7.setBounds(169, 14, 89, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(234, 14, 78, 14);
		contentPane.add(lblId);
		
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
		
		lblId.setText(String.valueOf(c.getId_cliente()));
		txtNome.setText(c.getNome());
		spCpf.setValue(c.getCpf());
		txtEndereco.setText(c.getEndereco());
		txtUser.setText(c.getUsuario());
		txtSenha.setText(c.getSenha());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setId_cliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setCpf(Integer.parseInt(spCpf.getValue().toString()));
				c.setEndereco(txtEndereco.getText());
				c.setUsuario(txtUser.getText());
				c.setSenha(txtSenha.getText());
				dao.update(c);
			}
		});
		btnAlterar.setBounds(220, 175, 168, 27);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.setBounds(220, 213, 168, 27);
		contentPane.add(btnCancelar);
		
	}

}
