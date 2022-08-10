/*
 * WorkerDutyListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Worker;

@Service
public class WorkerDutyListService implements AbstractListService<Worker, Duty> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected WorkerDutyRepository repository;

	// AbstractListService<Employer, Duty> interface ---------------------------


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		boolean result;
		int masterId;
		Job job;

		masterId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(masterId);
		result = !job.isDraftMode();

		return result;
	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		assert request != null;

		Collection<Duty> result;
		int masterId;

		masterId = request.getModel().getInteger("jobId");
		result = this.repository.findManyDutiesByMasterId(masterId);

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