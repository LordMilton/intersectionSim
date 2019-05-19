import java.util.LinkedList;

//Represents traffic light controlling a set of roads
public class Light
{
	public enum Color
	{
		RED, YELLOW, GREEN;
	}

	private Color lightColor;
	private LinkedList<Road> roadsControlled;

	public Light()
	{
		lightColor = Color.RED;
	}

	public addRoad(Road newRoad)
	{
		roadsControlled.add(newRoad);
	}

	public LinkedList<Road> getRoads()
	{
		return roadsControlled;
	}

	public changeColor(Color newColor)
	{
		lightColor = newColor;
	}

	public getColor()
	{
		return lightColor;
	}
}
