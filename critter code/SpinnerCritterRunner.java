/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *SpinnerCritterRunner
 *Creates SpinnerCritter tester
 **/

import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class SpinnerCritterRunner
{
	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
		SpinnerCritter someone = new SpinnerCritter();
		world.add(someone);
		for(int i = 0; i <= 10; i++)
		{
			Rock wow = new Rock();
			world.add(wow);
		}
		for(int j = 0; j<=10; j++)
		{
			Actor wow = new Actor();
			world.add(wow);
		}
        world.show();		
	}
}