import java.util.*;

//Controls actions necessary each tick
public class Controller
{
	private int tickCounter;
	private LinkedList<Road> roads;
	private LinkedList<Light> lights;
	private LinkedList<Connector> connectors;

	public Controller(Collection<Road> roads, Collection<Light> lights, Collection<Connector> connectors)
	{
		tickCounter = 0;
		this.roads = new LinkedList<>(roads);
		this.lights = new LinkedList<>(lights);
		this.connectors = new LinkedList<>(connectors);
	}

	public void runForXTicks(int ticks)
	{
		for(int i = 0; i < ticks; ++i)
		{
			Scanner scan = new Scanner(System.in);
			//scan.nextLine();
			advanceOneTick();
		}
	}

	public void advanceOneTick()
	{
		tickCounter++;
//		System.err.println("Tick: "+ tickCounter);
		for(Light light:lights)
		{
			light.addOneTick();
		}

		for(Connector connector:connectors)
		{
			connector.addOneTick();
		}
	}
}
