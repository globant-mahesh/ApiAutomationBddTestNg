@test @regressionSuite
Feature: Get book by ISBN
  This feature tests ISBN search API

  Scenario Outline: User calls web service to get a book by its ISBN
  In order to check book details
  As a Librarian
  I want to get the API response

    Given a book exists with an isbn of <sample_data>
    When a user retrieves the book by isbn
    Then the status code is 200
    And response includes the following
      | totalItems | 1             |
      | kind       | books#volumes |
    And response includes the following in any order
      | items.volumeInfo.title     | Steve Jobs         |
      | items.volumeInfo.publisher | Simon and Schuster |
      | items.volumeInfo.pageCount | 630                |
    Examples:
      | sample_data   |
      | 9781451648546 |