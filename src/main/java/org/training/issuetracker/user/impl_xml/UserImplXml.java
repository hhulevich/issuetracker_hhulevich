package org.training.issuetracker.user.impl_xml;

import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.items.AbstractItemImplXml;
import org.training.issuetracker.items.Item;
import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.xml.sax.Attributes;

/**
 * @author Hanna Hulevich
 *
 */
public class UserImplXml extends AbstractItemImplXml implements UserDAO {

	private List<User> users = new ArrayList<User>();
	private User user;
	private TagsEnum currentEnum = null;

	/**
	 *
	 */
	public UserImplXml() {
		super();
		setXmlFile(Constants.USERS_FILE_XML);
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.user.factory.UserDAO#getUser(java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public User getUser(String email, String password, String... realPath) {
		List<User> localUsers = getUsers(realPath[0]);
		for (User currentUser : localUsers) {
			if (currentUser.getEmailAddress().equals(email)
					&& currentUser.getPassword().equals(password)) {
				return currentUser;
			}
		}
		return null;
	}

	/**
	 * @param realPath String
	 * @return List<User>
	 */
	private List<User> getUsers(String realPath) {
		if (users.isEmpty()) {
			parse(realPath);
		}
		return users;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.user.factory.UserDAO#getUserById(long, java.lang.String[])
	 */
	@Override
	public User getUserById(long id, String... realPath) {
		return (User) getItemById(id, realPath[0]);
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
		case USER:
			user = new User();
			user.setId(Long.valueOf(attrs.getValue(0)));
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
		if (qName.toUpperCase().equals(TagsEnum.USER.toString())) {
			users.add(user);
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
		case FIRST_NAME:
			user.setFirstName(s);
			break;
		case LAST_NAME:
			user.setLastName(s);
		case EMAIL_ADDRESS:
			user.setEmailAddress(s);
		case ROLE:
			user.setRole(s);
		case PASSWORD:
			user.setPassword(s);
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.AbstractItemImplXml#getItems(java.lang.String)
	 */
	@Override
	protected List<Item> getItems(String realPath) {
		return new ArrayList<Item>(getUsers(realPath));
	}
}
