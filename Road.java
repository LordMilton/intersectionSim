import java.util.LinkedList;
import java.util.Iterator;

//Represents a queue of Cars waiting at an intersection
public class Road
{
	//The Traffic Light that controls this road
	private Light controllingLight;
	//Used as a queue, but all Cars need to be updated each tick
	private LinkedList<Car> line;
	//All cars which have left line aka "crossed" the intersection
	private LinkedList<Car> crossed;
	
	public Road(Light light)
	{
		line = new LinkedList<>();
		controllingLight = light;
	}

	public void addOneTick()
	{
		if(controllingLight.getColor() == Color.GREEN)
		{
			line.peek().setCanCross();
		}

		Iterator i = line.descendingIterator();
		boolean doneCrossing = false;
		while(i.hasNext())
		{
			doneCrossing = ((Car)i.next()).addOneTick();
		}
		if(doneCrossing)
			carCrosses();
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

	private void carCrosses()
	{
		crossed.addFirst(line.removeLast());
	}

	public LinkedList<Car> getCrossedCars()
	{
		return crossed;
	}
}
