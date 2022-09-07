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

package acme.testing.authenticated.systemconfigurator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;


public class AuthenticatedSystemConfiguratorShowTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------

	@Test
	@Order(10)
	public void AuthenticatedSystemConfiguratorShowPositiveTest () {
		super.signIn("epicure01", "epicure01");
		super.navigateHome();
		super.clickOnMenu("Account", "Currency");		
		
		//Check Showing Work Properly
		super.checkFormExists();
		super.checkInputBoxHasValue("acceptedCurrencies", "USD,EUR,GBP");
		super.checkInputBoxHasValue("systemCurrency", "EUR");
		
		super.signOut();
		}
	
	@Test
	@Order(20)
	public void AuthenticatedBulletinListNegativeTest() {
		super.navigate("/authenticated/system-configurator/show");
		super.checkErrorsExist();
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
