$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Selenium_Workspace/Cucumber_BDD/src/main/java/features/testPhase.feature");
formatter.feature({
  "line": 2,
  "name": "This is a demo test for different test Phases of the development",
  "description": "",
  "id": "this-is-a-demo-test-for-different-test-phases-of-the-development",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FuntionalTest"
    }
  ]
});
formatter.scenario({
  "line": 21,
  "name": "sanity Login testing",
  "description": "",
  "id": "this-is-a-demo-test-for-different-test-phases-of-the-development;sanity-login-testing",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "sanity testing User name and password",
  "keyword": "Given "
});
formatter.match({
  "location": "allTestPhase.sanity_testing_User_name_and_password()"
});
formatter.result({
  "duration": 165709466,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Login failure testing",
  "description": "",
  "id": "this-is-a-demo-test-for-different-test-phases-of-the-development;login-failure-testing",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "failed User name and password",
  "keyword": "Given "
});
formatter.match({
  "location": "allTestPhase.failed_User_name_and_password()"
});
formatter.result({
  "duration": 58561,
  "status": "passed"
});
});