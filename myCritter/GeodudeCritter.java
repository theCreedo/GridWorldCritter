/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *GeodudeCritter
 *Creates GeodudeCritter class
 **/

import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class GeodudeCritter extends Critter
{
	
private double level;

	/**
	 *Constructor that creates a new GeodudeCritter with a color red, and a level of 1.
	 */
	public GeodudeCritter()
	{
		setColor(Color.RED);
		level=1;
	}
	
	/**
	 * Constructor that creates a new GeodudeCritter with a given color and level of 1.
     * @param givenColor the given color
	 */
	public GeodudeCritter(Color givenColor)
	{
		setColor(givenColor);
		level=1;
	}
	
	 /**
     * Gets the actors for processing. The actors must be contained in the same
     * grid as this critter. Implemented to return the actors that occupy
     * the same column and row.
     * @return a list of actors that are neighbors of this critter
     */
    public ArrayList<Actor> getActors()
    {
        Location wow = getLocation().getAdjacentLocation(getDirection());
		ArrayList<Actor> demActors = new ArrayList<Actor>();
		
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) != null)
			{
				demActors.add(getGrid().get(wow));
			}
			wow = wow.getAdjacentLocation(getDirection());
		}
		wow = getLocation().getAdjacentLocation(getDirection() + Location.RIGHT);
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) != null)
			{
				demActors.add(getGrid().get(wow));
			}
			wow = wow.getAdjacentLocation(getDirection() + Location.RIGHT);
		}
		wow = getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) != null)
			{
				demActors.add(getGrid().get(wow));
			}
			wow = wow.getAdjacentLocation(getDirection() + Location.HALF_CIRCLE);
		}
		wow = getLocation().getAdjacentLocation(getDirection() + Location.LEFT);
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) != null)
			{
				demActors.add(getGrid().get(wow));
			}
			wow = wow.getAdjacentLocation(getDirection() + Location.LEFT);
		}
		return demActors;
    }

    /**
     * Processes the actors. Implemented to either turn a Rock into a GravelerCritter and level up by 1
     * or turn antyhing that is not a GeodudeCritter, GravelerCritter, or GolemCritter
     * into a Rock and level up by 1. 
     * Precondition: All objects in <code>actors</code> are contained in the
     * same grid as this critter.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Rock)
            {
            	GravelerCritter lol = new GravelerCritter();
                lol.putSelfInGrid(getGrid(), a.getLocation());
               level += 1;
            }
            else
            if(!(a instanceof GeodudeCritter) && !(a instanceof GravelerCritter) && !(a instanceof GolemCritter))
            {
            	Rock lolz = new Rock();
            	lolz.putSelfInGrid(getGrid(), a.getLocation());
            	level++;
            }
        }
    }

    
    /**
     * Moves this critter to the given location. If the GeodudeCritter has a level greater
     * than 7, the critter will "level up", and a GravelerCritter will take its place. If not,
     * the GeodudeCritter will be implemented to call moveTo, and will level up 1.
     * Override this method in subclasses that want to carry out other actions
     * for moving (for example, turning or leaving traces). <br />
     * Precondition: <code>loc</code> is valid in the grid of this critter
     * @param loc the location to move to (must be valid)
     */
    public void makeMove(Location loc)
    {
    	if(level>=7)
    	{
    		GravelerCritter wow = new GravelerCritter(getColor(), level);
            wow.putSelfInGrid(getGrid(), getLocation());
    	}
    	else
    	{
        moveTo(loc);
        level++;
    	}
    }
}