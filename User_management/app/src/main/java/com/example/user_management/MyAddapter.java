package com.example.user_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAddapter extends RecyclerView.Adapter<MyAddapter.ViewHolder> {
    private List<Model> modelList;
    private Context context;

    public MyAddapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position){


            final String fullname = modelList.get(position).getHead();
            final String email = modelList.get(position).getDesc();

            final String phone = modelList.get(position).getPhone();
            final String gender = modelList.get(position).getGender();

            viewHolder.setData(fullname,"","","");

            viewHolder.txtFullname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.setData(fullname,email,phone,gender);
                }
            });
        }

        @Override
        public int getItemCount() {

            return modelList.size();
        }



        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView txtFullname;
            public TextView txtEmail;
            public TextView txtPhone;
            public TextView txtGender;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                txtFullname = (TextView)itemView.findViewById(R.id.textViewFullname);
                txtEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
                txtPhone = (TextView)itemView.findViewById(R.id.txtViewPhone);
                txtGender = (TextView)itemView.findViewById(R.id.txtViewGender);
            }

            public void setData(String fullname,String email,String phone,String gender){
                txtFullname.setText(fullname);
                txtEmail.setText(email);
                txtPhone.setText(phone);
                txtGender.setText(gender);

            }
        }

        }


