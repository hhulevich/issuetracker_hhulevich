package org.training.issuetracker.user.factory;

import org.training.issuetracker.user.User;

/**
 * @author Hanna Hulevich
 *
 */
public interface UserDAO {

	/**
	 * @param email String
	 * @param password String
	 * @param realPath String[]
	 * @return User
	 */
	User getUser(String email, String password, String... realPath);

	/**
	 * @param id long
	 * @param realPath String[]
	 * @return User
	 */
	User getUserById(long id, String... realPath);
}
