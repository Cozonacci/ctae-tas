## Examples of approaches for automating test cases

### Capture and replay

In capture/playback approaches, tools are used to capture interactions with the SUT 
while performing the sequence of actions as defined by a test procedure/scenario.

[Check out this example](src/test/java/org/testingsol/tas/a_captureplay/ExploreCaliforniaTest.side)

### Linear scripting

Linear scripting approach uses a scripting (programming) language and an interface 
controller (test tool) to describe the actions and interaction elements to navigate
the user through a sequence of steps. This approach  (usually) does not follow any 
abstraction concepts or reuse patterns - that is why this approach is not recommended
when a large suite of scripts is to be developed (high maintenance cost).

[Check out this example](src/test/java/org/testingsol/tas/b_linear/ExploreCaliforniaTest.java)

### Structure scripting

Compared to linear scripting in structured scripting technique we see some levels of 
reuse and abstraction. These elements get usually transposed into a script library. 
The library contains reusable scripts that perform sequences of instructions that 
are commonly required across a number of tests (interaction and data processing related).

[Check out this example](src/test/java/org/testingsol/tas/c_structured/ExploreCaliforniaTest.java)

### Data-driven testing

The data-driven scripting technique builds on the structured scripting technique. The 
most significant difference is how the test inputs are handled. The inputs are extracted 
from the scripts and put into one or more separate files (typically called _data files_). 

This means the main test script (control script) can be reused to implement a number of 
tests (rather than just a single test). The control script contains the sequence of 
instructions necessary to perform the tests but the input data from a data file.

[Check out this example](src/test/java/org/testingsol/tas/d_datadriven/ExploreCaliforniaTest.java)

### Keyword-driven testing

Keyword-driven testing is a technique to automate test cases that builds on the following 
principles:
- the interactions with the system under test are similar in nature but with different data sets
- test controller implements logic for all possible interactions with the system under test
which could be technical (e.g. click, type) and business in nature (e.g. place order)
- test analyst defined test scripts using _action words_ and _test data_ and serve them to 
test controller for execution.

[Check out this example - control script](src/test/java/org/testingsol/tas/e_keyworddriven/ExploreCaliforniaTest.java)
<br>[Check out this example - test script](src/test/java/org/testingsol/tas/e_keyworddriven/ExploreCalifornia.json)

### Process-driven scripting

The process-driven approach builds on the keyword-driven scripting technique with the difference 
that scenarios – representing uses cases of the SUT and variants thereof – constitute the scripts 
which are parameterized with test data or combined into higher-level test definitions

An example of such scenario is given bellow:

    Feature: Explore California
    
      As a web site visitor
      I want to leave my contact details
      So that I could be notified when new trips are planned
    
      Scenario: User leaves contact details
        Given 'Mark Donovan' is a new customer
        When he navigates to 'Contact' page
        Then should be able to leave his contact details

This scenario follows a Gherkin definition style and is steps implementation is done using Cucumber tool