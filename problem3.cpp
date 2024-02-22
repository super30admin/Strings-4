#include<iostream>
#include<vector>
#include<string>
#include<queue>

using namespace std;

string get_identifier(string& sentence){
    int i{};
    string identifier{};
    for(;int(sentence.at(i))!=32;++i) identifier+=sentence.at(i);
    return identifier;
}

class Compare{
    public:
    bool operator()(string& below,string& above){

        string below_identifier = get_identifier(below);
        string above_identifier = get_identifier(above);

        size_t below_log_start = below_identifier.length()+1;
        size_t above_log_start = above_identifier.length()+1;
        // 1 is for space

        size_t below_log_len = below.length()- below_log_start; 
        size_t above_log_len = above.length() - above_log_start;

        string below_log = below.substr(below_log_start,below_log_len);
        string above_log = above.substr(above_log_start,above_log_len);

        int log_res = above_log.compare(below_log);
        int identifier_res = above_identifier.compare(below_identifier);

        if(log_res<0){
            return true;
        }
        else if(log_res == 0 && identifier_res<0){
            return true;
        }
        return false;
    }
};

class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        priority_queue<string,vector<string>,Compare> q1{};
        queue<string> q2{};

        for(string &s:logs){
            //find if letter log or digi log from 1st word
            //finding the identifier and first space and first word
            string identifier = get_identifier(s);
            int identifier_length = identifier.length();
            //choosing i+1 cause that will be character ahead of space
            // the loop will break at pos i that stores space
            if(isalpha(s.at(identifier_length+1))){
                q1.push(s);
            }
            else if(isdigit(s.at(identifier_length+1))){
                q2.push(s);
            }
        }
        vector<string> res{};
        while(q1.empty() == false){
            string to_push = q1.top();
            q1.pop();
            res.push_back(to_push);
        }
        while(q2.empty() == false){
            string to_push = q2.front();
            q2.pop();
            res.push_back(to_push);
        }
        return res;
    }
};