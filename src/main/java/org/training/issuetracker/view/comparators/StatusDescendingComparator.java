package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

public class StatusDescendingComparator implements Comparator<IssueFromList>{

	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return arg2.getStatus().compareTo(arg1.getStatus());
	}
}
