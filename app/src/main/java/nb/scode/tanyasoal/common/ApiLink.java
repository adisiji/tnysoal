package nb.scode.tanyasoal.common;

/**
 * Created by neobyte on 1/25/2017.
 */

public class ApiLink {

     public static String APP_TEMP_FOLDER = "news"; //directory for temporary storage of images from the camera

     public static String WEB_SITE = "http://tanyasoal.ourgoodhealth.us/";  //web site url address

     public static String CLIENT_ID = "1";  //Client ID | For identify the application | Example: 12567

     public static String API_DOMAIN = "http://tanyasoal.ourgoodhealth.us/";  //url address to which the application sends requests

     public static String API_FILE_EXTENSION = ".inc.php";
     public static String API_VERSION = "v1";

     public static String METHOD_ACCOUNT_LOGIN =  "/method/account.signIn" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_SIGNUP =  "" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_AUTHORIZE =  "/method/account.authorize" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_SET_GCM_TOKEN =  "/method/account.setGcmToken" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_LOGINBYFACEBOOK =  "/method/account.signInByFacebook" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_RECOVERY =  "/method/account.recovery" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_SETPASSWORD =  "/method/account.setPassword" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_DEACTIVATE =  "/method/account.deactivate" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_SAVE_SETTINGS =  "/method/account.saveSettings" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_CONNECT_TO_FACEBOOK =  "/method/account.connectToFacebook" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_DISCONNECT_FROM_FACEBOOK =  "/method/account.disconnectFromFacebook" + API_FILE_EXTENSION;
     public static String METHOD_ACCOUNT_LOGOUT =  "/method/account.logOut" + API_FILE_EXTENSION;

     public static String METHOD_ACCOUNT_SET_GEO_LOCATION =  "/method/account.setGeoLocation" + API_FILE_EXTENSION;

     public static String METHOD_CATEGORIES_GET =  "/method/categories.get" + API_FILE_EXTENSION;
     public static String METHOD_CATEGORY_GET =  "/method/category.get" + API_FILE_EXTENSION;

     public static String METHOD_SUPPORT_SEND_TICKET =  "/method/support.sendTicket" + API_FILE_EXTENSION;

     public static String METHOD_SETTINGS_COMMENT_REPLY_GCM =  "/method/account.setAllowCommentReplyGCM" + API_FILE_EXTENSION;

     public static String METHOD_PROFILE_GET =  "/method/profile.get" + API_FILE_EXTENSION;
     public static String METHOD_PROFILE_REPORT =  "/method/profile.report" + API_FILE_EXTENSION;
     public static String METHOD_PROFILE_UPLOADPHOTO =  "/method/profile.uploadPhoto" + API_FILE_EXTENSION;
     public static String METHOD_PROFILE_UPLOADCOVER =  "/method/profile.uploadCover" + API_FILE_EXTENSION;

     public static String METHOD_NOTIFICATIONS_GET =  "/method/notifications.get" + API_FILE_EXTENSION;
     public static String METHOD_ITEM_GET =  "/method/item.get" + API_FILE_EXTENSION;
     public static String METHOD_STREAM_GET =  "/method/stream.get" + API_FILE_EXTENSION;
     public static String METHOD_POPULAR_GET =  "/method/popular.get" + API_FILE_EXTENSION;

     public static String METHOD_APP_CHECKUSERNAME =  "/method/app.checkUsername" + API_FILE_EXTENSION;
     public static String METHOD_APP_TERMS =  "/method/app.terms" + API_FILE_EXTENSION;
     public static String METHOD_APP_THANKS =  "/method/app.thanks" + API_FILE_EXTENSION;
     public static String METHOD_APP_SEARCH =  "/method/app.search" + API_FILE_EXTENSION;

     public static String METHOD_ITEMS_LIKE =  "/method/items.like" + API_FILE_EXTENSION;

     public static String METHOD_FAVORITES_GET =  "/method/favorites.get" + API_FILE_EXTENSION;

     public static String METHOD_COMMENTS_REMOVE =  "/method/comments.remove" + API_FILE_EXTENSION;
     public static String METHOD_COMMENTS_NEW =  "/method/comments.new" + API_FILE_EXTENSION;

     int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE_PHOTO = 1;                  //WRITE_EXTERNAL_STORAGE
}
