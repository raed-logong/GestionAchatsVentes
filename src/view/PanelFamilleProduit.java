package view;

import controller.FamilleProduitService;
import controller.ProduitService;
import models.FamilleProduit;
import models.Produit;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelFamilleProduit extends JPanel {
	private final JTable tablecategory;
	private final JTable tableproduit;

	/**
	 * Create the panel.
	 */
	public PanelFamilleProduit(MainWindow frame) {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("Listes Des Categories");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setIcon(new ImageIcon(PanelFamilleProduit.class.getResource("/resource/icons8-liste-64.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(300);
		panel_1.add(splitPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();

		panel_2.add(panel_4, BorderLayout.NORTH);

		JButton btnAjouter = new JButton("Ajouter");
		panel_4.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		panel_4.add(btnModifier);

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		tablecategory = new MyTable();
		tablecategory.setModel(new DefaultTableModel(
									   new Object[][]{
									   },
									   new String[]{
											   "Code", "Designation"
									   }
							   ) {


							   }
		);
		scrollPane.setViewportView(tablecategory);

		JPanel panel_3 = new JPanel();
		splitPane.setRightComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));


		JLabel lblNewLabel_1 = new JLabel("Liste des produit de la categorie selectionne:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);

		tableproduit = new MyTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				//  Alternate row color
				ProduitService ps = new ProduitService();
				if (!isRowSelected(row)) {
					Produit p = ps.get(getValueAt(row, 0).toString());
					if (p.getStock() <= p.getStockminimal())
						c.setBackground(Color.RED);
					else {
						c.setBackground(Color.white);
					}

				}
				return c;
			}
		};
		tableproduit.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Reference", "Fournisseur", "Stock", "Prix"
				}
		));
		tableproduit.setRowSelectionAllowed(false);
		scrollPane_1.setViewportView(tableproduit);
		updatedata();
		btnModifier.setEnabled(false);
		tablecategory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (tablecategory.getSelectedRow() >= 0) {
					btnModifier.setEnabled(true);

					//int code=Integer.parseInt((String) tablecategory.getValueAt(tablecategory.getSelectedRow(),0));
					int a = Integer.parseInt(tablecategory.getValueAt(tablecategory.getSelectedRow(), 0).toString());
					updateproduit(a);
				}
			}

		});
		tablecategory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE) {
					tablecategory.getSelectionModel().clearSelection();
					tablecategory.clearSelection();
					btnModifier.setEnabled(false);
					while (tableproduit.getRowCount() > 0) {
						((DefaultTableModel) tableproduit.getModel()).removeRow(0);
					}

				}

			}
		});
	}

	public void updatedata() {
		while (tablecategory.getRowCount() > 0) {
			((DefaultTableModel) tablecategory.getModel()).removeRow(0);
		}
		FamilleProduitService fps = new FamilleProduitService();
		ArrayList<FamilleProduit> list = fps.getall();
		for (int i = 0; i < list.size(); i++) {
			FamilleProduit fp = list.get(i);
			Object[] data = {
					fp.getCode(),
					fp.getDesignation()
			};
			((DefaultTableModel) tablecategory.getModel()).addRow(data);
		}

	}

	public void updateproduit(int code) {
		while (tableproduit.getRowCount() > 0) {
			((DefaultTableModel) tableproduit.getModel()).removeRow(0);
		}
		ProduitService ps = new ProduitService();
		ArrayList<Produit> list = ps.getbyfamille(code);
		for (int i = 0; i < list.size(); i++) {
			Produit p = list.get(i);
			Object[] data = {
					p.getReference(),
					p.getFournisseur().getRaison(),
					p.getStock(),
					p.getPrixunitaire()

			};
			((DefaultTableModel) tableproduit.getModel()).addRow(data);
		}
	}

}
