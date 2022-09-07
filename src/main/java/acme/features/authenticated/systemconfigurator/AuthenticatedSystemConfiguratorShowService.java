package acme.features.authenticated.systemconfigurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.systemconfigurator.SystemConfigurator;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedSystemConfiguratorShowService implements AbstractShowService<Authenticated, SystemConfigurator>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AuthenticatedSystemConfiguratorRepository repository;


		@Override
		public boolean authorise(final Request<SystemConfigurator> request) {
			assert request != null;
			
	        return true;
		}
		
		@Override
		public void unbind(final Request<SystemConfigurator> request, final SystemConfigurator entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "acceptedCurrencies", "systemCurrency");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", true);
		}

		@Override
		public SystemConfigurator findOne(final Request<SystemConfigurator> request) {
			assert request != null;

			SystemConfigurator result;
			
			result = this.repository.findOneSystemConfigurator();

			return result;
		}
}
