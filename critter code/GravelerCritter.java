/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *GravelerCritter
 *Creates GravelerCritter class
 **/

import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class GravelerCritter extends Critter
{
	
private double level;
	
	/**
	 *Constructor that creates a new GravelerCritter with a color Red and a level of 1.
	 */
	public GravelerCritter()
	{
		setColor(Color.RED);
		level =1;
	}
	
	/**
	 *Constructor that creates a new GravelerCritter with a given color and a given level.
     * @param givenColor the given Color
     * @param givenLevel the given Level
	 */
	public GravelerCritter(Color givenColor, double givenLevel)
	{
		setColor(givenColor);
		level = givenLevel;
	}
	
	 /**
     * Gets the actors for processing. The actors must be contained in the same
     * grid as this critter. Implemented to return the
     * actors within a square area of 5 x 5; the GravelerCritter is located,
     * before moving, within the center of the square.
     * Override this method in subclasses to look
     * elsewhere for actors to process.
     * @return a list of actors that are neighbors of this critter
     */
    public ArrayList<Actor> getActors()
    {
		ArrayList<Actor> wow = new ArrayList<Actor>();
		int a = getLocation().getRow();
		int b = getLocation().getCol();
		for(int i = a-2; i<=a+2; i++)
		{
			for(int j = b-2; j <= b+2; j++)
			{
				if((getGrid().isValid(new Location(i,j))) && (getGrid().get(new Location(i,j)) != null) && !(new Location(i,j).equals(getLocation())))
				{
					wow.add(getGrid().get(new Location(i,j)));
				}
			}
		}
		return wow;
    }

    /**
     * Processes the actors. Implemented to either take a Rock and
     * have a 25% chance to replace it with a GeodudeCritter and level up by 1 or 
     * replace it with a GravelerCritter and level up by one, or
     * if it is not a GeodudeCritter, GravelerCritter or GolemCritter,
     * it will replace it with a rock and level up by 1.
     * Override this method in subclasses to process
     * neighbors in a different way. <br />
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
            	int r = (int) (Math.random() * 5);
            	if(r<=1)
            	{
            	GeodudeCritter lolz = new GeodudeCritter(getColor());
            	lolz.putSelfInGrid(getGrid(), a.getLocation());
                level++;
            	}
            	else
            	{
            		GravelerCritter lol = new GravelerCritter(getColor(), level);
            		lol.putSelfInGrid(getGrid(), a.getLocation());
            		level++;
            	}
            }
            else
            if(!(a instanceof GeodudeCritter) && !(a instanceof GravelerCritter) && !(a instanceof GolemCritter))
            {
            	Rock lolz = new Rock();
            	lolz.putSelfInGrid(getGrid(), a.getLocation());
            	level++;
            }
//        	}
        }
    }

    /**
     * Gets the possible locations for the next move. Implemented to return the
     * empty locations within a square grid of 5 x 5; the GravelerCritter is located,
     * before moving, within the center of the square.
     * Postcondition: The locations must be valid in the grid of this critter.
     * @return a list of possible locations for the next move
     */
    public ArrayList<Location> getMoveLocations()
    {
		ArrayList<Location> wow = new ArrayList<Location>();
		int a = getLocation().getRow();
		int b = getLocation().getCol();
		for(int i = a-2; i<=a+2; i++)
		{
			for(int j = b-2; j <= b+2; j++)
			{
				if((getGrid().isValid(new Location(i,j))) && (getGrid().get(new Location(i,j)) == null) && !(new Location(i,j).equals(getLocation())))
				{
					wow.add(new Location(i,j));
				}
			}
		}
		return wow;
    }


    /**
     * Moves this critter to the given location. If the GravelerCritter's level 
     * is greater or equal to 10, it will create and be replaced with a GolemCritter, then
     * it will be implemented to call moveTo for the GolemCritter. Otherwise, it will just move
     * the GraveleerCritter and level it up by 1.
     * Override this method in subclasses that want to carry out other actions
     * for moving (for example, turning or leaving traces). <br />
     * Precondition: <code>loc</code> is valid in the grid of this critter
     * @param loc the location to move to (must be valid)
     */
    public void makeMove(Location loc)
    {
    	if(level >=10)
    	{
    		GolemCritter wow = new GolemCritter(getColor());
            wow.putSelfInGrid(getGrid(), getLocation());
            wow.moveTo(loc);
    	}
    	else
    	{
        moveTo(loc);
    	level++;
    	}
    }
}