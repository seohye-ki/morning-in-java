package PhoneBook;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        //set에 추가
        for(String phone_number : phone_book)
            set.add(phone_number);
        
        for(String phone_number : phone_book){
            for(int len = 1; len <= phone_number.length(); len++){
                if(set.contains(phone_number.substring(0, len)) && !phone_number.equals(phone_number.substring(0, len)))
                    return false;
            }
        }
        return true;
    }
}