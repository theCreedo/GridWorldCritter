/*Name: Eric lee
 *Teacher: Mrs. Gallatyn
 *Period: 1st
 *MagnetCritter
 *Creates MagnetCritter Class
 **/

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class MagnetCritter extends Critter
{
	public MagnetCritter(Color givenColor)
	{
		setColor(givenColor);
	}
	
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
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(Actor a: actors)
		{
			if(a.getColor().equals(getColor()))
			{
				 int wow = a.getLocation().getDirectionToward(getLocation());
				 if(getGrid().get(a.getLocation().getAdjacentLocation(wow)) == null)
				 {
				 	a.moveTo(a.getLocation().getAdjacentLocation(wow));
				 }
			}
		}
	}
}