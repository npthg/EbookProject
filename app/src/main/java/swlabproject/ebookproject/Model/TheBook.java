package swlabproject.ebookproject.Model;

/**
 * Created by Win10 on 2/6/2560.
 */

public class TheBook {
    private int id ;
    private String title ;
    private int pubYear ;
    private String img ;
    private double price ;

    public TheBook(int id , String title , int pubYear , String img , double price){
        this.id = id ;
        this.title = title ;
        this.pubYear = pubYear ;
        this.img = img ;
        this.price = price ;
    }
    public int getId(){
        return id ;
    }
    public String getTitle(){
        return title ;
    }
    public int getPubYear(){
        return pubYear ;
    }
    public String getImg(){
        return img ;
    }
    public double getPrice(){
        return price ;
    }
    public String toString(){
        return this.id+" : "+this.title+" , "+this.price+" Baht" ;
    }

}
