package org.easyengine.main;
import static org.lwjgl.opengl.GL11.*;
public class Point extends EngineObject{

	public Point(float xx, float yy, float w, float h, float r, float g, float b, float a) 
	{
		super(xx, yy, w, h, r, g, b, a);
	}
	public void Draw()
	{
		glTranslatef(x,y,0.0f);
		glBegin(GL_POINTS);
			glColor4f(rc,gc,bc,ac);
			glVertex2f(x,y);
		glEnd();
		glTranslatef(-x,-y,0.0f);
	}
}
