package me.jrneulight.cuhlifa.HungerGames;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin implements Listener{
	
	File file;
	ObjectInputStream ios;
	ObjectOutputStream oos;
	ArrayList<ArenaData> ArenaList = new ArrayList<ArenaData>();
	
	
	public void onEnable(){
		
		file = new File(getDataFolder(), "Arenas.dat");
		getDataFolder().mkdir();
		
		getServer().getPluginManager().registerEvents(this, this);
		

		
	}
	
	public Object load(){
		
		try {
			ios = new ObjectInputStream(new FileInputStream(file));
			return ios.readObject();

			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}
	
	public void save(Object o){
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			oos.flush();
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

		


}
