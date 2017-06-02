package swlabproject.ebookproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import swlabproject.ebookproject.Book.BookPresenter;
import swlabproject.ebookproject.Book.BookView;
import swlabproject.ebookproject.Model.BookRepo;
import swlabproject.ebookproject.Model.JSON;
import swlabproject.ebookproject.R;
import swlabproject.ebookproject.Model.TheBook;

public class MainActivity extends AppCompatActivity implements BookView {
    private BookPresenter bookPresenter  ;
    private BookRepo bookRepo ;

    private ListView listView ;
    private ArrayAdapter<TheBook> arrayAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookRepo = JSON.getJsonInstance();
        bookPresenter = new BookPresenter(bookRepo,this);
        bookPresenter.setPresenter();

        showBookList(bookRepo.getBookList());

    }
    @Override
    public void showBookList(ArrayList<TheBook> books) {
        listView = (ListView) findViewById(R.id.book_listview);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,books);
        listView.setAdapter(arrayAdapter);
    }

}
