/*
 * EmployerJobUpdateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.job;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Employer;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected EmployerJobRepository repository;

	// AbstractUpdateService<Employer, Job> -------------------------------------


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int masterId;
		Job job;
		Employer employer;

		masterId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(masterId);
		employer = job.getEmployer();
		result = job != null && job.isDraftMode() && request.isPrincipal(employer);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Calendar calendar;
			Date minimumDeadline;

			calendar = new GregorianCalendar();
			calendar.add(Calendar.WEEK_OF_MONTH, 1);
			minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "employer.job.form.error.too-close");
		}

		if (!errors.hasErrors("reference")) {
			Job existing;

			existing = this.repository.findOneJobByReference(entity.getReference());
			errors.state(request, existing == null || existing.equals(entity), "reference", "employer.job.form.error.duplicated");
		}
		
		if (!errors.hasErrors("salary")) {
			errors.state(request, entity.getSalary().getAmount() > 0, "salary", "employer.job.form.error.negative-salary");
		}
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "reference", "title", "deadline", "salary");
		request.bind(entity, errors, "score", "moreInfo", "description");
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "salary", "score", "moreInfo", "description", "draftMode");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}