package aeshliman.events;

import aeshliman.structure.IOScheduler;

import java.util.PriorityQueue;

import aeshliman.bursts.Burst;
import aeshliman.enumerators.State;
import aeshliman.structure.CPUScheduler;
import aeshliman.structure.CustomProcess;
import aeshliman.structure.IO;

public class IOEvent extends Event
{
	// Instance Variables
	private IO io;
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	private int deltaTime;
	
	// Constructors
	public IOEvent(int time, PriorityQueue<Event> events, IO io, CPUScheduler cpuScheduler, IOScheduler ioScheduler, int deltaTime)
	{
		super(time,events);
		this.io = io;
		this.cpuScheduler = cpuScheduler;
		this.ioScheduler = ioScheduler;
		this.deltaTime = deltaTime;
	}
	
	// Operations
	public int resolve()
	{
		// Local copies of process and active burst
		CustomProcess process = io.removeProcess();
		Burst burst = process.getBursts().peek();
		
		// Reduce the current burst time by time elapsed
		burst.setTime(burst.getTime()-deltaTime);
		if(burst.getTime()<=0) // Checks if burst is complete
		{
			// Remove burst from queue
			process.getBursts().poll();
			if(process.getBursts().isEmpty()) process.setState(State.TERMINATED); // If queue is empty process terminates
			else // If queue is not empty process goes to ready queue
			{
				process.setState(State.READY);
				cpuScheduler.getReadyQueue().add(process);
				// If CPU is not active create a ReadyQueueEvent to fill CPU
				if(!cpuScheduler.isActive()) this.getEvents().add(new ReadyQueueEvent(this.getTime(),this.getEvents(),cpuScheduler));
			}
		}
		else // If not complete adds to waiting queue
		{
			process.setState(State.WAITING);
			ioScheduler.getWaitingQueue().add(process);
		}
		
		// Triggers a WaitingQueueEvent to refill IO Device
		this.getEvents().add(new WaitingQueueEvent(this.getTime(),this.getEvents(),ioScheduler));
		
		// Returns time of event
		return this.getTime();
	}
}
