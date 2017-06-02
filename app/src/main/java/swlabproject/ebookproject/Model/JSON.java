package swlabproject.ebookproject.Model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Win10 on 2/6/2560.
 */

public class JSON extends BookRepo {

    private static JSON jsonInstance ;
    private ArrayList<TheBook> listBook ;
    public static JSON getJsonInstance(){
        if(jsonInstance == null){
            jsonInstance = new JSON();
        }
        return jsonInstance ;
    }
    @Override
    public void fetchBook() {
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute();
    }

    @Override
    public ArrayList<TheBook> getBookList() {
        return listBook;
    }

    public class JSONAsyncTask extends AsyncTask<Void,Void,ArrayList<TheBook>>{
        @Override
        protected ArrayList<TheBook> doInBackground(Void... params) {

            ArrayList<TheBook> books = new ArrayList<>();
            if(loadJSONBook()==null){
                return null ;
            }
            try{
                JSONArray jsonArray = new JSONArray(loadJSONBook());

                for(int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    TheBook book = new TheBook(jsonObject.getInt("id"),jsonObject.getString("title")
                                    ,jsonObject.getInt("pub_year"),jsonObject.getString("img_url"),jsonObject.getDouble("price"));
                    books.add(book);
                }

            } catch (JSONException e) {
               return null ;
            }

            return books;
        }
        private String loadJSONBook(){
            String load = "" ;
            try{
                URL url = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
                URLConnection urlConnection = url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line ;
                while((line = reader.readLine())!=null){
                    load+=line ;
                }

                return load ;
            } catch (IOException e) {
                return load ;
            }
         }

        @Override
        protected void onPostExecute(ArrayList<TheBook> theBooks) {
           if(theBooks != null){
               listBook.clear();
               listBook.addAll(theBooks);
               setChanged();
               notifyObservers();
           }

        }

    }


}
