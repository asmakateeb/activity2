package edu.cs.birzeit.ass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

    public class phoneAdapter extends RecyclerView.Adapter<phoneAdapter.PhonetViewHolder>{

        private Context mctx;
        private List<Phone> phoneList;

        public phoneAdapter(Context mctx, List<Phone> phoneList) {
            this.mctx = mctx;
            this.phoneList = phoneList;
        }
        @Override
        public PhonetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mctx);
            View view = inflater.inflate(R.layout.phone_list, null);
            return new PhonetViewHolder(view);
        }

        public void onBindViewHolder(PhonetViewHolder holder, int position) {
            Phone phone = phoneList.get(position);

            //loading the image
            //Glide.with(mctx)
            //   .load(phone.getImage())
            //   .into(holder.imageView);

            holder.iphonename.setText(phone.getPhoneName());
            holder.screensize.setText(phone.getScreenSize());
            holder.op.setText(phone.getOperatingSystem());
            holder.memory.setText(phone.getMemory());
            holder.battery.setText(phone.getBattery());
            holder.weight.setText(phone.getWeight());



        }

        @Override
        public int getItemCount() {
            return phoneList.size();
        }
        class PhonetViewHolder extends RecyclerView.ViewHolder {

            TextView iphonename, screensize, op, memory, battery,weight;
            ImageView imageView;


            public PhonetViewHolder(@NonNull View itemView) {
                super(itemView);

                iphonename = itemView.findViewById(R.id.iphonename);
                screensize = itemView.findViewById(R.id.screensize);
                op = itemView.findViewById(R.id.op);
                memory = itemView.findViewById(R.id.memory);
                battery = itemView.findViewById(R.id.battery);
                weight = itemView.findViewById(R.id.weight);

                imageView = itemView.findViewById(R.id.imageView);
            }
        }
}
