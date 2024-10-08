package entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player (GamePanel gp, KeyHandler KeyH)
    {
        this.gp = gp;
        this.keyH = KeyH;
        setDefaultValues();
        getPlaterImage();
    }
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "rest"; //default direction
    }

    public void getPlaterImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            rest1 = ImageIO.read(getClass().getResourceAsStream("/player/rest1.png"));
            rest2 = ImageIO.read(getClass().getResourceAsStream("/player/rest2.png"));
        } catch (IOException e)
            {
            e.printStackTrace();
            }
    }
    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
        {
            if(keyH.upPressed)
            {
                direction = "up";
                y -=speed;
            }
            if(keyH.downPressed)
            {
                direction = "down";

                y+=speed;
            }
            if (keyH.leftPressed)
            {
                direction = "left";
                x-=speed;
            }
            if (keyH.rightPressed)
            {
                direction = "right";

                x+=speed;
            }
            spriteCounter ++;
            if(spriteCounter>12)
            {
                if(spriteNum ==1)
                {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2)
    {
 //       g2.setColor(Color.white);
 //       g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction){
            case "up":
                if (spriteNum == 1)
                {
                    image =up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1)
                {
                    image =down1;
                }
                if (spriteNum == 2)
                {
                    image =down2;
                }
                break;
            case "left":
                if (spriteNum == 1)
                {
                    image =left1;
                }
                if (spriteNum == 2)
                {
                    image =left2;
                }
                break;
            case "right":
                if (spriteNum == 1)
                {
                    image =right1;
                }
                if (spriteNum == 2)
                {
                    image =right2;
                }
                break;
            case "rest":
                if (spriteNum == 1)
                {
                    image =rest1;
                }
                if (spriteNum == 2)
                {
                    image =rest2;
                }
        }
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
}