/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *FlowerChildRunner
 *Creates the runner for FlowerChild
 *
 *Eric was not available for Lab A because of AP Registration
 **/

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;

import java.util.ArrayList;

public class FlowerChildRunner
{
	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
		FlowerChild something = new FlowerChild();
		FlowerChild something1 = new FlowerChild();
		world.add(something1);
		world.add(something);
		for(int i = 0; i <= 30; i++)
		{
			Rock wow = new Rock();
			wow.setColor(new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256)));
			world.add(wow);
		}
		
        world.show();		
	}
}