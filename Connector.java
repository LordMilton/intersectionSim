import java.util.LinkedList;

public class Connector
{
	private Road entrance;
	private Road exit;
	private int ticksToCommute;
	private LinkedList<Car> line;
	//Tracks how much longer the associated car in the line needs to get to the nextexit Road
	private LinkedList<Integer> carTimers;

	public Connector(Road entrance, Road exit, int commuteTime)
	{
		this.entrance = entrance;
		this.exit = exit;
		this.ticksToCommute = commuteTime;
	}

	public void addOneTick()
	{

	}

	public void addCar(Car newCar)
	{

	}
}
