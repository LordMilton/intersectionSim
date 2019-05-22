//TODO first car handling in here
//Represents a car waiting at an intersection
public class Car
{
	private int ticksWaiting;
	private int ticksToCrossIntersection;

	public Car()
	{
		ticksWaiting = 0;
		ticksToCrossIntersection = 2;
	}

	public void addOneTick()
	{
		ticksWaiting++;
	}

	public void getTicks()
	{
		return ticksWaiting;
	}

	public void getTicksToCross();
	{
		return ticksToCrossIntersection;
	}
}
