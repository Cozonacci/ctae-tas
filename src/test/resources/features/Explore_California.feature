Feature: Explore California

  As web site visitor
  I want to leave my contact details
  So that I could be notified when new trips are planned

  Scenario: User leaves contact details
    Given 'Mark Donovan' is a new customer
    When he navigates to 'Contact' page
    Then should be able to leave his contact details