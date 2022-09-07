package acme.features.any.utensil;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.utensil.Utensil;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyUtensilController extends AbstractController<Any, Utensil>{

	@Autowired
	private AnyUtensilListService listService;
	
	@Autowired
	private AnyUtensilShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
	
	
}
