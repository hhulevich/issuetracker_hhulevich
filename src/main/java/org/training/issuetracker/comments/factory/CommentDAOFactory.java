package org.training.issuetracker.comments.factory;

import java.util.HashMap;

import org.training.issuetracker.comments.impl_xml.CommentImplXml;

public class CommentDAOFactory {

	private static HashMap<String, CommentDAO> map = new HashMap<String, CommentDAO>();

	static {
		map.put(CommentDAO.class.getName(), new CommentImplXml());
	}

	public static Object getDAO(String className) {
		return map.get(className);
	}
}
