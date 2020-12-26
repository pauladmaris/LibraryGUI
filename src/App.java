
import Repository.*;
import Controller.*;
import UI.*;

import java.awt.*;



public class App {

    public static void main(String[] args) {
        RepoCarti repo_carti = new RepoCarti("C:\\Users\\Paula\\eclipse-workspace\\Pb3\\src\\Carti");
        RepoAutori repo_autori = new RepoAutori("C:\\Users\\Paula\\eclipse-workspace\\Pb3\\src\\Autori");
        RepoEdituri repo_edituri = new RepoEdituri("C:\\Users\\Paula\\eclipse-workspace\\Pb3\\src\\Edituri");
        RepoDomenii repo_domenii = new RepoDomenii("C:\\Users\\Paula\\eclipse-workspace\\Pb3\\src\\Domenii");
        Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
        Controller_Autori ctrl_autori = new Controller_Autori(repo_autori);
        Controller_Editura ctrl_edituri = new Controller_Editura(repo_edituri);
        Controller_Domeniu ctrl_domenii = new Controller_Domeniu(repo_domenii);
        //Interfata interfata = new Interfata(ctrl_carti, ctrl_autori,ctrl_edituri, ctrl_domenii);
        //interfata.main(null);
        UI ui = new UI(ctrl_carti, ctrl_autori,ctrl_edituri, ctrl_domenii);
        ui.runApp();
    }

}
