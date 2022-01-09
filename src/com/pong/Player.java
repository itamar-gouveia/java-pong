package com.pong;

import java.awt.*;


public class Player {

    public  boolean right, left;
    public int x,y;
    public int largura = 100;
    public int altura =5;


    public Player(int x, int y){
        this.x=x;
        this.y=y;

    }

    public void tick(){
        if(right)
        {
            x++;
        }
        else if(left){
            x--;
        }

        if(x+largura> Game.WIDTH)
        {
            x=Game.WIDTH - largura;
        }else if(x<0)
        {
            x=0;
        }
    }


    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x,y,largura,altura);

    }

}
