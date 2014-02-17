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
	
	@EventHandler
	public void onConnect(PlayerJoinEvent e){
		
		System.out.println("1");
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArenaData(1, 10, 0,e.getPlayer().getLocation().getX(),e.getPlayer().getLocation().getY(),e.getPlayer().getLocation().getZ(), e.getPlayer().getLocation().getWorld().getName()));
			oos.flush();
			oos.close();
			System.out.println("2");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	@EventHandler
	public void isMoving(PlayerMoveEvent e){
		
		try {
			ios = new ObjectInputStream(new FileInputStream(file));
			ArenaData ad = (ArenaData) ios.readObject();
			System.out.println(ad.getWorld());
//			Location l = new Location(Bukkit.getWorld(ad.getWorld()) , ad.getX() , ad.getY() , ad.getZ());
//			e.getPlayer().teleport(l);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
