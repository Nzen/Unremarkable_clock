package ws.nzen.clock;

public class UpdatesSettings// implements ActionListener
{
	private ClockSettings model;

	public UpdatesSettings( ClockSettings toChange )
	{
		model = toChange;
	}

	public void changeFont( ToOperationEvent fromConfig )
	{
		System.out.println( (Integer)fromConfig.val() );
		if ( fromConfig.why() == ViewEvent.biggerFont )
			model.setFontSize( model.getFontSize() + (Integer)fromConfig.val() );
		else
			model.setFontSize( model.getFontSize() - (Integer)fromConfig.val() );
	}

	/*Override
	public void actionPerformed( ActionEvent arg0 )
	{
		JButton nn = (JButton) arg0.getSource(); // FIX to more robust caller identification
		String name = nn.getText();
		if ( name.equals( "bigger" ) ) 
			model.setFontSize( model.getFontSize() + 10 );
		else
			model.setFontSize( model.getFontSize() - 10 );
	}*/
}
