import java.util.Scanner;
import java.io.File;

public class Main
{
	public static void main(String[] args)
	{
		/*
		   if(args.length != 2)
		   {
		   System.out.println("One argument expected: input file");
		   }
		   */
		//Filename will be obtained from command line args
		Scanner scan = new Scanner(new File("Example.txt"));
		
		//This will be obtained from command line args
		int ticksToRun = 2000;


	}
}
