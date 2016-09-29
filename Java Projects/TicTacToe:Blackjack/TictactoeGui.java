import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;


public class TictactoeGui extends GUI
{

	JLabel tableImg;

	public TictactoeGui()
	{
		//creates a new frame to hold the black jack GUI
		JFrame ticTacToe = new JFrame("Tic Tac Toe");
		ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel backPanel = new JPanel(new BorderLayout());
		//JLayeredPane backPanel = new JLayeredPane();

		//reads in the pre-specified background image
		//if an exception is thrown it is caught and the program exits
		try
		{
			BufferedImage background = ImageIO.read(new File("tictactoe.png"));
			tableImg = new JLabel(new ImageIcon(background));
		}
		catch(IOException e)
		{
			System.out.println("The backgorund must be a still image.");
			System.exit(1);
		}


		//tableImg.add(new JButton("Button"));

		backPanel.add(tableImg);


		//creates a menu bar with "File" and "Help" menus
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		menu.add(file);
		JMenu help = new JMenu("Help");
		help.setMnemonic('H');
		menu.add(help);


		//creates the menu item "Quit"
		//calls MenuListener and exits the program
		JMenuItem exit = new JMenuItem("Quit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.ALT_MASK));
		exit.addActionListener(new ExitListener());
		file.add(exit);


		//creates the menu item "About"
		//calls MenuListener and displays the information accordingly
		JMenuItem about = new JMenuItem("About");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.ALT_MASK));
		about.addActionListener(new AboutListener());
		help.add(about);


		//creates the menu item "Get Started"
		//calles StartedListener and displays the info accordingly
		JMenuItem started = new JMenuItem("Get Started");
		started.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.ALT_MASK));
		started.addActionListener(new StartedListener());
		help.add(started);


		ticTacToe.setJMenuBar(menu);




		/*
		*
		*Creates a panel to hold the spot marker buttons and the marker buttons themselves
		*
		*/


		JPanel markerPanel = new JPanel(new GridLayout(3,3,50,50));

		//JLabel markerLabel = new JLabel();

		/*
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));
		markerPanel.add(new JButton(""));


		//backPanel.setBounds(270,250,500,500);

		//markerPanel.add(markerLabel);
		*/
		backPanel.add(markerPanel);

		ticTacToe.getContentPane().add(backPanel);
		//ticTacToe.pack();
		//markerPanel.setVisible(false);
		//ticTacToe.getContentPane().add(markerPanel);

		ticTacToe.pack();
		ticTacToe.setLocationRelativeTo(null);
		ticTacToe.setVisible(true);



	}


	//ActionListener for exiting
	private class ExitListener implements ActionListener
		{

			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		}

		//ActionListener for the About section
		private class AboutListener implements ActionListener
		{
			public void actionPerformed(ActionEvent a)
			{
				//Crates the frame that content will be displayed in
				JFrame aboutFrame = new JFrame("About");
				aboutFrame.setPreferredSize(new Dimension(200,100));

				//creates a new JPanel to hold the text content
				JPanel aboutPanel = new JPanel();
				aboutPanel.setLayout(new BoxLayout(aboutPanel,BoxLayout.Y_AXIS));
				aboutPanel.add(new JLabel("     Awesome Arcade"));
				aboutPanel.add(new JLabel("     Version 1.0"));
				aboutPanel.add(new JLabel("     2014"));


				aboutFrame.getContentPane().add(aboutPanel);
				aboutFrame.pack();
				aboutFrame.setLocationRelativeTo(null);
				aboutFrame.setVisible(true);
			}
		}

		//ActionListener for the Get Started section
		private class StartedListener implements ActionListener
		{
			public void actionPerformed(ActionEvent a)
			{
				//Crates the frame that content will be displayed in
				JFrame startFrame = new JFrame("Get Started");
				startFrame.setPreferredSize(new Dimension(320,150));


				JPanel startPanel = new JPanel();
				startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.Y_AXIS));
				startPanel.add(new JLabel(" "));
				startPanel.add(new JLabel("   To use:"));
				startPanel.add(new JLabel("   1. Select the image file you wish to pixelize"));
				startPanel.add(new JLabel("   2. Select the desired new pixel size"));
				startPanel.add(new JLabel("   3. Have fun pixelating!"));
				startPanel.add(new JLabel(" "));


				startFrame.getContentPane().add(startPanel);
				startFrame.pack();
				startFrame.setLocationRelativeTo(null);
				startFrame.setVisible(true);
			}
		}
}
