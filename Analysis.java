import java.util.LinkedList;

public class Analysis
{
	LinkedList<Light> lights;
	LinkedList<Road> roads;

	public Analysis(LinkedList<Light> lights, LinkedList<Road> roads)
	{
		this.lights = lights;
		this.roads = roads;
	}

	public double roadAvgWait(String roadId)
	{
		Road request = null;
		for(Road road:roads)
			if(road.getIdentifier().equals(roadId))
				request = road;

		LinkedList<Car> crossed = request.getCrossedCars();
		int totalTicks = 0;
		int numCars = 0;
		for(Car car:crossed)
		{
			totalTicks += car.getTicks();
			numCars++;
		}

		return ((1.0*totalTicks)/numCars);
	}

	public int roadMaxWait(String roadId)
	{
		Road request = null;
		for(Road road:roads)
			if(road.getIdentifier().equals(roadId))
				request = road;

		LinkedList<Car> crossed = request.getCrossedCars();
		int maxTicks = 0;
		for(Car car:crossed)
		{
			if(car.getTicks() > maxTicks)
				maxTicks = car.getTicks();
		}

		return maxTicks;
	}

	public double lightAvgWait(String lightId)
	{
		Light request = null;
		for(Light light:lights)
			if(light.getIdentifier().equals(lightId))
				request = light;

		LinkedList<Road> controlled = request.getRoads();
		double totalTicks = 0;
		int numRoads = 0;
		for(Road road:controlled)
		{
			totalTicks += roadAvgWait(road.getIdentifier());
			numRoads++;
		}

		return totalTicks/numRoads;
	}

	public int lightMaxWait(String lightId)
	{
		Light request = null;
		for(Light light:lights)
			if(light.getIdentifier().equals(lightId))
				request = light;

		LinkedList<Road> controlled = request.getRoads();
		int maxTicks = 0;
		for(Road road:controlled)
		{
			if(roadMaxWait(road.getIdentifier()) > maxTicks)
				maxTicks = roadMaxWait(road.getIdentifier());
		}

		return maxTicks;
	}
}
