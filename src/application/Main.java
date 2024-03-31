package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	 public static MediaRentalManager mr = new MediaRentalManager();
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			/* main interface */
		
			BorderPane rootmain = new BorderPane();
			
			Button btnCustomer = new Button("Customer");
			Button btnMedia = new Button("Media");
			Button btnRent = new Button("Rent");
			
			btnCustomer.setStyle("-fx-background-color:deepskyblue");
			btnMedia.setStyle("-fx-background-color:deepskyblue");
			btnRent.setStyle("-fx-background-color:deepskyblue"); 
			
			btnCustomer.setPrefHeight(100);
			btnCustomer.setPrefWidth(200);
			btnMedia.setPrefHeight(100);
			btnMedia.setPrefWidth(200);
			btnRent.setPrefHeight(100);
			btnRent.setPrefWidth(200);
			
			btnCustomer.setFont(Font.font(null,FontWeight.BOLD,22));
			btnMedia.setFont(Font.font(null,FontWeight.BOLD,22));
			btnRent.setFont(Font.font(null,FontWeight.BOLD,22));
			
			Image icone1 = new Image("icons8-customer-50.png");
			btnCustomer.setGraphic(new ImageView(icone1));
			Image icone2 = new Image("icons8-media-48.png");
			btnMedia.setGraphic(new ImageView(icone2));
			Image icone3 = new Image("icons8-rent-50.png");
			btnRent.setGraphic(new ImageView(icone3));
			
			
			VBox mainvbox = new VBox();
			mainvbox.setSpacing(25);
			mainvbox.setPadding(new Insets(0,0,0,25));
			mainvbox.getChildren().addAll(btnCustomer,btnMedia,btnRent);
			
			Image icon4 = new Image("media.png");
			ImageView img1 = new ImageView(icon4);
			img1.setFitWidth(300);
			img1.setFitHeight(300);
			
			Label lbl = new Label("Rental Media System");
			lbl.setFont(Font.font(null,FontWeight.BOLD,30));
			lbl.setStyle("-fx-border-color:black");
			
			
			VBox vbox = new VBox(15);
			vbox.getChildren().addAll(img1,lbl);
			vbox.setAlignment(Pos.CENTER);
			
			
			rootmain.setLeft(mainvbox);
			rootmain.setCenter(vbox);
			mainvbox.setAlignment(Pos.CENTER_LEFT);
			rootmain.setStyle("-fx-background-color:wheat");
			
			/* END of main interface */
			
			
			/* customer window page */
			
			BorderPane rootcustomer = new BorderPane();
			
			Text ctxt = new Text("Select one: ");
			ctxt.setFont(Font.font(null,FontWeight.BOLD, 30));
			Button cbtn1 = new Button("Add new Customer");
			cbtn1.setFont(Font.font(25));
			Button cbtn2 = new Button("Delete Customer");
			cbtn2.setFont(Font.font(25));
			Button cbtn3 = new Button("Update Information about Customer");
			cbtn3.setFont(Font.font(25));
			Button cbtn4 = new Button("Search a Customer by id");
			cbtn4.setFont(Font.font(25));
			Button cbtn5 = new Button("Return to main page");
			cbtn5.setFont(Font.font(25));
			
			
			VBox cvbox = new VBox(20);
			cvbox.getChildren().addAll(ctxt,cbtn1,cbtn2,cbtn3,cbtn4,cbtn5);
			cvbox.setAlignment(Pos.CENTER);
			
		    rootcustomer.setStyle("-fx-background-color:skyblue");
			rootcustomer.setCenter(cvbox);
			
			/* END customer window page */
			
			
			/* add customer interface */
			
			BorderPane rootaddc = new BorderPane();
			
            GridPane gpcustomer = new GridPane();
			
            Label lb = new Label("Customer ID: ");
            lb.setFont(Font.font(25));
            Label lb2 = new Label("Customer Name: ");
            lb2.setFont(Font.font(25));
            Label lb3 = new Label("Customer Address: ");
            lb3.setFont(Font.font(25));
            Label lb4 = new Label("Customer Mobile: ");
            lb4.setFont(Font.font(25));
            
            TextField t1 = new TextField();
            t1.setPrefWidth(300);
            t1.setPrefHeight(30);
            TextField t2 = new TextField();
            t2.setPrefWidth(300);
            t2.setPrefHeight(30);
            t2.setDisable(true);
            TextField t3 = new TextField();
            t3.setPrefWidth(300);
            t3.setPrefHeight(30);
            t3.setDisable(true);
            TextField t4 = new TextField();
            t4.setPrefWidth(300);
            t4.setPrefHeight(30);
            t4.setDisable(true);
            
            ComboBox<String> cb = new ComboBox<>();
            cb.getItems().addAll("LIMITED","UNLIMITED");
            Label tc = new Label("Plan:");
            tc.setFont(Font.font(25));
            
			gpcustomer.add(lb, 0, 0);
			gpcustomer.add(t1, 1, 0);
			gpcustomer.add(lb2, 0, 1);
			gpcustomer.add(t2, 1, 1); 
			gpcustomer.add(lb3, 0, 2);
			gpcustomer.add(t3, 1, 2); 
			gpcustomer.add(lb4, 0, 3);
			gpcustomer.add(t4, 1, 3); 
			gpcustomer.add(tc, 0, 4);
			gpcustomer.add(cb, 1, 4);
		
			gpcustomer.setHgap(15);
			gpcustomer.setVgap(30);
			
			gpcustomer.setAlignment(Pos.CENTER_LEFT);
			gpcustomer.setPadding(new Insets(0,0,0,50));
				
		
			Button add = new Button("Add",new ImageView("icons8-add-64.png"));
			Button back = new Button("Back",new ImageView("go-back-icon.png"));
			
			add.setPrefSize(150,100);
			back.setPrefSize(150,100);
			
			HBox hbox = new HBox(70);
			hbox.getChildren().addAll(add,back);
			hbox.setPadding(new Insets(0,0,30,0));
			hbox.setAlignment(Pos.BOTTOM_CENTER);
			
			rootaddc.setLeft(gpcustomer);
			rootaddc.setBottom(hbox);
			rootaddc.setStyle("-fx-background-color:antiquewhite");
			
			t1.setOnKeyTyped(e -> {t2.setDisable(false);});
			t2.setOnKeyTyped(e -> {t3.setDisable(false);});
			t3.setOnKeyTyped(e -> {t4.setDisable(false);});
			
			/* END of add customer interface */
			
			// add customer events 
			add.setOnAction(e -> {
				mr.addCustomer(t1.getText(),t2.getText(),t3.getText(),t4.getText(),cb.getValue());
				writeCustomerFile();
			});
			///////////
			
			/* Delete customer interface */
					
			BorderPane rootdeletec = new BorderPane();
			
            GridPane gpcustomer2 = new GridPane();
			
            Label lb5 = new Label("Customer ID: ");
            lb5.setFont(Font.font(25));
            Label lb6 = new Label("Customer Name: ");
            lb6.setFont(Font.font(25));
            Label lb7 = new Label("Customer Address: ");
            lb7.setFont(Font.font(25));
            Label lb8 = new Label("Customer Mobile: ");
            lb8.setFont(Font.font(25));
            
            TextField t5 = new TextField();
            t5.setPrefWidth(300);
            t5.setPrefHeight(30);
            TextField t6 = new TextField();
            t6.setPrefWidth(300);
            t6.setPrefHeight(30);
            TextField t7 = new TextField();
            t7.setPrefWidth(300);
            t7.setPrefHeight(30);
            TextField t8 = new TextField();
            t8.setPrefWidth(300);
            t8.setPrefHeight(30);
            
			gpcustomer2.add(lb5, 0, 0);
			gpcustomer2.add(t5, 1, 0);
			gpcustomer2.add(lb6, 0, 1);
			gpcustomer2.add(t6, 1, 1); 
			gpcustomer2.add(lb7, 0, 2);
			gpcustomer2.add(t7, 1, 2); 
			gpcustomer2.add(lb8, 0, 3);
			gpcustomer2.add(t8, 1, 3); 
			
		
			gpcustomer2.setHgap(15);
			gpcustomer2.setVgap(30);
			
			gpcustomer2.setAlignment(Pos.CENTER_LEFT);
			gpcustomer2.setPadding(new Insets(0,0,0,50)); 
				
		
			Button find = new Button("Find");
			Button Delete = new Button("Delete");
			Button back2 = new Button("Back");
			Image icone7 = new Image("icons8-find-64.png");
			find.setGraphic(new ImageView(icone7));
			Image icone8 = new Image("icons8-delete-64.png");
			Delete.setGraphic(new ImageView(icone8));
			Image icone9 = new Image("go-back-icon.png");
			back2.setGraphic(new ImageView(icone9));
			
			find.setPrefSize(150,100);
			Delete.setPrefSize(150,100);
			back2.setPrefSize(150,100);
			
			HBox hbox2 = new HBox(70);
			hbox2.getChildren().addAll(find,Delete,back2);
			hbox2.setPadding(new Insets(0,0,30,0));
			hbox2.setAlignment(Pos.BOTTOM_CENTER);
			
			rootdeletec.setLeft(gpcustomer2);
			rootdeletec.setBottom(hbox2);
			rootdeletec.setStyle("-fx-background-color:	antiquewhite");
				
			/* END of Delete customer interface */
			
			// delete customer events
			find.setOnAction(e -> {
				findCustomer(t5,t6,t7,t8);
			});
			Delete.setOnAction(e -> {
				for(int i=0; i<mr.customers.size(); i++) {
					if((mr.customers.get(i).getId()).equals(t5.getText())) {
						mr.customers.get(i).getCart().clear();
						mr.customers.get(i).getRented().clear();
						mr.customers.remove(i);
					}
				}
						
				writeCustomerFile();
				writeRequestedFile();
				writeRentedFile();
			}); 
			
				
			/* Search a Customer by id */ 
			
			BorderPane rootsearchc = new BorderPane();
			
            GridPane gpcustomer4 = new GridPane();
			
            Label lb13 = new Label("Customer ID: ");
            lb13.setFont(Font.font(25));
            Label lb14 = new Label("Customer Name: ");
            lb14.setFont(Font.font(25));
            Label lb15 = new Label("Customer Address: ");
            lb15.setFont(Font.font(25));
            Label lb16 = new Label("Customer Mobile: ");
            lb16.setFont(Font.font(25));
            
            TextField t13 = new TextField();
            t13.setPrefWidth(300);
            t13.setPrefHeight(30);
            TextField t14 = new TextField();
            t14.setPrefWidth(300);
            t14.setPrefHeight(30);
            TextField t15 = new TextField();
            t15.setPrefWidth(300);
            t15.setPrefHeight(30);
            TextField t16 = new TextField();
            t16.setPrefWidth(300);
            t16.setPrefHeight(30);
            
			gpcustomer4.add(lb13, 0, 0);
			gpcustomer4.add(t13, 1, 0);
			gpcustomer4.add(lb14, 0, 1);
			gpcustomer4.add(t14, 1, 1); 
			gpcustomer4.add(lb15, 0, 2);
			gpcustomer4.add(t15, 1, 2); 
			gpcustomer4.add(lb16, 0, 3);
			gpcustomer4.add(t16, 1, 3); 
			
		
			gpcustomer4.setHgap(15);
			gpcustomer4.setVgap(30);
			
			gpcustomer4.setAlignment(Pos.CENTER_LEFT);
			gpcustomer4.setPadding(new Insets(0,0,0,50)); 
			
			Button search = new Button("Search",new ImageView("icons8-search-64.png"));
			Button back4 = new Button("Back",new ImageView("go-back-icon.png"));
			
			search.setPrefSize(150,100);
			back4.setPrefSize(150,100);
			
			HBox shbox = new HBox(100);
			shbox.getChildren().addAll(search,back4);
			shbox.setPadding(new Insets(0,0,30,0));
			shbox.setAlignment(Pos.BOTTOM_CENTER);
			
			rootsearchc.setLeft(gpcustomer4);
			rootsearchc.setBottom(shbox);
			rootsearchc.setStyle("-fx-background-color:	antiquewhite");
			
			Label error1 = new Label("Error! Customer not found");
			error1.setFont(Font.font(25));
			error1.setTextFill(Color.RED);
			/* End Search a Customer by id */ 
			
			//search customer events
			search.setOnAction(e-> {	
				boolean flag = true;
				for(int i=0; i<mr.customers.size(); i++) {
					if((mr.customers.get(i).getId().equals(t13.getText()))) {
						findCustomer(t13,t14,t15,t16);
						flag=false;
						gpcustomer4.getChildren().remove(error1);
					}
				}
				
				if(flag) {
					System.out.println("Error! Customer  not found");
					gpcustomer4.add(error1,6,3);
				}
			});
			/////////
           
			/* Update customer info */
			
			BorderPane rootupdatec = new BorderPane();
			
            GridPane gpcustomer3 = new GridPane();
			
            Label lb9 = new Label("Customer ID: ");
            lb9.setFont(Font.font(25));
            Label lb10 = new Label("Customer Name: ");
            lb10.setFont(Font.font(25));
            Label lb11 = new Label("Customer Address: ");
            lb11.setFont(Font.font(25));
            Label lb12 = new Label("Customer Mobile: ");
            lb12.setFont(Font.font(25));
            
            TextField t9 = new TextField();
            t9.setPrefWidth(300);
            t9.setPrefHeight(30);
            TextField t10 = new TextField();
            t10.setPrefWidth(300);
            t10.setPrefHeight(30);
            TextField t11 = new TextField();
            t11.setPrefWidth(300);
            t11.setPrefHeight(30);
            TextField t12 = new TextField();
            t12.setPrefWidth(300);
            t12.setPrefHeight(30);
            
			gpcustomer3.add(lb9, 0, 0);
			gpcustomer3.add(t9, 1, 0);
			gpcustomer3.add(lb10, 0, 1);
			gpcustomer3.add(t10, 1, 1); 
			gpcustomer3.add(lb11, 0, 2);
			gpcustomer3.add(t11, 1, 2); 
			gpcustomer3.add(lb12, 0, 3);
			gpcustomer3.add(t12, 1, 3); 
			
		
			gpcustomer3.setHgap(15);
			gpcustomer3.setVgap(30);
			
			gpcustomer3.setAlignment(Pos.CENTER_LEFT);
			gpcustomer3.setPadding(new Insets(0,0,0,50)); 
			
		
			Button find2 = new Button("Find",new ImageView("icons8-find-64.png"));	
			Button back3 = new Button("Back",new ImageView("go-back-icon.png"));
			Button update = new Button("Update",new ImageView("icons8-update-64.png"));
			
			find2.setPrefSize(150, 100);
			back3.setPrefSize(150, 100);
			update.setPrefSize(150, 100);
			
			HBox hbox3 = new HBox(70);
			hbox3.getChildren().addAll(find2,update,back3);
			hbox3.setAlignment(Pos.BOTTOM_CENTER);
			hbox3.setPadding(new Insets(0,0,30,0));
			
			rootupdatec.setLeft(gpcustomer3);
			rootupdatec.setBottom(hbox3);
			rootupdatec.setStyle("-fx-background-color:	antiquewhite");
				 	
			/* END Update customer info */
			 find2.setOnAction(e ->{
				 findCustomer(t9,t10,t11,t12);
			 });
			update.setOnAction(e ->{
				updateCustomer(t9,t10,t11,t12);
				writeCustomerFile();
			});
			
			/*Media window page*/
            BorderPane rootmedia = new BorderPane();
			
			Text mtxt = new Text("Select one: ");
			mtxt.setFont(Font.font(null,FontWeight.BOLD, 30));
			Button mbtn1 = new Button("Add new Media");
			mbtn1.setFont(Font.font(25));
			Button mbtn2 = new Button("Delete Media");
			mbtn2.setFont(Font.font(25));
			Button mbtn3 = new Button("Update Information about Media");
			mbtn3.setFont(Font.font(25));
			Button mbtn4 = new Button("Search a Media by code");
			mbtn4.setFont(Font.font(25));
			Button mbtn5 = new Button("Print all Media information");
			mbtn5.setFont(Font.font(25));
			Button mbtn6 = new Button("Return to main page");
			mbtn6.setFont(Font.font(25));
				
			VBox mvbox = new VBox(20);
			mvbox.getChildren().addAll(mtxt,mbtn1,mbtn2,mbtn3,mbtn4,mbtn5,mbtn6);
			mvbox.setAlignment(Pos.CENTER);
			
		    rootmedia.setStyle("-fx-background-color:antiquewhite");
			rootmedia.setCenter(mvbox);		
			
		   /*END Media window page*/
			
			
				
			/*Add Media*/

			BorderPane rootaddMedia = new BorderPane();
			
            GridPane gpaddmedia = new GridPane();
            
            ComboBox<String> cbox = new ComboBox<>();
			cbox.getItems().addAll("Movie","Album","Game");
			
            Label lb17 = new Label("Media Code: ");
            lb17.setFont(Font.font(25));
            Label lb18 = new Label("Media Title: ");
            lb18.setFont(Font.font(25));
            Label lb19 = new Label("Number of copies: ");
            lb19.setFont(Font.font(25));
            Label lb20 = new Label("Select Media Type: ");
            lb20.setFont(Font.font(25));
            
            Label lb21 = new Label("Rating: ");
            lb21.setFont(Font.font(25));
            Label lb22 = new Label("Artist: ");
            lb22.setFont(Font.font(25));
            Label lb23 = new Label("Songs: ");
            lb23.setFont(Font.font(25));
            Label lb24 = new Label("Weight: ");
            lb24.setFont(Font.font(25));
           
            TextField t17 = new TextField();
            t17.setPrefSize(300,30);
            TextField t18 = new TextField();
            t18.setPrefSize(300,30);
            t18.setDisable(true);
            TextField t19 = new TextField();
            t19.setPrefSize(300,30);
            t19.setDisable(true);
            
         
            TextField t21 = new TextField();
            t21.setPrefSize(300,30);
            TextField t22 = new TextField();
            t22.setPrefSize(300,30);
            TextField t23 = new TextField();
            t23.setPrefSize(300,30);
            TextField t24 = new TextField();
            t24.setPrefSize(300,30);
           
            
			gpaddmedia.add(lb17, 0, 0);
			gpaddmedia.add(t17, 1, 0);
			gpaddmedia.add(lb18, 0, 1);
			gpaddmedia.add(t18, 1, 1); 
			gpaddmedia.add(lb19, 0, 2);
			gpaddmedia.add(t19, 1, 2); 
			gpaddmedia.add(lb20, 0, 3);
			gpaddmedia.add(cbox, 1, 3);
			
			//combobox events:
            cbox.setOnAction(e ->{
            	if(cbox.getValue().equals("Movie")) {
            		gpaddmedia.add(lb21, 0, 4);
            		gpaddmedia.add(t21, 1, 4);
            		
            		gpaddmedia.getChildren().remove(lb22);
            		gpaddmedia.getChildren().remove(t22);
            		gpaddmedia.getChildren().remove(lb23);
            		gpaddmedia.getChildren().remove(t23);
            		gpaddmedia.getChildren().remove(lb24);
            		gpaddmedia.getChildren().remove(t24);
            			
            	}
            	else if(cbox.getValue().equals("Album")) {
            		gpaddmedia.add(lb22, 0, 4);
            		gpaddmedia.add(t22, 1, 4);
            		gpaddmedia.add(lb23, 0, 5);
            		gpaddmedia.add(t23, 1, 5);
            		
            		gpaddmedia.getChildren().remove(lb21);
            		gpaddmedia.getChildren().remove(t21);
            		gpaddmedia.getChildren().remove(lb24);
            		gpaddmedia.getChildren().remove(t24);
            		
            	}
            	else if(cbox.getValue().equals("Game")) {
            		gpaddmedia.add(lb24, 0, 4);
            		gpaddmedia.add(t24, 1, 4);
            		
            		gpaddmedia.getChildren().remove(lb21);
            		gpaddmedia.getChildren().remove(t21);
            		gpaddmedia.getChildren().remove(lb22);
            		gpaddmedia.getChildren().remove(t22);
            		gpaddmedia.getChildren().remove(lb23);
            		gpaddmedia.getChildren().remove(t23);
            	}
            	
            });
			
			gpaddmedia.setHgap(15);
			gpaddmedia.setVgap(30);
			
			gpaddmedia.setAlignment(Pos.CENTER_LEFT);
			gpaddmedia.setPadding(new Insets(0,0,0,50)); 
			
			Button add2 = new Button("Add",new ImageView("icons8-add-64.png"));
			Button back5 = new Button("Back",new ImageView("go-back-icon.png"));
			
			add2.setPrefSize(150,100);
			back5.setPrefSize(150,100);
			
			HBox ahbox = new HBox(100);
			ahbox.getChildren().addAll(add2,back5);
			ahbox.setPadding(new Insets(0,0,30,0));
			ahbox.setAlignment(Pos.BOTTOM_CENTER);
			
			rootaddMedia.setLeft(gpaddmedia);
			rootaddMedia.setBottom(ahbox);
			rootaddMedia.setStyle("-fx-background-color:skyblue");
			
			t17.setOnKeyTyped(e -> {t18.setDisable(false);});
			t18.setOnKeyTyped(e -> {t19.setDisable(false);});
			t19.setOnKeyTyped(e -> {t21.setDisable(false);});
		   
			/*END Add Media*/
			
			//Add media events
			add2.setOnAction(e -> {
				if(cbox.getValue().equals("Movie"))
					mr.addMovie(t17.getText(),t18.getText(),Integer.parseInt(t19.getText()),t21.getText());
				else if(cbox.getValue().equals("Album"))
					mr.addAlbum(t17.getText(),t18.getText(),Integer.parseInt(t19.getText()),t22.getText(),t23.getText());
				else if(cbox.getValue().equals("Game"))
					mr.addGame(t17.getText(),t18.getText(),Integer.parseInt(t19.getText()),Double.parseDouble(t24.getText()));
				writeMediaFile();
			});
		 
			
		   /*Delete media*/

			BorderPane rootdeleteMedia = new BorderPane();
			
            GridPane gpdeletemedia = new GridPane();
            
            ComboBox<String> cbox2 = new ComboBox<>();
			cbox2.getItems().addAll("Movie","Album","Game");
			
            Label lb25 = new Label("Media Code: ");
            lb25.setFont(Font.font(25));
            Label lb26 = new Label("Media Title: ");
            lb26.setFont(Font.font(25));
            Label lb27 = new Label("Number of copies: ");
            lb27.setFont(Font.font(25));
            Label lb28 = new Label("Select Media Type: ");
            lb28.setFont(Font.font(25));
            
            Label lb29 = new Label("Rating: ");
            lb29.setFont(Font.font(25));
            Label lb30 = new Label("Artist: ");
            lb30.setFont(Font.font(25));
            Label lb31 = new Label("Songs: ");
            lb31.setFont(Font.font(25));
            Label lb32 = new Label("Weight: ");
            lb32.setFont(Font.font(25));
           
            TextField t25 = new TextField();
            t25.setPrefSize(300,30);
            TextField t26 = new TextField();
            t26.setPrefSize(300,30);
            TextField t27 = new TextField();
            t27.setPrefSize(300,30);
            
         
            TextField t28 = new TextField();
            t28.setPrefSize(300,30);
            TextField t29 = new TextField();
            t29.setPrefSize(300,30);
            TextField t30 = new TextField();
            t30.setPrefSize(300,30);
            TextField t31 = new TextField();
            t31.setPrefSize(300,30);
            
			gpdeletemedia.add(lb25, 0, 0);
			gpdeletemedia.add(t25, 1, 0);
			gpdeletemedia.add(lb26, 0, 1);
			gpdeletemedia.add(t26, 1, 1); 
			gpdeletemedia.add(lb27, 0, 2);
			gpdeletemedia.add(t27, 1, 2); 
			gpdeletemedia.add(lb28, 0, 3);
			gpdeletemedia.add(cbox2, 1, 3);
			
			//combobox events:
            cbox2.setOnAction(e ->{
            	if(cbox2.getValue().equals("Movie")) {
            		gpdeletemedia.add(lb29, 0, 4);
            		gpdeletemedia.add(t28, 1, 4);
            		
            		gpdeletemedia.getChildren().remove(lb30);
            		gpdeletemedia.getChildren().remove(t29);
            		gpdeletemedia.getChildren().remove(lb31);
            		gpdeletemedia.getChildren().remove(t30);
            		gpdeletemedia.getChildren().remove(lb32);
            		gpdeletemedia.getChildren().remove(t31);
            	}
            	else if(cbox2.getValue().equals("Album")) {
            		gpdeletemedia.add(lb30, 0, 4);
            		gpdeletemedia.add(t29, 1, 4);
            		gpdeletemedia.add(lb31, 0, 5);
            		gpdeletemedia.add(t30, 1, 5);
            	
            		gpdeletemedia.getChildren().remove(lb29);
            		gpdeletemedia.getChildren().remove(t28);
            		gpdeletemedia.getChildren().remove(lb32);
            		gpdeletemedia.getChildren().remove(t31);
            	}
            	else if(cbox2.getValue().equals("Game")) {
            		gpdeletemedia.add(lb32, 0, 4);
            		gpdeletemedia.add(t31, 1, 4);
            		
            		gpdeletemedia.getChildren().remove(lb29);
            		gpdeletemedia.getChildren().remove(t28);
            		gpdeletemedia.getChildren().remove(lb30);
            		gpdeletemedia.getChildren().remove(t29);
            		gpdeletemedia.getChildren().remove(lb31);
            		gpdeletemedia.getChildren().remove(t30);
            	}
            	
            });
			
			gpdeletemedia.setHgap(15);
			gpdeletemedia.setVgap(30);
			
			gpdeletemedia.setAlignment(Pos.CENTER_LEFT);
			gpdeletemedia.setPadding(new Insets(0,0,0,50)); 
			
			Button delete = new Button("Delete",new ImageView("icons8-delete-64.png"));
			Button back6 = new Button("Back",new ImageView("go-back-icon.png"));
			Button find3 = new Button("Find",new ImageView("icons8-find-64.png"));
			
			delete.setPrefSize(150,100);
			back6.setPrefSize(150,100);
			find3.setPrefSize(150,100);
			
			HBox dhbox = new HBox(100);
			dhbox.getChildren().addAll(find3,delete,back6);
			dhbox.setPadding(new Insets(0,0,30,0));
			dhbox.setAlignment(Pos.BOTTOM_CENTER);
			
			rootdeleteMedia.setLeft(gpdeletemedia);
			rootdeleteMedia.setBottom(dhbox);
			rootdeleteMedia.setStyle("-fx-background-color:skyblue");
		   /*END Delete media*/
			
			// Delete media events
			find3.setOnAction(e -> {
				findMedia(t25,t26,t27,cbox2,t28,t29,t30,t31);
			});
			delete.setOnAction(e -> {
				for(int i=0; i<mr.media.size(); i++) {
					if(mr.media.get(i).getCode().equals(t25.getText()))
						mr.media.remove(i);
				}
				writeMediaFile();
			});
			
		   /*Update media*/

			BorderPane rootupdateMedia = new BorderPane();
			
            GridPane gpupdatemedia = new GridPane();
            
            ComboBox<String> cbox3 = new ComboBox<>();
			cbox3.getItems().addAll("Movie","Album","Game");
			
            Label lb33 = new Label("Media Code: ");
            lb33.setFont(Font.font(25));
            Label lb34 = new Label("Media Title: ");
            lb34.setFont(Font.font(25));
            Label lb35 = new Label("Number of copies: ");
            lb35.setFont(Font.font(25));
            Label lb36 = new Label("Select Media Type: ");
            lb36.setFont(Font.font(25));
            
            Label lb37 = new Label("Rating: ");
            lb37.setFont(Font.font(25));
            Label lb38 = new Label("Artist: ");
            lb38.setFont(Font.font(25));
            Label lb39 = new Label("Songs: ");
            lb39.setFont(Font.font(25));
            Label lb40 = new Label("Weight: ");
            lb40.setFont(Font.font(25));
           
            TextField t33 = new TextField();
            t33.setPrefSize(300,30);
            TextField t34 = new TextField();
            t34.setPrefSize(300,30);
            TextField t35 = new TextField();
            t35.setPrefSize(300,30);
            
         
            TextField t37 = new TextField();
            t37.setPrefSize(300,30);
            TextField t38 = new TextField();
            t38.setPrefSize(300,30);
            TextField t39 = new TextField();
            t39.setPrefSize(300,30);
            TextField t40 = new TextField();
            t40.setPrefSize(300,30);
            
			gpupdatemedia.add(lb33, 0, 0);
			gpupdatemedia.add(t33, 1, 0);
			gpupdatemedia.add(lb34, 0, 1);
			gpupdatemedia.add(t34, 1, 1); 
			gpupdatemedia.add(lb35, 0, 2);
			gpupdatemedia.add(t35, 1, 2); 
			gpupdatemedia.add(lb36, 0, 3);
			gpupdatemedia.add(cbox3, 1, 3);
			
			//combobox events:
            cbox3.setOnAction(e ->{
            	if(cbox3.getValue().equals("Movie")) {
            		gpupdatemedia.add(lb37, 0, 4);
            		gpupdatemedia.add(t37, 1, 4);
            		
            		gpupdatemedia.getChildren().remove(lb38);
            		gpupdatemedia.getChildren().remove(t38);
            		gpupdatemedia.getChildren().remove(lb39);
            		gpupdatemedia.getChildren().remove(t39);
            		gpupdatemedia.getChildren().remove(lb40);
            		gpupdatemedia.getChildren().remove(t40);
            	}
            	else if(cbox3.getValue().equals("Album")) {
            		gpupdatemedia.add(lb38, 0, 4);
            		gpupdatemedia.add(t38, 1, 4);
            		gpupdatemedia.add(lb39, 0, 5);
            		gpupdatemedia.add(t39, 1, 5);
            		
            		gpupdatemedia.getChildren().remove(lb37);
            		gpupdatemedia.getChildren().remove(t37);
            		gpupdatemedia.getChildren().remove(lb40);
            		gpupdatemedia.getChildren().remove(t40);
            	
            	}
            	else if(cbox3.getValue().equals("Game")) {
            		gpupdatemedia.add(lb40, 0, 4);
            		gpupdatemedia.add(t40, 1, 4);
            		
            		gpupdatemedia.getChildren().remove(lb37);
            		gpupdatemedia.getChildren().remove(t37);
            		gpupdatemedia.getChildren().remove(lb38);
            		gpupdatemedia.getChildren().remove(t38);
            		gpupdatemedia.getChildren().remove(lb39);
            		gpupdatemedia.getChildren().remove(t39);
            	}
            	
            });
			
			gpupdatemedia.setHgap(15);
			gpupdatemedia.setVgap(30);
			
			gpupdatemedia.setAlignment(Pos.CENTER_LEFT);
			gpupdatemedia.setPadding(new Insets(0,0,0,50)); 
			
			Button update2 = new Button("Update",new ImageView("icons8-update-64.png"));
			Button back7 = new Button("Back",new ImageView("go-back-icon.png"));
			Button find4 = new Button("Find",new ImageView("icons8-find-64.png"));
			
			update2.setPrefSize(150,100);
			back7.setPrefSize(150,100);
			find4.setPrefSize(150,100);
			
			HBox uhbox = new HBox(100);
			uhbox.getChildren().addAll(find4,update2,back7);
			uhbox.setPadding(new Insets(0,0,30,0));
			uhbox.setAlignment(Pos.BOTTOM_CENTER);
			
			rootupdateMedia.setLeft(gpupdatemedia);
			rootupdateMedia.setBottom(uhbox);
			rootupdateMedia.setStyle("-fx-background-color:skyblue");
		  /*END Update media*/

			// update media events
			find4.setOnAction(e ->{
				findMedia(t33,t34,t35,cbox3,t37,t38,t39,t40);
			});
			update2.setOnAction(e -> {
				updateMedia(t33,t34,t35,cbox3,t37,t28,t39,t40);
				writeMediaFile();
			});

			/*Search media*/

			BorderPane rootsearchMedia = new BorderPane();
			
            GridPane gpsearchmedia = new GridPane();
            
            ComboBox<String> cbox4 = new ComboBox<>();
			cbox4.getItems().addAll("Movie","Album","Game");
			
            Label lb41 = new Label("Media Code: ");
            lb41.setFont(Font.font(25));
            Label lb42 = new Label("Media Title: ");
            lb42.setFont(Font.font(25));
            Label lb43 = new Label("Number of copies: ");
            lb43.setFont(Font.font(25));
            Label lb44 = new Label("Select Media Type: ");
            lb44.setFont(Font.font(25));
            
            Label lb45 = new Label("Rating: ");
            lb45.setFont(Font.font(25));
            Label lb46 = new Label("Artist: ");
            lb46.setFont(Font.font(25));
            Label lb47 = new Label("Songs: ");
            lb47.setFont(Font.font(25));
            Label lb48 = new Label("Weight: ");
            lb48.setFont(Font.font(25));
           
            TextField t41 = new TextField();
            t41.setPrefSize(300,30);
            TextField t42 = new TextField();
            t42.setPrefSize(300,30);
            TextField t43 = new TextField();
            t43.setPrefSize(300,30);
            
         
            TextField t45 = new TextField();
            t45.setPrefSize(300,30);
            TextField t46 = new TextField();
            t46.setPrefSize(300,30);
            TextField t47 = new TextField();
            t47.setPrefSize(300,30);
            TextField t48 = new TextField();
            t48.setPrefSize(300,30);
            
			gpsearchmedia.add(lb41, 0, 0);
			gpsearchmedia.add(t41, 1, 0);
			gpsearchmedia.add(lb42, 0, 1);
			gpsearchmedia.add(t42, 1, 1); 
			gpsearchmedia.add(lb43, 0, 2);
			gpsearchmedia.add(t43, 1, 2); 
			gpsearchmedia.add(lb44, 0, 3);
			gpsearchmedia.add(cbox4, 1, 3);
			
			//combobox events:
            cbox4.setOnAction(e ->{
            	if(cbox4.getValue().equals("Movie")) {
            		gpsearchmedia.add(lb45, 0, 4);
            		gpsearchmedia.add(t45, 1, 4);
            		
            		gpsearchmedia.getChildren().remove(lb46);
            		gpsearchmedia.getChildren().remove(t46);
            		gpsearchmedia.getChildren().remove(lb47);
            		gpsearchmedia.getChildren().remove(t47);
            		gpsearchmedia.getChildren().remove(lb48);
            		gpsearchmedia.getChildren().remove(t48);
            	}
            	else if(cbox4.getValue().equals("Album")) {
            		gpsearchmedia.add(lb46, 0, 4);
            		gpsearchmedia.add(t46, 1, 4);
            		gpsearchmedia.add(lb47, 0, 5);
            		gpsearchmedia.add(t47, 1, 5);
            		
            		gpsearchmedia.getChildren().remove(lb45);
            		gpsearchmedia.getChildren().remove(t45);
            		gpsearchmedia.getChildren().remove(lb48);
            		gpsearchmedia.getChildren().remove(t48);
            		
            	}
            	else if(cbox4.getValue().equals("Game")) {
            		gpsearchmedia.add(lb48, 0, 4);
            		gpsearchmedia.add(t48, 1, 4);
            		
            		gpsearchmedia.getChildren().remove(lb45);
            		gpsearchmedia.getChildren().remove(t45);
            		gpsearchmedia.getChildren().remove(lb46);
            		gpsearchmedia.getChildren().remove(t46);
            		gpsearchmedia.getChildren().remove(lb47);
            		gpsearchmedia.getChildren().remove(t47);
            	}
            	
            });
			
			gpsearchmedia.setHgap(15);
			gpsearchmedia.setVgap(30);
			
			gpsearchmedia.setAlignment(Pos.CENTER_LEFT);
			gpsearchmedia.setPadding(new Insets(0,0,0,50)); 
			
			Button search2 = new Button("Search",new ImageView("icons8-search-64.png"));
			Button back8 = new Button("Back",new ImageView("go-back-icon.png"));
			
			search2.setPrefSize(150,100);
			back8.setPrefSize(150,100);
			
			
			HBox shbox2 = new HBox(100);
			shbox2.getChildren().addAll(search2,back8);
			shbox2.setPadding(new Insets(0,0,30,0));
			shbox2.setAlignment(Pos.BOTTOM_CENTER);
			
			rootsearchMedia.setLeft(gpsearchmedia);
			rootsearchMedia.setBottom(shbox2);
			rootsearchMedia.setStyle("-fx-background-color:skyblue");
			
			Label error = new Label("Error! Media not found");
			error.setFont(Font.font(25));
			error.setTextFill(Color.RED);
			
			/*End Search media*/
			
	        // Search media events
			search2.setOnAction(e -> {
				boolean flag = true;
				for(int i=0; i<mr.media.size(); i++) {
					if((mr.media.get(i).getCode().equals(t41.getText()))) {
						findMedia(t41,t42,t43,cbox4,t45,t46,t47,t48);
						
						flag=false;
						gpsearchmedia.getChildren().remove(error);
					}
				}
				
				if(flag) {
					System.out.println("Error! Media not found");
					gpsearchmedia.add(error,6,3);
				}
			});
			
			/* print all media information interface*/
			GridPane mgp = new GridPane();
			
			Label mtitle = new Label("Enter media code to display all information about it ");
			mtitle.setFont(Font.font(25));
			
			Label mcode = new Label("Media Code: ");
			mcode.setFont(Font.font(25));
			TextField mcodet = new TextField();
			mcodet.setPrefSize(140,30);
			
			TextArea mediaInfo = new TextArea();
			mediaInfo.setPrefSize(700,200);
			mediaInfo.setFont(Font.font(15));
			
			HBox mbx = new HBox();
			mbx.getChildren().addAll(mcode,mcodet);
			mbx.setPadding(new Insets(25,25,25,25));
			
			Button display1 = new Button("display information");
			display1.setPrefSize(150,120);
			display1.setFont(Font.font(15));
			
			Button display2 = new Button("display all media info");
			display2.setPrefSize(160,120);
			display2.setFont(Font.font(15));
			
			Button backm = new Button("Back",new ImageView("go-back-icon.png"));
			backm.setPrefSize(150,120);
			backm.setFont(Font.font(15));
			
			HBox mbx2 = new HBox(10);
			mbx2.getChildren().addAll(display1,display2,backm);
			mbx2.setPadding(new Insets(25,25,25,25));
		
			mgp.add(mtitle, 3, 0);
			mgp.add(mbx,3,2);
			mgp.add(mediaInfo, 3, 3);
			mgp.add(mbx2, 6, 11);
			mgp.setAlignment(Pos.CENTER);
			mgp.setPadding(new Insets(25,25,25,25));
			mgp.setStyle("-fx-background-color:skyblue");
			
			/* end print all media information interface */
			
			//print all media information events
			display1.setOnAction(e -> {
				mediaInfo.setText(displayMediaInfo(mcodet));
			});
			display2.setOnAction(e -> {
				mediaInfo.setText(displayAllMediaInfo());
			});
			//////////////////
			
			/* Rent Media window page*/
	        BorderPane rootRent = new BorderPane();
			
			Text rtxt = new Text("Select one: ");
			rtxt.setFont(Font.font(null,FontWeight.BOLD, 30));
			Button rbtn1 = new Button("Rent Media");
			rbtn1.setFont(Font.font(25));
			Button rbtn2 = new Button("Print the requested media in a customer's cart by giving the id");
			rbtn2.setFont(Font.font(25));
			Button rbtn3 = new Button("Print the rented media in a customer's cart by giving the id");
			rbtn3.setFont(Font.font(25));
			Button rbtn4 = new Button("Return rented media");
			rbtn4.setFont(Font.font(25));
			Button rbtn5 = new Button("Return to main page");
			rbtn5.setFont(Font.font(25));
			
			
			VBox rvbox = new VBox(20);
			rvbox.getChildren().addAll(rtxt,rbtn1,rbtn2,rbtn3,rbtn4,rbtn5);
			rvbox.setAlignment(Pos.CENTER);
			
		    rootRent.setStyle("-fx-background-color:skyblue");
			rootRent.setCenter(rvbox);
			///////////////////////////
			
			
			//// Rent media interface
			GridPane rm = new GridPane();
			 
			Label idr = new Label("Customer ID: ");
			idr.setFont(Font.font(25));
		
			TextField idrt = new TextField();
			idrt.setPrefSize(150, 40);
			idrt.setFont(Font.font(15));
			
			HBox cr = new HBox();
			cr.getChildren().addAll(idr, idrt);
			cr.setPadding(new Insets(25,25,25,25));
			
			TextArea txtarea1 = new TextArea();
			txtarea1.setMaxSize(800, 150);
			txtarea1.setFont(Font.font(15));
			
			rm.add(cr,3,0);
			rm.add(txtarea1,3,1);
			///////
			Label mediac = new Label("Media Code: ");
			mediac.setFont(Font.font(25));
			
			TextField mediact = new TextField();
			mediact.setPrefSize(150, 40);
			mediact.setFont(Font.font(15));
			
			HBox mc = new HBox();
			mc.getChildren().addAll(mediac, mediact);
			mc.setPadding(new Insets(25,25,25,25));
			
			TextArea textarea2 = new TextArea();			    
			textarea2.setMaxSize(800, 150);
			textarea2.setFont(Font.font(15));
			rm.add(mc,3,3);
			rm.add(textarea2,3,4);
			///////////////////
			Label rentedd = new Label("Rented Date: ");
			rentedd.setFont(Font.font(25));
			TextField renteddt = new TextField();	
			renteddt.setMaxSize(500,100);
			renteddt.setFont(Font.font(15));
				
			HBox rd = new HBox();
			rd.getChildren().addAll(rentedd,renteddt);
			rd.setPadding(new Insets(25,25,25,25));
			
			rm.add(rd,3,5);
			
			///////////////////////
			Button addCart = new Button("Add To Cart");
			addCart .setPrefSize(150,120);
			Button processCart = new Button("process cart");
			processCart.setPrefSize(150,120);
			Button display = new Button("display information");
			display.setPrefSize(150,120);
			Button backrentform = new Button("back",new ImageView("go-back-icon.png"));
			backrentform .setPrefSize(150,120);
			addCart.setFont(Font.font(15));
			processCart.setFont(Font.font(15));
			display.setFont(Font.font(15));
			backrentform.setFont(Font.font(15));
			
			HBox hbr1 = new HBox(20);	
			hbr1.getChildren().addAll(display,addCart,processCart,backrentform);
			hbr1.setPadding(new Insets(25,25,25,25));

			rm.add(hbr1,7,7);
			
			rm.setAlignment(Pos.CENTER);
			rm.setPadding(new Insets(25, 25, 25, 25));
			rm.setStyle("-fx-background-color:thistle");
			//////////////////////////
			
			/// rent media events
			display.setOnAction(e -> {
				txtarea1.setText(displayCustomerInfo( idrt));
				
				textarea2.setText(displayMediaInfo(mediact));
				 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
				  Date date = new Date(); 
				  renteddt.setText(formatter.format(date));
	
			});
			
			addCart.setOnAction(e -> {
				mr.addToCart(idrt.getText(),mediact.getText());
				writeRequestedFile();
				writeMediaFile();
			});
			processCart.setOnAction(e -> {
				mr.processRequests(idrt.getText(),mediact.getText());
				writeRentedFile();
				writeRequestedFile();
			});
			
			////////////////////////////
			
		    ///// print requested media interface
			   GridPane rm2 = new GridPane();
			   Label titlerent2 = new Label("Display the requested media in the customer's cart by giving the id: ");
				 
				Label idrm2 = new Label("Customer ID: ");
				idrm2.setFont(Font.font(25));
				titlerent2.setFont(Font.font(25));
			
				TextField idtext = new TextField();
				idtext.setPrefSize(150, 40);
				idtext.setFont(Font.font(15));
				
				HBox cirm2 = new HBox();
				cirm2.getChildren().addAll(idrm2, idtext);
				cirm2.setPadding(new Insets(25,25,25,25));
				
				TextArea idtextA = new TextArea();
				idtextA.setMaxSize(700, 150);
				idtextA.setFont(Font.font(15));
				
				rm2.add(titlerent2,3,0);
				rm2.add(cirm2,3,1);
				rm2.add(idtextA,3,2);
			
				Button displayrm2 = new Button("display information");
				displayrm2.setPrefSize(150,120);
				Button backrm2= new Button("back",new ImageView("go-back-icon.png"));
				backrm2 .setPrefSize(150,120);
					
				displayrm2.setFont(Font.font(15));
				backrm2.setFont(Font.font(15));
				
				HBox hbrrm2 = new HBox(20);	
				hbrrm2.getChildren().addAll(displayrm2,backrm2);
				hbrrm2.setPadding(new Insets(25,25,25,25));
				
				rm2.add(hbrrm2,7,7);
				
				rm2.setAlignment(Pos.CENTER);
				rm2.setHgap(15);
				rm2.setVgap(15);
				rm2.setPadding(new Insets(25, 25, 25, 25));
				rm2.setStyle("-fx-background-color:thistle");
				//////////////////////
				
				
				// print requested media events
				displayrm2.setOnAction(e -> {
					String line ="";
					for(int i=0; i<mr.customers.size(); i++) {
						
						if((mr.customers.get(i).getId()).equals(idtext.getText()))
							for(int j=0; j<mr.customers.get(i).getCart().size(); j++) {
								line +="code: "+ mr.customers.get(i).getCart().get(j)+", ";
								for(int k=0; k<mr.media.size(); k++) {
									if(mr.media.get(k).getCode().equals(mr.customers.get(i).getCart().get(j))) {
										line += "Title: " + mr.media.get(k).getTitle() + "\n" ;
									}
								}
							}
					}
					idtextA.setText(line);
				});
				
				//// print rented media interface
				  GridPane rm3 = new GridPane();
				   Label titlerent3 = new Label("Display the rented  media in the customer's cart by giving the id:");
					  
					Label idrm3 = new Label("Customer ID: ");
					idrm3.setFont(Font.font(25));
					titlerent3.setFont(Font.font(25));
					
					
					TextField idtext3 = new TextField();
					idtext3.setPrefSize(150, 40);
					idtext3.setFont(Font.font(15));
						
					HBox cirm3 = new HBox();
					cirm3.getChildren().addAll(idrm3, idtext3);
					cirm3.setPadding(new Insets(25,25,25,25));
					
					TextArea idtextA3 = new TextArea();
					idtextA3.setMaxSize(700,150);
					idtextA3.setFont(Font.font(15));
					
					rm3.add(titlerent3,3,0);
					rm3.add(cirm3,3,1);
					rm3.add(idtextA3,3,2);
				
					Button displayrm3 = new Button("display information");
					displayrm3.setPrefSize(150,120);
					Button backrm3= new Button("back",new ImageView("go-back-icon.png"));
					backrm3 .setPrefSize(150,120);
					
					
					displayrm3.setFont(Font.font(15));
					backrm3.setFont(Font.font(15));
					
					HBox hbrrm3 = new HBox(20);	
					hbrrm3.getChildren().addAll(displayrm3,backrm3);
					hbrrm3.setPadding(new Insets(25,25,25,25));
					
					rm3.add(hbrrm3,5,5);
					
					rm3.setAlignment(Pos.CENTER);
					rm3.setHgap(15);
					rm3.setVgap(15);
					rm3.setPadding(new Insets(25, 25, 25, 25));
					rm3.setStyle("-fx-background-color:thistle");
                    ///////////////////////
				    
					/// print rented media interface
					displayrm3.setOnAction(e -> {
						String line ="";
						for(int i=0; i<mr.customers.size(); i++) {
							
							if((mr.customers.get(i).getId()).equals(idtext3.getText()))
								for(int j=0; j<mr.customers.get(i).getRented().size(); j++) {
									line +="code: "+ mr.customers.get(i).getRented().get(j)+", ";
									for(int k=0; k<mr.media.size(); k++) {
										if(mr.media.get(k).getCode().equals(mr.customers.get(i).getRented().get(j))) {
											line += "Title: " + mr.media.get(k).getTitle() + "\n" ;
										}
									}
								}
						}
						idtextA3.setText(line);
					});
					
		    //// return media interface
					  GridPane rm4 = new GridPane();
				      Label titlerent4 = new Label("Enter your id and code for media you want to return:");
						  
						Label idrm4 = new Label("Customer ID: ");
						idrm4.setFont(Font.font(25));
						titlerent4.setFont(Font.font(20));
					
						TextField idtext4 = new TextField();
						idtext4.setPrefSize(150, 40);
						idtext4.setFont(Font.font(15));
						
						Label coderm4 = new Label("Media Code: ");
						coderm4.setFont(Font.font(25));
					    coderm4.setFont(Font.font(25));
					
						TextField codetext4 = new TextField();
						codetext4.setPrefSize(150, 40);
						codetext4.setFont(Font.font(15));
						
						
						HBox cirm4 = new HBox();
						cirm4.getChildren().addAll(idrm4, idtext4);
						cirm4.setPadding(new Insets(25,25,25,25));
						
						HBox mirm4 = new HBox();
						mirm4.getChildren().addAll(coderm4, codetext4);
						mirm4.setPadding(new Insets(25,25,25,25));
						
						TextArea idtextA4 = new TextArea();
						idtextA4.setMaxSize(750,130);
						idtextA4.setFont(Font.font(15));
						rm4.add(titlerent4,3,0);
						rm4.add(cirm4,3,1);
						rm4.add(mirm4,3,2);
						rm4.add(idtextA4,3,3);
						
					
						Button returnmedia = new Button("return media");
						returnmedia.setPrefSize(150,120);
						Button backrm4= new Button("back",new ImageView("go-back-icon.png"));
						backrm4 .setPrefSize(150,120);
						Button displayrm4 = new Button("display info");
						displayrm4.setPrefSize(150,120);
						Button returnAllmedia= new Button("return all media");
						returnAllmedia.setPrefSize(150,120);
						
						
						displayrm4.setFont(Font.font(15));
						backrm4.setFont(Font.font(15));
						returnmedia.setFont(Font.font(15));
						returnAllmedia.setFont(Font.font(15));
						
						HBox hbrrm4 = new HBox(20);	
						hbrrm4.getChildren().addAll(displayrm4,returnmedia,backrm4);
						hbrrm4.setPadding(new Insets(25,25,25,25));
						
						rm4.add(hbrrm4,5,5);
						
						rm4.setAlignment(Pos.CENTER);
						rm4.setHgap(15);
						rm4.setVgap(15);
						rm4.setPadding(new Insets(25, 25, 25, 25)); 
						rm4.setStyle("-fx-background-color:thistle");
                        //////////
	        
						/// return media events
						returnmedia.setOnAction(e -> {
							mr.returnMedia( idtext4.getText(), codetext4.getText());
							writeMediaFile();
							writeRentedFile();
						});
						displayrm4.setOnAction(e -> {
							String line = displayCustomerInfo(idtext4) ;
							line += "\n**********\n";
							line += displayMediaInfo(codetext4);
							idtextA4.setText(line);
						});
						/*returnAllmedia.setOnAction(e -> {
 
							writeRentedFile();
							writeMediaFile();
						});*/
						
			/////////
			Scene scene = new Scene(rootmain,400,400);
		    //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			/*Events for changing roots on scene*/
			btnCustomer.setOnAction(e -> {scene.setRoot(rootcustomer);});
			btnMedia.setOnAction(e -> {scene.setRoot(rootmedia);});
			btnRent.setOnAction(e -> {scene.setRoot(rootRent);});
			//customer
			cbtn1.setOnAction(e -> {scene.setRoot(rootaddc);});
			cbtn2.setOnAction(e -> {scene.setRoot(rootdeletec);});
			cbtn3.setOnAction(e -> {scene.setRoot(rootupdatec);});
			cbtn4.setOnAction(e -> {scene.setRoot(rootsearchc);});
			cbtn5.setOnAction(e -> {scene.setRoot(rootmain);});
			
			back.setOnAction(e -> {scene.setRoot(rootcustomer);});
			back2.setOnAction(e -> {scene.setRoot(rootcustomer);});
			back3.setOnAction(e -> {scene.setRoot(rootcustomer);});
			back4.setOnAction(e -> {scene.setRoot(rootcustomer);});
			
			//media
			mbtn1.setOnAction(e -> {scene.setRoot(rootaddMedia);});
			mbtn2.setOnAction(e -> {scene.setRoot(rootdeleteMedia);});
			mbtn3.setOnAction(e -> {scene.setRoot(rootupdateMedia);});
			mbtn4.setOnAction(e -> {scene.setRoot(rootsearchMedia);});
			mbtn5.setOnAction(e -> {scene.setRoot(mgp);});
			mbtn6.setOnAction(e -> {scene.setRoot(rootmain);});
			
			back5.setOnAction(e -> {scene.setRoot(rootmedia);});
			back6.setOnAction(e -> {scene.setRoot(rootmedia);});
			back7.setOnAction(e -> {scene.setRoot(rootmedia);});
			back8.setOnAction(e -> {scene.setRoot(rootmedia);});
			backm.setOnAction(e -> {scene.setRoot(rootmedia);});
			
			// rent
			rbtn1.setOnAction(e -> {scene.setRoot(rm);} );
			rbtn2.setOnAction(e -> {scene.setRoot(rm2);} );
			rbtn3.setOnAction(e -> {scene.setRoot(rm3);} );
			rbtn4.setOnAction(e -> {scene.setRoot(rm4);} );
			rbtn5.setOnAction(e -> {scene.setRoot(rootmain);} );
			
			
			backrentform.setOnAction(e -> {scene.setRoot(rootRent);});
			backrm2.setOnAction(e -> {scene.setRoot(rootRent);});
			backrm3.setOnAction(e -> {scene.setRoot(rootRent);});
			backrm4.setOnAction(e -> {scene.setRoot(rootRent);});
			
			
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// writing on customer file method
	public void writeCustomerFile()  {
		
		File c = new File("customers.txt");
		try {
			FileWriter fw = new FileWriter(c);
			
			for(int i=0; i<mr.customers.size(); i++) {
				String line = mr.customers.get(i).getId() + "," +
						      mr.customers.get(i).getName() + "," +
						      mr.customers.get(i).getAddress() + "," +
						      mr.customers.get(i).getMobile() + "," +
						      mr.customers.get(i).getPlan()+"\n";
				fw.write(line);
			}
				
			fw.close();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// writing on media file method
    public void writeMediaFile()  {
		
		File m = new File("media.txt");
		try {
			FileWriter fw = new FileWriter(m);
			
			for(int i=0; i<mr.media.size(); i++) {
			    String line="";
			    if(mr.media.get(i) instanceof Movie) {
			    	line = "Movie"+"," + 
			                mr.media.get(i).code + "," +
			                mr.media.get(i).title + "," +
			                mr.media.get(i).numOfCopies + "," +
			                mr.media.get(i).getRating()+  "\n";
			    }
			    		    			
			    			
			    else if(mr.media.get(i) instanceof Album) {
			    	line = "Album"+"," + 
			                mr.media.get(i).code + "," +
			                mr.media.get(i).title + "," +
			                mr.media.get(i).numOfCopies + "," +
			                mr.media.get(i).getArtist()+ "," +
			                mr.media.get(i).getSongs() + "\n" ;
			                
			    }
			    else if(mr.media.get(i) instanceof Game) {
			    	line = "Game"+"," + 
			                mr.media.get(i).code + "," +
			                mr.media.get(i).title + "," +
			                mr.media.get(i).numOfCopies + "," +
			                mr.media.get(i).getWeight() +"\n" ;
			    	       	                
			    }
			    
				fw.write(line);
			}
				
			fw.close();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
    
    /// write on requested file
    public void writeRequestedFile() {
    	File r1 = new File("requested.txt");
    	
    	try {
			FileWriter fw = new FileWriter(r1);
			for(int i=0; i<mr.customers.size(); i++) {
				for(int j=0; j<mr.customers.get(i).getCart().size(); j++) {
					String line = mr.customers.get(i).getId() +","+ mr.customers.get(i).getCart().get(j) +"\n";
					fw.write(line);
				}
			}
			
			fw.close();
	
    	} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    //////////////
    
    /// write on rented file
    public void writeRentedFile() {
    	File r2 = new File("rented.txt");
    	
    	try {
			FileWriter fw = new FileWriter(r2);
			for(int i=0; i<mr.customers.size(); i++) {
				for(int j=0; j<mr.customers.get(i).getRented().size(); j++) {
					String line = mr.customers.get(i).getId() +","+ mr.customers.get(i).getRented().get(j) + "\n";
					fw.write(line);
				}
			}
			
			fw.close();
	
    	} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
	
    // find customer method
    public void findCustomer(TextField id,TextField name,TextField address,TextField mobile) {
    	for(int i=0; i<mr.customers.size();i++) {
    		if((mr.customers.get(i).getId()).equals(id.getText())) {
    			name.setText(mr.customers.get(i).getName());
    		    address.setText(mr.customers.get(i).getAddress());
    		    mobile.setText(mr.customers.get(i).getMobile());
    		}   
    	}
    }	
	//////////
    
    // update customer method
    public void updateCustomer(TextField id,TextField name,TextField address,TextField mobile) {
    	for(int i=0; i<mr.customers.size(); i++) {
    		if((mr.customers.get(i).getId()).equals(id.getText())) {
    			mr.customers.get(i).setName(name.getText());
    			mr.customers.get(i).setAddress(address.getText());
    			mr.customers.get(i).setMobile(mobile.getText());
    		}
    	}
    }
    // find media method
    public void findMedia(TextField code, TextField title, TextField numOfCopies,ComboBox<String>cb,TextField rating, TextField artist,TextField songs, TextField weight) {
    	for(int i=0; i<mr.media.size(); i++) {
    		if((mr.media.get(i).getCode()).equals(code.getText())) {
    			title.setText(mr.media.get(i).getTitle());
    			numOfCopies.setText(String.valueOf(mr.media.get(i).getNumOfCopies()));
    			if(mr.media.get(i) instanceof Movie) {
    				cb.setValue("Movie");
    				rating.setText(mr.media.get(i).getRating());
    			}
    				
    			else if(mr.media.get(i) instanceof Album) {
    				cb.setValue("Album");
    				artist.setText(mr.media.get(i).getArtist());
    				songs.setText(mr.media.get(i).getSongs());
    			}
    				
    			else if(mr.media.get(i) instanceof Game) {
    				cb.setValue("Game");
    				weight.setText(String.valueOf(mr.media.get(i).getWeight()));
    			}
    				
    
    		}
    	}
    }
    
    // update media method  numOfCopies
    public void updateMedia(TextField code, TextField title, TextField numOfCopies,ComboBox<String>cb,TextField rating, TextField artist,TextField songs, TextField weight) {
    	for(int i=0; i<mr.media.size(); i++) {
    		if((mr.media.get(i).getCode()).equals(code.getText())) {
    			mr.media.get(i).setTitle(title.getText());
    			mr.media.get(i).setNumOfCopies(Integer.parseInt(numOfCopies.getText()));
    			if(cb.getValue().equals("Movie")) {
    			  ((Movie)mr.media.get(i)).setRating(rating.getText());
    			}
    				
    			else if(cb.getValue().equals("Album")) {
    				((Album)mr.media.get(i)).setArtist(artist.getText());
    				((Album)mr.media.get(i)).setSongs(songs.getText());
    			}
    				
    			else if(cb.getValue().equals("Game")) {
    				((Game)mr.media.get(i)).setWeight(Double.parseDouble(weight.getText()));
    			}
    			  
    		}
    	}
    }
    
    public String displayMediaInfo(TextField code) {
    	Media med = null;
    	String line2 ="";
    	for(int i=0; i<mr.media.size(); i++) {
    		if(mr.media.get(i).getCode().equals(code.getText())) {
    			med = mr.media.get(i);
    		    break;
    		}
    	} 
    	if(med instanceof Movie) {
    		 line2 = "Type: Movie" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Rating: " + med.getRating();
    	}
    	else if(med instanceof Album) {
    		 line2 = "Type: Album" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Artist: " + med.getArtist() + "\n" +
    					    "Songs: "  + med.getSongs();
    	}
    	else if(med instanceof Game) {
    		 line2 = "Type: Game" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Weight: " + med.getWeight();
    	}
    	
    	return line2;
    }
    //////////////////////////
    
    public String displayAllMediaInfo() {
    	Media med = null;
    	String line2 ="";
    	for(int i=0; i<mr.media.size(); i++) {
    		
    		med = mr.media.get(i);
    			if(med instanceof Movie) {
    		 line2 += "Type: Movie" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Rating: " + med.getRating()+ "\n"+"*********"+"\n";
    	}
    	else if(med instanceof Album) {
    		 line2 += "Type: Album" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Artist: " + med.getArtist() + "\n" +
    					    "Songs: "  + med.getSongs() + "\n"+"*********"+"\n";
    	}
    	else if(med instanceof Game) {
    		 line2 += "Type: Game" + "\n" + "Title: " + med.getTitle() + "\n" +
    					    "Number of copies: " + med.getNumOfCopies() + "\n" +
    					    "Weight: " + med.getWeight() + "\n"+"*********"+"\n";
    	}
    		
    			
    		
    	} 
 
    	return line2;
    }
    /////////
    public String displayCustomerInfo(TextField id) {
    	String line ="";
    	for(int i=0; i<mr.customers.size(); i++) {
			if((mr.customers.get(i).getId()).equals(id.getText())) {
				 line = "Name: " + mr.customers.get(i).getName() +"\n" +
			                  "Address: " + mr.customers.get(i).getAddress() +"\n" +
			                  "Mobile Number: " + mr.customers.get(i).getMobile() +"\n" ;
		
			}
		}
    	return line;
    }
    
    ////////////
	public static void main(String[] args) throws FileNotFoundException {
		
		File c2 = new File("customers.txt");
		File m = new File("media.txt");
		File ren = new File("rented.txt");
		File req = new File("requested.txt");
		
		if(c2.exists()) {
			Scanner in = new Scanner(c2);
			while(in.hasNext()) {
				String lin = in.nextLine();
				String[]d = lin.split(",");
				mr.customers.add(new Customer(d[0],d[1],d[2],d[3],d[4]));
				
			}
			
		}
		else
			System.out.println("Error:File not found!"); 

		///////////////////////////////
		if(m.exists()) {
			Scanner in2 = new Scanner(m);
			while(in2.hasNext()) {
				String line = in2.nextLine();
				String[]d2 = line.split(",");
				if(d2[0].equals("Movie"))
					mr.media.add(new Movie(d2[1],d2[2],Integer.parseInt(d2[3]),d2[4]));
				else if(d2[0].equals("Game"))
					mr.media.add(new Game(d2[1],d2[2],Integer.parseInt(d2[3]),Double.parseDouble(d2[4])));
				if(d2[0].equals("Album"))
					mr.media.add(new Album(d2[1],d2[2],Integer.parseInt(d2[3]),d2[4],d2[5]));
			}
			
		}
		else
			System.out.println("Error: File not found!");
		////////////////////////////////
		
		if(req.exists()) {
			Scanner in3 = new Scanner(req);
			while(in3.hasNext()) {
				String lin = in3.nextLine();
				String[]d = lin.split(",");
			    for(int i=0; i<mr.customers.size(); i++) {
			    	if((mr.customers.get(i).getId()).equals(d[0])) {
			    		mr.customers.get(i).getCart().add(d[1]);
			    	}
			    }
				
			}
			
		}
		else
			System.out.println("Error:File not found!");
		//////////////////////////
		if(ren.exists()) {
			Scanner in4 = new Scanner(ren);
			while(in4.hasNext()) {
				String lin = in4.nextLine();
				String[]d = lin.split(",");
			    for(int i=0; i<mr.customers.size(); i++) {
			    	if((mr.customers.get(i).getId()).equals(d[0])) {
			    		mr.customers.get(i).getRented().add(d[1]);
			    	}
			    }
				
			}
			
		}
		else
			System.out.println("Error:File not found!");
	 
	
	/*	for(Media i:media) {
			i.toString();
		}
		System.out.println(media.get(0).code); */
		

		launch(args);
		
	}
}
