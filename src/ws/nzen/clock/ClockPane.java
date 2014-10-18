package ws.nzen.clock;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ClockPane extends JPanel
{
	private JLabel face;
	private Date now;
	private SimpleDateFormat digits;

	public static final int clockX = 3; 
	public static final int clockY = 3; 
	public static final int clockSize = 400;
	public static Polygon hourPolygon = new Polygon();
	public static Polygon minutePolygon = new Polygon();
	Shape h,m;
	int hour,minute,second;
	//BufferedImage clockFace;
	AffineTransform af = new AffineTransform();
	Color secColors[] = {Color.lightGray,Color.gray};
	int index = 1,prev = 0;

	public ClockPane( String dateStyle, int ww, int hh )
	// from scicek's analog clock
	{
		now = new Date();
		hour = now.getHours();
		minute = now.getMinutes();
		second = now.getSeconds();
		/*try
		{
			clockFace = ImageIO.read(new File("clockface.png"));
		}
		catch(Exception e){e.printStackTrace();}*/
		
		this.setBackground(Color.black);
		/* Middle point (base of the pointer)
		hourPolygon.addPoint(clockSize/2, clockSize/2);
		// Left point
		hourPolygon.addPoint(clockSize/2 - 15, clockSize/2 - 20);
		// Top
		hourPolygon.addPoint(clockSize/2, clockY + 66);
		// Right point
		hourPolygon.addPoint(clockSize/2 + 15, clockSize/2 - 20);
		
		// Middle point (base of the pointer)
		minutePolygon.addPoint(clockSize/2, clockSize/2);
		// Left point
		minutePolygon.addPoint(clockSize/2 - 10, clockSize/2 - 20);
		// Top
		minutePolygon.addPoint(clockSize/2, clockY + 48);
		// Right point
		minutePolygon.addPoint(clockSize/2 + 10, clockSize/2 - 20);*/
		    
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.red);
		g2.fillOval(clockX + 48, clockY + 46, clockSize - 100,clockSize - 100);
		g2.setColor(Color.gray);
		g2.fill(new Arc2D.Double(61, 59, clockSize - 121, clockSize - 120, 90, -second*6,Arc2D.PIE));
		int innerOffset = 50;
		int centerXX = (int)(61 + (clockSize - 121)/2.0) - innerOffset;
		int centerYY = (int)(59 + (clockSize - 121)/2.0) - innerOffset;
		g2.setColor(Color.green);
		// drawChars(char[] data, int offset, int length, int x, int y)
		for ( int hour_i = 11; hour_i >= 0; hour_i-- )
		{
			int maybeX = (int)(centerXX*Math.cos( Math.toRadians( getHourDegree(hour_i, 0) ) -1.57)) + 200;
			int maybeY = (int)(centerYY*Math.sin( Math.toRadians( getHourDegree(hour_i, 0) ) -1.57)) + 200;
			/*System.out.println( hour_i + ":I  " + maybeX + "x y" + maybeY );
			g2.drawChars( new char[]{new Integer(hour_i).toString().charAt( 0 )}, 0, 1, maybeX, maybeY);
			//g2.fillOval((int)(centerXX*Math.cos( Math.toRadians( getHourDegree(hour_i, 0) ))) + 61,
			//	(int)(centerYY*Math.sin( Math.toRadians( getHourDegree(hour_i, 0) ))) + 59, 5, 5); */
			g2.fillOval( maybeX, maybeY, 5, 5 );
		}
		// hour
		g2.setColor(Color.blue);
		g2.drawLine( centerXX + innerOffset, centerYY + innerOffset,
				hourMath( centerXX, hour, minute, false ), hourMath( centerYY, hour, minute, true ) );
		// minute
		g2.setColor(Color.white);
		g2.drawLine( centerXX + innerOffset, centerYY + innerOffset,
				minuteMath( centerXX, minute, false ), minuteMath( centerYY, minute, true ) );
		// center
		g2.fillOval(centerXX - 3 + innerOffset, centerYY - 3 + innerOffset, 3, 3);
	}

	public double getHourDegree(int h, int m)
	{
		return 0.5*(60*h + m);
	}
   
	public double getMinuteDegree(int m)
	{
		return 6*m;
	}

	private int hourMath( int center, int hh, int mm, boolean sine )
	{
		if ( sine )
			return (int)(center*Math.sin( Math.toRadians( getHourDegree(hh, mm) ) -1.57)) + 200;
		else
			return (int)(center*Math.cos( Math.toRadians( getHourDegree(hh, mm) ) -1.57)) + 200;
	}

	private int minuteMath( int center, int mm, boolean sine )
	{
		if ( sine )
			return (int)(center*Math.sin( Math.toRadians( getMinuteDegree(mm) ) -1.57)) + 200;
		else
			return (int)(center*Math.cos( Math.toRadians( getMinuteDegree(mm) ) -1.57)) + 200;
	}

	public JComponent compPart( )
	{
		return this;
	}

	public void updateTime( int delay )
	{
		now.setTime( now.getTime() + delay );
		hour = now.getHours();
		minute = now.getMinutes();
		second = now.getSeconds();
		//face.setText( digits.format(new Date()) );
		this.repaint();
	}

	public void setFont( Font nn )
	{
		;//face.setFont( nn );
	}

	public void setSize( int ww, int hh )
	{
		face.setSize(ww, hh);
	}

	public int gWid()
	{ return face.getWidth(); }
	
	public int gHi()
	{	return face.getHeight(); 	}

	/*
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
        */
}

	/* hour
	g2.setColor(Color.white);
	g2.drawLine( centerXX, centerYY,
			(int)(centerXX*Math.cos( Math.toRadians( getHourDegree(hour, minute) )) ),
			(int)(centerYY*Math.sin( Math.toRadians( getHourDegree(hour, minute) )) )
	);
	// minute
	g2.setColor(Color.blue);
	g2.drawLine( centerXX, centerYY,
			(int)(centerXX*Math.cos( getMinuteDegree(minute) )),
			(int)(centerYY*Math.sin( getMinuteDegree(minute) ))
	);*/
	//System.out.println( centerXX*Math.cos( Math.toRadians( getHourDegree(hour, minute) )) );

	/*
	g2.fillOval(clockX + 48, clockY + 46, clockSize - 100,clockSize - 100);
	g2.setColor(Color.red);
	g2.fillOval(clockX - 3, clockY - 3, clockSize,clockSize);
	g2.setColor(secColors[prev]);
	g2.fillOval(61, 59, clockSize - 121, clockSize - 120);
	g2.setColor(secColors[index]);
	if(second == 0)
	{
		prev = index;
		index++;
		index = index % secColors.length;
		g2.fillOval(61, 59, clockSize - 121, clockSize - 120);
		g2.setColor(secColors[index]);
	}   
	g2.fill(new Arc2D.Double(61, 59, clockSize - 121, clockSize - 120, 90, -second*6,Arc2D.PIE));
	g2.setColor(Color.black);
	af = new AffineTransform();
	af.rotate(Math.toRadians(getHourDegree(hour,minute)), clockSize/2, clockSize/2);
	h = af.createTransformedShape(hourPolygon);
	af = new AffineTransform();
	af.rotate(Math.toRadians(getMinuteDegree(minute)), clockSize/2, clockSize/2);
	m = af.createTransformedShape(minutePolygon);


	g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
	g2.setColor(Color.red);
	g2.fill(m);
	g2.setColor(Color.black);
	g2.draw(m);
	g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
	g2.setColor(Color.red);
	g2.fill(h);
	g2.setColor(Color.black);
	g2.draw(h);
	g2.setColor(Color.white);
	g2.fillOval(clockSize/2 - 6, clockSize/2 - 5, 10,10);
	g2.setColor(Color.black);
	g2.drawOval(clockSize/2 - 6, clockSize/2 - 5, 10,10);
	//g2.drawImage(clockFace, 7, 10, null);
	g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER));
	g2.drawOval(clockX + 46, clockY + 47, clockSize - 99,clockSize - 100);
	g2.drawOval(clockX + 58, clockY + 55, clockSize - 120,clockSize - 120);
	g2.drawOval(clockX + 4, clockY + 5, clockSize - 17,clockSize - 16);
}*/
