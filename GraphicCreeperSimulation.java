/**
 * Simulates the graphic creepers by adding GraphicCreeper objects and moving them randomly until at 
 * until there is a collision (e.g. 2 die).
 * 
 * @author Meg Fryling
 * @version 2.5.2016
 * */
import java.awt.*;

public class GraphicCreeperSimulation
{
    public static void main(String[] args)
    {
        //Add yourself as a GraphicCreeper here.  
        GraphicCreeper c1 = new GraphicCreeper("Brian Sopok", 40, new Color(255,0,0), 500);
        GraphicCreeper c2 = new GraphicCreeper("Drew Pintus", 50, new Color(0,255,0), 500);
        GraphicCreeper c3 = new GraphicCreeper("Kristen Bossio", 60, new Color(0,0,255), 500);
        GraphicCreeper c4 = new GraphicCreeper("Eric Neuls", 7, new Color(0,100,255), 500);
        GraphicCreeper c5 = new GraphicCreeper("Blake Edwards", 7, new Color(0,100,255), 500);
 
        //Update this code too so that your GraphicCreeper is checked.
        while(c1.isAlive() && c2.isAlive() && c3.isAlive() && c4.isAlive()) {
         
            //Add your GraphicCreeper here too!
            c1.randomMove();
            c1.checkDistance(c2);
            c1.checkDistance(c3);
            c1.checkDistance(c4);
            c1.checkDistance(c5);
            
            c2.randomMove();
            c2.checkDistance(c1);
            c2.checkDistance(c3);
            c2.checkDistance(c4);
            c2.checkDistance(c5);
            
            c3.randomMove();
            c3.checkDistance(c1);
            c3.checkDistance(c2);
            c3.checkDistance(c4);
            c3.checkDistance(c5);
            
            c4.randomMove();
            c4.checkDistance(c1);
            c4.checkDistance(c2);
            c4.checkDistance(c3);
            c4.checkDistance(c5);
            
            c5.randomMove();
            c5.checkDistance(c1);
            c5.checkDistance(c2);
            c5.checkDistance(c3);
            c5.checkDistance(c4);
        }
               
        //Add your GraphicCreeper here too!
        c1.print();
        c2.print();
        c3.print();
        c4.print();
        c5.print();
    }
}
