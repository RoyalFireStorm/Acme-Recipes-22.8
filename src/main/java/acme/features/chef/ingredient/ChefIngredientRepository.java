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

package acme.features.chef.ingredient;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ingredient.Ingredient;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ChefIngredientRepository extends AbstractRepository {

	@Query("select a from Ingredient a where a.id = :id")
	Ingredient findOneIngredientById(int id);
	
	@Query("select a from Ingredient a where a.chef.userAccount.username = :user")
	Collection<Ingredient> findAllIngredientsByChef(String user);
	
}
