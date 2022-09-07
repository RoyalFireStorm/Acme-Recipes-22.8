package acme.features.chef.utensil;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.utensil.Utensil;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Chef;

@Service
public class ChefUtensilShowService implements AbstractShowService<Chef, Utensil>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChefUtensilRepository repository;


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
			assert Objects.equals(request.getPrincipal().getUsername(), entity.getChef().getUserAccount().getUsername());
			
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
