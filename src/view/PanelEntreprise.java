package view;

import ControlleSaisie.Saisie;
import controller.EntrepriseService;
import models.Address;
import models.BankAccount;
import models.Client;
import models.Entreprise;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelEntreprise extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private final JTable table;
	TextField textFieldmatricule;
	TextField textFieldraison;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton btnNewButton;
	TextField textFieldfax;
	TextField textFieldnumfix;
	TextField textFieldnumportable;
	TextField textFieldemail;
	TextField textFieldsiteweb;
	JComboBox comboBox;
	TextField textFieldnumeroroute;
	TextField textFieldlibelle;
	TextField textFieldcodepostal;
	TextField textFieldgouvernourat;
	TextField textFieldpays;
	TextField textFieldrib;
	TextField textFieldbankname;
	TextField textFieldagence;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	ArrayList<String> currentribs = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public PanelEntreprise() {
		//this.setSize(1175, 585);
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Gestion de L'entreprise");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		add(lblNewLabel, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Entreprise", null, panel_1, null);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1 = new JLabel("Matricule:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_1);


		textFieldmatricule = new TextField();
		textFieldmatricule.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldmatricule.setColumns(10);
		panel_5.add(textFieldmatricule);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_2 = new JLabel("Raison:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(lblNewLabel_2);


		textFieldraison = new TextField();
		textFieldraison.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldraison.setColumns(10);
		panel_6.add(textFieldraison);

		JPanel panel_4_1 = new JPanel();
		panel_1.add(panel_4_1);

		JPanel panel_5_1 = new JPanel();
		panel_4_1.add(panel_5_1);
		panel_5_1.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_1 = new JLabel("Type:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_1.add(lblNewLabel_1_1);


		rdbtnNewRadioButton = new JRadioButton("Morale");
		rdbtnNewRadioButton.setActionCommand("Morale");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setSelected(true);
		panel_5_1.add(rdbtnNewRadioButton);


		btnNewButton = new JRadioButton("Physique");
		btnNewButton.setActionCommand("Physique");
		buttonGroup.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_1.add(btnNewButton);

		JPanel panel_6_1 = new JPanel();
		panel_4_1.add(panel_6_1);
		panel_6_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 5));

		JLabel lblNewLabel_2_1 = new JLabel("FAX:");
		lblNewLabel_2_1.setSize(250, 100);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6_1.add(lblNewLabel_2_1);


		textFieldfax = new TextField();
		textFieldfax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldfax.setColumns(10);
		panel_6_1.add(textFieldfax);

		JPanel panel_4_2 = new JPanel();
		panel_1.add(panel_4_2);

		JPanel panel_5_2 = new JPanel();
		panel_4_2.add(panel_5_2);
		panel_5_2.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_2 = new JLabel("NumFix:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_2.add(lblNewLabel_1_2);


		textFieldnumfix = new TextField();
		textFieldnumfix.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldnumfix.setColumns(10);
		panel_5_2.add(textFieldnumfix);

		JPanel panel_6_2 = new JPanel();
		panel_4_2.add(panel_6_2);
		panel_6_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 5));

		JLabel lblNewLabel_2_2 = new JLabel("NumPortable:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6_2.add(lblNewLabel_2_2);


		textFieldnumportable = new TextField();
		textFieldnumportable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldnumportable.setColumns(10);
		panel_6_2.add(textFieldnumportable);

		JPanel panel_4_3 = new JPanel();
		panel_1.add(panel_4_3);

		JPanel panel_5_3 = new JPanel();
		panel_4_3.add(panel_5_3);
		panel_5_3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_3 = new JLabel("Email:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_3.add(lblNewLabel_1_3);


		textFieldemail = new TextField();
		textFieldemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldemail.setColumns(10);
		panel_5_3.add(textFieldemail);

		JPanel panel_6_3 = new JPanel();
		panel_4_3.add(panel_6_3);
		panel_6_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 5));

		JLabel lblNewLabel_2_3 = new JLabel("SiteWeb:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6_3.add(lblNewLabel_2_3);


		textFieldsiteweb = new TextField();
		textFieldsiteweb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldsiteweb.setColumns(10);
		panel_6_3.add(textFieldsiteweb);

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);

		JPanel panel_5_3_1 = new JPanel();
		panel_7.add(panel_5_3_1);
		panel_5_3_1.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_3_1 = new JLabel("EtatFiscal:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_3_1.add(lblNewLabel_1_3_1);


		rdbtnNewRadioButton_1 = new JRadioButton("OUI");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setActionCommand("OUI");
		rdbtnNewRadioButton_1.setSelected(true);
		buttonGroup2.add(rdbtnNewRadioButton_1);
		panel_5_3_1.add(rdbtnNewRadioButton_1);


		rdbtnNewRadioButton_2 = new JRadioButton("NON");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setActionCommand("NON");
		buttonGroup2.add(rdbtnNewRadioButton_2);
		panel_5_3_1.add(rdbtnNewRadioButton_2);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Address", null, panel_2, null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_4_4 = new JPanel();
		panel_2.add(panel_4_4);
		panel_4_4.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4 = new JPanel();
		panel_4_4.add(panel_5_4);
		panel_5_4.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4 = new JLabel("NumeroRoute:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4.add(lblNewLabel_1_4);


		textFieldnumeroroute = new TextField();
		textFieldnumeroroute.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldnumeroroute.setColumns(10);
		panel_5_4.add(textFieldnumeroroute);

		JPanel panel_4_4_1 = new JPanel();
		panel_2.add(panel_4_4_1);
		panel_4_4_1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4_1 = new JPanel();
		panel_4_4_1.add(panel_5_4_1);
		panel_5_4_1.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_1 = new JLabel("Libelle:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_1.add(lblNewLabel_1_4_1);


		textFieldlibelle = new TextField();
		textFieldlibelle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldlibelle.setColumns(10);
		panel_5_4_1.add(textFieldlibelle);

		JPanel panel_4_4_2 = new JPanel();
		panel_2.add(panel_4_4_2);
		panel_4_4_2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4_2 = new JPanel();
		panel_4_4_2.add(panel_5_4_2);
		panel_5_4_2.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_2 = new JLabel("Ville:");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_2.add(lblNewLabel_1_4_2);


		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"Tunis", "Ariana", "Ben Arous", "Manouba", "Nabeul", "Zaghouan", "Bizerte", "B\u00E9ja", "Jendouba", "Kef", "Siliana", "Sousse", "Monastir", "Mahdia", "Sfax", "Kairouan", "Kasserine", "Sidi Bouzid", "Gab\u00E8s", "Mednine", "Tataouine", "Gafsa", "Tozeur", "Kebili"}));

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_2.add(comboBox);

		JPanel panel_4_4_3 = new JPanel();
		panel_2.add(panel_4_4_3);
		panel_4_4_3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4_3 = new JPanel();
		panel_4_4_3.add(panel_5_4_3);
		panel_5_4_3.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_3 = new JLabel("CodePostal:");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_3.add(lblNewLabel_1_4_3);


		textFieldcodepostal = new TextField();
		textFieldcodepostal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldcodepostal.setColumns(10);
		panel_5_4_3.add(textFieldcodepostal);

		JPanel panel_4_4_4 = new JPanel();
		panel_2.add(panel_4_4_4);
		panel_4_4_4.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4_4 = new JPanel();
		panel_4_4_4.add(panel_5_4_4);
		panel_5_4_4.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_4 = new JLabel("Gouvernourat:");
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_4.add(lblNewLabel_1_4_4);


		textFieldgouvernourat = new TextField();
		textFieldgouvernourat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldgouvernourat.setColumns(10);
		panel_5_4_4.add(textFieldgouvernourat);

		JPanel panel_4_4_5 = new JPanel();
		panel_2.add(panel_4_4_5);
		panel_4_4_5.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel panel_5_4_5 = new JPanel();
		panel_4_4_5.add(panel_5_4_5);
		panel_5_4_5.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_5 = new JLabel("Pays:");
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_5.add(lblNewLabel_1_4_5);


		textFieldpays = new TextField();
		textFieldpays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldpays.setColumns(10);
		panel_5_4_5.add(textFieldpays);

		JPanel panel = new JPanel();
		tabbedPane.addTab("BankAccounts", null, panel, null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		table = new MyTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"RIB", "BankName", "Agence"
				}
		));
		scrollPane.setViewportView(table);

		JPanel panel_8 = new JPanel();
		splitPane.setRightComponent(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));

		JPanel panel_5_4_6 = new JPanel();
		panel_8.add(panel_5_4_6);
		panel_5_4_6.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_6 = new JLabel("RIB:");
		lblNewLabel_1_4_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_6.add(lblNewLabel_1_4_6);


		textFieldrib = new TextField();
		textFieldrib.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldrib.setColumns(18);
		panel_5_4_6.add(textFieldrib);

		JPanel panel_5_4_6_1 = new JPanel();
		panel_8.add(panel_5_4_6_1);
		panel_5_4_6_1.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_6_1 = new JLabel("BankName:");
		lblNewLabel_1_4_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_6_1.add(lblNewLabel_1_4_6_1);


		textFieldbankname = new TextField();
		textFieldbankname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldbankname.setColumns(18);
		panel_5_4_6_1.add(textFieldbankname);

		JPanel panel_5_4_6_2 = new JPanel();
		panel_8.add(panel_5_4_6_2);
		panel_5_4_6_2.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));

		JLabel lblNewLabel_1_4_6_2 = new JLabel("Agence:");
		lblNewLabel_1_4_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5_4_6_2.add(lblNewLabel_1_4_6_2);


		textFieldagence = new TextField();
		textFieldagence.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldagence.setColumns(18);
		panel_5_4_6_2.add(textFieldagence);

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(50);
		panel_8.add(panel_9);

		JButton btnaddaccount = new JButton("Ajouter");
		btnaddaccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(btnaddaccount);

		JButton btneditaccount = new JButton("Modifier");
		btneditaccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(btneditaccount);

		JButton btndeleteaccount = new JButton("Supprimer");
		btndeleteaccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(btndeleteaccount);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.SOUTH);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_3.add(btnModifier);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_3.add(btnCancel);
		initilisentreprise();
		btndeleteaccount.setEnabled(false);
		btneditaccount.setEnabled(false);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRowCount() > 0) {
					btndeleteaccount.setEnabled(true);
					btneditaccount.setEnabled(true);
					int row = table.getSelectedRow();
					if (table.getRowCount() > 0) {
						textFieldrib.setText(table.getValueAt(row, 0).toString());
						textFieldbankname.setText(table.getValueAt(row, 1).toString());
						textFieldagence.setText(table.getValueAt(row, 2).toString());
					}
				} else {
					btndeleteaccount.setEnabled(false);
					btneditaccount.setEnabled(false);
				}

			}
		});
		btnaddaccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Saisie.isRibUnique(textFieldrib.getText().trim())) {
					if (!iscurrentrib(textFieldrib.getText().trim())) {
						JOptionPane.showMessageDialog(PanelEntreprise.this,
								"RIB Saisie Deja existant ",
								"RIB Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if (verifrib(textFieldrib.getText().trim()) == false) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Rib deja existant",
							"Rib Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldagence.getText().trim()) == false) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Agence invalid",
							"Agence Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldbankname.getText().trim()) == false) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"bankname invalid",
							"bankname Error", JOptionPane.ERROR_MESSAGE);

					return;
				}
				((DefaultTableModel) table.getModel()).addRow(new Object[]{
						textFieldrib.getText().trim(),
						textFieldbankname.getText().trim(),
						textFieldagence.getText().trim()
				});
			}
		});
		btneditaccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (!Saisie.isRibUnique(textFieldrib.getText().trim())) {
					if (!iscurrentrib(textFieldrib.getText().trim())) {
						JOptionPane.showMessageDialog(PanelEntreprise.this,
								"RIB Saisie Deja existant ",
								"RIB Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if (Saisie.checkraison(textFieldagence.getText().trim()) == false) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Agence invalid",
							"Agence Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldbankname.getText().trim()) == false) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"bankname invalid",
							"bankname Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				table.getModel().setValueAt(textFieldrib.getText(), row, 0);
				table.getModel().setValueAt(textFieldbankname.getText(), row, 1);
				table.getModel().setValueAt(textFieldagence.getText(), row, 2);
			}
		});
		btndeleteaccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				((DefaultTableModel) table.getModel()).removeRow(row);
				if (table.getSelectedRowCount() == 0) {
					btndeleteaccount.setEnabled(false);
					btneditaccount.setEnabled(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initilisentreprise();
			}
		});
		btnModifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				if (!Saisie.checkmatricule(textFieldmatricule.getText().trim())) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"matricule doit etre sous la forme 0744801M/NC/000",
							"Matricule invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldraison.getText().trim())) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"une raison sociale (qui peut être simplement nom et prénom)",
							"Raison invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldfax.getText().trim()) && textFieldfax.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Fax doit etre composé de 8 chiffre",
							"Fax invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldnumportable.getText().trim()) && textFieldnumportable.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Num Portable doit etre composé de 8 chiffre",
							"Num Portable invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldnumfix.getText().trim()) && textFieldnumfix.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Num Fix doit etre composé de 8 chiffre",
							"Num Fix invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textFieldemail.getText().length() != 0) {
					if (!Saisie.emailisValid(textFieldemail.getText().trim())) {
						JOptionPane.showMessageDialog(PanelEntreprise.this,
								"Email doit etre sous format aaaaa@aaaa.aa",
								"Email Invalid", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
				//todo site web to do here

				if (!Saisie.isNumeric(textFieldnumeroroute.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Numero Route doit etre compose seulment des chiffres",
							"Numero Route Invalid", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldlibelle.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Libelle doit etre copose seulement des letres",
							"Libelle invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldcodepostal.getText().trim()) && textFieldcodepostal.getText().trim().length() == 4)) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Code postal doit etre composé de 4 chiffres",
							"Code postal invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldgouvernourat.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"gouvernourat doit etre copose seulement des letres",
							"gouvernourat invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldpays.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"pays doit etre copose seulement des letres",
							"pays invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (getaccounts() == null) {
					tabbedPane.setSelectedIndex(2);
					JOptionPane.showMessageDialog(PanelEntreprise.this,
							"Le client doit avoir un compte au minimum",
							"BankAccounts Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				EntrepriseService es = new EntrepriseService();
				ArrayList<BankAccount> bankAccounts = getaccounts();
				Address address = new Address(textFieldnumeroroute.getText().trim(),
						textFieldlibelle.getText().trim()
						, comboBox.getSelectedItem().toString(),
						textFieldcodepostal.getText().trim()
						, textFieldgouvernourat.getText().trim(), textFieldpays.getText().trim());

				boolean etat = false;
				if (buttonGroup2.getSelection().getActionCommand() == "OUI") {
					etat = true;
				}
				Entreprise c = new Entreprise(textFieldmatricule.getText().trim(),
						textFieldraison.getText().trim(),
						buttonGroup.getSelection().getActionCommand(), bankAccounts, address,
						textFieldfax.getText().trim(),
						textFieldnumportable.getText().trim(), textFieldnumfix.getText().trim(),
						etat, "rrr");
				c.setEmail(textFieldemail.getText().trim());
				c.setSiteWeb(textFieldsiteweb.getText().trim());
				es.edit(c);
				JOptionPane.showMessageDialog(PanelEntreprise.this,
						"Entreprise modifier avec succes",
						"BankAccounts Error", JOptionPane.INFORMATION_MESSAGE);


			}
		});

	}

	private void initilisentreprise() {
		EntrepriseService es = new EntrepriseService();
		Entreprise E = es.get();
		textFieldmatricule.setText(E.getMatricule());
		textFieldraison.setText(E.getRaison());
		if (E.getType().equals("Physique")) {
			btnNewButton.setSelected(true);
		}
		if (!E.getEtat()) {
			rdbtnNewRadioButton_2.setSelected(true);
		}
		textFieldfax.setText(E.getFax());
		textFieldnumfix.setText(E.getNumFix());
		textFieldnumportable.setText(E.getNumPortable());
		textFieldemail.setText(E.getEmail());
		textFieldsiteweb.setText(E.getSiteWeb());
		textFieldnumeroroute.setText(E.getAddress().getNumeroRue());
		textFieldlibelle.setText(E.getAddress().getLibelle());
		comboBox.setSelectedItem(E.getAddress().getVille());
		textFieldcodepostal.setText(E.getAddress().getCodePostal());
		textFieldgouvernourat.setText(E.getAddress().getGouvernourat());
		textFieldpays.setText(E.getAddress().getPays());
		updateaccounts(E.getBankAccounts());


	}

	private boolean iscurrentrib(String rib) {
		if (currentribs.size() == 0)
			return false;
		for (int i = 0; i < currentribs.size(); i++) {
			if (currentribs.contains(rib))
				return true;
		}
		return false;
	}

	private void fillcurrentrib(Client E) {
		for (int i = 0; i < E.getBankAccounts().size(); i++) {
			currentribs.add(E.getBankAccounts().get(i).getRIB());
		}
	}

	private boolean verifrib(String rib) {
		if (table.getRowCount() == 0) {
			return true;
		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 0).equals(rib)) {

				return false;
			}

		}
		return true;
	}

	public ArrayList<BankAccount> getaccounts() {
		ArrayList<BankAccount> list = new ArrayList<>();
		if (table.getRowCount() == 0)
			return null;
		for (int row = 0; row < table.getRowCount(); row++) {
			list.add(new BankAccount(table.getValueAt(row, 0).toString(),
					table.getValueAt(row, 1).toString(),
					table.getValueAt(row, 2).toString()));
		}
		return list;
	}

	public void updateaccounts(ArrayList<BankAccount> list) {
		while (table.getRowCount() > 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		for (int i = 0; i < list.size(); i++) {
			BankAccount b = list.get(i);
			Object[] data = {b.getRIB(),
					b.getBankname(),
					b.getAgence()};

			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}
}
