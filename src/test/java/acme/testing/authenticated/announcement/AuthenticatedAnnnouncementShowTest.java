/*
 * AuthenticatedAnnnouncementShowTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TemporalAwareTestHarness;

public class AuthenticatedAnnnouncementShowTest extends TemporalAwareTestHarness {

	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String status, final String text, final String moreInfo) {
		super.signIn("employer1", "employer1");
		
		super.clickOnMenu("Authenticated", "List announcements");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("text", text);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		
		super.signOut();
	}

	@Test
	public void negativeTest() {
		// HINT: there aren't any negative tests for this feature because it doesn't involve any forms.
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't currently provide enough support to hack
		// HINT+ this feature, so the hacking tests must be performed manually.
		// HINT+ a) show an announcement as an anonymous principal;
		// HINT+ b) show an old announcement as an authenticated principal.
	}

	// Ancillary methods ------------------------------------------------------

}
