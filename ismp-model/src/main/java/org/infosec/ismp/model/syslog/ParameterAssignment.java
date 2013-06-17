package org.infosec.ismp.model.syslog;

import java.io.Serializable;

public class ParameterAssignment implements Serializable {
	/**
	 * The number of the matching group from the regex
	 *  whose value will be assigned. Group 0 always refers
	 *  to the entire string matched by the expression. If
	 *  the referenced group does not exist, the empty string
	 *  will be assigned.
	 *  
	 */
	private int matchingGroup;

	/**
	 * keeps track of state for field: _matchingGroup
	 */
	private boolean has_matchingGroup;

	/**
	 * The name of the event parameter to which the named
	 *  matching group's value will be assigned
	 *  
	 */
	private java.lang.String parameterName;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public ParameterAssignment() {
		super();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 */
	public void deleteMatchingGroup() {
		this.has_matchingGroup = false;
	}

	/**
	 * Returns the value of field 'matchingGroup'. The field
	 * 'matchingGroup' has the following description: The number of
	 * the matching group from the regex
	 *  whose value will be assigned. Group 0 always refers
	 *  to the entire string matched by the expression. If
	 *  the referenced group does not exist, the empty string
	 *  will be assigned.
	 *  
	 * 
	 * @return the value of field 'MatchingGroup'.
	 */
	public int getMatchingGroup() {
		return this.matchingGroup;
	}

	/**
	 * Returns the value of field 'parameterName'. The field
	 * 'parameterName' has the following description: The name of
	 * the event parameter to which the named
	 *  matching group's value will be assigned
	 *  
	 * 
	 * @return the value of field 'ParameterName'.
	 */
	public java.lang.String getParameterName() {
		return this.parameterName;
	}

	/**
	 * Method hasMatchingGroup.
	 * 
	 * @return true if at least one MatchingGroup has been added
	 */
	public boolean hasMatchingGroup() {
		return this.has_matchingGroup;
	}

	/**
	 * Sets the value of field 'matchingGroup'. The field
	 * 'matchingGroup' has the following description: The number of
	 * the matching group from the regex
	 *  whose value will be assigned. Group 0 always refers
	 *  to the entire string matched by the expression. If
	 *  the referenced group does not exist, the empty string
	 *  will be assigned.
	 *  
	 * 
	 * @param matchingGroup the value of field 'matchingGroup'.
	 */
	public void setMatchingGroup(final int matchingGroup) {
		this.matchingGroup = matchingGroup;
		this.has_matchingGroup = true;
	}

	/**
	 * Sets the value of field 'parameterName'. The field
	 * 'parameterName' has the following description: The name of
	 * the event parameter to which the named
	 *  matching group's value will be assigned
	 *  
	 * 
	 * @param parameterName the value of field 'parameterName'.
	 */
	public void setParameterName(final java.lang.String parameterName) {
		this.parameterName = parameterName;
	}

}
