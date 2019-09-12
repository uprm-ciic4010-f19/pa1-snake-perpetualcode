package Game.Entities.Static;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.math.BigDecimal;

import Game.Entities.Dynamic.Player;
import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

	private Handler handler;

	public int xCoord;
	public int yCoord;
	public Color AppleCC = Color.BLACK;

	public Apple(Handler handler,int x, int y){
		this.handler=handler;
		this.xCoord=x;
		this.yCoord=y;
	}




	public void isGood (){


	}
	public void render (Graphics g) {
		
		if(handler.getWorld().player.steps<200)
			AppleCC = Color.BLACK;
		else { 
			AppleCC = Color.RED;
			if(handler.getWorld().player.justAte) {
				handler.getWorld().player.steps = 0;
				handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
				handler.getWorld().body.removeLast();
			}
		}
		
		g.setColor(AppleCC);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(BigDecimal.valueOf(handler.getWorld().player.score).setScale(2, BigDecimal.ROUND_CEILING).toString(), 0, 25);
		g.drawString("Danger",handler.getWidth()/2,25);

	}



}




