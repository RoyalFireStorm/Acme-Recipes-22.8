/*
 * AdministratorDashboardRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.PROPOSED")
	Integer numberOfProposedFineDishes();
	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.ACCEPTED")
	Integer numberOfAcceptedFineDishes();
	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.DENIED")
	Integer numberOfDeniedFineDishes();
	@Query("select count(a) from Ingredient a")
	Integer numberIngredients();
	@Query("select count(a) from Utensil a")
	Integer numberUtensils();
	
	@Query("select a.retailPrice.currency, avg(a.retailPrice.amount) from Ingredient a group by a.retailPrice.currency")
	List<String> averageRetailPriceByCurrencyIngredient();
	@Query("select a.retailPrice.currency, stddev(a.retailPrice.amount) from Ingredient a group by a.retailPrice.currency")
	List<String> deviationRetailPriceByCurrencyIngredient();
	@Query("select a.retailPrice.currency, min(a.retailPrice.amount) from Ingredient a group by a.retailPrice.currency")
	List<String> minRetailPriceByCurrencyIngredient();
	@Query("select a.retailPrice.currency, max(a.retailPrice.amount) from Ingredient a group by a.retailPrice.currency")
	List<String> maxRetailPriceByCurrencyIngredient();
	
	@Query("select a.retailPrice.currency, avg(a.retailPrice.amount) from Utensil a group by a.retailPrice.currency")
	List<String> averageRetailPriceByCurrencyUtensil();
	@Query("select a.retailPrice.currency, stddev(a.retailPrice.amount) from Utensil a group by a.retailPrice.currency")
	List<String> deviationRetailPriceByCurrencyUtensil();
	@Query("select a.retailPrice.currency, min(a.retailPrice.amount) from Utensil a group by a.retailPrice.currency")
	List<String> minRetailPriceByCurrencyUtensil();
	@Query("select a.retailPrice.currency, max(a.retailPrice.amount) from Utensil a group by a.retailPrice.currency")
	List<String> maxRetailPriceByCurrencyUtensil();
	
	//TODO: GroupBy Currency when Money Exchange Implements
	@Query("select a.status, avg(a.budget.amount) from FineDish a group by a.status")
	List<String> averageBudgetByCurrencyFineDish();
	@Query("select a.status, stddev(a.budget.amount) from FineDish a group by a.status")
	List<String> deviationBudgetByCurrencyFineDish();
	@Query("select a.status, min(a.budget.amount) from FineDish a group by a.status")
	List<String> minBudgetByCurrencyFineDish();
	@Query("select a.status, max(a.budget.amount) from FineDish a group by a.status")
	List<String> maxBudgetByCurrencyFineDish();
	
	
	
	
	
}
