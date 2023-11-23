import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {   
        super(600, 400, 1);
        Croc crocky = new Croc();
        addObject(crocky, 95, 385);
    }
}
