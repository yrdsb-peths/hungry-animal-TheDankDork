import greenfoot.*;  

/*
 * The MyWorld class creates a world with all the buttons and displays on them
 * First, the initial variables and instances are set, most with no value.
 * The constructor then creates the world with the background, initial buttons, etc.
 */

public class MyWorld extends World{
    // Create the core gameplay variables - score and lives.
    public int score = 0;
    public int lives = 3;
    public int speedMod = 0;  // speedMod allows the game to gradually increase speed

    // Create labels for the score and life display
    Label displayScore; 
    Label displayLives;
    
    Cat cat; //Create an instance of cat, the player.
    
    // Create buttons and labels with no value.  This allows them to be called at any time without causing bugs.
    Button title; 
    Button startButton;
    Button homeButton;
    Button restartButton;
    Label gameOverLabel;    
    Label homeLabel;
    Label restartLabel;
    
    /*
     * The constructor creates the basic world with the background image.
     * The cat, all buttons, and all labels are given values and their instances are created.
     * Lastly, the title text and start button is added on.
     */
    public MyWorld(){       
        super(600, 400, 1); // Create a world of 600x400
        Background kitchen = new Background();
        addObject(kitchen, 230, 230); // Set the background image
        
        // Create all instances
        cat = new Cat();
        displayScore = new Label("Score: ", score, 30);
        displayLives = new Label("Lives: ", lives, 30);
        
        gameOverLabel = new Label("Game Over", 90);
        homeLabel = new Label("Home", 30);
        homeButton = new Button("home_button.png", 40, 40);
        restartLabel = new Label("Restart", 30);
        restartButton = new Button("restart_button.png", 40, 40);
        
        title = new Button("hungry_animal.png", 551, 84);
        startButton = new Button("start_button.png", 198, 150);
        
        // Add title and start button
        addObject(title, 300, 100);        
        addObject(startButton, 300, 290);
        
        
    }
    
    // Constantly check if buttons are being pressed
    public void act(){
        checkStartPressed();
        checkHomePressed();
        checkRestartPressed();
    }
    
    // If the start button is pressed, the game is begun and the two objects on the home page are removed.
    public void checkStartPressed(){        
        if(Greenfoot.mouseClicked(startButton)){
            initGame();
            removeObject(startButton);
            removeObject(title);
        }
    } 

    // At game over, when the home button is pressed, everything is cleared and a home button is generated.
    public void checkHomePressed(){
        if(Greenfoot.mouseClicked(homeButton)){
            addObject(title, 300, 100);        
            addObject(startButton, 300, 290);
            removeObject(homeButton);
            removeObject(homeLabel);
            removeObject(restartButton);
            removeObject(restartLabel);
            removeObject(gameOverLabel);
        }
    }
    
    // Restarts the game by starting the main game function and removing all other objects.
    public void checkRestartPressed(){
        if(Greenfoot.mouseClicked(restartButton)){
            initGame();
            removeObject(homeButton);
            removeObject(homeLabel);
            removeObject(restartButton);
            removeObject(restartLabel);
            removeObject(gameOverLabel);
        }
    }
    
    // Call the game
    public void initGame(){  
        // Set or reset default variables
        score = 0;
        lives = 3;
        speedMod = 0;
        
        // Display score and lives for user
        addObject(displayScore, 80, 40);
        addObject(displayLives, 520, 40); 
        
        // Constantly update the score and lives display
        displayScore.setValue(score);
        displayLives.setValue(lives);
        
        // Spawn the player
        addObject(cat, 95, 360);
        
        // Spawn an initial food
        spawnFish(); 
    }
    
    // Adds and removes necessary buttons or labels when game over.
    public void gameOver() {
        addObject(gameOverLabel, 300, 200);              
        addObject(homeLabel, 180, 260);
        addObject(homeButton, 250, 260);        
        addObject(restartLabel, 380, 260);
        addObject(restartButton, 450, 260);
        
        removeObject(displayScore);
        removeObject(displayLives);
        removeObject(cat);
    }
    
    // Spawn a random food using a random number generator.
    public void spawnRandom(){
        int i = Greenfoot.getRandomNumber(60);
        if(i < 30){
            spawnFish();
        }
        
        else if(i < 40){
            spawnLobster();
        }
        
        else if(i < 49){
            spawnBomb();
        }
        
        else if(i < 50){
            spawnBurger();
        }
        
        else if(i < 60)
        {
            spawnAmongus();
        }
    }
    
    // All foods generated are given a random x value.
    // Create the most basic food - fish
    public void spawnFish(){
        int x = Greenfoot.getRandomNumber(600);
        Food fish = new Food(x, 0, 1, 1, "fish.png", "eat_sound.mp3");
        addObject(fish, x, 0);
    }   
    
    // Creates a lobster as food
    public void spawnLobster(){
        int x = Greenfoot.getRandomNumber(600);
        Food lobster = new Food(x, 0, 3, 1, "lobster.png", "eat_sound.mp3");
        addObject(lobster, x, 0);
    }
    
    // Create the jackpot food - a burger
    public void spawnBurger(){
        int x = Greenfoot.getRandomNumber(600);
        Food burger = new Food(x, 0, 25, -3, "hamburger.png", "burger_sound.mp3");
        addObject(burger, x, 0);
    }
    
    // Create a bomb.  The 4th parameter is set to 0 so as to not take any lives away when leaked.
    public void spawnBomb(){
        int x = Greenfoot.getRandomNumber(600);
        Food bomb = new Food(x, 0, -10, 0, "bomb.png", "bomb_sound.mp3");
        addObject(bomb, x, 0);
    }
    
    public void spawnAmongus()
    {
        int x = Greenfoot.getRandomNumber(600);
        Food Amongus = new Food(x, 0, 30, 2, "blueamongus.png", "kill.mp3");
        addObject(Amongus, x, 0);
    }
    
    // Modify score based on number of points the food carries
    public void modifyScore(int points){    
        score += points;
        displayScore.setValue(score);
    }
    
    // Modify lives based on food that was leaked
    public void modifyLives(int amount){
        lives += amount;
        displayLives.setValue(lives);
    }
}
