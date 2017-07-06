package kf.gyn.com.supermarket_no6.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import kf.gyn.com.supermarket_no6.R;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/6/30
 */

public class ImageTextGoup extends LinearLayout {
    public ImageTextGoup(Context context) {
        super(context);
    }

    public ImageTextGoup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);

    }


    public ImageTextGoup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);

    }

    private void initView(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.home_imagetext, this);

        //获取属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.home_ImageTextView);

        int image = typedArray.getResourceId(R.styleable.home_ImageTextView_home_image, R.mipmap.ic_launcher);
        String text = typedArray.getString(R.styleable.home_ImageTextView_home_text);


        ImageView imageView = (ImageView) view.findViewById(R.id.home_zuhe_image);

        TextView textView = (TextView) view.findViewById(R.id.home_zuhe_text);
        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/PingFang Light.ttf");

//使用字体

        textView.setTypeface(typeFace);


        imageView.setBackgroundResource(image);

        textView.setText(text + "");


        //利用
        typedArray.recycle();
    }
}
