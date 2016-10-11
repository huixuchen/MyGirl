package example.com.mygirl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16/10/11.
 */

public class ClassifyAdapter extends SexyGirlBaseAdapter<ClassifyBean.TngouBean> {
    public ClassifyAdapter(Context context, List<ClassifyBean.TngouBean> dataList) {
        super(context, dataList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ButterKnife.bind(ViewHolder.class, convertView);
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item_classify, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(mDataList.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.tv)
        TextView tv;

        public ViewHolder(View root) {
            ButterKnife.bind(this, root);
        }
    }


}
