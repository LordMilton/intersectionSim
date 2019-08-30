import java.util.LinkedList;

public class Connector
{
	private Road entrance;
	private Road exit;
	private int ticksToCommute;
	private LinkedList<Car> line;
	private int numCars;
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
		for(int i = 0; i < numCars; ++i)
		{
			carTimers.set(i, carTimers.get(i) - 1);
			if(carTimers.get(i) <= 0)
			{
				exit.addCar(line.remove(i));
				carTimers.remove(i);
				numCars--;
				--i;
			}
		}
		
		Car newCar = entrance.getLastCrossed();
		if(newCar != null)
		{
			addCar(newCar);
		}
	}

	public void addCar(Car newCar)
	{
		line.addLast(newCar);
		carTimers.addLast(ticksToCommute);
		numCars++;
	}
}
