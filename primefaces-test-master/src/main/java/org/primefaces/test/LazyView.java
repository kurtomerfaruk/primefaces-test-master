package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import java.util.List;

/**
 * @author Omer Faruk KURT kurtomerfaruk@gmail.com
 * @version 1.0.0
 * @since 2.11.2024 12:43
 */
@Named("dtLazyView")
@ViewScoped
public class LazyView implements java.io.Serializable {

    private LazyDataModel<Customer> lazyModel;

    private Customer selectedCustomer;
    private List<Customer> filtered;

    @Inject
    private CustomerService service;

    @PostConstruct
    public void init() {
        lazyModel = new LazyCustomerDataModel(service.getCustomers(200));
    }

    public LazyDataModel<Customer> getLazyModel() {
        return lazyModel;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<Customer> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<Customer> filtered) {
        this.filtered = filtered;
    }

    public void setService(CustomerService service) {
        this.service = service;
    }

    public void onRowSelect(SelectEvent<Customer> event) {
        FacesMessage msg = new FacesMessage("Customer Selected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	 public void onFilter(AjaxBehaviorEvent event) {
        if(this.getFiltered()!=null){
            System.out.println("size:"+this.getFiltered().size());
        }
    }
}
