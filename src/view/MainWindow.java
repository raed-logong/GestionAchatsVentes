package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

	private final JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JLayeredPane layeredPane = new JLayeredPane();
	PanelFournisseur panelFournisseur;
	PanelClient panelClient;
	PanelProduits panelProduits;
	PanelFamilleProduit panelFamilleProduit;
	PanelVentes2 panelVentes;
	PanelAchats panelAchats;


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1185, 98);
		contentPane.add(panel, BorderLayout.PAGE_START);
		panel.setLayout(new BorderLayout());

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 5, 1165, 83);
		panel.add(toolBar);

		JToggleButton btnEntreprise = new JToggleButton("Entreprise");
		btnEntreprise.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEntreprise.setSelected(true);

		buttonGroup.add(btnEntreprise);
		btnEntreprise.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-nouvelle-entreprise-50_selected.png")));
		btnEntreprise.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-nouvelle-entreprise-50.png")));
		toolBar.add(btnEntreprise);

		JToggleButton btnFournisseur = new JToggleButton("Fournisseur");
		btnFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(btnFournisseur);
		btnFournisseur.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-fournisseur-50_selected.png")));
		btnFournisseur.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-fournisseur-50.png")));
		toolBar.add(btnFournisseur);

		JToggleButton btnAchats = new JToggleButton("Achats");
		btnAchats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAchats.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-achats-50-selected.png")));
		btnAchats.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-achats-50.png")));
		buttonGroup.add(btnAchats);
		toolBar.add(btnAchats);

		JToggleButton btnClient = new JToggleButton("Client");
		btnClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(btnClient);
		btnClient.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-client_50_selected.png")));
		btnClient.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-client_50.png")));
		toolBar.add(btnClient);

		JToggleButton btnVentes = new JToggleButton("Ventes");
		btnVentes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVentes.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-ventes-50 -selected.png")));
		btnVentes.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-ventes-50.png")));
		buttonGroup.add(btnVentes);
		toolBar.add(btnVentes);

		JToggleButton tglbtnfamilleproduit = new JToggleButton("Famille Produit");
		tglbtnfamilleproduit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tglbtnfamilleproduit.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-category-50-selected.png")));
		tglbtnfamilleproduit.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-category-50.png")));
		buttonGroup.add(tglbtnfamilleproduit);

		toolBar.add(tglbtnfamilleproduit);

		JToggleButton btnProduit = new JToggleButton("Produits");
		btnProduit.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-produit-50-selected.png")));
		btnProduit.setIcon(new ImageIcon(MainWindow.class.getResource("/resource/icons8-produit-50.png")));
		btnProduit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(btnProduit);
		toolBar.add(btnProduit);


		//layeredPane.setBounds(10, 118, 1175, 585);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(1, 0));

		PanelEntreprise panelEntreprise = new PanelEntreprise();
		layeredPane.add(panelEntreprise, "name_613080563914100");


		panelFournisseur = new PanelFournisseur(this);
		layeredPane.add(panelFournisseur, "name_613092475580000");


		panelAchats = new PanelAchats(this);
		layeredPane.add(panelAchats, "name_613116113861900");


		panelClient = new PanelClient(this);
		layeredPane.add(panelClient, "name_613134499799500");


		panelVentes = new PanelVentes2(this);
		layeredPane.add(panelVentes, "name_613143969213300");


		panelProduits = new PanelProduits(this);
		layeredPane.add(panelProduits, "name_613162045195200");


		panelFamilleProduit = new PanelFamilleProduit(this);
		layeredPane.add(panelFamilleProduit, "name_890379232718000");

		btnEntreprise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelEntreprise);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnFournisseur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelFournisseur);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnAchats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelAchats);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelClient);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnVentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelVentes);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnProduit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelProduits);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		tglbtnfamilleproduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelFamilleProduit);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
