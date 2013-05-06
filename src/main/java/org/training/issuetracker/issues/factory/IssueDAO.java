package org.training.issuetracker.issues.factory;

import org.training.issuetracker.issues.Issue;

public interface IssueDAO  {
	
	public Issue getIssueById(Long id, String ...realPath);
	
}
