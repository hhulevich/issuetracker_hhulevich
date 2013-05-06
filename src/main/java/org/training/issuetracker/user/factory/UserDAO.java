package org.training.issuetracker.user.factory;

import org.training.issuetracker.user.User;


public interface UserDAO {
	
	public User getUser(String email, String password, String ...realPath);
	
	public User getUserById(Long id, String ...realPath);
}
