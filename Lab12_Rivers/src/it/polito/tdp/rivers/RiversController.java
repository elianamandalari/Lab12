package it.polito.tdp.rivers;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.ResourceBundle;
import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Simulator;
import it.polito.tdp.rivers.model.Statistiche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

	public class RiversController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<River> boxRiver;

	    @FXML
	    private TextField txtStartDate;

	    @FXML
	    private TextField txtEndDate;

	    @FXML
	    private TextField txtNumMeasurements;

	    @FXML
	    private TextField txtFMed;

	    @FXML
	    private TextField txtK;

	    @FXML
	    private Button btnSimula;

	    @FXML
	    private TextArea txtResult;
	    
	    Model model;
	    Simulator simulator;
	    
	    float flussoMedio=0;
		public void setModel(Model model) {
			this.model=model;
			boxRiver.getItems().addAll(this.model.getAllRivers());
		}
		
		 @FXML
		public void riempiCampi(){
			txtStartDate.clear();
			txtEndDate.clear();
			txtNumMeasurements.clear();
			txtFMed.clear();
			River river=boxRiver.getValue();
			this.model.getAllFlows(river);
			List<Flow> flows=this.model.getAllFlows(river);
			LocalDate dataFirst=this.model.getDataFirst(river);
		    LocalDate dataLast=this.model.getDataLast(river);
		    int numeroTotMisurazioni=flows.size();
		    flussoMedio=this.model.getFlussoMedio(river);
		    
		    txtStartDate.setText(dataFirst.toString());
		    txtEndDate.setText(dataLast.toString());
		    txtNumMeasurements.setText(""+numeroTotMisurazioni);
		    txtFMed.setText(""+flussoMedio);
		    
		    
		}
		 
		 @FXML
		public void doSimula(){
			River river=boxRiver.getValue();
		  if(river!=null){
			int fattoreScala=Integer.parseInt(txtK.getText());
			
			Statistiche statistiche=this.model.getStatistiche(fattoreScala,river);
		
			
			   if(fattoreScala>0){
					
				txtResult.appendText("Numero di giorni in cui non si è potuta garantire l'erogazione minima "+statistiche.getNumeroTotGiorniInsoddisfatti()+"\n"+"Occupazione media del bacino nel corso della simulazione "+statistiche.getOccupazioneTotale()/statistiche.getTotaleGiorni()+"\n");
			}
			else{
				txtResult.appendText("Hai inserito un fattore di scala k="+fattoreScala+" negativo");
			}
			}
			else{
				txtResult.appendText("Non hai scelto nessun fiume dal menù");
			}
		}
		
			
			
			
			
			
			
	    @FXML
	    void initialize() {
	        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

	    }
	}


