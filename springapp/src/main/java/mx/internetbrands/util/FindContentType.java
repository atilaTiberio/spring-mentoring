package mx.internetbrands.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;

public class FindContentType {



    public FindContentType(){


    }

    public String getContentType(File file ){

        try {
            return Files.probeContentType(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "UNKNOWN";
    }

    public String getContentType(String fromURL){

        try {
            URLConnection connection= new URL(fromURL).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            return connection.getContentType();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "UNKNOWN";

    }


}
