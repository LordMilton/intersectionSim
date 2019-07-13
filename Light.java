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
	private LinkedList<Light> dependencies;
	private int prevLightBuffer;
	private int ticksAsYellow;
	private int ticksAsGreen;
	private int ticksUntilChange;

	public Light(String identifier, int ticksAsGreen, int ticksAsYellow, int prevLightBuffer)
	{
		this.identifier = identifier;
		lightColor = Color.RED;
		this.dependencies = new LinkedList<>();
		this.roadsControlled = new LinkedList<>();
		this.prevLightBuffer = prevLightBuffer;
		this.ticksAsYellow = ticksAsYellow;
		this.ticksAsGreen = ticksAsGreen;
	}

	public Light(String identifier, int ticksAsGreen, int ticksAsYellow, int prevLightBuffer, Color startingColor)
	{
		this(identifier, ticksAsGreen, ticksAsYellow, prevLightBuffer);
		lightColor = startingColor;
		if(lightColor == Color.GREEN)
			ticksUntilChange = ticksAsGreen;
		else if(lightColor == Color.YELLOW)
			ticksUntilChange = ticksAsYellow;
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

	public void addDependency(Light dependency)
	{
		dependencies.add(dependency);
	}

	public void previousLightExpired()
	{
		ticksUntilChange = prevLightBuffer;
	}

	public void addOneTick()
	{
//		System.err.println("My name is: "+ identifier);
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
					for(Light dependency:dependencies)
					{
						dependency.previousLightExpired();
					}
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
