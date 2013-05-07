package org.training.issuetracker.issues.factory;

import java.util.List;

import org.training.issuetracker.issues.Issue;

public interface IssueDAO  {
	
	public Issue getIssueById(Long id, String ...realPath);
	
	public List<Issue> getIssues(String realPath);
	
}
