package org.easyengine.main;

public class EngineObject {
protected float x,y;
protected float width,height;
protected float rc,gc,bc,ac;
protected float xangle,yangle,zangle;
public EngineObject(float xx, float yy, float w, float h, float r, float g, float b, float a)
{
	x=xx;
	y=yy;
	width=w;
	height=h;
	rc=r;
	gc=g;
	bc=b;
	ac=a;
}
public void Draw()
{
	;
}
}
