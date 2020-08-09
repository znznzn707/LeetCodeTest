/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/09 21:55
 * <pre>
 *     * 贪心算法 *
 *     有N个同等级的会议需要在同一天使用同一个会议室，
 *     现在给出这N个会议的开始时间和结束时间，怎么样才能使会议室最大利用，安排最多场次的会议？
 *
 * 分析：这个问题需要用到贪心算法，即先将这些会议根据结束时间自然排序，
 * 肯定是先安排最先结束的，如果最先安排最后结束的，那如果一个会议开的很久，
 * 那本来可以多安排几场结果全被这个占了，显然不是最优的选择，因此优先安排会议先结束的才是合理的。
 * 然后接着在剩余的场次里判断会议开始时间是否在当前会议结束时间之后，如果在后面说明可以继续安排，
 * 下面就是代码实现。
 * </pre>
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 会议类，需实现Comparable接口
 */
class Meeting {
    private int number;
    private int starTime;
    private int endTime;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStarTime() {
        return starTime;
    }

    public void setStarTime(int starTime) {
        this.starTime = starTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Meeting(int number, int starTime, int endTime) {
        this.number = number;
        this.starTime = starTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "number=" + number +
                ", starTime=" + starTime +
                ", endTime=" + endTime +
                '}';
    }
}
public class Greedy {
    public static List<Meeting> GreatMeeting(List<Meeting> list) {
        Comparator<Meeting> comp = Comparator.comparingInt(Meeting::getEndTime);
        int curTime = 0 ;
        Collections.sort(list, comp);
        List<Meeting> target = new ArrayList<>(list.size()) ;
        for(int i = 0; i < list.size(); i++) {
            Meeting meeting = list.get(i) ;
            if(meeting.getStarTime() >= curTime) {
                target.add(meeting) ;
                curTime = meeting.getEndTime() ;
            }
        }
        return target ;
    }
    public static void main(String[] args) {
        List<Meeting> list = new ArrayList<>(4) ;
        list.add(new Meeting(0,  8, 10)) ;
        list.add(new Meeting(1, 6,  9)) ;
        list.add(new Meeting(2, 13, 14)) ;
        list.add(new Meeting(3, 11, 12)) ;
        List<Meeting> target = GreatMeeting(list) ;
        target.forEach(System.out::println);
    }
}
