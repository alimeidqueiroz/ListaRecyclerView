package View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.List;

import Model.Person;
import Model.PersonDao;
import Model.DataPersonListener;
import Presenter.Presenter;
import Presenter.PresenterInterface;
import listarecyclerview.cursoandroid.com.listarecyclerview.R;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    private RecyclerView mRecyclerView;
    private ListAdapter adapter;
    private PersonDao personDao = new PersonDao();
    private PresenterInterface presenter = new Presenter(personDao, this, this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_id);


        adapter = new ListAdapter();

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.getData();

    }


    @Override
    public void setList(List<Person> personList) {
        adapter.updateList(personList);

    }

    @Override
    public void showError(Exception exception) {
        Toast.makeText(this,"Erro ao exibir Lista " + exception.getMessage(),Toast.LENGTH_LONG).show();

    }
}



