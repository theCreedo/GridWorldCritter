/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *SuperChameleon
 *Creates SuperChameleon Class
 *
 *Eric was not available for Lab A because of AP Registration
 **/
 
 //*** -5 why do you have an if with a while that has the same condition?
 //*** had to fix alignment in processActors just to read it...
 //*** -10 not brightening or darkening properly.
 //*** Use a for each loop.  I said the size of the list was irrelevant.
 

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class SuperChameleon extends ChameleonCritter
{
	public SuperChameleon(Color givenColor)
	{
		setColor(givenColor);
	}
	
	public ArrayList<Actor> getActors()
	{
		Location wow = getLocation().getAdjacentLocation(getDirection());
		ArrayList<Actor> demActors = new ArrayList<Actor>();
		if(getGrid().isValid(wow)) //*** what?
		{
		while(getGrid().isValid(wow))
		{
			if(getGrid().get(wow) != null)
			{
				demActors.add(getGrid().get(wow));
			}
			wow = wow.getAdjacentLocation(getDirection());
		}
		}
		return demActors;	
	}
	
	public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0)
        	setColor(getColor().darker());
        else
        {
	       for(int i = 0; i< n; i++)
	       {
		        Actor other = actors.get(i);
		        if(!(other instanceof SuperChameleon))
		        other.setColor(getColor());
	       }
	       setColor(getColor().brighter());
        }

    }
}