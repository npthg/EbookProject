package swlabproject.ebookproject.Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Win10 on 2/6/2560.
 */

public abstract class BookRepo extends Observable {
    public abstract void fetchBook();
    public abstract ArrayList<TheBook> getBookList();
}
