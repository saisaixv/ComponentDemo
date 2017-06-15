package com.shunyi.cydex.news.data;

import java.util.List;

/**
 * Created by saisai on 2017/6/15.
 */

public class News {


    /**
     * date : 20170612
     * stories : [{"images":["https://pic2.zhimg.com/v2-09b3e633583a3421ce5c4d27413f5439.jpg"],"type":0,"id":9472212,"ga_prefix":"061222","title":"小事 · 我是如何考上清华的"},{"title":"你们拍不腻埃及和木乃伊，我也看不腻","ga_prefix":"061221","images":["https://pic2.zhimg.com/v2-f6762364b3ecbd5e8f8fedd38f96c61d.jpg"],"multipic":true,"type":0,"id":9471755},{"images":["https://pic2.zhimg.com/v2-d7eea46c4fe6657342bf210cae82ad0d.jpg"],"type":0,"id":9471300,"ga_prefix":"061220","title":"接电话时，你更喜欢用哪只耳朵？"},{"title":"看到这些建筑，第一次体会到数学是这么美好的存在","ga_prefix":"061219","images":["https://pic4.zhimg.com/v2-2e82d5d27cc816e22b02788306c8805f.jpg"],"multipic":true,"type":0,"id":9471429},{"images":["https://pic2.zhimg.com/v2-0d1b3fe46f3594899a1815b0b09c263d.jpg"],"type":0,"id":9471487,"ga_prefix":"061218","title":"几款健康、好吃又适合在家做的甜点，回去好好犒劳下自己吧"},{"images":["https://pic1.zhimg.com/v2-87804423b33a764c571aca4bec6e28ac.jpg"],"type":0,"id":9471727,"ga_prefix":"061217","title":"「不就是输了一把游戏，你干嘛这么较真？」"},{"images":["https://pic4.zhimg.com/v2-badabab7a1b55a4a5d5621065ebbb56f.jpg"],"type":0,"id":9470862,"ga_prefix":"061216","title":"瓦特明明没有发明蒸汽机，怎么就成了工业革命的代表人物？"},{"images":["https://pic1.zhimg.com/v2-5a17b213030da17836462b18a94b1360.jpg"],"type":0,"id":9471559,"ga_prefix":"061215","title":"相比国产电影的「精致」，怎么一些美国大片看着很脏？"},{"images":["https://pic3.zhimg.com/v2-057a0a6cf18d41f840a75b2cddfd4e32.jpg"],"type":0,"id":9471629,"ga_prefix":"061214","title":"利润都来自于游戏，任天堂为什么必须有自己的主机？"},{"images":["https://pic4.zhimg.com/v2-643cdb4168784f33e26641a5152a7167.jpg"],"type":0,"id":9470828,"ga_prefix":"061213","title":"「最佳生育年龄」到底是几岁，可能没你想的那么重要"},{"images":["https://pic4.zhimg.com/v2-788613f621a03c89b155eb7752169c57.jpg"],"type":0,"id":9470452,"ga_prefix":"061212","title":"大误 · 我是预言家，这不是一个平安夜"},{"images":["https://pic4.zhimg.com/v2-662c3c14babd7982636001834304f3ef.jpg"],"type":0,"id":9471318,"ga_prefix":"061211","title":"许巍歌中「永不凋谢的蓝莲花」原来就是它"},{"images":["https://pic1.zhimg.com/v2-147ec980c48616b361fb877aa90d58c8.jpg"],"type":0,"id":9470787,"ga_prefix":"061210","title":"你再发一大串长语音过来，我可真要拉黑了"},{"title":"想要看爽整个《异形》系列，这样补习就对了","ga_prefix":"061209","images":["https://pic4.zhimg.com/v2-7f4aa71a185c4b664890d36016a80a3f.jpg"],"multipic":true,"type":0,"id":9429607},{"title":"一台微波炉和一壶热水，一碗奥运冠军的「李氏秘方泡面」","ga_prefix":"061208","images":["https://pic1.zhimg.com/v2-77a06088a8523c033bfa593b4a73f630.jpg"],"multipic":true,"type":0,"id":9470810},{"images":["https://pic2.zhimg.com/v2-ffda3fee1550cdfda5f56e2a732f975d.jpg"],"type":0,"id":9469807,"ga_prefix":"061207","title":"谁能赢下共享单车大战，70% 可能是个坎儿"},{"images":["https://pic3.zhimg.com/v2-8606bc3d149f9e9746ccadda41109fee.jpg"],"type":0,"id":9470571,"ga_prefix":"061207","title":"- 有哪些简短却悲伤的话？\r\n- 今天星期一"},{"images":["https://pic1.zhimg.com/v2-f0156408a0e75f26482f7780ba04d980.jpg"],"type":0,"id":9470740,"ga_prefix":"061207","title":"「中国人口比官方数据少九千万」，这话错得太离谱了"},{"images":["https://pic3.zhimg.com/v2-e6a6972422954cc076611a499adf3a0e.jpg"],"type":0,"id":9470720,"ga_prefix":"061206","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-09b3e633583a3421ce5c4d27413f5439.jpg"]
         * type : 0
         * id : 9472212
         * ga_prefix : 061222
         * title : 小事 · 我是如何考上清华的
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
