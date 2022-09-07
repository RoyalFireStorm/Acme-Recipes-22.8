package acme.features.any.ingredient;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ingredient.Ingredient;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyIngredientListService implements AbstractListService<Any, Ingredient>{

	@Autowired
	AnyIngredientRepository repository;
	
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
		result = this.repository.findAllIngredients();
		
		return result;
	}

}
