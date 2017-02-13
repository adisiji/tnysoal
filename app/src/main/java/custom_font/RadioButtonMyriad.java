package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by User on 1/13/2017.
 */

public class RadioButtonMyriad extends RadioButton {
    public RadioButtonMyriad(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RadioButtonMyriad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioButtonMyriad(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = FontCache.get("MyriadPro-Regular.otf", getContext());
            setTypeface(tf);
        }
    }
}
