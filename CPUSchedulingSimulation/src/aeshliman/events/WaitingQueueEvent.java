package aeshliman.events;

import java.util.PriorityQueue;

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
	private IOScheduler ioScheduler;
	
	// Constructors
	public WaitingQueueEvent(int time, PriorityQueue<Event> events, IOScheduler ioScheduler)
	{
		super(time,events);
		this.ioScheduler = ioScheduler;
	}
	
	// Operations
	public int resolve()
	{
		ioScheduler.resolveWaitingQueueEvent();
		return this.getTime();
	}
}
