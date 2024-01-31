package main;
//import package.ressources.*;

import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.stage.Stage;
import dao.MatiereDAO;
import model.Matiere;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main{
    public static void main(String[] args){

        String path = "C:\\Users\\HugoDarthenay-Kienne\\IdeaProjects\\java-miage\\src\\main\\resources\\csv\\data.csv";

         ObservableList<Matiere> list = MatiereDAO.getAll(path);
         for(Matiere m : list){
             System.out.println(m.toString());
         }



         //launch(args);


    }

    /*
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
    *
     */
}