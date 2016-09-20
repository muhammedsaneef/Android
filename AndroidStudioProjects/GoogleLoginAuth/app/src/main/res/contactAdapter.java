import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by saneef on 6/9/16.
 */
public class contactAdapter extends RecyclerView.Adapter<contactHolder> {

    Context context;
    ArrayList<Person> contacts = new ArrayList<>();

    public contactAdapter(Context context, ArrayList<Person> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public contactHolder onCreateViewHolder(ViewGroup parent, int viewType)

    {
        View v= LayoutInflater.from(context).inflate(android.R.layout.contact,parent,false);
        return new contactHolder(v);
    }
    @Override
    public void onBindViewHoler(contactHolder holder,  )
    {

    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }
}
