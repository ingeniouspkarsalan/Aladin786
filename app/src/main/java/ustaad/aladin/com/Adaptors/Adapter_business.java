package ustaad.aladin.com.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ustaad.aladin.com.Activities.Item_page;
import ustaad.aladin.com.R;
import ustaad.aladin.com.classes.bus_list_class;

public class Adapter_business extends RecyclerView.Adapter<Adapter_business.businessViewHolder> {
    private Context context;
    private ArrayList<bus_list_class> bus_list_classList;


    class businessViewHolder extends RecyclerView.ViewHolder {
    ImageView bus_card_image;
    TextView bus_card_name,bus_card_contact,bus_card_city;
    CardView card_view;

        public businessViewHolder(View itemView) {
            super(itemView);
            card_view=itemView.findViewById(R.id.card_view);
        bus_card_image=itemView.findViewById(R.id.bus_card_img);
        bus_card_name=itemView.findViewById(R.id.bus_card_name);
        bus_card_contact=itemView.findViewById(R.id.bus_card_contact);
        bus_card_city=itemView.findViewById(R.id.bus_card_city);
        }
    }

    public Adapter_business(Context context, ArrayList<bus_list_class> bus_list_classList) {
        this.context = context;
        this.bus_list_classList = bus_list_classList;
    }

    @Override
    public void onBindViewHolder(businessViewHolder holder, int position) {
    final bus_list_class bus_list_class=bus_list_classList.get(position);
    if(!bus_list_class.getB_image().isEmpty()){
        Glide.with(context).load(bus_list_class.getB_image()).into(holder.bus_card_image);
    }else {
        holder.bus_card_image.setImageDrawable(context.getResources().getDrawable(R.drawable.banner));
    }

    holder.bus_card_name.setText(" "+bus_list_class.getB_name());
    holder.bus_card_contact.setText(" "+bus_list_class.getB_mobile());
    holder.bus_card_city.setText(" "+bus_list_class.getB_city());
    holder.card_view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent send=new Intent(context, Item_page.class);
            send.putExtra("b_id",bus_list_class.getB_id());
            send.putExtra("b_name",bus_list_class.getB_name());
            send.putExtra("b_image",bus_list_class.getB_image());
            send.putExtra("b_mobile",bus_list_class.getB_mobile());
            send.putExtra("b_city",bus_list_class.getB_city());
            send.putExtra("b_address",bus_list_class.getB_address());
            send.putExtra("b_detail",bus_list_class.getB_detail());
            send.putExtra("b_lat",bus_list_class.getB_lat());
            send.putExtra("b_long",bus_list_class.getB_long());
            send.putExtra("b_email",bus_list_class.getB_email());
            send.putExtra("lat",bus_list_class.getB_lat());
            send.putExtra("long",bus_list_class.getB_long());
            context.startActivity(send);
        }
    });
    }

    @Override
    public businessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflator.inflate(R.layout.card_bus_list, null);
        return new businessViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return bus_list_classList.size();
    }

}


