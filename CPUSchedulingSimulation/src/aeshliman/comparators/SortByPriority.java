package aeshliman.comparators;

import java.util.Comparator;

import aeshliman.structure.CustomProcess;

public class SortByPriority implements Comparator<CustomProcess>
{
	public int compare(CustomProcess process1, CustomProcess process2)
	{
		return process1.getPriority() - process2.getPriority();
	}
}
