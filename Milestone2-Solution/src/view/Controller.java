package view;

import model.characters.Direction;
import javafx.scene.Parent;
import javafx.scene.Node;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.world.CharacterCell;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.StartMain;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.Light.Point;

public class Controller {
	
	
	public static String type;
    
    static EventHandler<ActionEvent> eventHandlerUP = new EventHandler<ActionEvent>() 
    		{
    	        public void handle(ActionEvent event)
    	        {
    	        	try {
    	                Game.heroes.get(StartMain.changehero).move(Direction.UP);
    	            } catch (MovementException e) {
    	            	Alert alert = new Alert(Alert.AlertType.ERROR);
    	                alert.setTitle("Error");
    	                alert.setHeaderText(null);
    	                alert.setContentText("Can't move here");
    	                alert.showAndWait();
    	            } catch (NotEnoughActionsException e) {
    	            	Alert alert = new Alert(Alert.AlertType.ERROR);
    	                alert.setTitle("Error");
    	                alert.setHeaderText(null);
    	                alert.setContentText("Not enough actions");
    	                alert.showAndWait();
    	            }
    	            
    	            StartMain.updateStats(Game.heroes.get(StartMain.changehero));
    	            StartMain.checkgameover();
    	            StartMain.checkwin();
    	            StartMain.update();
    	            
    	            
    	        	
    	        	
    	        	
    	        	
    	        	
    	        }
    	    };
    	    
    static EventHandler<ActionEvent> eventHandlerDOWN = new EventHandler<ActionEvent>() 
    		{
    	    	public void handle(ActionEvent event)
    	    	{
       	        	try {
    						Game.heroes.get(StartMain.changehero).move(Direction.DOWN);
    					} catch (MovementException e) {
    						Alert alert = new Alert(Alert.AlertType.ERROR);
    				        alert.setTitle("Error");
    				        alert.setHeaderText(null);
    				        alert.setContentText("Can't move here");

    					} catch (NotEnoughActionsException e) {
    						Alert alert = new Alert(Alert.AlertType.ERROR);
    				        alert.setTitle("Error");
    				        alert.setHeaderText(null);
    				        alert.setContentText("Not enough actions");

    					}	    	        	
       	        	StartMain.updateStats(Game.heroes.get(StartMain.changehero));
       	        	StartMain.checkgameover();
    	            StartMain.checkwin();
    	            StartMain.update();
    	    	}
    	    };
    	    
    	  
    static EventHandler<ActionEvent> eventHandlerRIGHT = new EventHandler<ActionEvent>() 
    	    {
    	    	public void handle(ActionEvent event)
    	    	{
       	        	try {
       	        		Game.heroes.get(StartMain.changehero).move(Direction.RIGHT);
    					} catch (MovementException e) {
    						Alert alert = new Alert(Alert.AlertType.ERROR);
        	                alert.setTitle("Error");
        	                alert.setHeaderText(null);
        	                alert.setContentText("Can't move here");
        	                alert.showAndWait();

    					} catch (NotEnoughActionsException e) {
    						Alert alert = new Alert(Alert.AlertType.ERROR);
        	                alert.setTitle("Error");
        	                alert.setHeaderText(null);
        	                alert.setContentText("Not enough actions");
        	                alert.showAndWait();

    					}   	
       	        	StartMain.updateStats(Game.heroes.get(StartMain.changehero)); 
       	        	StartMain.checkgameover();
    	            StartMain.checkwin();
    	            StartMain.update();
    	    	 }
    	    };
    	    	    	    
   static EventHandler<ActionEvent> eventHandlerLEFT = new EventHandler<ActionEvent>() 
    	  {
    	  	public void handle(ActionEvent event)
    	    {
   	        	try {
						Game.heroes.get(StartMain.changehero).move(Direction.LEFT);
					} catch (MovementException e) {
						Alert alert = new Alert(Alert.AlertType.ERROR);
    	                alert.setTitle("Error");
    	                alert.setHeaderText(null);
    	                alert.setContentText("Can't move here");
    	                alert.showAndWait();

					} catch (NotEnoughActionsException e) {
						Alert alert = new Alert(Alert.AlertType.ERROR);
    	                alert.setTitle("Error");
    	                alert.setHeaderText(null);
    	                alert.setContentText("Not enough actions");
    	                alert.showAndWait();

					}      	
   	        	StartMain.updateStats(Game.heroes.get(StartMain.changehero));  	
   	        	StartMain.checkgameover();
	            StartMain.checkwin();
	            StartMain.update();
    	    }
    	  };
    	  
   static EventHandler<ActionEvent> eventHandlerATTACK = new EventHandler<ActionEvent>() 
    	  {
    		public void handle(ActionEvent event)
    		{
    			
    			try {
					Game.heroes.get(StartMain.changehero).attack();
				} catch (NotEnoughActionsException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("Not enough actions");
	                alert.showAndWait();
				} catch (InvalidTargetException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("invalid target");
	                alert.showAndWait();
				}
    			
    			StartMain.updateStats(Game.heroes.get(StartMain.changehero));
    			StartMain.checkgameover();
	            StartMain.checkwin();
    	    	    	    	    	        	
    		}
    	  };
	
   static EventHandler<ActionEvent> eventHandlerCURE = new EventHandler<ActionEvent>() 
    	  {
    	  	public void handle(ActionEvent event)
    	    {
    	     	try {
					Game.heroes.get(StartMain.changehero).cure();
				} catch (NoAvailableResourcesException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("No available resources");
	                alert.showAndWait();
				} catch (InvalidTargetException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("invalid target");
	                alert.showAndWait();
				} catch (NotEnoughActionsException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("Not enough actions");
	                alert.showAndWait();
				}        	
    	     	StartMain.updateStats(Game.heroes.get(StartMain.changehero));   
    	     	StartMain.checkgameover();
	            StartMain.checkwin();
    	     }
    	  };
  static EventHandler<ActionEvent> eventHandlerUSESPECIAL = new EventHandler<ActionEvent>() 
    	 {
    	 	public void handle(ActionEvent event)
    	 	{
    	 		try {
					Game.heroes.get(StartMain.changehero).useSpecial();
				} catch (NoAvailableResourcesException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("No available resources");
	                alert.showAndWait();
				} catch (InvalidTargetException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("invalid target");
	                alert.showAndWait();
				}
    	 		catch(Exception e){
    	 			e.printStackTrace();
    	 		}
    	 		StartMain.updateStats(Game.heroes.get(StartMain.changehero));
    	 		StartMain.checkgameover();
	            StartMain.checkwin();
    	    }
    	 };
 static EventHandler<ActionEvent> eventHandlerCHANGEHERO = new EventHandler<ActionEvent>() 
    	{
    		public void handle(ActionEvent event)
    	    {
    			int num = 0;
    			if(Game.heroes.get(0) != null)
    				num++;
    			if(Game.heroes.get(1)!= null)
    				num++;
    			if(Game.heroes.get(2)!= null)
    				num++;
    			if(Game.heroes.get(3)!= null)
    				num++;
    			if(Game.heroes.get(4)!= null)
    				num++;
    			
    			
    	    	if (StartMain.changehero < num)
    	    		StartMain.changehero++;
    	    	else
    	    		if(StartMain.changehero == num)
    	    		StartMain.changehero = 0;
    	    	
    	    	StartMain.updateStats(Game.heroes.get(StartMain.changehero));
    			
    			
    	    }
    	};
    	
 static EventHandler<ActionEvent> eventHandlerENDTURN = new EventHandler<ActionEvent>() 
		 {
    		public void handle(ActionEvent event)
    		{
    		    try {
					Game.endTurn();
				} catch (NotEnoughActionsException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("Not enough actions");
	                alert.showAndWait();
				} catch (InvalidTargetException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText(null);
	                alert.setContentText("invalid target");
	                alert.showAndWait();
				}    	        	
    		    StartMain.updateStats(Game.heroes.get(StartMain.changehero)); 
    		    StartMain.checkgameover();
	            StartMain.checkwin();
    		}
		 };    	
    	
	    	    

   public static  void handleButton(String name , int actionsAvailable , int attackDMG , int currentHp , int maxActions , int maxHp)
   {
	   
	   
	   if (Game.heroes.get(StartMain.changehero) instanceof Fighter)
		   type = "Type: Fighter";
	   if (Game.heroes.get(StartMain.changehero) instanceof Medic)
		   type = "Type: Medic";
	   if (Game.heroes.get(StartMain.changehero) instanceof Explorer)
		   type = "Type: Fighter";
	     
	   
	   
	   StartMain.getStatusName().setText(type + "\n" + "Name: " + name + "\n" + "Actions Available: " + actionsAvailable + "\n" + "Attack DMG: " + attackDMG + "\n" + "Current HP: " + currentHp + "\n" + "Max Actions: " + maxActions + "\n" + "Max HP: " + maxHp ) ;
	   
   }

   public static void updateHandleButton(String name , int actionsAvailable , int attackDMG , int currentHp , int maxActions , int maxHp)	     	    
   {
	   StartMain.getStatusName().setText(type + "\n" +"Name: " + name + "\n" + "Actions Available: " + actionsAvailable  + "\n" + "Attack DMG: " + attackDMG + "\n" + "Current HP: " + currentHp + "\n" + "Max Actions: " + maxActions + "\n" + "Max HP: " + maxHp ) ;
   }
	
 
}
