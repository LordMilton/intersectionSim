# Intersection Simulator
This program simulates the traffic patterns of an intersection, allowing one to view how long cars waited on each road after an arbitrary number of seconds of simulating
### Basics of Use
Currently, the code can simulate an intersection described in a file (see File Usage) but does not present any statistics once that is finished (this will be done soon, or you can do it yourself!). Besides that, all you have to do it fill out a file yourself. When running the program, the arguments are expected as such: *File name with intersection details*, *Number of ticks (seconds) to run simulation for*. (command line arguments are currently commented out of Parser.java, so args are ignored, intersection file is always Example.txt and number of ticks to run for is 2000).
### File Usage
The intersection file currently has 3 sections: *Lights*, *Light Orders*, *Roads*. Each section should be denoted with the appropriate word/phrase and the file should end with "End". Lines not denoting sections are parsed as Comma Separated Values (CSVs). An example of a complete file can be seen in *Example.txt*.
#### *Lights*
In this section, each line describes one traffic light. Each line should look as follows: *name*,*Seconds as Green*, *Seconds as Yellow*, *Seconds between predecessor turning Red and this light turning Green*, *Starter* (optional). Duplicate *name*s will break the program in a currently invisible manner.
*seconds between predecessor turning Red and this light turning Green*: This program doesn't turn lights to Green after a certain amount of time, instead lights only turn Green a certain time after the light before them has turned Red; this value acts as the break in time where all lights in an intersection are Red before the next set turns Green.
*Starter*: Because lights don't just turn Red after a certain time, there need to be lights to start the whole process; those lights with the word *Starter* as their last argument are the lights that start said process.
Mistakes in this section will likely lead the program to print *Unable to parse Lights section* and exit.
#### *Light Orders*
In this section, each line describes all the successors of one traffic light. Each line should look as follows: *Predecessor light name*, *Successor light name*, *Successor light name*, etc. There can be any number of *Successor light name*s as long as there is at least one. All names in this section should match the name put as the name of one of the lights of the previous section.
Mistakes in this section will likely lead the program to print *Unable to parse Light Orders section* and exit.
#### *Roads*
In this section, each line describes one road. Each line should look as follows: *name*, *number of cars per second*, *light name*. Duplicate *name*s will break the program in a currently invisible manner.
*number of cars per second*: How many cars will appear on the road per second, this is expected to be a decimal value. Currently, cars are expected to take 2 seconds to cross the intersection and therefore if this value is > 0.5, the number of cars on that road will only ever increase.
*light name*: This is the name of the light which controls the road, allowing cars to cross the intersection. All *light name*s in this section should match the name put as the name of one of the lights of the previous section.
Mistakes in this section will likely lead the program to print *Unable to parse Roads section* and exit.
