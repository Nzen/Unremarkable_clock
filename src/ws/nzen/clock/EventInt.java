package ws.nzen.clock;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// I see that AbstractButton handles addActionListener, until I find a similar wrapper, I'll do this. sigh
public class EventInt
{
	int val;
	ChangeListener target;

	public EventInt( int nn )
	{
		val = nn;
	}

	public void set( int nn )
	{
		val = nn;
		// oh man SANITY CHECK ! that changelistener isn't null
		fireItemStateChanged();
	}

	public int is()
	{
		return val;
	}

	public void addChangeListener( ChangeListener instant )
	{
		target = instant;
	}

	private void fireItemStateChanged()
	{
		target.stateChanged( new ChangeEvent( this ) ); // constructor is (Object source)
	}
}
// NOTES: didn't send this to the event queque. depicted in http://stackoverflow.com/questions/8247926/java-event-listener-to-detect-a-variable-change

/*
Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
	at ws.nzen.clock.EventInt.fireItemStateChanged(EventInt.java:36)
	at ws.nzen.clock.EventInt.set(EventInt.java:21)
	at ws.nzen.clock.ClockConfig.setFontSize(ClockConfig.java:105)
	at ws.nzen.clock.ClockInit.actionPerformed(ClockInit.java:38)
	at javax.swing.AbstractButton.fireActionPerformed(Unknown Source)
	at javax.swing.AbstractButton$Handler.actionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.setPressed(Unknown Source)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source)
	at java.awt.Component.processMouseEvent(Unknown Source)
	at javax.swing.JComponent.processMouseEvent(Unknown Source)
	at java.awt.Component.processEvent(Unknown Source)
	at java.awt.Container.processEvent(Unknown Source)
	at java.awt.Component.dispatchEventImpl(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.processMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.dispatchEvent(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Window.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.EventQueue.dispatchEventImpl(Unknown Source)
	at java.awt.EventQueue.access$200(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(Unknown Source)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$1.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue.dispatchEvent(Unknown Source)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForFilter(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.run(Unknown Source)

*/