class Solution {

    public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s : strs){
                sb.append(s.length());
                sb.append(",");
            }
           
            if(sb.length()>0)
                sb.deleteCharAt(sb.length() - 1);
            sb.append("#");
           
            for(String s : strs){
                sb.append(s);
            }
            return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str == ""){
            return new ArrayList<String>();
        }

        char[] arr = str.toCharArray();
        int indexOfHash = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '#'){
                indexOfHash = i;
                break;
            }
        }
        
        List<String> results = new ArrayList<>();
        String lens = str.substring(0,indexOfHash);
        String values = str.substring(indexOfHash+1);

        System.out.println("Lens :" + lens);
        System.out.println("Values :" + values);
        int tracker = 0;
        String[] splits  =  lens.split(",");

        for(String s : splits){
                if(s == "" || s == null){
                    continue;
                }
                int length = Integer.parseInt(s) ;
                results.add(values.substring(tracker,tracker + length));
                tracker = tracker + length;
        }
        return results;
    }
}
