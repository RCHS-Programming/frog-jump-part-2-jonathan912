import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    public boolean isUpPress;
    public boolean isDownPress;
    public boolean isRightPress;
    public boolean isLeftPress;
    public int Lives = 3;
    public Frog()
    {
        isUpPress = false;
        isDownPress = false;
        isRightPress = false;
        isLeftPress = false;
    }
    
    /**
     * Act - do whatever the Frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        keyJump();
        checkCollision();
        getWorld().showText("LIVES: " + Lives, 50, 30);
    }    
    
    public void keyJump()
    {
        //Check for the up key
        if( isUpPress == false && Greenfoot.isKeyDown("w") && getY() > 60)
        {
            setLocation( getX() , getY() - 60);
            isUpPress = true;
                if (getY() < 60)
                {
                    Greenfoot.setWorld( new WinScreen());
                }
        }
        
        if( isUpPress && !Greenfoot.isKeyDown("w"))
        {
            isUpPress = false;
        }
        
        
        //Check for the down key
        if( isDownPress == false && Greenfoot.isKeyDown("s") && getY() < 540)
        {
            setLocation( getX() , getY() + 60);
            isDownPress = true;
        }
        
        if( isDownPress && !Greenfoot.isKeyDown("s"))
        {
            isDownPress = false;
        }
     
        
        //Check for the right key
        if( isRightPress == false && Greenfoot.isKeyDown("d") && getX() < 740)
        {
            setImage("frog.png");
            setLocation( getX() + 60 , getY());
            isRightPress = true;
        }
        
        if( isRightPress && !Greenfoot.isKeyDown("d"))
        {
            isRightPress = false;
        }
        
        
        //Check for the left key
        if( isLeftPress == false && Greenfoot.isKeyDown("a") && getX() > 60)
        {
            //setImage("frog_left.PNG"); 
            setLocation( getX() - 60 , getY());
            isLeftPress = true;
        }
       
        if( isLeftPress && !Greenfoot.isKeyDown("a"))
        {
            isLeftPress = false;
        }
        
        
        
    }
    
    public void checkCollision()
    {
        if(isTouching(Car.class) || isTouching(Truck.class))
        {
            Lives = Lives - 1;
            if (Lives == 0)
            {
                Greenfoot.setWorld( new LoseScreen() );
            }
            setLocation(370, 510);
        }
    }
}
