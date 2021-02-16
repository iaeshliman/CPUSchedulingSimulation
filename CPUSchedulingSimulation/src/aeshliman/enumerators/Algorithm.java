package aeshliman.enumerators;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import aeshliman.comparators.SortByBurstTime;
import aeshliman.comparators.SortByPriority;
import aeshliman.events.IOEvent;
import aeshliman.structure.CustomProcess;
import aeshliman.structure.Device;
import aeshliman.structure.Simulation;

public enum Algorithm
{
	FCFS // First-Come First-Serve
	{
		// Standard queue
		public Queue<CustomProcess> getQueue()
		{
			return new LinkedList<CustomProcess>();
		}
		
		// Duration of next burst
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
	RR // Round Robin
	{
		// Standard queue
		public Queue<CustomProcess> getQueue()
		{
			return new LinkedList<CustomProcess>();
		}
		
		// Min between duration of next burst and quantum time slice
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
	SJF // Shortest Job First
	{
		// Sorted by shortest burst times
		public Queue<CustomProcess> getQueue()
		{
			return new PriorityQueue<CustomProcess>(new SortByBurstTime());
		}
		
		// Duration of next burst 
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
	PS // Priority Scheduling
	{
		// Sorted by highest to lowest priority (0 being high and 9 being low)
		public Queue<CustomProcess> getQueue()
		{
			return new PriorityQueue<CustomProcess>(new SortByPriority());
		}
		
		// Duration of next burst
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
	
	// Methods
	public abstract Queue<CustomProcess> getQueue(); // Returns correct type of queue depending on algorithm
	public abstract void algorithm(Simulation simulation, Device device, Queue<CustomProcess> queue); // Selects correct process based on algorithm
}
