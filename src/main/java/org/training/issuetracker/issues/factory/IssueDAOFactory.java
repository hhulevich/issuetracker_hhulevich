package org.training.issuetracker.issues.factory;

import java.util.HashMap;
import org.training.issuetracker.issues.impl_xml.IssueImplXml;

public class IssueDAOFactory {
	
	private static HashMap<String, IssueDAO> map = new HashMap<String, IssueDAO>();

	static {
		map.put(IssueDAO.class.getName(), new IssueImplXml());
	}
	
	public static Object getDAO(String className) {
		return map.get(className);
	}

}
