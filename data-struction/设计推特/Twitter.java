package 设计推特;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 单纯使用一个队列存 推特，会超时
 *
 *
 * @version 1.0.0
 * @since 2020-06-29
 */
public class Twitter {

    LinkedList<T> tweetIds = new LinkedList<>();

    Map<Integer, List<Integer>> f = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweetIds.addLast(new T(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> fo = f.getOrDefault(userId, new ArrayList<>());

        List<Integer> ans = new ArrayList<>();

        for (int i = tweetIds.size() - 1; i >= 0; i--) {

            T t = tweetIds.get(i);
            if (t.userId == userId || fo.contains(t.userId)) {
                ans.add(t.tId);
            }
            if (ans.size() == 10) {
                return ans;
            }
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (f.containsKey(followerId)) {
            f.get(followerId).add(followeeId);
        } else {
            f.put(followerId, new ArrayList<Integer>() {{
                add(followeeId);
            }});
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!f.containsKey(followerId)) {
            return;
        }
        f.get(followerId).remove(Integer.valueOf(followeeId));
    }

    class T {
        int userId;

        int tId;

        public T(int userId, int tId) {
            this.userId = userId;
            this.tId = tId;
        }
    }
}
