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
public class VampireCollection 
{
    private List<Vampire> vamppyyriLista=new ArrayList<Vampire>();
    private Dungeon luola;

    public VampireCollection() {
        this.luola=luola;
    }
    
    
    
    public void addVampire(int howMany,Dungeon luola)
    {
        int temp=0;
        if(howMany>=(luola.getHeight()*luola.getLenght()-1))
            temp=luola.getHeight()*luola.getLenght()-1;
        else
            temp=howMany;
        
           
        for(int i=0;i<temp;i++)
            this.vamppyyriLista.add(new Vampire(luola));
      
        for(Vampire vamppi : vamppyyriLista)
            vamppi.resolvePosition(luola, vamppi);
                    
    }

    public List<Vampire> getVamppyyriLista() {
        return vamppyyriLista;
    }

    public Dungeon getLuola() {
        return luola;
    }
    
}
