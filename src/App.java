import controllers.Controllers;  
import controllers.SearchMethods;
import controllers.SortingMethods;
import view.Views; 

public class App {
    public static void main(String[] args) throws Exception {

        Views vista = new Views(); 

        SortingMethods sortingMethods = new SortingMethods();  
        SearchMethods searchMethods = new SearchMethods();      

        Controllers controllers = new Controllers(vista, sortingMethods, searchMethods); 

    }
}
