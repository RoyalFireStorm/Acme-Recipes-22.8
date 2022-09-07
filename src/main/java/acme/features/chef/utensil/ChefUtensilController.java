package acme.features.chef.utensil;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.utensil.Utensil;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;

@Controller
public class ChefUtensilController extends AbstractController<Chef, Utensil>{

	@Autowired
	private ChefUtensilListService listService;
	
	@Autowired
	private ChefUtensilShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
	
	
}
