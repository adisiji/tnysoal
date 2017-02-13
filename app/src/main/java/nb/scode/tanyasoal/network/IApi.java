package nb.scode.tanyasoal.network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import nb.scode.tanyasoal.modelRetro.BaseApiResponse;
import nb.scode.tanyasoal.modelRetro.PackageRetro;
import nb.scode.tanyasoal.modelRetro.ProfileResponse;
import nb.scode.tanyasoal.modelRetro.QuestionRetro;
import nb.scode.tanyasoal.models.Academics;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by User on 1/17/2017.
 */

public interface IApi {

    @FormUrlEncoded
    @POST("/account.setGcmToken.inc")
    Call <JSONObject> setGcmToken(@Field("accountId")String  id,
                                  @Field("accessToken")String  token,
                                  @Field("gcm_regId")String  gcmtoken);

    @FormUrlEncoded
    @POST("/authenticate")
    Call <JSONObject> authenticate(@Field("email") String email,
                                   @Field("password")String password,
                                   @Field("deviceRegistrationId") String deviceId,
                                   @Field("deviceType")String deviceType);

    @GET("/register/predefines")
    Call<Academics> getAcademics();

    @FormUrlEncoded
    @POST("/register")
    Call <BaseApiResponse> signUp(@Field("email") String email,
                             @Field("username")String username,
                             @Field("password") String password,
                             @Field("academic_type_id") int jns_akad,
                             @Field("academic_level_id") int tkt_akad,
                             @Field("register_promo_code") String promo,
                             @Field("school_name") String sekolah,
                             @Field("first_name") String fullname,
                             @Field("phone_number") String no_hp,
                             @Field("dob") String birthday);

    @FormUrlEncoded
    @POST("/validateForgotPasswordInfo")
    Call <BaseApiResponse> forgotpwd(@Field("email") String email,
                                @Field("first_name") String first_name,
                                @Field("phone_number") String phone,
                                @Field("dob") String birthday);


    @FormUrlEncoded
    @POST("/resetPassword")
    Call <BaseApiResponse> resetpwd(@Field("email") String email,
                               @Field("password")String password,
                               @Field("confirm_password") String conf_pass);


    @GET("/user/")
    Call <ProfileResponse> getProfile(@Query("token") String token);

    @FormUrlEncoded
    @POST("/user/")
    Call<BaseApiResponse> setProfile(@Query("token") String token,
                                @Field("email") String email,
                                @Field("first_name") String first_name,
                                @Field("phone_number") String phone,
                                @Field("dob") String birthday,
                                @Field("academic_type_id") int academic_type,
                                @Field("academic_level_id") int academic_level,
                                @Field("school_name") String sekolah);

    @POST("/voucher/request/")
    Call<BaseApiResponse> reqVoucher(@Field("email") String email,
                                     @Field("phone_number") String phone,
                                     @Field("amount") long amount);

    @POST("/voucher/use")
    Call<BaseApiResponse> useVoucher(@Field("voucherCode") String voucherCode);

    @GET("/services")
    Call<JSONArray> getServices();

    @GET("/packages")
    Call<List<PackageRetro>> getPackage();

    @POST("/subscription/subscribe")
    Call<BaseApiResponse>  subscribe(@Query("token") String token);

    @GET("/user/balance")
    Call<Integer> getBalance(@Query("token") String token);

    @GET("/question/predefines")
    Call<QuestionRetro> getQuestion(@Query("token") String token);

}
