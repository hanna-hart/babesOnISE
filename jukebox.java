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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class jukebox {

	JLabel counterLabel, perSecLabel, songNameLabel;
	JFrame window;
	JPanel songNamePanel;
	JButton fiftiesButton;
	Font font1, font2;
	int clickCount;
	SongCountCounter songCounter = new SongCountCounter();
	fiftiesAction fiftiesListener = new fiftiesAction();
	sixtiesAction sixtiesListener = new sixtiesAction();
	seventiesAction seventiesListener = new seventiesAction();
	eightiesAction eightiesListener = new eightiesAction();
	ninetiesAction ninetiesListener = new ninetiesAction();
	
	
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
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);
		
		
		// Create panel for jukebox picture
		JPanel jukeboxPanel = new JPanel();
		jukeboxPanel.setBounds(100,220,200,200);
		jukeboxPanel.setBackground(Color.gray);
		window.add(jukeboxPanel);
		
		// Panel for click count
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100,100,250,100);
		counterPanel.setBackground(Color.gray);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		
		// Panel for 50s,60s,70s,80s,90s buttons
		
		JPanel songPanel = new JPanel();
		songPanel.setBounds(400,170,320,250);
		songPanel.setBackground(Color.gray);
		songPanel.setLayout(new GridLayout(5,1));
		window.add(songPanel);
		
		// Panel for song name
		
		songNamePanel = new JPanel();
		songNamePanel.setBounds(100,450,400,50);
		songNamePanel.setBackground(Color.gray);
		window.add(songNamePanel);
		
		
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
		jukeboxButton.setBackground(Color.gray);
		jukeboxButton.setFocusPainted(false);
		jukeboxButton.setIcon(jukebox);
		jukeboxButton.addActionListener(songCounter);
		jukeboxPanel.add(jukeboxButton);
		
		fiftiesButton = new JButton();
		fiftiesButton.setBackground(Color.yellow);
		songPanel.add(fiftiesButton);
		
		JButton sixtiesButton = new JButton();
		sixtiesButton.setBackground(Color.yellow);
		sixtiesButton.addActionListener(sixtiesListener);
		songPanel.add(sixtiesButton);
		
		JButton seventiesButton = new JButton();
		seventiesButton.setBackground(Color.yellow);
		seventiesButton.addActionListener(seventiesListener);
		songPanel.add(seventiesButton);
		
		JButton eightiesButton = new JButton();
		eightiesButton.setBackground(Color.yellow);
		eightiesButton.addActionListener(eightiesListener);
		songPanel.add(eightiesButton);
		
		JButton ninetiesButton = new JButton();
		ninetiesButton.setBackground(Color.yellow);
		ninetiesButton.addActionListener(ninetiesListener);
		songPanel.add(ninetiesButton);
		
		// Song Labels
		JLabel fiftiesLabel = new JLabel("Song from the 50's (50 song credits)");
		fiftiesLabel.setForeground(Color.black);
		fiftiesLabel.setFont(font2);
		fiftiesButton.addActionListener(fiftiesListener);
		fiftiesButton.add(fiftiesLabel);
		
		JLabel sixtiesLabel = new JLabel("Song from the 60's (60 song credits)");
		sixtiesLabel.setForeground(Color.black);
		sixtiesLabel.setFont(font2);
		sixtiesButton.add(sixtiesLabel);
		
		JLabel seventiesLabel = new JLabel("Song from the 70's (70 song credits)");
		seventiesLabel.setForeground(Color.black);
		seventiesLabel.setFont(font2);
		seventiesButton.add(seventiesLabel);
		
		JLabel eightiesLabel = new JLabel("Song from the 80's (80 song credits)");
		eightiesLabel.setForeground(Color.black);
		eightiesLabel.setFont(font2);
		eightiesButton.add(eightiesLabel);
		
		JLabel ninetiesLabel = new JLabel("Song from the 90's (90 song credits)");
		ninetiesLabel.setForeground(Color.black);
		ninetiesLabel.setFont(font2);
		ninetiesButton.add(ninetiesLabel);
		
		songNameLabel = new JLabel();
		songNameLabel.setForeground(Color.white);
		songNameLabel.setFont(font2);
		songNamePanel.add(songNameLabel);
		
		window.setVisible(true);
		
		
	}
	
//	public void playFiftiesMusic() {
//	       
//		try{
//	    	     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("C:\\Users\\hanna\\Documents\\OU\\Spring 2021\\Hacklahoma\\babesOnISE\\Fifties.mp3"));
//	    	     Clip clip = AudioSystem.getClip();
//	    	     clip.open(audioInputStream);
//	    	     clip.start( );
//	    	    }
//	    	   catch(Exception ex){  
//	    	   }
//
//	}
	
	public class SongCountCounter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			clickCount++;
			counterLabel.setText(clickCount + " song credits");
			//playMusic();
		}
		
	}
	
	public class fiftiesAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if (clickCount >= 50) {
				songNameLabel.setText("You are listening to 'I Got a Woman' by Ray Charles");
				//playFiftiesMusic();
			}
		}
	}
	
	public class sixtiesAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if (clickCount >= 60) {
				songNameLabel.setText("You are listening to 'I Got You' by James Brown");
				//playFiftiesMusic();
			}
		}
		
	}
	
	public class seventiesAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if (clickCount >= 7) {
				songNameLabel.setText("You are listening to 'Don't Go Breaking My Heart' /n by Elton John (Feat. Kiki Dee)");
				//playFiftiesMusic();
			}
		}
		
	}

	public class eightiesAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if (clickCount >= 80) {
				songNameLabel.setText("You are listening to 'You Spin Me Round' by Dead or Alive");
				//playFiftiesMusic();
			}
		}
		
	}
	
	public class ninetiesAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if (clickCount >= 90) {
				songNameLabel.setText("You are listening to 'Gettin' Jiggy Wit It' by Will Smith");
				//playFiftiesMusic();
			}
		}
		
	}

}


