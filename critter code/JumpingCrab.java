/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *JumpingCrab
 *Creates JumpingCrab Class
 **/
 
 //*** WHY would you write it this way.  You certainly wouldn't if you were writing it by hand, which is what we are practicing for!
 //*** -10 you're using Location.LEFT and Location.RIGHT without offsetting the getDirection.  This means, you're treating them like
 //*** east and west.
 

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.*;

import java.util.ArrayList;

public class JumpingCrab extends CrabCritter
{
	public void processActors(ArrayList<Actor> actors)
	{
		for(Actor a: actors)
		{
			if(!(a instanceof Critter))
			{
				a.removeSelfFromGrid();
			}
		}
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> wow = new ArrayList<Location>();
		boolean some = false;
		if(getGrid().isValid(getLocation().getAdjacentLocation(Location.LEFT).getAdjacentLocation(Location.LEFT)) && getGrid().get(getLocation().getAdjacentLocation(Location.LEFT).getAdjacentLocation(Location.LEFT)) == null && getGrid().get(getLocation().getAdjacentLocation(Location.LEFT)) instanceof Rock)
		{
			wow.add(getLocation().getAdjacentLocation(Location.LEFT).getAdjacentLocation(Location.LEFT));
			some = true;
		}
		if(getGrid().isValid(getLocation().getAdjacentLocation(Location.RIGHT).getAdjacentLocation(Location.RIGHT)) && getGrid().get(getLocation().getAdjacentLocation(Location.RIGHT).getAdjacentLocation(Location.RIGHT)) == null && getGrid().get(getLocation().getAdjacentLocation(Location.RIGHT)) instanceof Rock)
		{
			wow.add(getLocation().getAdjacentLocation(Location.RIGHT).getAdjacentLocation(Location.RIGHT));
			some = true;
		}
		if(!some)
		{
			wow = super.getMoveLocations();
			return wow;
		}
		return wow;
		
	}
	
}