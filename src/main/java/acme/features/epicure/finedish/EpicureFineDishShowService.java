package acme.features.epicure.finedish;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.finedish.FineDish;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Epicure;

@Service
public class EpicureFineDishShowService implements AbstractShowService<Epicure, FineDish>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected EpicureFineDishRepository repository;


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
			assert Objects.equals(request.getPrincipal().getUsername(), entity.getEpicure().getUserAccount().getUsername());
			
			request.unbind(entity, model, "status","code", "request","budget", "startDate", "endDate", "link", "chef.userAccount.username", "recipe.heading","chef.organisation","chef.assertion","chef.link", "chef.userAccount.identity.email");
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
