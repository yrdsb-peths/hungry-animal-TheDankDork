import greenfoot.*;  

/*
 * The food class takes in 6 parameters to determine its type and what it carries.
 * The constructor will then set variables, such as the points it carries, its image, its sound effect when eaten, etc.
 * Lastly, the food class checks if it is touching ground, and will remove lives if it is not a bomb.
 */

public class Food extends Actor{
    // Set variables.  Some are static since they need to be referenced outside as a class rather than an instance.
    public int xPos;
    public int yPos;
    public static int points = 1;
    public static int livesTaken = 1;
    public static String sound;
    
    // Set the position, the points, lives taken, and the audio.  Lastly, set the image.
    public Food(int xPos, int yPos, int points, int livesTaken, String image, String sound){
        this.xPos = xPos;
        this.yPos = yPos;
        this.points = points;
        this.livesTaken = livesTaken;
        this.sound = sound;
        setImage(image);
    }
    
    public void act(){
        setLocation(xPos, yPos); // Set location of the food
        
        MyWorld world = (MyWorld) getWorld();
        yPos += (2 + world.speedMod); // Allows the food to slowly fall down
        
        // Remove self and take away lives if touching ground
        if(isTouchingGround()){
            world.modifyLives(-livesTaken);
            world.removeObject(this);
            
            if(world.lives <= 0){
                world.gameOver(); // Game over if lives hit 0
            }
            else{
                world.spawnRandom(); // If the game isn't over yet, spawn another random food
            }              
        }
    }
    
    private boolean isTouchingGround(){
        if(yPos >= 380){ // Check the y position for the ground
            return true;
        }
        return false;
    }
    
    public static void playAudio(){ // Allows the sound to played by the Cat class
        GreenfootSound audio = new GreenfootSound("sounds/" + sound);
        audio.play();
    }
}
