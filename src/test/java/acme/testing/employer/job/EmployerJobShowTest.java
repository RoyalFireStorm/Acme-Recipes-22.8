/*
 * EmployerJobShowTest.java
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

public class EmployerJobShowTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String reference, final String title, final String deadline, final String salary, final String score, final String moreInfo, final String description) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List all jobs");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("reference", reference);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("deadline", deadline);
		super.checkInputBoxHasValue("salary", salary);
		super.checkInputBoxHasValue("score", score);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		super.checkInputBoxHasValue("description", description);

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
		// HINT: the framework doesn't provide enough support to implement this test case,
		// HINT+ so it must be performed manually:
		// HINT+ a) show a job with a role other than "Employer";
		// HINT+ b) show an unpublished job that wasn't registered by the principal;
	}

	// Ancillary methods ------------------------------------------------------

}
