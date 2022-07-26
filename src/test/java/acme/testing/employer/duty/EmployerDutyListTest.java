/*
 * EmployerDutyListTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.employer.duty;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class EmployerDutyListTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/duty/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int jobRecordIndex, final String reference, final int dutyRecordIndex, final String title, final String workLoad) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "List my jobs");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(jobRecordIndex, 0, reference);
		super.clickOnListingRecord(jobRecordIndex);
		super.checkInputBoxHasValue("reference", reference);
		super.clickOnButton("Duties");

		super.checkListingExists();
		super.checkColumnHasValue(dutyRecordIndex, 0, title);
		super.checkColumnHasValue(dutyRecordIndex, 1, workLoad);
		super.clickOnListingRecord(dutyRecordIndex);
	
		super.signOut();
	}

	@Test
	@Order(20)
	public void negativeTest() {
		// HINT: there's no negative test case for this listing, since it doesn't
		// HINT+ involve filling in any forms.
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't currently provide enough support to hack
		// HINT+ this feature, so the remaining hacking tests must be performed manually.
		// HINT+ a) list the duties of a job that is unpublished;
		// HINT+ b) list the duties of a job that is published, but not available.
	}

	// Ancillary methods ------------------------------------------------------

}
