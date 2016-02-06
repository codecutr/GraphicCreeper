/**
 * Graphic creeper object and methods
 * 
 * @author Meg Fryling
 * @version 2.5.2016
 */
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class GraphicCreeper
{
    //instance variables
    private Canvas canvas;
    private String name;
    private double range;
    private Color color;
    private double x;
    private double y;
    private boolean alive;
    private int area;
    
   /**
    * Draw creeper
    */
    public GraphicCreeper(String name, double range, Color color, int area)
    {
        canvas = Canvas.getCanvas(area);
        this.name = name;
        this.range = range;
        this.color = color;
        this.area = area;
        this.alive = true;
        randomLocate();
        draw();
    }
    
    /**
     * Print information about creepers
     */
    public void print()
    {
       System.out.print(
       "----------------------------\n" +
       "Creeper name: " + name + "\n" +
       "range: " + range + "\n" +
       "color: " + color + "\n");
       System.out.printf("location: (%.1f, %.1f)\n", x, y);
       System.out.println("alive: " + alive + "\n");  
    }  
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public double getX()
    {
        return this.x;
    }
    
    public double getY()
    {
        return this.y;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public double getRange()
    {
        return this.range;
    }
    
    public boolean isAlive()
    {
        return alive;
    }    

    /**
     * Turns creeper black, redraws, and updates object to not alive.
     */
    public void explode()
    {
        this.setColor(new Color(0,0,0));
        this.draw();
        alive = false; 
    } 
    
    /**
     * Move creeper to specific x,y coordinates
     */
    public void moveTo(double x, double y)
    {
        
        if(alive)
        {
            erase();
            if(x > 0 && x < area)
                this.x = x;
            if(y > 0 && y < area)
                this.y = y;
            draw();    
        }

    }
    
    public void setLocation(double x, double y)
    {
        moveTo(x,y);
    }
    
    public void randomMove()
    {
        moveTo(this.x + randomDirection(), this.y + randomDirection());
    }
    
    public void randomLocate()
    {
        moveTo(randomValue()*area,randomValue()*area);
    }
    
    public double randomDirection()
    {
        return randomValue()*area/20 - area/40;
    }
    
    public double randomValue()
    {
        Random gen = new Random();
        double rand = gen.nextDouble();
        return rand;
    }

    private void draw()
    {
        if(alive) {
            canvas.draw(this, color, 
            new Ellipse2D.Double(x-range, y-range, range*2, range*2));            
            canvas.wait(10);
        }
    }

    private void erase()
    {
        if(alive) {
            canvas.erase(this);
        }
    }
    
    public boolean checkDistance(GraphicCreeper c) {
        Double dist = distance(this,c);
        String name1 = this.getName();
        String name2 = c.getName();
        //System.out.println(name1 + " is " + dist + " units from " + name2);
        if (dist < this.getRange() || dist < c.getRange()) {
            //System.out.println(name1 + " and " + name2 + " just exploded!");

            this.explode();
            c.explode();
            return true;
        }
        return false;
    }
   
    private double distance(GraphicCreeper c1, GraphicCreeper c2) {
        double dist = Math.sqrt(Math.pow(c2.getX()-c1.getX(),2)+Math.pow(c2.getY()-c1.getY(),2));
        return dist;
    }
}
