package swlabproject.ebookproject.Book;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import swlabproject.ebookproject.Model.BookRepo;
import swlabproject.ebookproject.Model.TheBook;

/**
 * Created by Win10 on 2/6/2560.
 */

public class BookPresenter implements Observer {
    private BookView bookView ;
    private BookRepo bookRepo ;
    private ArrayList<TheBook> listBook ;

    public BookPresenter(BookRepo bookRepo , BookView bookView){
        this.bookRepo = bookRepo ;
        this.bookView = bookView ;
    }
    public void setPresenter(){
        bookRepo.addObserver(this);
        bookRepo.fetchBook();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o==bookRepo){
            listBook = new ArrayList<>(bookRepo.getBookList());
            bookView.showBookList(listBook);
        }
    }
}
