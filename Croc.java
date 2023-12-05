import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Croc extends Actor{

    public void act(){
        if(Greenfoot.isKeyDown("a")){
            move(-1);
        }
        if(Greenfoot.isKeyDown("d")){
            move(1);
        }

        eat();
    }
    
    private void eat(){
        if(isTouching(Food.class)){
            removeTouching(Food.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnPork(); 
            world.increaseScore(1);
        }
    }
}
