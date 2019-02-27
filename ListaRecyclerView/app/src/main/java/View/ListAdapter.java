package View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Model.Person;
import listarecyclerview.cursoandroid.com.listarecyclerview.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Person> personList = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ViewHolder(view, personList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Person person = this.personList.get(i);
        viewHolder.bind(person);

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void updateList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNome;
        private List<Person> personList;
        private TextView txtId;
        private ImageView imageView;
        private TextView birthday;
        private TextView txtBiography;


        public ViewHolder(@NonNull View itemView, List<Person> personList) {
            super(itemView);

            this.personList = personList;

            txtNome = itemView.findViewById(R.id.nome_id);
            txtId = itemView.findViewById(R.id.id_id);
            imageView = itemView.findViewById(R.id.imageView_id);
            birthday = itemView.findViewById(R.id.birthday_id);
            txtBiography = itemView.findViewById(R.id.biography_id);


        }

        public void bind(Person person) {

            if (person.getName() != null) {
                txtNome.setText("Name: " + person.getName());
            } else {
                txtNome.setText("Não disponível");
            }

            if (person.getId() != null) {
                txtId.setText("ID: " + person.getId());
            } else {
                txtId.setText("Não disponível");
            }

            if (person.getBirthday() != null) {
                birthday.setText("Birthday: " + person.getBirthday());
            } else {
                birthday.setText("Não disponível");

            }


            if (person.getBiography() != null) {
                txtBiography.setText("Biography: " + person.getBiography());
            } else {
                txtBiography.setText("Não disponível");
            }


            Picasso.get()
                    .load(person.getImageView())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
        }

    }

}

