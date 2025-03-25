class Solution {
    public int scheduleCourse(int[][] courses) {
// sort courses on the basis of last day in ascending, so we can pick course have
        // the lowest last day.
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int timeElapsed = 0;
        for(var course: courses) {
            if(timeElapsed + course[0] <= course[1]) {
                timeElapsed += course[0];
                maxHeap.offer(course[0]);
            } else if(!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                timeElapsed = (timeElapsed - maxHeap.poll()) + course[0];
                maxHeap.offer(course[0]);
            }
        }

        return maxHeap.size();
    }
}