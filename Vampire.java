/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

import java.util.Random;

/**
 *
 * @author kenne_000
 */
public class Vampire 
{
    private int positionX;
    private int positionY;
    
    private Random rand = new Random();
    
    public Vampire(int positionX,int positionY)
    {
        this.positionX=positionX;
        this.positionY=positionY;
    }

    public Vampire(Dungeon luola) 
    {
        int positionX = rand.nextInt((luola.getLenght()-1 - 0) + 1) + 0; 
        int positionY = rand.nextInt((luola.getHeight()-1 - 0) + 1) + 0;
        
    
        this.positionX=positionX;
        this.positionY=positionY;
    }
    
    public void resolvePosition(Dungeon luola,Vampire vampyyra)
    {
        boolean paallekkain=true;
        while(true) // Menee muuten päällekäin pelaajan kanssa
        {
            
            positionX = rand.nextInt((luola.getLenght()-1 - 0) + 1) + 0; 
            positionY = rand.nextInt((luola.getHeight()-1 - 0) + 1) + 0;            
        
            vampyyra.setPositionX(positionX);
            vampyyra.setPositionY(positionY);
       
            for(Vampire vamppyyri : luola.getVamppyyriKokoelma().getVamppyyriLista())
            {
                
                if(vamppyyri!=vampyyra) // Referenssivertaus --> ei vertaile itse itseään vasten
                {
                if(vampyyra.positionX==vamppyyri.positionX && vampyyra.positionY==vamppyyri.positionY)
                {
                    paallekkain=true;
                    break;
                }
                else
                {
                    paallekkain=false;
                }
                }
            }
            
            if((vampyyra.positionX!=0 || vampyyra.positionY!=0) && luola.getVamppyyriKokoelma().getVamppyyriLista().size()==1)
                break;
            if((vampyyra.positionX!=0 || vampyyra.positionY!=0) && !paallekkain)
                break;
           
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }  
}
