package view;

import controller.ClientService;
import models.Client;
import view.components.MyTable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PanelClient extends JPanel {


	private final MyTable table;
	private final TableRowSorter<TableModel> rowSorter;
	JFrame frame;
	JButton btnSupprimer;
	JButton btnModifier;

	public PanelClient(MainWindow frame) {
		this.frame = frame;
		setLayout(new BorderLayout());
		//this.setSize(1175, 585);


		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(this.getBounds());
		scrollPane.setBackground(Color.WHITE);
		add(scrollPane, BorderLayout.CENTER);

		table = new MyTable();


		Dimension dimension = new Dimension(100, 50);
		table.getTableHeader().setMinimumSize(dimension);
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"Code", "Matricule", "Raison", "Type",
						"NumRue", "Libelle", "Ville", "CodePostal", "Gouvernourat", "Pays",
						"fax", "NumFix", "NumPortable", "Email", "SiteWeb", "Etat"
				}
		) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setBackground(new Color(0, 0, 0, 0));
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

		JLabel lblNewLabel = new JLabel("Listes Des Clients");
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
		btnAjouter.setToolTipText("Ajouter un client");
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-modifier-16.png")));
		btnModifier.setToolTipText("Modifier le client selectionner");
		btnModifier.setEnabled(false);
		panel_2.add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon(PanelClient.class.getResource("/resource/icons8-supprimer-16.png")));
		btnSupprimer.setToolTipText("Supprimer le client selectionner\r\n");
		btnSupprimer.setEnabled(false);
		panel_2.add(btnSupprimer);
		updatedata();

		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
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
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterClient ac = new AjouterClient(PanelClient.this);
				ac.getParent().setEnabled(false);
				ac.setVisible(true);


			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientService clientService = new ClientService();
				if (!(table.getSelectionModel().isSelectionEmpty())) {
					int dialogResult = JOptionPane.showConfirmDialog(PanelClient.this, "Voulez vous supprimer ce" +
									"Client",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {
						int[] rows = table.getSelectedRows();
						for (int i = 0; i < rows.length; i++) {
							String code = (String) table.getValueAt(rows[i], 0);
							clientService.delete(code);
						}
						updatedata();
					}
				}
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

					ClientService clientService = new ClientService();
					int row = table.getSelectedRow();
					String code = (String) table.getValueAt(row, 0);
					Client client = clientService.get(code);
					ModifierClient ac = new ModifierClient(PanelClient.this, client, row);
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
		while (table.getRowSorter().getModelRowCount() > 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		ClientService clientservice = new ClientService();
		ArrayList<Client> list = clientservice.getAll();
		for (int i = 0; i < list.size(); i++) {
			Client client = list.get(i);
			Object[] data = {client.getCode(), client.getMatricule(), client.getRaison(),
					client.getType(),
					client.getAddress().getNumeroRue(), client.getAddress().getLibelle(),
					client.getAddress().getVille(), client.getAddress().getCodePostal(),
					client.getAddress().getGouvernourat(), client.getAddress().getPays(),
					client.getFax(), client.getNumFix(), client.getNumPortable(),
					client.getEmail(), client.getSiteWeb(), client.getEtat().toString()};

			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}
}
