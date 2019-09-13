package Game.Entities.Static;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.math.BigDecimal;

import Game.Entities.Dynamic.Player;
import Game.GameStates.State;
import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

	private Handler handler;

	public int xCoord;
	public int yCoord;
	public Color AppleCC = Color.RED;
	public Color ScoreSS = Color.BLACK;

	public Apple(Handler handler,int x, int y){
		this.handler=handler;
		this.xCoord=x;
		this.yCoord=y;
	}




	public void isGood (Graphics g){
		g.setColor(ScoreSS);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(BigDecimal.valueOf(handler.getWorld().player.score).setScale(2, BigDecimal.ROUND_CEILING).toString(), 0, 25);
		g.drawString("Danger",handler.getWidth()/2,25);

		for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
			for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
				if(handler.getWorld().appleLocation[i][j]) 				
					g.setColor(AppleCC);
				if(handler.getWorld().appleLocation[i][j]){
					g.fillRect((i*handler.getWorld().GridPixelsize),
							(j*handler.getWorld().GridPixelsize),
							handler.getWorld().GridPixelsize,
							handler.getWorld().GridPixelsize);
				}
			}
		}
		if(handler.getWorld().player.steps>400) {
			AppleCC = Color.YELLOW;
			ScoreSS = Color.RED;
			g.setColor(ScoreSS);
			if(handler.getWorld().player.justAte) {
				handler.getWorld().player.steps = 0;
				handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
				handler.getWorld().body.removeLast();
				handler.getWorld().player.score-=Math.sqrt(2*handler.getWorld().player.score+1);

				if(handler.getWorld().player.score<0)
					State.setState(handler.getGame().GameOverState);

				if(handler.getWorld().body.isEmpty())  //Checks if player loses all body after eating. If yes, is GameOver.
					State.setState(handler.getGame().GameOverState);
			}

		}
		else
		{
			AppleCC = Color.RED;
			ScoreSS = Color.BLACK;
		}
		handler.getWorld().player.justAte=false;
	}
}




