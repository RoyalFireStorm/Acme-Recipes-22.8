/*
 * FavouriteemailTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.any.peep;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyPeepListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/peep/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyPeepListPositiveTest (final int recordIndex, final String moment, final String heading, final String writer, final String text, final String email) {
		super.navigateHome();
		super.clickOnMenu("Peep list");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, heading);
		super.checkColumnHasValue(recordIndex, 2, writer);
		super.checkColumnHasValue(recordIndex, 3, text);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
