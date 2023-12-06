import greenfoot.*;  

public class Croc extends Actor{       
    public void act(){
        MyWorld world = (MyWorld) getWorld();
        
        if(Greenfoot.isKeyDown("a")){
            move(-3 - world.speedMod);
        }
        if(Greenfoot.isKeyDown("d")){
            move(3 + world.speedMod);
        }

        eat();
    }
    
    private void eat(){
        if(isTouching(Food.class)){
            MyWorld world = (MyWorld) getWorld();
            
            removeTouching(Food.class);
            world.modifyScore(Food.points);
            
            if(world.score < 0){
                world.gameOver();
            }
            else{
                if((world.score % 10) == 0){
                    world.speedMod = (world.score / 10);
                }
               world.spawnRandom(); 
            }            
        }
    }
}
