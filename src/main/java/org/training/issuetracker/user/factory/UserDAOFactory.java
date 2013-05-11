package org.training.issuetracker.user.factory;

import java.util.HashMap;

import org.training.issuetracker.user.impl_xml.UserImplXml;

public class UserDAOFactory {

	private static HashMap<String, UserDAO> map = new HashMap<String, UserDAO>();

	static {
		map.put(UserDAO.class.getName(), new UserImplXml());
	}

	public static Object getDAO(String className) {
		return map.get(className);
	}
}
