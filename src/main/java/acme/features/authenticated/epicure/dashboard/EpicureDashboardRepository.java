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

package acme.features.authenticated.epicure.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface EpicureDashboardRepository extends AbstractRepository {

	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.PROPOSED")
	Integer numberOfProposedFineDishesByStatus();
	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.ACCEPTED")
	Integer numberOfAcceptedFineDishesByStatus();
	@Query("select count(a) from FineDish a where a.status = acme.entities.finedish.DishStatus.DENIED")
	Integer numberOfDeniedFineDishesByStatus();

	@Query("select avg(a.budget.amount), a.budget.currency, a.status from FineDish a group by a.budget.currency, a.status")
	List<String> averageBudgetByCurrencyAndStatus();
	@Query("select stddev(a.budget.amount), a.budget.currency, a.status from FineDish a group by a.budget.currency, a.status")
	List<String> deviationBudgetByCurrencyAndStatus();
	@Query("select min(a.budget.amount), a.budget.currency, a.status from FineDish a group by a.budget.currency, a.status")
	List<String> minBudgetByCurrencyAndStatus();
	@Query("select max(a.budget.amount), a.budget.currency, a.status from FineDish a group by a.budget.currency, a.status")
	List<String> maxBudgetByCurrencyAndStatus();	
	@Query("select a.budget.currency from FineDish a")
	List<String> getAllCurrencies();	
	@Query("select a.status from FineDish a")
	List<Integer> getAllStatus();

}
