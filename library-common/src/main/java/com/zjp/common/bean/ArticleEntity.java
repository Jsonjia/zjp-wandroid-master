package com.zjp.common.bean;

import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zjp.network.constant.C;

import java.util.List;

/**
 * Created by zjp on 2020/5/12 11:18
 */
public class ArticleEntity {

    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":445,"chapterName":"Service","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13362,"link":"https://mp.weixin.qq.com/s/fcdBEq7qOw8vLHZ0sI3KIA","niceDate":"10小时前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1589214486000,"selfVisible":0,"shareDate":1589163532000,"shareUser":"轻风白宇","superChapterId":178,"superChapterName":"framework","tags":[],"title":"Android实现长按复制文本功能","type":0,"userId":29185,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":267,"chapterName":"handler","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13373,"link":"https://juejin.im/post/5d4e6af7e51d4561ba48fdb0","niceDate":"10小时前","niceShareDate":"13小时前","origin":"","prefix":"","projectLink":"","publishTime":1589214421000,"selfVisible":0,"shareDate":1589205762000,"shareUser":"wangzhengyi","superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"揭秘 Android 同步消息屏障：target==null？","type":0,"userId":38889,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":433,"chapterName":"Window","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13369,"link":"https://www.jianshu.com/p/28c61d49b4a1","niceDate":"10小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1589214407000,"selfVisible":0,"shareDate":1589180072000,"shareUser":"深红骑士","superChapterId":178,"superChapterName":"framework","tags":[],"title":"android 沉淀 - 渲染原理","type":0,"userId":29303,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13363,"link":"https://mp.weixin.qq.com/s/Ju8BXLP1mGXAFXFS5JvsHA","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1589164979000,"selfVisible":0,"shareDate":1589164979000,"shareUser":"飞洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"面试官：你做过组件化？","type":0,"userId":31360,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13361,"link":"https://juejin.im/post/5eb183a8e51d454da077b113","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1589162514000,"selfVisible":0,"shareDate":1589162514000,"shareUser":"maoqitian","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"深入理解Android之Service绑定流程","type":0,"userId":863,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":13360,"link":"https://weilu.blog.csdn.net/article/details/106046434","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1589160948000,"selfVisible":0,"shareDate":1589160948000,"shareUser":"唯鹿","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Flutter性能优化实践 &mdash;&mdash; UI篇","type":0,"userId":2657,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13345,"link":"https://juejin.im/post/5eb63bcae51d4528dd23c29b","niceDate":"2天前","niceShareDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1589078020000,"selfVisible":0,"shareDate":1589078020000,"shareUser":"ClericYi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"锦囊篇｜一文摸懂RxJava","type":0,"userId":43964,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":424,"chapterName":"协程","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13300,"link":"https://www.jianshu.com/p/e1061501bdc4","niceDate":"2020-05-08 22:19","niceShareDate":"2020-05-08 00:02","origin":"","prefix":"","projectLink":"","publishTime":1588947550000,"selfVisible":0,"shareDate":1588867346000,"shareUser":"鸿洋","superChapterId":232,"superChapterName":"Kotlin","tags":[],"title":"Kotlin学习手册（十）带你真正理解什么是Kotlin协程","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13303,"link":"https://juejin.im/post/5eb3ab29e51d453914497aa4","niceDate":"2020-05-08 22:18","niceShareDate":"2020-05-08 08:41","origin":"","prefix":"","projectLink":"","publishTime":1588947538000,"selfVisible":0,"shareDate":1588898496000,"shareUser":"goweii","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android R 新特性变化","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13304,"link":"https://mp.weixin.qq.com/s/BkXGkLESC84Jhzyx9y4ddg","niceDate":"2020-05-08 22:18","niceShareDate":"2020-05-08 08:45","origin":"","prefix":"","projectLink":"","publishTime":1588947510000,"selfVisible":0,"shareDate":1588898706000,"shareUser":"RookieJay","superChapterId":197,"superChapterName":"热门专题","tags":[],"title":"Android面经分享，失业两个月，五一节前拿到offer","type":0,"userId":12331,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":94,"chapterName":"事件分发","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13306,"link":"https://juejin.im/post/5eb4e92ff265da7ba0582755","niceDate":"2020-05-08 22:17","niceShareDate":"2020-05-08 13:57","origin":"","prefix":"","projectLink":"","publishTime":1588947474000,"selfVisible":0,"shareDate":1588917436000,"shareUser":"Android_Jiang","superChapterId":93,"superChapterName":"自定义控件","tags":[],"title":"老生常谈：事件分发","type":0,"userId":56200,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":484,"chapterName":"okhttp","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13308,"link":"https://www.jianshu.com/p/160ad3d7c69c","niceDate":"2020-05-08 22:17","niceShareDate":"2020-05-08 16:47","origin":"","prefix":"","projectLink":"","publishTime":1588947449000,"selfVisible":0,"shareDate":1588927639000,"shareUser":"吊儿郎当","superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"OkHttp原理解析2(拦截器篇)","type":0,"userId":2554,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13312,"link":"https://juejin.im/post/5eb4379e6fb9a0436a7c667e","niceDate":"2020-05-08 22:15","niceShareDate":"2020-05-08 21:46","origin":"","prefix":"","projectLink":"","publishTime":1588947342000,"selfVisible":0,"shareDate":1588945576000,"shareUser":"鸿洋","superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"[译]Jake Wharton 提问：除以 2 ，右移 1，谁更好 ？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"huangruiLearn","canEdit":false,"chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"基于Fullter的仿微博客户端, 包含首页、视频、发现、消息(仿微博聊天界面)及个人中心模块,还原微博最新10.4.0版本80%界面,包含发布微博,转发,点赞,评论,聊天(只实现ui),登录,修改信息等功能，希望能帮助到大家！ ","descMd":"","envelopePic":"https://wanandroid.com/blogimgs/2490513e-299c-45e2-9fe8-15cfc48a72a8.png","fresh":false,"id":13313,"link":"https://www.wanandroid.com/blog/show/2753","niceDate":"2020-05-08 22:15","niceShareDate":"2020-05-08 22:15","origin":"","prefix":"","projectLink":"https://github.com/huangruiLearn/flutter_hrlweibo","publishTime":1588947318000,"selfVisible":0,"shareDate":1588947318000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"Flutter仿微博客户端","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13310,"link":"https://blog.csdn.net/qq1271396448/article/details/106002648","niceDate":"2020-05-08 18:17","niceShareDate":"2020-05-08 18:17","origin":"","prefix":"","projectLink":"","publishTime":1588933044000,"selfVisible":0,"shareDate":1588933044000,"shareUser":"菜鸡","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 类似于日历区间选择 变色","type":0,"userId":23705,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>这是一个群友发的，还有点意思：<\/p> <pre><code>class Test{ public static void main(String[] args){ try{ throw new RuntimeException(&quot;try&quot;); }finally{ throw new RuntimeException(&quot;finally&quot;); } } } <\/code><\/pre><p>上面的代码，最终会抛出哪个异常呢，为什么？<\/p> <p>以后遇到类似问题，怎么看比较靠谱？<\/p>","descMd":"","envelopePic":"","fresh":false,"id":13205,"link":"https://wanandroid.com/wenda/show/13205","niceDate":"2020-05-07 10:02","niceShareDate":"2020-04-28 17:35","origin":"","prefix":"","projectLink":"","publishTime":1588816930000,"selfVisible":0,"shareDate":1588066502000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 try finally 都抛出异常，哪里停止呢？","type":0,"userId":2,"visible":1,"zan":10},{"apkLink":"","audit":1,"author":"Yuzopro","canEdit":false,"chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"OpenGit基于Flutter的Github客户端，支持Android和iOS。项目中涉及到BloC、Redux、国际化、多主题以及Github相关信息的查看等。","descMd":"","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":13280,"link":"https://www.wanandroid.com/blog/show/2752","niceDate":"2020-05-06 22:06","niceShareDate":"2020-05-06 22:06","origin":"","prefix":"","projectLink":"https://github.com/Yuzopro/opengit_flutter","publishTime":1588773999000,"selfVisible":0,"shareDate":1588773999000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"使用Flutter开发的一款仿Gitme的客户端","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":149,"chapterName":"so文件相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13267,"link":"https://juejin.im/post/5eae6f86e51d454ddb0b3dc6","niceDate":"2020-05-06 22:05","niceShareDate":"2020-05-06 11:35","origin":"","prefix":"","projectLink":"","publishTime":1588773942000,"selfVisible":0,"shareDate":1588736141000,"shareUser":"Lgxing","superChapterId":182,"superChapterName":"JNI","tags":[],"title":"为何大厂APP如微信、支付宝、淘宝、手Q等只适配了armeabi-v7a/armeabi？","type":0,"userId":29390,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13272,"link":"https://www.jianshu.com/p/30acbdce0000","niceDate":"2020-05-06 22:05","niceShareDate":"2020-05-06 19:35","origin":"","prefix":"","projectLink":"","publishTime":1588773930000,"selfVisible":0,"shareDate":1588764907000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Kotlin Vocabulary | 枚举和 R8 编译器","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":296,"chapterName":"阅读","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":13273,"link":"https://www.jianshu.com/p/a8673ec5acd3","niceDate":"2020-05-06 22:05","niceShareDate":"2020-05-06 19:47","origin":"","prefix":"","projectLink":"","publishTime":1588773921000,"selfVisible":0,"shareDate":1588765637000,"shareUser":"鸿洋","superChapterId":202,"superChapterName":"延伸技术","tags":[],"title":"那些消失的安卓技术博主们","type":0,"userId":2,"visible":1,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 421
     * size : 20
     * total : 8415
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements MultiItemEntity {


        /**
         * apkLink :
         * audit : 1
         * author :
         * canEdit : false
         * chapterId : 445
         * chapterName : Service
         * collect : false
         * courseId : 13
         * desc :
         * descMd :
         * envelopePic :
         * fresh : true
         * id : 13362
         * link : https://mp.weixin.qq.com/s/fcdBEq7qOw8vLHZ0sI3KIA
         * niceDate : 10小时前
         * niceShareDate : 1天前
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1589214486000
         * selfVisible : 0
         * shareDate : 1589163532000
         * shareUser : 轻风白宇
         * superChapterId : 178
         * superChapterName : framework
         * tags : []
         * title : Android实现长按复制文本功能
         * type : 0
         * userId : 29185
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private int audit;
        private String author;
        private boolean canEdit;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String descMd;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private long publishTime;
        private int selfVisible;
        private long shareDate;
        private String shareUser;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isCanEdit() {
            return canEdit;
        }

        public void setCanEdit(boolean canEdit) {
            this.canEdit = canEdit;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDescMd() {
            return descMd;
        }

        public void setDescMd(String descMd) {
            this.descMd = descMd;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(int selfVisible) {
            this.selfVisible = selfVisible;
        }

        public long getShareDate() {
            return shareDate;
        }

        public void setShareDate(long shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        @Override
        public int getItemType() {
            if (TextUtils.isEmpty(envelopePic)) {
                return C.ARTICLE_ITEM;
            }
            return C.ARTICLE_ITEM_PIC;
        }
    }
}
