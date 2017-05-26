package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ManagerDao;
import entity.Manager;
import service.Managerservice;
@Service("managerservice")
public class Managerserviceimpl implements Managerservice {
	@Resource(name="managerdao")
	private ManagerDao managerdao;
	@Override
	public void updatamanager(Manager manager) {
		// TODO Auto-generated method stub
		managerdao.updatamanager(manager);
	}
	public ManagerDao getManagerdao() {
		return managerdao;
	}
	public void setManagerdao(ManagerDao managerdao) {
		this.managerdao = managerdao;
	}
	@Override
	public Manager getbyname(String name) {
		// TODO Auto-generated method stub
		return managerdao.getbyname(name);
	}
	
}
