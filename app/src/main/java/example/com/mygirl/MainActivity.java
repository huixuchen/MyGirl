package example.com.mygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView mList;
    private List<ClassifyBean.TngouBean> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadDataFromServer();
        mList.setOnItemClickListener(mOnItemClickListener);
    }
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this,PictureActivity.class);
            intent.putExtra("id",position);
            startActivity(intent);
        }
    };

    private void loadDataFromServer() {
        String url = "http://apis.baidu.com/tngou/gallery/classify";
        SexyGirlRequest<ClassifyBean> request = new SexyGirlRequest<>(url, ClassifyBean.class, listener, erroListener);
        NetworkManager.sendRequest(request);
    }

    private Response.Listener<ClassifyBean> listener = new Response.Listener<ClassifyBean>() {
        @Override
        public void onResponse(ClassifyBean response) {
            mDataList = response.getTngou();
            ClassifyAdapter adapter = new ClassifyAdapter(MainActivity.this,mDataList);
            mList.setAdapter(adapter);
        }
    };
    private Response.ErrorListener erroListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };
}
