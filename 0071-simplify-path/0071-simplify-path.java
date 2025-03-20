class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.isBlank()) {
            return "";
        }
        var dataSplit = path.split("/");
        var stack = new Stack<String>();

        for(var data : dataSplit) {
            if(data.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(!data.equals(".") && !data.isBlank()) {
                stack.push(data);
            }
        }

        if(stack.isEmpty())
            return "/";

        StringBuilder response = new StringBuilder();
        while(!stack.isEmpty()) {
            response.insert(0, "/" + stack.pop());
        }

        return response.toString();
    }
}