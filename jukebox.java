import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jukebox {

	JLabel counterLabel, perSecLabel;
	Font font1, font2;
	int clickCount;
	SongCountCounter songCounter = new SongCountCounter();
	
	
	public static void main(String[] args) {
		
		new jukebox();
	}
	
	public jukebox() {
		
		clickCount = 0;
		createFont();
		
		launch();
	}
	
	public void createFont() {
		font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
	}
	
	public void launch() {
		// Create window and set size/color
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.magenta);
		window.setLayout(null);
		
		
		// Create panel for jukebox picture
		JPanel jukeboxPanel = new JPanel();
		jukeboxPanel.setBounds(100,220,200,200);
		jukeboxPanel.setBackground(Color.magenta);
		window.add(jukeboxPanel);
		
		// Panel for click count
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100,100,250,100);
		counterPanel.setBackground(Color.magenta);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		
		// Initialize labels
		
		counterLabel = new JLabel(clickCount + " song credits");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(counterLabel);
		
		// Add image
		ImageIcon jukebox = new ImageIcon(getClass().getClassLoader().getResource("transparentjukebox.png"));
		
		// Create Buttons
		JButton jukeboxButton = new JButton();
		jukeboxButton.setBackground(Color.magenta);
		jukeboxButton.setFocusPainted(false);
		jukeboxButton.setIcon(jukebox);
		jukeboxButton.addActionListener(songCounter);
		jukeboxPanel.add(jukeboxButton);
		
		
		
		window.setVisible(true);
		
		
	}
	
    public void playMusic() {       


    }
	
	
	public class SongCountCounter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			clickCount++;
			counterLabel.setText(clickCount + " song credits");
		}
		
	}



}


