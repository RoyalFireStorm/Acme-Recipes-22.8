package acme.features.any.recipe;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.recipe.QuantityUtensil;
import acme.entities.recipe.Recipe;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyRecipeListAllService implements AbstractListService<Any, Recipe>{

	@Autowired
	AnyRecipeRepository repository;
	
	@Override
	public boolean authorise(final Request<Recipe> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Recipe> request, final Recipe entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final StringBuilder builder = new StringBuilder();
		final Integer id = entity.getId();
		final Collection<QuantityUtensil> utensil = this.repository.findAllQuantityUtensilsByRecipeId(id);
		int i =0;
		for(final QuantityUtensil qu : utensil) {
			builder.append(qu.getNumber()+" " + qu.getUtensil().getName());
			if(utensil.size()-i!=1) {
				builder.append(", ");
		 		i++;
			}else {
				builder.append(".");
			}
		}
		
		final String quantityIngredient = entity.getQuantityIngredient().getIngredient().getName() + ": " + entity.getQuantityIngredient().getNumber() + " " + entity.getQuantityIngredient().getUnit();
		
		model.setAttribute("quantityIngredient", quantityIngredient);
		model.setAttribute("quantityUtensil", builder);
		
		
		request.unbind(entity, model, "heading","code", "description","notes", "link");
	}

	@Override
	public Collection<Recipe> findMany(final Request<Recipe> request) {
		assert request != null;
		
		Collection<Recipe> result;
		result = this.repository.findAllRecipes();
		
		return result;
	}

}
