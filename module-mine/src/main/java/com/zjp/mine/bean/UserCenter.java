package com.zjp.mine.bean;

import java.util.List;

/**
 * Created by zjp on 2020/7/26 16:25.
 */
public class UserCenter {

    /**
     * coinInfo : {"coinCount":13582,"level":136,"rank":"4","userId":2,"username":"x**oyang"}
     * shareArticles : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>每次新建项目，我们都会生成build.gradle，如果是app模块则会引入：<\/p>\r\n<pre><code>apply plugin: &#39;com.android.application&#39;\r\n<\/code><\/pre><p>如果是lib：<\/p>\r\n<pre><code>apply plugin: &#39;com.android.library&#39;\r\n<\/code><\/pre><p>问题来了：<\/p>\r\n<ol>\r\n<li>apply plugin: &#39;com.android.application&#39;背后的原理是？<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":true,"id":14500,"link":"https://wanandroid.com/wenda/show/14500","niceDate":"5小时前","niceShareDate":"5小时前","origin":"","prefix":"","projectLink":"","publishTime":1595735648000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1595735648000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 | apply plugin: 'com.android.application' 背后发生了什么？","type":2,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14497,"link":"https://juejin.im/post/5f1adc98e51d4534732069d1","niceDate":"17小时前","niceShareDate":"17小时前","origin":"","prefix":"","projectLink":"","publishTime":1595689516000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595689516000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" 仿系统日志实现一个Crash日志采集工具 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14496,"link":"https://juejin.im/post/5f1ae5176fb9a07e7b6269bf","niceDate":"18小时前","niceShareDate":"18小时前","origin":"","prefix":"","projectLink":"","publishTime":1595686018000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595686018000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" Android 性能监控框架 Matrix（3）Hprof 文件分析 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14495,"link":"https://blog.csdn.net/kangkanglou/article/details/79422520","niceDate":"19小时前","niceShareDate":"19小时前","origin":"","prefix":"","projectLink":"","publishTime":1595685413000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595685389000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JVM指令之invokestatic,invokespecial,invokeinterface,invokevirtual,invokedy","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14494,"link":"https://www.infoq.cn/article/Invokedynamic-Javas-secret-weapon","niceDate":"19小时前","niceShareDate":"19小时前","origin":"","prefix":"","projectLink":"","publishTime":1595683638000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595683638000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Invokedynamic：Java的秘密武器 - InfoQ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14492,"link":"https://juejin.im/post/5f04129c6fb9a07e8e44e7c3","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1595674919000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595674919000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" JVM 角度看代码优化 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14491,"link":"https://www.jianshu.com/p/0ec378cfb4c7","niceDate":"22小时前","niceShareDate":"22小时前","origin":"","prefix":"","projectLink":"","publishTime":1595672891000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595672891000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"宏观剖析Glide4.8.0源码 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14490,"link":"https://juejin.im/post/5f16cf76f265da22fd6399ef","niceDate":"23小时前","niceShareDate":"23小时前","origin":"","prefix":"","projectLink":"","publishTime":1595669085000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595669085000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" Thread也会OOM吗？ ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":486,"chapterName":"LiveData","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14457,"link":"https://juejin.im/post/5f171848f265da22fd639a56","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434112000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1595433842000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"自己动手改造 Jetpack LiveData","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14458,"link":"https://juejin.im/post/5f168dd9f265da22ce394a7a","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434100000,"realSuperChapterId":53,"selfVisible":0,"shareDate":1595433859000,"shareUser":"鸿洋","superChapterId":81,"superChapterName":"热门专题","tags":[],"title":"一个更贴近 android 场景的启动框架 | Anchors","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14459,"link":"https://www.jianshu.com/p/1eca5e32fad2","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434089000,"realSuperChapterId":156,"selfVisible":0,"shareDate":1595433892000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"基于JSON RPC的一种Android跨进程调用解决方案了解一下？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14460,"link":"https://www.jianshu.com/p/ebbe8341c582","niceDate":"2020-07-23 00:07","niceShareDate":"2020-07-23 00:05","origin":"","prefix":"","projectLink":"","publishTime":1595434028000,"realSuperChapterId":53,"selfVisible":0,"shareDate":1595433931000,"shareUser":"鸿洋","superChapterId":81,"superChapterName":"热门专题","tags":[],"title":"Android apk瘦身更佳实践(一)：去除R.class","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":100,"chapterName":"RecyclerView","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14461,"link":"https://www.jianshu.com/p/3e9aa4bdaefd?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2020-07-23 00:06","niceShareDate":"2020-07-23 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595434008000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595433992000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"让你彻底掌握RecyclerView的缓存机制","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14446,"link":"https://juejin.im/post/5f156c8de51d453476714a37","niceDate":"2020-07-22 00:14","niceShareDate":"2020-07-22 00:13","origin":"","prefix":"","projectLink":"","publishTime":1595348088000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1595348037000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android进阶基础系列：View的工作原理 全面理解！","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":510,"chapterName":"大厂分享","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14433,"link":"https://juejin.im/post/5f144b2f6fb9a07e6f7b7fce#comment","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:05","origin":"","prefix":"","projectLink":"","publishTime":1595261306000,"realSuperChapterId":509,"selfVisible":0,"shareDate":1595261147000,"shareUser":"鸿洋","superChapterId":510,"superChapterName":"大厂对外分享","tags":[],"title":"今日头条 Android &#39;秒&#39; 级编译速度优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":444,"chapterName":"androidx","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14434,"link":"https://juejin.im/post/5f02bb50f265da22a8514e49","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595261300000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595261179000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"错误的ViewPager用法（填坑）：ViewPager2做了什么？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":142,"chapterName":"ConstraintLayout","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14436,"link":"https://juejin.im/post/5f0e9eea6fb9a07e7e0444e3","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595261288000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595261188000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android MotionLayout动画：续写ConstraintLayout新篇章","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>View 的三大流程：测量、布局、绘制，我想大家应该都烂熟于心。<\/p>\r\n<p>而在绘制阶段，ViewGroup 不光要绘制自身，还需循环绘制其一众子 View，这个绘制策略默认为顺序绘制，即 [0 ~ childCount)。<\/p>\r\n<p>这个默认的策略，有办法调整吗？<\/p>\r\n<p>例如修改成 (childCount ~ 0]，或是修成某个 View 更后绘制。同时又有什么场景需要我们做这样的修改？<\/p>\r\n<p>问题来了：<\/p>\r\n<ol>\r\n<li>这个默认的策略，有办法调整吗？<\/li>\r\n<li>修改了之后，事件分发需要特殊处理吗？还是需要特殊处理。<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":false,"id":14409,"link":"https://www.wanandroid.com/wenda/show/14409","niceDate":"2020-07-20 00:01","niceShareDate":"2020-07-19 18:07","origin":"","prefix":"","projectLink":"","publishTime":1595174476000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1595153262000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问| View 绘制的一个细节，如何修改 View 绘制的顺序？","type":1,"userId":2,"visible":1,"zan":5},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14403,"link":"https://www.jianshu.com/p/d3ccd97ec5d1","niceDate":"2020-07-20 00:00","niceShareDate":"2020-07-19 14:17","origin":"","prefix":"","projectLink":"","publishTime":1595174437000,"realSuperChapterId":244,"selfVisible":0,"shareDate":1595139462000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"ASM简介（二）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14402,"link":"https://www.jianshu.com/p/85502e42bbb6","niceDate":"2020-07-20 00:00","niceShareDate":"2020-07-19 14:17","origin":"","prefix":"","projectLink":"","publishTime":1595174418000,"realSuperChapterId":244,"selfVisible":0,"shareDate":1595139445000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"ASM简介（一）","type":0,"userId":2,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":30,"size":20,"total":592}
     */

    private Integral coinInfo;
    private ShareArticlesBean shareArticles;

    public Integral getCoinInfo() {
        return coinInfo;
    }

    public void setCoinInfo(Integral coinInfo) {
        this.coinInfo = coinInfo;
    }

    public ShareArticlesBean getShareArticles() {
        return shareArticles;
    }

    public void setShareArticles(ShareArticlesBean shareArticles) {
        this.shareArticles = shareArticles;
    }


    public static class ShareArticlesBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>每次新建项目，我们都会生成build.gradle，如果是app模块则会引入：<\/p>\r\n<pre><code>apply plugin: &#39;com.android.application&#39;\r\n<\/code><\/pre><p>如果是lib：<\/p>\r\n<pre><code>apply plugin: &#39;com.android.library&#39;\r\n<\/code><\/pre><p>问题来了：<\/p>\r\n<ol>\r\n<li>apply plugin: &#39;com.android.application&#39;背后的原理是？<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":true,"id":14500,"link":"https://wanandroid.com/wenda/show/14500","niceDate":"5小时前","niceShareDate":"5小时前","origin":"","prefix":"","projectLink":"","publishTime":1595735648000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1595735648000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问 | apply plugin: 'com.android.application' 背后发生了什么？","type":2,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14497,"link":"https://juejin.im/post/5f1adc98e51d4534732069d1","niceDate":"17小时前","niceShareDate":"17小时前","origin":"","prefix":"","projectLink":"","publishTime":1595689516000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595689516000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" 仿系统日志实现一个Crash日志采集工具 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14496,"link":"https://juejin.im/post/5f1ae5176fb9a07e7b6269bf","niceDate":"18小时前","niceShareDate":"18小时前","origin":"","prefix":"","projectLink":"","publishTime":1595686018000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595686018000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" Android 性能监控框架 Matrix（3）Hprof 文件分析 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14495,"link":"https://blog.csdn.net/kangkanglou/article/details/79422520","niceDate":"19小时前","niceShareDate":"19小时前","origin":"","prefix":"","projectLink":"","publishTime":1595685413000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595685389000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"JVM指令之invokestatic,invokespecial,invokeinterface,invokevirtual,invokedy","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14494,"link":"https://www.infoq.cn/article/Invokedynamic-Javas-secret-weapon","niceDate":"19小时前","niceShareDate":"19小时前","origin":"","prefix":"","projectLink":"","publishTime":1595683638000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595683638000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Invokedynamic：Java的秘密武器 - InfoQ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14492,"link":"https://juejin.im/post/5f04129c6fb9a07e8e44e7c3","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1595674919000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595674919000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" JVM 角度看代码优化 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14491,"link":"https://www.jianshu.com/p/0ec378cfb4c7","niceDate":"22小时前","niceShareDate":"22小时前","origin":"","prefix":"","projectLink":"","publishTime":1595672891000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595672891000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"宏观剖析Glide4.8.0源码 ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"id":14490,"link":"https://juejin.im/post/5f16cf76f265da22fd6399ef","niceDate":"23小时前","niceShareDate":"23小时前","origin":"","prefix":"","projectLink":"","publishTime":1595669085000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1595669085000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":" Thread也会OOM吗？ ","type":0,"userId":2,"visible":0,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":486,"chapterName":"LiveData","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14457,"link":"https://juejin.im/post/5f171848f265da22fd639a56","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434112000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1595433842000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"自己动手改造 Jetpack LiveData","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14458,"link":"https://juejin.im/post/5f168dd9f265da22ce394a7a","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434100000,"realSuperChapterId":53,"selfVisible":0,"shareDate":1595433859000,"shareUser":"鸿洋","superChapterId":81,"superChapterName":"热门专题","tags":[],"title":"一个更贴近 android 场景的启动框架 | Anchors","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14459,"link":"https://www.jianshu.com/p/1eca5e32fad2","niceDate":"2020-07-23 00:08","niceShareDate":"2020-07-23 00:04","origin":"","prefix":"","projectLink":"","publishTime":1595434089000,"realSuperChapterId":156,"selfVisible":0,"shareDate":1595433892000,"shareUser":"鸿洋","superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"基于JSON RPC的一种Android跨进程调用解决方案了解一下？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14460,"link":"https://www.jianshu.com/p/ebbe8341c582","niceDate":"2020-07-23 00:07","niceShareDate":"2020-07-23 00:05","origin":"","prefix":"","projectLink":"","publishTime":1595434028000,"realSuperChapterId":53,"selfVisible":0,"shareDate":1595433931000,"shareUser":"鸿洋","superChapterId":81,"superChapterName":"热门专题","tags":[],"title":"Android apk瘦身更佳实践(一)：去除R.class","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":100,"chapterName":"RecyclerView","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14461,"link":"https://www.jianshu.com/p/3e9aa4bdaefd?utm_source=desktop&amp;utm_medium=timeline","niceDate":"2020-07-23 00:06","niceShareDate":"2020-07-23 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595434008000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595433992000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"让你彻底掌握RecyclerView的缓存机制","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14446,"link":"https://juejin.im/post/5f156c8de51d453476714a37","niceDate":"2020-07-22 00:14","niceShareDate":"2020-07-22 00:13","origin":"","prefix":"","projectLink":"","publishTime":1595348088000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1595348037000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android进阶基础系列：View的工作原理 全面理解！","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":510,"chapterName":"大厂分享","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14433,"link":"https://juejin.im/post/5f144b2f6fb9a07e6f7b7fce#comment","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:05","origin":"","prefix":"","projectLink":"","publishTime":1595261306000,"realSuperChapterId":509,"selfVisible":0,"shareDate":1595261147000,"shareUser":"鸿洋","superChapterId":510,"superChapterName":"大厂对外分享","tags":[],"title":"今日头条 Android &#39;秒&#39; 级编译速度优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":444,"chapterName":"androidx","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14434,"link":"https://juejin.im/post/5f02bb50f265da22a8514e49","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595261300000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595261179000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"错误的ViewPager用法（填坑）：ViewPager2做了什么？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":142,"chapterName":"ConstraintLayout","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14436,"link":"https://juejin.im/post/5f0e9eea6fb9a07e7e0444e3","niceDate":"2020-07-21 00:08","niceShareDate":"2020-07-21 00:06","origin":"","prefix":"","projectLink":"","publishTime":1595261288000,"realSuperChapterId":39,"selfVisible":0,"shareDate":1595261188000,"shareUser":"鸿洋","superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android MotionLayout动画：续写ConstraintLayout新篇章","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"xiaoyang","canEdit":false,"chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>View 的三大流程：测量、布局、绘制，我想大家应该都烂熟于心。<\/p>\r\n<p>而在绘制阶段，ViewGroup 不光要绘制自身，还需循环绘制其一众子 View，这个绘制策略默认为顺序绘制，即 [0 ~ childCount)。<\/p>\r\n<p>这个默认的策略，有办法调整吗？<\/p>\r\n<p>例如修改成 (childCount ~ 0]，或是修成某个 View 更后绘制。同时又有什么场景需要我们做这样的修改？<\/p>\r\n<p>问题来了：<\/p>\r\n<ol>\r\n<li>这个默认的策略，有办法调整吗？<\/li>\r\n<li>修改了之后，事件分发需要特殊处理吗？还是需要特殊处理。<\/li>\r\n<\/ol>","descMd":"","envelopePic":"","fresh":false,"id":14409,"link":"https://www.wanandroid.com/wenda/show/14409","niceDate":"2020-07-20 00:01","niceShareDate":"2020-07-19 18:07","origin":"","prefix":"","projectLink":"","publishTime":1595174476000,"realSuperChapterId":439,"selfVisible":0,"shareDate":1595153262000,"shareUser":"","superChapterId":440,"superChapterName":"问答","tags":[{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}],"title":"每日一问| View 绘制的一个细节，如何修改 View 绘制的顺序？","type":1,"userId":2,"visible":1,"zan":5},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14403,"link":"https://www.jianshu.com/p/d3ccd97ec5d1","niceDate":"2020-07-20 00:00","niceShareDate":"2020-07-19 14:17","origin":"","prefix":"","projectLink":"","publishTime":1595174437000,"realSuperChapterId":244,"selfVisible":0,"shareDate":1595139462000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"ASM简介（二）","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14402,"link":"https://www.jianshu.com/p/85502e42bbb6","niceDate":"2020-07-20 00:00","niceShareDate":"2020-07-19 14:17","origin":"","prefix":"","projectLink":"","publishTime":1595174418000,"realSuperChapterId":244,"selfVisible":0,"shareDate":1595139445000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"ASM简介（一）","type":0,"userId":2,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 30
         * size : 20
         * total : 592
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

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author : xiaoyang
             * canEdit : false
             * chapterId : 440
             * chapterName : 官方
             * collect : false
             * courseId : 13
             * desc : <p>每次新建项目，我们都会生成build.gradle，如果是app模块则会引入：</p>
             <pre><code>apply plugin: &#39;com.android.application&#39;
             </code></pre><p>如果是lib：</p>
             <pre><code>apply plugin: &#39;com.android.library&#39;
             </code></pre><p>问题来了：</p>
             <ol>
             <li>apply plugin: &#39;com.android.application&#39;背后的原理是？</li>
             </ol>
             * descMd :
             * envelopePic :
             * fresh : true
             * id : 14500
             * link : https://wanandroid.com/wenda/show/14500
             * niceDate : 5小时前
             * niceShareDate : 5小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1595735648000
             * realSuperChapterId : 439
             * selfVisible : 0
             * shareDate : 1595735648000
             * shareUser :
             * superChapterId : 440
             * superChapterName : 问答
             * tags : [{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}]
             * title : 每日一问 | apply plugin: 'com.android.application' 背后发生了什么？
             * type : 2
             * userId : 2
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
            private int realSuperChapterId;
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
            private List<TagsBean> tags;

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

            public int getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(int realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
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

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : 本站发布
                 * url : /article/list/0?cid=440
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
