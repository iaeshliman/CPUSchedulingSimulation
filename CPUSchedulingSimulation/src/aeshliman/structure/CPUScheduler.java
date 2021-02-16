package aeshliman.structure;

import java.util.Queue;

import aeshliman.enumerators.Algorithm;

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
		this.readyQueue = this.algorithm.getQueue();
	}
	
	// Getters
	public Simulation getSimulation() { return this.simulation; }
	public Algorithm getAlgorithm() { return this.algorithm; }
	public CPU getCPU() { return this.cpu; }
	public int getQuantum() { return this.quantum; }
	public Queue<CustomProcess> getReadyQueue() { return this.readyQueue; }
	
	// Operations
	public boolean isActive()
	{
		return !cpu.isEmpty();
	}
	
	public void resolveReadyQueueEvent()
	{
		algorithm.algorithm(simulation,cpu,readyQueue);
	}
	
	// toString
	public String toString()
	{
		String toString = "Algorithm: " + algorithm + "\tQuantum Slice: " + quantum + cpu.toString();
		for(CustomProcess process : readyQueue) toString += "\n" + process.toString();
		return toString;
	}
}
