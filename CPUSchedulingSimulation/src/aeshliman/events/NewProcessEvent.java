package aeshliman.events;

import aeshliman.structure.CustomProcess;
import aeshliman.structure.IOScheduler;

import java.util.PriorityQueue;

import aeshliman.bursts.CPUBurst;
import aeshliman.enumerators.State;
import aeshliman.structure.CPUScheduler;

public class NewProcessEvent extends Event
{
	// Instance Variables
	private CustomProcess process;
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	
	// Constructors
	public NewProcessEvent(int time, PriorityQueue<Event> events, CustomProcess process, CPUScheduler cpuScheduler, IOScheduler ioScheduler)
	{
		super(time,events);
		this.process = process;
		this.cpuScheduler = cpuScheduler;
		this.ioScheduler = ioScheduler;
	}
	
	// Operations
	public int resolve()
	{
		// Places process into correct queue
		if(process.peekBurst() instanceof CPUBurst)
		{
			process.setState(State.READY); // Updates state
			cpuScheduler.getReadyQueue().add(process); // Adds to queue
			// If CPU is empty trigger ReadyQueueEvent
			if(!cpuScheduler.isActive()) this.getEvents().add(new ReadyQueueEvent(this.getTime(),this.getEvents(),cpuScheduler));
		}
		else
		{
			process.setState(State.WAITING); // Updates state
			ioScheduler.getWaitingQueue().add(process); // Adds to queue
			// If IO is empty trigger WaitingQueueEvent
			if(!ioScheduler.isActive()) this.getEvents().add(new WaitingQueueEvent(this.getTime(),this.getEvents(),ioScheduler));
		}
		return this.getTime();
	}
}
