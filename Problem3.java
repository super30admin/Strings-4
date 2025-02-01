class Problem3 {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,(a,b)->{
            String[] logA = a.split(" ", 2);
            String[] logB = b.split(" ", 2);
            String identifierA = logA[1];
            String identifierB = logB[1];
            char idCharA = identifierA.charAt(0);
            char idCharB = identifierB.charAt(0);

            //if both are digits
            if(Character.isDigit(idCharA) && Character.isDigit(idCharB)){
                return 0; // both have to be considered equal
            }else if(!Character.isDigit(idCharA) && !Character.isDigit(idCharB)){
                //if both the alphanumberic are equal then we sort by logId

                if(logA[1].compareTo(logB[1]) == 0 ){
                    return logA[0].compareTo(logB[0]);
                }
                return logA[1].compareTo(logB[1]);
            }else if(!Character.isDigit(idCharA) && Character.isDigit(idCharB)){
                //negetive like 1-3 ie.. a-b then ascending
                return -1;
            }else{
                // first is digit and second is character
                return 1;
            }

            //if one is a digit
            //if both are alphanumeris
        });
        return logs;
    }


}