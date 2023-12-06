import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Croc extends Actor{

    public void act(){
        if(Greenfoot.isKeyDown("a")){
            move(-3);
        }
        if(Greenfoot.isKeyDown("d")){
            move(3);
        }

        eat();
    }
    
    private void eat(){
        if(isTouching(Food.class)){
            removeTouching(Food.class);
            MyWorld world = (MyWorld) getWorld();
            world.modifyScore(Food.points);
            
            world.spawnRandom(); 

        }
    }
}
