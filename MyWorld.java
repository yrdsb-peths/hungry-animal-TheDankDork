import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int score = 0;
    public int lives = 3;

    Label displayScore = new Label("Score: ", score, 30);
    Label displayLives = new Label("Lives: ", lives, 30);
      
    public MyWorld(){   
        super(600, 400, 1);
        
        Croc crocky = new Croc();      
        addObject(crocky, 95, 385);
        spawnPork();
        
        addObject(displayScore, 80, 40);
        addObject(displayLives, 520, 40); 
               
    }
    
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 90);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void spawnPork(){
        int x = Greenfoot.getRandomNumber(600);
        Food pork = new Food(x, 0);
        addObject(pork, x, 0);
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
