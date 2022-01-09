package com.pong;

import java.awt.*;
import java.util.Random;

public class Ball {
    public double x,y;
    public int width,height;

    public double dx,dy;
    public double speed = 1.3;


    public Ball(int x, int y)
    {
        this.x=x;
        this.y=y;
        this.width= 5;
        this.height=5;

        int angle = new Random().nextInt(359);
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }


    public void tick(){
        //limitacoes das paredes
        if(x+(dx*speed)  + width >= Game.WIDTH){
            dx*=-1;
        }else if(x+(dx*speed)<0){
              dx*=-1;
        }
        //termina limitacoes da parede


        //verificar se bolinha ultrapassou os limites do jogador ou do inimigo
        if (y>=Game.HEIGHT)
        {
                System.out.println("Ponto do inimigo");
                new Game();
                return;
        }
        else if(y<0){
            System.out.println("Ponto do jogador");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.largura,Game.player.altura);
        Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);

        if(bounds.intersects(boundsPlayer)){
            dy*=-1;
        }
        else if(bounds.intersects(boundsEnemy)){
            dy*=-1;
        }
        x+=dx*speed;
        y+=dy*speed;
    }




    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,width,height);
    }
}