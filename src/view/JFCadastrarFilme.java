package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

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

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroFilmes = new JLabel("Cadastrar Filme");
		lblCadastroFilmes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroFilmes.setBounds(26, 11, 96, 14);
		contentPane.add(lblCadastroFilmes);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(26, 36, 46, 14);
		contentPane.add(lblTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(26, 51, 402, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(26, 82, 46, 14);
		contentPane.add(lblSinopse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 107, 402, 53);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(26, 177, 68, 14);
		contentPane.add(lblNewLabel);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(26, 202, 402, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tempo");
		lblNewLabel_1.setBounds(471, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(471, 51, 68, 20);
		contentPane.add(spTempo);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(471, 177, 46, 14);
		contentPane.add(lblImagem);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setBounds(512, 201, 46, 23);
		contentPane.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setBounds(471, 201, 46, 23);
		contentPane.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C1udio");
		lblNewLabel_2.setBounds(471, 82, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(471, 107, 109, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(471, 137, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setDuracao(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtn2D.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				}
				if(rdbtnDublado.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
			}
		});
		btnCadastrar.setBounds(471, 263, 109, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(26, 263, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(365, 263, 89, 23);
		contentPane.add(btnCancelar);
	}
}
