/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HanWang
 */
public class SecondController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private Pane smokerA;
    @FXML private Pane smokerB;
    @FXML private Pane smokerC;
    @FXML private Pane ma_1;
    @FXML private Pane ma_2;
    @FXML private Pane ma_3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movesmoker(3);
 
        
        
    
    }
    
    public void clicke(MouseEvent event){
        movematerial(3,2);
    }
    
    public void movematerial(int id1,int id2){
        Line line1 = new Line(153, 30, 554.5, 30);
        Line line2 = new Line(153, 30, 554.5, 30);
        PathTransition transition = new PathTransition();
        switch(id1){
            case 1:
                transition.setNode(ma_1);
                break;
            case 2:
                transition.setNode(ma_2);
                break;
            default:
                transition.setNode(ma_3);
                break;
        }
        transition.setDuration(Duration.millis(800));
        transition.setPath(line1);
        PathTransition transition1 = new PathTransition();
        switch(id2){
            case 1:
                transition1.setNode(ma_1);
                break;
            case 2:
                transition1.setNode(ma_2);
                break;
            default:
                transition1.setNode(ma_3);
                break;
        }
        transition1.setDuration(Duration.millis(800));
        transition1.setPath(line2);
        transition.play();
        transition1.play();
    }

    public void movesmoker(int id){
        switch (id) {
            case 1:
                Line line1 = new Line(153, 145, 593, 145);
                Line line2 = new Line(153, 145, 591, 145);
                Line line3 = new Line(153, 145, 591, 145);
                PathTransition transition = new PathTransition();
                transition.setNode(smokerA);
                transition.setDuration(Duration.millis(800));
                transition.setPath(line1);
                transition.play();
                PathTransition transition2 = new PathTransition();
                transition2.setNode(smokerB);
                transition2.setDuration(Duration.millis(800));
                transition2.setPath(line2);
                transition2.play();
                PathTransition transition3 = new PathTransition();
                transition3.setNode(smokerC);
                transition3.setDuration(Duration.millis(800));
                transition3.setPath(line3);
                transition3.play();
                break;
            case 3:
                Line line1r = new Line(153, 145, -287, 145);
                Line line2r = new Line(153, 145, -285, 145);
                Line line3r = new Line(153, 145, -285, 145);
                PathTransition transitionr = new PathTransition();
                transitionr.setNode(smokerA);
                transitionr.setDuration(Duration.millis(800));
                transitionr.setPath(line1r);
                transitionr.play();
                PathTransition transition2r = new PathTransition();
                transition2r.setNode(smokerB);
                transition2r.setDuration(Duration.millis(800));
                transition2r.setPath(line2r);
                transition2r.play();
                PathTransition transition3r = new PathTransition();
                transition3r.setNode(smokerC);
                transition3r.setDuration(Duration.millis(800));
                transition3r.setPath(line3r);
                transition3r.play();
                break;
        }
        
    }
}
