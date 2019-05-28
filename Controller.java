import java.util.*;

//Controls actions necessary each tick
public class Controller
{
	private int tickCounter;
	private LinkedList<Road> roads;
	private LinkedList<Light> lights;

	public Controller(Collection<Road> roads, Collection<Light> lights)
	{
		tickCounter = 0;
		this.roads = new LinkedList<>(roads);
		this.lights = new LinkedList<>(lights);
	}

	public void advanceOneTick()
	{
		tickCounter++;
		for(Light light:lights)
		{
			light.addOneTick();
		}
	}
}
