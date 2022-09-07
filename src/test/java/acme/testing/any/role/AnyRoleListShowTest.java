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

package acme.testing.any.role;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AnyRoleListShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/any/roles/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AnyRolePositiveTest (final int recordIndex, final String roles, final String username, final String email) {
		super.navigateHome();
		super.clickOnMenu("User accounts");		
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, roles);
		super.checkColumnHasValue(recordIndex, 1, username);
		super.checkColumnHasValue(recordIndex, 2, email);
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("roles", roles);
		super.checkInputBoxHasValue("username", username);
		super.checkInputBoxHasValue("identity.email", email);
		
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
