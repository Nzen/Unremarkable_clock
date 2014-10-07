package ws.nzen.clock;

	import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockView
{
	JFrame frame;
	JLabel label;

	public ClockView()
	{
		frame = new JFrame("HelloWorldSwing");
		label = new JLabel("Hello World");
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		System.out.println( " double sigh" );
	}

	public void changeLabel( String newT )
	{
		// CUT
		label.setText( newT );
	}
}
