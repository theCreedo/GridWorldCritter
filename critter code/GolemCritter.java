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

public class GolemCritter extends Critter
{
	
	/**
	 *Constructor that creates a new GolemCritter with a color Red.
	 */
	public GolemCritter()
	{
		setColor(Color.RED);
	}
	
	/**
	 * Constructor that creates a new GolemCritter with a given color.
     * @param givenColor the given color
	 */
	public GolemCritter(Color givenColor)
	{
		setColor(givenColor);
	}
	
	 /**
     * Gets the actors for processing. The actors must be contained in the same
     * grid as this critter. Implemented to return the actors that occupy
     * the locations in the GolemCritter's direction. Override this method in subclasses to look
     * elsewhere for actors to process.
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
		return demActors;
    }

    /**
     * Processes the actors. Implemented to change all actors that are not GeodudeCritters,
     * GravelerCritters, or GolemCritters into Rocks. Override this method in subclasses to process
     * neighbors in a different way. <br />
     * Precondition: All objects in <code>actors</code> are contained in the
     * same grid as this critter.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if(!(a instanceof GeodudeCritter) && !(a instanceof GravelerCritter) && !(a instanceof GolemCritter))
            {
            	Rock lolz = new Rock();
            	lolz.putSelfInGrid(getGrid(), a.getLocation());
            }
        }
    }

    /**
     * Gets the possible locations for the next move. Takes all empty locations
     * in front of the critter and places a GeodudeCritter in it, and takes
     * the last location in its direction in the Grid and places it into
     * the ArrayList<Location>. Override this method in subclasses to look
     * elsewhere for move locations.<br />
     * Postcondition: The locations must be valid in the grid of this critter.
     * @return a list of possible locations for the next move
     */
    public ArrayList<Location> getMoveLocations()
    {
        Location wow = getLocation().getAdjacentLocation(getDirection());
        ArrayList<Location> lol = new ArrayList<Location>();
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) == null)
			{
				GeodudeCritter hmm = new GeodudeCritter();
				hmm.putSelfInGrid(getGrid(), wow);
			}
				wow = wow.getAdjacentLocation(getDirection());
			if(getGrid().isValid(wow))
				lol.add(wow);
		}
		return lol;
    }

    /**
     * Selects the location for the next move. Implemented to pick the last
     * location in the ArrayList, or to return the current location if
     * <code>locs</code> has size 0. Override this method in subclasses that
     * have another mechanism for selecting the next move location. <br />
     * Precondition: All locations in <code>locs</code> are valid in the grid
     * of this critter
     * @param locs the possible locations for the next move
     * @return the location that was selected for the next move.
     */
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        return locs.get(n-1);
    }

    /**
     * Implemented to call moveTo.
     * Moves this critter to the given location and turns it to a random direction.
     * Override this method in subclasses that want to carry out other actions
     * for moving (for example, turning or leaving traces). <br />
     * Precondition: <code>loc</code> is valid in the grid of this critter
     * @param loc the location to move to (must be valid)
     */
    public void makeMove(Location loc)
    {
        moveTo(loc);
        int d = (int) (Math.random() * 8) * 45;
        setDirection(d);
    }
}