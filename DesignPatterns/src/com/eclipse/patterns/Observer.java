package com.eclipse.patterns;

/**
 * Observers promote abstract coupling to Subjects. A subject doesn¡¯t
know the details of any of its observers. However, this has the potential
disadvantage of successive or repeated updates to the Observers when there
are a series of incremental changes to the data. If the cost of these updates is
high, it may be necessary to introduce some sort of change management, so
that the Observers are not notified too soon or too frequently.
When one client makes a change in the underlying data, you need to
decide which object will initiate the notification of the change to the other
observers. If the Subject notifies all the observers when it is changed, each
client is not responsible for remembering to initiate the notification. On the
other hand, this can result in a number of small successive updates being
triggered. If the clients tell the Subject when to notify the other clients, this
cascading notification can be avoided, but the clients are left with the
responsibility of telling the Subject when to send the notifications. If one
client ¡°forgets,¡± the program simply won¡¯t work properly.
Finally, you can specify the kind of notification you choose to send
by defining a number of update methods for the Observers to receive
depending on the type or scope of change. In some cases, the clients will thus
be able to ignore some of these notifications
 * */

public class Observer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}//end of Observer class
