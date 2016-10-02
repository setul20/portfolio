package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Calendar;

@SpringUI
@Theme("chameleon")
public class SQLui extends UI {

    @Autowired
    private CustomerSQL service;
    
    @Autowired
    private ReviewSQL service2;
    
    @Autowired
    private EquipmentSQL service3;
    
    @Autowired
    private RentalsSQL service4;
    
    @Autowired
    private InventorySQL service5;
    
    @Autowired
	private LoginSQL log;

    private Customer customer;
    private Equipment equipment;
    private Review review;
    private Rentals rentals;
    private Inventory inventory;
    
    private long custID;
    
    ///GRIDS FOR TABLES///
    private Grid customerGrid = new Grid();
    private Grid equipmentGrid = new Grid();
    private Grid rentalGrid = new Grid();
    private Grid inventoryGrid = new Grid();
    private Grid reviewGrid = new Grid();
    
    ///PANELS FOR GRIDS////
    private Panel Customer = new Panel("Customer");
    private Panel Equipment = new Panel("Equipment");
    private Panel Rental = new Panel("Rental");
    private Panel Inventory = new Panel("Inventory");
    private Panel Review = new Panel("Review");
    
    
    ////TEXT FIELDS FOR FORMS////
   
    
    private TextField dueDate = new TextField("Due Date");
    private TextField outDate = new TextField("Out Date");
    private TextField inDate = new TextField("In Date");
    
    
    
    
    
    /////COOKIE////////
    //Cookie cook = 
    
    
    //private TextField form5 = new TextField();
    //private TextField equipmentForm1 = new TextField("Rental Cost");
    
    
    ////Field Groups////
    //private FieldGroup fieldGroup;
    
    /////BUTTONS/////
    private Button save = new Button("Rent", e -> addRental());
    //private Button add = new Button("Add Customer", e -> insertCustomer());
    
    ExternalResource image = new ExternalResource("https://lh3.googleusercontent.com/-iFU9YNFAEto/V5qmMfr4f9I/AAAAAAAAGKA/dlDkUx3uh70U_Q9aXyBIW2n1Q1TorPVkACCo/s128/InterstellarPaper_FEAT-970x545.png"+ Calendar.getInstance().getTime().getTime());
    //Embedded image2 = new Embedded("1", image);
    Image image3 = new Image(null, image);
    
    
    String date1;
    String date2;
    String date3;
    
    
    
    
    ///////////INIT//////////////////////
    @Override
    protected void init(VaadinRequest request) {
    	//Win loginWindow = new Win(log.findAll(), (SQLui) this.getCurrent());
    	//loginWindow.setModal(true);
    	//this.getCurrent().addWindow(loginWindow);
    	
    	
    	
    	System.out.println(custID);
    	
    	
    	//System.out.println(this.custID);
    	
    	updateGrid();
    	
    	FormLayout form = new FormLayout();
    	form.addComponent(outDate);
    	form.addComponent(inDate);
    	form.addComponent(dueDate);
    	
    	
    	
        customerGrid.setColumns("firstName", "lastName", "email", "phone");
        customerGrid.addSelectionListener(e -> updateCustomerForm());
        
        equipmentGrid.setColumns("type", "rentalCost", "replacementFee");
        equipmentGrid.addSelectionListener(e -> updateEquipmentForm());
        
        rentalGrid.setColumns("outDate", "inDate", "dueDate", "itemID", "custID");
        rentalGrid.addSelectionListener(e -> updateRentalForm());

        inventoryGrid.setColumns("stockStatus", "itemLocation", "type");
        inventoryGrid.addSelectionListener(e -> updateInventoryForm());
        
        reviewGrid.setColumns("type", "reviewBody", "rating");
        reviewGrid.addSelectionListener(e -> updateReviewForm());
        

        VerticalLayout layout1 = new VerticalLayout(Customer, customerGrid);
        layout1.setMargin(true);
        layout1.setSpacing(true);
        VerticalLayout layout2 = new VerticalLayout(Equipment, equipmentGrid);
        layout2.setMargin(true);
        layout2.setSpacing(true);
        VerticalLayout layout3 = new VerticalLayout(Rental, rentalGrid, Review, reviewGrid);
        layout3.setMargin(true);
        layout3.setSpacing(true);
        VerticalLayout layout4 = new VerticalLayout(Inventory, inventoryGrid);
        layout4.setMargin(true);
        layout4.setSpacing(true);
        
        HorizontalLayout hLayout1 = new HorizontalLayout(layout1, layout2);
        HorizontalLayout hLayout2 = new HorizontalLayout(layout3, layout4);
        save.setVisible(true);
        HorizontalLayout horizlayout = new HorizontalLayout(image3, outDate, inDate, dueDate, save);
        horizlayout.setMargin(true);
        horizlayout.setSpacing(true);
        VerticalLayout BigVert = new VerticalLayout(hLayout1, hLayout2, horizlayout);
        // layout = new VerticalLayout(Customer, customerGrid, Equipment, equipmentGrid, Rental, rentalGrid, Inventory, inventoryGrid, Review, reviewGrid);
        
        
        
        BigVert.setMargin(true);
        BigVert.setSpacing(true);
        setContent(BigVert);
        
        
       
        
    }
    
    private void addRental() {
    	service4.insert(rentals);
        updateGrid();
	}

	

	public void setCID(long i){
    	this.custID = i;
    }

	private void updateGrid() {
        List<Customer> customers = service.findAll();
        List<Review> reviews = service2.findAll();
        List<Equipment> equipment = service3.findAll();
        List<Rentals> rentals = service4.findAll();
        List<Inventory> inventory = service5.findAll();
        
        
        reviewGrid.setContainerDataSource(new BeanItemContainer<>(Review.class,
                reviews));
        customerGrid.setContainerDataSource(new BeanItemContainer<>(Customer.class,
                customers));
        equipmentGrid.setContainerDataSource(new BeanItemContainer<>(Equipment.class,
                equipment));
        rentalGrid.setContainerDataSource(new BeanItemContainer<>(Rentals.class,
                rentals));
        inventoryGrid.setContainerDataSource(new BeanItemContainer<>(Inventory.class,
                inventory));
        setCustomerFormVisible(false);
    }
	
	
	
	////FOR FILLING INVENTORY WITH ONLY WHAT IS SELECTED IN EQUIP///////////////////////
	private void updateInventoryGrid(String inv){
		List<Inventory> inventory = service5.select(inv);
		inventoryGrid.setContainerDataSource(new BeanItemContainer<>(Inventory.class,
                inventory));
	}
	
	private void updateReviewGrid(String type){
		List<Review> reviews = service2.select(type);
		reviewGrid.setContainerDataSource(new BeanItemContainer<>(Review.class,
                reviews));
	}
	
	
	
	
	
	//////METHODS FOR UPDATING RESPECTIVE FORMS//////////////////////////////
    private void updateCustomerForm() {
        if (customerGrid.getSelectedRows().isEmpty()) {
            setCustomerFormVisible(false);
        } else {
            customer = (Customer) customerGrid.getSelectedRow();
            //BeanFieldGroup.bindFieldsUnbuffered(customer, this);
            setCustomerFormVisible(true);
            updateRentalsGrid(customer.getcID());
        }
    }
    
    private void updateRentalsGrid(long cID) {
    	List<Rentals> rentals = service4.select(cID);
		rentalGrid.setContainerDataSource(new BeanItemContainer<>(Rentals.class,
                rentals));
	}

	private void updateEquipmentForm() {
		if (equipmentGrid.getSelectedRows().isEmpty()) {
            //setEquipmentFormVisible(false);
        } else {
            equipment = (Equipment) equipmentGrid.getSelectedRow();
            BeanFieldGroup.bindFieldsUnbuffered(equipment, this);
            //setEquipmentFormVisible(true);
            updateInventoryGrid(equipment.getType());
        }
	}
    
    private void updateInventoryForm(){
    	if (inventoryGrid.getSelectedRows().isEmpty()) {
            setInventoryFormVisible(false);
        } else {
            inventory = (Inventory) inventoryGrid.getSelectedRow();
            
            BeanFieldGroup.bindFieldsUnbuffered(inventory, this);
            //setEquipmentFormVisible(true);
            updateReviewGrid(inventory.gettype());
        }
    }
    
    private void setInventoryFormVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	
	private void updateReviewForm(){
		if (reviewGrid.getSelectedRows().isEmpty()) {
            //setReviewFormVisible(false);
        } else {
            review = (Review) reviewGrid.getSelectedRow();
            BeanFieldGroup.bindFieldsUnbuffered(review, this);
            //setReviewFormVisible(true);
            
        }
	}
	
	private void updateRentalForm() {
        if (rentalGrid.getSelectedRows().isEmpty()) {
        	//setCustomerFormVisible(false);
        }
        else {
          rentals = (Rentals) rentalGrid.getSelectedRow();
           //System.out.println(customer.getLastName());
            BeanFieldGroup.bindFieldsUnbuffered(rentals, this);
            //setRentalsFormVisible(true);
        }
    }
	
	
	
//	private Object updateInventoryForm() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
	/////VISIBILITY METHODS////////
    private void setCustomerFormVisible(boolean visible) {
        
//    	firstName.setVisible(visible);
//    	lastName.setVisible(visible);
//        email.setVisible(visible);        
//        phone.setVisible(visible);
//        save.setVisible(visible);
        //image3.setVisible(visible);
    }
    
//    private void setEquipmentFormVisible(boolean visible) {
//		//clearForms();
//		//rentalCost.setVisible(visible);
//		//replacementFee.setVisible(visible);
//	
//	}
    
//    private void setReviewFormVisible(boolean visible) {
//		//clearForms();
////		type.setVisible(visible);
////		reviewBody.setVisible(visible);
////		rating.setVisible(visible);
////		save.setVisible(visible);
//		//rentalCost.setVisible(visible);
//		//replacementFee.setVisible(visible);
//	
//	}
	
//	private void clearForms(){
//		
//    	
//	}
    
//    private void setRentalsFormVisible(boolean visible) {
//        
//        
//    }
    
    
    
    /////SAVING AND ADDING
    private void saveCustomer() {
        service.update(customer);
        updateGrid();
    }
    
    private void insertCustomer(){
    	service.insert(customer);
    	updateGrid();
    }

}