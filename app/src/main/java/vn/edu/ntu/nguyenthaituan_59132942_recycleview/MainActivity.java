package vn.edu.ntu.nguyenthaituan_59132942_recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.controller.ICartController;
import vn.edu.ntu.model.Product;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<Product> listProducts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();

    }

    private  void addView(){
        rvListProduct = findViewById(R.id.rvmathang);
        rvListProduct.setLayoutManager(new LinearLayoutManager(this));
        ICartController controller =(ICartController) getApplication();
        listProducts = controller.getAProducts();
        adapter = new ProductAdapter(listProducts);
        rvListProduct.setAdapter(adapter);

    }

    //khoi tao cua recycleview
    private class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice, txtDesc;
        ImageView imageAddToCard;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName        = this.itemView.findViewById(R.id.txtName);
            txtPrice       = this.itemView.findViewById(R.id.txtPrice);
            txtDesc        = this.itemView.findViewById(R.id.txtDesc);
            imageAddToCard =  this.itemView.findViewById(R.id.imvAddToCart);
        }


        public void bind(Product p)
        {
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDesc.setText(p.getDesc());
        }
    }

    //VH: viewholder
    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>
    {
        List<Product> listProducts;

        public ProductAdapter(List<Product> listProducts) {
            this.listProducts = listProducts;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //LayoutInflater do flater cung cap
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent,false);

           //view: Layout product da thiet ke
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind((listProducts).get(position));
        }

        //position; vi tri cua Adapter


        @Override
        public int getItemCount() {
            return listProducts.size();
        }
    }
}
