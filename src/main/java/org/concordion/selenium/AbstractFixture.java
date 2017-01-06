package org.concordion.selenium;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public abstract class AbstractFixture {

    public AbstractFixture(){
        System.setProperty("concordion.output.dir", "target/concordion");
    }

}
