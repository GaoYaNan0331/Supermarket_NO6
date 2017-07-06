package kf.gyn.com.supermarket_no6.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import kf.gyn.com.supermarket_no6.R;


/**
 * @类的用途:
 * @author:王帅
 * @date:2017/6/28
 */

public class ImageTextViewTwo extends LinearLayout {

    private ImageView imageView;
    private TextView textView;

    public ImageTextViewTwo(Context context) {
        super(context);

    }

    public ImageTextViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);

    }

    public ImageTextViewTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {

        View view = inflate(getContext(), R.layout.custom_text_two, this);

        //获取属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ImageTextView);

        int image = typedArray.getResourceId(R.styleable.ImageTextView_image, 0);

        String text = typedArray.getString(R.styleable.ImageTextView_text);

        int textColor = typedArray.getResourceId(R.styleable.ImageTextView_textColor, 0);

        imageView = (ImageView) view.findViewById(R.id.cu_image);

        textView = (TextView) view.findViewById(R.id.cu_text);

        imageView.setBackgroundResource(image);

        textView.setText(text + "");

        textView.setTextColor(getResources().getColorStateList(textColor));



        //利用
        typedArray.recycle();
    }

    public void setSelected(boolean flag) {

        imageView.setSelected(flag);

        textView.setSelected(flag);

    }
}
