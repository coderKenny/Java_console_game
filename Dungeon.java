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
public class Dungeon 
{
    private int lenght;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;  
    private Scanner reader;
    private VampireCollection vamppyyriKokoelma;   
    private DungeonGraphics graffa;    
    private Player pelaaja;
    private PlayerMover liikkumisLuokka;
    private LuolastoMalli malli;
    

    
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove)
    {
        malli=new LuolastoMalli(this);
        this.lenght=length;
        this.height=height;
        this.vampires=vampires;
        this.moves=moves;
        this.vampiresMove=vampiresMove;
        this.reader = new Scanner(System.in);
        this.vamppyyriKokoelma=new VampireCollection();
        this.graffa=new DungeonGraphics(this);
        this.pelaaja=new Player(this);
        this.liikkumisLuokka=new PlayerMover(reader,this);
        
    }
    
       public LuolastoMalli getMalli() {
        return malli;
    }
   
    
    public void run()
    {
        vamppyyriKokoelma.addVampire(vampires, this);
        graffa.DrawInitialDungeon(height, lenght,moves,this);    
        
        pelaaja.liiku(liikkumisLuokka.lueLiikkumisStringi(),this);
        
        do
        {          
            graffa.ContinueMoving(height, lenght, moves, this);
            pelaaja.liiku(liikkumisLuokka.lueLiikkumisStringi(),this);
            //graffa.MovePlayerTo(5, 5,this);
            this.reduceMoves();
            graffa.ContinueMoving(height, lenght, moves, this);
            
            if(this.vamppyyriKokoelma.getVamppyyriLista().isEmpty())
                break;
            if(getMalli().allVisited())
            {
                break; // Luolasto koluttu läpi
            }
            
        } while(this.moves!=0);
        
  
        
        if(this.vamppyyriKokoelma.getVamppyyriLista().isEmpty() || getMalli().allVisited())
            System.out.println("YOU WIN");
        else
            System.out.println("YOU LOSE");
    }

    public int getHeight() {
        return height;
    }

    public int getLenght() {
        return lenght;
    }

    public Player getPelaaja() {
        return pelaaja;
    }

    public VampireCollection getVamppyyriKokoelma() {
        return vamppyyriKokoelma;
    }
    
    public void reduceMoves()
    {  
       this.moves--;         
    }
    
    public boolean vampiresMove()
    {
        return this.vampiresMove;
    }
}
