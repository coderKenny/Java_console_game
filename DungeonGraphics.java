/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

/**
 *
 * @author kenne_000
 */
public class DungeonGraphics 
{
    
    private Dungeon luola;
    
    public DungeonGraphics(Dungeon luola) 
    {
        this.luola=luola;
    }
    
    
    
    public void DrawInitialDungeon(int height,int lenght,int moves,Dungeon luola)
    {
        boolean vamppyyriPiirretty=false;
        boolean eka;
        System.out.println(moves+"\n");
        
        System.out.println("@ 0 0");
        
        for(Vampire vamppyyri:luola.getVamppyyriKokoelma().getVamppyyriLista())
        {
           System.out.println("v "+vamppyyri.getPositionX()+" "+vamppyyri.getPositionY()); 
        }
        
        
        
        System.out.print("\n");
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<lenght;j++)
            {
                    for(Vampire vamppyyri:luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(i==vamppyyri.getPositionY() && j==vamppyyri.getPositionX())
                        {
                            System.out.print("v");
                            vamppyyriPiirretty=true;
                        }
                    }
                
                if(!vamppyyriPiirretty)
                {
                    if(i==0 && j==0)
                        System.out.print("@");
                    else
                        System.out.print(".");                  
                }
                
                vamppyyriPiirretty=false;
            }
            System.out.print("\n");
        }  
           
        System.out.print("\n");
        luola.reduceMoves();
    }
    
    
    
    
    
    
    
    public void ContinueMoving(int height,int lenght,int moves,Dungeon luola)
    {
        boolean vamppyyriPiirretty=false;
        
        System.out.println(moves+"\n");
        
        System.out.println("@ "+ luola.getPelaaja().getPositionX()+" "+luola.getPelaaja().getPositionY());
        
        for(Vampire vamppyyri:luola.getVamppyyriKokoelma().getVamppyyriLista())
        {
           System.out.println("v "+vamppyyri.getPositionX()+" "+vamppyyri.getPositionY()); 
        }
        
        
        
        System.out.print("\n");
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<lenght;j++)
            {
                    for(Vampire vamppyyri:luola.getVamppyyriKokoelma().getVamppyyriLista())
                    {
                        if(i==vamppyyri.getPositionY() && j==vamppyyri.getPositionX())
                        {
                            System.out.print("v");
                            vamppyyriPiirretty=true;
                        }
                    }
                
                if(!vamppyyriPiirretty)
                {
                    if(i==luola.getPelaaja().getPositionY() && j==luola.getPelaaja().getPositionX())
                    {
                        System.out.print("@");
                                                                                                     
                    }
                    else
                        System.out.print(".");                  
                }
                
                vamppyyriPiirretty=false;
            }
            System.out.print("\n");
        }  
        
        System.out.print("\n");       
    }
    

    
    public void MovePlayerTo(int height, int lenght, Dungeon luola)
    {
        for(int i=0;i<luola.getHeight();i++)
        {
            for(int j=0;j<luola.getLenght();j++)
            {
                if(j==lenght && i==height)
                    System.out.print("@");
                else
                    System.out.print(".");
                      
            }
            System.out.print("\n");
        }       
    }
}
