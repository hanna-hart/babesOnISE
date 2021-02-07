import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class jukebox {

	public static void main(String[] args) {
		
		new jukebox();
	}
	
	public jukebox() {
		
		launch();
	}
	
	public void launch() {
		// Create window and set size/color
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.magenta);
		window.setLayout(null);
		
		// Create boarder
		
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		// Create panel for jukebox picture
		JPanel jukeboxPanel = new JPanel();
		jukeboxPanel.setBounds(100,220,200,200);
		jukeboxPanel.setBackground(Color.gray);
		window.add(jukeboxPanel);
		
		// Add image
		
		// ImageIcon jukebox = new ImageIcon(getClass().getClassLoader().getResource(""));
		
		// Create Buttons
		JButton jukeboxButton = new JButton();
		jukeboxButton.setBackground(Color.yellow);
		jukeboxButton.setFocusPainted(false);
		//jukeboxButton.setBorder(blackline);
		jukeboxButton.setSize(150, 100);
		//jukeboxButton.setIcon(jukebox);
		jukeboxPanel.add(jukeboxButton);
		
		
		
		window.setVisible(true);
		
		
	}

}
