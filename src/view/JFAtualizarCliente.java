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
import java.awt.Color;
import javax.swing.JSeparator;

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
		setBounds(100, 100, 421, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 76, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 101, 168, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(10, 132, 46, 14);
		contentPane.add(lblCpf);
		
		JSpinner spCpf = new JSpinner();
		spCpf.setBounds(10, 157, 168, 20);
		contentPane.add(spCpf);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(10, 188, 74, 14);
		contentPane.add(lblEndereo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 168, 77);
		contentPane.add(scrollPane);
		
		JTextArea txtEndereco = new JTextArea();
		scrollPane.setViewportView(txtEndereco);
		txtEndereco.setText(c.getEndereco());
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsurio.setBounds(220, 76, 46, 14);
		contentPane.add(lblUsurio);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 255, 204));
		panel.setBounds(-2, 0, 407, 47);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 45, 580, 5);
		panel.add(separator);
		
		JLabel lblAtualizarCliente = new JLabel("Atualizar Cliente");
		lblAtualizarCliente.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblAtualizarCliente.setBounds(135, 7, 169, 27);
		panel.add(lblAtualizarCliente);
		
		JLabel lblNewLabel_7 = new JLabel("ID do cliente:");
		lblNewLabel_7.setBounds(10, 16, 89, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(92, 16, 78, 14);
		panel.add(lblId);
		
		lblId.setText(String.valueOf(c.getId_cliente()));
		
		txtUser = new JTextField();
		txtUser.setBounds(220, 101, 168, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(220, 132, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(220, 157, 168, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		txtNome.setText(c.getNome());
		spCpf.setValue(c.getCpf());
		txtUser.setText(c.getUsuario());
		txtSenha.setText(c.getSenha());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(153, 255, 255));
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnAlterar.setBounds(220, 213, 168, 32);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(153, 255, 255));
		btnCancelar.setBounds(220, 258, 168, 32);
		contentPane.add(btnCancelar);
		
		
		
	}

}
