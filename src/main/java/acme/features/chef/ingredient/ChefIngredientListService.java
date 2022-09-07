package acme.features.chef.ingredient;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ingredient.Ingredient;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Chef;

@Service
public class ChefIngredientListService implements AbstractListService<Chef, Ingredient>{

	@Autowired
	ChefIngredientRepository repository;
	
	@Override
	public boolean authorise(final Request<Ingredient> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Ingredient> request, final Ingredient entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "description","retailPrice", "link");
	}

	@Override
	public Collection<Ingredient> findMany(final Request<Ingredient> request) {
		assert request != null;
		
		Collection<Ingredient> result;
		final String user = request.getPrincipal().getUsername();
		result = this.repository.findAllIngredientsByChef(user);
		
		return result;
	}

}
