package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by one on 3/12/15.
 */
public class TextViewMyriad extends TextView {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public TextViewMyriad(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyFont(context,attrs);
    }

    public TextViewMyriad(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyFont(context,attrs);
    }

    public TextViewMyriad(Context context) {
        super(context);
        applyFont(context,null);
    }

    private void applyFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);
        if(!isInEditMode()){
            Typeface customFont = selectTypeface(context, textStyle);
            setTypeface(customFont);
        }
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        /*
        * information about the TextView textStyle:
        * http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
        */
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.get("MyriadPro-Bold.otf", context);

            case Typeface.ITALIC: // italic
                return FontCache.get("MyriadPro-Italic.ttf", context);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.get("MyriadPro-Italic.ttf", context);

            case Typeface.NORMAL: // regular

            default:
                return FontCache.get("MyriadPro-Regular.otf", context);
        }
    }

}