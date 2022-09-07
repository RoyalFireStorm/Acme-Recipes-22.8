/*
 * FavouritecriticalTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.authenticated.bulletin;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;


public class AuthenticatedBulletinListShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources="/authenticated/bulletin/listpositive.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void AuthenticatedBulletinListShowPositiveTest (final int recordIndex, final String moment, final String heading, final String text, final String email, final String critical) {
		super.signIn("epicure01", "epicure01");
		super.navigateHome();
		super.clickOnMenu("Authenticated", "List bulletin");		
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		//Check Listing Work Properly
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, heading);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, email);
		super.checkColumnHasValue(recordIndex, 4, critical);
		
		//Check Showing Work Properly
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("heading", heading);
		super.checkInputBoxHasValue("text", text);
		super.checkInputBoxHasValue("email", email);
		if(critical=="true") {
			super.checkInputBoxHasValue("critical", "True");
		}else if(critical=="false") {
			super.checkInputBoxHasValue("critical", "False");
		}
		
		super.signOut();
		}
	
	@Test
	@Order(20)
	public void AuthenticatedBulletinListNegativeTest() {
		super.navigate("/authenticated/bulletin/list");
		super.checkErrorsExist();
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
