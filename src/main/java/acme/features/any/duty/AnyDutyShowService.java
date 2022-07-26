/*
 * AnyDutyShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyDutyShowService implements AbstractShowService<Any, Duty> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyDutyRepository repository;

	// AbstractShowService<Employer, Duty> interface ---------------------------


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		return true;
	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneDutyById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "workLoad", "moreInfo");
	}

}
