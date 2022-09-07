package acme.features.chef.ingredient;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.ingredient.Ingredient;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;


@Controller
public class ChefIngredientController extends AbstractController<Chef, Ingredient>{

	@Autowired
	private ChefIngredientListService listService;
	
	@Autowired
	private ChefIngredientShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
	
	
}
