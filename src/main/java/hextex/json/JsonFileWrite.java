package hextex.json;

import com.google.gson.Gson;
import hextex.references.Reference;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonFileWrite {

  public static void writejson(List<Reference> references) throws IOException {
      Gson gson = new Gson();
      for (Reference reference : references) {
          System.out.println(gson.toJsonTree(reference));
      }
      

  }

}
