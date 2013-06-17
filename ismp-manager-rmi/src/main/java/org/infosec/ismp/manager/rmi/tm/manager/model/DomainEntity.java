package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *  域对象
 */
@Entity
@Table(name = "ismp_domain")
public class DomainEntity  implements  Serializable{
	
	private static final long serialVersionUID = -4751104686794976875L;
	
	protected Integer id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String domainName;
	private String description;
	private DomainEntity parentDomain;

	@Column(name="domain_name")
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @ManyToOne
    @JoinColumn(name="parent_id")
	public DomainEntity getParentDomain() {
		return parentDomain;
	}

	public void setParentDomain(DomainEntity parentDomain) {
		this.parentDomain = parentDomain;
	}


	
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("domainName",
				domainName).append("description", description).append(
				"parentDomain", parentDomain).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof DomainEntity))
			return false;
		DomainEntity castOther = (DomainEntity) other;
		return new EqualsBuilder().append(id, castOther.id).append(domainName,
				castOther.domainName)
				.append(description, castOther.description).append(
						parentDomain, castOther.parentDomain).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(domainName).append(
				description).append(parentDomain).toHashCode();
	}
}
