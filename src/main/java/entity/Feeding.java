package entity;

import javax.persistence.*;

@Entity
public class Feeding {

	private long id;
	private User user;
	private Survey survey;
	private String preference;
	private String allergy;

	@Id
	@GeneratedValue
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@ManyToOne
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@ManyToOne
	public Survey getSurvey()
	{
		return survey;
	}

	public void setSurvey(Survey survey)
	{
		this.survey = survey;
	}

	public String getPreference()
	{
		return preference;
	}

	public void setPreference(String preference)
	{
		this.preference = preference;
	}

	public String getAllergy()
	{
		return allergy;
	}

	public void setAllergy(String allergy)
	{
		this.allergy = allergy;
	}
}
