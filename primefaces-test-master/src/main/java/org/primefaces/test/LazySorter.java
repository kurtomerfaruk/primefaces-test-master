package org.primefaces.test;

import org.primefaces.model.SortOrder;

import java.util.Comparator;

/**
 * @author Omer Faruk KURT kurtomerfaruk@gmail.com
 * @version 1.0.0
 * @since 2.11.2024 12:47
 */
public class LazySorter implements Comparator<Customer> {

    private String sortField;
    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Customer customer1, Customer customer2) {
        try {
            Object value1 = ShowcaseUtil.getPropertyValueViaReflection(customer1, sortField);
            Object value2 = ShowcaseUtil.getPropertyValueViaReflection(customer2, sortField);

            int value = ((Comparable) value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
