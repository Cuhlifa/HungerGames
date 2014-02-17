package me.jrneulight.cuhlifa.HungerGames;

import java.io.Serializable;

import org.bukkit.Location;

public class ArenaData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5401904117410620779L;
	
	private String world;
	private int ID, maxPlayers,currentPlayers;
	private double x,y,z;
	
	public ArenaData(int ID, int maxPlayers, int currentPlayers,double x,double y,double z,String world){
		
		this.currentPlayers = currentPlayers;
		this.ID = ID;
		this.world = world;
		this.maxPlayers = maxPlayers;
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public int getID(){return ID;}
	public double getX(){return x;}
	public double getY(){return y;}
	public double getZ(){return z;}
	public String getWorld(){return world;}

}
