/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *PokemonCritterTester
 *Creates PokemonCritter tester
 **/

import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class PokemonCritterRunner
{
	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
//		GeodudeCritter something = new GeodudeCritter();
		GolemCritter someone = new GolemCritter();
//		GravelerCritter somewhere = new GravelerCritter();
//		world.add(something);
		world.add(someone);
//		world.add(somewhere);
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