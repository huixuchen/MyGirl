package example.com.mygirl;

import android.app.Application;

/**
 * Created by Administrator on 16/10/11.
 */

public class SexyGirlApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(getApplicationContext());
    }
}
