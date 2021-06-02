package view;

import controller.FactureBl_BonService;
import controller.FactureClientBLService;
import controller.TableNames;
import models.BonFournisseur;
import models.FactureFournisseurBL;
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

public class PanelFactureClientBL extends JPanel {
	private final JTable table;
	private final JTable table_bon;
	private final TableRowSorter<TableModel> rowSorter;
	JEditorPane filtre;
	PanelVentes2 panelVentes;

	/**
	 * Create the panel.
	 */
	public PanelFactureClientBL(PanelVentes2 panelVentes) {
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
		lblNewLabel.setIcon(new ImageIcon(PanelFactureClientBL.class.getResource("/resource/icons8-rechercher-plus-35.png")));
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
						"ID", "Code", "Client", "Date", "PrixHorsTva",
						"Total", "ModePayement"
				}
		) {
			final Class[] types = {Integer.class, String.class, String.class, Date.class,
					Double.class, Double.class, String.class
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

		table_bon = new MyTable();
		table_bon.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Code", "Date", "PrixhorsTVA", "Total"
				}
		));
		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = filtre.getText();
				table.clearSelection();

				while ((table_bon.getRowCount() > 0)) {
					((DefaultTableModel) table_bon.getModel()).removeRow(0);
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
		table_bon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
		//table_bon.setRowSelectionAllowed(false);
		scrollPane_1.setViewportView(table_bon);
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
					updatebon(a);
				}

			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AjouterFactureClientBL ac = new AjouterFactureClientBL(PanelFactureClientBL.this);
				ac.setVisible(true);


			}
		});
		btnAfficher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*FactureFournisseurBLService fservice=new FactureFournisseurBLService();
				AfficherFactureBL.afficherfacture(fservice.get(table.getValueAt(
						table.getSelectedRow(),1
				).toString()));*/
			}
		});


	}

	public void updatedata() {
		while ((table.getRowSorter().getModelRowCount() > 0)) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		FactureClientBLService ffbl = new FactureClientBLService();
		ArrayList<FactureFournisseurBL> list = ffbl.getAll();
		for (int i = 0; i < list.size(); i++) {
			FactureFournisseurBL f = list.get(i);
			Object[] data = {
					f.getId(),
					f.getCode(),
					f.getFournisseur(),
					f.getDate(),
					f.getTotalhorstva(),
					f.getTotal(),
					f.getModepayment()
			};
			((DefaultTableModel) table.getModel()).addRow(data);
		}

	}

	public void updatebon(String facture_code) {
		while ((table_bon.getRowCount() > 0)) {
			((DefaultTableModel) table_bon.getModel()).removeRow(0);
		}
		FactureBl_BonService bsp = new FactureBl_BonService(TableNames.factureclientbl_bon);
		ArrayList<BonFournisseur> list = bsp.getbons(facture_code);
		for (int i = 0; i < list.size(); i++) {
			BonFournisseur f = list.get(i);
			Object[] data = {
					f.getCode(),
					f.getDatedebon(),
					f.getPrixhorstva(),
					f.getPrixtotal()
			};
			((DefaultTableModel) table_bon.getModel()).addRow(data);
		}

	}

}
