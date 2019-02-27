package Model;

import java.util.List;

public interface DataPersonListener {

    void onSucess(List<Person> personList);

    void onError(Exception exception);
}
