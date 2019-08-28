package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entities.User;

public class UserService {
	
	private static UserDaoImpl dao;
	
	public UserService() {
		dao = new UserDaoImpl();
	}
	public void persist(User e) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(e);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer save(User e) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(e);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(User e) {
        dao.openCurrentSessionwithTransaction();
        dao.update(e);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public User findById(Integer id) {
        dao.openCurrentSession();
        User emp = dao.findById(id);
        dao.closeCurrentSession();
        return emp;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        User emp = dao.findById(id);
        dao.delete(emp);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<User> findAll() {
        dao.openCurrentSession();
        List<User> users = dao.getAll();
        dao.closeCurrentSession();
        return users;
    }
 
    
 
    public UserDaoImpl EmployeeDao() {
        return dao;
    }
}
