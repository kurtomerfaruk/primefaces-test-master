package org.primefaces.test;

import java.util.Random;

/**
 * @author Omer Faruk KURT kurtomerfaruk@gmail.com
 * @version 1.0.0
 * @since 2.11.2024 12:45
 */
public enum CustomerStatus {
    QUALIFIED,
    UNQUALIFIED,
    NEGOTIATION,
    NEW,
    RENEWAL,
    PROPOSAL;

    public static CustomerStatus random() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
