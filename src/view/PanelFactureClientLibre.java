package view;

import controller.BonFournisseur_ProduitServices;
import controller.FactureClientLibreService;
import controller.TableNames;
import models.FactureFournisseurLibre;
import models.Produit;
import test.AfficherFacture;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelFactureClientLibre extends JPanel {
	private final JTable table;
	private final JTable table_produit;
	private final TableRowSorter<TableModel> rowSorter;
	JEditorPane filtre;
	PanelVentes2 panelVentes;

	/**
	 * Create the panel.
	 */
	public PanelFactureClientLibre(PanelVentes2 panelVentes) {
		this.panelVentes = panelVentes;
		setLayout(new BorderLayout(0, 0));


		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);

		JButton btnAjouter = new JButton("Ajouter");
		panel_3.add(btnAjouter);

		JButton btnAfficher = new JButton("Afficher");
		panel_3.add(btnAfficher);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Rechereche");
		lblNewLabel.setIcon(new ImageIcon(PanelFactureClientLibre.class.getResource("/resource/icons8-rechercher-plus-35.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_4.add(lblNewLabel);

		filtre = new JEditorPane();
		panel_4.add(filtre);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		panel_2.add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		splitPane.setDividerLocation(300);

		table = new MyTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"ID", "Code", "Client", "DateBon", "DateReception", "Information", "PrixHorsTva",
						"Total", "ModePayement"
				}
		) {
			final Class[] types = {Integer.class, String.class, String.class, Date.class, Date.class,
					String.class, Double.class, Double.class, String.class
			};

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_1);

		table_produit = new MyTable();
		table_produit.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Ref", "Produit", "Quantité", "Prix", "TVA"
				}
		));
		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = filtre.getText();
				table.clearSelection();

				while ((table_produit.getRowCount() > 0)) {
					((DefaultTableModel) table_produit.getModel()).removeRow(0);
				}
				//btnModifier.setEnabled(false);
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = filtre.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});
		table_produit.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
		//table_produit.setRowSelectionAllowed(false);
		scrollPane_1.setViewportView(table_produit);
		updatedata();
		/*table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("pressed");

				//int code=Integer.parseInt((String) tablecategory.getValueAt(tablecategory.getSelectedRow(),0));

			}
		});*/
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					String a = table.getValueAt(table.getSelectedRow(), 1).toString();
					updateproduit(a);
				}

			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AjouterFactureClientLibre ac = new AjouterFactureClientLibre(PanelFactureClientLibre.this);
				ac.setVisible(true);


			}
		});
		btnAfficher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FactureClientLibreService fservice = new FactureClientLibreService();
				AfficherFacture.afficherfacture(fservice.getone(table.getValueAt(
						table.getSelectedRow(), 1
				).toString()));
			}
		});


	}

	public void updatedata() {
		while ((table.getRowSorter().getModelRowCount() > 0)) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		FactureClientLibreService factureservice = new FactureClientLibreService();
		ArrayList<FactureFournisseurLibre> list = factureservice.gettout();
		for (int i = 0; i < list.size(); i++) {
			FactureFournisseurLibre facture = list.get(i);
			Object[] data = {facture.getId(),
					facture.getCode(),
					facture.getFournisseur().getRaison(),
					facture.getDatedebon(),
					facture.getDatedereception(),
					facture.getInformation(),
					facture.getPrixhorstva(),
					facture.getPrixtotal(),
					facture.getModepayment(),
			};

			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}

	public void updateproduit(String bon_code) {
		while ((table_produit.getRowCount() > 0)) {
			((DefaultTableModel) table_produit.getModel()).removeRow(0);
		}
		BonFournisseur_ProduitServices bsp = new BonFournisseur_ProduitServices(TableNames.factureclient_produit);
		HashMap<Produit, Integer> hashMap = bsp.getproducts(bon_code);
		hashMap.forEach((produit, value) -> {
			Object[] data = {
					produit.getReference(),
					produit.getDesignation(),
					value,
					produit.getPrixunitaire(),
					produit.getTva()
			};
			((DefaultTableModel) table_produit.getModel()).addRow(data);
		});

	}

}
