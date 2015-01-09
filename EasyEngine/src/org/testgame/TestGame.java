package org.testgame;
import org.easyengine.main.Engine;
public class TestGame {
	public static void main(String[] argv)
	{
		Engine engine = new Engine(1600,900,"Game",true);
		engine.SetClearColor(1.0f,0.0f,0.0f);
		while (true)
		{
			engine.ClearScreen();
			engine.FinalRender();
			if (!engine.isComplete())
			{
				engine.StopEngine();
			}
		}
	}
}
