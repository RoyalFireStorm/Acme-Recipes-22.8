/*
 * AdministratorDashboardShowService.java
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDashboardRepository repository;

	// AbstractShowService<Administrator, AdministratorDashboard> interface ----------------


	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;

		final AdministratorDashboard result;
		final Integer totalNumberIngredients;
		final Integer totalNumberUtensils;
		final Integer totalNumberOfProposedFineDishes;
		final Integer totalNumberOfAcceptedFineDishes;
		final Integer totalNumberOfDeniedFineDishes;
		final Map<String,Double> averageRetailPriceByCurrencyIngredient;
		final Map<String,Double> deviationRetailPriceByCurrencyIngredient;
		final Map<String,Double> minRetailPriceByCurrencyIngredient;
		final Map<String,Double> maxRetailPriceByCurrencyIngredient;
		final Map<String,Double> averageRetailPriceByCurrencyUtensil;
		final Map<String,Double> deviationRetailPriceByCurrencyUtensil;
		final Map<String,Double> minRetailPriceByCurrencyUtensil;
		final Map<String,Double> maxRetailPriceByCurrencyUtensil;
		final Map<String,Double> averageBudgetByStatusFineDishes;
		final Map<String,Double> deviationBudgetByStatusFineDishes;
		final Map<String,Double> minBudgetByStatusFineDishes;
		final Map<String,Double> maxBudgetByStatusFineDishes;
		
		totalNumberIngredients = this.repository.numberIngredients();
		totalNumberUtensils = this.repository.numberUtensils();
		totalNumberOfProposedFineDishes = this.repository.numberOfProposedFineDishes();
		totalNumberOfAcceptedFineDishes = this.repository.numberOfAcceptedFineDishes();
		totalNumberOfDeniedFineDishes = this.repository.numberOfAcceptedFineDishes();;
		averageRetailPriceByCurrencyIngredient = this.parseQueryStringDouble(this.repository.averageRetailPriceByCurrencyIngredient());
		deviationRetailPriceByCurrencyIngredient = this.parseQueryStringDouble(this.repository.deviationRetailPriceByCurrencyIngredient());
		minRetailPriceByCurrencyIngredient = this.parseQueryStringDouble(this.repository.minRetailPriceByCurrencyIngredient());
		maxRetailPriceByCurrencyIngredient = this.parseQueryStringDouble(this.repository.maxRetailPriceByCurrencyIngredient());
		averageRetailPriceByCurrencyUtensil = this.parseQueryStringDouble(this.repository.averageRetailPriceByCurrencyUtensil());
		deviationRetailPriceByCurrencyUtensil = this.parseQueryStringDouble(this.repository.deviationRetailPriceByCurrencyUtensil());
		minRetailPriceByCurrencyUtensil = this.parseQueryStringDouble(this.repository.minRetailPriceByCurrencyUtensil());
		maxRetailPriceByCurrencyUtensil = this.parseQueryStringDouble(this.repository.maxRetailPriceByCurrencyUtensil());
		averageBudgetByStatusFineDishes = this.parseQueryStringDouble(this.repository.averageBudgetByCurrencyFineDish());
		deviationBudgetByStatusFineDishes = this.parseQueryStringDouble(this.repository.deviationBudgetByCurrencyFineDish());
		minBudgetByStatusFineDishes = this.parseQueryStringDouble(this.repository.minBudgetByCurrencyFineDish());
		maxBudgetByStatusFineDishes = this.parseQueryStringDouble(this.repository.maxBudgetByCurrencyFineDish());
		
		
		
		result = new AdministratorDashboard();
		result.setTotalNumberIngredients(totalNumberIngredients);
		result.setTotalNumberUtensils(totalNumberUtensils);
		result.setTotalNumberOfProposedFineDishes(totalNumberOfProposedFineDishes);
		result.setTotalNumberOfAcceptedFineDishes(totalNumberOfAcceptedFineDishes);
		result.setTotalNumberOfDeniedFineDishes(totalNumberOfDeniedFineDishes);
		result.setAverageRetailPriceByCurrencyIngredient(averageRetailPriceByCurrencyIngredient);
		result.setDeviationRetailPriceByCurrencyIngredient(deviationRetailPriceByCurrencyIngredient);
		result.setMinRetailPriceByCurrencyIngredient(minRetailPriceByCurrencyIngredient);
		result.setMaxRetailPriceByCurrencyIngredient(maxRetailPriceByCurrencyIngredient);
		result.setAverageRetailPriceByCurrencyUtensil(averageRetailPriceByCurrencyUtensil);
		result.setDeviationRetailPriceByCurrencyUtensil(deviationRetailPriceByCurrencyUtensil);
		result.setMinRetailPriceByCurrencyUtensil(minRetailPriceByCurrencyUtensil);
		result.setMaxRetailPriceByCurrencyUtensil(maxRetailPriceByCurrencyUtensil);
		result.setAverageBudgetByStatusFineDishes(averageBudgetByStatusFineDishes);
		result.setDeviationBudgetByStatusFineDishes(deviationBudgetByStatusFineDishes);
		result.setMinBudgetByStatusFineDishes(minBudgetByStatusFineDishes);
		result.setMaxBudgetByStatusFineDishes(maxBudgetByStatusFineDishes);

		return result;
	}

	private Map<String, Double> parseQueryStringDouble(final List<String> list){
		final HashMap<String, Double> aux = new HashMap<String, Double>();
		for(int i=0; i<list.size();i++) {
			final String line= list.get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[1]);
			final String key=split[0];
			aux.put(key, value);
		}
		return aux;
	}
	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"totalNumberIngredients", "totalNumberUtensils", // 
			"totalNumberOfProposedFineDishes", "totalNumberOfAcceptedFineDishes", //
			"totalNumberOfDeniedFineDishes", "averageRetailPriceByCurrencyIngredient", // 
			"deviationRetailPriceByCurrencyIngredient", "minRetailPriceByCurrencyIngredient", //
			"maxRetailPriceByCurrencyIngredient", "averageRetailPriceByCurrencyUtensil", // 
			"deviationRetailPriceByCurrencyUtensil", "minRetailPriceByCurrencyUtensil", //
			"maxRetailPriceByCurrencyUtensil", "averageBudgetByStatusFineDishes", // 
			"deviationBudgetByStatusFineDishes", "minBudgetByStatusFineDishes", //
			"maxBudgetByStatusFineDishes");
	}

}
