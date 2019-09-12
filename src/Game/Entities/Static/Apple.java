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
	public Color AppleCC;

	public Apple(Handler handler,int x, int y){
		this.handler=handler;
		this.xCoord=x;
		this.yCoord=y;
	}




	public void isGood(int score, int snakeTail, int steps, Graphics g) {

		if(handler.getWorld().player.steps<200)
			AppleCC = Color.BLACK;
		else { 
			AppleCC = Color.RED;
			if(handler.getWorld().player.justAte) {
				steps = 0;
			}
	}
	
		g.setColor(AppleCC);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(BigDecimal.valueOf(handler.getWorld().player.score).setScale(2, BigDecimal.ROUND_CEILING).toString(), 0, 25);
		g.drawString("Danger",handler.getWidth()/2,25);

	}



}




