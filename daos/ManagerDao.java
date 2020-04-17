package dev.sandra.daos;

import dev.sandra.entities.Manager;

public interface ManagerDao {

	Manager readManager(String username, String password);
	
	//Manager updateManager(Manager manager);
	
	//Manager deleteManager(Manager manager);
}
