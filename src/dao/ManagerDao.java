package dao;

import entity.Manager;

public interface ManagerDao {
	public void updatamanager(Manager manager);
	public Manager getbyname(String name);
}
