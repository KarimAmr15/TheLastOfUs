package view;

import java.awt.Point;
import java.io.File;

import view.Controller;

import java.util.ArrayList;

import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import engine.*;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.fxml.FXML;


public class StartMain extends Application implements EventHandler<ActionEvent> {
	
	private Button StartButton;
	private Label gameInfo;
	private Label title;
	private Button ExitButton;
	private Button BillButton;
	private Button DavidButton;
	private Button EllieButton;
	private Button HenryButton;
	private Button JoeButton;
	private Button RileyButton;
	private Button TessButton;
	private Button TommyButton;
	private Label HeroesWindowLabel;
	private Label Bill;
	private Label David;
	private Label Ellie;
	private Label Henry;
	private Label Joe;
	private Label Riley;
	private Label Tess;
	private Label Tommy;
	private Label BillInfo;
	private Label DavidInfo;
	private Label EllieInfo;
	private Label HenryInfo;
	private Label JoeInfo;
	private Label RileyInfo;
	private Label TessInfo;
	private Label TommyInfo;
	private static Stage window;
	private Scene Introwindow;
	private Scene HeroesWindow;
	private Label status;
	private Button up ;
	private Button left ;
	private Button right ;
	private Button down;
	private Button attack ;
	private Button useSpecial ;
	private Button cure ;
	private Button changeHero ;
	private Button endTurn;
	private static Label statusName;
	private Label statusActionsAvailable;
	private Label statusAttackDmg;
	private Label statusCurrentHp;
	private Label statusMaxActions;
	private Label statusMaxHp;
	private Label statusType;
	private static Label statusVaccines;
	private static Label statusSupplies;
	public static  GameView gameView;
	private static GridPane gridPane;
	static int changehero = 0;


	
public void start(Stage primaryStage) throws Exception {
		
	window = primaryStage;
	window.setTitle("THE LAST OF US"); // set title 
	Image backGroundImage = new Image(new File("src/view/TLOU better pic.jpg").toURI().toString());
	ImageView imageView = new ImageView(backGroundImage); // set background
	Image icon = new Image(new File("src/view/TLOU better pic.jpg").toURI().toString());
    primaryStage.getIcons().add(icon); //add icon pic
	
    
    
	StackPane root = new StackPane(imageView);
	
	// create 2 buttons to start and end the game
	StartButton = new Button();
	ExitButton = new Button();
	Image StartImage = new Image(new File("src/view/StartGame.jpeg").toURI().toString());
	Image ExitImage = new Image(new File("src/view/ExitGame.jpeg").toURI().toString());
	ImageView StartImageView = new ImageView(StartImage);
	ImageView ExitImageView = new ImageView(ExitImage);
	StartButton.setGraphic(StartImageView);
	ExitButton.setGraphic(ExitImageView);
	StartImageView.setFitWidth(350);
	StartImageView.setFitHeight(200);
	ExitImageView.setFitWidth(350);
	ExitImageView.setFitHeight(200);
	root.getChildren().add(StartButton);
	root.getChildren().add(ExitButton);
	StackPane.setAlignment(StartButton, Pos.CENTER_LEFT);
	StackPane.setAlignment(ExitButton, Pos.CENTER_LEFT);
	ExitButton.setTranslateX(400);
	
	// close the game when clicked on exit button
	EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() 
	{
        public void handle(ActionEvent event)
        {
        	primaryStage.close();
        }
    };
    ExitButton.setOnAction(eventHandler);
    

    EventHandler<ActionEvent> eventHandler2 = new EventHandler<ActionEvent>() 
    		{
    	        public void handle(ActionEvent event)
    	        {
    	        	primaryStage.setScene(HeroesWindow);
    	        	primaryStage.setMaximized(false);
    	        	
    	            
    	        }
    	    };
    	    StartButton.setOnAction(eventHandler2);
    
	Introwindow = new Scene(root);
	imageView.fitWidthProperty().bind(primaryStage.widthProperty());
       imageView.fitHeightProperty().bind(primaryStage.heightProperty());
       primaryStage.setScene(Introwindow);
       primaryStage.setMaximized(true);
       primaryStage.show();
    
       
       
       
       
    BillButton = new Button();
   	Image BillImage = new Image(new File("src/view/Bill.jpg").toURI().toString());
   	ImageView BillImageView = new ImageView(BillImage);
   	BillButton.setGraphic(BillImageView);
   	BillImageView.setFitWidth(350);
   	BillImageView.setFitHeight(200);
   	BillButton.setTranslateX(-700);
   	BillButton.setTranslateY(-250);
   	
   	
   	DavidButton = new Button();
   	Image DavidImage = new Image(new File("src/view/David.jpg").toURI().toString());
   	ImageView DavidImageView = new ImageView(DavidImage);
   	DavidButton.setGraphic(DavidImageView);
   	DavidImageView.setFitWidth(350);
   	DavidImageView.setFitHeight(200);
   	DavidButton.setTranslateX(-200);
   	DavidButton.setTranslateY(-250);
   	
   	EllieButton = new Button();
   	Image EllieImage = new Image(new File("src/view/Ellie.jpg").toURI().toString());
   	ImageView EllieImageView = new ImageView(EllieImage);
   	EllieButton.setGraphic(EllieImageView);
   	EllieImageView.setFitWidth(350);
   	EllieImageView.setFitHeight(200);
   	EllieButton.setTranslateX(250);
   	EllieButton.setTranslateY(-250);
   	
   	HenryButton = new Button();
   	Image HenryImage = new Image(new File("src/view/Henry.jpg").toURI().toString());
   	ImageView HenryImageView = new ImageView(HenryImage);
   	HenryButton.setGraphic(HenryImageView);
   	HenryImageView.setFitWidth(350);
   	HenryImageView.setFitHeight(200);
   	HenryButton.setTranslateX(700);
   	HenryButton.setTranslateY(-250);
   	
   	JoeButton = new Button();
   	Image JoeImage = new Image(new File("src/view/JoeMiller.jpg").toURI().toString());
   	ImageView JoeImageView = new ImageView(JoeImage);
   	JoeButton.setGraphic(JoeImageView);
   	JoeImageView.setFitWidth(350);
   	JoeImageView.setFitHeight(200);
   	JoeButton.setTranslateX(-700);
   	JoeButton.setTranslateY(100);
   	
   	RileyButton = new Button();
   	Image RileyImage = new Image(new File("src/view/RileyAbel.png").toURI().toString());
   	ImageView RileyImageView = new ImageView(RileyImage);
   	RileyButton.setGraphic(RileyImageView);
   	RileyImageView.setFitWidth(350);
   	RileyImageView.setFitHeight(200);
   	RileyButton.setTranslateX(700);
   	RileyButton.setTranslateY(100);
   	
   	TessButton = new Button();
   	Image TessImage = new Image(new File("src/view/Tess.png").toURI().toString());
   	ImageView TessImageView = new ImageView(TessImage);
   	TessButton.setGraphic(TessImageView);
   	TessImageView.setFitWidth(350);
   	TessImageView.setFitHeight(200);
   	TessButton.setTranslateX(250);
   	TessButton.setTranslateY(100);
   	
   	TommyButton = new Button();
   	Image TommyImage = new Image(new File("src/view/Tommy.jpg").toURI().toString());
   	ImageView TommyImageView = new ImageView(TommyImage);
   	TommyButton.setGraphic(TommyImageView);
   	TommyImageView.setFitWidth(350);
   	TommyImageView.setFitHeight(200);
   	TommyButton.setTranslateX(-200);
   	TommyButton.setTranslateY(100);
 
   	
   	
   	
   	
       
    StackPane pane = new StackPane();
    
    BackgroundImage backgroundImage = new BackgroundImage(
            new javafx.scene.image.Image (new File("src/view/grey BG.jpg").toURI().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));

    pane.setBackground(new Background(backgroundImage));

	HeroesWindowLabel = new Label("Choose A Hero!");
	HeroesWindowLabel.setTranslateY(10);
	HeroesWindowLabel.setFont(Font.font("Impact", FontWeight.MEDIUM, 70));
	HeroesWindowLabel.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(HeroesWindowLabel, Pos.TOP_CENTER);
	
	ScaleTransition transition = new ScaleTransition(Duration.seconds(1), HeroesWindowLabel);
	transition.setToX(1.5);
	transition.setToY(1.5);
	transition.setAutoReverse(true);
	transition.setCycleCount(ScaleTransition.INDEFINITE);
	transition.play();

	Bill = new Label("Bill");
	Bill.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Bill.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Bill, Pos.BOTTOM_CENTER);
	Bill.setTranslateX(-700);
   	Bill.setTranslateY(-600);
	
	David = new Label("David");
	David.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	David.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(David, Pos.BOTTOM_CENTER);
	David.setTranslateX(-200);
   	David.setTranslateY(-600);
	
	Ellie = new Label("Ellie");
	Ellie.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Ellie.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Ellie, Pos.BOTTOM_CENTER);
	Ellie.setTranslateX(250);
   	Ellie.setTranslateY(-600);
	
	Henry = new Label("Henry");
	Henry.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Henry.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Henry, Pos.BOTTOM_CENTER);
	Henry.setTranslateX(700);
   	Henry.setTranslateY(-600);
	
	Joe = new Label("Joe");
	Joe.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Joe.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Joe, Pos.BOTTOM_CENTER);
	Joe.setTranslateX(-700);
   	Joe.setTranslateY(-230);
	
	Riley = new Label("Riley");
	Riley.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Riley.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Riley, Pos.BOTTOM_CENTER);
	Riley.setTranslateX(700);
   	Riley.setTranslateY(-230);
	
	Tess = new Label("Tess");
	Tess.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Tess.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Tess, Pos.BOTTOM_CENTER);
	Tess.setTranslateX(250);
   	Tess.setTranslateY(-230);
	
	Tommy = new Label("Tommy");
	Tommy.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 35));
	Tommy.setStyle("-fx-text-fill: black;");
	StackPane.setAlignment(Tommy, Pos.BOTTOM_CENTER);
	Tommy.setTranslateX(-200);
   	Tommy.setTranslateY(-230);
	
	
	
	
	
	
	
	
	
	
	
	
	BillButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
        
         public void handle(MouseEvent event)
         {
           BillInfo = new Label("Can heal and restore health to other heroes or themselves, \n each process of healing uses 1 supply \n Type: Medic \n Max Hp: 100 \n Max Actions: 7 \n Attack DMG: 10 ");
           pane.getChildren().add(BillInfo);
           BillInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           BillInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(BillInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 BillButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
             BillInfo.setText(" ");
         }
     });
	 
	 
	 DavidButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           DavidInfo = new Label("Can attack as many times in a turn without costing action points \n for 1 turn whenever a supply is used \n Type: Fighter \n Max Hp: 150 \n Max Actions: 4 \n Attack DMG: 35");
           pane.getChildren().add(DavidInfo);
           DavidInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           DavidInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(DavidInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 DavidButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 DavidInfo.setText(" ");
         }
     });
	 
	 EllieButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           EllieInfo = new Label("Can heal and restore health to other heroes or themselves, \n each process of healing uses 1 supply \n Type: Medic \n Max Hp: 110 \n Max Actions: 6 \n Attack DMG: 15 ");
           pane.getChildren().add(EllieInfo);
           EllieInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           EllieInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(EllieInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 EllieButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 EllieInfo.setText(" ");
         }
     });
	
	 HenryButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           HenryInfo = new Label("Can heal and restore health to other heroes or themselves, \n each process of healing uses 1 supply \n Type: Medic \n Max Hp: 105 \n Max Actions: 6 \n Attack DMG: 15 ");
           pane.getChildren().add(HenryInfo);
           HenryInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           HenryInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(HenryInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 HenryButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 HenryInfo.setText(" ");
         }
     });
	 
	 
	 JoeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           JoeInfo = new Label("Can attack as many times in a turn without costing action points \n for 1 turn whenever a supply is used \n Type: Fighter \n Max Hp: 140 \n Max Actions: 5 \n Attack DMG: 30");
           pane.getChildren().add(JoeInfo);
           JoeInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           JoeInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(JoeInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 JoeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 JoeInfo.setText(" ");
         }
     });
	 
	 
	 RileyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           RileyInfo = new Label("Allows the player to be able to see the entirety \n of the map for 1 turn whenever a supply is used \n Type: Explorer \n Max Hp: 90 \n Max Actions: 5 \n Attack DMG: 25 ");
           pane.getChildren().add(RileyInfo);
           RileyInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           RileyInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(RileyInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 RileyButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 RileyInfo.setText(" ");
         }
     });
	 
	 
	 TessButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           TessInfo = new Label("Allows the player to be able to see the entirety \n of the map for 1 turn whenever a supply is used \n Type: Explorer \n Max Hp: 80 \n Max Actions: 6 \n Attack DMG: 20 ");
           pane.getChildren().add(TessInfo);
           TessInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           TessInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(TessInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 TessButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 TessInfo.setText(" ");
         }
     });
	 
	 
	 TommyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        
         public void handle(MouseEvent event)
         {
           TommyInfo = new Label("Allows the player to be able to see the entirety \n of the map for 1 turn whenever a supply is used \n Type: Explorer \n Max Hp: 95 \n Max Actions: 5 \n Attack DMG: 25 ");
           pane.getChildren().add(TommyInfo);
           TommyInfo.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, 25));
           TommyInfo.setStyle("-fx-text-fill: red;");
           StackPane.setAlignment(TommyInfo, Pos.BOTTOM_CENTER);
         }
     });
   
	 TommyButton.setOnMouseExited(new EventHandler<MouseEvent>() {
         
         public void handle(MouseEvent event) {
        	 TommyInfo.setText(" ");
         }
     });
	 
	pane.getChildren().addAll(BillButton , DavidButton , EllieButton , HenryButton , JoeButton  ,RileyButton ,TessButton , TommyButton , HeroesWindowLabel , Bill , David ,Ellie , Henry , Joe , Riley , Tess , Tommy  );
    
    HeroesWindow = new Scene(pane);

    
    
    
    
     gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setHgap(10);
    gridPane.setVgap(10);

     gameView = new GameView();
    gridPane.add(gameView, 0, 0, 15, 15);


     up = new Button("Down  ");
     left = new Button("LEFT");
     right = new Button("RIGHT");
     down = new Button("Up");
     attack = new Button("Attack");
     useSpecial = new Button("Use Special");
     cure = new Button("Cure");
     changeHero = new Button("Change Hero");
     endTurn = new Button("End Turn");
     statusName = new Label("Name: ");
     statusActionsAvailable = new Label("Actions Available: ");
     statusAttackDmg = new Label("Attack DMG: ");
     statusCurrentHp = new Label("Current HP: ");
     statusMaxActions = new Label("Max Actions: ");
     statusMaxHp = new Label("Max HP: ");
     gameInfo = new Label("hero block: red " + "\n" + "zombie block: blue" + "\n" + "vaccine block: green" + "\n" + "supply block: yellow");
     title = new Label("GAME INFO");
     
    

    gridPane.add(up, 25, 2);
    gridPane.add(left, 22, 1);
    gridPane.add(right, 25, 1);
    right.setTranslateX(80);
    gridPane.add(down, 25, 0);
    gridPane.add(attack, 40, 0);
    gridPane.add(useSpecial, 42, 0);
    gridPane.add(cure, 40, 2);
    gridPane.add(changeHero , 42 , 2);
    gridPane.add(endTurn , 44 , 0);
    gridPane.add(title , 42 , 11);
    gridPane.add(gameInfo , 42 , 12);
    
    
   
    Scene scene = new Scene(gridPane);
  
    
    
    
    EventHandler<ActionEvent> eventHandler3 = new EventHandler<ActionEvent>() 
    		{
    	        public void handle(ActionEvent event)
    	        {
    	        	primaryStage.setScene(scene);
    	        	primaryStage.setMaximized(false);
    	        	Medic bill = new Medic("Bill" , 100 , 10 , 7);
    	        	Game.availableHeroes.add(bill);
    	        	Game.startGame(bill);
    	        	stats(bill);
    	        	
    	        }
    	    };
    	    

    	    BillButton.setOnAction(eventHandler3);
    	    
    	    EventHandler<ActionEvent> eventHandler4 = new EventHandler<ActionEvent>() 
    	    		{
    	    	        public void handle(ActionEvent event)
    	    	        {
    	    	        	primaryStage.setScene(scene);
    	    	        	primaryStage.setMaximized(false);
    	    	        	
    	    	        	Fighter david = new Fighter("David" , 150 , 35 , 4);
    	    	        	Game.availableHeroes.add(david);
    	    	        	Game.startGame(david);
    	    	        	stats(david);
    	    	        	
    	    	        	
    	    	        	
    	    	        	
    	    	            
    	    	        }
    	    	    };

    	    	    DavidButton.setOnAction(eventHandler4);
    	 
    	    	    EventHandler<ActionEvent> eventHandler5 = new EventHandler<ActionEvent>() 
    	    	    		{
    	    	    	        public void handle(ActionEvent event)
    	    	    	        {
    	    	    	        	primaryStage.setScene(scene);
    	    	    	        	primaryStage.setMaximized(false);
    	    	    	        	
    	    	    	        	Medic Ellie = new Medic("Ellie" , 110 , 15 , 6);
    	    	    	        	Game.availableHeroes.add(Ellie);
    	    	    	        	Game.startGame(Ellie);
    	    	    	        	stats(Ellie);
    	    	    	        	
    	    	    	            
    	    	    	        }
    	    	    	    };

    	    	    	    EllieButton.setOnAction(eventHandler5);
    	    	    	    EventHandler<ActionEvent> eventHandler6 = new EventHandler<ActionEvent>() 
    	    	    	    		{
    	    	    	    	        public void handle(ActionEvent event)
    	    	    	    	        {
    	    	    	    	        	primaryStage.setScene(scene);
    	    	    	    	        	primaryStage.setMaximized(false);
    	    	    	    	        	
    	    	    	    	        	Medic henry = new Medic("Henry" , 105 , 15 ,6);
    	    	    	    	        	Game.availableHeroes.add(henry);
    	    	    	    	        	Game.startGame(henry);
    	    	    	    	        	stats(henry);
    	    	    	    	        	
    	    	    	    	        	
    	    	    	    	        }
    	    	    	    	    };

    	    	    	    	    HenryButton.setOnAction(eventHandler6);
    	    	    	    	    EventHandler<ActionEvent> eventHandler7 = new EventHandler<ActionEvent>() 
    	    	    	    	    		{
    	    	    	    	    	        public void handle(ActionEvent event)
    	    	    	    	    	        {
    	    	    	    	    	        	primaryStage.setScene(scene);
    	    	    	    	    	        	primaryStage.setMaximized(false);
    	    	    	    	    	        	
    	    	    	    	    	        	Fighter joe = new Fighter("Joe" , 140 , 30 , 5);
    	    	    	    	    	        	Game.availableHeroes.add(joe);
    	    	    	    	    	        	Game.startGame(joe);
    	    	    	    	    	        	stats(joe);
    	    	    	    	    	        	
    	    	    	    	    	        	
    	    	    	    	    	        }
    	    	    	    	    	    };

    	    	    	    	    	    JoeButton.setOnAction(eventHandler7);
    	    	    	    	    	    EventHandler<ActionEvent> eventHandler8 = new EventHandler<ActionEvent>() 
    	    	    	    	    	    		{
    	    	    	    	    	    	        public void handle(ActionEvent event)
    	    	    	    	    	    	        {
    	    	    	    	    	    	        	primaryStage.setScene(scene);
    	    	    	    	    	    	        	primaryStage.setMaximized(false);
    	    	    	    	    	    	        	
    	    	    	    	    	    	        	Explorer riley = new Explorer("Riley" , 90 , 25 ,5);
    	    	    	    	    	    	        	Game.availableHeroes.add(riley);
    	    	    	    	    	    	        	Game.startGame(riley);
    	    	    	    	    	    	        	stats(riley);
    	    	    	    	    	    	        	
    	    	    	    	    	    	        	
    	    	    	    	    	    	        }
    	    	    	    	    	    	    };

    	    	    	    	    	    	    RileyButton.setOnAction(eventHandler8);
    	    	    	    	    	    	    EventHandler<ActionEvent> eventHandler9 = new EventHandler<ActionEvent>() 
    	    	    	    	    	    	    		{
    	    	    	    	    	    	    	        public void handle(ActionEvent event)
    	    	    	    	    	    	    	        {
    	    	    	    	    	    	    	        	primaryStage.setScene(scene);
    	    	    	    	    	    	    	        	primaryStage.setMaximized(false);
    	    	    	    	    	    	    	        	
    	    	    	    	    	    	    	        	Explorer tess = new Explorer("Tess" , 80 , 20 ,6);
    	    	    	    	    	    	    	        	Game.availableHeroes.add(tess);
    	    	    	    	    	    	    	        	Game.startGame(tess);
    	    	    	    	    	    	    	        	stats(tess);
    	    	    	    	    	    	    	        	
    	    	    	    	    	    	    	        	
    	    	    	    	    	    	    	        }
    	    	    	    	    	    	    	    };

    	    	    	    	    	    	    	    TessButton.setOnAction(eventHandler9);
    	    	    	    	    	    	    	    EventHandler<ActionEvent> eventHandler10 = new EventHandler<ActionEvent>() 
    	    	    	    	    	    	    	    		{
    	    	    	    	    	    	    	    	        public void handle(ActionEvent event)
    	    	    	    	    	    	    	    	        {
    	    	    	    	    	    	    	    	        	primaryStage.setScene(scene);
    	    	    	    	    	    	    	    	        	primaryStage.setMaximized(false);
    	    	    	    	    	    	    	    	        	
    	    	    	    	    	    	    	    	        	Explorer tommy = new Explorer("Tommy" , 95 , 25 ,5);
    	    	    	    	    	    	    	    	        	Game.availableHeroes.add(tommy);
    	    	    	    	    	    	    	    	        	Game.startGame(tommy);
    	    	    	    	    	    	    	    	        	stats(tommy);
    	    	    	    	    	    	    	    	        	
    	    	    	    	    	    	    	    	        	
 
    	    	    	    	    	    	    	    	        }
    	    	    	    	    	    	    	    	    };

    	    	    	    	    	    	    	    	    TommyButton.setOnAction(eventHandler10);
    	    
    	    
    	    
    	    up.setOnAction(Controller.eventHandlerUP);
    	    down.setOnAction(Controller.eventHandlerDOWN);
    	    right.setOnAction(Controller.eventHandlerRIGHT);
    	    left.setOnAction(Controller.eventHandlerLEFT);
    	    attack.setOnAction(Controller.eventHandlerATTACK);
    	    cure.setOnAction(Controller.eventHandlerCURE);
    	    changeHero.setOnAction(Controller.eventHandlerCHANGEHERO);
    	    useSpecial.setOnAction(Controller.eventHandlerUSESPECIAL);
    	    endTurn.setOnAction(Controller.eventHandlerENDTURN);
    	    
  
    	    
	}


private static Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
            return node;
        }
    }
    return null;
}

	public static void stats(Hero h)
	{
    	int row = (int) Game.map.length -1;
    	int col = (int) h.getLocation().getY();
    	Button cell = (Button) getNodeByRowColumnIndex(row,col, gameView);
        cell.setStyle("-fx-background-color: red");
    	try{
    		if(h.getCurrentHp() > 0){
    	Controller.handleButton(h.getName() , h.getActionsAvailable() , h.getAttackDmg() , h.getCurrentHp() , h.getMaxActions() , h.getMaxHp());
    	gridPane.add(statusName ,25 , 10 );
    	statusName.setFont(new Font(20));}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	if (h.getCurrentHp() > 0){
    	statusVaccines = new Label("Vaccines Available: " + h.getVaccineInventory().size());
    	gridPane.add(statusVaccines , 25 , 11);
    	statusVaccines.setFont(new Font(20));
        statusSupplies = new Label("Supplies Available: " + h.getSupplyInventory().size());
        gridPane.add(statusSupplies , 25 , 12);
    	statusSupplies.setFont(new Font(20));}
    	
	}

	
	public static void updateStats(Hero h)
	{
		
		try{
    		if(h.getCurrentHp() > 0){
    	Controller.updateHandleButton(h.getName() , h.getActionsAvailable() , h.getAttackDmg() , h.getCurrentHp() , h.getMaxActions() , h.getMaxHp());
    	
    	statusName.setFont(new Font(20));}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		if (h.getCurrentHp() > 0){
	    	
	    	statusVaccines.setText("Vaccines Available: " + h.getVaccineInventory().size());
	        statusSupplies.setText("Supplies Available: " + h.getSupplyInventory().size());
		}

		
	}
	
	

	public void handle(ActionEvent event) 
	{
		
	}
	
	public Scene getIntroWindow()
	{
		return Introwindow;
	}
	public Button getUP()
	{
		return up;
	}
	
	public static void mainMethod (String [] args)
	{
		new StartMain();
	}

	public static void checkwin()
	  {
		  if(Game.checkWin() == true)
		  {
			  Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText(null);
		        alert.setContentText("You have Won!");

		        alert.showAndWait();


		        window.close();
		  }
	  }
			
	public static void checkgameover()
	{
		if(Game.checkGameOver() == true)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("game over you have lost");

	        alert.showAndWait();

	        window.close();
		}
	}
	
	
	public static void update()
	{
		
		for (int i = 0 ; i < Game.map.length ; i++){
			for ( int j = 0 ; j < Game.map.length ; j++){
				
				if (Game.map[i][j].isVisible() == true)
				{
					if (Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() != null && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero)
					{
						Button cell = (Button) getNodeByRowColumnIndex(i,j, gameView);
				        cell.setStyle("-fx-background-color: red");
					}
					
					if (Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() != null && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie)
					{
						Button cell = (Button) getNodeByRowColumnIndex(i,j, gameView);
				        cell.setStyle("-fx-background-color: blue");
					}
					
					if (Game.map[i][j] instanceof CollectibleCell && ((CollectibleCell) Game.map[i][j]).getCollectible() != null && ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine)
					{
						
						Button cell = (Button) getNodeByRowColumnIndex(i,j, gameView);
				        cell.setStyle("-fx-background-color: green");
					}
					
					if (Game.map[i][j] instanceof CollectibleCell && ((CollectibleCell) Game.map[i][j]).getCollectible() != null && ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply)
					{
						
						Button cell = (Button) getNodeByRowColumnIndex(i,j, gameView);
				        cell.setStyle("-fx-background-color: yellow");
					}
					
					if (Game.map[i][j] instanceof TrapCell )
					{
						
						Button cell = (Button) getNodeByRowColumnIndex(i,j, gameView);
				        cell.setStyle("-fx-background-color: grey");
					} 
					
					
					
					
					
				}
				
			}
		}
		
	}
	
	
	
	
public static void main(String [] args){
		
		launch(args);
	}



public static Label getStatusName() {
	return statusName;
}



public void setStatusName(Label statusName) {
	this.statusName = statusName;
}
	
	
	





}


