package ws.nzen.clock;

public class SettingsChanger
{
	private ClockSettings model;

	public SettingsChanger( ClockSettings toChange )
	{
		model = toChange;
	}

	public void processMessage( EventVw_Op fromConfig )
	{
		switch ( fromConfig.why() )
		{
		case biggerFont:
		case smallerFont:
		{
			changeFont( fromConfig );
			break;
		}
		case frameX:
		{
			changeFrameX( fromConfig );
			break;
		}
		case frameY:
		{
			changeFrameY( fromConfig );
			break;
		}
		default:
			System.out.print( fromConfig );
		}
	}

	private void changeFrameY( EventVw_Op fromConfig )
	{
		model.setYpos( (Integer)fromConfig.val() );
	}

	private void changeFrameX( EventVw_Op fromConfig )
	{
		model.setXpos( (Integer)fromConfig.val() );
	}

	public void changeFont( EventVw_Op fromConfig )
	{
		if ( fromConfig.why() == FlagView.biggerFont )
			model.setFontSize( model.getFontSize() + (Integer)fromConfig.val() );
		else
			model.setFontSize( model.getFontSize() - (Integer)fromConfig.val() );
	}
}
