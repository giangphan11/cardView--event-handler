package phanbagiang.com.cardviewp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import phanbagiang.com.adapter.CatAdapter;
import phanbagiang.com.model.Cat;
import phanbagiang.com.model.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleView;
    CatAdapter catAdapter;
    ArrayList<Cat>dsCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w=getWindow();
        //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        addControls();
        addData();
        addEvents();
    }

    private void addEvents() {
        recycleView.addOnItemTouchListener(new RecyclerItemClickListener(this, recycleView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Cat cat=dsCat.get(position);
                Toast.makeText(MainActivity.this,"Bạn chọn "+cat.getTen(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                catAdapter.deleteItem(position);
            }
        }));
    }

    private void addData() {
        Cat cat1=new Cat(R.drawable.cat1,"Cat1",80000);
        Cat cat2=new Cat(R.drawable.cat2,"Cat2",240000);
        Cat cat3=new Cat(R.drawable.cat3,"Cat3",805000);
        Cat cat4=new Cat(R.drawable.cat4,"Cat4",200300);
        Cat cat5=new Cat(R.drawable.cat5,"Cat5",6000220);
        Cat cat6=new Cat(R.drawable.cat6,"Cat6",70000);
        Cat cat7=new Cat(R.drawable.cat7,"Cat7",120000);
        Cat cat8=new Cat(R.drawable.cat8,"Cat8",82000);
        Cat cat9=new Cat(R.drawable.cat9,"Cat9",13000);
        Cat cat10=new Cat(R.drawable.cat10,"Cat10",40000);

        dsCat.add(cat1);dsCat.add(cat2);dsCat.add(cat3);dsCat.add(cat4);dsCat.add(cat5);
        dsCat.add(cat6);dsCat.add(cat7);dsCat.add(cat8);dsCat.add(cat9);dsCat.add(cat10);
    }

    private void addControls() {
        dsCat=new ArrayList<>();
        recycleView=findViewById(R.id.recCat);
        catAdapter=new CatAdapter(MainActivity.this,dsCat);
        recycleView.setAdapter(catAdapter);

        // hoạt ảnh khi xoá
        RecyclerView.ItemAnimator setItem=new DefaultItemAnimator();
        setItem.setRemoveDuration(500);
        recycleView.setItemAnimator(setItem);
        recycleView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycleView.setLayoutManager(layoutManager);
    }
}
