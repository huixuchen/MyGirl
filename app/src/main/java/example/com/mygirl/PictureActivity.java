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

/**
 * Created by Administrator on 16/10/11.
 */

public class PictureActivity extends AppCompatActivity {
    @BindView(R.id.list_picture)
    ListView mListView;
    private List<GalleryBean.TngouBean> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);
        loadDataFromServer();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int girlId = mDataList.get(position).getId();
                Intent intent = new Intent(PictureActivity.this,PictureDailogActivity.class);
                intent.putExtra("id",girlId);
                startActivity(intent);
            }
        });
    }
    private void loadDataFromServer() {
        int id = getIntent().getIntExtra("id",0);
        String url = "http://apis.baidu.com/tngou/gallery/list?id=" + id + "&page=1&rows=20";;
        SexyGirlRequest<GalleryBean> request = new SexyGirlRequest<>(url,GalleryBean.class,mListener,mErroListener);
        NetworkManager.sendRequest(request);
    }
    private Response.Listener<GalleryBean> mListener = new Response.Listener<GalleryBean>() {
        @Override
        public void onResponse(GalleryBean response) {
            mDataList = response.getTngou();
            PictureAdapter adapter = new PictureAdapter(PictureActivity.this,mDataList);
            mListView.setAdapter(adapter);
        }
    };
    private Response.ErrorListener mErroListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    };

}
