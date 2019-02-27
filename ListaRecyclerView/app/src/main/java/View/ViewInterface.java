package View;

import java.util.List;

import Model.Person;

public interface ViewInterface {

    void setList(List<Person> personList);

    void showError(Exception exception);
}
