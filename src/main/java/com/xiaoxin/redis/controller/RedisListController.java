package com.xiaoxin.redis.controller;

import com.xiaoxin.redis.Article;
import com.xiaoxin.redis.RedisListComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午5:38
 */
@RestController
@RequestMapping("list")
public class RedisListController {
    @Autowired
    private RedisListComponent listComponent;

    @PostMapping("/leftAddOne")
    public Result leftAddOne(@RequestBody Article article) {
        listComponent.addLastedUpdates(article);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/getLastUpdates/{author}/{count}")
    public Result getLastUpdates(@PathVariable String author,@PathVariable int count) {
        List<Article> articles = listComponent.getLastUpdates(author,count);
        return ResultGenerator.genSuccessResult(articles);
    }

    @GetMapping("/getLastedUpdates/{author}")
    public Result getAllLastUpdates(@PathVariable String author) {
        Article article = listComponent.getLastedUpdates(author);
        return ResultGenerator.genSuccessResult(article);
    }
}
