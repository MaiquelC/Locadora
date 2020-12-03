package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the fram;
	 */
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarClientes = new JLabel("Listar Clientes");
		lblListarClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListarClientes.setBounds(10, 11, 118, 19);
		contentPane.add(lblListarClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 172);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdCliente", "Nome", "CPF", "Usuario", "Senha", "Endereco"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(10, 227, 147, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterarCliente = new JButton("Alterar cliente");
		btnAlterarCliente.setBounds(167, 227, 127, 23);
		contentPane.add(btnAlterarCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.setBounds(304, 227, 120, 23);
		contentPane.add(btnExcluirCliente);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for (Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
				c.getId_cliente(),
				c.getNome(),
				c.getCpf(),
				c.getUsuario(),
				c.getSenha(),
				c.getEndereco()
			});
		}
	}

}
