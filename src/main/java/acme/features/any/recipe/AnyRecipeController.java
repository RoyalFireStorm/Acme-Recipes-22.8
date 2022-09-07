package acme.features.any.recipe;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.recipe.Recipe;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyRecipeController extends AbstractController<Any, Recipe>{

	@Autowired
	private AnyRecipeListAllService listAllService;
	
	@Autowired
	private AnyRecipeShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list-all","list", this.listAllService);
		super.addCommand("show", this.showService);
	}
	
	
}
