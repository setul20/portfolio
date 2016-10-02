package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


// Define a sub-window by inheritance

class Win extends Window {
	
	
	
	private TextField username = new TextField("Username");
	private TextField password = new TextField("Password");
	private String usernametf;
	private String passwordtf;
	private long loginID;
	private List<Login> login;
	
	
	
	
    public Win(List<Login> login, SQLui u) {
    	
        super("Login"); // Set window caption
        
        this.login = login;
        final Button logClose = new Button("Login", e -> closeWindow(this.login, u));
        final Button tryAgain = new Button("Try Again", e -> reset(u));
        center();
        username.setVisible(true);
        password.setVisible(true);
        // Some basic content for the window
        VerticalLayout content = new VerticalLayout(username,password,logClose);
        //content.addComponent(new Label("Login"));
        //content.addComponent(logClose);
        content.setMargin(true);
        setContent(content);

        // Disable the close button
        setClosable(false);

        username.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				usernametf = (String) event.getProperty().getValue();
				
			}
		});
        
        password.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				passwordtf = (String) event.getProperty().getValue();
				
			}
		});
        
       
        
    }
    
    public void setloginID(SQLui u){
    	u.setCID(this.loginID);
    }
    
    
    


	public void closeWindow(List<Login> login , SQLui u) {
//    	Collections.sort(login, (login1, login2) -> login1.getUser().compareTo(login2.getUser()));
//    	int index = Collection.binarySearch(login, usernametf, new LoginComparator());
    	
    	Optional<Login> user = login.stream().filter(usr -> usr.getUser().equals(usernametf)).findAny();
    	
    	
    	if(user.isPresent()){
    		Login temp = user.get();
    		
    		if(temp.getPassword().equals(passwordtf)){
    			this.loginID=temp.getLoginID();
    			//System.out.println(this.loginID);
    			this.setModal(false);
    			this.setVisible(false);
    			this.setloginID(u);
    			
    		}
    		else{
        		TextField wrong = new TextField("Wrong Username or Password");
        		Button tryAgain = new Button("Try Again", e -> reset(u));
        		VerticalLayout again = new VerticalLayout(wrong, tryAgain);
        		again.setMargin(true);
        		setContent(again);
        	}
    		
    		
    	}
    	else{
    		TextField wrong = new TextField("Wrong Username or Password");
    		Button tryAgain = new Button("Try Again", e -> reset(u));
    		VerticalLayout again = new VerticalLayout(wrong, tryAgain);
    		again.setMargin(true);
    		setContent(again);
    		
    	}
		
    	
    	 // Close the sub-window
    }
	
	private void reset(SQLui u) {
		username.setVisible(true);
        password.setVisible(true);
        // Some basic content for the window
        Button logClose = new Button("Login", e -> closeWindow(this.login, u));
        VerticalLayout content = new VerticalLayout(username,password,logClose);
        //content.addComponent(new Label("Login"));
        //content.addComponent(logClose);
        content.setMargin(true);
        setContent(content);

        // Disable the close button
        setClosable(false);

        username.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				usernametf = (String) event.getProperty().getValue();
				
			}
		});
        
        password.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				passwordtf = (String) event.getProperty().getValue();
				
			}
		});
	}
    
}