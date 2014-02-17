package me.jrneulight.cuhlifa.HungerGames;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class ArenaData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5401904117410620779L;
	
	private UUID world;
	private int ID, maxPlayers,currentPlayers;
	private ArrayList<SpawnData> spawndata = new ArrayList<SpawnData>();
	private ArrayList<PlayerData> playerdata = new ArrayList<PlayerData>();
	
	public ArenaData(int ID, int maxPlayers, int currentPlayers,ArrayList<SpawnData> spawndata,UUID world){
		
		this.currentPlayers = currentPlayers;
		this.ID = ID;
		this.world = world;
		this.maxPlayers = maxPlayers;
		this.spawndata = spawndata;
		
	}
	
	public int getID(){return ID;}
	public UUID getWorld(){return world;}

}
