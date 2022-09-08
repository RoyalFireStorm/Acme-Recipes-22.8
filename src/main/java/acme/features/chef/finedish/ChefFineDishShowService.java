package acme.features.chef.finedish;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.finedish.FineDish;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Chef;

@Service
public class ChefFineDishShowService implements AbstractShowService<Chef, FineDish>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ChefFineDishRepository repository;


		@Override
		public boolean authorise(final Request<FineDish> request) {
			assert request != null;
			
	        return true;
		}
		
		@Override
		public void unbind(final Request<FineDish> request, final FineDish entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			assert Objects.equals(request.getPrincipal().getUsername(), entity.getChef().getUserAccount().getUsername());
			
			request.unbind(entity, model, "status","code", "request","budget", "startDate", "endDate", "link", "epicure.userAccount.username", "recipe.heading","epicure.organisation","epicure.assertion","epicure.link", "epicure.userAccount.identity.email");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", true);
		}

		@Override
		public FineDish findOne(final Request<FineDish> request) {
			assert request != null;

			FineDish result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneFineDishById(id);

			return result;
		}
}
