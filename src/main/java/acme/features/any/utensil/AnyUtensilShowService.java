package acme.features.any.utensil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.utensil.Utensil;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyUtensilShowService implements AbstractShowService<Any, Utensil>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyUtensilRepository repository;


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
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", true);
		}

		@Override
		public Utensil findOne(final Request<Utensil> request) {
			assert request != null;

			Utensil result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneUtensilById(id);

			return result;
		}
}
