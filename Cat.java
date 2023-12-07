import greenfoot.*;  

/*
 * The Cat class is the class for the character the user will control.
 * It moves left and right using the keys A and D, and will carry an animation done through an array.
 * The class is also responsible to detecting if it is in contact with food.
 */

public class Cat extends Actor{         
    // For the animation loop
    int time = 0; 
    int frame = 0;
    
    // Create the arrays later to be used for animating
    GreenfootImage[] rightImages = new GreenfootImage[4];
    GreenfootImage[] leftImages = new GreenfootImage[4];
    boolean facingRight = true; // Determines which image array to use
    
    public Cat() {
        // Fill in the arrays with the 4 images
        for(int i = 0; i < 4; i++) {
            rightImages[i] = new GreenfootImage("images/cat_idle/cat" + i +".png");
            rightImages[i].scale(150, 80);
        }
        for(int i = 0; i < 4; i++) {
            leftImages[i] = new GreenfootImage("images/cat_idle/cat" + i +".png");
            leftImages[i].scale(150, 80);
            leftImages[i].mirrorHorizontally();
        }
        setImage(rightImages[0]);
    }
    
    public void act(){
        MyWorld world = (MyWorld) getWorld();
        
        // Controls movement
        if(Greenfoot.isKeyDown("a")){
            move(-4 - world.speedMod);
            facingRight = false; // Modify the direction boolean
        }
        if(Greenfoot.isKeyDown("d")){
            move(4 + world.speedMod);
            facingRight = true; // Modify the direction boolean
        }
        
        // Set the frame
        if(facingRight){
            setImage(rightImages[frame]);
        }
        else{
            setImage(leftImages[frame]);
        }
        
        // Constantly check for food and add time
        eat();
        time++;
        
        // Scroll through frames based on time.  Time increases very fast so a mod 10 is applied.
        if(time%10 == 0){
            frame++;
            
            if(frame == 4){
                frame = 0; // Cycle back to the first frame
            }
        }
    }
    
    private void eat(){
        if(isTouching(Food.class)){ // Detect if it is touching a food
            MyWorld world = (MyWorld) getWorld();
            
            // Remove the food and add respective points
            removeTouching(Food.class);
            world.modifyScore(Food.points); 
            Food.playAudio(); // Play audio effect based on food eaten
            
            if(world.score < 0){ 
                world.gameOver(); // Call game over if the score is below 0, which can happen if a bomb explodes
            }
            else{
                if((world.score % 10) == 0){ // Increase the speed by a bit every 10 points
                    world.speedMod = (world.score / 10);
                }
               world.spawnRandom(); // Spawn a new random food class
            }            
        }
    }
}
