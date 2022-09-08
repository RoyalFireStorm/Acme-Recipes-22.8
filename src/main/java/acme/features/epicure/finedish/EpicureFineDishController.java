package acme.features.epicure.finedish;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.finedish.FineDish;
import acme.framework.controllers.AbstractController;
import acme.roles.Epicure;


@Controller
public class EpicureFineDishController extends AbstractController<Epicure, FineDish>{

	@Autowired
	private EpicureFineDishListService listService;
	
	@Autowired
	private EpicureFineDishShowService showService;
	
	@PostConstruct
	private void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}
	
	
}
