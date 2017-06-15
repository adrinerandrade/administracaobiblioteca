package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.obra.RepositorioObras;
import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;

public class DashBoard {

	private JFrame frame;
	private JTextField obrasTxt;
	private JTextField usuarioTxt;
	private RepositorioUsuarios repositorioUsuario;
	private RepositorioObras repositorioObras;
	private List<Usuario> usu = new ArrayList<>();
	private JList usuariosList;
	private DefaultListModel mdl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 807, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 270, 447);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(10, 23, 46, 14);
		panel.add(lblPesquisa);
		
		obrasTxt = new JTextField();
		obrasTxt.setBounds(66, 20, 194, 20);
		panel.add(obrasTxt);
		obrasTxt.setColumns(10);
		
		JList obrasList = new JList();
		obrasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		obrasList.setBounds(10, 51, 250, 385);
		panel.add(obrasList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Usu\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(290, 11, 270, 447);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPesquisa_1 = new JLabel("Pesquisa:");
		lblPesquisa_1.setBounds(10, 23, 46, 14);
		panel_1.add(lblPesquisa_1);
		
		usuarioTxt = new JTextField();
		usuarioTxt.setBounds(66, 20, 194, 20);
		panel_1.add(usuarioTxt);
		usuarioTxt.setColumns(10);
		
		mdl = new DefaultListModel(); 
		usuariosList = new JList(mdl);
		usuariosList.setBounds(10, 51, 250, 385);
		panel_1.add(usuariosList);
		
		JButton btnIncluirUsurio = new JButton("Incluir Usu\u00E1rio");
		btnIncluirUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UsuarioUi(DashBoard.this);
			}
		});
		btnIncluirUsurio.setBounds(570, 11, 211, 23);
		frame.getContentPane().add(btnIncluirUsurio);
		
		JButton btnIncluirObra = new JButton("Incluir Obra");
		btnIncluirObra.setBounds(570, 45, 211, 23);
		frame.getContentPane().add(btnIncluirObra);
		
		JButton btnRealizarEmprestimo = new JButton("Realizar Emprestimo");
		btnRealizarEmprestimo.setBounds(570, 79, 211, 23);
		frame.getContentPane().add(btnRealizarEmprestimo);
	}
	
	public void usuarioIncluido(Usuario novoUsuario) {
		mdl.addElement(novoUsuario);	
		System.out.println(novoUsuario);
	}
	
}
