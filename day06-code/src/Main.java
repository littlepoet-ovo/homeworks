public class Main{
    public static void main(String[] args) {

    }
}
class Well {
    private int capacity;//水井的最大容量
    private int currentWaterLevel;//当前水井中的水位
    private boolean wait;//水井是否处于等待状态
    private int waitTime;//当前水井需要等待多长时间才能恢复使用。对于公共水井来说，这个值为6；对于村民家中的小水井来说，这个值为1。

    public Well(int capacity, int currentWaterLevel, int waitTime) {
        this.capacity = capacity;
        this.currentWaterLevel = currentWaterLevel;
        this.waitTime = waitTime;
        this.wait = false;
    }

    public void checkWait(int hour) {
        if (wait && hour >= waitTime) {
            currentWaterLevel += capacity;
            wait = false;
        }
    }

    public boolean takeWater(int amount) {
        if (!wait && currentWaterLevel >= amount) {
            currentWaterLevel -= amount;
            if (currentWaterLevel < 100) {
                wait = true;
            }
            return true;
        } else {
            return false;
        }
    }

}