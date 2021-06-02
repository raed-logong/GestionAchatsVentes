package view;

import controller.FournisseurService;
import models.Client;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class SelectFournisseur extends JDialog {
	private final JTable table;
	private final TableRowSorter<TableModel> rowSorter;

	/**
	 * Create the dialog.
	 */
	public SelectFournisseur(JDialog dialog, Label labelfournisseur, AjouterProduit.Selectedfournisseur selected) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 416, 174);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"code", "raison"
				}
		) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);

		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSelect.setBounds(157, 221, 121, 32);
		getContentPane().add(btnSelect);

		JEditorPane filtre = new JEditorPane();
		filtre.setBounds(10, 10, 113, 19);
		getContentPane().add(filtre);
		updatedata();
		table.setRowSelectionInterval(0, 0);
		filtre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = filtre.getText();

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
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				//panelproduit.frame.setEnabled(false);

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dialog.setEnabled(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				dialog.setEnabled(true);

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				//panelproduit.frame.setEnabled(false);
				//AjouterProduit.this.setVisible(true);

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				//panelproduit.frame.setEnabled(false);
				//AjouterProduit.this.setVisible(true);

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				//panelproduit.frame.setEnabled(true);

			}

		});
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				selected.selected = table.getValueAt(index, 0).toString();
				labelfournisseur.setText(table.getValueAt(index, 1).toString());
				dialog.setEnabled(true);
				SelectFournisseur.this.dispose();
			}
		});

	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFournisseur dialog = new SelectFournisseur();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void updatedata() {
		while (table.getRowCount() > 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		FournisseurService fournisseurService = new FournisseurService();
		ArrayList<Client> list = fournisseurService.getAll();
		for (int i = 0; i < list.size(); i++) {
			Client fournisseur = list.get(i);

			Object[] data = {
					fournisseur.getCode(),
					fournisseur.getRaison()
			};

			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}
}
