package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import java.awt.Color;
import javax.swing.JSeparator;

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
	 * Create the fram;;
	 */
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 637, 193);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdCliente", "Nome", "CPF", "Usuario", "Senha", "Endereco"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBackground(new Color(153, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cc = new JFCadastrarCliente();
				cc.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 274, 200, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Alterar Cliente");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(153, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar se há linha selecionada
				if(jtCliente.getSelectedRow()!= -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente(
							(int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
					ac.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnNewButton.setBounds(228, 274, 200, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirCliente.setBackground(new Color(153, 255, 255));
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtCliente.getSelectedRow() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setId_cliente((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
						dao.delete(c);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnExcluirCliente.setBounds(447, 274, 200, 23);
		contentPane.add(btnExcluirCliente);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 255, 204));
		panel.setBounds(0, 0, 656, 47);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 45, 656, 5);
		panel.add(separator);
		
		JLabel lblListarClientes = new JLabel("Listar Clientes");
		lblListarClientes.setBounds(287, 11, 153, 19);
		panel.add(lblListarClientes);
		lblListarClientes.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
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
