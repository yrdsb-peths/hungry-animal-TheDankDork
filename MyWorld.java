import greenfoot.*;  

public class MyWorld extends World{
    public int score = 0;
    public int lives = 3;
    public int speedMod = 0;

    Label displayScore;
    Label displayLives;
    Croc crocky;
    
    Button title;
    Button startButton;
    Button homeButton;
    Button restartButton;
    Label gameOverLabel;    
    Label homeLabel;
    Label restartLabel;
    
    public MyWorld(){       
        super(600, 400, 1);
        Background swamp = new Background();
        addObject(swamp, 0, 100);
        
        crocky = new Croc();
        displayScore = new Label("Score: ", score, 30);
        displayLives = new Label("Lives: ", lives, 30);
        
        gameOverLabel = new Label("Game Over", 90);
        homeLabel = new Label("Home", 30);
        homeButton = new Button("home_button.png", 40, 40);
        restartLabel = new Label("Restart", 30);
        restartButton = new Button("restart_button.png", 40, 40);
        
        title = new Button("hungry_animal.png", 551, 64);
        startButton = new Button("start_button.png", 198, 80);
        addObject(title, 300, 100);        
        addObject(startButton, 300, 290);
        
        
    }
    
    public void act(){
        checkStartPressed();
        checkHomePressed();
        checkRestartPressed();
    }
    
    public void checkStartPressed(){        
        if(Greenfoot.mouseClicked(startButton)){
            initGame();
            removeObject(startButton);
            removeObject(title);
        }
    } 

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
    
    public void initGame(){                
        score = 0;
        lives = 3;
        speedMod = 0;
        
        addObject(displayScore, 80, 40);
        addObject(displayLives, 520, 40); 
        
        displayScore.setValue(score);
        displayLives.setValue(lives);
        
        addObject(crocky, 95, 385);
        
        spawnPork(); 
    }
    
    public void gameOver() {
        addObject(gameOverLabel, 300, 200);              
        addObject(homeLabel, 180, 260);
        addObject(homeButton, 250, 260);        
        addObject(restartLabel, 380, 260);
        addObject(restartButton, 450, 260);
        
        removeObject(displayScore);
        removeObject(displayLives);
        removeObject(crocky);
    }
    
    public void spawnRandom(){
        int i = Greenfoot.getRandomNumber(50);
        if(i < 30){
            spawnPork();
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
    }
    
    public void spawnPork(){
        int x = Greenfoot.getRandomNumber(600);
        Food pork = new Food(x, 0, 1, 1, "pig.png");
        addObject(pork, x, 0);
    }   
    
    public void spawnLobster(){
        int x = Greenfoot.getRandomNumber(600);
        Food lobster = new Food(x, 0, 3, 1, "lobster.png");
        addObject(lobster, x, 0);
    }
    
    public void spawnBurger(){
        int x = Greenfoot.getRandomNumber(600);
        Food burger = new Food(x, 0, 25, -3, "hamburger.png");
        addObject(burger, x, 0);
    }
    
    public void spawnBomb(){
        int x = Greenfoot.getRandomNumber(600);
        Food bomb = new Food(x, 0, -10, 0, "bomb.png");
        addObject(bomb, x, 0);
    }
    
    public void modifyScore(int points){    
        score += points;
        displayScore.setValue(score);
    }
    
    public void modifyLives(int amount){
        lives += amount;
        displayLives.setValue(lives);
    }
}
