Feature: Get a random user

  Background:
    * url api.baseUrl
    * def random = function(max){ return Math.floor(Math.random() * max) + 1 }
    * def responseSuccessfulGetUser = read("successful-response-get-user.json")
    * def responseSuccessfulGetPost = read("successful-response-get-post.json")
    * def responseSuccessfulPost = read("successful-response-post.json")
    * def bodyRequest = read("post-body-request.json")


  Scenario: Get a random user and print his email
    Given path 'users/' + 1
    When method get
    Then status 200
    And match $ == responseSuccessfulGetUser
    * print response.email

  Scenario: Get posts from user and verify id
    Given path 'posts'
    And param userId = 1
    When method get
    Then status 200
    And match $ == responseSuccessfulGetPost

    Scenario: Create a new post from the user
      Given path 'posts'
      And request bodyRequest
      When method post
      Then status 201
      And match $ == responseSuccessfulPost

