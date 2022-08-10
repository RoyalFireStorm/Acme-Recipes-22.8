/*
 * AnyJobListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyJobListService implements AbstractListService<Any, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyJobRepository repository;

	// AbstractListService<Anonymous, Job>  interface -------------------------


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<Job> result;

		result = this.repository.findManyJobsByAvailability();

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		String payload;

		request.unbind(entity, model, "reference", "deadline", "title");

		payload = String.format(//
			"%s; %s; %s", //
			entity.getDescription(), entity.getEmployer().getIdentity().getFullName(), entity.getEmployer().getCompany());
		model.setAttribute("payload", payload);
	}

}