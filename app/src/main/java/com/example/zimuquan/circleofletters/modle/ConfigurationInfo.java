package com.example.zimuquan.circleofletters.modle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EDZ on 2018/9/26.
 */

public class ConfigurationInfo implements Serializable {


    /**
     * Flag : 100
     * FlagString : 请求成功
     * data : {"index_label":[{"name":"recommend","title":"推荐"},{"name":"circle","title":"圈子"},{"name":"new","title":"新人"}],"authentication_fee_1":"1","authentication_content":"1、\u201c字母圈\u201d致力于打造100%真实健康交友平台，通过收取基本的认证费用，筛选掉大部分酒饭托、微商广告等虚假用户及保证交友安全。\n2、 进行严格的身份认证需要耗费大量的人力成本，收取基本的认证费用可以保证\u201c字母圈\u201d持续稳定运营。","authentication_detail":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146976477521105.png","member_detail":"http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146580339324111.jpg","authentication_title":"为什么要缴纳费用？","authentication_fee_2":"1","service_wx":"scytbb","update_info":{"is_mandatory":0,"tips_number":"3","update_addr":"","new_version":"1.1.5","update_info":"有新版本，前往更新","need_update":1}}
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
         * index_label : [{"name":"recommend","title":"推荐"},{"name":"circle","title":"圈子"},{"name":"new","title":"新人"}]
         * authentication_fee_1 : 1
         * authentication_content : 1、“字母圈”致力于打造100%真实健康交友平台，通过收取基本的认证费用，筛选掉大部分酒饭托、微商广告等虚假用户及保证交友安全。
         2、 进行严格的身份认证需要耗费大量的人力成本，收取基本的认证费用可以保证“字母圈”持续稳定运营。
         * authentication_detail : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146976477521105.png
         * member_detail : http://bdsm-1256663796.cos.ap-shanghai.myqcloud.com/config/153146580339324111.jpg
         * authentication_title : 为什么要缴纳费用？
         * authentication_fee_2 : 1
         * service_wx : scytbb
         * update_info : {"is_mandatory":0,"tips_number":"3","update_addr":"","new_version":"1.1.5","update_info":"有新版本，前往更新","need_update":1}
         */

        private String authentication_fee_1;
        private String authentication_content;
        private String authentication_detail;
        private String member_detail;
        private String authentication_title;
        private String authentication_fee_2;
        private String service_wx;
        private UpdateInfoBean update_info;
        private List<IndexLabelBean> index_label;

        public String getAuthentication_fee_1() {
            return authentication_fee_1;
        }

        public void setAuthentication_fee_1(String authentication_fee_1) {
            this.authentication_fee_1 = authentication_fee_1;
        }

        public String getAuthentication_content() {
            return authentication_content;
        }

        public void setAuthentication_content(String authentication_content) {
            this.authentication_content = authentication_content;
        }

        public String getAuthentication_detail() {
            return authentication_detail;
        }

        public void setAuthentication_detail(String authentication_detail) {
            this.authentication_detail = authentication_detail;
        }

        public String getMember_detail() {
            return member_detail;
        }

        public void setMember_detail(String member_detail) {
            this.member_detail = member_detail;
        }

        public String getAuthentication_title() {
            return authentication_title;
        }

        public void setAuthentication_title(String authentication_title) {
            this.authentication_title = authentication_title;
        }

        public String getAuthentication_fee_2() {
            return authentication_fee_2;
        }

        public void setAuthentication_fee_2(String authentication_fee_2) {
            this.authentication_fee_2 = authentication_fee_2;
        }

        public String getService_wx() {
            return service_wx;
        }

        public void setService_wx(String service_wx) {
            this.service_wx = service_wx;
        }

        public UpdateInfoBean getUpdate_info() {
            return update_info;
        }

        public void setUpdate_info(UpdateInfoBean update_info) {
            this.update_info = update_info;
        }

        public List<IndexLabelBean> getIndex_label() {
            return index_label;
        }

        public void setIndex_label(List<IndexLabelBean> index_label) {
            this.index_label = index_label;
        }

        public static class UpdateInfoBean {
            /**
             * is_mandatory : 0
             * tips_number : 3
             * update_addr :
             * new_version : 1.1.5
             * update_info : 有新版本，前往更新
             * need_update : 1
             */

            private int is_mandatory;
            private String tips_number;
            private String update_addr;
            private String new_version;
            private String update_info;
            private int need_update;

            public int getIs_mandatory() {
                return is_mandatory;
            }

            public void setIs_mandatory(int is_mandatory) {
                this.is_mandatory = is_mandatory;
            }

            public String getTips_number() {
                return tips_number;
            }

            public void setTips_number(String tips_number) {
                this.tips_number = tips_number;
            }

            public String getUpdate_addr() {
                return update_addr;
            }

            public void setUpdate_addr(String update_addr) {
                this.update_addr = update_addr;
            }

            public String getNew_version() {
                return new_version;
            }

            public void setNew_version(String new_version) {
                this.new_version = new_version;
            }

            public String getUpdate_info() {
                return update_info;
            }

            public void setUpdate_info(String update_info) {
                this.update_info = update_info;
            }

            public int getNeed_update() {
                return need_update;
            }

            public void setNeed_update(int need_update) {
                this.need_update = need_update;
            }
        }

        public static class IndexLabelBean {
            /**
             * name : recommend
             * title : 推荐
             */

            private String name;
            private String title;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
