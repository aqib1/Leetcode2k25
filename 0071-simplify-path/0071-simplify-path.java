class Solution {
    // Time complexity O(n) and space O(n)
    public String simplifyPath(String path) {
        if(path == null || path.isBlank()) {
            return "";
        }
        var dataSplit = path.split("/");
        var deque = new ArrayDeque<String>();

        for(var data : dataSplit) {
            if(data.equals(".") || data.isBlank())
                continue;

            if(data.equals("..")) {
                if(!deque.isEmpty())
                    deque.removeLast();
            } else {
                deque.addLast(data);
            }
        }

        if(deque.isEmpty())
            return "/";

        StringBuilder response = new StringBuilder();
        while(!deque.isEmpty()) {
            response.append("/").append(deque.pollFirst());
        }

        return response.toString();
    }
}