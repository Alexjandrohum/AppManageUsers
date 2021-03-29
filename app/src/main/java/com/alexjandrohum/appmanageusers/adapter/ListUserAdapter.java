package com.alexjandrohum.appmanageusers.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexjandrohum.appmanageusers.R;
import com.alexjandrohum.appmanageusers.dto.Datum;
import com.alexjandrohum.appmanageusers.util.GlideApp;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter {

    private List<Datum> listUsers;
    private final Activity activity;

    public ListUserAdapter(List<Datum> listUsers, Activity activity) {
        this.listUsers = listUsers;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_user_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (listUsers != null && listUsers.get(position) != null) {
            final Datum listUsersObject = listUsers.get(position);
            if (listUsersObject != null) ((Holder) holder).bind(listUsersObject);
        }
    }

    @Override
    public int getItemCount() {
        if (listUsers != null) {
            return listUsers.size();
        }
        return 0;
    }

    public void setItems(List<Datum> listUsers) {
        this.listUsers = listUsers;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        final TextView textViewEmail;
        final TextView textViewName;
        final ImageView ivAvatar;

        public Holder(View itemView) {
            super(itemView);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewName = itemView.findViewById(R.id.textViewName);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);

        }

        void bind(Datum datum) {

            GlideApp.with(activity.getApplicationContext())
                    .asBitmap()
                    .load(datum.getAvatar())
                    .fitCenter()
                    .priority(Priority.NORMAL)
                    .into(ivAvatar);

            textViewEmail.setText(datum.getEmail());
            textViewName.setText(datum.getFirstName()+" "+datum.getLastName());

        }
    }
}
