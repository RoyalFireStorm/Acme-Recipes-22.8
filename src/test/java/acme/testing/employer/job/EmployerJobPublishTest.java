/*
 * EmployerJobPublishTest.java
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

public class EmployerJobPublishTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String reference) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List my jobs");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, reference);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String reference) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List my jobs");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, reference);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkAlertExists(false);

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't provide enough support to implement this test case,
		// HINT+ so it must be performed manually:
		// HINT+ a) publish a job with a role other than "Employer";
		// HINT+ b) publish an published job that was registered by the principal;
		// HINT+ c) publish an published job that wasn't registered by the principal;
		// HINT+ d) publish an unpublished job that wasn't registered by the principal.
	}

	// Ancillary methods ------------------------------------------------------

}
