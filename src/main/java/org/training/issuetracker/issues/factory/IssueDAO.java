package org.training.issuetracker.issues.factory;

import java.util.List;

import org.training.issuetracker.issues.Issue;

/**
 * @author Hanna Hulevich
 *
 */
public interface IssueDAO {

	/**
	 * @param id long
	 * @param realPath String[]
	 * @return Issue
	 */
	Issue getIssueById(long id, String... realPath);

	/**
	 * @param realPath String
	 * @return List<Issue>
	 */
	List<Issue> getIssues(String realPath);
}
