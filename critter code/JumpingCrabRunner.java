/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *JumpingCrabRunner
 *Creates JumpingCrab Runner
 **/

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.*;

import java.util.ArrayList;

public class JumpingCrabRunner
{
	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
		JumpingCrab something = new JumpingCrab();
		JumpingCrab something1 = new JumpingCrab();
		JumpingCrab something2 = new JumpingCrab();
		world.add(something);
		world.add(something1);
		world.add(something2);
		for(int i = 0; i<=10; i++)
		{
			Rock wow = new Rock();
			world.add(wow);
		}
	world.add(new Bug());
	world.show();
	}
}