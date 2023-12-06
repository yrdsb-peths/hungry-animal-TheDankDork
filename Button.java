import greenfoot.*;  

public class Button extends Actor{
    public int scaleX;
    public int scaleY;
    
    public Button(String theImage, int scaleX, int scaleY){
        GreenfootImage image = new GreenfootImage(theImage);
        image.scale(scaleX, scaleY);
        setImage(image);
                
    }
    
    public void act(){
        
    }
}
