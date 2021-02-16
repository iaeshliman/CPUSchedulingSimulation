package aeshliman.events;

import aeshliman.structure.IOScheduler;

/*
 * Trigger: When an I/O Device is empty but the waitingQueue
 * 		is not this event is triggered.
 * Description: Assigns the I/O Device with a process
 * 		according to its scheduling algorithm.
 */

public class WaitingQueueEvent extends Event
{
	// Instance Variables
	private IOScheduler ioscheduler;
	
	// Constructors
	public WaitingQueueEvent(int time, IOScheduler ioscheduler)
	{
		super(time);
		this.ioscheduler = ioscheduler;
	}
	
	// Operations
	public int resolve()
	{
		ioscheduler.resolveWaitingQueueEvent();
		return this.getTime();
	}
}
