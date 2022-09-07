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

package acme.testing.chef.ingredient;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyIngredientListShowTTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/ingredient/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyIngredientListShowTPositiveTest (final int recordIndex, final String name, final String code, final String description, final String retailPrice, final String link) {
		super.navigateHome();
		super.clickOnMenu("Products", "Ingredients list");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);
		super.checkColumnHasValue(recordIndex, 4, link);
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("link", link);
		
		
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
