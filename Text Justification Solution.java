class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0; //control which words
        while (index < words.length) {
            //首先要知道每个单词的长度
            int count = words[index].length();
            //当年这一行最多能存几个单词,边界
            int last = index + 1;
            //last 肯定小于最后一个单词
            /*
            count = 10  last = 3 diff = 2 space = 3
            sb : "This"
            
            time = O(n)
            Space = O(n)
            */
            while (last < words.length){
                //下一个单词的长度加上之后超过maxwidth 就跳出。+1 是空格，至少会有一个空格
                if (words[last].length() + count + 1 > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            //diff  多余空格的个数 This_is/ This__is/
            int diff = last - index - 1;
            if (last == words.length || diff == 0){
                //sb 里已经把index加进去了，再加入是就是加下一个单词 index + 1;
                for (int i = index + 1 ; i < last; i++){
                    //加上一个空格再加上一个单词
                    builder.append(" ");
                    builder.append(words[i]);
                }
                //加到最后一个单词，对后面用空格填充
                for (int i = builder.length(); i < maxWidth; i++){
                    builder.append(" ");
                } 
            }else {
                    //行内 空格数应该是有几个
                    int spaces = (maxWidth - count) / diff;
                    int r = (maxWidth - count) % diff;
                    for (int i = index + 1; i < last; i++){
                        for (int k = spaces; k > 0; k--){
                            builder.append(" ");
                        }
                        if (r > 0){
                            builder.append(" ");
                            r--;
                        }
                        //count 里有一个 +1  所以这里一定要加一个空格
                        builder.append(" ");
                        builder.append(words[i]);
                    }
                }
                res.add(builder.toString());
               index = last;
            }
            return res;
        }
    
}
