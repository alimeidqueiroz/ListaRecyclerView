package Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDao {

    public void readFile(Context context, DataPersonListener listener) {

        List<Person> personList = new ArrayList<>();

        try {
            AssetManager manager = context.getAssets();
            InputStream galleriesJson = manager.open("JsonTeste.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(galleriesJson));

            Gson gson = new Gson();

            Person[] personArray = gson.fromJson(bufferReaderIn, Person[].class);

            personList.addAll(Arrays.asList(personArray));

            for(int i = 0 ; i < personList.size(); i++) {

                Person person = personList.get(i);

                for(int j = i+1 ; j < personList.size();j++) {
                    Person person1 = personList.get(j);
                    if(person.getId().equals(person1.getId())) {
                        personList.remove(person);
                    }
                }
            }

            listener.onSucess(personList);

        } catch (IOException exception) {
            Log.e("JSON", "ERRO AO LER ARQUIVO jsonTeste.json");
            listener.onError(exception);
        }
    }


}
