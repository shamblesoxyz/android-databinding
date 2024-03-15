package com.assignment.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.databinding.databinding.ItemListUserBinding;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.UserViewHolder> {
    private List<UserModel> users;

    public ListUserAdapter(List<UserModel> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListUserBinding itemListUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_user, parent, false);
        return new UserViewHolder(itemListUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setBinding(users.get(position), position);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public ObservableField<String> order = new ObservableField<>();
        public ObservableField<String> firstname = new ObservableField<>();
        public ObservableField<String> lastname = new ObservableField<>();
        private final ItemListUserBinding itemListUserBinding;

        public UserViewHolder(ItemListUserBinding itemView) {
            super(itemView.getRoot());
            this.itemListUserBinding = itemView;
        }

        public void setBinding(UserModel user, int position){
            if(itemListUserBinding.getViewHolder() == null){
                itemListUserBinding.setViewHolder(this);
            }
            order.set(String.valueOf(position));
            firstname.set(user.getFirstname());
            lastname.set(user.getLastname());
        }
    }
}
