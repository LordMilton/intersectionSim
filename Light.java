import java.util.LinkedList;
enum Color
{
	RED, YELLOW, GREEN;
}

//Represents traffic light controlling a set of roads
public class Light
{	
	private Color lightColor;
	private LinkedList<Road> roadsControlled;
	private int ticksAsRed;
	private int ticksAsYellow;
	private int ticksAsGreen;
	private int ticksUntilChange;

	public Light(int ticksAsRed, int ticksAsYellow, int ticksAsGreen)
	{
		lightColor = Color.RED;
		this.ticksAsRed = ticksAsRed;
		this.ticksAsYellow = ticksAsYellow;
		this.ticksAsGreen = ticksAsGreen;
		ticksUntilChange = this.ticksAsRed;
	}

	public Light(int ticksAsRed, int ticksAsYellow, int ticksAsGreen, Color startingColor)
	{
		Light(ticksAsRed, ticksAsYellow, ticksAsGreen);
		lightColor = startingColor;
	}

	public void addRoad(Road newRoad)
	{
		roadsControlled.add(newRoad);
	}

	public LinkedList<Road> getRoads()
	{
		return roadsControlled;
	}

	public void changeColor(Color newColor)
	{
		lightColor = newColor;
	}

	public Color getColor()
	{
		return lightColor;
	}

	public void addOneTick()
	{
		ticksUntilChange--;
		if(ticksUntilChange == 0)
		{
			switch(lightColor)
			{
				case Color.RED:
					lightColor = Color.GREEN;
					ticksUntilChange = ticksAsGreen;
					for(Road road:roads)
					{
						road.setFirstCar();
					}
					break;
				case Color.YELLOW:
					lightColor = Color.RED;
					ticksUntilChange = ticksAsRed;
					break;
				case Color.GREEN:
					lightColor = Color.YELLOW;
					ticksUntilChange = ticksAsYellow;
					break;
			}
		}
		
		for(Road road:roadsControlled)
		{
			road.addOneTick();
		}
	}
}
