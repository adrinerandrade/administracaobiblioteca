package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.emprestimo.Emprestimo;
import model.emprestimo.EmprestimoController;
import model.obra.Obra;
import model.obra.RepositorioObras;
import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;

public class DashBoard {

	private JFrame frame;
	private JTextField obrasTxt;
	private RepositorioUsuarios repositorioUsuario;
	private RepositorioObras repositorioObras;
	private EmprestimoController emprestimoCtrl;
	private JList usuariosList;
	private JList obrasList;
	private DefaultListModel usuarioModel;
	private DefaultListModel obraModel;


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

	public DashBoard() {
		repositorioObras = RepositorioObras.instance();
		repositorioUsuario = RepositorioUsuarios.instance();
		initialize();
	}

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
		lblPesquisa.setBounds(10, 23, 60, 14);
		panel.add(lblPesquisa);
		
		obrasTxt = new JTextField();
		obrasTxt.setBounds(80, 20, 180, 20);
		panel.add(obrasTxt);
		obrasTxt.setColumns(10);
		
		obraModel = new DefaultListModel();
		obrasList = new JList(obraModel);
		obrasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		obrasList.setBounds(10, 51, 250, 385);
		panel.add(obrasList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Usu\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(290, 11, 270, 447);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		usuarioModel = new DefaultListModel(); 
		usuariosList = new JList(usuarioModel);
		usuariosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		usuariosList.setBounds(10, 23, 250, 413);
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
		btnIncluirObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ObraUi(DashBoard.this);
			}
		});
		btnIncluirObra.setBounds(570, 45, 211, 23);
		frame.getContentPane().add(btnIncluirObra);
		
		JButton btnRealizarEmprestimo = new JButton("Realizar Emprestimo");
		btnRealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Obra obra = (Obra) obraModel.getElementAt(obrasList.getSelectedIndex());
				System.out.println(obra.getNome());
				
			}
		});
		btnRealizarEmprestimo.setBounds(570, 79, 211, 23);
		frame.getContentPane().add(btnRealizarEmprestimo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrarAction();
			}
		});
		btnBuscar.setBounds(570, 113, 211, 23);
		frame.getContentPane().add(btnBuscar);
		
		obrasTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					filtrarAction();
				}
			}
		});
	}
	
	public void incluirUsuario(Usuario novoUsuario) {
		usuarioModel.addElement(novoUsuario);	
		repositorioUsuario.adicionaUsuario(novoUsuario);
	}
	
	public void incluirObra(Obra novaObra){
		obraModel.addElement(novaObra);
		repositorioObras.addObra(novaObra);
	}
	
	public void realizarEmprestimo(){
		if(obrasList.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma obra para realizar o emprestimo!");
			return;
		} else if (usuariosList.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(null, "Selecione um usuário para realizar o emprestimo!");
			return;
		}
		Obra obra = (Obra) obraModel.getElementAt(obrasList.getSelectedIndex());
		Usuario usuario = (Usuario) usuarioModel.getElementAt(usuariosList.getSelectedIndex());
		Date dataAtual = new Date();
		emprestimoCtrl.novoEmprestimo(usuario, obra, dataAtual);
	}
	
	public double realizarDevolcao(Emprestimo emprestimo, Date dataDevolucao){
		return emprestimoCtrl.devolucao(emprestimo, dataDevolucao);
	}
	
	public void filtrarAction(){
		obraModel.clear();
		repositorioObras.filtrarPor(obrasTxt.getText()).forEach(obra->{
			obraModel.addElement(obra);
		});				
		
		if(obraModel.size() == 0){
			JOptionPane.showMessageDialog(null, "Nunhuma obra foi encontrada!");
			repositorioObras.getObras().forEach(obra->{
				obraModel.addElement(obra);
			});
		}
	}
}
