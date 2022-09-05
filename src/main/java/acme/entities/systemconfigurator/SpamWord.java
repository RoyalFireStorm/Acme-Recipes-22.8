package acme.entities.systemconfigurator;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpamWord extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	public String 				word;
	
	@NotNull 
	public Double				weight;
	
	@Valid
	@ManyToOne
	@NotNull
	public SystemConfigurator 	config;
}
