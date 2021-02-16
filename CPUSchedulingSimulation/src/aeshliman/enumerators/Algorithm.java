package aeshliman.enumerators;

import java.util.Queue;

import aeshliman.events.IOEvent;
import aeshliman.structure.CustomProcess;
import aeshliman.structure.Device;
import aeshliman.structure.Simulation;

public enum Algorithm
{
	FCFS
	{
		public void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process);
				IOEvent event = new IOEvent(simulation.getTime()+process.peekBurstTime(),simulation.getCPUScheduler(),simulation.getIOScheduler());
				simulation.getEvents().add(event);
			}
		}
	},
	RR
	{
		public void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process);
				IOEvent event = new IOEvent(simulation.getTime()+Math.min(process.peekBurstTime(),simulation.getQuantum()),simulation.getCPUScheduler(),simulation.getIOScheduler());
				simulation.getEvents().add(event);
			}
		}
	},
	SJF
	{
		public void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process);
				IOEvent event = new IOEvent(simulation.getTime()+process.peekBurstTime(),simulation.getCPUScheduler(),simulation.getIOScheduler());
				simulation.getEvents().add(event);
			}
		}
	},
	PS
	{
		public void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process);
				IOEvent event = new IOEvent(simulation.getTime()+process.peekBurstTime(),simulation.getCPUScheduler(),simulation.getIOScheduler());
				simulation.getEvents().add(event);
			}
		}
	};
	
	public abstract void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue);
}
