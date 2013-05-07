package org.training.issuetracker.issues.impl_xml;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.training.issuetracker.issues.Issue;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class IssueImplXml  extends DefaultHandler implements IssueDAO {

	private List<Issue> issues = new ArrayList<Issue>();
	private TagsEnum currentEnum = null;
	private Issue issue;
	
	@Override
	public Issue getIssueById(Long id, String... realPath) {
		List<Issue> issues = getIssues(realPath[0]);
		for (Issue issue : issues) {
			if (issue.getId() == id) {
				return issue;
			}
		}
		return null;
	}
	
	public List<Issue> getIssues(String realPath) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(this);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(realPath + "\\org\\training\\issuetracker\\res\\issues.xml", this);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return issues;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attrs) { 
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
	
	public void endElement(String uri, String localName, String qName) { 
		if (qName.toUpperCase().equals(TagsEnum.ISSUE.toString())) { 
			issues.add(issue);
		}
		currentEnum = null;
	} 
	
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
				issue.setPriority(Integer.valueOf(s));
				break;
			case PROJECT:
				issue.setProject(s);
				break;
			case BUILD_FOUND:
				issue.setBuild_found(Integer.valueOf(s));
				break;
			case ASSIGNEE:
				issue.setAssignee(Long.valueOf(s));
			default:
				break;
			}
		}

	private static Date getFormattedDate(String dateStr) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = (Date) df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
