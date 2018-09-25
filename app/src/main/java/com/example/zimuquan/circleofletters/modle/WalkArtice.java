package com.example.zimuquan.circleofletters.modle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EDZ on 2018/9/18.
 */

public class WalkArtice implements Serializable {

    /**
     * Flag : 100
     * FlagString : 请求成功
     * data : [{"user_id":127,"nick_name":"小微","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153173607467905108.jpg\"]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/153173594166819104.jpg","location":"上海","age":21,"is_vip":0,"property":"M","signature":"遇见","is_follow":0},{"user_id":131,"nick_name":"二次次次次次","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179649184321101.jpg\",\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179649224338110.jpg\",\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179649224327106.jpg\"]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/153179642377481105.jpg","location":"温州","age":21,"is_vip":0,"property":"M","signature":"喜欢卡卡卡卡卡卡卡卡卡卡卡卡通","is_follow":0},{"user_id":130,"nick_name":"主人在哪","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179639153498109.jpg\",\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179639159314100.jpg\",\"http:\\/\\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\\/photo\\/153179639193041106.jpg\"]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/15317962977408899.jpg","location":"武汉","age":18,"is_vip":0,"property":"M","signature":"只想找一个真的懂调教的人","is_follow":0},{"user_id":62990,"nick_name":"凌雪","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi112.jpg","location":"三亚市","age":21,"is_vip":0,"property":"M","signature":"有没有帅气的小哥哥","is_follow":0},{"user_id":62992,"nick_name":"双子","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi114.jpg","location":"贵阳市","age":28,"is_vip":0,"property":"M","signature":"你答应过的我都记得","is_follow":0},{"user_id":62993,"nick_name":"ZE","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi115.jpg","location":"武汉市","age":27,"is_vip":0,"property":"M","signature":"有些人走着走着就散了","is_follow":0},{"user_id":62994,"nick_name":"高尔夫小女","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi116.jpg","location":"长沙市","age":22,"is_vip":0,"property":"M","signature":"心宽体胖的小胖子","is_follow":0},{"user_id":62995,"nick_name":"AIMEE","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi117.jpg","location":"郑州市","age":21,"is_vip":0,"property":"M","signature":"全幼儿园第一可爱的我","is_follow":0},{"user_id":62996,"nick_name":"KK","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi118.jpg","location":"太原市","age":24,"is_vip":0,"property":"M","signature":"我走了,你一个人要好好地","is_follow":0},{"user_id":62997,"nick_name":"晓玲弄","is_pay_authentication_fee":1,"is_video_authentication":0,"video_authentication_url":"","online_state":4,"photo_list":"[]","sex":2,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/simi119.jpg","location":"大连市","age":27,"is_vip":0,"property":"M","signature":"你走吧,我妈不让我跟你玩","is_follow":0}]
     */

    private int Flag;
    private String FlagString;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 127
         * nick_name : 小微
         * is_pay_authentication_fee : 1
         * is_video_authentication : 0
         * video_authentication_url :
         * online_state : 4
         * photo_list : ["http:\/\/bdsm-1256663796.cos.ap-shanghai.myqcloud.com\/photo\/153173607467905108.jpg"]
         * sex : 2
         * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/153173594166819104.jpg
         * location : 上海
         * age : 21
         * is_vip : 0
         * property : M
         * signature : 遇见
         * is_follow : 0
         */

        private int user_id;
        private String nick_name;
        private int is_pay_authentication_fee;
        private int is_video_authentication;
        private String video_authentication_url;
        private int online_state;
        private String photo_list;
        private int sex;
        private String avatar;
        private String location;
        private int age;
        private int is_vip;
        private String property;
        private String signature;
        private int is_follow;

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

        public int getIs_pay_authentication_fee() {
            return is_pay_authentication_fee;
        }

        public void setIs_pay_authentication_fee(int is_pay_authentication_fee) {
            this.is_pay_authentication_fee = is_pay_authentication_fee;
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

        public int getOnline_state() {
            return online_state;
        }

        public void setOnline_state(int online_state) {
            this.online_state = online_state;
        }

        public String getPhoto_list() {
            return photo_list;
        }

        public void setPhoto_list(String photo_list) {
            this.photo_list = photo_list;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getIs_follow() {
            return is_follow;
        }

        public void setIs_follow(int is_follow) {
            this.is_follow = is_follow;
        }
    }
}
