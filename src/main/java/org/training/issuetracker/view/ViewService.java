package org.training.issuetracker.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.training.issuetracker.comments.Comment;
import org.training.issuetracker.comments.CommentView;
import org.training.issuetracker.comments.factory.CommentDAO;
import org.training.issuetracker.issues.Issue;
import org.training.issuetracker.issues.IssueFromList;
import org.training.issuetracker.issues.IssueView;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.view.comparators.AssegneeAscendingComparator;
import org.training.issuetracker.view.comparators.AssigneeDescendingComparator;
import org.training.issuetracker.view.comparators.IdAscendingComparator;
import org.training.issuetracker.view.comparators.IdDescendingComparator;
import org.training.issuetracker.view.comparators.PriorityAscendingComparator;
import org.training.issuetracker.view.comparators.PriorityDescendingComparator;
import org.training.issuetracker.view.comparators.StatusAscendingComparator;
import org.training.issuetracker.view.comparators.StatusDescendingComparator;
import org.training.issuetracker.view.comparators.SummaryAscendingComparator;
import org.training.issuetracker.view.comparators.SummaryDescendingComparator;
import org.training.issuetracker.view.comparators.TypeAscendingComparator;
import org.training.issuetracker.view.comparators.TypeDescendingComparator;

/**
 * @author Hanna Hulevich
 *
 */
public class ViewService {

	/**
	 * @param issueDAO IssueDAO
	 * @param userDAO UserDAO
	 * @param realPath String
	 * @return List<IssueFromList>
	 */
	public List<IssueFromList> getIssueList(IssueDAO issueDAO, UserDAO userDAO,
			String... realPath) {
		List<IssueFromList> issueList = new ArrayList<IssueFromList>();
		List<Issue> issues = issueDAO.getIssues(realPath[0]);
		IssueFromList issueFromList = null;
		for (Issue issue : issues) {
			issueFromList = new IssueFromList();
			issueFromList.setId(issue.getId());
			issueFromList.setPriority(issue.getPriority());
			issueFromList.setAssignee(getAssignee(issue.getAssignee(), userDAO,
					realPath));
			issueFromList.setType(issue.getStatus());
			issueFromList.setStatus(issue.getStatus());
			issueFromList.setSummary(issue.getSummary());
			issueList.add(issueFromList);
		}
		return issueList;
	}

	/**
	 * @param issueId long
	 * @param issueDAO IssueDAO
	 * @param userDAO UserDAO
	 * @param realPath String[]
	 * @return IssueView
	 */
	public IssueView getIssueView(long issueId, IssueDAO issueDAO,
			UserDAO userDAO, String... realPath) {
		IssueView issueView = new IssueView();
		Issue issue = issueDAO.getIssueById(issueId, realPath);
		issueView.setId(issueId);
		issueView.setCreateDate(formatDate(issue.getCreateDate()));
		issueView.setCreatedBy((userDAO.getUserById(issue.getCreatedBy(),
				realPath)).getLastName());
		issueView.setModifyDate(formatDate(issue.getModifyDate()));
		issueView.setModifiedBy((userDAO.getUserById(issue.getCreatedBy(),
				realPath)).getLastName());
		issueView.setSummary(issue.getSummary());
		issueView.setDescription(issue.getDescription());
		issueView.setStatus(issue.getStatus());
		issueView.setResolution(issue.getResolution());
		issueView.setType(issue.getType());
		issueView.setPriority(issue.getPriority());
		issueView.setProject(issue.getProject());
		issueView.setBuildFound(issue.getBuildFound());
		issueView.setAssignee(getAssignee(issueId, userDAO, realPath));
		return issueView;
	}

	/**
	 * @param issueId long
	 * @param commentDAO CommentDAO
	 * @param userDAO UserDAO
	 * @param realPath String[]
	 * @return List<CommentView>
	 */
	public List<CommentView> getCommentsView(long issueId,
			CommentDAO commentDAO, UserDAO userDAO, String... realPath) {
		List<CommentView> commentsView = new ArrayList<CommentView>();
		CommentView commentView = null;
		List<Comment> comments = commentDAO.getCommentsByIssueId(issueId,
				realPath);
		for (Comment comment : comments) {
			commentView = new CommentView();
			commentView.setText(comment.getText());
			commentView.setAddedBy(userDAO.getUserById(comment.getAddedBy(),
					realPath).getLastName());
			commentView.setAddDate(formatDate(comment.getAddDate()));
			commentsView.add(commentView);
		}
		return commentsView;
	}

	/**
	 * @param issueId long
	 * @param userDAO UserDAO
	 * @param realPath String[]
	 * @return
	 */
	private String getAssignee(long issueId, UserDAO userDAO,
			String... realPath) {
		User user = userDAO.getUserById(issueId, realPath);
		if (user == null) {
			return "not assigned";
		} else {
			return user.getLastName();
		}
	}

	/**
	 * @param date Date
	 * @return String
	 */
	private static String formatDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * @param issues List<IssueFromList>
	 * @param issuesNumber int
	 * @param sortParameter String
	 * @return List<IssueFromList>
	 */
	public List<IssueFromList> getSortedViewIssues(List<IssueFromList> issues,
			int issuesNumber, String sortParameter) {
		if (sortParameter != null) {
			SortParametersEnum currentEnum = SortParametersEnum
					.valueOf(sortParameter.toUpperCase());
			switch (currentEnum) {
			case ID_ASC:
				Collections.sort(issues, new IdAscendingComparator());
				break;
			case ID_DESC:
				Collections.sort(issues, new IdDescendingComparator());
				break;
			case PRIORITY_ASC:
				Collections.sort(issues, new PriorityAscendingComparator());
				break;
			case PRIORITY_DESC:
				Collections.sort(issues, new PriorityDescendingComparator());
				break;
			case ASSIGNEE_ASC:
				Collections.sort(issues, new AssegneeAscendingComparator());
				break;
			case ASSIGNEE_DESC:
				Collections.sort(issues, new AssigneeDescendingComparator());
				break;
			case STATUS_ASC:
				Collections.sort(issues, new StatusAscendingComparator());
				break;
			case STATUS_DESC:
				Collections.sort(issues, new StatusDescendingComparator());
				break;
			case SUMMARY_ASC:
				Collections.sort(issues, new SummaryAscendingComparator());
				break;
			case SUMMARY_DESC:
				Collections.sort(issues, new SummaryDescendingComparator());
				break;
			case TYPE_ASC:
				Collections.sort(issues, new TypeAscendingComparator());
				break;
			case TYPE_DESC:
				Collections.sort(issues, new TypeDescendingComparator());
			default:
				break;
			}
		}

		if (issues.size() < issuesNumber) {
			return issues;
		}
		return issues.subList(0, issuesNumber);
	}
}
