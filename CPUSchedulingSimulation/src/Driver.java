
import aeshliman.enumerators.Algorithm;
import aeshliman.events.DebugEvent;
import aeshliman.structure.Simulation;

public class Driver
{
	public static void main(String[] args)
	{
		Simulation sim = new Simulation(Algorithm.PS,10);
		sim.getEvents().add(new DebugEvent(0,sim.getEvents(),sim));
		sim.loadScenario("data.txt");
		sim.run();
	}
}
