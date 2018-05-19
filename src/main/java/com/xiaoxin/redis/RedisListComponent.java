package com.xiaoxin.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 列表的常见用例
 * 列表对于许多任务很有用，下面是两个非常具有代表性的用例：
 *
 * 记住用户发布到社交网络的最新更新。
 * 进程之间的通信，使用消费者 - 生产者模式，生产者将项目推入列表中，消费者（通常是工作者）使用这些项目并执行操作。Redis有特殊的列表命令，使这个用例更加可靠和高效。
 * 例如，为了实现后台作业，流行的Ruby库resque和 sidekiq都使用了Redis列表。
 *
 * 流行的Twitter社交网络将 用户发布的最新推文发布到Redis列表中。
 *
 * 要逐步描述常见用例，假设您的主页显示在照片共享社交网络中发布的最新照片，并且您希望加快访问速度。
 *
 * 每次用户发布新照片时，我们都会使用LPUSH将其ID添加到列表中。
 * 当用户访问主页时，我们使用这些信息LRANGE 0 9来获取最新的10个发布项目。
 * @Auther zhangyongxin
 * @date 2018/5/19 下午4:30
 */
@Component
public class RedisListComponent {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 使用lpush实现最新的排在最前面
     * @param article
     */
    public void addLastedUpdates(Article article){
        ListOperations listOperations =redisTemplate.opsForList();
        listOperations.leftPush("design-pattern:article:lastUpdates:"+article.getAuthor(),article);
    }

    /**
     * 获取该作者最近的更新
     * @param author
     * @param counts
     * @return
     */
    public List<Article> getLastUpdates(String author,int counts){
        ListOperations listOperations =redisTemplate.opsForList();
        List<Article> articles= listOperations.range("design-pattern:article:lastUpdates:"+author,0,counts);
        return articles;
    }

    /**
     * 获取最近的一条更新
     * @return
     */
    public Article getLastedUpdates(String author){
        ListOperations listOperations =redisTemplate.opsForList();
        Article article = (Article) listOperations.leftPop("design-pattern:article:lastUpdates:"+author);
        return article;
    }

}
