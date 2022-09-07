package acme.entities.ingredient;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Chef;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		
		@NotBlank
		protected String			name;
		
		@NotBlank
		@Pattern(regexp="^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$")
		protected String			code;
		
		@NotBlank
		protected String			description;
		
		@NotNull
		protected Money				retailPrice;
		
		@URL
		protected String			link;
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------

		
		@Valid
		@NotNull
		@ManyToOne(optional=false)
		protected Chef chef;
}
