package view;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import engine.Game;
import model.characters.*;
import model.collectibles.*;
import model.world.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameView extends GridPane {
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLS = 15;
    private static final int CELL_SIZE = 50;
    private static final int CELL_SPACING = 5;
    public static Cell[][] map;

    public GameView() {
        map = Game.map;
        setHgap(CELL_SPACING);
        setVgap(CELL_SPACING);
        setPadding(new Insets(CELL_SPACING));

        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                Button cellButton = createCellButton(row, col);
                add(cellButton, col, row, 1, 1);
            }
        }
    }

    private Button createCellButton(int row, int col) {
        Cell cell = map[row][col];

        Button button = new Button();
        button.setPrefSize(CELL_SIZE, CELL_SIZE);
        button.setBackground(new Background(new BackgroundFill(getColorForCell(cell), CornerRadii.EMPTY, Insets.EMPTY)));
        button.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
               
                handleCellButtonClick(row, col);
            }
        });

        return button;
    }

    public Color getColorForCell(Cell cell) {
        if (cell instanceof CharacterCell) {
            CharacterCell characterCell = (CharacterCell) cell;
            if (characterCell.getCharacter() == null) {
                return Color.LIGHTGRAY; // Empty cell
            } else if (characterCell.getCharacter() instanceof Zombie) {
                return Color.RED; // Zombie cell
            } else if (characterCell.getCharacter() instanceof Hero) {
            	
                return Color.BLUE; // Hero cell
            }
        } else if (cell instanceof CollectibleCell) {
            CollectibleCell collectibleCell = (CollectibleCell) cell;
            if (collectibleCell.getCollectible() instanceof Vaccine) {
                return Color.GREEN; // Vaccine cell
            } else if (collectibleCell.getCollectible() instanceof Supply) {
                return Color.YELLOW; // Supply cell
            }
        } else if (cell instanceof TrapCell) {
            return Color.LIGHTGRAY; // Trap cell
        }

        return Color.LIGHTGRAY; // Default empty cell
    }

    

    private void handleCellButtonClick(int row, int col) {
    			if (Game.map[row][col] instanceof CharacterCell)
    			{
    				if (((CharacterCell) Game.map[row][col]).getCharacter() != null) 
    					Game.heroes.get(0).setTarget(((CharacterCell) Game.map[row][col]).getCharacter());
    			
    				
    				
    			}
    				
    	
    }
}