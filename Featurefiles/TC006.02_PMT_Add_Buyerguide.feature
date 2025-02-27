@sanity
Feature: PMT parts buyers guide
Description: User will add application for a part# through buyersguide

@Philips5001
Scenario: Adding application through buyers guide
Given User will go to parts page and search for a part# and will tie-up the application
When User will click on buyersguide frame and choose the vehicle, make, model & search
And User will choose an enginebase and click on save
Then User will see successfull alert and verify the reocrd has shown in the below grid

@Philips
Scenario: Parts search
Given After login Click My catalog and select Buyer guide sub menu
When Enter partnumber and select part number within Autocomplete
And Click search
#Then Click parts data

@Philips
Scenario: Edit Application through buyers guide
Given User will go to parts page and search for a part# will edit notes
When User will click on buyers guide frame, show grid will be seen along with application & edit an application
And User will enter notes in notes textbox and click on save
Then User will see succesfull alert and verify the notes added 

@Philips
Scenario: Delete Application through buyers guide
Given User will go to parts page and search for a part# to delete the application
When User will click on buyers guide frame, choose the application and click on delete 
Then User will see succesfull alert and verify the application is deleted from the show grid 