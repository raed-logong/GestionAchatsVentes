package view;

import controller.ProduitService;
import models.Produit;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PanelProduits extends JPanel {
	private final JTable table;
	private final TableRowSorter<TableModel> rowSorter;
	JFrame frame;
	JButton btnModifier;
	JButton btnSupprimer;

	public PanelProduits(MainWindow frame) {
		this.frame = frame;
		setLayout(new BorderLayout());
		//this.setSize(1175, 585);


		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(10, 104, 1155, 471);
		scrollPane.setBackground(Color.WHITE);
		add(scrollPane, BorderLayout.CENTER);

		table = new MyTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				//  Alternate row color

				if (!isRowSelected(row)) {
					if (Integer.parseInt(getValueAt(row, 6).toString()) <= Integer.parseInt(getValueAt(row, 7).toString()))
						c.setBackground(Color.YELLOW);
					else
						c.setBackground(Color.WHITE);

				}
				return c;
			}
		};


		Dimension dimension = new Dimension(100, 50);
		table.getTableHeader().setMinimumSize(dimension);
		table.getTableHeader().setFont(new Font(Font.SERIF, Font.BOLD, 25));
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Id", "Reference", "Designation", "Unite", "Fournisseur",
						"FamilleProduit", "Stock", "StockMin", "Prix Unitaire", "TVA"
				}
		) {
			final Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class,
					Integer.class, Integer.class,
					Double.class, Double.class};

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return types[columnIndex];
			}


		});
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setMinimumSize(new Dimension(100, 100));
		//table.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,18));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new java.awt.Color(232, 57, 124));
		table.setRowHeight(30);

		table.setFont(new Font("Tahoma", Font.PLAIN, 17));

		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Listes Des Produit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-liste-64.png")));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		JLabel lblNewLabel_1 = new JLabel("Recherche");
		lblNewLabel_1.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-rechercher-plus-35.png")));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_1);
		JEditorPane filtre = new JEditorPane();
		filtre.setSize(200, 100);
		filtre.setToolTipText("recherche");
		filtre.setFont(new Font("Arial", Font.BOLD, 19));
		panel_1.add(filtre);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-ajouter-16.png")));
		btnAjouter.setToolTipText("Ajouter un Produit");
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-modifier-16.png")));
		btnModifier.setToolTipText("Modifier le Produit selectionné");
		btnModifier.setEnabled(false);
		panel_2.add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-supprimer-16.png")));
		btnSupprimer.setToolTipText("Supprimer le Produit selectionné\r\n");
		btnSupprimer.setEnabled(false);
		panel_2.add(btnSupprimer);
		updatedata();
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterProduit ac = new AjouterProduit(PanelProduits.this);
				ac.getParent().setEnabled(false);
				ac.setVisible(true);


			}
		});
		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				table.updateUI();
				String text = filtre.getText();
				table.clearSelection();
				btnModifier.setEnabled(false);
				btnSupprimer.setEnabled(false);
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				table.updateUI();
				String text = filtre.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);

					//updatedata();
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		});
		/*table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRowCount()>0) {
					btnSupprimer.setEnabled(true);
					btnModifier.setEnabled(true);
				}
			}



		});*/
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRowCount() > 0) {
					btnSupprimer.setEnabled(true);
					btnModifier.setEnabled(true);
				}
			}
		});
		table.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE) {
					table.clearSelection();
					btnModifier.setEnabled(false);
					btnSupprimer.setEnabled(false);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ProduitService produitService = new ProduitService();
				if (!(table.getSelectionModel().isSelectionEmpty())) {
					table.updateUI();
					int dialogResult = JOptionPane.showConfirmDialog(PanelProduits.this, "Voulez vous supprimer ce" +
									"Produit",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {
						int row = table.getSelectedRow();

						String code = (String) table.getValueAt(row, 1);


						produitService.delete(code);

						updatedata();
					}
				}
				/*if(table.getSelectedRow()<1) {
					btnModifier.setEnabled(false);
					btnSupprimer.setEnabled(false);
				}*/
				if (table.getRowCount() == 0) {
					btnModifier.setEnabled(false);
					btnSupprimer.setEnabled(false);
				}
			}
		});
		btnModifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!(table.getSelectionModel().isSelectionEmpty())) {

					ProduitService produitService = new ProduitService();
					int row = table.getSelectedRow();
					//table.getRowSorter().toggleSortOrder(0);
					int index = table.getRowSorter().convertRowIndexToView(row);
					String code = (String) table.getValueAt(row, 1);
					Produit produit = produitService.get(code);

					ModifierProduit ac = new ModifierProduit(PanelProduits.this, produit);
					ac.getParent().setEnabled(false);
					ac.setVisible(true);


				}

			}
		});


	}

	public JTable getTable() {
		return table;
	}

	/**
	 * Create the panel.
	 */
	public void updatedata() {

		//System.out.println(table.getRowSorter().getViewRowCount());
		while (table.getRowSorter().getModelRowCount() > 0) {

			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		ProduitService produitService = new ProduitService();
		ArrayList<Produit> list = produitService.getAll();
		for (int i = 0; i < list.size(); i++) {
			Produit produit = list.get(i);

			Object[] data = {
					produit.getId(),
					produit.getReference(),
					produit.getDesignation(),
					produit.getUnite(),
					produit.getFournisseur().getRaison(),
					produit.getFamilleProduit().getDesignation(),
					produit.getStock(),
					produit.getStockminimal(),
					produit.getPrixunitaire(),
					produit.getTva()};

			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}
}
