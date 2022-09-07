package acme.features.any.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.recipe.QuantityUtensil;
import acme.entities.recipe.Recipe;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyRecipeShowService implements AbstractShowService<Any, Recipe>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyRecipeRepository repository;


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

			final Integer id = entity.getId();
			final StringBuilder builder = new StringBuilder();
			final int size = this.repository.findAllQuantityUtensilsByRecipeId(id).size();
			int i = 0;
			for(final QuantityUtensil qu:this.repository.findAllQuantityUtensilsByRecipeId(id)) {
				builder.append(qu.getNumber()+ " "+ qu.getUtensil().getName());
				
				if(size-i!=1) {
					builder.append("\n");
					i++;
				}
			}
			
			final String quantityNumberIngredient = entity.getQuantityIngredient().getNumber() + " " + entity.getQuantityIngredient().getUnit();
			
			
			model.setAttribute("mapUtensil", builder);
			model.setAttribute("quantityIngredient", quantityNumberIngredient);
			
			request.unbind(entity, model, "heading","code", "description","notes", "link", "quantityIngredient.ingredient.name");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", true);
		}

		@Override
		public Recipe findOne(final Request<Recipe> request) {
			assert request != null;

			Recipe result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneRecipeById(id);

			return result;
		}
}
