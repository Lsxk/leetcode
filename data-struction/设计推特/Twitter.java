package 设计推特;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
 * <p>
 * <p>
 * 单纯使用一个队列存 推特，会超时
 *
 * @version 1.0.0
 * @since 2020-06-29
 */
public class Twitter {

    Map<Integer, Set<Integer>> f = new HashMap<>();

    Map<Integer, Tw> t = new HashMap<>();

    int time = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (t.containsKey(userId)) {
            Tw tw = t.get(userId);

            Tw head = new Tw(tweetId);
            head.next = tw;

            t.put(userId, head);
        } else {
            t.put(userId, new Tw(tweetId));
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        //多路归并

        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Tw> queue = new PriorityQueue<>((o1, o2) -> (int) (o2.time - o1.time));

        Set<Integer> ff = f.getOrDefault(userId, new HashSet<>());
        ff.add(userId);

        ff.forEach(userId1 -> {
            int i = 0;
            Tw tw = t.get(userId1);
            if (tw != null) {
                while (i < 10 && tw != null) {

                    queue.offer(tw);
                    tw = tw.next;
                    i++;
                }
            }

        });

        int i = 0;
        while (i < 10 && !queue.isEmpty()) {
            ans.add(queue.poll().id);
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
            f.put(followerId, new HashSet<Integer>() {{
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
        f.get(followerId).remove(followeeId);
    }

    class Tw {
        int id;

        long time;

        Tw next;

        public Tw(int id) {
            this.id = id;
            this.time = Twitter.time++;
        }
    }
}
