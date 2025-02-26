class Solution {
    // Time O(N * M) and Space O(N)
    public int numUniqueEmails(String[] emails) {
          var set = new HashSet<String>();
        for(var email: emails) {
            var emailSplit = email.split("@");
            var localName = emailSplit[0];
            var domainName = emailSplit[1];
            localName = applyRules(localName);
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String applyRules(String localName) {
        return localName
                .replaceAll("\\.", "")
                .split("\\+")[0];
    }
}