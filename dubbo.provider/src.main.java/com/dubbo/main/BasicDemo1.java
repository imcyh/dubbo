package com.dubbo.main;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class BasicDemo1 {

    public static void main(String[] args) throws Exception{
    	Watcher watcher = new Watcher(){
            // 监控所有被触发的事件
            public void process(WatchedEvent event) { 
                System.out.println("触发了" + event.getType() + "事件！"); 
            }
        };
    	
    	ZooKeeper zk = new ZooKeeper("192.168.2.11:2181", 3000, watcher);
        System.out.println("=========创建节点===========");
        if(zk.exists("/test", false) == null)
        {
        	zk.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println("=============查看节点是否安装成功===============");
        System.out.println(new String(zk.getData("/test", false, null)));
        
        System.out.println("=========修改节点的数据==========");
        zk.setData("/test", "zNode2".getBytes(), -1);
        System.out.println("========查看修改的节点是否成功=========");
        System.out.println(new String(zk.getData("/test", false, null)));
        
        System.out.println("=======删除节点==========");
        zk.delete("/test", -1);
        System.out.println("==========查看节点是否被删除============");
        System.out.println("节点状态：" + zk.exists("/test", false));
        zk.close();
    }
}
