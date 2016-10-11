package example.com.mygirl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 16/10/11.
 */

public class PictureAdapter extends SexyGirlBaseAdapter<GalleryBean.TngouBean> {
    public PictureAdapter(Context context, List<GalleryBean.TngouBean> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = View.inflate(mContext, R.layout.list_item_picture, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageDec.setText(mDataList.get(position).getTitle());
        String url = "http://tnfs.tngou.net/image" + mDataList.get(position).getImg();
        Glide.with(mContext).load(url).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.image);
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.image_dec)
        TextView imageDec;
        @BindView(R.id.list_image)
        ImageView image;

        private ViewHolder(View root) {
            ButterKnife.bind(this, root);
        }
    }
}
