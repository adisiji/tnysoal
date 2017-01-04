package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by one on 3/12/15.
 */
public class EditTextApple extends EditText{

    public EditTextApple(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextApple(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextApple(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = FontCache.get("fonts/AppleChancery.ttf", getContext());
            setTypeface(tf);
        }
    }

}