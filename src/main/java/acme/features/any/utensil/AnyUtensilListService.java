package acme.features.any.utensil;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.utensil.Utensil;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyUtensilListService implements AbstractListService<Any, Utensil>{

	@Autowired
	AnyUtensilRepository repository;
	
	@Override
	public boolean authorise(final Request<Utensil> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Utensil> request, final Utensil entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name","code", "description","retailPrice", "link");
	}

	@Override
	public Collection<Utensil> findMany(final Request<Utensil> request) {
		assert request != null;
		
		Collection<Utensil> result;
		result = this.repository.findAllUtensils();
		
		return result;
	}

}
