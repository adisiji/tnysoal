package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by one on 3/12/15.
 */
public class EditTextMyriad extends EditText{

    public EditTextMyriad(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextMyriad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextMyriad(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = FontCache.get("fonts/MyriadPro-Regular.otf", getContext());
            setTypeface(tf);
        }
    }

}