package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.obra.Obra;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetalhesEmprestimoUi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultListModel emprestimoModel;
	private JList emprestimoList;

	public DetalhesEmprestimoUi(List<Obra> obras) {
		setBounds(100, 100, 297, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		
		emprestimoModel = new DefaultListModel();
		emprestimoList = new JList(emprestimoModel);
		emprestimoList.setBounds(10, 11, 257, 206);
		contentPanel.add(emprestimoList);
		
		obras.forEach(obra ->{
			emprestimoModel.addElement(obra);
		});
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setVisible(true);
	}
}
