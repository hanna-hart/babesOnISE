import java.awt.Color;

import javax.swing.JFrame;

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
		
		window.setVisible(true);
		
		
	}

}
