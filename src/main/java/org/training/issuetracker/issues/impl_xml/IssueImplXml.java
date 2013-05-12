package org.training.issuetracker.issues.impl_xml;

import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.issues.Issue;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.items.AbstractItemImplXml;
import org.training.issuetracker.items.Item;
import org.training.issuetracker.res.Constants;
import org.xml.sax.Attributes;

/**
 * @author Hanna Hulevich
 *
 */
public class IssueImplXml extends AbstractItemImplXml implements IssueDAO {

	private List<Issue> issues = new ArrayList<Issue>();
	private TagsEnum currentEnum = null;
	private Issue issue;

	/**
	 *
	 */
	public IssueImplXml() {
		super();
		setXmlFile(Constants.ISSUES_FILE_XML);
	}

	/**
	 * @param id long
	 * @param realPath String[]
	 * @return Issue
	 */
	@Override
	public Issue getIssueById(long id, String... realPath) {
		return (Issue) getItemById(id, realPath[0]);
	}

	/**
	 * @param realPath String
	 * @return List<Issue>
	 */
	@Override
	public List<Issue> getIssues(String realPath) {
		if (issues.isEmpty()) {
			parse(realPath);
		}
		return issues;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.AbstractItemImplXml#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		currentEnum = TagsEnum.valueOf(qName.toUpperCase());
		switch (currentEnum) {
		case ISSUE:
			issue = new Issue();
			issue.setId(Long.valueOf(attrs.getValue(0)));
			break;
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.AbstractItemImplXml#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.toUpperCase().equals(TagsEnum.ISSUE.toString())) {
			issues.add(issue);
		}
		currentEnum = null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.AbstractItemImplXml#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length).trim();
		if (currentEnum == null) {
			return;
		}
		switch (currentEnum) {
		case CREATE_DATE:
			issue.setCreateDate(getFormattedDate(s));
			break;
		case CREATED_BY:
			issue.setCreatedBy(Long.valueOf(s));
			break;
		case MODIFY_DATE:
			issue.setModifyDate(getFormattedDate(s));
			break;
		case MODIFIED_BY:
			issue.setModifiedBy(Long.valueOf(s));
			break;
		case SUMMARY:
			issue.setSummary(s);
			break;
		case DESCRIPTION:
			issue.setDescription(s);
			break;
		case STATUS:
			issue.setStatus(s);
			break;
		case RESOLUTION:
			issue.setResolution(s);
			break;
		case TYPE:
			issue.setType(s);
			break;
		case PRIORITY:
			issue.setPriority(s);
			break;
		case PROJECT:
			issue.setProject(s);
			break;
		case BUILD_FOUND:
			issue.setBuildFound(Integer.valueOf(s));
			break;
		case ASSIGNEE:
			issue.setAssignee(Long.valueOf(s));
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.AbstractItemImplXml#getItems(java.lang.String)
	 */
	@Override
	protected List<Item> getItems(String realPath) {
		return new ArrayList<Item>(getIssues(realPath));
	}
}
