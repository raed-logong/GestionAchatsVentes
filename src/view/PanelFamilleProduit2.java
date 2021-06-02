package view;

import controller.FamilleProduitService;
import controller.ProduitService;
import models.FamilleProduit;
import models.Produit;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PanelFamilleProduit2 extends JPanel {
	private final JTable tablecategory;
	private final JTable tableproduit;
	private final TableRowSorter<TableModel> rowSorter;

	public PanelFamilleProduit2(MainWindow frame) {
		this.setSize(1175, 585);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(28, 22, 814, 74);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Liste Des Categories");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(10, 5, 502, 59);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 118, 1133, 457);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 75, 346, 302);
		panel_1.add(scrollPane);

		tablecategory = new JTable();
		tablecategory.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Code", "Designation"
				}

		) {
			final Class[] types = {Integer.class, String.class};

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return this.types[columnIndex];
			}


			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tablecategory.setDefaultRenderer(Object.class, new MyRenderer());
		MyRenderer renderer = new MyRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		tablecategory.getColumnModel().getColumn(0).setCellRenderer(renderer);
		tablecategory.getTableHeader().setFont(new Font(Font.SERIF, Font.BOLD, 25));
		tablecategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tablecategory.setFocusable(false);
		scrollPane.setViewportView(tablecategory);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(486, 75, 637, 300);
		panel_1.add(scrollPane_1);

		tableproduit = new JTable() {
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
		) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableproduit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableproduit);
		rowSorter = new TableRowSorter<>(tablecategory.getModel());
		tablecategory.setRowSorter(rowSorter);
		JLabel lblNewLabel_1 = new JLabel("Liste des Produit de la categorie selectionn\u00E9e");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(490, 26, 339, 56);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(208, 35, 196, 31);
		panel_1.add(panel_2);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setToolTipText("Ajouter une categorie\r\n");
		panel_2.add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setToolTipText("Modifier Category\r\n");
		btnModifier.setEnabled(false);
		panel_2.add(btnModifier);

		JEditorPane filtre = new JEditorPane();
		filtre.setBounds(61, 45, 107, 19);
		panel_1.add(filtre);
		updatedata();
		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = filtre.getText();
				tablecategory.clearSelection();
				btnModifier.setEnabled(false);
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
		/*tablecategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(tablecategory.getSelectedRowCount()>0) {

					btnModifier.setEnabled(true);
				}
				//int code=Integer.parseInt((String) tablecategory.getValueAt(tablecategory.getSelectedRow(),0));
				int a=Integer.parseInt( tablecategory.getValueAt(tablecategory.getSelectedRow(),0).toString());
				updateproduit(a);
			}
		});*/
		tablecategory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {


				btnModifier.setEnabled(true);

				//int code=Integer.parseInt((String) tablecategory.getValueAt(tablecategory.getSelectedRow(),0));
				int a = Integer.parseInt(tablecategory.getValueAt(tablecategory.getSelectedRow(), 0).toString());
				updateproduit(a);
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

	/**
	 * Create the panel.
	 */
	public void updatedata() {
		while (tablecategory.getRowSorter().getModelRowCount() > 0) {
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

	public class MyRenderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setBorder(noFocusBorder);
			return this;
		}

	}
}
