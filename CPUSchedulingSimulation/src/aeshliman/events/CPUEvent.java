package aeshliman.events;

import aeshliman.bursts.Burst;
import aeshliman.structure.CPU;
import aeshliman.structure.CustomProcess;

public class CPUEvent extends Event
{
	private CPU cpu;
	
	public CPUEvent(int time, CPU cpu)
	{
		super(time);
		this.cpu = cpu;
	}

	public int resolve()
	{
		CustomProcess process = cpu.getProcess();
		Burst burst = process.getBursts().peek();
		burst.setTime(burst.getTime()-this.getTime());
		if(burst.getTime()<=0)
		{
			
		}
		return this.getTime();
	}
}
