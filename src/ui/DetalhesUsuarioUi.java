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

	public DetalhesUsuarioUi(DashBoard parent, List<Emprestimo> lista) {
		setBounds(100, 100, 315, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnRealizarDevoluo = new JButton("Realizar Devolu\u00E7\u00E3o");
		btnRealizarDevoluo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1){
					JOptionPane.showMessageDialog(null, "Selecione uma obra para devolução!");
					return;
				}
				Emprestimo emprestimo = (Emprestimo) emprestimoModel.getElementAt(list.getSelectedIndex());
				String data = JOptionPane.showInputDialog("Data de devolução:");
				DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
				try {
					/*TODO*/
					Date dataDevolucao = format.parse(data);
					double valor = parent.realizarDevolcao(emprestimo, dataDevolucao);
					JOptionPane.showMessageDialog(null,"O valor do empréstimo é de " + String.valueOf(valor));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRealizarDevoluo.setBounds(10, 190, 144, 23);
		contentPanel.add(btnRealizarDevoluo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Obras Emprestadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 279, 168);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		emprestimoModel = new DefaultListModel();
		list = new JList(emprestimoModel);
		list.setBounds(10, 22, 259, 135);
		panel.add(list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		lista.forEach(emprestimo->{
			emprestimoModel.addElement(emprestimo);
		});
	}
}
