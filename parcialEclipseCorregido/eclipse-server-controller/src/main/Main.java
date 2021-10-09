package main;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import model.Blue;
import model.Green;
import model.MsgInfo;
import model.Red;
import processing.core.PApplet;

public class Main extends PApplet implements OnMessageListener {

	// -------------------------------------
	// Global assets
	// -------------------------------------
	private TCPConnection tcp;
	private Gson gson;

	// -------------------------------------
	// Global variables
	// ------------------------------------
	
	private ArrayList<Red> reds;
	private ArrayList<Green> greens;
	private ArrayList<Blue> blues;

	// -------------------------------------
	// Main method
	// -------------------------------------
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// -------------------------------------
	// Processing methods
	// -------------------------------------
	public void settings() {
		size(810, 510);
	}

	public void setup() {
		
		reds = new ArrayList<Red>();
		greens = new ArrayList<Green>();
		blues = new ArrayList<Blue>();
		
		gson = new Gson();

		tcp = TCPConnection.getInstance();
		tcp.setObserver(this);
		textSize(10);
		textMode(3);
	}

	public void draw() {

		background(255);
		
		for (Red r : reds) {
			r.draw();
			//r.move(width, height);
		}
	
		for (Green g : greens) {
			g.draw();
			g.move(width, height);
		}
		
		for (Blue b: blues) {
			b.draw();
			b.move(width, height);
		}

	}

	// -------------------------------------
	// TCP
	// -------------------------------------
	public void onMessage(String msg) {
		// TODO Auto-generated method stub
		
		System.out.println(msg);
		
		if (msg.startsWith("{")) {
			
			MsgInfo info = gson.fromJson(msg, MsgInfo.class);

			for(int i = 0; i < info.numParticles; i++) {
				
				int offsetX = (int) random(-100,100);
				int offsetY = (int) random(-100,100);
				
				switch (info.type) {
				case "red" :
					reds.add(new Red(info.posX+offsetX, info.posY+offsetY,info.groupName,this));
					break;
					
				case "green" :
					greens.add(new Green(info.posX+offsetX, info.posY+offsetY,info.groupName,this));
					break;
					
				case "blue" :
					blues.add(new Blue(info.posX+offsetX, info.posY+offsetY,info.groupName,this));
					break;

				default:
					break;
				}
				
			 }
			
		}else{
			deleteAll();
		}
	

	}

	private void deleteAll() {
		reds.removeAll(reds);
		greens.removeAll(greens);
		blues.removeAll(blues);
	}

}
