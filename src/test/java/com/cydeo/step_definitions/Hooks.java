package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre-postconditions to each scenario and each step
 */

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

    @Before
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");

    }

    @After
    public void tearDown(){
        System.out.println("====Closing browser using cucumber @After");
        System.out.println("====Scenario ended/take screenshot if failed");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-------------->applying setup using @BeforeStep ");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("---------------->applying tearDown using @AfterStep");

    }
}
