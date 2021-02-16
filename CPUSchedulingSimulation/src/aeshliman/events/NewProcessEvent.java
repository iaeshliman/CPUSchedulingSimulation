package aeshliman.events;

import aeshliman.structure.CustomProcess;

import java.util.PriorityQueue;

import aeshliman.structure.CPUScheduler;

public class NewProcessEvent extends Event
{
	private CustomProcess process;
	private CPUScheduler scheduler;
	
	public NewProcessEvent(int time, PriorityQueue<Event> events, CustomProcess process, CPUScheduler scheduler)
	{
		super(time,events);
		this.process = process;
		this.scheduler = scheduler;
	}
	
	public int resolve()
	{
		//scheduler.resolveNewProcessEvent(process);
		return this.getTime();
	}
}
