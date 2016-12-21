package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 12/21/2016.
 */

public class TextViewAmerica extends TextView {
    
    public TextViewAmerica(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewAmerica(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewAmerica(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/American-Typewriter-Regular.ttf");
            setTypeface(tf);
        }
    }

}
