package view;

import ControlleSaisie.Saisie;
import controller.CodeService;
import controller.FournisseurService;
import models.Address;
import models.BankAccount;
import models.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AjouterFournisseur extends JDialog {
	private final TextField textFieldmatricule;
	private final TextField textFieldraison;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnNewRadioButton;
	private final JRadioButton btnNewButton;
	private final TextField textFieldfax;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final TextField textFieldnumeroroute;
	private final TextField textFieldlibelle;
	private final TextField textFieldEmail;
	private final TextField textFieldSiteweb;
	private final TextField textFieldgouvernourat;
	private final TextField textFieldpays;
	private final JTable table;
	private final TextField textFieldRib;
	private final TextField textFieldbankname;
	private final TextField textFieldagence;
	private final JLabel labelraison;
	private final JLabel labelmatricule;
	JLabel labelnumfix;

	/**
	 * Create the dialog.
	 */
	public AjouterFournisseur(PanelFournisseur panelClient) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 653);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(156, 545, 485, 54);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAjouterClient = new JButton("Ajouter");
		btnAjouterClient.setBounds(133, 10, 94, 34);
		panel.add(btnAjouterClient);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterFournisseur.this.dispose();
				panelClient.frame.setVisible(true);

			}
		});
		btnCancel.setBounds(260, 10, 94, 34);
		panel.add(btnCancel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabbedPane.setBounds(52, 48, 721, 487);
		getContentPane().add(tabbedPane);

		JPanel panelfournisseur = new JPanel();
		tabbedPane.addTab("Client", null, panelfournisseur, null);
		panelfournisseur.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(61, 10, 270, 66);
		panelfournisseur.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Matricule:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 92, 32);
		panel_2.add(lblNewLabel_1);

		textFieldmatricule = new TextField();
		textFieldmatricule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldmatricule.setBounds(112, 10, 128, 32);
		panel_2.add(textFieldmatricule);
		textFieldmatricule.setColumns(10);


		labelmatricule = new JLabel("");
		labelmatricule.setForeground(Color.RED);
		labelmatricule.setBounds(36, 52, 205, 13);
		panel_2.add(labelmatricule);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(393, 10, 259, 69);
		panelfournisseur.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Raison:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 10, 74, 32);
		panel_3.add(lblNewLabel_2);

		textFieldraison = new TextField();
		textFieldraison.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldraison.setBounds(94, 10, 155, 32);
		panel_3.add(textFieldraison);
		textFieldraison.setColumns(10);


		labelraison = new JLabel("");
		labelraison.setForeground(Color.RED);
		labelraison.setBounds(94, 46, 155, 13);
		panel_3.add(labelraison);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(61, 86, 322, 69);
		panelfournisseur.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Type:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(20, 10, 74, 32);
		panel_4.add(lblNewLabel_2_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(94, 10, 205, 35);
		panel_4.add(panel_5);


		rdbtnNewRadioButton = new JRadioButton("Morale");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setActionCommand("Morale");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdbtnNewRadioButton);
		panel_5.add(rdbtnNewRadioButton);


		btnNewButton = new JRadioButton("Physique");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setActionCommand("Physique");
		buttonGroup.add(btnNewButton);
		panel_5.add(btnNewButton);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(392, 89, 260, 69);
		panelfournisseur.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_2_2 = new JLabel("Fax:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 10, 74, 32);
		panel_6.add(lblNewLabel_2_2);

		textFieldfax = new TextField();
		textFieldfax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldfax.setColumns(10);
		textFieldfax.setBounds(95, 10, 155, 32);


		panel_6.add(textFieldfax);

		JLabel labelfax = new JLabel("");
		labelfax.setForeground(Color.RED);
		labelfax.setBounds(45, 52, 205, 13);
		panel_6.add(labelfax);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBounds(61, 174, 270, 69);
		panelfournisseur.add(panel_6_1);

		JLabel lblNewLabel_2_2_1 = new JLabel("NumFix:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(10, 10, 74, 32);
		panel_6_1.add(lblNewLabel_2_2_1);

		TextField textFieldNumFix = new TextField();
		textFieldNumFix.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNumFix.setColumns(10);
		textFieldNumFix.setBounds(95, 10, 155, 32);
		panel_6_1.add(textFieldNumFix);


		labelnumfix = new JLabel("");
		labelnumfix.setForeground(Color.RED);
		labelnumfix.setBounds(45, 52, 205, 13);
		panel_6_1.add(labelnumfix);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setLayout(null);
		panel_6_2.setBounds(393, 177, 308, 66);
		panelfournisseur.add(panel_6_2);

		JLabel lblNewLabel_2_2_2 = new JLabel("NumPortable:");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(10, 10, 115, 32);
		panel_6_2.add(lblNewLabel_2_2_2);

		TextField textFieldnumportable;
		textFieldnumportable = new TextField();
		textFieldnumportable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldnumportable.setColumns(10);
		textFieldnumportable.setBounds(135, 10, 155, 32);
		panel_6_2.add(textFieldnumportable);

		JLabel labelnumportable = new JLabel("");
		labelnumportable.setForeground(Color.RED);
		labelnumportable.setBounds(85, 52, 205, 13);
		panel_6_2.add(labelnumportable);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(61, 340, 390, 69);
		panelfournisseur.add(panel_3_1);

		JLabel lblNewLabel_2_3 = new JLabel("Etat Fiscale:");
		lblNewLabel_2_3.setToolTipText("Ajussti a la TVA ou Non");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 10, 115, 32);
		panel_3_1.add(lblNewLabel_2_3);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(135, 10, 245, 32);
		panel_3_1.add(panel_7);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("OUI");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setActionCommand("OUI");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NON");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(rdbtnNewRadioButton_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(61, 253, 300, 66);
		panelfournisseur.add(panel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("EMAIL:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 10, 92, 32);
		panel_2_1.add(lblNewLabel_1_1);

		textFieldEmail = new TextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(112, 10, 161, 32);
		panel_2_1.add(textFieldEmail);

		JLabel labelemail = new JLabel("");
		labelemail.setForeground(Color.RED);
		labelemail.setBounds(36, 52, 205, 13);
		panel_2_1.add(labelemail);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(393, 253, 308, 66);
		panelfournisseur.add(panel_2_2);

		JLabel lblNewLabel_1_2 = new JLabel("SiteWeb:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 10, 92, 32);
		panel_2_2.add(lblNewLabel_1_2);

		textFieldSiteweb = new TextField();
		textFieldSiteweb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSiteweb.setColumns(10);
		textFieldSiteweb.setBounds(112, 10, 186, 32);
		panel_2_2.add(textFieldSiteweb);

		JLabel labelsiteweb = new JLabel("");
		labelsiteweb.setForeground(Color.RED);
		labelsiteweb.setBounds(93, 53, 205, 13);
		panel_2_2.add(labelsiteweb);

		JPanel paneladdress = new JPanel();
		tabbedPane.addTab("Address", null, paneladdress, null);
		paneladdress.setLayout(null);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBounds(56, 10, 583, 69);
		paneladdress.add(panel_3_2);

		JLabel lblNewLabel_2_4 = new JLabel("Numero Route:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(69, 10, 124, 32);
		panel_3_2.add(lblNewLabel_2_4);

		textFieldnumeroroute = new TextField();
		textFieldnumeroroute.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldnumeroroute.setColumns(10);
		textFieldnumeroroute.setBounds(256, 10, 155, 32);
		panel_3_2.add(textFieldnumeroroute);

		JLabel labelnumroute = new JLabel("");
		labelnumroute.setForeground(Color.RED);
		labelnumroute.setBounds(256, 52, 155, 13);
		panel_3_2.add(labelnumroute);

		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBounds(56, 89, 583, 69);
		paneladdress.add(panel_3_2_1);

		JLabel lblNewLabel_2_4_1 = new JLabel("Libelle:");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4_1.setBounds(69, 10, 124, 32);
		panel_3_2_1.add(lblNewLabel_2_4_1);

		textFieldlibelle = new TextField();
		textFieldlibelle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldlibelle.setColumns(10);
		textFieldlibelle.setBounds(256, 10, 155, 32);
		panel_3_2_1.add(textFieldlibelle);

		JLabel labellibelle = new JLabel("");
		labellibelle.setForeground(Color.RED);
		labellibelle.setBounds(256, 52, 155, 13);
		panel_3_2_1.add(labellibelle);

		JPanel panel_3_2_2 = new JPanel();
		panel_3_2_2.setLayout(null);
		panel_3_2_2.setBounds(56, 161, 583, 52);
		paneladdress.add(panel_3_2_2);

		JLabel lblNewLabel_2_4_2 = new JLabel("Ville:");
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4_2.setBounds(69, 10, 124, 32);
		panel_3_2_2.add(lblNewLabel_2_4_2);

		JComboBox comboBoxvile = new JComboBox();
		comboBoxvile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxvile.setBounds(255, 12, 155, 32);
		panel_3_2_2.add(comboBoxvile);
		comboBoxvile.setModel(new DefaultComboBoxModel(new String[]{"Tunis", "Ariana", "Ben Arous", "Manouba", "Nabeul", "Zaghouan", "Bizerte", "B\u00E9ja", "Jendouba", "Kef", "Siliana", "Sousse", "Monastir", "Mahdia", "Sfax", "Kairouan", "Kasserine", "Sidi Bouzid", "Gab\u00E8s", "Mednine", "Tataouine", "Gafsa", "Tozeur", "Kebili"}));
		comboBoxvile.setMaximumRowCount(24);
		comboBoxvile.setMaximumRowCount(8);

		JPanel panel_3_2_3 = new JPanel();
		panel_3_2_3.setLayout(null);
		panel_3_2_3.setBounds(56, 295, 583, 69);
		paneladdress.add(panel_3_2_3);

		JLabel lblNewLabel_2_4_3 = new JLabel("Gouvernourat:");
		lblNewLabel_2_4_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4_3.setBounds(69, 10, 124, 32);
		panel_3_2_3.add(lblNewLabel_2_4_3);

		JLabel labelgouvernourat = new JLabel("");
		labelgouvernourat.setForeground(Color.RED);
		labelgouvernourat.setBounds(251, 46, 155, 13);
		panel_3_2_3.add(labelgouvernourat);

		textFieldgouvernourat = new TextField();
		textFieldgouvernourat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldgouvernourat.setColumns(10);
		textFieldgouvernourat.setBounds(251, 10, 155, 32);
		panel_3_2_3.add(textFieldgouvernourat);

		JPanel panel_3_2_3_1 = new JPanel();
		panel_3_2_3_1.setLayout(null);
		panel_3_2_3_1.setBounds(56, 374, 583, 69);
		paneladdress.add(panel_3_2_3_1);

		JLabel lblNewLabel_2_4_3_1 = new JLabel("Pays:");
		lblNewLabel_2_4_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4_3_1.setBounds(69, 10, 124, 32);
		panel_3_2_3_1.add(lblNewLabel_2_4_3_1);

		JLabel labelpays = new JLabel("");
		labelpays.setForeground(Color.RED);
		labelpays.setBounds(249, 46, 155, 13);
		panel_3_2_3_1.add(labelpays);

		textFieldpays = new TextField();
		textFieldpays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldpays.setColumns(10);
		textFieldpays.setBounds(249, 10, 155, 32);
		panel_3_2_3_1.add(textFieldpays);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(56, 223, 583, 62);
		paneladdress.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_2_4_1_1 = new JLabel("Code Postal:");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4_1_1.setBounds(67, 10, 124, 32);
		panel_8.add(lblNewLabel_2_4_1_1);

		TextField textFieldcodepostal = new TextField();
		textFieldcodepostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldcodepostal.setColumns(10);
		textFieldcodepostal.setBounds(254, 10, 155, 32);
		panel_8.add(textFieldcodepostal);

		JLabel labelcodepostal = new JLabel("");
		labelcodepostal.setForeground(Color.RED);
		labelcodepostal.setBounds(254, 49, 155, 13);
		panel_8.add(labelcodepostal);

		JPanel panelbank = new JPanel();
		tabbedPane.addTab("BankAccounts", null, panelbank, null);
		panelbank.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 63, 296, 261);
		panelbank.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"RIB", "BankName", "agence"
				}
		) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBounds(388, 63, 270, 66);
		panelbank.add(panel_2_3);

		JLabel lblNewLabel_1_3 = new JLabel("RIB:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 10, 35, 32);
		panel_2_3.add(lblNewLabel_1_3);

		textFieldRib = new TextField();
		textFieldRib.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRib.setColumns(10);
		textFieldRib.setBounds(55, 10, 205, 32);
		panel_2_3.add(textFieldRib);

		JLabel labelrib = new JLabel("");
		labelrib.setForeground(Color.RED);
		labelrib.setBounds(36, 52, 205, 13);
		panel_2_3.add(labelrib);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBounds(388, 139, 270, 66);
		panelbank.add(panel_2_4);

		JLabel lblNewLabel_1_4 = new JLabel("BankName:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(10, 10, 92, 32);
		panel_2_4.add(lblNewLabel_1_4);

		textFieldbankname = new TextField();
		textFieldbankname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldbankname.setColumns(10);
		textFieldbankname.setBounds(112, 10, 128, 32);
		panel_2_4.add(textFieldbankname);

		JLabel labelbankname = new JLabel("");
		labelbankname.setForeground(Color.RED);
		labelbankname.setBounds(36, 52, 205, 13);
		panel_2_4.add(labelbankname);

		JPanel panel_2_5 = new JPanel();
		panel_2_5.setLayout(null);
		panel_2_5.setBounds(388, 216, 270, 66);
		panelbank.add(panel_2_5);

		JLabel lblNewLabel_1_5 = new JLabel("Agence:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(10, 10, 92, 32);
		panel_2_5.add(lblNewLabel_1_5);

		textFieldagence = new TextField();
		textFieldagence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldagence.setColumns(10);
		textFieldagence.setBounds(112, 10, 128, 32);
		panel_2_5.add(textFieldagence);

		JLabel labelagence = new JLabel("");
		labelagence.setForeground(Color.RED);
		labelagence.setBounds(36, 52, 205, 13);
		panel_2_5.add(labelagence);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(388, 292, 283, 39);
		panelbank.add(panel_1);

		JButton btnaddaccount = new JButton("Ajouter");
		panel_1.add(btnaddaccount);

		JButton btneditaccount = new JButton("Modifier");
		panel_1.add(btneditaccount);

		JButton btndeleteaccount = new JButton("Supprimer");
		panel_1.add(btndeleteaccount);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				panelClient.frame.setEnabled(false);

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				panelClient.frame.setEnabled(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				panelClient.frame.setEnabled(true);

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				panelClient.frame.setEnabled(true);

			}

		});

		textFieldfax.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldfax.getText().trim().length() != 8) {
					labelfax.setForeground(Color.RED);
					labelfax.setText("invalide");
				} else {
					if (Saisie.isNumeric(textFieldfax.getText().trim())) {
						labelfax.setForeground(Color.GREEN);
						labelfax.setText("valide");
					}
				}

			}
		});
		textFieldNumFix.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldNumFix.getText().trim().length() != 8) {
					labelnumfix.setForeground(Color.RED);
					labelnumfix.setText("invalide");
				} else {
					if (Saisie.isNumeric(textFieldNumFix.getText().trim())) {
						labelnumfix.setForeground(Color.GREEN);
						labelnumfix.setText("valide");
					}
				}

			}
		});
		textFieldnumportable.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldnumportable.getText().trim().length() != 8) {
					labelnumportable.setForeground(Color.RED);
					labelnumportable.setText("invalide");
				} else {
					if (Saisie.isNumeric(textFieldnumportable.getText().trim())) {
						labelnumportable.setForeground(Color.GREEN);
						labelnumportable.setText("valide");
					}
				}

			}
		});
		textFieldraison.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldraison.getText().trim())) {
					labelraison.setForeground(Color.GREEN);
					labelraison.setText("valide");
				} else {
					labelraison.setForeground(Color.RED);
					labelraison.setText("invalide");
				}
			}
		});
		textFieldmatricule.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkmatricule(textFieldmatricule.getText().trim())) {
					labelmatricule.setForeground(Color.GREEN);
					labelmatricule.setText("valide");
				} else {
					labelmatricule.setForeground(Color.RED);
					labelmatricule.setText("invalide");
				}
			}
		});
		textFieldEmail.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldEmail.getText().length() == 0) {
					labelemail.setText("");
					return;
				}
				if (Saisie.emailisValid(textFieldEmail.getText().trim())) {
					labelemail.setForeground(Color.GREEN);
					labelemail.setText("valide");
				} else {
					labelemail.setForeground(Color.RED);
					labelemail.setText("invalide");
				}
			}
		});
		textFieldnumeroroute.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.isNumeric(textFieldnumeroroute.getText().trim())) {
					labelnumroute.setForeground(Color.GREEN);
					labelnumroute.setText("valide");
				} else {
					labelnumroute.setForeground(Color.RED);
					labelnumroute.setText("invalide");
				}
			}
		});
		textFieldgouvernourat.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldgouvernourat.getText().trim())) {
					labelgouvernourat.setForeground(Color.GREEN);
					labelgouvernourat.setText("valide");
				} else {
					labelgouvernourat.setForeground(Color.RED);
					labelgouvernourat.setText("invalide");
				}
			}
		});
		textFieldpays.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldpays.getText().trim())) {
					labelpays.setForeground(Color.GREEN);
					labelpays.setText("valide");
				} else {
					labelpays.setForeground(Color.RED);
					labelpays.setText("invalide");
				}
			}
		});
		textFieldlibelle.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldlibelle.getText().trim())) {
					labellibelle.setForeground(Color.GREEN);
					labellibelle.setText("valide");
				} else {
					labellibelle.setForeground(Color.RED);
					labellibelle.setText("invalide");
				}
			}
		});
		textFieldRib.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (!Saisie.isRibUnique(textFieldRib.getText().trim())) {
					labelrib.setForeground(Color.RED);
					labelrib.setText("RIB existe deja");
					return;
				}
				if (Saisie.checkRib(textFieldRib.getText().trim())) {
					labelrib.setForeground(Color.GREEN);
					labelrib.setText("valide");
				} else {
					labelrib.setForeground(Color.RED);
					labelrib.setText("invalide");
				}

			}
		});
		textFieldbankname.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldbankname.getText().trim())) {
					labelbankname.setForeground(Color.GREEN);
					labelbankname.setText("valide");
				} else {
					labelbankname.setForeground(Color.RED);
					labelbankname.setText("invalide");
				}
			}
		});
		textFieldagence.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldagence.getText().trim())) {
					labelagence.setForeground(Color.GREEN);
					labelagence.setText("valide");
				} else {
					labelagence.setForeground(Color.RED);
					labelagence.setText("invalide");
				}
			}
		});
		textFieldcodepostal.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldcodepostal.getText().trim().length() != 4) {
					labelcodepostal.setForeground(Color.RED);
					labelcodepostal.setText("invalide");
				} else {
					if (Saisie.isNumeric(textFieldcodepostal.getText().trim())) {
						labelcodepostal.setForeground(Color.GREEN);
						labelcodepostal.setText("valide");
					}
				}

			}
		});

		btnAjouterClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				if (!Saisie.checkmatricule(textFieldmatricule.getText().trim())) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"matricule doit etre sous la forme 0744801M/NC/000",
							"Matricule invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldraison.getText().trim())) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"une raison sociale (qui peut être simplement nom et prénom)",
							"Raison invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldfax.getText().trim()) && textFieldfax.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Fax doit etre composé de 8 chiffre",
							"Fax invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldnumportable.getText().trim()) && textFieldnumportable.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Num Portable doit etre composé de 8 chiffre",
							"Num Portable invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldNumFix.getText().trim()) && textFieldNumFix.getText().trim().length() == 8)) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Num Fix doit etre composé de 8 chiffre",
							"Num Fix invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textFieldEmail.getText().length() != 0) {
					if (!Saisie.emailisValid(textFieldEmail.getText().trim())) {
						JOptionPane.showMessageDialog(AjouterFournisseur.this,
								"Email doit etre sous format aaaaa@aaaa.aa",
								"Email Invalid", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
				//todo site web to do here

				if (!Saisie.isNumeric(textFieldnumeroroute.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Numero Route doit etre compose seulment des chiffres",
							"Numero Route Invalid", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldlibelle.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Libelle doit etre copose seulement des letres",
							"Libelle invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(Saisie.isNumeric(textFieldcodepostal.getText().trim()) && textFieldcodepostal.getText().trim().length() == 4)) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Code postal doit etre composé de 4 chiffres",
							"Code postal invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldgouvernourat.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"gouvernourat doit etre copose seulement des letres",
							"gouvernourat invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFieldpays.getText().trim())) {
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"pays doit etre copose seulement des letres",
							"pays invalide", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (getaccounts() == null) {
					tabbedPane.setSelectedIndex(2);
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Le fournisseur doit avoir un compte au minimum",
							"BankAccounts Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				FournisseurService fournisseurService = new FournisseurService();
				ArrayList<BankAccount> bankAccounts = getaccounts();
				Address address = new Address(textFieldnumeroroute.getText().trim(),
						textFieldlibelle.getText().trim()
						, comboBoxvile.getSelectedItem().toString(),
						textFieldcodepostal.getText().trim()
						, textFieldgouvernourat.getText().trim(), textFieldpays.getText().trim());

				boolean etat = false;
				if (buttonGroup_1.getSelection().getActionCommand() == "OUI") {
					etat = true;
				}
				fournisseurService.add(

						new Client(textFieldmatricule.getText().trim(),
								textFieldraison.getText().trim(),
								buttonGroup.getSelection().getActionCommand(), bankAccounts, address,
								textFieldfax.getText().trim(), textFieldNumFix.getText().trim(),
								textFieldnumportable.getText().trim(), textFieldEmail.getText().trim(),
								textFieldSiteweb.getText().trim(), etat,
								CodeService.getCode("Fournisseur"))
				);

				panelClient.updatedata();
				JTable table = panelClient.getTable();
				table.scrollRectToVisible(table.getCellRect(table.getRowCount() - 1, 0, true));
				table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1);
				panelClient.frame.setVisible(true);
				panelClient.btnModifier.setEnabled(true);
				panelClient.btnSupprimer.setEnabled(true);
				AjouterFournisseur.this.dispose();


			}
		});
		btndeleteaccount.setEnabled(false);
		btneditaccount.setEnabled(false);
		btnaddaccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Saisie.isRibUnique(textFieldRib.getText().trim())) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"RIB Saisie Deja existant invalid",
							"RIB Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (verifrib(textFieldRib.getText().trim()) == false) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Rib deja existant",
							"Rib Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldagence.getText().trim()) == false) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Agence invalid",
							"Agence Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldbankname.getText().trim()) == false) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"bankname invalid",
							"bankname Error", JOptionPane.ERROR_MESSAGE);

					return;
				}
				((DefaultTableModel) table.getModel()).addRow(new Object[]{
						textFieldRib.getText().trim(),
						textFieldbankname.getText().trim(),
						textFieldagence.getText().trim()
				});
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount() > 0) {
					btndeleteaccount.setEnabled(true);
					btneditaccount.setEnabled(true);
				} else {
					btndeleteaccount.setEnabled(false);
					btneditaccount.setEnabled(false);
				}
				int row = table.getSelectedRow();
				textFieldRib.setText(table.getValueAt(row, 0).toString());
				textFieldbankname.setText(table.getValueAt(row, 1).toString());
				textFieldagence.setText(table.getValueAt(row, 2).toString());
			}
		});
		btneditaccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (!Saisie.isRibUnique(textFieldRib.getText().trim())) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"RIB Saisie Deja existant invalid",
							"RIB Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldagence.getText().trim()) == false) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"Agence invalid",
							"Agence Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Saisie.checkraison(textFieldbankname.getText().trim()) == false) {
					JOptionPane.showMessageDialog(AjouterFournisseur.this,
							"bankname invalid",
							"bankname Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				table.getModel().setValueAt(textFieldRib.getText(), row, 0);
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

	}

	/**
	 * verifier le rib dans le tableau interne
	 **/
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

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AjouterClient dialog = new AjouterClient();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
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
}
