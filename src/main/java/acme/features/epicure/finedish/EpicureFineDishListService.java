package acme.features.epicure.finedish;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.finedish.FineDish;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Epicure;

@Service
public class EpicureFineDishListService implements AbstractListService<Epicure, FineDish>{

	@Autowired
	EpicureFineDishRepository repository;
	
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
		
		request.unbind(entity, model, "status","code", "request","budget", "startDate", "endDate", "link", "chef.userAccount.username", "recipe.heading");
	}

	@Override
	public Collection<FineDish> findMany(final Request<FineDish> request) {
		assert request != null;
		
		Collection<FineDish> result;
		final String user = request.getPrincipal().getUsername();
		result = this.repository.findAllFineDishsByEpicure(user);
		
		return result;
	}

}
