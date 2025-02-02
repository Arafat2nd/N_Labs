package source_code.superv;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class super_cont implements Initializable {

    @FXML
    private AnchorPane navbar, slider, tmp, card;
    @FXML
    BorderPane pb;
    @FXML
    Parent root;
    @FXML
    private Label nav_lable;
    public String lab;
    public String id;

    @FXML
    private Button unfold, home, labs, grades, profile, logout;

    @FXML
    private ImageView exit;
    boolean h = false;
    @FXML
    private HBox cardlay;
    @FXML
    public Label name;
    @FXML
    private Button cp1;
    @FXML
    private Button search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        home.setStyle("-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_super/home_super.fxml"));
            Parent root = loader.load();
            home cont = loader.getController();
            cont.id=id;
            cont.lab=lab;
            pb.setCenter(root);
            // home.setStyle("-fx-background-color : #4364f7 ;" + "-fx-border-color:BLACK;" + "-fx-border-width: 0px 0px 0px 6px;");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logout.setOnMouseClicked(event -> {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_general/login.fxml"));
                    try {
                        Stage stage = (Stage) logout.getScene().getWindow();

                        stage.setScene(new Scene(loader.load()));
                        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        slider.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), navbar);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), slider);
        translateTransition.setByX(-600);
        translateTransition.play();

        unfold.setOnMouseClicked(event -> {
            if (
                    !h) {
                slider.setVisible(true);

                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), navbar);
                fadeTransition1.setFromValue(0);
                fadeTransition1.setToValue(0.15);
                fadeTransition1.play();

                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), slider);
                translateTransition1.setByX(+600);
                translateTransition1.play();
                h = true;
                unfold.setDisable(true);
                GaussianBlur g = new GaussianBlur();
                g.setRadius(10);
                pb.setEffect(g);
            }

        });
        slider.setOnMouseClicked(event -> {

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), navbar);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                navbar.setVisible(false);
            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), slider);
            translateTransition1.setByX(-600);
            translateTransition1.play();
            h = false;
            unfold.setDisable(false);
            GaussianBlur g = new GaussianBlur();
            g.setRadius(0);
            pb.setEffect(g);
        });
        cp1.setOnMouseClicked(event->{
            Stage s=(Stage) cp1.getScene().getWindow();
            s.close();});
        out.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_general/login.fxml"));
            try {
                Stage stage = (Stage) logout.getScene().getWindow();

                stage.setScene(new Scene(loader.load()));
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

@FXML
Button out;

    @FXML
    private void activate(ActionEvent e) throws IOException, SQLException {
        if (e.getSource() == home) {
            home.setStyle(  "-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");
            profile.setStyle(" -fx-background-color :transparent;" + ".button:hover" + "{-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;};");
            search.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            labs.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            grades.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_super/home_super.fxml"));
            Parent root = loader.load();
            home cont = loader.getController();

            cont.id=id;

            cont.lab=lab;
            System.out.println(cont.lab);
            pb.setCenter(root);

            nav_lable.setText("Home");

        }
        if (e.getSource() == labs) {
            labs.setStyle(  "-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");
            home.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            profile.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            search.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            grades.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
             nav_lable.setText("Labs");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_super/exps.fxml"));
            Parent root = loader.load();
            exps cont = loader.getController();
            cont.lab=lab;
            cont.cards();
            pb.setCenter(root);

            /*FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File f=fileChooser.showOpenDialog((Stage)labs.getScene().getWindow());
            System.out.println(f.getName());
            Desktop desktop = Desktop.getDesktop();
            desktop.mail();
            desktop.open(f);*/
        }
        if (e.getSource() == grades) {
            grades.setStyle( "-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");
            home.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #D4F1F4;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            labs.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #D4F1F4;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            search.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");

            profile.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #D4F1F4;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");











            loader("/fxml_super/home_instructor");
            nav_lable.setText("Grading");


        }
        if (e.getSource() == profile) {
            profile.setStyle( "-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");
            home.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            labs.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            grades.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            search.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_super/home_super.fxml"));
            Parent root = loader.load();
            home cont = loader.getController();
            cont.id=id;
            cont.lab=lab;

             nav_lable.setText("Profile");


        }
        if (e.getSource() == search) {
            search.setStyle( "-fx-border-color: WHITE;" + "-fx-border-width: 0px 0px 0px 6px;");
            home.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            labs.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            grades.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          WHITE;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");
            profile.setStyle(" -fx-background-color :transparent;" + ".button:hover {" + "-fx-background-color: #4592E8;" + "-fx-border-color:          BLACK;" + "-fx-border-width: 0px 0px 0px 6px;" + "};");

            loader("/fxml_instructor/search a student_instructor");
            nav_lable.setText("Search A Student");


        }


    }
    @FXML
    private void loader(String page) throws IOException {
        root=FXMLLoader.load(getClass().getResource(page+".fxml"));


        pb.setCenter(root);

    }

}