/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timelineworld;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import timeline.TimelineWorld;
import timeline.components.Component;

/**
 *
 * @author ceckles
 */
public class TimelineWorldController implements Initializable {
    
    @FXML
    ObservableList<Component> components = FXCollections.observableArrayList(TimelineWorld.getTimelineInstance().getComponents());
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public ObservableList<Component> getComponents() {
        return components;
    }

    public void setComponents(ObservableList<Component> components) {
        this.components = components;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    
    
}
