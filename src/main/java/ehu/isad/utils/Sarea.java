package ehu.isad.utils;

import com.google.gson.Gson;
import ehu.isad.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Sarea {

    public Sarea() {}

    public Book infoLortu(String pISBN) {
        String emaitza = this.irakurriURL(pISBN);
        Gson gson = new Gson();
        return gson.fromJson(emaitza, Book.class);
    }

    private String irakurriURL(String pISBN) {
        String inputLine = "";
        URL url;
        try {
            url = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + pISBN + "&jscmd=details&format=json");
            URLConnection urlKonexioa = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlKonexioa.getInputStream()));
            inputLine = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Zatiak hemen egin
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        return inputLine;
    }
}