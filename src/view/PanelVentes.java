package view;

import javax.swing.*;
import java.awt.*;

public class PanelVentes extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelVentes() {
		setLayout(null);
		this.setSize(1175, 585);
		JLabel lblNewLabel = new JLabel("ventes to do");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		lblNewLabel.setBounds(368, 239, 462, 118);
		add(lblNewLabel);

	}

}
