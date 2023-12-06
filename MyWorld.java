import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int score = 0;
    public int lives = 3;

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
    }
    
    public void spawnRandom(){
        int i = Greenfoot.getRandomNumber(50);
        if(i < 25){
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
        Food pork = new Food(x, 0);
        addObject(pork, x, 0);
    }   
    
    public void spawnLobster(){
        int x = Greenfoot.getRandomNumber(600);
        Food lobster = new Food(x, 0, 3, 1);
        addObject(lobster, x, 0);
    }
    
    public void spawnBurger(){
        int x = Greenfoot.getRandomNumber(600);
        Food burger = new Food(x, 0, 10, -1);
        addObject(burger, x, 0);
    }
    
    public void spawnBomb(){
        int x = Greenfoot.getRandomNumber(600);
        Food bomb = new Food(x, 0, -5, 0);
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
