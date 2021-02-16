package aeshliman.comparators;

import java.util.Comparator;

import aeshliman.structure.CustomProcess;

public class SortByBurstTime implements Comparator<CustomProcess>
{
	public int compare(CustomProcess process1, CustomProcess process2)
	{
		return process1.peekBurstTime() - process2.peekBurstTime();
	}
}
