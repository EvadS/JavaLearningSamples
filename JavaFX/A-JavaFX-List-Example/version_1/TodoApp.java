import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TodoApp
        extends Application {

    private ListView<Todo> listView;
    private ObservableList<Todo> data;
    private TextField nametxt;
    private TextArea desctxt;
    private Text actionstatus;

    public static void main(String [] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Todo App - version 1");

        // gridPane layout
		
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
		
        // list view, listener and list data
		
        listView = new ListView<>();
        listView.getSelectionModel().selectedIndexProperty().addListener(
                new ListSelectChangeListener());
        data = getListData();
        listView.setItems(data);
        grid.add(listView, 1, 1); // col = 1, row = 1
		
        // todo name label and text fld - in a hbox
		
        Label namelbl = new Label("Todo Name:");
        nametxt = new TextField();
        nametxt.setMinHeight(30.0);
        nametxt.setPromptText("Enter todo name (required).");
        nametxt.setPrefColumnCount(20);
        nametxt.setTooltip(new Tooltip("Item name (5 to 50 chars length)"));
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(namelbl, nametxt);
		
        // todo desc text area in a scrollpane
		
        desctxt = new TextArea();
        desctxt.setPromptText("Enter description (optional).");
        desctxt.setWrapText(true);
        ScrollPane sp = new ScrollPane();
        sp.setContent(desctxt);
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        sp.setPrefHeight(300);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
        // todo hbox (label + text fld), scrollpane - in a vbox 
		
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(hbox, sp);

        grid.add(vbox, 2, 1); // col = 2, row = 1
		
        // new and delete buttons
		
        Button newbtn = new Button("New");
        Button delbtn = new Button("Delete");
        HBox hbox2 = new HBox(10);
        hbox2.getChildren().addAll(newbtn, delbtn);
        grid.add(hbox2, 1, 2); // col = 1, row = 2

        // save button to the right anchor pane and grid
		
        Button savebtn = new Button("Save");
        AnchorPane anchor = new AnchorPane();
        AnchorPane.setRightAnchor(savebtn, 0.0);
        anchor.getChildren().add(savebtn);		
        grid.add(anchor, 2, 2); // col = 2, row = 2
		
        // action message (status) text
		
        actionstatus = new Text();
        actionstatus.setFill(Color.FIREBRICK);
        actionstatus.setText("");	
        grid.add(actionstatus, 1, 3); // col = 1, row = 3
		
        // scene

        Scene scene = new Scene(grid, 750, 400); // width = 750, height = 400
        primaryStage.setScene(scene);
        primaryStage.show();
		
        // initial selection
        listView.getSelectionModel().selectFirst(); // does nothing if no data
		
    } // start()
	
    private class ListSelectChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> ov, 
                Number old_val, Number new_val) {
			
            if ((new_val.intValue() < 0) || (new_val.intValue() >= data.size())) {
					
                return; // invalid data
            }
			
            // set name and desc fields for the selected todo
            Todo todo = data.get(new_val.intValue());
            nametxt.setText(todo.getName());
            desctxt.setText(todo.getDesc());
            actionstatus.setText(todo.getName() + " - selected");	
        }
    }
	
    private ObservableList<Todo> getListData() {
		
        List<Todo> list = new ArrayList<>(); // initial list data
        list.add(new Todo("Work", "Work on JCG's example article."));
        list.add(new Todo("Grocery", "Get apples, milk and bread."));
        list.add(new Todo("Calls", "Call kid brother."));
        list.add(new Todo("Read", "Magnificent Obcession, by Lloyd C. Douglas."));
        ObservableList<Todo> data = FXCollections.observableList(list);

        return data;
    }
}
