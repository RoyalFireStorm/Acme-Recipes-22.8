package acme.features.any.peep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.peep.Peep;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyPeepController extends AbstractController<Any, Peep>{

	@Autowired
	private AnyPeepListService listService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
 
	}
	
	
}
