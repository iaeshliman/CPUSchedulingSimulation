package aeshliman.events;

import aeshliman.structure.IOScheduler;
import aeshliman.structure.CPUScheduler;

public class IOEvent extends Event
{
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	
	public IOEvent(int time, CPUScheduler cpuScheduler, IOScheduler ioScheduler)
	{
		super(time);
		this.cpuScheduler = cpuScheduler;
		this.ioScheduler = ioScheduler;
	}

	public int resolve()
	{
		
		return this.getTime();
	}
}
