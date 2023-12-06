import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends Actor{
    public int xPos;
    public int yPos;
    public static int points = 1;
    public static int livesTaken = 1;
    
    public Food(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public Food(int xPos, int yPos, int points, int livesTaken){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void act(){
        setLocation(xPos, yPos);
        yPos += 2;
        
        if(isTouchingGround()){
            MyWorld world = (MyWorld) getWorld();
            world.modifyLives(-livesTaken);
            world.removeObject(this);
            
            if(world.lives <= 0){
                world.gameOver();
            }
            else{
                world.spawnRandom();
            }              
        }
    }
    
    private boolean isTouchingGround(){
        if(yPos >= 380){
            return true;
        }
        return false;
    }
}
