package com.example.zimuquan.circleofletters.modle.user;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EDZ on 2018/9/25.
 */

public class UserAllInfo implements Serializable {

    /**
     * Flag : 100
     * FlagString : 请求成功
     * data : {"user_id":21,"nick_name":"你去哪里","is_vip":0,"is_video_authentication":0,"video_authentication_url":"","sex":1,"avatar":"https://bdsm-1256663796.file.myqcloud.com/avatar/55.jpg","age":22,"photo_list":[],"is_black":0,"location":"大连市","property":"S","signature":"不掩己拙，不揭人短；不失童趣，不露媚颜；不求人喜，不招人烦","interest_label":[{"id":41,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"e9c07e","name":"我   是","listorder":1,"child":["已领养","傻白甜"]},{"id":48,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"655b4d","name":"我拒绝","listorder":3,"child":["约束","装高冷"]}],"is_follow":0,"dynamics_list":[]}
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
         * user_id : 21
         * nick_name : 你去哪里
         * is_vip : 0
         * is_video_authentication : 0
         * video_authentication_url :
         * sex : 1
         * avatar : https://bdsm-1256663796.file.myqcloud.com/avatar/55.jpg
         * age : 22
         * photo_list : []
         * is_black : 0
         * location : 大连市
         * property : S
         * signature : 不掩己拙，不揭人短；不失童趣，不露媚颜；不求人喜，不招人烦
         * interest_label : [{"id":41,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png","color":"e9c07e","name":"我   是","listorder":1,"child":["已领养","傻白甜"]},{"id":48,"icon_url":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/15311106106783699.png","color":"655b4d","name":"我拒绝","listorder":3,"child":["约束","装高冷"]}]
         * is_follow : 0
         * dynamics_list : []
         */

        private int user_id;
        private String nick_name;
        private int is_vip;
        private int is_video_authentication;
        private String video_authentication_url;
        private int sex;
        private String avatar;
        private int age;
        private int is_black;
        private String location;
        private String property;
        private String signature;
        private int is_follow;
        private List<?> photo_list;
        private List<InterestLabelBean> interest_label;
        private List<?> dynamics_list;

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

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getIs_black() {
            return is_black;
        }

        public void setIs_black(int is_black) {
            this.is_black = is_black;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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

        public List<?> getPhoto_list() {
            return photo_list;
        }

        public void setPhoto_list(List<?> photo_list) {
            this.photo_list = photo_list;
        }

        public List<InterestLabelBean> getInterest_label() {
            return interest_label;
        }

        public void setInterest_label(List<InterestLabelBean> interest_label) {
            this.interest_label = interest_label;
        }

        public List<?> getDynamics_list() {
            return dynamics_list;
        }

        public void setDynamics_list(List<?> dynamics_list) {
            this.dynamics_list = dynamics_list;
        }

        public static class InterestLabelBean {
            /**
             * id : 41
             * icon_url : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/icon/153111049137507104.png
             * color : e9c07e
             * name : 我   是
             * listorder : 1
             * child : ["已领养","傻白甜"]
             */

            private int id;
            private String icon_url;
            private String color;
            private String name;
            private int listorder;
            private List<String> child;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getListorder() {
                return listorder;
            }

            public void setListorder(int listorder) {
                this.listorder = listorder;
            }

            public List<String> getChild() {
                return child;
            }

            public void setChild(List<String> child) {
                this.child = child;
            }
        }
    }
}
