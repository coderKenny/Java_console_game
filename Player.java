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
public class Player 
{
        private int positionX;
        private int positionY;
        private List<Vampire> poistettavat=new ArrayList<Vampire>();
        private Dungeon luola;
        
        private LuolastoMalli malli;
        
        private VampireMover vamppyyrinLiikutusLuokka;
        
        public Player(Dungeon luola)
        {
            this.positionX=0;
            this.positionY=0;
            
            this.luola=luola;
            
            this.vamppyyrinLiikutusLuokka=new VampireMover(this.luola);
            this.malli=luola.getMalli();
        }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
        
        
        
    public void liiku(String liikkumisStringi,Dungeon luola)
    {
        for(int i=0;i<liikkumisStringi.length();i++)
        {
            if(liikkumisStringi.charAt(i)=='w')
            {
                malli.addPoint(new Point(luola.getPelaaja().getPositionX(),luola.getPelaaja().getPositionY()));
                
                if(positionY==0)
                    positionY=0;
                else
                {
                    positionY-=1;
                    for(Vampire vampyyri : luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(this.positionX==vampyyri.getPositionX() && this.positionY==vampyyri.getPositionY())  // Collision
                        {
                            poistettavat.add(vampyyri);
                        }
                    }
                    luola.getVamppyyriKokoelma().getVamppyyriLista().removeAll(poistettavat);
                }
                
                if(luola.vampiresMove())
                    vamppyyrinLiikutusLuokka.liikutaVamppyyreja();
            }
            
            if(liikkumisStringi.charAt(i)=='s')
            {
                malli.addPoint(new Point(luola.getPelaaja().getPositionX(),luola.getPelaaja().getPositionY()));
                
                if(positionY==luola.getHeight()-1)
                    positionY=luola.getHeight()-1;
                else
                {
                    positionY+=1;
                    for(Vampire vampyyri : luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(this.positionX==vampyyri.getPositionX() && this.positionY==vampyyri.getPositionY())  // Collision
                        {
                            poistettavat.add(vampyyri);
                        }
                    }
                    luola.getVamppyyriKokoelma().getVamppyyriLista().removeAll(poistettavat);

                }
                
                if(luola.vampiresMove())
                    vamppyyrinLiikutusLuokka.liikutaVamppyyreja();
            }
            
            if(liikkumisStringi.charAt(i)=='a')
            {
                malli.addPoint(new Point(luola.getPelaaja().getPositionX(),luola.getPelaaja().getPositionY()));
                
                if(positionX==0)
                    positionX=0;
                else
                {
                    positionX-=1;
                    for(Vampire vampyyri : luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(this.positionX==vampyyri.getPositionX() && this.positionY==vampyyri.getPositionY())  // Collision
                        {
                            poistettavat.add(vampyyri);
                        }
                    }
                    luola.getVamppyyriKokoelma().getVamppyyriLista().removeAll(poistettavat);

                }
                
                if(luola.vampiresMove())
                    vamppyyrinLiikutusLuokka.liikutaVamppyyreja();
            }
            
            if(liikkumisStringi.charAt(i)=='d')
            {
                malli.addPoint(new Point(luola.getPelaaja().getPositionX(),luola.getPelaaja().getPositionY()));
                
                if(positionX==luola.getLenght()-1)
                    positionX=luola.getLenght()-1;
                else
                {
                    positionX+=1;
                    for(Vampire vampyyri : luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(this.positionX==vampyyri.getPositionX() && this.positionY==vampyyri.getPositionY())  // Collision
                        {
                            poistettavat.add(vampyyri);
                        }
                    }
                    luola.getVamppyyriKokoelma().getVamppyyriLista().removeAll(poistettavat);      
                }
                
                if(luola.vampiresMove())
                    vamppyyrinLiikutusLuokka.liikutaVamppyyreja();
            }
        }
    }
}
