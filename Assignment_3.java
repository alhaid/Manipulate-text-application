/*
 * Name:  [Hamzah Shafeeq]
 * Assignment:  [Assignment3]

 * [A program that allows the user to inter a text and manipulate it as he/she
 wants. The user can change the font, size, forground color and background color]
 */
package Prog24178.assign3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Hamzah Shafeeq
 */
public class Assignment_3 extends Application {

    //constant array for the size action event
    public static final int[] SIZES = {12, 16, 24};
    private RadioButton optSmall, optMedium, optLarge, optLeft, optCenter,
            optRight;
    //the main label that is going to be mainpulated.
    private Label lblCenter;
    private CheckBox chkBold, chkItalic;
    //this array colors for the foreground colors for the drop down menu that is
    //on the right side of the program.
    private Color[] colors1 = {Color.BLACK, Color.DARKGREEN, Color.NAVY};
    RadioMenuItem mnuEditSizeSmall, mnuEditSizeMedium, mnuEditSizeLarge,
            mnuEditAlignLeft, mnuEditAlignCenter, mnuEditAlignRight;
    CheckMenuItem mnuEditBold, mnuEditItalic;

    @Override
    public void start(Stage primaryStage) {
        //menus(at the top of the program)
        //1
        MenuBar mnuMain = new MenuBar();
        //1.1
        Menu mnuFile = new Menu("_File");
        //1.1.1
        MenuItem mnuFileReset = new MenuItem("_Reset");
        //1.1.2
        MenuItem mnuFileExit = new MenuItem("E_xit");
        mnuFile.getItems().addAll(mnuFileReset, new SeparatorMenuItem(),
                mnuFileExit);
        mnuFileExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        //1.2
        Menu mnuEdit = new Menu("_Edit");
        //1.2.*1
        Menu mnuEditSize = new Menu("Size");
        mnuEditSizeSmall = new RadioMenuItem("_Small");
        mnuEditSizeMedium = new RadioMenuItem("_Medium");
        mnuEditSizeLarge = new RadioMenuItem("_Large");
        SizeRadioHandler menuSize = new SizeRadioHandler();
        mnuEditSizeSmall.setOnAction(menuSize);
        mnuEditSizeMedium.setOnAction(menuSize);
        mnuEditSizeLarge.setOnAction(menuSize);
        ToggleGroup grpSize = new ToggleGroup();
        mnuEditSizeSmall.setToggleGroup(grpSize);
        mnuEditSizeMedium.setToggleGroup(grpSize);
        mnuEditSizeLarge.setToggleGroup(grpSize);
        mnuEditSize.getItems().addAll(mnuEditSizeSmall, mnuEditSizeMedium,
                mnuEditSizeLarge);

        //1.2.2
        Menu mnuEditAlign = new Menu("Alignment");
        mnuEditAlignLeft = new RadioMenuItem("Le_ft");
        mnuEditAlignCenter = new RadioMenuItem("_Center");
        mnuEditAlignRight = new RadioMenuItem("Ri_ght");
        AlignRadioHandler menuAlign = new AlignRadioHandler();
        mnuEditAlignLeft.setOnAction(menuAlign);
        mnuEditAlignCenter.setOnAction(menuAlign);
        mnuEditAlignRight.setOnAction(menuAlign);
        ToggleGroup grpAlign = new ToggleGroup();
        mnuEditAlignLeft.setToggleGroup(grpAlign);
        mnuEditAlignCenter.setToggleGroup(grpAlign);
        mnuEditAlignRight.setToggleGroup(grpAlign);
        mnuEditAlign.getItems().addAll(mnuEditAlignLeft, mnuEditAlignCenter,
                mnuEditAlignRight);
        //1.2.3
        mnuEditBold = new CheckMenuItem("_Bold");
        //1.2.4
        mnuEditItalic = new CheckMenuItem("_Italic");
        FontHandler menuFont = new FontHandler();
        mnuEditBold.setOnAction(menuFont);
        mnuEditItalic.setOnAction(menuFont);
        //1.2.5 
        //foreground menu
        Menu mnuEditFGC = new Menu("Foreground");
        RadioMenuItem mnuEditFGCRed = new RadioMenuItem("_red");
        RadioMenuItem mnuEditFGCBlue = new RadioMenuItem("Bl_ue");
        RadioMenuItem mnuEditFGCGreen = new RadioMenuItem("_Green");
        ToggleGroup grpFGC = new ToggleGroup();
        mnuEditFGCRed.setToggleGroup(grpFGC);
        mnuEditFGCBlue.setToggleGroup(grpFGC);
        mnuEditFGCGreen.setToggleGroup(grpFGC);
        mnuEditFGC.getItems().addAll(mnuEditFGCRed, mnuEditFGCBlue,
                mnuEditFGCGreen);
        //setting the foreground menu on action.
        mnuEditFGCRed.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.setTextFill(Color.RED);
            }
        });
        mnuEditFGCBlue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.setTextFill(Color.BLUE);
            }
        });
        mnuEditFGCGreen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.setTextFill(Color.GREEN);
            }
        });
        //1.2.6
        //background menu
        Menu mnuEditBGC = new Menu("Background");
        RadioMenuItem mnuEditBGCAqua = new RadioMenuItem("A_qua");
        RadioMenuItem mnuEditBGCCoral = new RadioMenuItem("C_oral");
        RadioMenuItem mnuEditBGCCyan = new RadioMenuItem("C_yan");
        ToggleGroup grpBGC = new ToggleGroup();
        mnuEditBGCAqua.setToggleGroup(grpBGC);
        mnuEditBGCCoral.setToggleGroup(grpBGC);
        mnuEditBGCCyan.setToggleGroup(grpBGC);
        mnuEditBGC.getItems().addAll(mnuEditBGCAqua, mnuEditBGCCoral,
                mnuEditBGCCyan);
        //setting the background menu on action.
        mnuEditBGCAqua.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.getStyleClass().add("aqua");
                lblCenter.getStyleClass().removeAll("coral", "cyan", "white",
                        "wheat", "grey");
            }
        });
        mnuEditBGCCoral.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.getStyleClass().add("coral");
                lblCenter.getStyleClass().removeAll("aqua", "cyan", "white",
                        "wheat", "grey");
            }
        });
        mnuEditBGCCyan.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.getStyleClass().add("cyan");
                lblCenter.getStyleClass().removeAll("aqua", "coral", "white",
                        "wheat", "grey");
            }
        });
        //adding the menus to the edit menu.
        mnuEdit.getItems().addAll(mnuEditSize, mnuEditAlign, mnuEditBold,
                mnuEditItalic, mnuEditFGC, mnuEditBGC);
        //adding the menus to the main menu.
        mnuMain.getMenus().addAll(mnuFile, mnuEdit);
        //labels
        Label lblTextSize = new Label("Text Size:");
        Label lblAlign = new Label("Alignment:");
        Label lblChangeText = new Label("Change Text:");
        Label lblFont = new Label("Font Option:");
        Label lblForeground = new Label("Foreground:");
        Label lblBackground = new Label("Backround:");
        lblCenter = new Label("Assignment 3");
        lblCenter.setMaxWidth(Double.MAX_VALUE);
        lblCenter.setMaxHeight(Double.MAX_VALUE);
        lblCenter.setOpacity(100);
        lblCenter.setAlignment(Pos.CENTER);
        //txt 
        TextField txtChangeText = new TextField();
        //setting the text on action.
        txtChangeText.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.setText(txtChangeText.getText());
                txtChangeText.clear();
                txtChangeText.requestFocus();
            }
        });
        //buttons
        Button btnReset = new Button("_Reset");
        Button btnExit = new Button("E_xit");
        btnReset.setMnemonicParsing(true);
        btnExit.setMnemonicParsing(true);
        //buttons events
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        //radi buttons
        optSmall = new RadioButton("_Small");
        optMedium = new RadioButton("_Meduim");
        optLarge = new RadioButton("_Large");
        optLeft = new RadioButton("Le_ft");
        optCenter = new RadioButton("_Center");
        optRight = new RadioButton("Ri_ght");
        optSmall.setMnemonicParsing(true);
        optMedium.setMnemonicParsing(true);
        optLarge.setMnemonicParsing(true);
        optLeft.setMnemonicParsing(true);
        optCenter.setMnemonicParsing(true);
        optRight.setMnemonicParsing(true);
        ToggleGroup group1 = new ToggleGroup();
        optSmall.setToggleGroup(group1);
        optMedium.setToggleGroup(group1);
        optLarge.setToggleGroup(group1);
        ToggleGroup group2 = new ToggleGroup();
        optLeft.setToggleGroup(group2);
        optCenter.setToggleGroup(group2);
        optRight.setToggleGroup(group2);
        //setting the size radio buttons on action
        SizeRadioHandler size = new SizeRadioHandler();
        optSmall.setOnAction(size);
        optMedium.setOnAction(size);
        optLarge.setOnAction(size);
        //setting the alignment radio buttons on action
        AlignRadioHandler align = new AlignRadioHandler();
        optLeft.setOnAction(align);
        optCenter.setOnAction(align);
        optRight.setOnAction(align);
        //check box
        chkBold = new CheckBox("_Bold");
        chkItalic = new CheckBox("_Italic");
        chkBold.setMnemonicParsing(true);
        chkItalic.setMnemonicParsing(true);
        //setting the check box on action.
        FontHandler font = new FontHandler();
        chkBold.setOnAction(font);
        chkItalic.setOnAction(font);
        //drop menu1 (foreground colors).
        String[] foregroundColors = {"Black", "Dark Green", "Navy"};
        ObservableList<String> list1
                = FXCollections.observableArrayList(foregroundColors);
        ComboBox<String> ddlForeGround = new ComboBox<>(list1);
        ddlForeGround.setValue(foregroundColors[1]);
        lblCenter.setTextFill(colors1[1]);
        //setting drop down menu 1 on action.
        ddlForeGround.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = ddlForeGround.getSelectionModel().
                        getSelectedIndex();
                if (index == 0) {
                    lblCenter.setTextFill(colors1[0]);
                } else if (index == 1) {
                    lblCenter.setTextFill(colors1[1]);
                } else if (index == 2) {
                    lblCenter.setTextFill(colors1[2]);
                }
            }
        });
        //drop menu2 (background colors).
        String[] backgroundColors = {"Grey", "White", "Wheat"};
        ObservableList<String> list2
                = FXCollections.observableArrayList(backgroundColors);
        ComboBox<String> ddlBackground = new ComboBox<>(list2);
        ddlBackground.setValue(backgroundColors[0]);
        lblCenter.getStyleClass().add("grey");
        //setting drop down menu 2 on action.
        ddlBackground.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int index = ddlBackground.getSelectionModel().
                        getSelectedIndex();
                if (index == 0) {
                    lblCenter.getStyleClass().add("grey");
                    lblCenter.getStyleClass().removeAll("white", "wheat",
                            "aqua", "coral", "cyan");
                } else if (index == 1) {
                    lblCenter.getStyleClass().add("white");
                    lblCenter.getStyleClass().removeAll("grey", "wheat",
                            "aqua", "coral", "cyan");
                } else if (index == 2) {
                    lblCenter.getStyleClass().add("wheat");
                    lblCenter.getStyleClass().removeAll("grey", "white",
                            "aqua", "coral", "cyan");
                }
            }
        });
        //reset button (it resets everything).
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                lblCenter.setAlignment(Pos.CENTER);
                lblCenter.setFont(Font.font("Arial", FontWeight.NORMAL,
                        FontPosture.REGULAR, 16));
                lblCenter.setText("Assignment 3");
                ddlBackground.setValue(backgroundColors[0]);
                ddlForeGround.setValue(foregroundColors[1]);
                lblCenter.getStyleClass().add("grey");
                lblCenter.getStyleClass().removeAll("white", "wheat", "aqua",
                        "coral", "cyan");
                lblCenter.setTextFill(colors1[1]);
                chkBold.setSelected(false);
                chkItalic.setSelected(false);
                optSmall.setSelected(false);
                optMedium.setSelected(false);
                optLarge.setSelected(false);
                optLeft.setSelected(false);
                optCenter.setSelected(false);
                optRight.setSelected(false);
                txtChangeText.clear();
                txtChangeText.requestFocus();
                mnuEditSizeSmall.setSelected(false);
                mnuEditSizeMedium.setSelected(false);
                mnuEditSizeLarge.setSelected(false);
                mnuEditAlignLeft.setSelected(false);
                mnuEditAlignCenter.setSelected(false);
                mnuEditAlignRight.setSelected(false);
                mnuEditBold.setSelected(false);
                mnuEditItalic.setSelected(false);
                mnuEditFGCRed.setSelected(false);
                mnuEditFGCBlue.setSelected(false);
                mnuEditFGCGreen.setSelected(false);
                mnuEditBGCAqua.setSelected(false);
                mnuEditBGCCoral.setSelected(false);
                mnuEditBGCCyan.setSelected(false);
            }
        });
        //border pane for the top left side.
        //left side.
        BorderPane leftPane = new BorderPane();
        HBox line1 = new HBox(lblTextSize, optSmall, optMedium, optLarge);
        HBox line2 = new HBox(lblAlign, optLeft, optCenter, optRight);
        HBox line3 = new HBox(lblChangeText, txtChangeText);
        VBox threeLines = new VBox(line1, line2, line3);
        leftPane.setTop(threeLines);
        leftPane.setCenter(lblCenter);
        BorderPane.setMargin(leftPane, new Insets(0, 5, 5, 5));
        //right side.
        VBox rightPane = new VBox(lblFont, chkBold, chkItalic, lblForeground,
                ddlForeGround, lblBackground, ddlBackground);
        //bottom side.
        HBox bottomPane = new HBox(btnReset, btnExit);
        bottomPane.setAlignment(Pos.CENTER);
        //BorderPane (the main one).
        BorderPane pane = new BorderPane();
        pane.setTop(mnuMain); //top (menu).
        pane.setCenter(leftPane); //top left side.
        pane.setBottom(bottomPane); //bottom (HBox).
        pane.setRight(rightPane);   //right side (VBox).
        //adding the css file.
        String stylesheet
                = getClass().getResource("style.css").toExternalForm();
        Scene scene = new Scene(pane);
        //using the css file.
        scene.getStylesheets().add(stylesheet);
        primaryStage.setTitle("Assignment 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    //Inner class to handle the action event of the size radio button.
    private class SizeRadioHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (optSmall.isSelected() || mnuEditSizeSmall.isSelected()) {
                lblCenter.setFont(Font.font(SIZES[0]));
            } else if (optMedium.isSelected() || mnuEditSizeMedium.
                    isSelected()) {
                lblCenter.setFont(Font.font(SIZES[1]));
            } else if (optLarge.isSelected() || mnuEditSizeLarge.isSelected()) {
                lblCenter.setFont(Font.font(SIZES[2]));
            }
        }
    }

    //Inner class to handle the action event of the alignment radio button.
    private class AlignRadioHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (optLeft.isSelected() || mnuEditAlignLeft.isSelected()) {
                lblCenter.setAlignment(Pos.CENTER_LEFT);
            } else if (optCenter.isSelected() || mnuEditAlignCenter.
                    isSelected()) {
                lblCenter.setAlignment(Pos.CENTER);
            } else if (optRight.isSelected() || mnuEditAlignRight.isSelected()) {
                lblCenter.setAlignment(Pos.CENTER_RIGHT);
            }
        }
    }

    //Inner class to handle the action event of the check-box.
    private class FontHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Font currentFont = lblCenter.getFont();
            //checking if bold is selected, in order to make it bold.
            FontWeight bold = (chkBold.isSelected()
                    || mnuEditBold.isSelected())
                            ? FontWeight.BOLD : FontWeight.NORMAL;
            //checking if italic is selected, in order to make it italic.
            FontPosture italic = (chkItalic.isSelected()
                    || mnuEditItalic.isSelected())
                            ? FontPosture.ITALIC : FontPosture.REGULAR;
            Font font = Font.font(currentFont.getName(), bold, italic,
                    currentFont.getSize());
            lblCenter.setFont(font);
        }
    }
}
