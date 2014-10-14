package ws.nzen.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UpdatesSettings implements ActionListener
{
	private ClockSettings model;
	private SettingsView configger;

	public UpdatesSettings( ClockSettings toChange )
	{
		model = toChange;
	}

	public void receiveSettingsView( SettingsView sv )
	{
		configger = sv;
		configger.receiveUpdateListener( this );
	}

	@Override
	public void actionPerformed( ActionEvent arg0 )
	{
		JButton nn = (JButton) arg0.getSource(); // FIX to more robust caller identification
		String name = nn.getText();
		if ( name.equals( "bigger" ) ) 
			model.setFontSize( model.getFontSize() + 10 );
		else
			model.setFontSize( model.getFontSize() - 10 );
	}
}
