package acme.features.any.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ingredient.Ingredient;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyIngredientShowService implements AbstractShowService<Any, Ingredient>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyIngredientRepository repository;


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

			request.unbind(entity, model, "name","code", "description","retailPrice", "link");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", true);
		}

		@Override
		public Ingredient findOne(final Request<Ingredient> request) {
			assert request != null;

			Ingredient result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneIngredientById(id);

			return result;
		}
}
