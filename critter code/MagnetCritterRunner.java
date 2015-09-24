/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *MagnetCritterRunner
 *Creates MagnetCritter tester
 **/
 
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;

 
 public class MagnetCritterRunner
 {
 	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
		MagnetCritter something = new MagnetCritter(Color.black);
		MagnetCritter something1 = new MagnetCritter(Color.blue);
		world.add(something1);
		world.add(something);
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