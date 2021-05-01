# Specification Search Breweries
This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gradle gauge
	or click green triangle at the tes case

This is the first scenario in this specification

Here's a step that takes a table

## Check status codes with right/wrong path URL
* Sent request for getting breweries

   |URL                       |status|
   |--------------------------|------|
   |breweries/search?query=dog|200   |
   |                          |200   |
   |wrong/search?query=dog    |404   |

## Check first brewery name in response
* First name of breweries search result is "Big Dog's Brewing Co"
* Response code should be "200"

## Check last brewery name in response
* Last name of breweries search result is "Grande Mere Inn / Cranberry Bog Bar"
* Response code should be "200"

## Check first ten breweries name
* Extract 10 breweries name

   |NAME                |
   |--------------------|
   |Big Dog's Brewing Co|
   |Barrel Dog Brewing  |
   |Boss Dog Brewing    |
   |Diving Dog Brewhouse|
   |Dog Days Brewing    |
   |Dog Money Restaurant|
   |Dog Tag Brewing     |
   |Flying Dog Brewery  |
   |Laughing Dog Brewing|
   |Lead Dog Brewing    |

## Check headers of Content-Type
* Extract headers of "Content-Type" is equal to "application/json; charset=utf-8"
* Response code should be "200"

## Check max and min value of created_at
* Check that max value "created_at" is "2020-10-11T00:00:00.000Z"
* Check that min value "created_at" is "2018-07-24T00:00:00.000Z"

## Check search result with parameters and find name with id
* Extract response "brewery_type" with "micro" and "state" with "Arizona"
* Name "Sleepy Dog Brewing Co" with id "14369" from response of search result