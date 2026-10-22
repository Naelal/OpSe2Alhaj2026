package gui;

import java.io.IOException;

import business.Getraenk;
import business.GetraenkModel;
import javafx.stage.Stage;

public class GetraenkeControl {
	
	private GetraenkeView gv; 
	private GetraenkModel gm;
	
	
	
	
	public GetraenkeControl(Stage stage) {
		
		
		gm = new GetraenkModel();
		gv =new GetraenkeView(stage, this, gm);
	}



	public void nehmeGetraenkAuf(){
    	try{ 
    		this.gm.setGetraenk(new Getraenk(
    			gv.getTxtArtikelnummer().getText(), 
   	            Float.parseFloat(gv.getTxtEinkaufspreis().getText()),
   	            Float.parseFloat(gv.getTxtVerkaufspreis().getText()),
   	        	gv.getTxtMitAlkohol().getText(),
    		    gv.getTxtBehaeltnisse().getText().split(";")));
    		gv.zeigeInformationsfensterAn("Das Getraenk wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		gv.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	
	
	
	public void leseAusDatei(String typ){
	    	try {
	    		gm.leseAusDatei(typ);
	      		if("csv".equals(typ)){
	      			
	      	  			gv.zeigeInformationsfensterAn(
	      	  	   			"Der Getraenk wurde gelesen!");
	      		}
	       		else{
		   			gv.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				gv.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				gv.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
	 
	 
	public void schreibeBahnhoefeInCsvDatei() {
			try {
				gm.schreibeBahnhoefeInCsvDatei();
	   			gv.zeigeInformationsfensterAn(
		   			"Die Getraenke wurden gespeichert!");
			}	
			catch(IOException exc){
				gv.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				gv.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

}
