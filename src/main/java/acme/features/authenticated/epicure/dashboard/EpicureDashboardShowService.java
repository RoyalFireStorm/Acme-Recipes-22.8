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

package acme.features.authenticated.epicure.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.forms.EpicureDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Epicure;

@Service
public class EpicureDashboardShowService implements AbstractShowService<Epicure, EpicureDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EpicureDashboardRepository repository;

	// AbstractShowService<Epicure, EpicureDashboard> interface ----------------


	@Override
	public boolean authorise(final Request<EpicureDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public EpicureDashboard findOne(final Request<EpicureDashboard> request) {
		assert request != null;

		final EpicureDashboard result;
		final Integer totalNumberOfProposedFineDishes;
		final Integer totalNumberOfAcceptedFineDishes;
		final Integer totalNumberOfDeniedFineDishes;
		final Map<Pair<String,String>, Double> averageBudgetByCurrencyAndStatus;
		final Map<Pair<String,String>, Double> deviationBudgetByCurrencyAndStatus;
		final Map<Pair<String,String>, Double> minBudgetByCurrencyAndStatus;
		final Map<Pair<String,String>, Double> maxBudgetByCurrencyAndStatus;

		totalNumberOfProposedFineDishes = this.repository.numberOfProposedFineDishesByStatus();
		totalNumberOfAcceptedFineDishes = this.repository.numberOfAcceptedFineDishesByStatus();
		totalNumberOfDeniedFineDishes = this.repository.numberOfDeniedFineDishesByStatus();
		averageBudgetByCurrencyAndStatus = new HashMap<Pair<String, String>, Double>();
		deviationBudgetByCurrencyAndStatus = new HashMap<Pair<String, String>, Double>();
		minBudgetByCurrencyAndStatus = new HashMap<Pair<String, String>, Double>();
		maxBudgetByCurrencyAndStatus = new HashMap<Pair<String, String>, Double>();

		result = new EpicureDashboard();
		result.setTotalNumberOfProposedFineDishes(totalNumberOfProposedFineDishes);
		result.setTotalNumberOfAcceptedFineDishes(totalNumberOfAcceptedFineDishes);
		result.setTotalNumberOfDeniedFineDishes(totalNumberOfDeniedFineDishes);
		
		for(int i=0; i<this.repository.averageBudgetByCurrencyAndStatus().size();i++) {
			final String line= this.repository.averageBudgetByCurrencyAndStatus().get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[0]);
			final String currency=split[1];
			final String status= split[2];
			final Pair<String, String> key=Pair.of(currency, status);
			averageBudgetByCurrencyAndStatus.put(key, value);
		}
		for(int i=0; i<this.repository.deviationBudgetByCurrencyAndStatus().size();i++) {
			final String line= this.repository.deviationBudgetByCurrencyAndStatus().get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[0]);
			final String currency=split[1];
			final String status= split[2];
			final Pair<String, String> key=Pair.of(currency, status);
			deviationBudgetByCurrencyAndStatus.put(key, value);
		}
		for(int i=0; i<this.repository.minBudgetByCurrencyAndStatus().size();i++) {
			final String line= this.repository.minBudgetByCurrencyAndStatus().get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[0]);
			final String currency=split[1];
			final String status= split[2];
			final Pair<String, String> key=Pair.of(currency, status);
			minBudgetByCurrencyAndStatus.put(key, value);
		}
		for(int i=0; i<this.repository.maxBudgetByCurrencyAndStatus().size();i++) {
			final String line= this.repository.maxBudgetByCurrencyAndStatus().get(i);
			final String[] split=line.split(",");
			final Double value=Double.parseDouble(split[0]);
			final String currency=split[1];
			final String status= split[2];
			final Pair<String, String> key=Pair.of(currency, status);
			maxBudgetByCurrencyAndStatus.put(key, value);
		}
		
		result.setAverageBudgetByCurrencyAndStatus(averageBudgetByCurrencyAndStatus);
		result.setDeviationBudgetByCurrencyAndStatus(deviationBudgetByCurrencyAndStatus);
		result.setMinBudgetByCurrencyAndStatus(minBudgetByCurrencyAndStatus);
		result.setMaxBudgetByCurrencyAndStatus(maxBudgetByCurrencyAndStatus);

		return result;
	}

	@Override
	public void unbind(final Request<EpicureDashboard> request, final EpicureDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"totalNumberOfProposedFineDishes", "totalNumberOfAcceptedFineDishes", // 
			"totalNumberOfDeniedFineDishes", "averageBudgetByCurrencyAndStatus", //
			"deviationBudgetByCurrencyAndStatus", "minBudgetByCurrencyAndStatus", "maxBudgetByCurrencyAndStatus");
	}

}
