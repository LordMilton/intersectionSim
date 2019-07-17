import java.util.*;
import java.io.File;

public class Parser
{
	public static boolean parseFile(Scanner infile, LinkedList<Road> roads, LinkedList<Light> lights)
	{
		String[] nextLine;
		infile.nextLine(); //"Lights"
		nextLine = infile.nextLine().split(",");
		try{
			while(nextLine.length > 1)
			{
				Light next;
				if(nextLine.length == 5)
					next = new Light(nextLine[0], Integer.parseInt(nextLine[1]),
							Integer.parseInt(nextLine[2]),
							Integer.parseInt(nextLine[3]), Color.GREEN);
				else
					next = new Light(nextLine[0], Integer.parseInt(nextLine[1]),
							Integer.parseInt(nextLine[2]),
							Integer.parseInt(nextLine[3]));
				lights.add(next);
				nextLine = infile.nextLine().split(",");
			}
		}catch(Exception e){
			System.err.println("Unable to parse \"Lights\" section");
			e.printStackTrace(System.out);
			System.exit(1);
		}
		nextLine = infile.nextLine().split(",");
		//"Light Orders"
		try{
			while(nextLine.length > 1)
			{
				Light cur = findLight(nextLine[0], lights);
				for(int i = 1; i < nextLine.length; ++i)
					cur.addDependency(findLight(nextLine[i], lights));
				nextLine = infile.nextLine().split(",");
			}
		}catch(Exception e){
			System.err.println("Unable to parse \"Light Orders\" section");
			e.printStackTrace(System.out);
			System.exit(1);
		}
		nextLine = infile.nextLine().split(",");
		//"Roads"
		try{
			while(!(nextLine[0].equals("End")))
			{
				//				System.err.println("road name: "+ nextLine[0] +"\tlight name: "+ nextLine[2]);
				Road cur = new Road(nextLine[0], findLight(nextLine[2], lights),
						Double.parseDouble(nextLine[1]));
				roads.add(cur);
				//Have to add road as a controlled road to the light as well
				//TODO for some reason, findLight is returning null, figure out when
				findLight(nextLine[2], lights).addRoad(cur);
				nextLine = infile.nextLine().split(",");
			}
		}catch(Exception e){
			System.err.println("Unable to parse \"Roads\" section");
			e.printStackTrace(System.out);
			System.exit(1);
		}

		return true;
	}

	private static Light findLight(String identifier, LinkedList<Light> lights)
	{
		for(Light light:lights)
		{
			if(light.getIdentifier().equals(identifier))
				return light;
		}
		return null;
	}

	public static void main(String[] args)
	{

		if(args.length != 3)
		{
			System.out.println("Two arguments expected: input file, ticks to run simulation for");
		}

		//Filename will be obtained from command line args
		Scanner scan = new Scanner(System.in);
		try{
			scan = new Scanner(args[1]);
		}catch(Exception e){
			System.err.println("Could not find a file named "+ args[1]);
			System.exit(1);
		}

		//This will be obtained from command line args
		int ticksToRun = Integer.parseInt(args[2]);

		LinkedList<Road> roads = new LinkedList<>();
		LinkedList<Light> lights = new LinkedList<>();
		parseFile(scan, roads, lights);

		Controller controller = new Controller(roads, lights);
		controller.runForXTicks(ticksToRun);

		Analysis analysis = new Analysis(lights, roads);
		for(Road road:roads)
		{
			System.out.println("Road Name: "+ road.getIdentifier() +
					"\tMax Wait: "+ analysis.roadMaxWait(road) +
					"\tAvg Wait: "+ analysis.roadAvgWait(road));
		}
		for(Light light:lights)
		{
			System.out.println("Light Name: "+ light.getIdentifier() +
					"\tMax Wait: "+ analysis.lightMaxWait(light) +
					"\tAvg Wait: "+ analysis.lightAvgWait(light));
		}
	}
}
