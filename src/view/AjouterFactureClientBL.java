package view;

import controller.BonClientService;
import controller.ClientService;
import controller.CodeService;
import controller.FactureClientBLService;
import models.BonFournisseur;
import models.Client;
import models.FactureFournisseurBL;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class AjouterFactureClientBL extends JDialog {
	private final MyTable table_bon;
	private final MyTable table_panier;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Date date;
	JComboBox comboBox;
	Client fournisseur;
	PanelFactureClientBL panelFactureClientBL;
	JLabel totalhorstva;
	JLabel ttc;

	/**
	 * Create the dialog.
	 */
	public AjouterFactureClientBL(PanelFactureClientBL panelFactureClientBL) {

		super(panelFactureClientBL.panelVentes.frame, "Ajouter Facture Client BL");
		this.panelFactureClientBL = panelFactureClientBL;
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
		ClientService fs = new ClientService();
		ArrayList<Client> listforunisseur = fs.getAll();

		comboBox = new JComboBox();

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(195, 10, 280, 30);
		for (int i = 0; i < listforunisseur.size(); i++) {
			comboBox.addItem(listforunisseur.get(i));
		}
		panel_1.add(comboBox);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_1_2_1.setBounds(10, 98, 479, 119);
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
		tabbedPane.addTab("BonsReceptions", null, panelproduit, null);
		panelproduit.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Liste Des Bons");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 25, 166, 28);
		panelproduit.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 298, 172);
		panelproduit.add(scrollPane);

		table_bon = new MyTable();
		table_bon.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Code", "TotalhorsTva", "TTC"
				}
		));
		table_bon.setRowHeight(15);
		table_bon.setHeaderFontsize(14);
		table_bon.settablefontsize(12);
		scrollPane.setViewportView(table_bon);

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
						"Code", "TotalhorsTva", "TTC"
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
		btnAjouterPanier.setBounds(97, 283, 136, 35);
		panelproduit.add(btnAjouterPanier);

		JButton btnsupprimer = new JButton("Supprimer");
		btnsupprimer.setBounds(478, 283, 115, 35);
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
		updatetablebon(fournisseur.getCode());
		btnAjouterPanier.setEnabled(false);
		btnsupprimer.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				AjouterFactureClientBL.this.getParent().setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				AjouterFactureClientBL.this.getParent().setEnabled(true);
			}

		});
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				fournisseur = (Client) comboBox.getSelectedItem();
				while (table_panier.getRowCount() > 0) {
					((DefaultTableModel) table_panier.getModel()).removeRow(0);
				}
				table_bon.clearSelection();
				updatetablebon(fournisseur.getCode());
			}
		});
		/*table_bon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (table_bon.getSelectedRowCount()>0){
					btnAjouterPanier.setEnabled(true);
				}
			}
		});*/
		table_bon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table_bon.getSelectedRowCount() > 0) {
					System.out.println(checkpanier(table_bon.getValueAt(table_bon.getSelectedRow(), 0).toString()));
					btnAjouterPanier.setEnabled(checkpanier(table_bon.getValueAt(table_bon.getSelectedRow(), 0).toString()));

				}
			}
		});
		btnAjouterPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_bon.getSelectedRow();
				((DefaultTableModel) table_panier.getModel()).addRow(new Object[]{
						table_bon.getValueAt(row, 0),
						table_bon.getValueAt(row, 1),
						table_bon.getValueAt(row, 2)

				});
				updateprix();
				btnAjouterPanier.setEnabled(false);

			}
		});
		table_panier.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table_panier.getSelectedRowCount() > 0) {
					btnsupprimer.setEnabled(true);
				}
			}
		});
		btnsupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_panier.getSelectedRow();
				((DefaultTableModel) table_panier.getModel()).removeRow(row);
				if (table_panier.getRowCount() == 0) {

					btnsupprimer.setEnabled(false);
				}

				updateprix();
			}
		});
		btncCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AjouterFactureClientBL.this.getParent().setVisible(true);
				AjouterFactureClientBL.this.dispose();

			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client f = (Client) comboBox.getSelectedItem();

				if (!(table_panier.getRowCount() > 0)) {
					JOptionPane.showMessageDialog(AjouterFactureClientBL.this,
							"il faut ajouter au minimum un Bon",
							"Aucun Bon ajouter", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String modepayment = buttonGroup.getSelection().getActionCommand();
				FactureFournisseurBL facture = new FactureFournisseurBL(1, CodeService.getCode("FactureBL"),
						f, new java.sql.Date(System.currentTimeMillis()), modepayment, getbons());
				FactureClientBLService fbls = new FactureClientBLService();
				fbls.add(facture);

				AjouterFactureClientBL.this.panelFactureClientBL.updatedata();
				JOptionPane.showMessageDialog(AjouterFactureClientBL.this,
						"Facture ajouter avec succes",
						"Succes", JOptionPane.INFORMATION_MESSAGE);
				AjouterFactureClientBL.this.getParent().setVisible(true);
				AjouterFactureClientBL.this.dispose();

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
	public void updatetablebon(String key) {
		while (table_bon.getRowCount() > 0) {
			((DefaultTableModel) table_bon.getModel()).removeRow(0);
		}
		BonClientService bfs = new BonClientService();
		ArrayList<BonFournisseur> list = bfs.getByFournisseur(key);
		for (int i = 0; i < list.size(); i++) {
			BonFournisseur bon = list.get(i);
			Object[] data = {
					bon.getCode(),
					bon.getPrixhorstva(),
					bon.getPrixtotal()
			};
			((DefaultTableModel) table_bon.getModel()).addRow(data);
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
		for (int i = 0; i < table_panier.getRowCount(); i++) {
			totalhtva += Double.parseDouble(table_panier.getValueAt(i, 1).toString());
			tva += Double.parseDouble(table_panier.getValueAt(i, 2).toString());
		}
		totalhorstva.setText(String.valueOf(totalhtva));
		ttc.setText(String.valueOf(tva));

	}

	public ArrayList<BonFournisseur> getbons() {
		ArrayList<BonFournisseur> list = new ArrayList<>();
		BonClientService bfs = new BonClientService();
		for (int i = 0; i < table_panier.getRowCount(); i++) {
			BonFournisseur bon = bfs.get(table_panier.getValueAt(i, 0).toString());
			list.add(bon);

		}

		return list;
	}
}
