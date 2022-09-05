package acme.entities.systemconfigurator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfigurator extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	public String acceptedCurrencies;
	
	@NotBlank
	public String systemCurrency;
	
	@Range(min = 0, max = 1)
	@Digits(integer = 1, fraction = 2)
	@NotNull
	public Double spamThreshold;
	
	public List<String> listAcceptedCurrencies(){
		final List<String> currencies = new ArrayList<String>();
		for(int i=0;i<this.acceptedCurrencies.split(",").length;i++){
			currencies.add(this.acceptedCurrencies.split(",")[i]);
		}
		return currencies;
	}
	
	
	
}