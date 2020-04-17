package com.ssh.dao;

import com.ssh.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
* 析:我的dao继承了HibernateDaoSupport  所以不能注入sessionFactory或hibernateTemplate
*两种方法:（1）继续使用HibernateDaoSupport    在dao类里面添加下面代码
*
* @Resource

	   public void setSessionFactory0(SessionFactory sessionFactory){

	      super.setSessionFactory(sessionFactory);

	   }
	   * 2）dao不继承HibernateDaoSupport，直接用HibernateTemplate属性注入
	   *
@Resource(name="hibernateTemplate")

	private HibernateTemplate hibernateTemplate;
	* 并在spring的配置文件中配置HibernateTemplate即可
	* <bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
	<property name="sessionFactory" ref="sessionFactory></property>
	*  </bean>
	*
* */
@Repository
public class UserDao extends HibernateDaoSupport {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);

    }
    public List<User> getall(){
        return (List<User>) super.getHibernateTemplate().find("from User",null);
    }
}
