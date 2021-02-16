package aeshliman.structure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import aeshliman.comparators.SortByBurstTime;
import aeshliman.comparators.SortByPriority;
import aeshliman.enumerators.Algorithm;
import aeshliman.events.CPUEvent;

public class CPUScheduler
{
	// Instance Variables
	private Simulation simulation;
	private Algorithm algorithm;
	private CPU cpu;
	private int quantum;
	private Queue<CustomProcess> readyQueue;
	
	// Constructors
	public CPUScheduler(Simulation simulation, Algorithm algorithm, CPU cpu, int quantum)
	{
		this.simulation = simulation;
		this.algorithm = algorithm;
		this.cpu = cpu;
		this.quantum = quantum;
		if(algorithm==Algorithm.SJF) this.readyQueue = new PriorityQueue<CustomProcess>(new SortByBurstTime());
		else if(algorithm==Algorithm.PS) this.readyQueue = new PriorityQueue<CustomProcess>(new SortByPriority());
		else this.readyQueue = new LinkedList<CustomProcess>();
	}
	
	// Getters
	public Simulation getSimulation() { return this.simulation; }
	public Algorithm getAlgorithm() { return this.algorithm; }
	public CPU getCPU() { return this.cpu; }
	public int getQuantum() { return this.quantum; }
	public Queue<CustomProcess> getQueue() { return this.readyQueue; }
	
	// Operations
	public void resolveReadyQueueEvent()
	{
		algorithm.algorithm(simulation,cpu,readyQueue);
	}
}
