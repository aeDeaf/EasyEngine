package org.testgame;
import org.easyengine.main.Engine;
import org.easyengine.main.Point;
public class TestGame {
	public static void main(String[] argv)
	{
		Engine engine = new Engine(1600,900,"Game",true);
		Point point=new Point(1.0f,1.0f,0.0f,0.0f,2.5f,2.5f,0.5f,1.0f);
		engine.SetClearColor(0.0f,0.0f,0.0f);
		while (true)
		{
			engine.ClearScreen();
			engine.Draw(point);
			engine.FinalRender();
			if (!engine.isComplete())
			{
				engine.StopEngine();
			}
		}
	}
}
