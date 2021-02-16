package aeshliman.comparators;

import java.util.Comparator;

import aeshliman.structure.CustomProcess;

public class SortByBurstTime implements Comparator<CustomProcess>
{
	// Sorts low burst time to high burst time
	public int compare(CustomProcess process1, CustomProcess process2)
	{
		return process1.peekBurstTime() - process2.peekBurstTime();
	}
}
