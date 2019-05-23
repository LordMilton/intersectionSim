import java.util.LinkedList;

//Represents a queue of Cars waiting at an intersection
public class Road
{
	//Used as a queue, but all Cars need to be updated each tick
	private LinkedList<Car> line;
	//All cars which have left line aka "crossed" the intersection
	private LinkedList<Car> crossed;
	
	public Road()
	{
		line = new LinkedList<>();
	}

	public void addOneTick()
	{
		for(Car car:line)
			car.addOneTick();
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

	//TODO handle crossing the cars, not just be told when a car has crossed (will need to be told
	//when light is green/red)
	public void carCrosses()
	{
		crossed.addFirst(line.removeLast());
	}

	public LinkedList<Car> getCrossedCars()
	{
		return crossed;
	}
}
