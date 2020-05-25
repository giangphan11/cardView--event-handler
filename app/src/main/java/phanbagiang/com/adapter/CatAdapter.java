package phanbagiang.com.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import phanbagiang.com.cardviewp1.R;
import phanbagiang.com.model.Cat;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {
    Activity context;
    ArrayList<Cat>dsCat;


    public CatAdapter(Activity context, ArrayList<Cat> dsCat) {
        this.context = context;
        this.dsCat = dsCat;
    }
    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customView=inflater.inflate(R.layout.card_view_item,parent,false);
        return new CatHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Cat cat=dsCat.get(position);
        holder.imghinh.setImageResource(cat.getHinh());
        holder.txtTen.setText(cat.getTen());
        holder.txtGia.setText(cat.getGia()+"");
    }
    public void deleteItem(int position){
        dsCat.remove(position);

        // cập nhật lại danh sách sau khi xoá
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return dsCat.size();
    }

    class CatHolder extends RecyclerView.ViewHolder {
        ImageView imghinh;
        TextView txtTen,txtGia;
        public CatHolder(@NonNull View itemView) {
            super(itemView);
            imghinh=itemView.findViewById(R.id.imgHinh);
            txtTen=itemView.findViewById(R.id.txtTen);
            txtGia=itemView.findViewById(R.id.txtGia);
        }
    }
}
