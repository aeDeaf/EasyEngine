package org.easyengine.main;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class Engine {
	private DisplayMode displayMode;
	private float r,g,b;
	public Engine (int width, int height, String windowTitle, boolean fullscreen)
	{
		try
		{
			Display.setFullscreen(fullscreen);
			DisplayMode d[] = Display.getAvailableDisplayModes();
			for (int i = 0; i < d.length; i++) {
				if (d[i].getWidth() == width
						&& d[i].getHeight() == height
						&& d[i].getBitsPerPixel() == 32) {
					displayMode = d[i];
					break;
				}
			}
			Display.setDisplayMode(displayMode);
			Display.setTitle(windowTitle);
			Display.create();
		}
		catch (LWJGLException e) {
            System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
        }
		glEnable(GL_TEXTURE_2D); 
        glShadeModel(GL_SMOOTH); 
        glClearDepth(1.0); 
        glEnable(GL_DEPTH_TEST); 
        glDepthFunc(GL_LEQUAL); 
        glMatrixMode(GL_PROJECTION); 
        glLoadIdentity();
        gluPerspective(
          45.0f,
          (float) displayMode.getWidth() / (float) displayMode.getHeight(),
          0.1f,
          100.0f);
        glMatrixMode(GL_MODELVIEW); 
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	}
	public void SetClearColor(float rc,float gc,float bc)
	{
		r=rc;
		g=gc;
		b=bc;
		glClearColor(r,g,b,0.0f);
	}
	public void ClearScreen()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);          
        glLoadIdentity();
        glTranslatef(0.0f,0.0f,-6.0f);
	}
	public void FinalRender()
	{
		Display.update();
	}
	public boolean isComplete()
	{
		return !Display.isCloseRequested();
	}
	public void StopEngine()
	{
		Display.destroy();
		System.exit(0);
	}
	public void Draw(EngineObject obj)
	{
		obj.Draw();
	}
}
