package example.com.mygirl;

import android.content.Context;
import android.util.Log;
import android.widget.BaseAdapter;

import java.util.List;

import static example.com.mygirl.ClassifyBean.TAG;


/**
 * Created by Administrator on 16/10/11.
 */

public abstract class SexyGirlBaseAdapter<T> extends BaseAdapter {
    protected List<T> mDataList;
    protected Context mContext;
    public SexyGirlBaseAdapter(Context context,List<T> dataList){
        mDataList = dataList;
        mContext = context;
    }
    @Override
    public int getCount() {
        Log.d(TAG, "getCount: "+(mDataList==null?0:mDataList.size()));
        return mDataList==null?0:mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
