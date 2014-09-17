/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenne_000
 */
public class LuolastoMalli 
{
    private Dungeon sokkelo;
    private List<Point> pisteet;

    public LuolastoMalli(Dungeon sokkelo) {
        this.sokkelo=sokkelo;
        pisteet=new ArrayList<Point>();
        
        pisteet.add(new Point(0,0));  // Aloituspiste ylös
    }
    
    public void createMap()
    {
        
    }
    
    public void addPoint(Point piste)
    {
        boolean pointAlreadyInList=false;
        for(Point point : pisteet)
        {
            if(point.equals(piste))
                pointAlreadyInList =true;
        }
        if(!pointAlreadyInList)
            pisteet.add(piste);
        
    }
    
    
    
    public int visitedRooms()
    {
        return pisteet.size();
    }
    
    public boolean allVisited()
    {
        if(visitedRooms()==(sokkelo.getHeight()*sokkelo.getLenght()) && sokkelo.vampiresMove())
            return true;
        
        else if(visitedRooms()==(sokkelo.getHeight()*sokkelo.getLenght()-2) && !sokkelo.vampiresMove())
            return true;
        
        else
            return false;
    }
    
}
