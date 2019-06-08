package com.coll.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Friend getFriend(int friendid) {
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,friendid);
		session.close();
		return friend;
	}

	@Override
	public List<Friend> showFriendList(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname and status='A'");
		query.setParameter("uname",username);
		List<Friend> listFriends=query.list();
		return listFriends;
	}
	
	@Override
	public List<Friend> showPendingFriendRequest(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname and status='NA'");
		query.setParameter("uname",username);
		List<Friend> listFriends=query.list();
		return listFriends;
	}
	
	@Override
	public List<UserDetail> showSuggestedFriends(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createNativeQuery("select username from userdetail where username not in (select friendusername from friend where username='"+username+"') and username not in (select username from friend where friendusername='"+username+"' and status='A') and username!='"+username+"'");
        List<String> userList=query.list();	
        ArrayList<UserDetail> userDetailList=new ArrayList<UserDetail>();
        int i=0;
        while(i<userList.size())
        {
        	UserDetail user=session.get(UserDetail.class,userList.get(i).toString().trim());
        	userDetailList.add(user);
        	i++;
        }
        return userDetailList;
	}
	
	@Override
	public boolean sendFriendRequest(Friend friend) {
		
		try {
			friend.setStatus("NA");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean acceptFriendRequest(Friend friend) {
		
		try {
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteFriendRequest(Friend friend) {
	
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}