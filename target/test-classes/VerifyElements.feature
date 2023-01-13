Feature: Search Widgets
  In order to user connect to internet
  As a user enter a valid url
  User want to verify url will change if he click aleatoire and verify the widgets facebook, twitter et tumblr are exist or no


  Scenario: SearchWidgetsSuccessful

    Given utilisateur accede au site Bouletcorp
    When utilisateur clique sur Aleatoire
    Then utilisateur verifie que la page a change
    And utilisateur verifie que les widgets facebook, twitter et tumblr sont bien affiches