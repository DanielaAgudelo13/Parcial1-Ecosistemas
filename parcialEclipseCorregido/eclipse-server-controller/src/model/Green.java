package model;

import processing.core.PApplet;

public class Green {
	private int xPos;
	private int yPos;
	private Dirs dir;
	private float speedX; 
	private float speedY; 
	private String name;
	private PApplet app;
	private boolean over;
	
	public Green() {
		
	}
	
	public Green(int xPos, int yPos,String name,PApplet app) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.dir = Dirs.UpLeft;
		
		int value = Math.round(app.random(4));
		
		switch (value) {
		case 0:
			this.dir = Dirs.UpLeft;
			break;
		case 1:
			this.dir = Dirs.UpRight;
			break;
		case 2:
			this.dir = Dirs.DownLeft;
			break;
		case 3:
			this.dir = Dirs.DownRight;
			break;

		default:
			break;
		}
		
		this.name = name;
		this.app =app;
		this.speedX = app.random(2,5);
		this.speedY = app.random(2,5);
		this.over = false;
	}
	
	public void draw() {
		app.fill(17,192,76);
		app.ellipse(xPos, yPos, 15, 15);
		
		validateOver();
		
		if(!over) {
			move(app.width, app.height);
		}else {
			app.text(name, xPos, yPos - 15);
		}
	}
	
	public void move(int width, int height) {
		
		switch(dir) {
		
			case DownRight:
				xPos+=speedX;
				yPos+=speedY;
				
				break;
				
			case DownLeft:
				xPos-=speedX;
				yPos+=speedY;
				
				break;
				
			case UpLeft:
				xPos-=speedX;
				yPos-=speedY;
				
				break;
				
			case UpRight:
				xPos+=speedX;
				yPos-=speedY;
				break;
				
		}
		
		if(xPos<15 || xPos>width-15) {
			speedX*=-1;
		}
		
		if(yPos<15 || yPos>height-15) {
			speedY*=-1;
		}
		
	}
	
	public void validateOver(){
		
		if(app.mouseX > xPos-7&& app.mouseX < xPos+7  &&
				app.mouseY > yPos-7 && app.mouseY < yPos+7) {
			over = true;
			
		}else {
			over = false;
		}
		
	}
	

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Dirs getDir() {
		return dir;
	}

	public void setDir(Dirs dir) {
		this.dir = dir;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	
	
	
}
