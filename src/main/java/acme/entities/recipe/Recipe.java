package acme.entities.recipe;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.ingredient.Ingredient;
import acme.entities.utensil.Utensil;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recipe extends AbstractEntity{
	
	    // Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------
		
		
		@NotBlank
		@Pattern(regexp="^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$")
		protected String			code;
		
		@NotBlank
		protected String			heading;
		
		@NotBlank
		protected String			description;
		
		@NotBlank
		protected String			notes;
		
		@URL
		protected String			link;
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		@Valid
		@NotNull
		@ManyToOne(optional=false)
		protected Ingredient ingredient;
		
		@Valid
		@NotNull
		@ManyToMany()
		protected Set<Utensil>  utensil;
}
