/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kenne_000
 */
public class VampireMover 
{
    private Dungeon luola;
    private Random rand = new Random();
    private List<Vampire> poistettavat=new ArrayList<Vampire>();

    public VampireMover() {
    }

    public VampireMover(Dungeon luola) {
        this.luola = luola;
    }
    
    public void liikutaVamppyyreja()
    {
        VampireCollection kokoelma = luola.getVamppyyriKokoelma();
        String suunta="";
        
        int randomNum = rand.nextInt((3 - 0) + 1) + 0; 
        
        switch(randomNum)
        {
            case 0: suunta= "w";
                    break;
            case 1: suunta= "a";
                    break;
            case 2: suunta= "s";
                    break;
            case 3: suunta= "d";
                    break;
        }
        
        
        for(Vampire vamppi:kokoelma.getVamppyyriLista())
        {
            boolean siirtoOK=false;
           
            if(suunta=="w")
            {
                if(vamppi.getPositionY()<=0)
                {}
                else
                {
                    for(Vampire vamppi2:kokoelma.getVamppyyriLista())
                    {
                         if(!(vamppi2.getPositionX()==vamppi.getPositionX() && vamppi2.getPositionY()==vamppi.getPositionY()-1))
                             siirtoOK=true;
                    }  
                    
                    if(siirtoOK)
                    {
                        vamppi.setPositionY(vamppi.getPositionY()-1);
                        siirtoOK=false;
                    }
                    
                }
                
                if(vamppi.getPositionX()==luola.getPelaaja().getPositionX()&&vamppi.getPositionY()==luola.getPelaaja().getPositionY())
                    poistettavat.add(vamppi);
            } 
            
            if(suunta=="a")
            {
                if(vamppi.getPositionX()<=0)
                {}
                else
                {
                    for(Vampire vamppi2:kokoelma.getVamppyyriLista())
                    {
                         if(!(vamppi2.getPositionX()==vamppi.getPositionX()-1 && vamppi2.getPositionY()==vamppi.getPositionY()))
                             siirtoOK=true;
                             
                    } 
                            
                    if(siirtoOK)
                    {
                        vamppi.setPositionX(vamppi.getPositionX()-1);
                        siirtoOK=false;
                    }
                    
                }
                
                if(vamppi.getPositionX()==luola.getPelaaja().getPositionX()&&vamppi.getPositionY()==luola.getPelaaja().getPositionY())
                    poistettavat.add(vamppi);
            } 
            
            if(suunta=="s")
            {
                if(vamppi.getPositionY()==luola.getHeight()-1)
                {}
                else
                {
                    for(Vampire vamppi2:kokoelma.getVamppyyriLista())
                    {
                         if(!(vamppi2.getPositionX()==vamppi.getPositionX() && vamppi2.getPositionY()==vamppi.getPositionY()-1))
                             siirtoOK=true;
                             
                    }    
                    
                    if(siirtoOK)
                    {
                        vamppi.setPositionY(vamppi.getPositionY()+1);
                        siirtoOK=false;
                    }
                }
                
                if(vamppi.getPositionX()==luola.getPelaaja().getPositionX()&&vamppi.getPositionY()==luola.getPelaaja().getPositionY())
                    poistettavat.add(vamppi);
            } 
            
            if(suunta=="d")
            {
                if(vamppi.getPositionX()==luola.getLenght()-1)
                {}
                else
                {
                    for(Vampire vamppi2:kokoelma.getVamppyyriLista())
                    {
                         if(!(vamppi2.getPositionX()==vamppi.getPositionX()+1 && vamppi2.getPositionY()==vamppi.getPositionY()))
                             siirtoOK=true;
                             
                    }   
                    
                    if(siirtoOK)
                    {
                        vamppi.setPositionX(vamppi.getPositionX()+1);
                        siirtoOK=false;
                    }
                }
                
                if(vamppi.getPositionX()==luola.getPelaaja().getPositionX()&&vamppi.getPositionY()==luola.getPelaaja().getPositionY())
                    poistettavat.add(vamppi);
            } 
                    
        }
        kokoelma.getVamppyyriLista().removeAll(poistettavat);
    }
}
