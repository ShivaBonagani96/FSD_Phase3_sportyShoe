package com.sportyshoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entries.User;
import com.sportyshoes.repository.UserRepository;


@Service
public class UserService {

        @Autowired
         private UserRepository userRepository;


        public void save(User user) {
        	
        	userRepository.save(user);
        	System.out.println(user);
        }
        public User GetUserByName(String name) {
        	User user = userRepository.findByName(name);
        	if (user == null) {
        		throw new RuntimeException("User Not Found!");
        	}
        	return user;
        }
         
        public boolean ConfirmUserPassword(User user, String password) {
        	return(user.getPassword().equals(password));
        }
        
        public Iterable<User> GetAllUsers()
        {
            return userRepository.findAll();
        }


}