/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dungeon;

import java.util.Scanner;

/**
 *
 * @author kenne_000
 */
public class PlayerMover 
{

    private Scanner reader;
    private Dungeon luola;
    private String liikkumisStringi;
    
    public PlayerMover(Scanner reader, Dungeon luola) 
    {
        this.reader=reader;
        this.luola=luola;
    }
    
    public String lueLiikkumisStringi()
    {
        liikkumisStringi = reader.nextLine();
        int ups=0,downs=0,lefts=0,rights=0;
        
        for(int i=0;i<liikkumisStringi.length();i++)
        {
            if(liikkumisStringi.charAt(i)=='w')
                ups++;
            if(liikkumisStringi.charAt(i)=='s')
                downs++;
            if(liikkumisStringi.charAt(i)=='a')
                lefts++;
            if(liikkumisStringi.charAt(i)=='d')
                rights++;
        }
        return liikkumisStringi;
    }  
}
