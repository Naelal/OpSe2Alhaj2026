package gui;

import business.GetraenkModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;
public class GetraenkeView {
	
	
	private GetraenkeControl gc; 
	private GetraenkModel gm; 
	
	private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 			= new Label("Artikelnummer:");
    private Label lblEinkaufspreis   		= new Label("Einkaufspreis:");
    private Label lblVerkaufspreis  	 	= new Label("Verkaufspreis:");
    private Label lblMitAlkohol   			= new Label("mit Alkohol:");
    private Label lblBehaeltnisse  			= new Label("Behaeltnisse:");
    private TextField txtArtikelnummer 	 	= new TextField();
    private TextField txtEinkaufspreis		= new TextField();
    private TextField txtVerkaufspreis		= new TextField();
    private TextField txtMitAlkohol			= new TextField();
    private TextField txtBehaeltnisse	 	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    

    
    
    public GetraenkeView(Stage primaryStage , GetraenkeControl gc, GetraenkModel gm){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung eines Getraenkemarktes");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
		this.gc= gc; 
		this.gm = gm; 
		
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;");  
       	lblArtikelnummer.setLayoutX(20);
    	lblArtikelnummer.setLayoutY(90);
    	lblEinkaufspreis.setLayoutX(20);
    	lblEinkaufspreis.setLayoutY(130);
    	lblVerkaufspreis.setLayoutX(20);
    	lblVerkaufspreis.setLayoutY(170);
    	lblMitAlkohol.setLayoutX(20);
    	lblMitAlkohol.setLayoutY(210);
    	lblBehaeltnisse.setLayoutX(20);
    	lblBehaeltnisse.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblArtikelnummer, lblEinkaufspreis, lblVerkaufspreis,
       		lblMitAlkohol, lblBehaeltnisse);
    
    	// Textfelder
     	txtArtikelnummer.setLayoutX(170);
    	txtArtikelnummer.setLayoutY(90);
    	txtArtikelnummer.setPrefWidth(200);
    	txtEinkaufspreis.setLayoutX(170);
    	txtEinkaufspreis.setLayoutY(130);
    	txtEinkaufspreis.setPrefWidth(200);
    	txtVerkaufspreis.setLayoutX(170);
    	txtVerkaufspreis.setLayoutY(170);
    	txtVerkaufspreis.setPrefWidth(200);
      	txtMitAlkohol.setLayoutX(170);
    	txtMitAlkohol.setLayoutY(210);
    	txtMitAlkohol.setPrefWidth(200);
    	txtBehaeltnisse.setLayoutX(170);
    	txtBehaeltnisse.setLayoutY(250);
    	txtBehaeltnisse.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtArtikelnummer, txtEinkaufspreis, txtVerkaufspreis,
     		txtMitAlkohol, txtBehaeltnisse);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    gc.nehmeGetraenkAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBahnhoefeAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	gc.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	gc.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gc.schreibeBahnhoefeInCsvDatei();
			}	
	    });
    }
   
   public GetraenkeControl getGc() {
	return gc;
}

   public void setGc(GetraenkeControl gc) {
	this.gc = gc;
   }

   public GetraenkModel getGm() {
	return gm;
   }

   public void setGm(GetraenkModel gm) {
	this.gm = gm;
   }

   public Pane getPane() {
	return pane;
   }

   public void setPane(Pane pane) {
	this.pane = pane;
   }

   public Label getLblEingabe() {
	return lblEingabe;
   }

   public void setLblEingabe(Label lblEingabe) {
	this.lblEingabe = lblEingabe;
   }

   public Label getLblAnzeige() {
	return lblAnzeige;
   }

   public void setLblAnzeige(Label lblAnzeige) {
	this.lblAnzeige = lblAnzeige;
   }

   public Label getLblArtikelnummer() {
	return lblArtikelnummer;
   }

   public void setLblArtikelnummer(Label lblArtikelnummer) {
	this.lblArtikelnummer = lblArtikelnummer;
   }

   public Label getLblEinkaufspreis() {
	return lblEinkaufspreis;
   }

   public void setLblEinkaufspreis(Label lblEinkaufspreis) {
	this.lblEinkaufspreis = lblEinkaufspreis;
   }

   public Label getLblVerkaufspreis() {
	return lblVerkaufspreis;
   }

   public void setLblVerkaufspreis(Label lblVerkaufspreis) {
	this.lblVerkaufspreis = lblVerkaufspreis;
   }

   public Label getLblMitAlkohol() {
	return lblMitAlkohol;
   }

   public void setLblMitAlkohol(Label lblMitAlkohol) {
	this.lblMitAlkohol = lblMitAlkohol;
   }

   public Label getLblBehaeltnisse() {
	return lblBehaeltnisse;
   }

   public void setLblBehaeltnisse(Label lblBehaeltnisse) {
	this.lblBehaeltnisse = lblBehaeltnisse;
   }

   public TextField getTxtArtikelnummer() {
	return txtArtikelnummer;
   }

   public void setTxtArtikelnummer(TextField txtArtikelnummer) {
	this.txtArtikelnummer = txtArtikelnummer;
   }

   public TextField getTxtEinkaufspreis() {
	return txtEinkaufspreis;
   }

   public void setTxtEinkaufspreis(TextField txtEinkaufspreis) {
	this.txtEinkaufspreis = txtEinkaufspreis;
   }

   public TextField getTxtVerkaufspreis() {
	return txtVerkaufspreis;
   }

   public void setTxtVerkaufspreis(TextField txtVerkaufspreis) {
	this.txtVerkaufspreis = txtVerkaufspreis;
   }

   public TextField getTxtMitAlkohol() {
	return txtMitAlkohol;
   }

   public void setTxtMitAlkohol(TextField txtMitAlkohol) {
	this.txtMitAlkohol = txtMitAlkohol;
   }

   public TextField getTxtBehaeltnisse() {
	return txtBehaeltnisse;
   }

   public void setTxtBehaeltnisse(TextField txtBehaeltnisse) {
	this.txtBehaeltnisse = txtBehaeltnisse;
   }

   public TextArea getTxtAnzeige() {
	return txtAnzeige;
   }

   public void setTxtAnzeige(TextArea txtAnzeige) {
	this.txtAnzeige = txtAnzeige;
   }

   public Button getBtnEingabe() {
	return btnEingabe;
   }

   public void setBtnEingabe(Button btnEingabe) {
	this.btnEingabe = btnEingabe;
   }

   public Button getBtnAnzeige() {
	return btnAnzeige;
   }

   public void setBtnAnzeige(Button btnAnzeige) {
	this.btnAnzeige = btnAnzeige;
   }

   public MenuBar getMnbrMenuLeiste() {
	return mnbrMenuLeiste;
   }

   public void setMnbrMenuLeiste(MenuBar mnbrMenuLeiste) {
	this.mnbrMenuLeiste = mnbrMenuLeiste;
   }

   public Menu getMnDatei() {
	return mnDatei;
   }

   public void setMnDatei(Menu mnDatei) {
	this.mnDatei = mnDatei;
   }

   public MenuItem getMnItmCsvImport() {
	return mnItmCsvImport;
   }

   public void setMnItmCsvImport(MenuItem mnItmCsvImport) {
	this.mnItmCsvImport = mnItmCsvImport;
   }

   public MenuItem getMnItmTxtImport() {
	return mnItmTxtImport;
   }

   public void setMnItmTxtImport(MenuItem mnItmTxtImport) {
	this.mnItmTxtImport = mnItmTxtImport;
   }

   public MenuItem getMnItmCsvExport() {
	return mnItmCsvExport;
   }

   public void setMnItmCsvExport(MenuItem mnItmCsvExport) {
	this.mnItmCsvExport = mnItmCsvExport;
   }

   private void zeigeBahnhoefeAn(){
   	if(this.gm.getGetraenk() != null){
   		txtAnzeige.setText(
   			this.gm.getGetraenk().gibGetraenkZurueck(' '));
   	}
   	else{
   		zeigeInformationsfensterAn("Bisher wurde keine Getraenk aufgenommen!");
   	}
   }    
   
   
   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
}
