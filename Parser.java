import java.util.Scanner;
import java.io.File;

public class Parser
{
	public static parseFile(Scanner infile, LinkedList<Road> roads, LinkedList<Light> lights)
	{
		
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
