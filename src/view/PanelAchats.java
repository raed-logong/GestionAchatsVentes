package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAchats extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JLayeredPane layeredPane = new JLayeredPane();
	JFrame frame;

	/**
	 * Create the panel.
	 */
	public PanelAchats(MainWindow frame) {
		this.frame = frame;
		this.setSize(1175, 585);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Gestion des Achats");
		lblNewLabel.setIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-liste-64.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar, BorderLayout.WEST);

		JToggleButton btnBonreception = new JToggleButton("BonReception");

		btnBonreception.setSelected(true);
		btnBonreception.setIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-bonlivraison-50.png")));
		buttonGroup.add(btnBonreception);
		btnBonreception.setSelectedIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-bonlivraison-50-selected.png")));
		btnBonreception.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(btnBonreception);

		JToggleButton btnFactureBL = new JToggleButton("Facture BL");

		btnFactureBL.setSelectedIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-factureBL-50-selected.png")));
		btnFactureBL.setIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-factureBL-50.png")));
		buttonGroup.add(btnFactureBL);
		btnFactureBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(btnFactureBL);

		JToggleButton btnFactureLibre = new JToggleButton("Facture Libre");

		btnFactureLibre.setSelectedIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-facturelibre-50-selected.png")));
		btnFactureLibre.setIcon(new ImageIcon(PanelAchats.class.getResource("/resource/icons8-facturelibre-50.png")));
		buttonGroup.add(btnFactureLibre);
		btnFactureLibre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(btnFactureLibre);

		add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(1, 0));

		PanelBonReception panelBonReception = new PanelBonReception(this);
		layeredPane.add(panelBonReception, "name_107951867347100");

		PanelFactureBL panelFactureBL = new PanelFactureBL(this);
		layeredPane.add(panelFactureBL, "name_107951878570900");


		PanelFactureLibre panelFactureLibre = new PanelFactureLibre(this);
		layeredPane.add(panelFactureLibre, "name_107951889712300");
		btnBonreception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelBonReception);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnFactureBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelFactureBL);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnFactureLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelFactureLibre);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});

	}
}
