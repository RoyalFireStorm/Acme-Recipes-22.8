package acme.features.chef.finedish;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.finedish.FineDish;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;


@Controller
public class ChefFineDishController extends AbstractController<Chef, FineDish>{

	@Autowired
	private ChefFineDishListService listService;
	
	@Autowired
	private ChefFineDishShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
	
	
}
