package com.example.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.services.security.EncryptionService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	UserDAO userDAO;
	
	private EncryptionService encryptionService;
	
	@Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

	@Override
	public List<User> listAll() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	public Optional<User> getById(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		
		if(domainObject.getPassword() != null){
            domainObject.setPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
		
		return userDAO.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		userDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
