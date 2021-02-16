package aeshliman.events;

import java.util.PriorityQueue;

import aeshliman.bursts.Burst;
import aeshliman.enumerators.State;
import aeshliman.structure.CPU;
import aeshliman.structure.CPUScheduler;
import aeshliman.structure.CustomProcess;
import aeshliman.structure.IOScheduler;

public class CPUEvent extends Event
{
	// Instance Variables
	private CPU cpu;
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	private int deltaTime;
	
	// Constructors
	public CPUEvent(int time, PriorityQueue<Event> events, CPU cpu, CPUScheduler cpuScheduler, IOScheduler ioScheduler, int deltaTime)
	{
		super(time,events);
		this.cpu = cpu;
		this.cpuScheduler = cpuScheduler;
		this.ioScheduler = ioScheduler;
		this.deltaTime = deltaTime;
	}
	
	// Operations
	public int resolve()
	{
		// Local copies of process and active burst
		CustomProcess process = cpu.removeProcess();
		Burst burst = process.getBursts().peek();
		
		// Reduce the current burst time by time elapsed
		burst.setTime(burst.getTime()-deltaTime);
		if(burst.getTime()<=0) // Checks if burst is complete
		{
			// Remove burst from queue
			process.getBursts().poll();
			if(process.getBursts().isEmpty()) process.setState(State.TERMINATED); // If queue is empty process terminates
			else // If queue is not empty process goes to waiting queue
			{
				process.setState(State.WAITING);
				ioScheduler.getWaitingQueue().add(process);
				// If IO device is not active create a WaitingQueueEvent to fill device
				if(!ioScheduler.isActive()) this.getEvents().add(new WaitingQueueEvent(this.getTime(),this.getEvents(),ioScheduler));
			}
		}
		else // If not complete adds to ready queue
		{
			process.setState(State.READY);
			cpuScheduler.getReadyQueue().add(process);
		}
		
		// Triggers a ReadyQueueEvent to refill CPU
		this.getEvents().add(new ReadyQueueEvent(this.getTime(),this.getEvents(),cpuScheduler));
		
		// Returns time of event
		return this.getTime();
	}
}
