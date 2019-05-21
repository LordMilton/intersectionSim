import java.util.LinkedList;

//Represents a queue of Cars waiting at an intersection
public class Road
{
	//Used as a queue, but all Cars need to be updated each tick
	private LinkedList<Car> line;
	
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
		line.add(car);
	}

	public Car removeCar()
	{
		return line.removeLast();
	}
}
