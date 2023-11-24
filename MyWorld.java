import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {   
        super(600, 400, 1);
        
        Croc crocky = new Croc();
        Food pork = new Food(0, 0);
        
        addObject(crocky, 95, 385);
        addObject(pork, 0, 0);
    }
}
