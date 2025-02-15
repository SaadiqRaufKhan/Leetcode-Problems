/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // corner case
        if(head == NULL || head->next == NULL) return head;

        ListNode* prev = new ListNode(0);
        prev->next = head;
        ListNode* curr = head;
        bool flag = false;

        while(curr->next != NULL) {
            if(curr->val == curr->next->val) {
                flag = true;
                ListNode* duplicate = curr->next;
                curr->next = duplicate->next;
                delete duplicate;
            }
            else {
                // this means that the curr node also needs to be deleted
                if(flag) {
                    flag = false;
                    // check if the curr node is head node or note
                    if(curr == head) {
                        head = curr->next;
                        delete curr;
                        curr = head;
                    } 
                    else {
                        prev->next = curr->next;
                        delete curr;
                        curr = prev->next;
                    }
                }
                else {
                    prev = curr;
                    curr = curr->next;
                }
            }
        }
        if(flag) {
            if(curr == head) {
                head = NULL;
                delete curr;
            }
            else {
                prev->next = NULL;
                delete curr;
            }
        }
        return head;
    }
};