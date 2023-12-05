import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int lives = 3;
    int score = 0;
    
    private Label scoreLabel;
    
    public MyWorld(){   
        super(600, 400, 1);
        
        Croc crocky = new Croc();      
        addObject(crocky, 95, 385);
        spawnPork();
        
        scoreLabel = new Label(score, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 90);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    
    public void spawnPork(){
        int x = Greenfoot.getRandomNumber(600);
        Food pork = new Food(x, 0);
        addObject(pork, x, 0);
    }
    
    public void increaseScore(int points){
        score += points;
        scoreLabel.setValue(score);
    }

}
