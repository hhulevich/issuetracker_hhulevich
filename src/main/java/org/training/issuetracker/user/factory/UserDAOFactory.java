package org.training.issuetracker.user.factory;

import java.util.HashMap;

import org.training.issuetracker.user.impl_xml.UserImplXml;

/**
 * @author Hanna Hulevich
 *
 */
public final class UserDAOFactory {

	/**
	 *
	 */
	private static HashMap<String, UserDAO> map = new HashMap<String, UserDAO>();


	/**
	 *
	 */
	private UserDAOFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		map.put(UserDAO.class.getName(), new UserImplXml());
	}

	/**
	 * @param className String
	 * @return Object
	 */
	public static Object getDAO(String className) {
		return map.get(className);
	}
}
