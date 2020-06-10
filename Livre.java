package models ;

import java.util.*;
import io.ebean.*;
import javax.persistence.*;


@Entity
public class Livre extends Model {
  
    private static final long serialVersionUID = 1L;

    @Id
    public long id;    
    public String auteur ;
    public String editeur ;
    public String date ;
    public String titre ;
    public String categorie ;
    public String description ;
    public boolean isEmprunte ;
    public boolean isEmpruntable ;
    public boolean EnReparation ;
    public boolean isPerdu ;
    
    
    public Livre(String auteur, String editeur, String date, String titre, String categorie, String description){
        this.auteur=auteur;
        this.editeur=editeur;
        this.date=date;
        this.titre=titre;
        this.categorie=categorie;
        this.description=description;
        this.isEmprunte=false;
        this.isEmpruntable=false;
        this.EnReparation=false;
        this.isPerdu=false;
    }
    
    public String getAuteur(){
        return this.auteur;
    }
    
    
    
    
    public static Finder<Long, Livre> find = new Finder<Long,Livre>(Livre.class);
}