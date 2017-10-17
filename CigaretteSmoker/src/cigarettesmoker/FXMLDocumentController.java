/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author HanWang
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private WebView svgtest;
    
    
    
    @FXML
    private void btnhoverin(MouseEvent event){
        System.out.println("testbtn"); 
        final WebEngine eng = svgtest.getEngine();
        URL svgpath = this.getClass().getResource("startbtn_hover.svg");
        eng.load(svgpath.toString());
    }
    
    @FXML
    private void btnhoverout(MouseEvent event){
        System.out.println("testoutbtn"); 
        final WebEngine eng = svgtest.getEngine();
        URL svgpath = this.getClass().getResource("startbtn.svg");
        eng.load(svgpath.toString());
    }
    
    @FXML
    private void start_btn_click(MouseEvent event){
        System.out.println("start");  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final WebEngine eng = svgtest.getEngine();
        URL svgpath = this.getClass().getResource("startbtn.svg");
        eng.load(svgpath.toString());
    }    
    
}
