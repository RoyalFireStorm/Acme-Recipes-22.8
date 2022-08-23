package acme.entities.finedish;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.recipe.Recipe;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Chef;
import acme.roles.Epicure;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FineDish extends AbstractEntity{
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@NotNull
	protected DishStatus		status;
	
	@NotBlank
	@Pattern(regexp="^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$")
	protected String			code;
	
	@NotBlank
	protected String			request;
	
	@NotNull
	protected Money				budget;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				endDate;
	
	@URL
	protected String			link;
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	protected Epicure epicure;
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	protected Chef chef;
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	protected Recipe recipe;
}
