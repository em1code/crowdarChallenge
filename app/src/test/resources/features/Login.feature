@Login

Feature: Login
    
    As a user I want to be able to login into Swag Labs application 

    Background: Successful navigate to login page
        Given I am on the login page
        Then I see the title Swag Labs
    
    Scenario: Successful login with valid user
        When I enter the username standard_user and the password secret_sauce
        And I click the login button
        Then I should see the products page correctly

    Scenario: Invalid login with locked user
        When I enter the username locked_out_user and the password secret_sauce
        And I click the login button
        Then I should see an error message indicating that there has been a problem with the login

    Scenario: Invalid login with problematic user
        When I enter the username problem_user and the password secret_sauce
        And I click the login button
        Then I should see the products page with wrong images

    Scenario: Login with performance glitch user
        When I enter the username performance_glitch_user and the password secret_sauce
        And I click the login button
        Then I should see a delay loading the products page

    Scenario: Login without entering username and password
        When I do not enter any username and password
        And I click the login button
        Then I should see an error message indicating that username and password are required

    Scenario Outline: Login with valid username and invalid password
        When I enter the user '<username>' and password '<password>'
        And I click the login button
        Then I should see an error message indicating that the username/password is not correct

        Examples:
            | username                 | password   |
            | standard_user            | 123        |
            | locked_out_user          | password   |
            | problem_user             | abcde      |
            | performance_glitch_user  | _invalidPW |

    Scenario Outline: Login with invalid username and valid password
        When I enter the user '<username>' and password '<password>'
        And I click the login button
        Then I should see an error message indicating that the username/password is not correct

        Examples:
            | username                 | secret_sauce |
            | random1234556            | secret_sauce |
            | emiliano                 | secret_sauce |
            | crowdar                  | secret_sauce |
            | admin123                 | secret_sauce |

    # Scenario: Valid fields values
    #     Given I enter an string values in Username and Password fields
    #     And I enter an numeric values in Username and Password fields
    #     And I enter an special character in Username and Password fields
    #     Then All values are valid

    # Scenario: Successful logout
    #     Given I am loged in the Product Page
    #     And I click the Menu button
    #     And I click the Logout button
    #     Then I should be loged out and Login Page is displayed