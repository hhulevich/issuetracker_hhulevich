package org.training.issuetracker.comments.factory;

import java.util.HashMap;

import org.training.issuetracker.comments.impl_xml.CommentImplXml;

/**
 * @author Hanna Hulevich
 *
 */
public final class CommentDAOFactory {

	/**
	 *
	 */
	private static HashMap<String, CommentDAO> map = new HashMap<String, CommentDAO>();

	/**
	 *
	 */
	private CommentDAOFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		map.put(CommentDAO.class.getName(), new CommentImplXml());
	}

	/**
	 * @param className String
	 * @return Object
	 */
	public static Object getDAO(String className) {
		return map.get(className);
	}
}
