/*
 * EmployerJobListMineTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.employer.job;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class EmployerJobListAllTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/list-all-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String reference, final String title, final String deadline) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List all jobs");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, reference);
		super.checkColumnHasValue(recordIndex, 1, deadline);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.signOut();
	}

	@Test
	@Order(20)
	public void negativeTest() {
		// HINT: there aren't any negative tests for this feature because it's a listing
		// HINT+ that doesn't involve entering any data in any forms.
	}

	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/employer/job/list-all");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/employer/job/list-all");
		super.checkPanicExists();
		super.signOut();

		super.signIn("worker1", "worker1");
		super.navigate("/employer/job/list-all");
		super.checkPanicExists();
		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
