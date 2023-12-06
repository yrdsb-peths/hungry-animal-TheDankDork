import greenfoot.*;  

public class MyWorld extends World{
    public int score = 0;
    public int lives = 3;
    public int speedMod = 1;

    Label displayScore = new Label("Score: ", score, 30);
    Label displayLives = new Label("Lives: ", lives, 30);
      
    public MyWorld(){   
        super(600, 400, 1);
        Background swamp = new Background();
        addObject(swamp, 0, 100);
        
        addObject(displayScore, 80, 40);
        addObject(displayLives, 520, 40); 
                 
        Croc crocky = new Croc();      
        addObject(crocky, 95, 385);
        
        spawnPork();      
    }
    
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 90);
        addObject(gameOverLabel, 300, 200);
        
        Button restartButton = new Button("restart_button.png", 50, 50);
        addObject(restartButton, 300, 300);
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
