import java.util.Scanner;
import java.io.File;

public class Parser
{
	public static parseFile(Scanner infile, LinkedList<Road> roads, LinkedList<Light> lights)
	{
		String[] nextLine;
		infile.nextLine(); //"Lights"
		nextLine = infile.nextLine().split(",");
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
			nextLine = infile.nextLine().split("c");
		}
	}

	public static void main(String[] args)
	{
		/*
		   if(args.length != 3)
		   {
		   System.out.println("Two arguments expected: input file, ticks to run simulation for");
		   }
		   */
		//Filename will be obtained from command line args
		Scanner scan = new Scanner(new File("Example.txt"));
		
		//This will be obtained from command line args
		int ticksToRun = 2000;

		LinkedList<Road> roads = new LinkedList<>();
		LinkedList<Light> lights = new LinkedList<>();
		parseFile(scan, roads, lights);
	}
}
