package heima.leetcode;

@FunctionalInterface
public interface TriConsumer {

    void accept(int popValue, int popIndex, int peekIndex);
}
