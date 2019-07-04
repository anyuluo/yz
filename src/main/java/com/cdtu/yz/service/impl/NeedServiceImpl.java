package com.cdtu.yz.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.NeedDao;
import com.cdtu.yz.entity.Need;
import com.cdtu.yz.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeedServiceImpl implements NeedService {

    @Autowired
    NeedDao needDao;


    /**
     *
     * @param pageUtil
     * @return
     */
    @Override
    public PageUtil getNeedPage(PageUtil pageUtil) {

        // 查询总的记录数
        pageUtil.setTotalCount(needDao.getNeedCount());  // 总数
        // 查询当前页的数据
        pageUtil.setData(needDao.getNeedPage(pageUtil));
        return pageUtil;
    }

    /**
     * 判断需求是否存在
     * @param title
     * @return
     */
    @Override
    public boolean isExist(String title) {
        if (null != needDao.getNeedByTitle(title)){
            return true;
        }
        return false;
    }

    /**
     * 添加需求
     * @param need
     * @return
     */
    @Override
    public boolean addNeed(Need need) {
        // 生成一个时间戳
        need.setCreateTime(DateUtil.now());
        // 初始化阅读量为0
        need.setCount(0);
//        return needDao.addNeed(need);
        return needDao.addNeed(need);
    }

    /**
     * 通过名称查询需求
     * @param title
     * @return
     */

    @Override
    public Need getNeedByTitle(String title) {
        Need need = needDao.getNeedByTitle(title);
        if(need == null){
            return null;
        }
        return need;
    }
//    public Need getNeedByTitle(String title) {
//        return needDao.getNeedByTitle(title);
//    }

    /**
     * 修改需求
     * @param need
     * @return
     */
    @Override
      public boolean editNeed(Need need) {
        //更改时间
        need.setEditTime(DateUtil.now());
        if(needDao.updateNeed(need)){
            return true;
        }
        return false;
    }

    /**
     * 通过id查找需求
     * @param id
     * @return
     */
    @Override
    public Need getNeedById(Integer id) {
        return  needDao.getNeedById(id);
//        return  needDao.getNeedById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delNeed(Integer id) {
            //查询需要删除的用户信息
            needDao.delNeed(id);
            return true;
        }

    @Override
    public void incrementCount(Integer id) {
        needDao.incrementCount(id);
    }

    @Override
    public List<Need> getNeedList() {
        // 获取数据库中援藏需求信息的总条数
        int count = needDao.getNeedCount();
        // 获取数据库中最后5条数据，即最新的五条数据
        count = count -6 > 0 ? count - 6 : 0;
        return needDao.getNeedList(count);
    }

    /**
     * 静态方法
     * 用于对need中Context信息进行编码
     * @param need
     * @return
     */
    public static Need encode(Need need){
        // 对信息进行编码
        need.setContent(Base64.encode(need.getContent()));
        return need;
    }

    /**
     * 静态方法
     * 用于对need中context信息进行解码
     * @param need
     * @return
     */
    public static Need decode(Need need){
        // 数据解码
        need.setContent(Base64.decodeStr(need.getContent()));
        return need;
    }

}
