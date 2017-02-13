package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 12/21/2016.
 */

public class TextViewApple extends TextView {
    
    public TextViewApple(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewApple(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewApple(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = FontCache.get("AppleChancery.ttf", getContext());
            setTypeface(tf);
        }
    }

}
