package example.com.mygirl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16/10/11.
 */

public class PictureDailogActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_dilog);
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra("id",0);
        String url = "http://www.tngou.net/tnfs/show/" + id;
        mWebView.loadUrl(url);
    }
}
