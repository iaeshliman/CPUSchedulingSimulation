package aeshliman.comparators;

import java.util.Comparator;

import aeshliman.structure.CustomProcess;

public class SortByPriority implements Comparator<CustomProcess>
{
	// Sorts high priority to low (0 is high 9 is low)
	public int compare(CustomProcess process1, CustomProcess process2)
	{
		return process1.getPriority() - process2.getPriority();
	}
}
