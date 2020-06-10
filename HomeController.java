package controllers;

import models.Person;
import models.Livre;
import views.html.*;
import play.mvc.*;
import java.util.List ; 
import play.data.* ;
import javax.inject.Inject; 
import play.i18n.MessagesApi;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory; 
    Form <Person> personForm ;
    Form <Livre> livreForm ;
    MessagesApi messagesApi;
    
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
     this.personForm = formFactory.form(Person.class);
     this.livreForm = formFactory.form(Livre.class);
     this.messagesApi = messagesApi;
    }
    
    /*
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        List<Livre> listeLivre = Livre.find.all();
        return ok(index.render(listeLivre));
    }
    
     public Result helloworld(String fname) {
        return ok(helloworld.render(fname));
    }
    
    public Result sayhelloform (Http.Request request) {
        personForm = formFactory.form(Person.class) ;
        return ok(sayhelloform.render(personForm, request, messagesApi.preferred(request))) ; 
    }
    
    public Result helloworldform(Http.Request request) {
       final Form<Person> pForm = personForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Person a = pForm.get();
            a.save();
        return ok(helloworldform.render(a)) ;
    //    }
    }
    
    
    public Result creerLivre (Http.Request request) {
        livreForm = formFactory.form(Livre.class) ;
        return ok(creationLivre.render(livreForm, request, messagesApi.preferred(request))) ; 
    }
    
    public Result creerLivreform(Http.Request request) {
       final Form<Livre> lForm = livreForm.bindFromRequest(request) ; 
       // if (pForm.hasErrors()){
    //      return badRequest(sayhelloform.render(lForm,request, messagesApi.preferred(request)));
    //    }else{
            Livre livre = lForm.get();
            livre.save();
            return ok(creationLivreForm.render(a)) ;
      //  }
    }
    
    
    
     public Result sayhello() {
        return ok(views.html.sayhello.render());
    }
    
    public Result all(){
        List<Person> liste = Person.find.all();
        return ok(all.render(liste));
    }
   public Result all(){
        List<Livre> liste = Livre.find.all();
        return ok(all.render(liste));
    }
    public Result show(Long id){
        Livre livre = Livre.find.byId(id)
        return ok(show.render(livre));
    }
    public Result delete(Long id){
        Livre livre = livre.find.byId(id);
        livre.delete();
        return redirect (routes.HomeController.all());
    }
    public Result update(Long id, http.Request request){
        Livre livre = Livre.find.byeId(id);
        Form<Livre> lform = formFactory.form(Livre.class);
        lform = livreForm.fill(livre);
        return ok(update.render(livreForm, id, request, messagesApi.preferred(request)));
    }
    

}
