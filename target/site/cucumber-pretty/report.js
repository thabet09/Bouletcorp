$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/VerifyElements.feature");
formatter.feature({
  "name": "Search Widgets",
  "description": "  In order to user connect to internet\n  As a user enter a valid url\n  User want to verify url will change if he click aleatoire and verify the widgets facebook, twitter et tumblr are exist or no",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "SearchWidgetsSuccessful",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "utilisateur accede au site Bouletcorp",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.MyStepdefs.utilisateur_accede_au_site_Bouletcorp() in file:/C:/thabet/WorkspaceIntellij/Bouletcorp/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "utilisateur clique sur Aleatoire",
  "keyword": "When "
});
formatter.match({
  "location": "steps.MyStepdefs.utilisateur_clique_sur_Aleatoire() in file:/C:/thabet/WorkspaceIntellij/Bouletcorp/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "utilisateur verifie que la page a change",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.MyStepdefs.utilisateur_verifie_que_la_page_a_change() in file:/C:/thabet/WorkspaceIntellij/Bouletcorp/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "utilisateur verifie que les widgets facebook, twitter et tumblr sont bien affiches",
  "keyword": "And "
});
formatter.match({
  "location": "steps.MyStepdefs.utilisateur_verifie_que_les_widgets_facebook_twitter_et_tumblr_sont_bien_affiches() in file:/C:/thabet/WorkspaceIntellij/Bouletcorp/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});