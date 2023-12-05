import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {   
        super(600, 400, 1);
        
        int score = 0;
        int lives = 3;
        
        Croc crocky = new Croc();      
        addObject(crocky, 95, 385);
        spawnPork();
    }
    
    public void spawnPork(){
        int x = Greenfoot.getRandomNumber(600);
        Food pork = new Food(x, 0);
        addObject(pork, x, 0);
    }
}
