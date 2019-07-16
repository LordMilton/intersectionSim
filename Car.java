//Represents a car waiting at an intersection
public class Car
{
	private final static double FIRST_CAR_CROSS_TIME_MULTIPLIER = 1.5;
	private int ticksWaiting;
	private int ticksToCrossIntersection;
	private boolean firstCar;
	private boolean canCross;
	private int ticksCrossing;

	public Car()
	{
		ticksWaiting = 0;
		ticksCrossing = 0;
		ticksToCrossIntersection = 1;
		firstCar = false;
		canCross = false;
	}

	//Returns true if the car is allowed to cross
	//and has had enough ticks to cross the intersection
	public boolean addOneTick()
	{
		ticksWaiting++;

		if(canCross)
			ticksCrossing++;
		double crossMultiplier = 1;
		if(firstCar)
			crossMultiplier = FIRST_CAR_CROSS_TIME_MULTIPLIER;
		if(ticksCrossing >= Math.ceil(ticksToCrossIntersection * crossMultiplier))
			return true;
		return false;
	}

	public int getTicks()
	{
		return ticksWaiting;
	}

	public int getTicksToCross()
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

	public void setCanCross()
	{
		canCross = true;
	}

	public void setCanCross(boolean canCross)
	{
		this.canCross = canCross;
	}

	public boolean getCanCross()
	{
		return canCross;
	}
}
