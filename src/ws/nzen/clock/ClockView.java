package ws.nzen.clock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClockView
{
	private ViewRoot channelUp;
	private JFrame frame;
	private JButton editor;
	private ClockPane clockFace;

	public ClockView( ViewRoot parent, ClockSettings fromInit )
	{
		channelUp = parent;
		frame = new JFrame( "Time" );
		frame.setLocation( fromInit.getXpos(), fromInit.getYpos() );
		frame.setSize( fromInit.getFrameWidth(), fromInit.getFrameHigh() );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel bounds = new JPanel( new GridBagLayout() );
		frame.getContentPane().add(bounds);
		clockFace = new ClockPane( fromInit.getDateFormat(), fromInit.getWidth(), fromInit.getHeight() );
		editor = new JButton( "edit" );
		wireEvents();
		GridBagConstraints clockRectangle =
				new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1,1,1,1), 0, 0 );
		//							gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
		bounds.add( clockFace.compPart(), clockRectangle );
		GridBagConstraints editorRectangle =
				new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(1,1,1,1), 0, 0 );
		bounds.add(editor, editorRectangle);
		frame.setVisible(true);
		// processMessage( new EventMd_Vw(fromInit.getWidth(), FlagModel.frameWchange) ); // FIX hack to prevent packing
	}

	private void wireEvents()
	{
		editor.addActionListener(
			new ActionListener() {
				public void actionPerformed( ActionEvent buttonPress ) {
					channelUp.receiveMessage( new EventVw_Op( -1, FlagView.showSettings ) );
			}	}		// val irrelevant here
		);
	}

	// sends reference to cset of self for settings to call when stateChanges
	/*public void awaitFontChange( ClockSettings fromInit )
	{
		fromInit.registerListener( this );
	}*/

	public void updateTime( int delay )
	{
		clockFace.updateTime( delay );
	}

	public void processMessage( EventMd_Vw changeWhat )
	{
		switch( changeWhat.why() )
		{
		case fontChange:
		{
			clockFace.setFont( new Font( "Serif", Font.PLAIN, (Integer)changeWhat.val() ) );
			break;
		}
		case frameXchange:
		{
			frame.setLocation( (Integer)changeWhat.val(), frame.getY() );
			break;
		}
		case frameYchange:
		{
			frame.setLocation( frame.getX(), (Integer)changeWhat.val() );
			break;
		}
                case frameWchange:
                {
			frame.setSize((Integer)changeWhat.val(), (int)frame.getSize().getWidth());
			break;
		}
                case frameHchange:
                {
			frame.setSize((int)frame.getSize().getHeight(), (Integer)changeWhat.val());
			break;
		}
                case clockWchange:
                {
                    clockFace.setSize( (Integer)changeWhat.val(), clockFace.gHi() );
                    break;
                }
                case clockHchange:
                {
                    // this version could be inadequate in cases where the user resizes the frame
                    clockFace.setSize( clockFace.gWid(), (Integer)changeWhat.val() );
                    break;
                }
		default:
			System.out.println( "hmm? what;s " + changeWhat );
		}
	}

	/* called by clockSettings when the font size changes
	public void stateChanged( ChangeEvent ev ) // from config
	{
		EventInt nn = (EventInt)ev.getSource();
		int nSize = nn.is();
		clockFace.setFont( new Font( "Serif", Font.PLAIN, nSize ) ); // and then get the value from the valuechanged event
		// or, dump model and do ClockConfig model = ev.getSource()
		// l.set( n F("" f.f, model.getfontsize() ); // except this might actually surrender the EventFiringInteger that changed, not the parent. hmm
		frame.repaint();
	}*/
}
















