package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.StringUtils;

import model.emprestimo.Emprestimo;
import model.usuario.Usuario;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DetalhesUsuarioUi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultListModel emprestimoModel;
	private JList list;

	public DetalhesUsuarioUi(DashBoard parent) {
		setBounds(100, 100, 315, 267);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnRealizarDevoluo = new JButton("Realizar Devolu��o");
		btnRealizarDevoluo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (list.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione uma obra para devolu��o!");
						return;
					}
					Emprestimo emprestimo = (Emprestimo) emprestimoModel.getElementAt(list.getSelectedIndex());
					String data = JOptionPane.showInputDialog("Data de devolu��o:");
					
					
					if(data == null){
						return;
					}
					
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");					
					Date dataDevolucao;
					try {
						dataDevolucao = format.parse(data);
					} catch (ParseException e2) {
						JOptionPane.showMessageDialog(null, "A data deve ser informada no formato DD/MM/YYYY");
						return;
					}					
					
					double valor = parent.realizarDevolucao(emprestimo, dataDevolucao);
					JOptionPane.showMessageDialog(null, "O valor do empr�stimo � de R$" + String.format("%11.2f", valor));
					
					emprestimoModel.clear();
					parent.getEmprestimosUsuario().forEach(emp -> {
						emprestimoModel.addElement(emp);
					});
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRealizarDevoluo.setBounds(10, 190, 144, 23);
		contentPanel.add(btnRealizarDevoluo);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Obras Emprestadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 279, 168);
		contentPanel.add(panel);
		panel.setLayout(null);

		emprestimoModel = new DefaultListModel();
		list = new JList(emprestimoModel);
		list.setBounds(10, 22, 259, 135);
		panel.add(list);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(231, 190, 58, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}

		parent.getEmprestimosUsuario().forEach(emprestimo -> {
			emprestimoModel.addElement(emprestimo);
		});
		
		setVisible(true);
	}
	
}
