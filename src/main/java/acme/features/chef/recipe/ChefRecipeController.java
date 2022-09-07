package acme.features.chef.recipe;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.recipe.Recipe;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;

@Controller
public class ChefRecipeController extends AbstractController<Chef, Recipe>{

	@Autowired
	private ChefRecipeListAllService listAllService;
	
	@Autowired
	private ChefRecipeShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-all","list", this.listAllService);
		super.addCommand("show", this.showService);
	}
	
	
}
