package acme.features.chef.utensil;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.utensil.Utensil;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Chef;

@Service
public class ChefUtensilListService implements AbstractListService<Chef, Utensil>{

	@Autowired
	ChefUtensilRepository repository;
	
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
		final String user = request.getPrincipal().getUsername();
		Collection<Utensil> result;
		result = this.repository.findAllUtensilsByChef(user);
		
		return result;
	}

}
