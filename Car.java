//Represents a car waiting at an intersection
public class Car
{
	private int ticksWaiting;
	private int ticksToCrossIntersection;
	private boolean firstCar;

	public Car()
	{
		ticksWaiting = 0;
		ticksToCrossIntersection = 2;
		firstCar = false;
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

	public void makeFirstCar()
	{
		firstCar = true;
	}

	public boolean isFirstCar()
	{
		return firstCar;
	}
}
