/*
 * AnonymousShoutRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.chef.utensil;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.utensil.Utensil;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ChefUtensilRepository extends AbstractRepository {
	
	@Query("select a from Utensil a where a.id = :id")
	Utensil findOneUtensilById(int id);
	
	@Query("select a from Utensil a where a.chef.userAccount.username = :user")
	Collection<Utensil> findAllUtensilsByChef(String user);
	
}
