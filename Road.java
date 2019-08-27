import java.util.LinkedList;
import java.util.Iterator;

//Represents a queue of Cars waiting at an intersection
public class Road
{
	private String identifier;
	//The Traffic Light that controls this road
	private Light controllingLight;
	//Used as a queue, but all Cars need to be updated each tick
	private LinkedList<Car> line;
	//How many cars should arrive in this road per tick, can be any decimal value above 0
	private double carsPerTick;
	//How close to another car arriving in this Road, based around carsPerTick
	//Can be above 1 at any given time but will never end a tick as such
	private double nextCarProgress;
	//All cars which have left line aka "crossed" the intersection
	private LinkedList<Car> crossed;
	
	public Road(String identifier, Light light, double carsPerTick)
	{
		this.identifier = identifier;
		line = new LinkedList<>();
		crossed = new LinkedList<>();
		controllingLight = light;
		if(carsPerTick <= 0)
			throw new IllegalArgumentException();
		this.carsPerTick = carsPerTick;
		nextCarProgress = 0;
	}

	public void addOneTick()
	{
		if(controllingLight.getColor() == Color.GREEN && line.peek() != null)
		{
			line.peek().setCanCross();
		}

		nextCarProgress += carsPerTick;
		while(nextCarProgress >= 1)
		{
			nextCarProgress--;
			addCar(new Car());
		}

		Iterator i = line.descendingIterator();
		//This flag will be repeatedly set in this loop, but we only care about the last car
		//we check (which is the first car in line)
		boolean doneCrossing = false;
		while(i.hasNext())
		{
			doneCrossing = ((Car)i.next()).addOneTick();
		}
		if(doneCrossing)
			carCrosses();

		/*
		//Debug
		//#####################
		System.err.println("My name: "+ identifier +"\tMy light: "+ controllingLight.getColor() +"\tcar progress: "+ nextCarProgress);
		System.err.print("My cars: ");
		for(Car car:line)
		{
			System.err.print(car.getTicks() +", ");
		}
		System.err.println();
		//#####################
		//Debug
		*/
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void addCar(Car car)
	{
		line.addFirst(car);
	}

	public void setFirstCar()
	{
		if(!line.isEmpty())
			line.peek().makeFirstCar();
	}

	private Car carCrosses()
	{
		crossed.addFirst(line.removeLast());
		return crossed.element(); //So Connector can get the car and pass it to the next intersection
	}

	public LinkedList<Car> getCrossedCars()
	{
		return crossed;
	}
}
