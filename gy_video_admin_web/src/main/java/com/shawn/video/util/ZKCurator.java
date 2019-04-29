package com.shawn.video.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/29 0029
 */
public class ZKCurator {
    //zk客户端
    private CuratorFramework client = null;

    final static org.slf4j.Logger log = LoggerFactory.getLogger(ZKCurator.class);

    public ZKCurator(CuratorFramework client) {
        this.client = client;
    }

    public void init(){
        client = client.usingNamespace("admin");

        //判断在admin命名空间下是否有/bgm节点  /admin/bgm
        try {
            if(client.checkExists().forPath("/bgm") == null){
                /**
                 * 对于zk来讲，有两种类型的节点：
                 * 1.持久节点：当你创建一个节点的时候，这个节点就永远存在，除非手动删除
                 * 2.临时节点：创建一个节点之后，会话断开，会自动删除，也可以手动删除
                 */
                client.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)        //节点类型，持久节点
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE) //acl：匿名权限
                        .forPath("/bgm");
                log.info("zookeeper初始化成功...");
                log.info("zookeeper初始化成功...{0}",client.isStarted());
            }
        } catch (Exception e) {
            log.error("zookeeper客户端链接，初始化错误...");
            e.printStackTrace();
        }
    }
}
