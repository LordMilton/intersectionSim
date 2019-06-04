import java.util.LinkedList;
enum Color
{
	RED, YELLOW, GREEN;
}

//Represents traffic light controlling a set of roads
public class Light
{
	private String identifier;
	private Color lightColor;
	private LinkedList<Road> roadsControlled;
	private int ticksAsRed;
	private int ticksAsYellow;
	private int ticksAsGreen;
	private int ticksUntilChange;

	public Light(String identifier, int ticksAsRed, int ticksAsYellow, int ticksAsGreen)
	{
		this.identifier = identifier;
		lightColor = Color.RED;
		this.ticksAsRed = ticksAsRed;
		this.ticksAsYellow = ticksAsYellow;
		this.ticksAsGreen = ticksAsGreen;
		ticksUntilChange = this.ticksAsRed;
	}

	public Light(String identifier, int ticksAsRed, int ticksAsYellow, int ticksAsGreen, Color startingColor)
	{
		this(identifier, ticksAsRed, ticksAsYellow, ticksAsGreen);
		lightColor = startingColor;
	}

	public String getIdentifier()
	{
		return identifier;
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
				case RED:
					lightColor = Color.GREEN;
					ticksUntilChange = ticksAsGreen;
					for(Road road:roadsControlled)
					{
						road.setFirstCar();
					}
					break;
				case YELLOW:
					lightColor = Color.RED;
					ticksUntilChange = ticksAsRed;
					break;
				case GREEN:
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
