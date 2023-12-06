import greenfoot.*;  

public class Food extends Actor{
    public int xPos;
    public int yPos;
    public static int points = 1;
    public static int livesTaken = 1;
    
    public Food(int xPos, int yPos, int points, int livesTaken, String image){
        this.xPos = xPos;
        this.yPos = yPos;
        this.points = points;
        this.livesTaken = livesTaken;
        setImage(image);
    }
    
    public void act(){
        setLocation(xPos, yPos);
        
        MyWorld world = (MyWorld) getWorld();
        yPos += (2 + world.speedMod);
        
        if(isTouchingGround()){
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
