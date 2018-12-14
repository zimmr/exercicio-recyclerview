package zimmer.adapterex1.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import zimmer.adapterex1.R;
import zimmer.adapterex1.adapter.ProductAdapter;
import zimmer.adapterex1.model.Product;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPrice;
    private Spinner spCategory;
    private Button btOK;
    private ArrayList<Product> products;
    private ProductAdapter adapter;
    private RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()){
                    toast("Name is empty!");
                    return;
                }
                if (etPrice.getText().toString().isEmpty()){
                    toast("Price is empty!");
                    return;
                }
                if (spCategory.getSelectedItemPosition() == 0){
                    toast("Select a category!");
                    return;
                }
                Product p = new Product();
                p.setName(etName.getText().toString());
                p.setPrice(Double.parseDouble(etPrice.getText().toString()));
                p.setCategory(spCategory.getSelectedItem().toString());
                products.add(p);
                adapter.notifyDataSetChanged();
                clear();
                close();
                toast("The product was registered succesfully!");
            }
        });
    }

    public void clear(){
        etName.setText("");
        etPrice.setText("");
    }

    public void close(){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void init(){
        etName = findViewById(R.id.pl_et_name);
        etPrice = findViewById(R.id.pl_et_price);
        spCategory = findViewById(R.id.ma_sp_categories);
        rvProducts = findViewById(R.id.ma_rv_products);
        btOK = findViewById(R.id.ma_bt_ok);

        products = new ArrayList<>();
        adapter = new ProductAdapter(MainActivity.this, products);
        //lvProducts.setAdapter(adapter);//

        rvProducts.setAdapter(adapter);
        rvProducts.setHasFixedSize(true);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
    }
}
