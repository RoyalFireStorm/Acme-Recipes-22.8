package acme.features.authenticated;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyRoleListService implements AbstractListService<Any, UserAccount>{

	@Autowired
	protected AnyRoleRepository		repository;
	
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		
		return true;
	}
	
	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request){
		assert request != null;
		Collection<UserAccount> result;
		
		result = this.repository.findEnabledUserAccounts();
		
		for (final UserAccount userAccount : result) {
			userAccount.getRoles().forEach(r -> { ; });
		}
		
		return result;
	}

	
	 @Override
	 public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		 assert request != null;
		 assert entity != null;
		 assert model != null;
		 //String Builder for role
		 final StringBuilder builder = new StringBuilder();
		 final Collection<UserRole> roles = entity.getRoles();
		
		 int aux= roles.size();
		
		 for (final UserRole rol : roles) {
			 if(!"Authenticated".equals(rol.getAuthorityName())) {
				 builder.append(rol.getAuthorityName());
			 	
			 	if(aux > 1) {
			 		builder.append("  ");
			 		aux--;
			 	}
			 }
		 }
		 
		 model.setAttribute("roles", builder.toString());
		 
		 request.unbind(entity, model, "username", "identity.email");
		 
	 }
	 
	 
}
