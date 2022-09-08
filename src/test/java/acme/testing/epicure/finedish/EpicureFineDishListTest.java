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


public class EpicureFineDishListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/epicure/finedish/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void EpicureUtensilListPositiveTest (final int recordIndex, final String status, final String code, final String request, final String budget, final String startDate,
			final String endDate, final String username, final String recipe, final String link) {
		super.signIn("epicure01", "epicure01");
		super.navigateHome();
		super.clickOnMenu("Epicure", "Your fine dishes");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, request);
		super.checkColumnHasValue(recordIndex, 3, budget);
		super.checkColumnHasValue(recordIndex, 4, startDate);
		super.checkColumnHasValue(recordIndex, 5, endDate);
		super.checkColumnHasValue(recordIndex, 6, username);
		super.checkColumnHasValue(recordIndex, 7, recipe);
		super.checkColumnHasValue(recordIndex, 8, link);
		
		super.signOut();
		
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
