/* Name: Eric Lee
 *Teacher: Mrs. Gallatin
 *Period: 1st
 *FlowerChild
 *Creates the FlowerChild class
 *
 *Eric was not available for Lab A because of AP Registration
 */
 
 //*** -5 you misspelled getMoveLocations, so it wasn't using yours...
 //*** -10 in getMoveLocations, you're asking the completely wrong question, so it's moving to any
 //*** location in the grid instead of empty ones.
 
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.*;

import java.util.ArrayList;

public class FlowerChild extends Critter
{
//		public ArrayList<Actor> getActors()
//		{
//			ArrayList<Location> wow = getGrid().getOccupiedLocations();
//			ArrayList<Actor> demActors = new ArrayList<Actor>();
//			for(Location e: wow)
//			{
//				demActors.add(getGrid().get(e));
//			}
//			return demActors;
//		}

		public void processActors(ArrayList<Actor> actors)
		{
			for(Actor a: actors)
			{
				if(a instanceof Rock)
				{	
					Flower lol = new Flower(new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256)));
					lol.putSelfInGrid(getGrid(), a.getLocation());
//					getGrid().put(a.getLocation(), new Flower(new Color((int)(Math.random() * 256),(int)(Math.random() * 256), (int)(Math.random() * 256))));
				}
			}
		}
		
		public ArrayList<Location> getMoveLocations() //*** added s
		{
			ArrayList<Location> wow = new  ArrayList<Location>();
			int a = getGrid().getNumRows();
			int b = getGrid().getNumCols();
			for(int i = 0; i<a; i++)
			{
				for(int j = 0; j <b; j++)
				{
					if(new Location(i,j) != null)//*** NO.  If the ACTOR at that location isn't null
					{
						wow.add(new Location(i, j));
					}
				}
			}
			return wow;
		}
}