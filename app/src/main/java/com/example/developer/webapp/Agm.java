package com.example.developer.webapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Agm extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Events,Agm.EventsViewHolder>mRecyclerviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agm);
        setTitle("EGM and RecordDate");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("user");
        mDatabase.keepSynced(true);
        mRecyclerview=(RecyclerView) findViewById(R.id.myRecycleView);
        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("user");
        Query personsQuery = personsRef.orderByKey();
        mRecyclerview.hasFixedSize();
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Events>()
                .setQuery(personsQuery, Events.class).build();
        mRecyclerviewAdapter = new FirebaseRecyclerAdapter<Events, Agm.EventsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(@NonNull Agm.EventsViewHolder holder,final int position, @NonNull final Events model) {
                holder.setName(model.getName());
                holder.setYE(model.getYE());
                holder.setRD(model.getRD());
                holder.setDv(model.getDv());
                holder.setDate(model.getDate());

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            @Override
            public Agm.EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.agm_row,parent,false);
                return new Agm.EventsViewHolder(view);
            }
        };

    mRecyclerview.setAdapter(mRecyclerviewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRecyclerviewAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRecyclerviewAdapter.stopListening();
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public EventsViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setName(String Name)  {
        TextView Cname = (TextView)mView.findViewById(R.id.Cname);
        Cname.setText(Name);
        }
        public void setDate(String Date)  {
            TextView date = (TextView)mView.findViewById(R.id.date);
            date.setText(Date);
        }
        public void setDv(String Dv)  {
            TextView dv = (TextView)mView.findViewById(R.id.dv);
            dv.setText(Dv);
        }
        public void setYE(String Ye)  {
            TextView ye = (TextView)mView.findViewById(R.id.ye);
            ye.setText(Ye);
        }
        public void setRD(String RD)  {
            TextView rd = (TextView)mView.findViewById(R.id.rd);
            rd.setText(RD);
        }



    }
}
