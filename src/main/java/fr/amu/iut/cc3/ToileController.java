package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.beans.value.ObservableValue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;


public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;
    private ChangeListener<String> compListener;


    @FXML
    TextField comp1;
    @FXML
    TextField comp2;
    @FXML
    TextField comp3;
    @FXML
    TextField comp4;
    @FXML
    TextField comp5;
    @FXML
    TextField comp6;

    @FXML
    Pane pain;

    @FXML
    Button vider;
    @FXML
    Button tracer;


    Circle cercle1 = new Circle();
    Circle cercle2 = new Circle();
    Circle cercle3 = new Circle();
    Circle cercle4 = new Circle();
    Circle cercle5 = new Circle();
    Circle cercle6 = new Circle();

    private StringProperty comp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        compListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                cercle1.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                cercle2.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                cercle3.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                cercle4.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                cercle5.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                cercle6.setCenterX(getXRadarChart(parseDouble(comp1.getText()), 1));
                pain.getChildren().addAll(cercle1, cercle2, cercle3, cercle4, cercle5, cercle6);
            }
        };
        vider.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            clear();
        });
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    void clear(){
        comp1.clear();
        comp2.clear();
        comp3.clear();
        comp4.clear();
        comp5.clear();
        comp6.clear();
    }

}
