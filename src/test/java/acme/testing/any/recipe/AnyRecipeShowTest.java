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

package acme.testing.any.recipe;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyRecipeShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/recipe/showpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyRecipeShowPositiveTest (final int recordIndex, final String code, final String heading, final String description, final String notes, final String link, final String ingredientQ,final String ingredientN, final String utensil) {
		super.navigateHome();
		super.clickOnMenu("Products","Recipe list");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("heading", heading);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("notes", notes);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("quantityIngredient", ingredientQ);
		super.checkInputBoxHasValue("quantityIngredient.ingredient.name", ingredientN);
		//super.checkInputBoxHasValue("mapUtensil", utensil);
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
