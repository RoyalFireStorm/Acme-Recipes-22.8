package acme.features.authenticated.systemconfigurator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.systemconfigurator.SystemConfigurator;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedSystemConfiguratorController extends AbstractController<Authenticated, SystemConfigurator>{

	@Autowired
	private AuthenticatedSystemConfiguratorShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("show", this.showService);
 
	}
	
	
}
