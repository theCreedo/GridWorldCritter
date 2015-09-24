/* Name: Eric Lee
 *Teacher: Mrs. Gallatin
 *Period: 1st
 *SuperChameleonRunner
 *Creates the runner for SuperChameleon
 *
 *Eric was not available for Lab A because of AP Registration
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;

import java.util.ArrayList;

public class SuperChameleonRunner
{
	public static void main(String args[])
	{
		ActorWorld world = new ActorWorld();
		SuperChameleon something = new SuperChameleon(Color.blue);
		SuperChameleon something1 = new SuperChameleon(Color.green);
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