import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends Actor{
    public int xPos;
    public int yPos;
    
    public Food(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void act(){
        setLocation(xPos, yPos);
        yPos++;
    }
}
