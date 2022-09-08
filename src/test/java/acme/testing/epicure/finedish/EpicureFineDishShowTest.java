/*
 * FavouriteLinkTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.epicure.finedish;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class EpicureFineDishShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/epicure/finedish/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void EpicureFineDishShowPositiveTest (final int recordIndex, final String status, final String code, final String request, final String budget, final String startDate,
		final String endDate, final String username, final String recipe, final String link, final String organisation, final String assertion, final String epicureLink, final String email) {
		super.signIn("epicure01", "epicure01");
		super.navigateHome();
		super.clickOnMenu("Epicure","Your fine dishes");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("request", request);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("endDate", endDate);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("recipe.heading", recipe);
		super.checkInputBoxHasValue("chef.userAccount.username", username);
		super.checkInputBoxHasValue("chef.organisation", organisation);
		super.checkInputBoxHasValue("chef.assertion", assertion);
		super.checkInputBoxHasValue("chef.link", epicureLink);
		super.checkInputBoxHasValue("chef.userAccount.identity.email", email);
		
		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
