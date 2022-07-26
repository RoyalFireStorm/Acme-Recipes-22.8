/*
 * EmployerDutyCreateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Employer;

@Service
public class EmployerDutyCreateService implements AbstractCreateService<Employer, Duty> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EmployerDutyRepository repository;

	// AbstractCreateService<Employer, Duty> interface -------------------------


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		boolean result;
		int masterId;
		Job job;

		masterId = request.getModel().getInteger("masterId");
		job = this.repository.findOneJobById(masterId);
		result = (job != null && job.isDraftMode() && request.isPrincipal(job.getEmployer()));

		return result;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "description", "workLoad");
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "workLoad");
		model.setAttribute("masterId", entity.getJob().getId());
		model.setAttribute("draftMode", entity.getJob().isDraftMode());
	}

	@Override
	public Duty instantiate(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int masterId;
		Job job;

		masterId = request.getModel().getInteger("masterId");
		job = this.repository.findOneJobById(masterId);

		result = new Duty();
		result.setTitle("");
		result.setDescription("");
		result.setWorkLoad(0.00);
		result.setJob(job);

		return result;
	}

	@Override
	public void create(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
