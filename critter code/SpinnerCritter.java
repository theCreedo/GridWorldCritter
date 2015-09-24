import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class SpinnerCritter extends Critter
{

    /**
     * Processes the actors. Implemented to "eat" (i.e. remove) all actors that
     * are not rocks or critters. Override this method in subclasses to process
     * neighbors in a different way. <br />
     * Precondition: All objects in <code>actors</code> are contained in the
     * same grid as this critter.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
    	int size = actors.size();
    	if(size >1)
    	{
    	Actor lol = actors.get(0);
        for (int i = 0; i<size;)
        {
        	if(i == size)
        	{
        	  lol.putSelfInGrid(getGrid(), (actors.get(i-1)).getLocation());
        	}
        	else
        	{
        	  Actor temp = actors.get(i+1);
        	  temp.putSelfInGrid(getGrid(), (actors.get(i)).getLocation());
        	}
		}
    	}
    }
}