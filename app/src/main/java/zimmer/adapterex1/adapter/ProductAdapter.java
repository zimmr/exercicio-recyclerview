package zimmer.adapterex1.adapter;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import zimmer.adapterex1.R;
import zimmer.adapterex1.model.Product;
import zimmer.adapterex1.ui.MainActivity;


public class ProductAdapter extends RecyclerView.Adapter{

    private Context context;
    private ArrayList<Product> products;

    private static ClickListener clickListener;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_line, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder h = (ViewHolder) viewHolder;
        Product p = products.get(i);

        h.tvName.setText(p.getName());
        h.tvPrice.setText("$" + String.valueOf(p.getPrice()));

        Picasso.get()
                .load(p.verifyCategory())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(h.ivIcon);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private final TextView tvName;
        private final TextView tvPrice;
        private final ImageView ivIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvName = itemView.findViewById(R.id.pl_et_name);
            tvPrice = itemView.findViewById(R.id.pl_et_price);
            ivIcon = itemView.findViewById(R.id.pl_iv_icon);
        }

        @Override
        public void onClick(View v) {
            clickListener.OnItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.OnItemLongClick(v, getAdapterPosition());
            return true;
        }
    }

    public void setOnItemClickListener(ClickListener clickListener){
        ProductAdapter.clickListener = clickListener;
    }

    public interface ClickListener{
        void OnItemClick(View v, int position);
        void OnItemLongClick(View v, int position);
    }
}
