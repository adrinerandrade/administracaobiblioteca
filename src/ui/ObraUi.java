package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import model.obra.Livro;
import model.obra.MaterialDigital;
import model.obra.Obra;
import model.obra.Revista;
import model.obra.TipoMaterialDigital;

public class ObraUi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtObra;
	private JTextField txtAutor;
	private JTextField txtEdicao;
	private JTextField txtAno;
	private JTextField txtData;
	private Obra obra;
	private JTextField txtQuantidade;

	public ObraUi(DashBoard parent) {
		setBounds(100, 100, 379, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "Tipo de Obra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(20, 11, 164, 109);
		contentPanel.add(panel1);
		panel1.setLayout(null);

		JRadioButton rdbtnMaterialDigital = new JRadioButton("Material Digital");
		rdbtnMaterialDigital.setBounds(6, 23, 109, 23);
		panel1.add(rdbtnMaterialDigital);

		JRadioButton rdbtnLivro = new JRadioButton("Livro");
		rdbtnLivro.setBounds(6, 49, 109, 23);
		panel1.add(rdbtnLivro);

		JRadioButton rdbtnRevista = new JRadioButton("Revista");
		rdbtnRevista.setBounds(6, 75, 109, 23);
		panel1.add(rdbtnRevista);

		ButtonGroup bgObra = new ButtonGroup();
		bgObra.add(rdbtnRevista);
		bgObra.add(rdbtnLivro);
		bgObra.add(rdbtnMaterialDigital);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Tipo de Material Digital", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(194, 11, 149, 109);
		contentPanel.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnAudio = new JRadioButton("Audio");
		rdbtnAudio.setBounds(6, 24, 109, 23);
		panel.add(rdbtnAudio);

		JRadioButton rdbtnVideo = new JRadioButton("Video");
		rdbtnVideo.setBounds(6, 50, 109, 23);
		panel.add(rdbtnVideo);

		ButtonGroup bgMaterial = new ButtonGroup();
		bgMaterial.add(rdbtnVideo);
		bgMaterial.add(rdbtnAudio);

		JLabel lblNomeDaObra = new JLabel("Nome da Obra:");
		lblNomeDaObra.setBounds(20, 137, 84, 14);
		contentPanel.add(lblNomeDaObra);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(20, 162, 46, 14);
		contentPanel.add(lblAutor);

		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o:");
		lblEdio.setBounds(20, 187, 46, 14);
		contentPanel.add(lblEdio);

		JLabel lblAnoPublicao = new JLabel("Ano Publica\u00E7\u00E3o:");
		lblAnoPublicao.setBounds(20, 212, 84, 14);
		contentPanel.add(lblAnoPublicao);

		JLabel lblDataDePublicao = new JLabel("Data de Publica\u00E7\u00E3o");
		lblDataDePublicao.setBounds(20, 237, 91, 14);
		contentPanel.add(lblDataDePublicao);

		txtObra = new JTextField();
		txtObra.setBounds(114, 134, 229, 20);
		contentPanel.add(txtObra);
		txtObra.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setBounds(114, 159, 229, 20);
		contentPanel.add(txtAutor);
		txtAutor.setColumns(10);

		txtEdicao = new JTextField();
		txtEdicao.setBounds(114, 184, 86, 20);
		contentPanel.add(txtEdicao);
		txtEdicao.setColumns(10);

		txtAno = new JTextField();
		txtAno.setBounds(114, 209, 86, 20);
		contentPanel.add(txtAno);
		txtAno.setColumns(10);

		txtData = new JTextField();
		txtData.setBounds(114, 234, 86, 20);
		contentPanel.add(txtData);
		txtData.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(20, 262, 84, 14);
		contentPanel.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(114, 259, 86, 20);
		contentPanel.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = txtObra.getText();
					if (rdbtnMaterialDigital.isSelected()) {
						TipoMaterialDigital tipo;
						
						try {
							int qtd = Integer.parseInt(txtQuantidade.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "A quantidade informada deve ser um numero inteiro!");
							return;
						}
						
						if (rdbtnAudio.isSelected()) {
							tipo = TipoMaterialDigital.AUDIO;
						} else if (rdbtnVideo.isSelected()) {
							tipo = TipoMaterialDigital.VIDEO;
						}
						
						try {
							int ano = Integer.parseInt(txtAno.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "O ano informado deve ser um numero inteiro!");
							return;
						}
						
						obra = new MaterialDigital();/* TODO */
						
					} else if (rdbtnRevista.isSelected()) {
						try {
							DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
							Date data = format.parse(txtData.getText());
						} catch (ParseException e2) {
							JOptionPane.showMessageDialog(null, "A data deve ser informada no formato DD/MM/YYYY");
							return;
						}
						
						try {
							int edicao = Integer.parseInt(txtEdicao.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "A edição informada deve ser um numero inteiro!");
							return;
						}
						
						obra = new Revista();/* TODO */
					} else if (rdbtnLivro.isSelected()) {
						
						try {
							int ano = Integer.parseInt(txtAno.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "O ano informado deve ser um numero inteiro!");
							return;
						}
						
						try {
							int edicao = Integer.parseInt(txtEdicao.getText());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "A edição informada deve ser um numero inteiro!");
							return;
						}
						
						String autor = txtAutor.getText();
						obra = new Livro();/* TODO */
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um tipo de obra");
						return;
					}

					if (obra != null) {
						setVisible(false);
						parent.incluirObra(obra);
					}
				} catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					return;
				}

				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		rdbtnMaterialDigital.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnAudio.setEnabled(true);
				rdbtnVideo.setEnabled(true);
				txtAno.setEnabled(true);

				txtData.setEnabled(false);
				txtEdicao.setEnabled(false);
				txtAutor.setEnabled(false);
			}
		});

		rdbtnLivro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtAno.setEnabled(true);
				txtAutor.setEnabled(true);
				txtEdicao.setEnabled(true);

				rdbtnAudio.setEnabled(false);
				rdbtnVideo.setEnabled(false);
				txtData.setEnabled(false);
			}
		});

		rdbtnRevista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtData.setEnabled(true);
				txtEdicao.setEnabled(true);

				rdbtnAudio.setEnabled(false);
				rdbtnVideo.setEnabled(false);
				txtAutor.setEnabled(false);
				txtAno.setEnabled(false);
			}
		});

		setVisible(true);
	}

	public Obra getObra() {
		setVisible(true);
		return obra;
	}

}
