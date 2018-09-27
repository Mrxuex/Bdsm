package com.example.zimuquan.circleofletters.modle.user;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by EDZ on 2018/9/25.
 */

public class LoginUserInfo implements Serializable {


    /**
     * Flag : 100
     * FlagString : 请求成功
     * data : {"user_id":68503,"nick_name":"冷元勋","nick_name_self":"","package":"com.scytbb.bdsm","is_anchor":0,"is_recommend":0,"recommend_weight":9999,"is_restricted":0,"is_video_authentication":0,"video_authentication_url":"","is_fill":1,"is_system":0,"status":1,"register_type":"0","online_state":4,"real_name":"","photo_list":"[]","photo_list_self":null,"photo_need_auth":"0","sex":1,"rank_user":1,"mobile":"16605711725","openid":"","unionid":"","password":"74d6f5f8aff72b3135036da9aaadf712","avatar":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/68503201809212345212233-800x800.jpg","avatar_to_self":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/68503201809212343103766-800x802.jpg","avatar_audit_success":1,"platform":"ios","location":"上海市","location_id":0,"birthday":633628800,"age":27,"signature":"。，。","signature_to_self":"","access_token":"","inviter_user_id":0,"bind_invite_time":0,"invite_effective":"1","is_mjh":0,"mjh_reason":0,"visitor":2,"follow":0,"follower":0,"property":"S","longitude":"121.430185","latitude":"31.215948","interest_label":null,"login_ip":"115.196.163.69","login_time":"2018-09-27 10:13:44","login_addr":"中国 浙江 杭州","login_count":23,"touch_live_times":0,"already_touch_user_list":"[2279,2963,3270,5243,2032,5516,1527,391,3888,3481,2908,3885,2113,1845,2285,10006,2288,945,5046,2882]","register_time":"2018-09-20 17:38:56","version":"mozilla/5.0(windowsnt10.0;wow64)applewebkit/537.36(khtml,likegecko)chrome/68.0.3440.106safari/537.36","register_version":"com.scytbb.bdsm/1.1.4/app","user_token":"","update_time":"2018-09-27 11:00:01","is_cancel_user":0,"is_avatar_check":0,"is_block":0,"block_time":0,"account_block_remark":null,"account_block_time":0,"im_token":"6VqQ7OG6APgkTyZF3xThSdhB2MqgR3qPZhqLXUHvnmQX5sAibl/R5FXOtg5RrAVAhxvu9kNaDzJDtuFZe8wRjw==","avatar_is_check":0,"token":"e2a3f119a8281bf6a78b5c27e72d5eae","is_pzp":0,"verf_step":1}
     */

    private int Flag;
    private String FlagString;
    private DataBean data;

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int Flag) {
        this.Flag = Flag;
    }

    public String getFlagString() {
        return FlagString;
    }

    public void setFlagString(String FlagString) {
        this.FlagString = FlagString;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 68503
         * nick_name : 冷元勋
         * nick_name_self :
         * package : com.scytbb.bdsm
         * is_anchor : 0
         * is_recommend : 0
         * recommend_weight : 9999
         * is_restricted : 0
         * is_video_authentication : 0
         * video_authentication_url :
         * is_fill : 1
         * is_system : 0
         * status : 1
         * register_type : 0
         * online_state : 4
         * real_name :
         * photo_list : []
         * photo_list_self : null
         * photo_need_auth : 0
         * sex : 1
         * rank_user : 1
         * mobile : 16605711725
         * openid :
         * unionid :
         * password : 74d6f5f8aff72b3135036da9aaadf712
         * avatar : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/68503201809212345212233-800x800.jpg
         * avatar_to_self : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/avatar/68503201809212343103766-800x802.jpg
         * avatar_audit_success : 1
         * platform : ios
         * location : 上海市
         * location_id : 0
         * birthday : 633628800
         * age : 27
         * signature : 。，。
         * signature_to_self :
         * access_token :
         * inviter_user_id : 0
         * bind_invite_time : 0
         * invite_effective : 1
         * is_mjh : 0
         * mjh_reason : 0
         * visitor : 2
         * follow : 0
         * follower : 0
         * property : S
         * longitude : 121.430185
         * latitude : 31.215948
         * interest_label : null
         * login_ip : 115.196.163.69
         * login_time : 2018-09-27 10:13:44
         * login_addr : 中国 浙江 杭州
         * login_count : 23
         * touch_live_times : 0
         * already_touch_user_list : [2279,2963,3270,5243,2032,5516,1527,391,3888,3481,2908,3885,2113,1845,2285,10006,2288,945,5046,2882]
         * register_time : 2018-09-20 17:38:56
         * version : mozilla/5.0(windowsnt10.0;wow64)applewebkit/537.36(khtml,likegecko)chrome/68.0.3440.106safari/537.36
         * register_version : com.scytbb.bdsm/1.1.4/app
         * user_token :
         * update_time : 2018-09-27 11:00:01
         * is_cancel_user : 0
         * is_avatar_check : 0
         * is_block : 0
         * block_time : 0
         * account_block_remark : null
         * account_block_time : 0
         * im_token : 6VqQ7OG6APgkTyZF3xThSdhB2MqgR3qPZhqLXUHvnmQX5sAibl/R5FXOtg5RrAVAhxvu9kNaDzJDtuFZe8wRjw==
         * avatar_is_check : 0
         * token : e2a3f119a8281bf6a78b5c27e72d5eae
         * is_pzp : 0
         * verf_step : 1
         */

        private int user_id;
        private String nick_name;
        private String nick_name_self;
        @SerializedName("package")
        private String packageX;
        private int is_anchor;
        private int is_recommend;
        private int recommend_weight;
        private int is_restricted;
        private int is_video_authentication;
        private String video_authentication_url;
        private int is_fill;
        private int is_system;
        private int status;
        private String register_type;
        private int online_state;
        private String real_name;
        private String photo_list;
        private Object photo_list_self;
        private String photo_need_auth;
        private int sex;
        private int rank_user;
        private String mobile;
        private String openid;
        private String unionid;
        private String password;
        private String avatar;
        private String avatar_to_self;
        private int avatar_audit_success;
        private String platform;
        private String location;
        private int location_id;
        private int birthday;
        private int age;
        private String signature;
        private String signature_to_self;
        private String access_token;
        private int inviter_user_id;
        private int bind_invite_time;
        private String invite_effective;
        private int is_mjh;
        private int mjh_reason;
        private int visitor;
        private int follow;
        private int follower;
        private String property;
        private String longitude;
        private String latitude;
        private Object interest_label;
        private String login_ip;
        private String login_time;
        private String login_addr;
        private int login_count;
        private int touch_live_times;
        private String already_touch_user_list;
        private String register_time;
        private String version;
        private String register_version;
        private String user_token;
        private String update_time;
        private int is_cancel_user;
        private int is_avatar_check;
        private int is_block;
        private int block_time;
        private Object account_block_remark;
        private int account_block_time;
        private String im_token;
        private int avatar_is_check;
        private String token;
        private int is_pzp;
        private int verf_step;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getNick_name_self() {
            return nick_name_self;
        }

        public void setNick_name_self(String nick_name_self) {
            this.nick_name_self = nick_name_self;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public int getIs_anchor() {
            return is_anchor;
        }

        public void setIs_anchor(int is_anchor) {
            this.is_anchor = is_anchor;
        }

        public int getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(int is_recommend) {
            this.is_recommend = is_recommend;
        }

        public int getRecommend_weight() {
            return recommend_weight;
        }

        public void setRecommend_weight(int recommend_weight) {
            this.recommend_weight = recommend_weight;
        }

        public int getIs_restricted() {
            return is_restricted;
        }

        public void setIs_restricted(int is_restricted) {
            this.is_restricted = is_restricted;
        }

        public int getIs_video_authentication() {
            return is_video_authentication;
        }

        public void setIs_video_authentication(int is_video_authentication) {
            this.is_video_authentication = is_video_authentication;
        }

        public String getVideo_authentication_url() {
            return video_authentication_url;
        }

        public void setVideo_authentication_url(String video_authentication_url) {
            this.video_authentication_url = video_authentication_url;
        }

        public int getIs_fill() {
            return is_fill;
        }

        public void setIs_fill(int is_fill) {
            this.is_fill = is_fill;
        }

        public int getIs_system() {
            return is_system;
        }

        public void setIs_system(int is_system) {
            this.is_system = is_system;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRegister_type() {
            return register_type;
        }

        public void setRegister_type(String register_type) {
            this.register_type = register_type;
        }

        public int getOnline_state() {
            return online_state;
        }

        public void setOnline_state(int online_state) {
            this.online_state = online_state;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getPhoto_list() {
            return photo_list;
        }

        public void setPhoto_list(String photo_list) {
            this.photo_list = photo_list;
        }

        public Object getPhoto_list_self() {
            return photo_list_self;
        }

        public void setPhoto_list_self(Object photo_list_self) {
            this.photo_list_self = photo_list_self;
        }

        public String getPhoto_need_auth() {
            return photo_need_auth;
        }

        public void setPhoto_need_auth(String photo_need_auth) {
            this.photo_need_auth = photo_need_auth;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getRank_user() {
            return rank_user;
        }

        public void setRank_user(int rank_user) {
            this.rank_user = rank_user;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar_to_self() {
            return avatar_to_self;
        }

        public void setAvatar_to_self(String avatar_to_self) {
            this.avatar_to_self = avatar_to_self;
        }

        public int getAvatar_audit_success() {
            return avatar_audit_success;
        }

        public void setAvatar_audit_success(int avatar_audit_success) {
            this.avatar_audit_success = avatar_audit_success;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getLocation_id() {
            return location_id;
        }

        public void setLocation_id(int location_id) {
            this.location_id = location_id;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getSignature_to_self() {
            return signature_to_self;
        }

        public void setSignature_to_self(String signature_to_self) {
            this.signature_to_self = signature_to_self;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public int getInviter_user_id() {
            return inviter_user_id;
        }

        public void setInviter_user_id(int inviter_user_id) {
            this.inviter_user_id = inviter_user_id;
        }

        public int getBind_invite_time() {
            return bind_invite_time;
        }

        public void setBind_invite_time(int bind_invite_time) {
            this.bind_invite_time = bind_invite_time;
        }

        public String getInvite_effective() {
            return invite_effective;
        }

        public void setInvite_effective(String invite_effective) {
            this.invite_effective = invite_effective;
        }

        public int getIs_mjh() {
            return is_mjh;
        }

        public void setIs_mjh(int is_mjh) {
            this.is_mjh = is_mjh;
        }

        public int getMjh_reason() {
            return mjh_reason;
        }

        public void setMjh_reason(int mjh_reason) {
            this.mjh_reason = mjh_reason;
        }

        public int getVisitor() {
            return visitor;
        }

        public void setVisitor(int visitor) {
            this.visitor = visitor;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public int getFollower() {
            return follower;
        }

        public void setFollower(int follower) {
            this.follower = follower;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getInterest_label() {
            return interest_label;
        }

        public void setInterest_label(Object interest_label) {
            this.interest_label = interest_label;
        }

        public String getLogin_ip() {
            return login_ip;
        }

        public void setLogin_ip(String login_ip) {
            this.login_ip = login_ip;
        }

        public String getLogin_time() {
            return login_time;
        }

        public void setLogin_time(String login_time) {
            this.login_time = login_time;
        }

        public String getLogin_addr() {
            return login_addr;
        }

        public void setLogin_addr(String login_addr) {
            this.login_addr = login_addr;
        }

        public int getLogin_count() {
            return login_count;
        }

        public void setLogin_count(int login_count) {
            this.login_count = login_count;
        }

        public int getTouch_live_times() {
            return touch_live_times;
        }

        public void setTouch_live_times(int touch_live_times) {
            this.touch_live_times = touch_live_times;
        }

        public String getAlready_touch_user_list() {
            return already_touch_user_list;
        }

        public void setAlready_touch_user_list(String already_touch_user_list) {
            this.already_touch_user_list = already_touch_user_list;
        }

        public String getRegister_time() {
            return register_time;
        }

        public void setRegister_time(String register_time) {
            this.register_time = register_time;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getRegister_version() {
            return register_version;
        }

        public void setRegister_version(String register_version) {
            this.register_version = register_version;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public int getIs_cancel_user() {
            return is_cancel_user;
        }

        public void setIs_cancel_user(int is_cancel_user) {
            this.is_cancel_user = is_cancel_user;
        }

        public int getIs_avatar_check() {
            return is_avatar_check;
        }

        public void setIs_avatar_check(int is_avatar_check) {
            this.is_avatar_check = is_avatar_check;
        }

        public int getIs_block() {
            return is_block;
        }

        public void setIs_block(int is_block) {
            this.is_block = is_block;
        }

        public int getBlock_time() {
            return block_time;
        }

        public void setBlock_time(int block_time) {
            this.block_time = block_time;
        }

        public Object getAccount_block_remark() {
            return account_block_remark;
        }

        public void setAccount_block_remark(Object account_block_remark) {
            this.account_block_remark = account_block_remark;
        }

        public int getAccount_block_time() {
            return account_block_time;
        }

        public void setAccount_block_time(int account_block_time) {
            this.account_block_time = account_block_time;
        }

        public String getIm_token() {
            return im_token;
        }

        public void setIm_token(String im_token) {
            this.im_token = im_token;
        }

        public int getAvatar_is_check() {
            return avatar_is_check;
        }

        public void setAvatar_is_check(int avatar_is_check) {
            this.avatar_is_check = avatar_is_check;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getIs_pzp() {
            return is_pzp;
        }

        public void setIs_pzp(int is_pzp) {
            this.is_pzp = is_pzp;
        }

        public int getVerf_step() {
            return verf_step;
        }

        public void setVerf_step(int verf_step) {
            this.verf_step = verf_step;
        }
    }
}
