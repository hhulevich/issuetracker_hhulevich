package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

public class AssegneeAscendingComparator implements Comparator<IssueFromList> {

	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return arg1.getAssignee().compareTo(arg2.getAssignee());
	}
}
