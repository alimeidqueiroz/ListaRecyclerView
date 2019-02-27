package Presenter;

import android.content.Context;

import java.util.List;

import Model.DataPersonListener;
import Model.Person;
import Model.PersonDao;
import View.ViewInterface;

public class Presenter implements PresenterInterface, DataPersonListener {

    private PersonDao personDao;
    private ViewInterface view;
    private Context context;


    public Presenter(PersonDao personDao, ViewInterface view, Context context) {
        this.personDao = personDao;
        this.view = view;
        this.context = context;

    }

    @Override
    public void getData() {
      personDao.readFile(context, this);
    }

    @Override
    public void onSucess(List<Person> personList) {
        view.setList(personList);

    }

    @Override
    public void onError(Exception exception) {
        view.showError(exception);

    }
}
