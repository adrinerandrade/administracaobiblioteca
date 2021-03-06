package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.usuario.Aluno;
import model.usuario.Professor;
import model.usuario.Usuario;

public class UsuarioUi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtDataAdm;
	
	public UsuarioUi(DashBoard parent) {
		setBounds(100, 100, 417, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Tipo de Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 198, 55);
		contentPanel.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(6, 19, 100, 23);
		panel.add(rdbtnProfessor);

		JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(119, 19, 73, 23);
		panel.add(rdbtnAluno);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 77, 46, 14);
		contentPanel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(135, 74, 237, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 102, 59, 14);
		contentPanel.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(135, 99, 129, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblDataDeAdmisso = new JLabel("Data de Admiss\u00E3o:");
		lblDataDeAdmisso.setBounds(10, 127, 115, 14);
		contentPanel.add(lblDataDeAdmisso);

		txtDataAdm = new JTextField();
		txtDataAdm.setBounds(135, 124, 129, 20);
		contentPanel.add(txtDataAdm);
		txtDataAdm.setColumns(10);

		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnAluno);
		gp.add(rdbtnProfessor);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(10, 164, 77, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Usuario usuario = null;
					String nome = txtNome.getText();
					try {
						if(rdbtnAluno.isSelected()) {
							int matricula;
							try {
								matricula = Integer.parseInt(txtMatricula.getText());
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "A matricula informada deve ser um numero inteiro!");
								return;
							}
							
							usuario = new Aluno(nome, matricula);
						} else if (rdbtnProfessor.isSelected()) {
							Date data;
							DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
							try {
								data = format.parse(txtDataAdm.getText());
							} catch (ParseException e2) {
								JOptionPane.showMessageDialog(null, "A data de admiss�o deve ser informada no formato DD/MM/YYYY");
								return;
							}							
							
							usuario = new Professor(nome, data);
						} else {
							JOptionPane.showMessageDialog(null, "Selecione um tipo de usu�rio!");
						}
					} catch (RuntimeException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
						return;
					}
					
					if (usuario != null) {
						setVisible(false);
						parent.incluirUsuario(usuario);
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			setVisible(true);
		}

		rdbtnProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtDataAdm.setEnabled(true);
				txtMatricula.setEnabled(false);
			}
		});
		
		rdbtnAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMatricula.setEnabled(true);
				txtDataAdm.setEnabled(false);
			}
		});
	}

}
