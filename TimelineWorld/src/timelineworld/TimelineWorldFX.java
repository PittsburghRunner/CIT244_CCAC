/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timelineworld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timeline.TimelineWorld;
import timeline.components.Component;

/**
 *
 * @author ceckles
 */
public class TimelineWorldFX extends Application {

        ObservableList<? extends Component> components ;
    
    @Override
    public void start(Stage stage) throws Exception {
        components = FXCollections.observableArrayList(TimelineWorld.getTimelineInstance().getComponents());
        stage.setTitle("Timeline World");
        Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("timeline_tableview.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void run(String[] args) {
        launch(args);
    }

    public ObservableList<? extends Component> getComponents() {
        return components;
    }

    public void setComponents(ObservableList<Component> components) {
        this.components = components;
    }

    
    
}
