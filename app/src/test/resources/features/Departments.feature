@API

Feature: Test mercadolibre API
    Scenario Outline: As a user I want to verify that Departaments section in Mercadolibre API
        Given I perform GET to the endpoint
        Then I should see the section <response>

    Examples:
        | response     |
        | departments  |