package acme.features.any;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;

@Controller
public class AnyRoleController extends AbstractController<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected  AnyRoleListService listService;

	@Autowired
	protected  AnyRoleShowService showService;
	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
