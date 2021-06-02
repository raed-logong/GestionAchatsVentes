package view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Facture extends JFrame {

	/**
	 * Create the frame.
	 */
	public Facture() {
		setBounds(100, 100, 644, 685);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		editorPane.setEditable(false);
		getContentPane().add(editorPane, BorderLayout.CENTER);
		JButton btn = new JButton("AFficher");
		getContentPane().add(btn, BorderLayout.NORTH);
		File file = new File(System.getProperty("user.dir") + "/" + "src/view/components/facture.html");
		try {
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("haha\n");
			bw.write("hiihihi\n");
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File file = new File(System.getProperty("user.dir") + "/" + "src/view/components/facture.html");
				Desktop desktop = Desktop.getDesktop();

				try {
					desktop.open(file);              //opens the specified file
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}


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
					Facture frame = new Facture();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
