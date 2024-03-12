package HWOD.B.B200;

//  简易内存池
//  题目描述
//        ·请实现一个简易内存池,根据请求命令完成内存分配和释放。
//        ·内存池支持两种操作命令，REQUEST和RELEASE，其格式为:
//        ·REQUEST=请求的内存大小 表示清求分配指定大小内存，如果分配成功，返回分配到的内存首地址;如果内存不足，或指定的大小为0，则输出error.
//        ·RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
//    注意:
//        1.内存池总大小为100字节。
//        2.内存池地址分配必须是连续内存，并优先从低地址分配
//        3.内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放,
//        4.不会释放已申请的内存块的中间地址。
//        5.释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
//    输入描述
//        首行为整数 N,表示操作命令的个数，取值范围:0<N<= 100.
//        接下来的N行,每行将给出一个操作命令，操作命令和参数之间用“=”分割,
//    输出描述
//        请求分配指定大小内存时，如果分配成功，返回分配到的内存首地址;
//        如果内存不足，或指定的大小为0，则输出error
//        释放掉之前分配的内存时，释放成功无需输出，
//        如果释放不存在的首地址则输出error。


import java.util.*;

public class Q1green {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 读取换行符

        Q1green.MemoryPool pool = new Q1green.MemoryPool(); // 创建内存池对象

        for (int i = 0; i < n; ++i) {
            String str = sc.nextLine();

            String cmd = str.split("=")[0]; // 获取命令
            int num = Integer.parseInt(str.split("=")[1]);     // 获取数字参数

            if (cmd.equals("REQUEST")) {        // 如果是请求内存的命令
                int result = pool.request(num); // 调用内存池对象的request方法
                if (result != -1) { // 如果成功分配到内存
                    System.out.println(result); // 输出分配到的内存地址
                } else { // 如果没有分配到内存
                    System.out.println("error"); // 输出错误信息
                }
            } else { // 如果是释放内存的命令
                boolean result = pool.release(num);
                if (!result) { // 调用内存池对象的release方法，并检查是否释放成功
                    System.out.println("error"); // 如果释放失败，输出错误信息
                }
            }
        }
        sc.close();
    }

    static class MemoryPool {           //？？？？？？？
        private final int maxSize = 100; // 内存池总大小
        private final List<Boolean> m_status; // true时表示已被分配
        private final Map<Integer, Integer> m_used; // key为分配的首地址， value为分配的长度

        public MemoryPool() {
            // 初始化内存池中每个地址的状态都是未分配状态
            m_status = new ArrayList<>(Collections.nCopies(maxSize, false));
            m_used = new HashMap<>();
        }

        public int request(int size) {
            int ans = -1;
            if (size <= 0) {
                return ans;
            }
            for (int i = 0; i <= maxSize - size; ++i) {
                int j = 0;
                while (j < size) {
                    if (m_status.get(i + j)) { // 如果当前地址已经被分配，跳出循环
                        break;
                    }
                    j++;
                }
                if (j == size) { // 如果循环到了size，说明可以分配地址
                    ans = i;
                    break;
                }
            }

            if (ans == -1) { // 如果没有找到合适的地址，返回-1
                return ans;
            }

            // 将找到的地址标记为已分配状态
            m_used.put(ans, size);
            for (int i = 0; i < size; ++i) {
                m_status.set(i + ans, true);
            }

            return ans;
        }

        public boolean release(int startAddr) {
            if (!m_used.containsKey(startAddr)) { // 如果该地址没有被分配，返回false
                return false;
            }

            // 将该地址标记为未分配状态
            int size = m_used.get(startAddr);
            for (int i = startAddr; i < startAddr + size; ++i) {
                m_status.set(i, false);
            }

            // 从m_used中删除该地址
            m_used.remove(startAddr);

            return true;
        }
    }

}








