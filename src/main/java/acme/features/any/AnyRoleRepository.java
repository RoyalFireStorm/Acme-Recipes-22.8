package acme.features.any;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyRoleRepository extends AbstractRepository{
		
		
		@Query("select a from UserAccount a join a.roles r where a.enabled = true and (type(r) = Epicure or type(r) = Chef) and Administrator not in (select type(r) from UserAccount u join u.roles r where u.id = a.id)")
		Collection<UserAccount> findEnabledUserAccounts();
		
		@Query("select a from UserAccount a where a.id = :id")
		UserAccount findOneUserAccountById(Integer id);

}
