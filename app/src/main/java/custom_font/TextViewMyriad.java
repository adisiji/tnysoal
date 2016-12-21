package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by one on 3/12/15.
 */
public class TextViewMyriad extends TextView {

    public TextViewMyriad(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewMyriad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewMyriad(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MyriadPro-Regular.otf");
            setTypeface(tf);
        }
    }

}