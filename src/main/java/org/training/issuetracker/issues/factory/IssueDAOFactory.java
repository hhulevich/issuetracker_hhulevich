package org.training.issuetracker.issues.factory;

import java.util.HashMap;

import org.training.issuetracker.issues.impl_xml.IssueImplXml;

/**
 * @author Hanna Hulevich
 *
 */
public final class IssueDAOFactory {

	/**
	 *
	 */
	private static HashMap<String, IssueDAO> map = new HashMap<String, IssueDAO>();

	/**
	 *
	 */
	private IssueDAOFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		map.put(IssueDAO.class.getName(), new IssueImplXml());
	}

	/**
	 * @param className String
	 * @return Object
	 */
	public static Object getDAO(String className) {
		return map.get(className);
	}
}
