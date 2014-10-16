package ws.nzen.clock;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ClockPane
{
	private JLabel face;
	private Date now;
	private SimpleDateFormat digits;

	public ClockPane( String dateStyle, int ww, int hh )
	{
		now = new Date(); // if I can get a new Long representing the current milliseconds, then I can update it :/
		// however, if the thread ends up waiting, then this clock will run 'fast'
		digits = new SimpleDateFormat( dateStyle );
		face = new JLabel();
		face.setSize( ww, hh );
		// derive font size from w/h rectangle & date format length
		face.setText( digits.format(now) );
		face.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public ClockPane( )
	{
		now = new Date();
		digits = new SimpleDateFormat( "hh:mm" );
		face.setText( digits.format(now) );
	}

	public JComponent compPart( )
	{
		return face;
	}

	public void updateTime( int delay )
	{
		now.setTime( now.getTime() + delay );
		face.setText( digits.format(new Date()) );
	}

	public void setFont( Font nn )
	{
		face.setFont( nn );
	}

	public void setSize( int ww, int hh )
        {System.out.print( "reached clockpane setsize" );
		face.setSize(ww, hh);
	}

        public int gWid()
        { return face.getWidth(); }

        public int gHi()
        {	return face.getHeight(); 	}
}
