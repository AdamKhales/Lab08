/**
 * Sample Skeleton for 'Lab08FXML.fxml' Controller Class
 */

package com.mycompany.lab08;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Lab08FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="blackBtn"
    private RadioButton blackBtn; // Value injected by FXMLLoader

    @FXML // fx:id="blueBtn"
    private RadioButton blueBtn; // Value injected by FXMLLoader

    @FXML // fx:id="clearBtn"
    private Button clearBtn; // Value injected by FXMLLoader

    @FXML // fx:id="colorToggleGroup"
    private ToggleGroup colorToggleGroup; // Value injected by FXMLLoader

    @FXML // fx:id="drawingAreaPane"
    private Pane drawingAreaPane; // Value injected by FXMLLoader

    @FXML // fx:id="greenBtn"
    private RadioButton greenBtn; // Value injected by FXMLLoader

    @FXML // fx:id="largeBtn"
    private RadioButton largeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="mediumBtn"
    private RadioButton mediumBtn; // Value injected by FXMLLoader

    @FXML // fx:id="redBtn"
    private RadioButton redBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sizeToggleGroup"
    private ToggleGroup sizeToggleGroup; // Value injected by FXMLLoader

    @FXML // fx:id="smallBtn"
    private RadioButton smallBtn; // Value injected by FXMLLoader

    @FXML // fx:id="undoBtn"
    private Button undoBtn; // Value injected by FXMLLoader
    
    @FXML // fx:id="vbox"
    private VBox vbox; // Value injected by FXMLLoader

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Paint) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(event.getX() > drawingAreaPane.getTranslateX() + radius.getRadius()
                && event.getX() + radius.getRadius() < drawingAreaPane.getTranslateX() + drawingAreaPane.getWidth()
                && drawingAreaPane.getTranslateY() + radius.getRadius() < event.getY() 
                && drawingAreaPane.getTranslateY() + drawingAreaPane.getHeight() - radius.getRadius() > event.getY()) {
            
        
        Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(circle);
         }else return;
         
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        if (!drawingAreaPane.getChildren().isEmpty()) {
            drawingAreaPane.getChildren().remove(drawingAreaPane.getChildren().size() - 1);
        } 
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert blackBtn != null : "fx:id=\"blackBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert blueBtn != null : "fx:id=\"blueBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert clearBtn != null : "fx:id=\"clearBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert colorToggleGroup != null : "fx:id=\"colorToggleGroup\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert drawingAreaPane != null : "fx:id=\"drawingAreaPane\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert greenBtn != null : "fx:id=\"greenBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert largeBtn != null : "fx:id=\"largeBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert mediumBtn != null : "fx:id=\"mediumBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert redBtn != null : "fx:id=\"redBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert sizeToggleGroup != null : "fx:id=\"sizeToggleGroup\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert smallBtn != null : "fx:id=\"smallBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        assert undoBtn != null : "fx:id=\"undoBtn\" was not injected: check your FXML file 'Lab08FXML.fxml'.";
        
        blackBtn.setUserData(Color.BLACK);
        redBtn.setUserData(Color.RED);
        greenBtn.setUserData(Color.GREEN);
        blueBtn.setUserData(Color.BLUE);
        smallBtn.setUserData(PenSize.SMALL);
        mediumBtn.setUserData(PenSize.MEDIUM);
        largeBtn.setUserData(PenSize.LARGE);
    }
    
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {
            this.radius = radius;
        }
        public int getRadius() {
            return radius;
        }
    }
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

}
