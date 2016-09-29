import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Listener implements ActionListener
{

	private char key;
	
	public Listener(char c)
	{

		key = c;
		System.out.println(key);

	}

		
	public void actionPerformed(ActionEvent e)
	{

		new actListener(key);
	}

	private class actListener implements ActionListener
	{
		
		char charKey;

		private actListener(char c)
		{
			charKey = c;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			actionPerformed();
		}


		private void actionPerformed()
		{

			switch(charKey)
			{
				
				case 'q':
					
						System.out.println("Thanks for playing!");
						System.exit(1);

					break;
				
				case 'a':
					
						//Crates the frame that content will be displayed in
						JFrame aboutFrame = new JFrame("About");
						aboutFrame.setPreferredSize(new Dimension(200,100));

						//creates a new JPanel to hold the text content
						JPanel aboutPanel = new JPanel();
						aboutPanel.setLayout(new BoxLayout(aboutPanel,BoxLayout.Y_AXIS));
						aboutPanel.add(new JLabel("     AwesomeArcade"));
						aboutPanel.add(new JLabel("     Version 1.0"));
						aboutPanel.add(new JLabel("     2014"));


						aboutFrame.getContentPane().add(aboutPanel);
						aboutFrame.pack();
						aboutFrame.setLocationRelativeTo(null);
						aboutFrame.setVisible(true);

					break;

				case 's':

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

					break;

				default:
					
					System.out.println("You shouldn't be seeing this message. \nSomething went wrong.");
					System.exit(1);

					break;

			}
		}
	}
	
}
