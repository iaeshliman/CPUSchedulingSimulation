package aeshliman.events;

import java.util.PriorityQueue;

import aeshliman.structure.CPUScheduler;

/*
 * Trigger: When a CPU Device is empty but the readyQueue
 * 		is not this event is triggered.
 * Description: Assigns the CPU with a process
 * 		according to its scheduling algorithm.
 */

public class ReadyQueueEvent extends Event
{
	// Instance Variables
	private CPUScheduler cpuScheduler;
	
	// Constructors
	public ReadyQueueEvent(int time, PriorityQueue<Event> events, CPUScheduler cpuScheduler)
	{
		super(time,events);
		this.cpuScheduler = cpuScheduler;
	}
	
	// Operations
	public int resolve()
	{
		cpuScheduler.resolveReadyQueueEvent();
		return this.getTime();
	}
}