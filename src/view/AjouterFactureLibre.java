package view;

import controller.CodeService;
import controller.FactureFournisseurLibreService;
import controller.FournisseurService;
import controller.ProduitService;
import models.Address;
import models.Client;
import models.FactureFournisseurLibre;
import models.Produit;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AjouterFactureLibre extends JDialog {
	private final JTextField textFieldinformation;
	private final MyTable table_produit;
	private final MyTable table_panier;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Date date;
	JComboBox comboBox;
	Client fournisseur;
	PanelFactureLibre panelFactureLibre;
	JLabel totalhorstva;
	JLabel ttc;

	/**
	 * Create the dialog.
	 */
	public AjouterFactureLibre(PanelFactureLibre panelFactureLibre) {

		super(panelFactureLibre.panelAchats.frame, "Ajouter Facture Libre");
		this.panelFactureLibre = panelFactureLibre;
		this.getParent().setEnabled(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 563);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tabbedPane.setBounds(10, 10, 708, 459);
		getContentPane().add(tabbedPane);

		JPanel panelfournisseur = new JPanel();
		panelfournisseur.setBorder(null);
		tabbedPane.addTab("Fournisseur", null, panelfournisseur, null);
		panelfournisseur.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1.setBounds(10, 10, 479, 50);
		panelfournisseur.add(panel_1);

		JLabel lblNewLabel = new JLabel("Fournisseur");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 142, 30);
		panel_1.add(lblNewLabel);
		FournisseurService fs = new FournisseurService();
		ArrayList<Client> listforunisseur = fs.getAll();

		comboBox = new JComboBox();

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(195, 10, 280, 30);
		for (int i = 0; i < listforunisseur.size(); i++) {
			comboBox.addItem(listforunisseur.get(i));
		}
		panel_1.add(comboBox);


		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_1.setBounds(10, 83, 479, 50);
		panelfournisseur.add(panel_1_1);

		JLabel lblDateDeRecption = new JLabel("Date de Reception");
		lblDateDeRecption.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateDeRecption.setBounds(10, 10, 142, 30);
		panel_1_1.add(lblDateDeRecption);

		JSpinner spinnerdate = new JSpinner();

		spinnerdate.setModel(new SpinnerDateModel(new Date(System.currentTimeMillis()), null, null, Calendar.DAY_OF_YEAR));
		date = (Date) spinnerdate.getValue();
		spinnerdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerdate.setBounds(195, 10, 280, 30);
		panel_1_1.add(spinnerdate);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_2.setBounds(10, 164, 479, 50);
		panelfournisseur.add(panel_1_2);

		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInformation.setBounds(10, 10, 142, 30);
		panel_1_2.add(lblInformation);

		textFieldinformation = new JTextField();
		textFieldinformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldinformation.setBounds(195, 10, 280, 30);
		panel_1_2.add(textFieldinformation);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_2_1.setBounds(10, 244, 479, 119);
		panelfournisseur.add(panel_1_2_1);

		JLabel lblModePayement = new JLabel("Mode Payement:");
		lblModePayement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModePayement.setBounds(10, 10, 142, 30);
		panel_1_2_1.add(lblModePayement);

		JRadioButton radioespece = new JRadioButton("Espece");
		radioespece.setActionCommand("Espèce");
		buttonGroup.add(radioespece);
		radioespece.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioespece.setSelected(true);
		radioespece.setBounds(40, 65, 103, 21);
		panel_1_2_1.add(radioespece);

		JRadioButton radiocheque = new JRadioButton("Cheque");
		radiocheque.setActionCommand("Cheque");
		buttonGroup.add(radiocheque);
		radiocheque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radiocheque.setBounds(145, 65, 103, 21);
		panel_1_2_1.add(radiocheque);

		JRadioButton radiovirement = new JRadioButton("Virement");
		radiovirement.setActionCommand("Virement");
		buttonGroup.add(radiovirement);
		radiovirement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radiovirement.setBounds(260, 65, 103, 21);
		panel_1_2_1.add(radiovirement);

		JPanel panelproduit = new JPanel();
		panelproduit.setBorder(null);
		tabbedPane.addTab("Produit", null, panelproduit, null);
		panelproduit.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Liste Des Produit");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 25, 166, 28);
		panelproduit.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 298, 172);
		panelproduit.add(scrollPane);

		table_produit = new MyTable();
		table_produit.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Ref", "Designation", "Stock", "Prix"
				}
		));
		table_produit.setRowHeight(15);
		table_produit.setHeaderFontsize(14);
		table_produit.settablefontsize(12);
		scrollPane.setViewportView(table_produit);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(343, 0, 2, 446);
		panelproduit.add(separator);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(366, 63, 324, 172);
		panelproduit.add(scrollPane_1);

		table_panier = new MyTable();
		table_panier.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Ref", "Designation", "Qté"
				}
		));
		table_panier.setHeaderFontsize(14);
		table_panier.settablefontsize(12);
		table_panier.setRowHeight(15);
		scrollPane_1.setViewportView(table_panier);

		JLabel lblNewLabel_1_1 = new JLabel("Panier");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(368, 25, 166, 28);
		panelproduit.add(lblNewLabel_1_1);

		JButton btnAjouterPanier = new JButton("Ajouter au Panier");
		btnAjouterPanier.setBounds(97, 330, 136, 21);
		panelproduit.add(btnAjouterPanier);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 256, 181, 50);
		panelproduit.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Quantit\u00E9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 10, 55, 30);
		panel_2.add(lblNewLabel_2);

		JSpinner spinner_quantite_produit = new JSpinner();
		spinner_quantite_produit.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinner_quantite_produit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_quantite_produit.setBounds(93, 18, 50, 20);
		panel_2.add(spinner_quantite_produit);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(435, 263, 200, 43);
		panelproduit.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Qt\u00E9");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 10, 34, 28);
		panel_3.add(lblNewLabel_3);

		JSpinner spinner_quantite_panier = new JSpinner();
		spinner_quantite_panier.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinner_quantite_panier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_quantite_panier.setBounds(41, 14, 50, 20);
		panel_3.add(spinner_quantite_panier);

		JButton btnmodifier = new JButton("Modifier");
		btnmodifier.setBounds(101, 13, 85, 21);
		panel_3.add(btnmodifier);

		JButton btnsupprimer = new JButton("Supprimer");
		btnsupprimer.setBounds(498, 316, 85, 21);
		panelproduit.add(btnsupprimer);

		JLabel lblNewLabel_4 = new JLabel("TotalHorsTVA:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(463, 364, 102, 21);
		panelproduit.add(lblNewLabel_4);


		totalhorstva = new JLabel("");
		totalhorstva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalhorstva.setBounds(573, 364, 102, 21);
		panelproduit.add(totalhorstva);

		JLabel lblNewLabel_4_1 = new JLabel("TTC:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(451, 395, 102, 21);
		panelproduit.add(lblNewLabel_4_1);


		ttc = new JLabel("");
		ttc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ttc.setBounds(573, 395, 102, 21);
		panelproduit.add(ttc);

		JPanel panel = new JPanel();
		panel.setBounds(205, 476, 320, 40);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(57, 5, 85, 26);
		panel.add(btnAjouter);

		JButton btncCancel = new JButton("Annuller");
		btncCancel.setBounds(162, 5, 85, 26);
		panel.add(btncCancel);
		fournisseur = (Client) comboBox.getSelectedItem();
		updatetableproduit(fournisseur.getCode());
		btnAjouterPanier.setEnabled(false);
		btnmodifier.setEnabled(false);
		btnsupprimer.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				AjouterFactureLibre.this.getParent().setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				AjouterFactureLibre.this.getParent().setEnabled(true);
			}

		});
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				fournisseur = (Client) comboBox.getSelectedItem();
				while (table_panier.getRowCount() > 0) {
					((DefaultTableModel) table_panier.getModel()).removeRow(0);
				}
				table_produit.clearSelection();
				updatetableproduit(fournisseur.getCode());
			}
		});
		/*table_produit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (table_produit.getSelectedRowCount()>0){
					btnAjouterPanier.setEnabled(true);
				}
			}
		});*/
		table_produit.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table_produit.getSelectedRowCount() > 0) {

					if (checkpanier(table_produit.getValueAt(table_produit.getSelectedRow(), 0).toString())) {
						int qte = Integer.parseInt(table_produit.getValueAt(table_produit.getSelectedRow(), 2).toString());
						btnAjouterPanier.setEnabled(true);
						/*spinner_quantite_produit.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0),
								new Integer(qte)
								, new Integer(1)));*/
					} else {
						btnAjouterPanier.setEnabled(false);
					}
				}
			}
		});
		btnAjouterPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_produit.getSelectedRow();
				//System.out.println(checkpanier(table_produit.getValueAt(row,0).toString()));
				((DefaultTableModel) table_panier.getModel()).addRow(new Object[]{
						table_produit.getValueAt(row, 0),
						table_produit.getValueAt(row, 1),
						spinner_quantite_produit.getValue()
				});
				updateprix();
				btnAjouterPanier.setEnabled(false);

			}
		});
		table_panier.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table_panier.getSelectedRowCount() > 0) {
					ProduitService ps = new ProduitService();
					Produit p = ps.get(table_panier.getValueAt(table_panier.getSelectedRow(), 0).toString());
					/*System.out.println(p.getStock());
					spinner_quantite_panier.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0),
							new Integer(p.getStock())
							, new Integer(1)));*/
					btnmodifier.setEnabled(true);
					btnsupprimer.setEnabled(true);
				}
			}
		});
		btnmodifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				table_panier.getModel().setValueAt(
						spinner_quantite_panier.getValue(),
						table_panier.getSelectedRow(),
						2
				);
				updateprix();

			}
		});
		btnsupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_panier.getSelectedRow();
				((DefaultTableModel) table_panier.getModel()).removeRow(row);
				if (table_panier.getRowCount() == 0) {
					btnmodifier.setEnabled(false);
					btnsupprimer.setEnabled(false);
				}

				updateprix();
			}
		});
		btncCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AjouterFactureLibre.this.getParent().setVisible(true);
				AjouterFactureLibre.this.dispose();

			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client f = (Client) comboBox.getSelectedItem();
				Date d = (Date) spinnerdate.getValue();
				if (d.before(date)) {
					JOptionPane.showMessageDialog(AjouterFactureLibre.this,
							"date de reception doit etre superieur a aujourd'hui",
							"bankname invalid", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!(table_panier.getRowCount() > 0)) {
					JOptionPane.showMessageDialog(AjouterFactureLibre.this,
							"il faut ajouter au minimum un produit",
							"Aucun produit ajouter", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String modepayment = buttonGroup.getSelection().getActionCommand();
				java.sql.Date date = new java.sql.Date(d.getTime());
				FactureFournisseurLibre facture = new FactureFournisseurLibre(1, CodeService.getCode("Facture"),
						f,
						date,
						date,
						new Address(),
						textFieldinformation.getText(),
						getproducts(),
						modepayment);
				FactureFournisseurLibreService bfs = new FactureFournisseurLibreService();
				bfs.add(facture, facture.getModepayment());
				AjouterFactureLibre.this.panelFactureLibre.updatedata();
				((MainWindow) AjouterFactureLibre.this.panelFactureLibre.panelAchats.frame).panelProduits.updatedata();
				JOptionPane.showMessageDialog(AjouterFactureLibre.this,
						"Facture ajouter avec succes",
						"Succes", JOptionPane.INFORMATION_MESSAGE);
				AjouterFactureLibre.this.getParent().setVisible(true);
				AjouterFactureLibre.this.dispose();

			}
		});
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AjouterBon dialog = new AjouterBon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public void updatetableproduit(String key) {
		while (table_produit.getRowCount() > 0) {
			((DefaultTableModel) table_produit.getModel()).removeRow(0);
		}
		ProduitService ps = new ProduitService();
		ArrayList<Produit> list = ps.getbyfournisseur(key);
		for (int i = 0; i < list.size(); i++) {
			Produit p = list.get(i);
			Object[] data = {
					p.getReference(),
					p.getDesignation(),
					p.getStock(),
					p.getPrixunitaire()
			};
			((DefaultTableModel) table_produit.getModel()).addRow(data);
		}
	}

	public boolean checkpanier(String key) {
		for (int row = 0; row < table_panier.getRowCount(); row++) {

			if (table_panier.getValueAt(row, 0).equals(key)) {
				return false;
			}
		}
		return true;
	}

	public void updateprix() {
		double totalhtva = 0;
		double tva = 0;
		ProduitService ps = new ProduitService();
		for (int row = 0; row < table_panier.getRowCount(); row++) {
			int qte = Integer.parseInt(table_panier.getValueAt(row, 2).toString());
			Produit p = ps.get(table_panier.getValueAt(row, 0).toString());
			totalhtva += p.getPrixunitaire() * qte;
			tva += ((p.getPrixunitaire() * p.getTva()) / 100) * qte;
		}
		ttc.setText(String.valueOf(totalhtva + tva));
		totalhorstva.setText(String.valueOf(totalhtva));

	}

	public HashMap<Produit, Integer> getproducts() {
		HashMap<Produit, Integer> hmap = new HashMap<>();
		ProduitService ps = new ProduitService();
		for (int i = 0; i < table_panier.getRowCount(); i++) {
			hmap.put(ps.get(table_panier.getValueAt(i, 0).toString()),
					(Integer) table_panier.getValueAt(i, 2));
		}

		return hmap;
	}
}
