package view;

import ControlleSaisie.Saisie;
import controller.FamilleProduitService;
import controller.FournisseurService;
import controller.ProduitService;
import models.Client;
import models.FamilleProduit;
import models.Produit;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ModifierProduit extends JDialog {
	JComboBox comboBoxfamille;
	Label textFieldfournisseur;

	JTable tabefournisseur;
	PanelProduits panelProduits;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AjouterProduit dialog = new AjouterProduit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ModifierProduit(PanelProduits panelproduit, Produit produit) {

		this.panelProduits = panelproduit;
		AjouterProduit.Selectedfournisseur selected = new AjouterProduit.Selectedfournisseur();
		panelproduit.frame.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 620);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("MenuBar.border"));
		panel.setBounds(10, 10, 466, 58);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reference:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 134, 33);
		panel.add(lblNewLabel);

		TextField textFieldreference = new TextField();
		textFieldreference.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldreference.setBounds(145, 0, 311, 31);
		panel.add(textFieldreference);

		Label labelrefrence = new Label("");
		labelrefrence.setBounds(145, 35, 311, 15);
		panel.add(labelrefrence);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1.setBounds(10, 71, 466, 58);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Designation:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 0, 134, 33);
		panel_1.add(lblNewLabel_1);

		TextField textFielddesignation = new TextField();
		textFielddesignation.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFielddesignation.setBounds(145, 0, 311, 31);
		panel_1.add(textFielddesignation);

		Label labeldesignation = new Label("");
		labeldesignation.setBounds(145, 37, 59, 11);
		panel_1.add(labeldesignation);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_2.setBounds(10, 132, 466, 51);
		getContentPane().add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("Unit\u00E9:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 0, 134, 33);
		panel_2.add(lblNewLabel_2);

		TextField textFieldunite = new TextField();
		textFieldunite.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldunite.setBounds(145, 0, 311, 31);
		panel_2.add(textFieldunite);

		Label labelunite = new Label("");
		labelunite.setBounds(145, 37, 59, 12);
		panel_2.add(labelunite);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_3.setBounds(10, 193, 466, 51);
		getContentPane().add(panel_3);

		JLabel lblNewLabel_3 = new JLabel("Fournisseur:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(0, 0, 134, 33);
		panel_3.add(lblNewLabel_3);

		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSelect.setBounds(371, 0, 95, 33);
		panel_3.add(btnSelect);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(144, 0, 223, 41);
		panel_3.add(panel_6);
		panel_6.setLayout(null);

		textFieldfournisseur = new Label();
		textFieldfournisseur.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldfournisseur.setBounds(10, 3, 209, 30);
		panel_6.add(textFieldfournisseur);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_1.setBounds(10, 254, 466, 39);
		getContentPane().add(panel_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("FamilleProduit:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(0, 0, 134, 33);
		panel_1_1.add(lblNewLabel_1_1);

		comboBoxfamille = new JComboBox();
		comboBoxfamille.setBounds(145, 0, 311, 31);
		panel_1_1.add(comboBoxfamille);
		FamilleProduitService fps = new FamilleProduitService();
		ArrayList<FamilleProduit> listcategoy = fps.getall();
		for (int i = 0; i < listcategoy.size(); i++) {
			comboBoxfamille.addItem(listcategoy.get(i).toString());

		}

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_2_1.setBounds(10, 303, 466, 39);
		getContentPane().add(panel_2_1);

		JLabel lblNewLabel_2_1 = new JLabel("Stock:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(0, 0, 134, 33);
		panel_2_1.add(lblNewLabel_2_1);

		JSpinner spinnerstock = new JSpinner();
		spinnerstock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerstock.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinnerstock.setBounds(145, 0, 311, 31);
		panel_2_1.add(spinnerstock);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_4.setBounds(10, 352, 466, 39);
		getContentPane().add(panel_4);

		JLabel lblNewLabel_4 = new JLabel("Stockmin:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(0, 0, 134, 33);
		panel_4.add(lblNewLabel_4);

		JSpinner spinnerstockmin = new JSpinner();
		spinnerstockmin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerstockmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerstockmin.setBounds(145, 0, 311, 31);
		panel_4.add(spinnerstockmin);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_2.setBounds(10, 401, 466, 39);
		getContentPane().add(panel_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("PrixUnitaire:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(0, 0, 134, 33);
		panel_1_2.add(lblNewLabel_1_2);

		JSpinner spinnerprixunitaire = new JSpinner();
		spinnerprixunitaire.setModel(new SpinnerNumberModel(new Double(1), new Double(0), null, new Double(1)));
		spinnerprixunitaire.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerprixunitaire.setBounds(145, 0, 311, 31);
		panel_1_2.add(spinnerprixunitaire);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_2_2.setBounds(10, 450, 466, 39);
		getContentPane().add(panel_2_2);

		JLabel lblNewLabel_2_2 = new JLabel("TVA:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(0, 0, 134, 33);
		panel_2_2.add(lblNewLabel_2_2);

		JSpinner spinnertva = new JSpinner();
		spinnertva.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 10.0));
		spinnertva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnertva.setBounds(145, 0, 311, 31);
		panel_2_2.add(spinnertva);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(93, 522, 288, 39);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifier.setBounds(49, 5, 92, 34);
		panel_5.add(btnModifier);
		textFieldreference.setText(produit.getReference());
		textFielddesignation.setText(produit.getDesignation());
		textFieldunite.setText(produit.getUnite());
		textFieldfournisseur.setText(produit.getFournisseur().getRaison());
		selected.selected = produit.getFournisseur().getCode();
		comboBoxfamille.setSelectedItem(produit.getFamilleProduit().getDesignation());
		spinnerstock.setValue(produit.getStock());
		spinnerstockmin.setValue(produit.getStockminimal());
		spinnerprixunitaire.setValue(produit.getPrixunitaire());
		spinnertva.setValue(produit.getTva());
		btnModifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!textFieldreference.getText().trim().equals(produit.getReference())) {
					if (!Saisie.isrefunique(textFieldreference.getText().trim())) {
						JOptionPane.showMessageDialog(ModifierProduit.this,
								"Refrence Saisie Deja existant invalid",
								"Ref Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (!Saisie.checkstring3(textFieldreference.getText().trim())) {
					JOptionPane.showMessageDialog(ModifierProduit.this,
							"Refrence Saisie  invalid",
							"Ref Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkraison(textFielddesignation.getText().trim())) {
					JOptionPane.showMessageDialog(ModifierProduit.this,
							"Designation Saisie  invalid",
							"Designation Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Saisie.checkstring3(textFieldunite.getText().trim())) {
					JOptionPane.showMessageDialog(ModifierProduit.this,
							"Unite Saisie  invalid",
							"Unite Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (selected.selected == null) {
					JOptionPane.showMessageDialog(ModifierProduit.this,
							"Vous avez pas chosie un Fournisseur",
							"Fournisseur Error", JOptionPane.ERROR_MESSAGE);
					return;
				}


				String fp = (String) comboBoxfamille.getItemAt(comboBoxfamille.getSelectedIndex());
				//System.out.println(fps.getByName(fp).getCode());
				FournisseurService fs = new FournisseurService();
				Client f = fs.get(selected.selected);
				ProduitService produitService = new ProduitService();
				produitService.edit(new Produit(produit.getId(), textFieldreference.getText().trim(),
						textFielddesignation.getText().trim(), textFieldunite.getText().trim(), f,
						fps.getByUniqueName(fp), (int) spinnerstock.getValue(), (int) spinnerstockmin.getValue(),
						(double) spinnerprixunitaire.getValue(), (double) spinnertva.getValue()
				));
				panelproduit.updatedata();
				JTable table = panelproduit.getTable();


				//table.getRowSorter().toggleSortOrder(0);
				//table.getRowSorter().convertRowIndexToModel(row)
				//int index=table.getRowSorter().convertRowIndexToView(r);
				table.scrollRectToVisible(table.getCellRect(table.getSelectedRow(), 0, true));
				//table.setRowSelectionInterval(table.getSelectedRow(),table.getSelectedRow());
				panelproduit.frame.setVisible(true);
				panelproduit.frame.setEnabled(true);
				panelproduit.btnModifier.setEnabled(true);
				panelproduit.btnSupprimer.setEnabled(true);
				ModifierProduit.this.dispose();

			}
		});
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnnuler.setBounds(146, 5, 92, 34);
		panel_5.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifierProduit.this.dispose();
				panelproduit.frame.setVisible(true);
			}
		});
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(false);

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(true);

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(false);
				ModifierProduit.this.setVisible(true);

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(false);
				ModifierProduit.this.setVisible(true);

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				panelproduit.frame.setEnabled(true);

			}

		});
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				SelectFournisseur sf = new SelectFournisseur(ModifierProduit.this, textFieldfournisseur, selected);
				ModifierProduit.this.setEnabled(false);
				sf.setVisible(true);
			}
		});
		textFieldreference.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (textFieldreference.getText().equals(produit.getReference())) {
					labelrefrence.setText("");
					return;
				}
				if (!Saisie.isrefunique(textFieldreference.getText().trim())) {
					labelrefrence.setForeground(Color.RED);
					labelrefrence.setText("reference existe deja");
					return;
				}
				if (Saisie.checkstring3(textFieldreference.getText().trim())) {
					labelrefrence.setForeground(Color.GREEN);
					labelrefrence.setText("valide");
				} else {
					labelrefrence.setForeground(Color.RED);
					labelrefrence.setText("invalide");
				}

			}
		});
		textFieldunite.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFieldunite.getText().trim())) {
					labelunite.setForeground(Color.GREEN);
					labelunite.setText("valide");
				} else {
					labelunite.setForeground(Color.RED);
					labelunite.setText("invalide");
				}

			}
		});
		textFielddesignation.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if (Saisie.checkraison(textFielddesignation.getText().trim())) {
					labeldesignation.setForeground(Color.GREEN);
					labeldesignation.setText("valide");
				} else {
					labeldesignation.setForeground(Color.RED);
					labeldesignation.setText("invalide");
				}

			}
		});
	}
}
