import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * Given a list paths of directory info, including the directory path
 * and all the files with contents in this directory,
 * return all the duplicate files in the file system in terms of their paths.
 * You may return the answer in any order.
 *
 * A group of duplicate files consists of at least two files that have the same content.
 *
 * Link: https://leetcode.com/problems/find-duplicate-file-in-system/
 *
 * Times: 1
 * Rating: 4
 */


class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentPathMapping = new HashMap<>();
        for (String path : paths) {
            String[] temp = path.split(" "); //First is path, remaining are file names and content
            String filePath = temp[0];

            for (int i = 1; i < temp.length; i++) {
                //Split name from content and insert in map
                String[] nameAndContent = temp[i].split("\\(");
                String content = nameAndContent[1].substring(0, nameAndContent[1].length() - 1);
                // System.out.println(nameAndContent[1]);
                if (!contentPathMapping.containsKey(content)) {
                    contentPathMapping.put(content, new ArrayList<>());
                }
                contentPathMapping.get(content).add(filePath + "/" + nameAndContent[0]);
            }
        }
        List<List<String>> duplicatePaths = new ArrayList<>();
        for (String key : contentPathMapping.keySet()) {
            if (contentPathMapping.get(key).size() > 1) {
                duplicatePaths.add(contentPathMapping.get(key));
            }
        }
        return duplicatePaths;
    }
}
