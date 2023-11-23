import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Croc extends Actor
{

    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-1);
        }
        if(Greenfoot.isKeyDown("d")){
            move(1);
        }
    }
}
