//Represents a car waiting at an intersection
public class Car
{
	private int ticksWaiting;

	public Car()
	{
		ticksWaiting = 0;
	}

	public void addOneTick()
	{
		ticksWaiting++;
	}
}
