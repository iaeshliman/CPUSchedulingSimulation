package aeshliman.events;

import aeshliman.structure.CustomProcess;
import aeshliman.structure.CPUScheduler;

public class NewProcessEvent extends Event
{
	private CustomProcess process;
	private CPUScheduler scheduler;
	
	public NewProcessEvent(int time, CustomProcess process, CPUScheduler scheduler)
	{
		super(time);
		this.process = process;
		this.scheduler = scheduler;
	}
	
	public int resolve()
	{
		//scheduler.resolveNewProcessEvent(process);
		return this.getTime();
	}
}
