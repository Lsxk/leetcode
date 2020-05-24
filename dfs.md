##### dfs

dfs适用于***是否有解***的问题，bfs适用与***最短路径***问题

模板：

1. 求某个符合条件的节点---递归实现

   ```java
   /*
    * Return true if there is a path from cur to target.
    */
   boolean DFS(Node cur, Node target, Set<Node> visited) 
   {
   	if cur is target
       	return true ;
       for (next : each neighbor of cur) 
       {
           if (next is not in visited) 
           {
               add next to visted;
               if DFS(next, target, visited) == true;
               	return true 
           }
       }
       return false;
   }
   ```
   
2. 求某个符合条件的节点---栈实现

   ```java
   //主要入参是root
   boolean DFS(Node root, Node target)
   {
       Set<Node> visited;
       Stack<Node> s;
       add root to s;
       while s.isNotEmpty()
       {
           Node cur = s.pop();
           visited.add(cur);
           if (cur is target) {
              return true; 
           }
           for (Node node : the neighbor of cur)
           {
               if (node not in visited)
               {
                   cur.push(node)
               }
           }
       }
       return false;
   }
   ```

3. 如果需要遍历出所有的路径，就需要***回溯***

   典型题：[全排列](array/全排列/Solution.java)

   ```java
   private void dfs(int[] nums, int len, int depth,
                        List<Integer> path, boolean[] used,
                        List<List<Integer>> res)
   {
           if (depth == len)
           {
               res.add(new ArrayList<>(path));
               return;
           }
   
           for (int i = 0; i < len; i++)
           {
               if (!used[i]) {
                   path.add(nums[i]);
                   used[i] = true;
   
                   dfs(nums, len, depth + 1, path, used, res);
                   // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                   used[i] = false; //回溯，状态重置
                   path.remove(path.size() - 1); //回溯
               }
           }
   }
   ```

   