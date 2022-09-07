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

package acme.testing.chef.recipe;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyRecipeListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/recipe/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyRecipeListPositiveTest (final int recordIndex, final String code, final String heading, final String description, final String notes, final String link, final String ingredient, final String utensil) {
		super.navigateHome();
		super.clickOnMenu("Products","Recipe list");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, heading);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, notes);
		super.checkColumnHasValue(recordIndex, 4, link);
		super.checkColumnHasValue(recordIndex, 5, ingredient);
		super.checkColumnHasValue(recordIndex, 6, utensil);
		
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
