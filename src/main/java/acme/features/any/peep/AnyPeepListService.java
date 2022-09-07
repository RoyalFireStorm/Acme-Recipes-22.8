package acme.features.any.peep;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.peep.Peep;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyPeepListService implements AbstractListService<Any, Peep>{

	@Autowired
	AnyPeepRepository repository;
	
	@Override
	public boolean authorise(final Request<Peep> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Peep> request, final Peep entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "moment","heading", "writer","text", "email");
	}

	@Override
	public Collection<Peep> findMany(final Request<Peep> request) {
		assert request != null;
		
		Collection<Peep> result;
		final LocalDate time = LocalDate.now().minusMonths(1);
		result = this.repository.findLessThanAMonth(time);
		
		return result;
	}

}
